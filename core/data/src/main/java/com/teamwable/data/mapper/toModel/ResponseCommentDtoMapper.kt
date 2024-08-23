package com.teamwable.data.mapper.toModel

import com.teamwable.model.Comment
import com.teamwable.network.dto.response.ResponseCommentDto

internal fun ResponseCommentDto.toComment(): Comment =
    Comment(
        this.commentId,
        this.memberId,
        this.memberProfileUrl,
        this.memberNickname,
        this.isGhost,
        this.memberGhost,
        this.isLiked,
        this.commentLikedNumber.toString(),
        this.commentText,
        this.time,
        this.memberFanTeam,
    )