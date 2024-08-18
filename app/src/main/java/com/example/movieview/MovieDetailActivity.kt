package com.example.movieview

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MovieDetailActivity : AppCompatActivity() {

    private lateinit var largePosterImageView: ImageView
    private lateinit var titleTextView: TextView
    private lateinit var descriptionTextView: TextView
    private lateinit var starCastTextView: TextView
    private lateinit var releaseDateTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        largePosterImageView = findViewById(R.id.largePosterImageView)
        titleTextView = findViewById(R.id.titleTextView)
        descriptionTextView = findViewById(R.id.descriptionTextView)
        starCastTextView = findViewById(R.id.starCastTextView)
        releaseDateTextView = findViewById(R.id.releaseDateTextView)

        val movieData = intent.getSerializableExtra("movie") as? MovieData

        movieData?.let {
            titleTextView.text = it.title
            descriptionTextView.text = it.description
            starCastTextView.text = "Star Cast: ${it.starCast}"
            releaseDateTextView.text = "Release Date: ${it.releaseDate}"
            largePosterImageView.setImageResource(it.posterResId)
        }
    }
}
