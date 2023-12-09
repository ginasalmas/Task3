package com.example.task3

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Cats(
    val name: String,
    val description: String,
    val photo: Int
) : Parcelable
