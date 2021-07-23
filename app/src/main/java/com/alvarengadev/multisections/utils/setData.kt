package com.alvarengadev.multisections.utils

import com.alvarengadev.multisections.R
import com.alvarengadev.multisections.domain.Comment

fun setData(): ArrayList<Comment> {

    val comment01 = Comment(
        "01",
        null,
        "Luka Alvarenga",
        "Nice photooo! HAHAH",
        R.drawable.people_10,
        true
    )

    val comment02 = Comment(
        "02",
        null,
        "Mariana Caballo",
        "Photograph is perfect",
        R.drawable.people_3,
        false
    )

    val comment03 = Comment(
        "03",
        null,
        "Megan Ford",
        "Beautifuuullll",
        R.drawable.people_6,
        false
    )

    val comment04 = Comment(
        "04",
        null,
        "John Ford",
        "Niceeee",
        R.drawable.people_1,
        false
    )

    return arrayListOf(comment01, comment02, comment03, comment04)
}

fun getReplies(): ArrayList<Comment>  {
    val reply0101 = Comment(
        "01_01",
        "01",
        "Mateus Lenno",
        "Tks my frienddd!",
        R.drawable.people_8,
        true
    )

    val reply0102 = Comment(
        "01_02",
        "01",
        "Megan Ford",
        "Yessss HAHAH",
        R.drawable.people_6,
        true
    )

    val reply0201 = Comment(
        "02_01",
        "02",
        "Mateus Lenno",
        "tkss ❤!",
        R.drawable.people_8,
        false
    )

    val reply0301 = Comment(
        "03_01",
        "03",
        "Mateus Lenno",
        "is youu!! HAHAHA",
        R.drawable.people_8,
        false
    )

    val reply0302 = Comment(
        "03_02",
        "03",
        "Josuah Beckham",
        "Me? Oh tkss HAHAHAHA",
        R.drawable.people_9,
        false
    )

    val reply0303 = Comment(
        "03_03",
        "03",
        "Mateus Lenno",
        "It's me, Josuah HAHAHAHA",
        R.drawable.people_8,
        false
    )

    return arrayListOf(
        reply0101,
        reply0102,
        reply0201,
        reply0301,
        reply0302,
        reply0303
    )
}