package com.alvarengadev.multisections.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.alvarengadev.multisections.R
import com.alvarengadev.multisections.databinding.ItemBinding
import com.alvarengadev.multisections.domain.Comment
import com.alvarengadev.multisections.recycler.`interface`.SendLikeInterface
import com.alvarengadev.multisections.recycler.reply.ReplyAdapter
import com.alvarengadev.multisections.utils.extensions.hide
import com.alvarengadev.multisections.utils.extensions.text
import com.alvarengadev.multisections.utils.extensions.visible

open class ViewHolderGeneric(
    private val binding: ItemBinding,
    commentsOrRepliesList: ArrayList<Comment>,
    private val sendLikeInterface: SendLikeInterface?,
    private val isReply: Boolean
) : RecyclerView.ViewHolder(
    binding.root
){
    init {
        setIsRecyclable(false)

        binding.ibLike.apply {
            setOnClickListener {
                val positionRcy = bindingAdapterPosition
                if (positionRcy != RecyclerView.NO_POSITION) {
                    val commentOrReply = commentsOrRepliesList[positionRcy]

                    if (!commentOrReply.isLike) {
                        setImageResource(R.drawable.ic_ios_heart_empty)
                        sendLikeInterface?.sendLike(true, isReply, commentOrReply.id)
                    } else {
                        setImageResource(R.drawable.ic_ios_heart)
                        sendLikeInterface?.sendLike(false, isReply, commentOrReply.id)
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

            if (comment.getRepliesList()?.isNotEmpty() == true) {
                btnReplies.visible()
                btnReplies.setOnClickListener {
                    if (rcyReply.visibility == View.GONE) {
                        rcyReply.visible()
                    } else {
                        rcyReply.hide()
                    }
                }
            }
        }
    }

    fun setAdapter(replyAdapter: ReplyAdapter) = binding.apply {
        rcyReply.adapter = replyAdapter
    }
}