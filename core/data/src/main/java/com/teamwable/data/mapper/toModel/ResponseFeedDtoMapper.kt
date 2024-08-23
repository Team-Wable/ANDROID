package com.teamwable.data.mapper.toModel

import com.teamwable.model.Feed
import com.teamwable.network.dto.response.ResponseFeedDto

internal fun ResponseFeedDto.toFeed(): Feed =
    Feed(
        this.memberId,
        this.memberProfileUrl,
        this.memberNickname,
        this.contentId,
        this.contentTitle,
        this.contentText,
        this.time,
        this.isGhost,
        this.memberGhost,
        this.isLiked,
        this.likedNumber.toString(),
        this.commentNumber.toString(),
        this.contentImageUrl,
        this.memberFanTeam,
    )