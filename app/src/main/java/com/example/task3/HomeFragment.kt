package com.example.task3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        rvCats = view.findViewById(R.id.rv_cats)
        rvCats.setHasFixedSize(true)
        list.addAll(getListCats())
        showRecyclerList()

        return view
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
