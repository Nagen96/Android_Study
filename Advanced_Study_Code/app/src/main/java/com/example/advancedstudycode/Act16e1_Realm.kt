package com.example.advancedstudycode

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import io.realm.Realm
import io.realm.RealmConfiguration
import kotlinx.android.synthetic.main.activity_act16e1_realm.*

class Act16e1_Realm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act16e1_realm)

        // Realm 준비
        Realm.init(this@Act16e1_Realm)
        val config: RealmConfiguration =
            RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build()
        Realm.setDefaultConfiguration(config)
        val realm = Realm.getDefaultInstance()

        // Realm에 데이터 저장
        button_save.setOnClickListener {
            realm.executeTransaction {
                // A테이블에서 데이터를 가져온다.
                // B테이블에서 데이터를 가져온다.
                // C테이블에서 데이터를 가져온다.
                // 조합을 한다.
                // D테이블에 저장을 한다.
                // 이 일련의 과정이 수행될 동안 테이블들을 Lock 시킨다.
                // 즉, Transaction은 작업 단위이다.

//                with(it.createObject(School::class.java)) {
//                    this.name = "어떤 대학교"
//                    this.location = "서울"
//                }
                // with를 안 썼을 때 (위의 with문과 동일한 결과)
                it.createObject(School::class.java).name = "어떤 대학교"
                it.createObject(School::class.java).location = "서울"
            }
        }

        // Realm에서 데이터 불러오기
        button_load.setOnClickListener {
            // Realm에서 데이터에 접근할 때는 항상 executeTransaction{}을 이용
            realm.executeTransaction {
                val data = it.where(School::class.java).findFirst()
                // findFirst()는 테이블 한 줄을 가져온다.
                Log.d("realm data", "data : " + data)
            }
        }

        // Realm에서 데이터 삭제
        button_delete.setOnClickListener {
            realm.executeTransaction {
                it.where(School::class.java).findAll().deleteAllFromRealm()
            }
        }
    }
}