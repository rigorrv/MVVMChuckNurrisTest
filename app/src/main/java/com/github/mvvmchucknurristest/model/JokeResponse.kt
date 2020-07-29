package com.github.mvvmchucknurristest.model

data class JokeResponse(
    val type: String,
    val value: List<Value>
) {
    data class Value(
        val categories: List<Any>,
        val id: Int,
        val joke: String
    )
}