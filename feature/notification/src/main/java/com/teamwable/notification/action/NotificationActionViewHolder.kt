package com.teamwable.notification.action

import android.graphics.Color
import android.os.Build
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.StyleSpan
import android.view.View
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.teamwable.model.NotificationActionModel
import com.teamwable.notification.CalculateTime
import com.teamwable.notification.R
import com.teamwable.notification.databinding.ItemNotificationVpBinding
import com.teamwable.ui.extensions.stringOf
import timber.log.Timber

class NotificationActionViewHolder(
    private val binding: ItemNotificationVpBinding,
    private val click: (NotificationActionModel, Int) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {
    @RequiresApi(Build.VERSION_CODES.O)
    fun bind(data: NotificationActionModel) {
        with(binding) {
            val spannableText = when (data.notificationTriggerType) {
                "contentLiked" -> {
                    initProfileBtnClickListener(data)
                    getSpannableStyle(
                        data.triggerMemberNickname,
                        R.string.tv_notification_action_content_liked,
                        data = data
                    )
                }

                "comment" -> {
                    initProfileBtnClickListener(data)
                    getSpannableStyle(
                        data.triggerMemberNickname,
                        R.string.tv_notification_action_feed_comment,
                        data = data
                    )
                }

                "commentLiked" -> {
                    initProfileBtnClickListener(data)
                    getSpannableStyle(
                        data.triggerMemberNickname,
                        R.string.tv_notification_action_comment_liked,
                        data = data
                    )
                }

                "actingContinue" -> getSpannableStyle(
                    data.memberNickname,
                    R.string.tv_notification_action_acting_continue,
                    data = data
                )

                "beGhost" -> getSpannableStyle(
                    data.memberNickname,
                    R.string.tv_notification_action_be_ghost,
                    data = data
                )

                "contentGhost" -> getSpannableStyle(
                    data.memberNickname,
                    R.string.tv_notification_action_content_ghost,
                    data = data
                )

                "commentGhost" -> getSpannableStyle(
                    data.memberNickname,
                    R.string.tv_notification_action_comment_ghost,
                    data = data
                )

                "userBan" -> getSpannableStyle(
                    data.memberNickname,
                    R.string.tv_notification_action_user_ban,
                    36,
                    data = data
                )

                "popularWriter" -> getSpannableStyle(
                    data.memberNickname,
                    R.string.tv_notification_action_popular_writer,
                    data = data
                )

                else -> {
                    Timber.tag("notification_action").e("등록되지 않은 노티가 감지되었습니다 : ${data.notificationTriggerType}")
                    SpannableString("")
                }
            }

            tvNotificationVpContent.text = spannableText
            tvNotificationVpTime.text = CalculateTime(root.context).getCalculateTime(data.time)

            root.setOnClickListener {
                click(data, adapterPosition)
            }
        }
    }

    private fun initProfileBtnClickListener(data: NotificationActionModel) {
        binding.ivNotificationVpProfile.setOnClickListener {
            // Todo : 나중에 추가해야 함
        }
    }

    private fun clickableSpan(data: NotificationActionModel, isNickname: Boolean) = object : ClickableSpan() {
        override fun onClick(view: View) {
            // Todo : 나중에 추가해야 함
        }

        override fun updateDrawState(ds: TextPaint) {
            ds.isUnderlineText = false
            ds.color = Color.parseColor("#FF49494C")
        }
    }

    private fun getSpannableStyle(
        name: String,
        resId: Int,
        endIndex: Int = 0,
        data: NotificationActionModel,
    ): SpannableStringBuilder {
        val spannableText = SpannableStringBuilder(getSpannableText(data, name, resId))

        getClickSpannableStyle(data, spannableText, name, endIndex)
        getBoldSpannableStyle(spannableText, name, endIndex)

        return spannableText
    }

    private fun getClickSpannableStyle(
        data: NotificationActionModel,
        spannableText: SpannableStringBuilder,
        name: String,
        endIndex: Int
    ) {
        when (data.notificationTriggerType) {
            in listOf("contentLiked", "comment", "commentLiked", "popularWriter") -> {
                spannableText.setSpan(
                    clickableSpan(data, true),
                    0,
                    name.length + endIndex + 1,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
                spannableText.setSpan(
                    clickableSpan(data, false),
                    data.triggerMemberNickname.length + endIndex + 2,
                    spannableText.length,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
                binding.tvNotificationVpContent.movementMethod = LinkMovementMethod.getInstance()
            }
        }
    }

    private fun getBoldSpannableStyle(
        spannableText: SpannableStringBuilder,
        name: String,
        endIndex: Int
    ) {
        spannableText.setSpan(
            StyleSpan(com.teamwable.ui.R.font.font_pretendard_semibold),
            0,
            name.length + endIndex + 1,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE,
        )
    }

    private fun getSpannableText(
        data: NotificationActionModel,
        name: String,
        resId: Int
    ): String {
        val text = if (data.notificationTriggerType in listOf("contentLiked", "comment", "commentLiked", "popularWriter", "contentGhost", "commentGhost")) {
            "$name${binding.root.context.getString(resId)}\n: ${getPopularContent(data.notificationText)}"
        } else {
            "$name${binding.root.context.getString(resId)}"
        }
        return text
    }

    private fun getPopularContent(notificationText: String): String {
        return if (notificationText.length > MAX_LEN) {
            notificationText.substring(0, MAX_LEN) + binding.root.context.stringOf(R.string.tv_notification_action_more)
        } else {
            notificationText
        }
    }

    companion object {
        const val MAX_LEN = 15
    }
}