package com.alvarengadev.multisections

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import com.alvarengadev.multisections.databinding.ActivityMainBinding
import com.alvarengadev.multisections.recycler.`interface`.SendLikeInterface
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
        val commentAdapter = CommentAdapter(setData())
        commentAdapter.setSendLikeInterface(object : SendLikeInterface {
            override fun sendLike(isLike: Boolean, isReply: Boolean, id: Int) {
                val sendLike = mainViewModel.sendLikeOrOutLike(isLike)
                commentAdapter.notifyUpdateItem(id, isReply, sendLike)
            }
        })
        rcy.adapter = commentAdapter
    }
}