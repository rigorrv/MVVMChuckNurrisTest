package com.github.mvvmchucknurristest

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.MediaController
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.mvvmchucknurristest.model.JokeResponse
import com.github.mvvmchucknurristest.view.JokesAdapter
import com.github.mvvmchucknurristest.viewmodel.JokeViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //this can be called from a fragment


        val viewModel: JokeViewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return JokeViewModel() as T
            }
        }).get(JokeViewModel::class.java)


        viewModel.getData().observe(this, object : Observer<JokeResponse> {
            override fun onChanged(t: JokeResponse?) {
                t?.let {
                    val adapter = JokesAdapter(t)
                    adapter.list = t.value
                    Log.d("TAG", "onChanged: ${t.value}")
                    val layoutManager = LinearLayoutManager(this@MainActivity)
                    recycler.layoutManager = layoutManager
                    recycler.adapter = adapter
                    logoVideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.chuck));
                    logoVideo.start();
                }
            }
        })
        viewModel.getMeJokes()

    }


}