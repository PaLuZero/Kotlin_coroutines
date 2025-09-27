package com.example.kotlin_coroutines

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val postViewModel: PostViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Observar LiveData de posts
        postViewModel.posts.observe(this) { posts ->
            posts.forEach { post ->
                Log.d("POST", "${post.id}: ${post.title}")
            }
        }

        // Llamada a la API
        postViewModel.fetchPosts()
    }
}