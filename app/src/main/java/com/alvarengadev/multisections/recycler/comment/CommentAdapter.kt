package com.alvarengadev.multisections.recycler.comment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alvarengadev.multisections.databinding.ItemBinding
import com.alvarengadev.multisections.domain.Comment
import com.alvarengadev.multisections.recycler.ViewHolderGeneric
import com.alvarengadev.multisections.recycler.`interface`.SendLikeInterface
import com.alvarengadev.multisections.recycler.reply.ReplyAdapter

class CommentAdapter(
    private val commentsList: ArrayList<Comment>
) : RecyclerView.Adapter<ViewHolderGeneric>() {

    private lateinit var sendLikeInterface: SendLikeInterface
    private var replyAdapter: ReplyAdapter? = null

    fun setSendLikeInterface(sendLikeInterface: SendLikeInterface) {
        this.sendLikeInterface = sendLikeInterface
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderGeneric {
        val binding = ItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ViewHolderGeneric(binding, commentsList, sendLikeInterface, true)
    }

    override fun onBindViewHolder(holder: ViewHolderGeneric, position: Int) {
        holder.bind(commentsList[position])

        val replies = commentsList[position].getRepliesList()

        replyAdapter = replies?.let { ReplyAdapter(it) }
        replyAdapter?.let {
            it.setSendLikeInterface(sendLikeInterface)
            holder.setAdapter(it)
        }
    }

    fun notifyUpdateItem(
        id: Int,
        isLike: Boolean,
        isReply: Boolean
    ) {
        if (isReply) {
            replyAdapter?.notifyUpdateItem(id, isLike)
        } else {
            val comment = commentsList.first { comment -> comment.id == id }
            comment.isLike = isLike
            notifyItemChanged(commentsList.indexOf(comment))
        }
    }

    override fun getItemCount(): Int = commentsList.size

}