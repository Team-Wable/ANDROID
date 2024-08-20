package com.teamwable.ui.shareAdapter

import com.teamwable.model.Feed

interface FeedClickListener {
    fun onItemClick(feed: Feed)

    fun onGhostBtnClick(postAuthorId: Long)

    fun onLikeBtnClick(id: Long)

    fun onPostAuthorProfileClick(id: Long)

    fun onFeedImageClick(image: String)

    fun onKebabBtnClick(feedId: Long, postAuthorId: Long)

    fun onCommentBtnClick(feedId: Long)
}