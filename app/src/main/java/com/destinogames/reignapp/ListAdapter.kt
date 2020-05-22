package com.destinogames.reignapp

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ListAdapter (private val mContacts: List<wsResponse>?): RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    inner class ViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView) {
        val artistname = itemView.findViewById<TextView>(R.id.artistTextView)
        val albumname = itemView.findViewById<TextView>(R.id.albumtextView)
        val imageAlbum = itemView.findViewById<ImageView>(R.id.albumImageView)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val wsResponseView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return ViewHolder(wsResponseView)
    }

    override fun onBindViewHolder(viewHolder: ListAdapter.ViewHolder, position: Int) {
        val artista: wsResponse = mContacts!![position]
        val artisttextView = viewHolder.artistname
        val albumtextView = viewHolder.albumname
        val imageAlbum = viewHolder.imageAlbum

        Picasso.get().load(artista.artworkUrl100).into(imageAlbum)
        artisttextView.setText(artista.artistName)
        albumtextView.setText(artista.collectionName)
    }

    override fun getItemCount(): Int=mContacts!!.size


}