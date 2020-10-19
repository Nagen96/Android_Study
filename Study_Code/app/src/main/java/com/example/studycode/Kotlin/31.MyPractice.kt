package com.example.myapplication.Kotlin

fun main(args: Array<String>) {
    val mSet = mutableSetOf<Int>()
    while (mSet.size < 6) {
        val rnd = (0..10).random()
        mSet.add(rnd)
    }
    mSet.sorted().forEach() {
        println(it)
    }
}