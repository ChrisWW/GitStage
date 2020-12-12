package com.example.gitstage.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Singleton


object RetrofitClientInstance {

    private var retrofit: Retrofit? = null;
    private val Base_URL = "https://api.github.com/"

    val retrofitInstance: Retrofit?
        get(){
            // Has this object been created yet?
            if (retrofit == null){

                // create
                retrofit = retrofit2.Retrofit.Builder()
                        .baseUrl(Base_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            }
            return retrofit
        }

}