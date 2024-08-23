package com.teamwable.data.repository

import androidx.paging.PagingData
import com.teamwable.model.Feed
import kotlinx.coroutines.flow.Flow

interface FeedRepository {
    fun getHomeFeeds(): Flow<PagingData<Feed>>

    fun getProfileFeeds(userId: Long): Flow<PagingData<Feed>>

    suspend fun deleteFeed(feedId: Long): Result<Boolean>
}