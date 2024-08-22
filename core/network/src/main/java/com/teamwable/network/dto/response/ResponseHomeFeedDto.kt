package com.teamwable.network.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseHomeFeedDto(
    @SerialName("memberId") val memberId: Long,
    @SerialName("memberProfileUrl") val memberProfileUrl: String,
    @SerialName("memberNickname") val memberNickname: String,
    @SerialName("contentId") val contentId: Long,
    @SerialName("contentTitle") val contentTitle: String,
    @SerialName("contentText") val contentText: String,
    @SerialName("time") val time: String,
    @SerialName("isGhost") val isGhost: Boolean,
    @SerialName("memberGhost") val memberGhost: Int,
    @SerialName("isLiked") val isLiked: Boolean,
    @SerialName("likedNumber") val likedNumber: Int,
    @SerialName("commentNumber") val commentNumber: Int,
    @SerialName("isDeleted") val isDeleted: Boolean,
    @SerialName("contentImageUrl") val contentImageUrl: String,
    @SerialName("memberFanTeam") val memberFanTeam: String,
)