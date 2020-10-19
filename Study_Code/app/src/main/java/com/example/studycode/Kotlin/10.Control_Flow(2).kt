package com.example.myapplication.Kotlin


// 10 제어흐름

// When

fun main(args: Array<String>) {

    val value: Int = 1

    // Java의 switch문과 비슷
    when (value) {
        1 -> println("value is 1") // value값이 1일 때 실행
        2 -> println("value is 2") // value값이 2일 때 실행
        3 -> println("value is 3") // value값이 3일 때 실행
        else -> println("I do not know value") // 위의 값이 모두 아닐 때 실행
    }

    // 위의 when문을 if문으로 표현
    if (value == 1) println("value is 1")
    else if (value == 2) println("value is 2")
    else if (value == 3) println("value is 3")
    else println("I do not know value")

    val value2 = when (value) {
        1 -> 10
        2 -> 20
        3 -> 30
        else -> 100
    }
    println(value2)


}
