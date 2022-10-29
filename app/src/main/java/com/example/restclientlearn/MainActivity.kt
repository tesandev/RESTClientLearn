package com.example.restclientlearn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.restclientlearn.adapter.AdapterMain
import com.example.restclientlearn.model.Comments
import com.example.restclientlearn.service.CommentAPI
import com.example.restclientlearn.util.Retro
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        rvComments.setHasFixedSize(true)
        rvComments.layoutManager = LinearLayoutManager(this)

        GetCommentAPI()
    }

    fun GetCommentAPI() {
        val retro = Retro().getRetroClientInstanse().create(CommentAPI::class.java)
        retro.getComments().enqueue(object : Callback<List<Comments>>{
            override fun onResponse(
                call: Call<List<Comments>>,
                response: Response<List<Comments>>
            ) {
                val comment = response.body()
                val adapter = AdapterMain(Results = comment as ArrayList<Comments>)
                rvComments.adapter = adapter
            }

            override fun onFailure(call: Call<List<Comments>>, t: Throwable) {
                Log.e("Failed", t.message.toString())
            }

        })
    }
}