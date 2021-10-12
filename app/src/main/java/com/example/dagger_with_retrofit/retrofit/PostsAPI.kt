package com.example.dagger_with_retrofit.retrofit

import com.example.dagger_with_retrofit.mvvm.model.Post
import com.example.dagger_with_retrofit.mvvm.model.User
import retrofit2.http.GET

interface PostsAPI {

    @GET("posts/1")
    suspend fun getPost(): Post

    @GET("posts")
    suspend fun getPosts(): List<Post>

    @GET("users")
    suspend fun getUsers(): List<User>
}