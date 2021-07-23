package com.alvarengadev.multisections.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.alvarengadev.multisections.R
import com.alvarengadev.multisections.databinding.ItemBinding
import com.alvarengadev.multisections.domain.Comment
import com.alvarengadev.multisections.recycler.`interface`.SettingsAdapter
import com.alvarengadev.multisections.recycler.reply.ReplyAdapter
import com.alvarengadev.multisections.utils.extensions.hide
import com.alvarengadev.multisections.utils.extensions.text
import com.alvarengadev.multisections.utils.extensions.visible

open class ViewHolderGeneric(
    private val binding: ItemBinding,
    private val commentsOrRepliesList: ArrayList<Comment>,
    private val settingsAdapter: SettingsAdapter?,
    private val isReply: Boolean
) : RecyclerView.ViewHolder(
    binding.root
){
    init {
        setIsRecyclable(true)

        binding.ibLike.apply {
            setOnClickListener {
                val positionRcy = absoluteAdapterPosition
                if (positionRcy != RecyclerView.NO_POSITION) {
                    val commentOrReply = commentsOrRepliesList[positionRcy]

                    if (!commentOrReply.isLike) {
                        setImageResource(R.drawable.ic_ios_heart_empty)
                        settingsAdapter?.sendLike(true, isReply, commentOrReply.id)
                    } else {
                        setImageResource(R.drawable.ic_ios_heart)
                        settingsAdapter?.sendLike(false, isReply, commentOrReply.id)
                    }
                }
            }
        }
    }

    fun bind(comment: Comment) = binding.apply {
        with(comment) {
            tvNameUser.text(userName)
            tvComment.text(userComment)
            ivProfile.setImageResource(resPhotoProfile)

            ibLike.setImageResource(
                if (comment.isLike)
                    R.drawable.ic_ios_heart
                else
                    R.drawable.ic_ios_heart_empty
            )
        }
    }

    fun setAdapter(replyAdapter: ReplyAdapter) = binding.apply {
        val positionRcy = absoluteAdapterPosition
        if (positionRcy != RecyclerView.NO_POSITION) {
            val commentOrReply = commentsOrRepliesList[positionRcy]
            val verifyListCount = settingsAdapter?.verifyCountReplies(commentOrReply.id)

            if (verifyListCount != null && verifyListCount > 0) {
                btnReplies.visible()
                btnReplies.setOnClickListener {
                    val listReplies = settingsAdapter?.setRepliesAdapter(commentOrReply.id)

                    rcyReply.adapter = replyAdapter
                    listReplies?.let { replyAdapter.setDatasource(it) }

                    if (rcyReply.visibility == View.GONE) {
                        rcyReply.visible()
                    } else {
                        rcyReply.hide()
                    }
                }
            }
        }
    }
}