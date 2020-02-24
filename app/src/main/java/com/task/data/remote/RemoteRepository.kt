package com.task.data.remote

import com.task.App
import com.task.data.Resource
import com.task.data.error.Error.Companion.NETWORK_ERROR
import com.task.data.error.Error.Companion.NO_INTERNET_CONNECTION
import com.task.data.localdatabase.AppDBHelper

import com.task.data.models.db.Category
import com.task.data.remote.dto.SocialResponse
import com.task.data.remote.service.SocialService
import com.task.utils.Constants
import com.task.utils.Network.Utils.isConnected
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject


/**
 *
 */

class RemoteRepository @Inject
constructor(private val serviceGenerator: ServiceGenerator, private val localRepository: AppDBHelper) : RemoteSource {

    override suspend fun requestSocialcategory(): Resource<SocialResponse> {
        val socialService = serviceGenerator.createService(SocialService::class.java, Constants.BASE_URL)
        return when (val response = processCall(socialService::fetchSocialCategory)) {
            is SocialResponse -> {

                var categoryPresent = localRepository.getAllCategoriesFromDBCount()

                if (categoryPresent == null || categoryPresent?.size == 0) {
                    insertAllDataInDB(response)
                }

                Resource.Success(data = response)
            }
            else -> {
                Resource.DataError(errorCode = response as Int)
            }
        }
    }

    private suspend fun processCall(responseCall: suspend () -> Response<*>): Any? {
        if (!isConnected(App.context)) {
            return NO_INTERNET_CONNECTION
        }
        return try {
            val response = responseCall.invoke()
            val responseCode = response.code()
            if (response.isSuccessful) {
                response.body()
            } else {
                responseCode
            }
        } catch (e: IOException) {
            NETWORK_ERROR
        }
    }

    //
    suspend fun insertAllDataInDB(socialResponse: SocialResponse) {
        var categoryList = ArrayList<Category>()
        var category: Category

        for (categoryResponse in socialResponse.data!!.records) {
            category = Category()
            category.categoryId = categoryResponse.id!!
            category.title = categoryResponse.title!!
            category.mainImageURL = categoryResponse.mainImageURL!!
            category.startDate = categoryResponse.startDate!!
            category.endDate = categoryResponse.endDate!!
            category.shortDescription = categoryResponse.shortDescription!!
            category.collectedValue = categoryResponse.collectedValue
            category.totalValue = categoryResponse.totalValue

            categoryList.add(category)

        }

        insertCategoriesInDB(categoryList)
        // categoryList.clear()


    }

    suspend fun insertCategoryInDB(category: Category) {
        localRepository.insertCategoryInDB(category)
    }

    suspend fun insertCategoriesInDB(categoryList: List<Category>) {
        localRepository.insertCategoriesInDB(categoryList)
    }


}
