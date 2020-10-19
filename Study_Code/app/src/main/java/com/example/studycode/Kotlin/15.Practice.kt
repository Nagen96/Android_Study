package com.example.myapplication.Kotlin


fun main(array: Array<String>) {


    val a = mutableListOf<Int>(1, 2, 3)
    a.add(4)
    println(a)
    a.add(0, 100) // 기존 원소들을 오른쪽으로 민다.
    println(a)
    a.set(0, 200) // 해당 인덱스의 값을 변경한다.
    println(a)
    a.removeAt(1) // 해당 인덱스의 값을 제거한다.
    println(a)


    val b = mutableSetOf<Int>(1, 2, 3, 4)
    println()
    b.add(2)
    println(b)
    b.remove(2)
    println(b)
    b.remove(100) // 에러가 발생하지 않는다.
    println(b)


    val c = mutableMapOf<String, Int>("one" to 1)
    println()
    c.put("two", 2)
    println(c)
    c.replace("two", 3) // two라는 키와 매핑된 value를 변경
    println(c)
    println(c.keys) // key만 출력
    println(c.values) // value만 출력
    c.clear() // 초기화
    println(c)


}