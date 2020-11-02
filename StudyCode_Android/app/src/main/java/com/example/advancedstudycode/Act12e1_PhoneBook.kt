package com.example.advancedstudycode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView

class Act12e1_PhoneBook : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act12e1_phone_book)

        val phoneBook = createFakePhoneBook(30)
        createPhoneBookList(phoneBook)

    }


    fun createFakePhoneBook(fakeNumber: Int = 10, phoneBook: PhoneBook = PhoneBook()): PhoneBook {
        for (i in 0 until fakeNumber) {
            phoneBook.addPerson(Person(name = "" + i + "번째 사람", number = "" + i + "번째 사람의 전화 번호"))
        }
        return phoneBook
    }


    fun createPhoneBookList(phoneBook: PhoneBook) {
        val layoutInflater = LayoutInflater.from(this@Act12e1_PhoneBook)
        val container = findViewById<LinearLayout>(R.id.phonebook_list_container)
        for (i in 0 until phoneBook.personList.size) {
            val view = layoutInflater.inflate(R.layout.act12e1_phonebook_item, null)
            val personNameView = view.findViewById<TextView>(R.id.person_name)
            personNameView.setText(phoneBook.personList.get(i).name)
            addSetOnClickListener(phoneBook.personList.get(i), view)
            container.addView(view)
        }
    }


    fun addSetOnClickListener(person:Person, view: View) {
        view.setOnClickListener{
            val intent = Intent(this@Act12e1_PhoneBook, Act12e2_PhoneBookDetail::class.java)
            // Key, Value
            intent.putExtra("name", person.name)
            intent.putExtra("number", person.number)
            startActivity(intent)
        }
    }

    class PhoneBook() {
        // 전화 번호부

        val personList = ArrayList<Person>()

        fun addPerson(person: Person) {
            personList.add(person)
        }
    }


    class Person(val name: String, val number: String) {

    }

}


