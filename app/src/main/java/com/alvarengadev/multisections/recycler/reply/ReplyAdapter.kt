package com.alvarengadev.multisections.recycler.reply

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alvarengadev.multisections.databinding.ItemBinding
import com.alvarengadev.multisections.domain.Comment
import com.alvarengadev.multisections.recycler.ViewHolderGeneric
import com.alvarengadev.multisections.recycler.`interface`.SendLikeInterface

class ReplyAdapter : RecyclerView.Adapter<ViewHolderGeneric>() {

    private var sendLikeInterface: SendLikeInterface? = null
    private var repliesList = arrayListOf<Comment>()

    @SuppressLint("NotifyDataSetChanged")
    fun setDatasource(repliesList: ArrayList<Comment>) {
        this.repliesList = repliesList
        notifyDataSetChanged()
    }

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
        val reply = repliesList.firstOrNull { reply -> reply.id == id }
        if (reply != null) {
            reply.isLike = isLike
            notifyItemChanged(repliesList.indexOf(reply))
        }
    }
}