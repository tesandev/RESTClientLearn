package com.example.restclientlearn.service

import com.example.restclientlearn.model.Comments
import retrofit2.Call
import retrofit2.http.GET

interface CommentAPI {
    @GET("comments")
    fun getComments() : Call<List<Comments>>
}