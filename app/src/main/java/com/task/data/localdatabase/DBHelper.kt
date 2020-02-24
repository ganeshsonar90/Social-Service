package com.task.data.localdatabase

import androidx.lifecycle.LiveData
import com.task.data.models.db.Category


interface DBHelper {

    suspend fun insertCategoriesInDB(categoryList: List<Category>): Unit

    suspend fun insertCategoryInDB(category: Category): Unit


    fun getAllCategoriesFromDB(): LiveData<List<Category>>

    fun getAllCategoriesFromDBCount(): List<Category>


}