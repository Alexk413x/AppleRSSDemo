package com.alexk413x.mobile.applerssdemo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.alexk413x.mobile.applerssdemo.models.Album
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_album_details.*

class AlbumDetailsActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album_details)

        val album: Album = intent.getParcelableExtra(EXTRA_DATA)

        Glide.with(this)
            .load(album.artworkUrl)
            .placeholder(R.drawable.marbles)
            .centerInside()
            .into(album_details_artwork_view)

        album_details_title_view.text = album.name
        album_details_artist_view.text = album.artistName
        album_details_genre_view.text = album.getGenreNames()
        album_details_release_date_view.text = album.releaseDate
        album_details_copyright_view.text = album.copyright

        album_details_goto_apple_button.setOnClickListener { gotoApple(album.url) }
    }

    private fun gotoApple(urlString: String) {
        val appleIntent: Intent = Uri.parse(urlString).let { albumPage ->
            Intent(Intent.ACTION_VIEW, albumPage)
        }
        startActivity(appleIntent)
    }
}