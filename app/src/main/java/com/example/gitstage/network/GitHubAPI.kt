package com.example.gitstage.network

import com.example.gitstage.RepositoryResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface GitHubAPI {


    @GET("repositories")
    fun fetchRepo() : Call<ArrayList<RepositoryResponseItem>>
}