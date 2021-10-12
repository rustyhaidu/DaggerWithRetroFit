package com.example.dagger_with_retrofit.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.dagger_with_retrofit.mvvm.model.User

@Dao
interface UserDao {
    // insert query
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User?)

    // delete
    @Delete
    fun delete(user: User?)

    @Delete
    fun reset(userList: List<User?>?)

    @Update
    fun update(user: User?)

    @Query("Select * from user")
    fun getUsers(): List<User?>?
}