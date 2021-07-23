package com.alvarengadev.multisections.recycler.`interface`

import com.alvarengadev.multisections.domain.Comment

interface SettingsAdapter {
    fun sendLike(isLike: Boolean, isReply: Boolean, id: String)
    fun setRepliesAdapter(messageId: String): ArrayList<Comment>
    fun verifyCountReplies(messageId: String): Int
}