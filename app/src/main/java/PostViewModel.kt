package com.example.kotlin_coroutines

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import android.util.Log

class PostViewModel : ViewModel() {

    private val _posts = MutableLiveData<List<Post>>()
    val posts: LiveData<List<Post>> = _posts

    fun fetchPosts() {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.api.getPosts()
                _posts.value = response
            } catch (e: Exception) {
                Log.e("API_ERROR", e.toString())
            }
        }
    }
}