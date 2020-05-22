package com.destinogames.reignapp


import android.app.PendingIntent.getActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.act


class MainActivity : AppCompatActivity() {
    val BASE_URL = "https://itunes.apple.com/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            getMusica(searchView.text.toString())
        }

        val rvContacts = findViewById<View>(R.id.rvContacts) as RecyclerView
        rvContacts.layoutManager = LinearLayoutManager(this)

    }

    fun getMusica(nameArtist: String){
        var retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var api = retrofit.create(APIService::class.java)
        var call = api.getByName(nameArtist,"music",20)

        call.enqueue(object : Callback<UsersList> {

        override fun onResponse(call: Call<UsersList>, response: Response<UsersList>) {

            if (response.isSuccessful()){
                rvContacts.adapter = ListAdapter(response.body()!!.search)
            }
        }
        override fun onFailure(call: Call<UsersList>, t: Throwable) {
            Log.d("caused by",""+t.stackTrace)
        }
        })

    }

}
