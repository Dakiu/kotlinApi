package com.destinogames.reignapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

public interface APIService {

    @GET("search?")
    fun getByName(@Query("term") id: String,@Query("mediaType") media:String,@Query("limit") limit: Int):Call<UsersList>

}