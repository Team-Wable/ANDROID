package com.teamwable.network.datasource

import com.teamwable.network.dto.response.ResponseCommentDto
import com.teamwable.network.util.BaseResponse
import com.teamwable.network.util.BaseUnitResponse
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CommentService {
    @GET("api/v2/content/{contentId}/comments")
    suspend fun getHomeDetailComments(
        @Path(value = "contentId") contentId: Long,
        @Query(value = "cursor") cursor: Long = -1,
    ): BaseResponse<List<ResponseCommentDto>>

    @GET("api/v2/member/{memberId}/comments")
    suspend fun getProfileComments(
        @Path(value = "memberId") contentId: Long,
        @Query(value = "cursor") cursor: Long = -1,
    ): BaseResponse<List<ResponseCommentDto>>

    @DELETE("api/v1/comment/{commentId}")
    suspend fun deleteComment(
        @Path(value = "commentId") commentId: Long,
    ): BaseUnitResponse<Unit>
}