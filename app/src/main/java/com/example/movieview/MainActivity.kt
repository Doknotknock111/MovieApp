package com.example.movieview

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var horizontalRecyclerView: RecyclerView
    private lateinit var verticalRecyclerView: RecyclerView
    private lateinit var horizontalRecyclerView2: RecyclerView
    private lateinit var horizontalAdapter: MovieListAdapter
    private lateinit var verticalAdapter: MovieListAdapter


    private val horizontalMovieData = listOf(
        MovieData(
            title = "The Shawshank Redemption",
            description = "A Maine banker convicted of the murder of his wife and her lover in 1947 gradually forms a friendship over a quarter century with a hardened convict, while maintaining his innocence and trying to remain hopeful through simple compassion.",
            starCast = "Tim Robbins, Morgan Freeman",
            releaseDate = "1994-05-10",
            posterResId = R.drawable.theshawshankredemption
        ),
        MovieData(
            title = "Space Odyssey",
            description = "A sci-fi epic about the journey of astronauts exploring a distant galaxy and encountering unknown civilizations.",
            starCast = "Chris Evans, Scarlett Johansson, Tom Hardy",
            releaseDate = "2023-12-20",
            posterResId = R.drawable.spaceodyssey
        ),
        MovieData(
            title = "Kives Out",
            description = "A thrilling mystery set in a haunted mansion where a detective uncovers dark secrets.",
            starCast = "Daniel Craig, Judi Dench",
            releaseDate = "2024-01-05",
            posterResId = R.drawable.knivesout
        ),
        MovieData(
            title = "Cooking with Love",
            description = "A light-hearted comedy about a chef who finds love while cooking in a small town.",
            starCast = "Anna Kendrick, Ryan Reynolds",
            releaseDate = "2024-03-22",
            posterResId = R.drawable.img_3
        ),
        MovieData(
            title = "Love in Paris",
            description = "A romantic drama about two people who meet and fall in love in the beautiful city of Paris.",
            starCast = "Emily Clark, Michael Lee",
            releaseDate = "2023-08-15",
            posterResId = R.drawable.img_2
        )
    )

    private val verticalMovieData = listOf(
        MovieData(
            title = "Cooking with Love",
            description = "A light-hearted comedy about a chef who finds love while cooking in a small town.",
            starCast = "Anna Kendrick, Ryan Reynolds",
            releaseDate = "2024-03-22",
            posterResId = R.drawable.img_3
        ),
        MovieData(
            title = "Mystery Manor",
            description = "A thrilling mystery set in a haunted mansion where a detective uncovers dark secrets.",
            starCast = "Daniel Craig, Judi Dench",
            releaseDate = "2024-01-05",
            posterResId = R.drawable.knivesout
        ),
        MovieData(
            title = "The Shawshank Redemption",
            description = "A Maine banker convicted of the murder of his wife and her lover in 1947 gradually forms a friendship over a quarter century with a hardened convict, while maintaining his innocence and trying to remain hopeful through simple compassion.",
            starCast = "Tim Robbins, Morgan Freeman",
            releaseDate = "1994-05-10",
            posterResId = R.drawable.theshawshankredemption
        ),
        MovieData(
            title = "Space Odyssey",
            description = "A sci-fi epic about the journey of astronauts exploring a distant galaxy and encountering unknown civilizations.",
            starCast = "Chris Evans, Scarlett Johansson, Tom Hardy",
            releaseDate = "2023-12-20",
            posterResId = R.drawable.spaceodyssey
        ),
        MovieData(
            title = "Cooking with Love",
            description = "A light-hearted comedy about a chef who finds love while cooking in a small town.",
            starCast = "Anna Kendrick, Ryan Reynolds",
            releaseDate = "2024-03-22",
            posterResId = R.drawable.img_3
        ),
        MovieData(
            title = "Mystery Manor",
            description = "A thrilling mystery set in a haunted mansion where a detective uncovers dark secrets.",
            starCast = "Daniel Craig, Judi Dench",
            releaseDate = "2024-01-05",
            posterResId = R.drawable.knivesout
        ),
        MovieData(
            title = "The Shawshank Redemption",
            description = "A Maine banker convicted of the murder of his wife and her lover in 1947 gradually forms a friendship over a quarter century with a hardened convict, while maintaining his innocence and trying to remain hopeful through simple compassion.",
            starCast = "Tim Robbins, Morgan Freeman",
            releaseDate = "1994-05-10",
            posterResId = R.drawable.theshawshankredemption
        ),
        MovieData(
            title = "Space Odyssey",
            description = "A sci-fi epic about the journey of astronauts exploring a distant galaxy and encountering unknown civilizations.",
            starCast = "Chris Evans, Scarlett Johansson, Tom Hardy",
            releaseDate = "2023-12-20",
            posterResId = R.drawable.spaceodyssey
        )
    )

    private val horizontalMovies2s = listOf(
        MovieData(
            title = "Space Odyssey",
            description = "A sci-fi epic about the journey of astronauts exploring a distant galaxy and encountering unknown civilizations.",
            starCast = "Chris Evans, Scarlett Johansson, Tom Hardy",
            releaseDate = "2023-12-20",
            posterResId = R.drawable.spaceodyssey
        ),
        MovieData(
            title = "The Shawshank Redemption",
            description = "A Maine banker convicted of the murder of his wife and her lover in 1947 gradually forms a friendship over a quarter century with a hardened convict, while maintaining his innocence and trying to remain hopeful through simple compassion.",
            starCast = "Tim Robbins, Morgan Freeman",
            releaseDate = "1994-05-10",
            posterResId = R.drawable.theshawshankredemption
        ),
        MovieData(
            title = "Cooking with Love",
            description = "A light-hearted comedy about a chef who finds love while cooking in a small town.",
            starCast = "Anna Kendrick, Ryan Reynolds",
            releaseDate = "2024-03-22",
            posterResId = R.drawable.img_3
        ),
        MovieData(
            title = "Mystery Manor",
            description = "A thrilling mystery set in a haunted mansion where a detective uncovers dark secrets.",
            starCast = "Daniel Craig, Judi Dench",
            releaseDate = "2024-01-05",
            posterResId = R.drawable.knivesout
        ),
        MovieData(
            title = "Love in Paris",
            description = "A romantic drama about two people who meet and fall in love in the beautiful city of Paris.",
            starCast = "Emily Clark, Michael Lee",
            releaseDate = "2023-08-15",
            posterResId = R.drawable.img_2
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        horizontalRecyclerView = findViewById(R.id.horizontalRecyclerView)
        verticalRecyclerView = findViewById(R.id.verticalRecyclerView)
        horizontalRecyclerView2 = findViewById(R.id.horizontalRecyclerView2)

        horizontalAdapter = MovieListAdapter(horizontalMovieData) { movie ->
            val intent = Intent(this, MovieDetailActivity::class.java)
            intent.putExtra("movie", movie)
            startActivity(intent)
        }

        verticalAdapter = MovieListAdapter(verticalMovieData) { movie ->
            val intent = Intent(this, MovieDetailActivity::class.java)
            intent.putExtra("movie", movie)
            startActivity(intent)
        }

        horizontalRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        horizontalRecyclerView.adapter = horizontalAdapter

        verticalRecyclerView.layoutManager = LinearLayoutManager(this)
        verticalRecyclerView.adapter = verticalAdapter

        horizontalRecyclerView2.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        horizontalRecyclerView2.adapter = horizontalAdapter
    }
}
