package com.task.data.localdatabase


import androidx.room.Database
import androidx.room.RoomDatabase
import com.task.data.localdatabase.db.CategoryBaseDAO
import com.task.data.models.db.Category

/**
 *
 */
@Database(entities = arrayOf(Category::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun categoryDao(): CategoryBaseDAO


}