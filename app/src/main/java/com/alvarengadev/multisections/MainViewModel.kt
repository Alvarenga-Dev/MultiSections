package com.alvarengadev.multisections

class MainViewModel {
    private val fakeRepository = FakeRepository()

    fun sendLikeOrOutLike(sendLike: Boolean): Boolean = fakeRepository.postLike(sendLike)

}