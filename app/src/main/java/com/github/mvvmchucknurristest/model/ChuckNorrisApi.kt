package com.github.mvvmchucknurristest.model

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Path

interface ChuckNorrisApi {

    //http://api.icndb.com/jokes/random/3
    @GET("jokes/random/{size}")
    fun getMeJokes(@Path("size") numberofJokes : Int) : Call<JokeResponse>

    companion object{
        fun intRetrofit () : ChuckNorrisApi{
            return Retrofit.Builder()
                .baseUrl("http://api.icndb.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ChuckNorrisApi::class.java)
        }
    }
}