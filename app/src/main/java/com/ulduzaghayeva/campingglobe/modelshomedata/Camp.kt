package com.ulduzaghayeva.campingglobe.modelshomedata

import android.os.Parcel
import android.os.Parcelable


data class Camp(
    val name: String,
    val price: Int,
    val currency: String,
    val date: String,
    val imageView: Int,
)