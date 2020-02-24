package com.task.data.localdatabase

import androidx.lifecycle.LiveData
import com.task.data.models.db.Category
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class AppDBHelper : DBHelper {

    val appDatabase: AppDatabase

    @Inject
    constructor(database: AppDatabase) {
        this.appDatabase = database
    }

    override suspend fun insertCategoriesInDB(categoryList: List<Category>) {
        appDatabase.categoryDao().insertAllCategories(categoryList)
    }

    override suspend fun insertCategoryInDB(category: Category) {
        appDatabase.categoryDao().insertCategory(category)
    }

    override fun getAllCategoriesFromDB(): LiveData<List<Category>> {
        return (appDatabase.categoryDao().getAllCategories())
    }

    override fun getAllCategoriesFromDBCount(): List<Category> {
        return (appDatabase.categoryDao().getAllCategoriesCount())
    }


}