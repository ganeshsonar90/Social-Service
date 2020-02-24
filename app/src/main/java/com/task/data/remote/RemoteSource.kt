package com.task.data.remote

import com.task.data.Resource
import com.task.data.remote.dto.SocialResponse

/**
 *
 */

internal interface RemoteSource {
    suspend fun requestSocialcategory(): Resource<SocialResponse>
}
