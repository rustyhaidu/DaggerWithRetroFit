package com.example.dagger_with_retrofit.retrofit

import javax.inject.Inject

class Repo @Inject constructor() {

    suspend fun getPosts() = PostsNetwork.RETROFIT.getPosts()
}