package com.alexk413x.mobile.applerssdemo.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Genre(
    var id: Int,
    var name: String,
    var url: String
) : Parcelable