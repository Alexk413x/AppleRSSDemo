package com.alexk413x.mobile.applerssdemo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.alexk413x.mobile.applerssdemo.adapters.AlbumAdapter
import com.alexk413x.mobile.applerssdemo.api.ApiUrl
import com.alexk413x.mobile.applerssdemo.models.Album
import com.alexk413x.mobile.applerssdemo.models.Genre
import kotlinx.android.synthetic.main.activity_album_list.*
import org.json.JSONObject
import java.net.URL

class AlbumListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album_list)

        album_list_view.layoutManager = LinearLayoutManager(this)
        val clickListener = { album: Album -> albumSelected(album)}
        album_list_view.adapter = AlbumAdapter(ArrayList(), clickListener)

        refreshAlbumList()
    }

    private fun refreshAlbumList() = Thread {
        loading_spinner.visibility = View.VISIBLE

        val feedUrl = ApiUrl.appleApiUrl + ApiUrl.appleApiVersion + ApiUrl.countryUS + ApiUrl.mediaType + ApiUrl.feedType + ApiUrl.genre + ApiUrl.resultsLimit + ApiUrl.allowExplicit + ApiUrl.dataFormat
        val results = URL(feedUrl).readText()
        val resultsJson = JSONObject(results)
        val feedJson = resultsJson.getJSONObject("feed")
        val albumsJsonArray = feedJson.getJSONArray("results")

        val albumList = ArrayList<Album>()

        for(i in 0 until albumsJsonArray.length()) {
            val albumJson = albumsJsonArray.getJSONObject(i)

            val genreJsonArray = albumJson.getJSONArray("genres")
            val genreList = ArrayList<Genre>()
            for( j in 0 until genreJsonArray.length()){
                val genreJson = genreJsonArray.getJSONObject(j)
                val genre = Genre(
                    genreJson.getInt("genreId"),
                    genreJson.getString("name"),
                    genreJson.getString("url")
                )
                genreList.add(genre)
            }

            var contentRating = ""
            if(albumJson.has("contentAdvisoryRating")){
                contentRating = albumJson.getString("contentAdvisoryRating")
            }

            val album = Album(
                albumJson.getInt("id"),
                albumJson.getString("name"),
                albumJson.getString("releaseDate"),
                albumJson.getInt("artistId"),
                albumJson.getString("artistName"),
                albumJson.getString("artistUrl"),
                albumJson.getString("kind"),
                albumJson.getString("copyright"),
                contentRating,
                albumJson.getString("artworkUrl100"),
                albumJson.getString("url"),
                genreList
            )
            albumList.add(album)
        }

        runOnUiThread {
            albumsReturned(albumList)
        }
    }.start()

    private fun albumSelected(album: Album){
        val intent = Intent(this, AlbumDetailsActivity::class.java)
        intent.putExtra(AlbumDetailsActivity.EXTRA_DATA, album)
        startActivity(intent)
    }

    private fun albumsReturned(albumList: ArrayList<Album>){
        loading_spinner.visibility = View.GONE
        (album_list_view.adapter as AlbumAdapter).updateAlbums(albumList)
    }
}
