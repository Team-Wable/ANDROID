package com.teamwable.network.datasource

import com.teamwable.network.dto.response.ResponseFeedDto
import com.teamwable.network.util.BaseResponse
import com.teamwable.network.util.BaseUnitResponse
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FeedService {
    @GET("api/v2/contents")
    suspend fun getHomeFeeds(
        @Query(value = "cursor") contentId: Long = -1,
    ): BaseResponse<List<ResponseFeedDto>>

    @GET("api/v2/member/{memberId}/contents")
    suspend fun getProfileFeeds(
        @Path("memberId") userId: Long,
        @Query(value = "cursor") contentId: Long = -1,
    ): BaseResponse<List<ResponseFeedDto>>

    @DELETE("api/v1/content/{contentId}")
    suspend fun deleteFeed(
        @Path(value = "contentId") contentId: Long,
    ): BaseUnitResponse<Unit>

    @GET("api/v2/content/{contentId}")
    suspend fun getHomeDetail(
        @Path(value = "contentId") contentId: Long,
    ): BaseResponse<ResponseFeedDto>
}
