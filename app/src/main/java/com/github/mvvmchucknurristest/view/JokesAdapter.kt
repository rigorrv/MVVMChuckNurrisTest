package com.github.mvvmchucknurristest.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.mvvmchucknurristest.R
import com.github.mvvmchucknurristest.model.JokeResponse
import kotlinx.android.synthetic.main.item_layout_jokes.view.*

class JokesAdapter(t: JokeResponse) : RecyclerView.Adapter<JokesAdapter.ViewHolder>() {


    var list: List<JokeResponse.Value> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_jokes, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.onBind(list[position])
    }

    class ViewHolder(view : View): RecyclerView.ViewHolder(view){
        val TAG : String = "TAG"
        val joke = itemView.jokeInfo
        val id = itemView.id
        val display = itemView.displayImage

        var myImageList = intArrayOf(R.drawable.img_0001, R.drawable.img_0002,R.drawable.img_0003,R.drawable.img_0004,R.drawable.img_0005,R.drawable.img_0006,R.drawable.img_0007,R.drawable.img_0008,R.drawable.img_0009)

        fun onBind(list : JokeResponse.Value){
            joke.text = list.joke
            var randomImg = (0..8).random()
            display.setBackgroundResource(myImageList[randomImg])


            itemView.setOnClickListener {
                Log.d(TAG, "onBind: you click in joke number $id")
            }
        }
    }

}