package com.alvarengadev.multisections

import com.alvarengadev.multisections.domain.Comment
import com.alvarengadev.multisections.utils.getReplies

class FakeRepository {
    fun postLike(sendLike: Boolean): Boolean = sendLike

    fun getListReplies(messageId: String): ArrayList<Comment> = getReplies().filter { messageId == it.parentId } as ArrayList<Comment>

}