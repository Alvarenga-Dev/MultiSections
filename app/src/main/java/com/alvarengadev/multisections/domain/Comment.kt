package com.alvarengadev.multisections.domain

data class Comment(
    val id: Int,
    val userName: String,
    val userComment: String,
    val resPhotoProfile: Int,
    var isLike: Boolean,
    private var repliesList: ArrayList<Comment>? = null
) {
    fun setRepliesList(repliesList: ArrayList<Comment>) {
        this.repliesList = repliesList
    }

    fun getRepliesList() = this.repliesList
}