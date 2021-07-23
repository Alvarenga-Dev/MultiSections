package com.alvarengadev.multisections.recycler.comment

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alvarengadev.multisections.databinding.ItemBinding
import com.alvarengadev.multisections.domain.Comment
import com.alvarengadev.multisections.recycler.ViewHolderGeneric
import com.alvarengadev.multisections.recycler.`interface`.SettingsAdapter
import com.alvarengadev.multisections.recycler.reply.ReplyAdapter

class CommentAdapter : RecyclerView.Adapter<ViewHolderGeneric>() {

    private lateinit var settingsAdapter: SettingsAdapter
    private var replyAdapter: ReplyAdapter? = null
    private var commentsList = arrayListOf<Comment>()

    @SuppressLint("NotifyDataSetChanged")
    fun setDatasource(commentsList: ArrayList<Comment>) {
        this.commentsList = commentsList
        notifyDataSetChanged()
    }

    fun setSendLikeInterface(settingsAdapter: SettingsAdapter) {
        this.settingsAdapter = settingsAdapter
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderGeneric {
        val binding = ItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ViewHolderGeneric(binding, commentsList, settingsAdapter, false)
    }

    override fun onBindViewHolder(holder: ViewHolderGeneric, position: Int) {
        holder.bind(commentsList[position])
        replyAdapter = ReplyAdapter()
        replyAdapter?.let { replyAdapter ->
            replyAdapter.setSendLikeInterface(settingsAdapter)
            holder.setAdapter(replyAdapter)
        }
    }

    fun notifyUpdateItem(
        id: String,
        isReply: Boolean,
        isLike: Boolean
    ) {
        if (isReply) {
            replyAdapter?.notifyUpdateItem(id, isLike)
        } else {
            val comment = commentsList.first { comment -> comment.id == id }
            comment.isLike = isLike
            notifyItemChanged(commentsList.indexOf(comment))
        }
    }

    fun notifyAddListReplies(id: String) {
        val comment = commentsList.first { comment -> comment.id == id }
        notifyItemChanged(commentsList.indexOf(comment))
    }

    override fun getItemCount(): Int = commentsList.size

}