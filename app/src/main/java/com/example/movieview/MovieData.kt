package com.example.movieview

import java.io.Serializable

data class MovieData(
    val title: String,
    val description: String,
    val starCast: String,
    val releaseDate: String,
    val posterResId: Int
) : Serializable
