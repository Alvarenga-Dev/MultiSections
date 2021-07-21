package com.alvarengadev.multisections.utils

import com.alvarengadev.multisections.R
import com.alvarengadev.multisections.domain.Comment

fun setData(): ArrayList<Comment> {

    val comment01 = Comment(
        "Luka Alvarenga",
        "Nice photooo! HAHAH",
        R.drawable.people_10,
        true
    )

    val reply0101 = Comment(
        "Mateus Lenno",
        "Tks my frienddd!",
        R.drawable.people_8,
        true
    )

    val reply0201 = Comment(
        "Maria Joshan",
        "Yessss HAHAH",
        R.drawable.people_6,
        true
    )

    val arrayReplies01 = arrayListOf(reply0101, reply0201)

    comment01.setRepliesList(arrayReplies01)

    val comment02 = Comment(
        "Mariana Caballo",
        "Photograph is perfect",
        R.drawable.people_3,
        true
    )

    val reply0102 = Comment(
        "Mateus Lenno",
        "tkss ❤!",
        R.drawable.people_8,
        true
    )

    val arrayReplies02 = arrayListOf(reply0102)

    comment02.setRepliesList(arrayReplies02)

    val comment03 = Comment(
        "Megan Ford",
        "Beautifuuullll",
        R.drawable.people_10,
        true
    )

    val reply0103 = Comment(
        "Mateus Lenno",
        "is youu!! HAHAHA",
        R.drawable.people_8,
        true
    )

    val reply0203 = Comment(
        "Josuah Beckham",
        "Me? Oh tkss HAHAHAHA",
        R.drawable.people_9,
        true
    )

    val reply0303 = Comment(
        "Mateus Lenno",
        "It's me, Josuah HAHAHAHA",
        R.drawable.people_8,
        true
    )

    val arrayReplies03 = arrayListOf(reply0103, reply0203, reply0303)

    comment03.setRepliesList(arrayReplies03)

    return arrayListOf(comment01, comment02, comment03)
}