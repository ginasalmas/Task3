package com.example.task3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.*
import androidx.appcompat.app.AppCompatActivity  // Add this import statement
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {
    private lateinit var rvCats: RecyclerView
    private val list = ArrayList<Cats>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val toolbar: androidx.appcompat.widget.Toolbar = view.findViewById(R.id.toolbar)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        setHasOptionsMenu(true)

        rvCats = view.findViewById(R.id.rv_cats)
        rvCats.setHasFixedSize(true)
        list.addAll(getListCats())
        showRecyclerList()

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_search, menu)
        val searchItem = menu.findItem(R.id.action_search)
        val searchView = searchItem.actionView as SearchView

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun getListCats(): ArrayList<Cats> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listCats = ArrayList<Cats>()
        for (i in dataName.indices) {
            val cat = Cats(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listCats.add(cat)
        }
        return listCats
    }

    private fun showRecyclerList() {
        rvCats.layoutManager = LinearLayoutManager(activity)
        val listCatsAdapter = ListCatsAdapter(list)
        rvCats.adapter = listCatsAdapter
    }
}
