package com.task.data.remote.service

import com.task.data.remote.dto.SocialResponse
import retrofit2.Response
import retrofit2.http.GET

/**
 */

interface SocialService {
    @GET("/testdata.json")
    suspend fun fetchSocialCategory(): Response<SocialResponse>
}
