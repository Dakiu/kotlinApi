package com.destinogames.reignapp

import com.google.gson.annotations.SerializedName

class UsersList {

    @SerializedName("results")
    var search: List<wsResponse>? = null
}

class wsResponse(

    val collectionName: String,
    val artistName: String,
    val artworkUrl100: String


)
