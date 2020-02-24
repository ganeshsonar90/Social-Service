package com.task.data

import androidx.lifecycle.LiveData
import com.task.data.models.db.Category
import com.task.data.remote.dto.SocialResponse

/**
 *
 */

interface DataSource {
    suspend fun requestCategories(): Resource<SocialResponse>
    fun requestCatgoryFromDataBase(): LiveData<List<Category>>


}
