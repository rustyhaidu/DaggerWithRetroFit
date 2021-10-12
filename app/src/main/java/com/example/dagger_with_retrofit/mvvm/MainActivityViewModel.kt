package com.example.dagger_with_retrofit.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dagger_with_retrofit.mvvm.model.Post
import com.example.dagger_with_retrofit.mvvm.model.User
import com.example.dagger_with_retrofit.retrofit.PostsNetwork
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {

    val myResponse: MutableLiveData<Post> = MutableLiveData()
    val postList: MutableLiveData<List<Post>> = MutableLiveData()
    val userList: MutableLiveData<List<User>> = MutableLiveData()

    fun getPost() {
        viewModelScope.launch {
            myResponse.value = PostsNetwork.RETROFIT.getPost()
        }
    }

    fun getPosts() {
        viewModelScope.launch {
            postList.value = PostsNetwork.RETROFIT.getPosts()
        }
    }

    fun getUsers() {
        viewModelScope.launch {
            userList.value = PostsNetwork.RETROFIT.getUsers()
        }
    }
}