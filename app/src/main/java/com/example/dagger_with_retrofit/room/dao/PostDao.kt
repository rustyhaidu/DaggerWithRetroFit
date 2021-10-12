package com.example.dagger_with_retrofit.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.dagger_with_retrofit.mvvm.model.Post
import com.example.dagger_with_retrofit.mvvm.model.User

@Dao
interface PostDao {
    // insert query
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(post: Post?)

    // delete
    @Delete
    fun delete(post: Post?)

    @Delete
    fun reset(userList: List<User?>?)

    @Update
    fun update(post: Post?)

    @Query("Select * from post")
    fun getPosts(): List<Post?>?
}