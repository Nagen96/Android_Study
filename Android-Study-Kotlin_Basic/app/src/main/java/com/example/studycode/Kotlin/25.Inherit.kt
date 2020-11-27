package com.example.myapplication.Kotlin


// 겹치는 코드가 두번까지는 OK
// 두번 이상이 넘어가면 리펙토링을 해야 한다

// 25. 상속
// 부모로부터 설명서를 물려받는다!

fun main(args: Array<String>) {
    val superCar100: SuperCar100 = SuperCar100()
    println(superCar100.drive())
//    superCar100.stop()
//
//    val bus100: Bus100 = Bus100()
//    bus100.drive()
}

// 부모 : Car100
// 자식 : SuperCar100, Bus100
open class Car100() { // Kotlin은 기본 상태가 자바의 final과 같으므로 상속을 위해 open 명시 필요
    open fun drive(): String { // Kotlin은 기본 상태가 자바의 final과 같으므로 오버라이딩을 위해 open 명시 필요
        return "달린다"
    }

    fun stop() {

    }
}

class SuperCar100() : Car100() { // SuperCar100 클래스에서 Car100 클래스를 상속
    override fun drive(): String { // Kotlin은 오버라이딩시 명시를 해야 한다.
        val run = super.drive() // super 키워드로 부모의 메소드 호출
        return "빨리 $run"
    }
}

class Bus100() : Car100() {

}

