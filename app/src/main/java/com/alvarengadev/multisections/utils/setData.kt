package com.alvarengadev.multisections.utils

import com.alvarengadev.multisections.R
import com.alvarengadev.multisections.domain.Comment

fun setData(): ArrayList<Comment> {

    val comment01 = Comment(
        1,
        "Luka Alvarenga",
        "Nice photooo! HAHAH",
        R.drawable.people_10,
        true
    )

    val reply0101 = Comment(
        2,
        "Mateus Lenno",
        "Tks my frienddd!",
        R.drawable.people_8,
        true
    )

    val reply0201 = Comment(
        3,
        "Megan Ford",
        "Yessss HAHAH",
        R.drawable.people_6,
        true
    )

    val arrayReplies01 = arrayListOf(reply0101, reply0201)

    comment01.setRepliesList(arrayReplies01)

    val comment02 = Comment(
        4,
        "Mariana Caballo",
        "Photograph is perfect",
        R.drawable.people_3,
        false
    )

    val reply0102 = Comment(
        5,
        "Mateus Lenno",
        "tkss ❤!",
        R.drawable.people_8,
        false
    )

    val arrayReplies02 = arrayListOf(reply0102)

    comment02.setRepliesList(arrayReplies02)

    val comment03 = Comment(
        6,
        "Megan Ford",
        "Beautifuuullll",
        R.drawable.people_6,
        false
    )

    val reply0103 = Comment(
        7,
        "Mateus Lenno",
        "is youu!! HAHAHA",
        R.drawable.people_8,
        false
    )

    val reply0203 = Comment(
        8,
        "Josuah Beckham",
        "Me? Oh tkss HAHAHAHA",
        R.drawable.people_9,
        false
    )

    val reply0303 = Comment(
        9,
        "Mateus Lenno",
        "It's me, Josuah HAHAHAHA",
        R.drawable.people_8,
        false
    )

    val comment04 = Comment(
        10,
        "John Ford",
        "Niceeee",
        R.drawable.people_1,
        false
    )

    val arrayReplies03 = arrayListOf(reply0103, reply0203, reply0303)

    comment03.setRepliesList(arrayReplies03)

    return arrayListOf(comment01, comment02, comment03, comment04)
}