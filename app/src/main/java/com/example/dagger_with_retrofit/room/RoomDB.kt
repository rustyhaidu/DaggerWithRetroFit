package com.example.dagger_with_retrofit.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.dagger_with_retrofit.mvvm.model.Post
import com.example.dagger_with_retrofit.mvvm.model.User
import com.example.dagger_with_retrofit.room.dao.PostDao
import com.example.dagger_with_retrofit.room.dao.UserDao

@Database(entities = [User::class, Post::class], version = 3, exportSchema = false)
abstract class RoomDB : RoomDatabase() {
    // Create Dao
    abstract fun userDao(): UserDao?
    abstract fun postDao(): PostDao?

    companion object {
        // Create database instance
        private var database: RoomDB? = null

        // Define database name
        private const val DATABASE_NAME = "todos"
        @Synchronized
        fun getInstance(context: Context): RoomDB? {
            // check if database is null
            if (database == null) {
                // When database is null we initialize it
                database = Room.databaseBuilder(
                    context.applicationContext, RoomDB::class.java, DATABASE_NAME
                )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return database
        }
    }
}