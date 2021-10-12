package com.example.dagger_with_retrofit.mvvm

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dagger_with_retrofit.R
import com.example.dagger_with_retrofit.adaptors.PostRecyclerAdaptor
import com.example.dagger_with_retrofit.dagger.DaggerMainComponent
import com.example.dagger_with_retrofit.mvvm.model.Post
import com.example.dagger_with_retrofit.mvvm.model.User
import com.example.dagger_with_retrofit.retrofit.Repo
import com.example.dagger_with_retrofit.room.RoomDB
import com.example.dagger_with_retrofit.room.dao.PostDao
import com.example.dagger_with_retrofit.room.dao.UserDao
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private var database: RoomDB? = null
    private var postDao: PostDao? = null
    private var userDao: UserDao? = null
    private lateinit var viewModel: MainActivityViewModel
    private var postRecyclerView: RecyclerView? = null

    @Inject
    lateinit var repo: Repo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = RoomDB.getInstance(applicationContext)
        postDao = database?.postDao()
        userDao = database?.userDao()

        postRecyclerView = findViewById(R.id.listaIntrebariGrila)
        postRecyclerView?.layoutManager = LinearLayoutManager(this)

        val posts = getPosts()
        val examGrilaAdaptor = PostRecyclerAdaptor(posts)
        postRecyclerView?.adapter = examGrilaAdaptor

        DaggerMainComponent.create().inject(this)

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getPosts()
        viewModel.getUsers()

       /* getUsers()
        showUsers()*/
        //showPosts()

    }

    fun showPost() {
        viewModel.myResponse.observe(this) {
            Log.d(TAG, it.body)
            Log.d(TAG, it.title)
            Log.d(TAG, it.id.toString())
            Log.d(TAG, it.userId.toString())
        }
    }

    private fun showPosts() {
        viewModel.postList.observe(this, Observer {
            for (post in it) {
                Log.d(TAG, post.body)
                Log.d(TAG, post.title)
                Log.d(TAG, post.id.toString())
                Log.d(TAG, post.userId.toString())

                //insertPost(post)
            }
        })
    }

    private fun showUsers() {
        viewModel.userList.observe(this, Observer {
            for (user in it) {
                Log.d(TAG, user.name)
                Log.d(TAG, user.email)
                Log.d(TAG, user.id.toString())
                Log.d(TAG, user.phone)

                //insertUser(user)
            }
        })
    }

    private fun insertPost(post: Post) {
        postDao?.insert(post)
    }

    private fun insertUser(user: User) {
        userDao?.insert(user)
    }

    private fun getPosts(): List<Post?>? {
        val postList = postDao?.getPosts()
        if (postList != null) {
            for (post in postList) {
                if (post != null) {
                    Log.d("Room$TAG", post.body)
                    Log.d("Room$TAG", post.title)
                    Log.d("Room$TAG", post.id.toString())
                    Log.d("Room$TAG", post.userId.toString())
                }
            }
        }
        return postList
    }

    private fun getUsers() {
        val userList = userDao?.getUsers()
        if (userList != null) {
            for (post in userList) {
                if (post != null) {
                    Log.d("Room$TAG", post.name)
                    Log.d("Room$TAG", post.username)
                    Log.d("Room$TAG", post.id.toString())
                    Log.d("Room$TAG", post.email)
                }
            }
        }
    }

    private companion object {
        const val TAG = "MainActivity"
    }
}