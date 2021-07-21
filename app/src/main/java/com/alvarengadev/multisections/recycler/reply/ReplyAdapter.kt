package com.alvarengadev.multisections.recycler.reply

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alvarengadev.multisections.databinding.ItemBinding
import com.alvarengadev.multisections.domain.Comment
import com.alvarengadev.multisections.recycler.ViewHolderGeneric
import com.alvarengadev.multisections.recycler.`interface`.SendLikeInterface

class ReplyAdapter(
    private val repliesList: ArrayList<Comment>
) : RecyclerView.Adapter<ViewHolderGeneric>() {

    private var sendLikeInterface: SendLikeInterface? = null

    fun setSendLikeInterface(sendLikeInterface: SendLikeInterface) {
        this.sendLikeInterface = sendLikeInterface
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderGeneric {
        val binding = ItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolderGeneric(binding, repliesList, sendLikeInterface, true)
    }

    override fun onBindViewHolder(holder: ViewHolderGeneric, position: Int) {
        holder.bind(repliesList[position])
    }

    override fun getItemCount(): Int = repliesList.size

    fun notifyUpdateItem(
        id: Int,
        isLike: Boolean
    ) {
        val reply = repliesList.first { reply -> reply.id == id }
        reply.isLike = isLike
        notifyItemChanged(repliesList.indexOf(reply))
    }
}