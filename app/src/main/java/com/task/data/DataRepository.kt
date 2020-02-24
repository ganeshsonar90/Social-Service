package com.task.data


import androidx.lifecycle.LiveData
import com.task.data.localdatabase.AppDBHelper
import com.task.data.models.db.Category
import com.task.data.remote.RemoteRepository
import com.task.data.remote.dto.SocialResponse
import javax.inject.Inject


class DataRepository @Inject
constructor(private val remoteRepository: RemoteRepository, private val localRepository: AppDBHelper) : DataSource {

    override suspend fun requestCategories(): Resource<SocialResponse> {
        return remoteRepository.requestSocialcategory()
    }

    override fun requestCatgoryFromDataBase(): LiveData<List<Category>> {
        return localRepository.getAllCategoriesFromDB()
    }


}
