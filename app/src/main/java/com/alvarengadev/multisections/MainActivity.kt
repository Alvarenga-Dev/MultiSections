package com.alvarengadev.multisections

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alvarengadev.multisections.databinding.ActivityMainBinding
import com.alvarengadev.multisections.domain.Comment
import com.alvarengadev.multisections.recycler.`interface`.SettingsAdapter
import com.alvarengadev.multisections.recycler.comment.CommentAdapter
import com.alvarengadev.multisections.utils.setData

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val thisActivity = this@MainActivity
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel = MainViewModel()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initList()
    }

    private fun initList() = binding.apply {
        val commentAdapter = CommentAdapter()
        commentAdapter.setDatasource(setData())
        commentAdapter.setSendLikeInterface(object : SettingsAdapter {
            override fun sendLike(isLike: Boolean, isReply: Boolean, id: String) {
                val sendLike = mainViewModel.sendLikeOrOutLike(isLike)
                commentAdapter.notifyUpdateItem(id, isReply, sendLike)
            }

            override fun setRepliesAdapter(messageId: String): ArrayList<Comment> {
                //commentAdapter.notifyAddListReplies(messageId)
                return mainViewModel.getRepliesList(messageId)
            }

            override fun verifyCountReplies(messageId: String): Int {
                return mainViewModel.getRepliesList(messageId).size
            }
        })
        rcy.adapter = commentAdapter
    }
}