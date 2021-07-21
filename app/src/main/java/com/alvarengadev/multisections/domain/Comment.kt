package com.alvarengadev.multisections.domain

data class Comment(
    private val userName: String,
    private val comment: String,
    private val resPhotoProfile: Int,
    private val isLike: Boolean,
    private var repliesList: ArrayList<Comment>? = null,
) {
    fun setRepliesList(repliesList: ArrayList<Comment>) {
        this.repliesList = repliesList
    }
}