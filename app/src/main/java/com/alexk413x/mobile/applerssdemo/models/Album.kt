package com.alexk413x.mobile.applerssdemo.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlin.collections.ArrayList

@Parcelize
data class Album (
    var id: Int,
    var name: String,
    var releaseDate: String,
    var artistId: Int,
    var artistName: String,
    var artistUrl: String,
    var kind: String,
    var copyright: String,
    var contentAdvisoryRating: String,
    var artworkUrl: String,
    var url: String,
    var genres: ArrayList<Genre>
) : Parcelable {

    fun getGenreNames(): String{
        var genreNames = ""
        genres.forEachIndexed { i, genre ->
            val genreName = genre.name

            if(genreName != "Music") {
                if (i != 0) {
                    genreNames += " | "
                }
                genreNames += genre.name
            }
        }
        return genreNames
    }
}