package com.alvarengadev.multisections

import com.alvarengadev.multisections.domain.Comment

class MainViewModel {
    private val fakeRepository = FakeRepository()

    fun sendLikeOrOutLike(sendLike: Boolean): Boolean = fakeRepository.postLike(sendLike)

    fun getRepliesList(messageId: String): ArrayList<Comment> = fakeRepository.getListReplies(messageId)

}