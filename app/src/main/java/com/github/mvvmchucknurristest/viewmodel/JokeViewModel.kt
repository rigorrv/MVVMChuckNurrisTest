package com.github.mvvmchucknurristest.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.mvvmchucknurristest.model.ChuckNorrisApi
import com.github.mvvmchucknurristest.model.JokeResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JokeViewModel : ViewModel() {
    val TAG : String = "TAG"
    val dataSet : MutableLiveData<JokeResponse> = MutableLiveData()

    fun getData() : LiveData<JokeResponse>{
        return dataSet
    }

    fun getMeJokes(){
        ChuckNorrisApi.intRetrofit().getMeJokes(15)
            .enqueue(object : Callback<JokeResponse>{
                override fun onFailure(call: Call<JokeResponse>, t: Throwable) {
                    Log.e(TAG,  t.message ?: "N/A")
                }

                override fun onResponse(
                    call: Call<JokeResponse>,
                    response: Response<JokeResponse>
                ) {
                    if (response.isSuccessful)
                        dataSet.value = response.body()
                    Log.d(TAG, "onResponse: ${response.body()}")


                }
            })
    }
}
