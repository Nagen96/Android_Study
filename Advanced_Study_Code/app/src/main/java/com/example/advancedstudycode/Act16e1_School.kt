package com.example.advancedstudycode

import io.realm.RealmObject

open class School: RealmObject() {
    // Realm에서 쓸 Table 생성
    var name: String? = null
    var location: String? = null
}