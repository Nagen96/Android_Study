package com.example.advancedstudycode

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.advancedstudycode.Act12e1_PhoneBook.*
import kotlinx.android.synthetic.main.activity_act14e1_phone_book_with_recycler_view.*

class Act14e1_PhoneBookWithRecyclerView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act14e1_phone_book_with_recycler_view)



        val phoneBook = createFakePhoneBook(fakeNumber = 30)
        val phoneBookRecyclerAdapter = PhoneBookRecyclerAdapter(
            phonebookList = phoneBook,
            inflater = LayoutInflater.from(this@Act14e1_PhoneBookWithRecyclerView),
            activity = this
        )
        phonebook_recycler_view.adapter = phoneBookRecyclerAdapter
        phonebook_recycler_view.layoutManager =
            LinearLayoutManager(this@Act14e1_PhoneBookWithRecyclerView)



//                with(phonebook_recycler_view) {
//            this.adapter = PhoneBookRecyclerAdapter(
//                phonebookList = createFakePhoneBook(fakeNumber = 30),
//                inflater = LayoutInflater.from(this@Act14e1_PhoneBookWithRecyclerView),
//                activity = this@Act14e1_PhoneBookWithRecyclerView
//            )
//            this.layoutManager = LinearLayoutManager(this@Act14e1_PhoneBookWithRecyclerView)
//        }




    }



    fun createFakePhoneBook(fakeNumber: Int = 10, phoneBook: PhoneBook = PhoneBook()): PhoneBook {
        for (i in 0 until fakeNumber) {
            phoneBook.addPerson(
                Person(name = "" + i + "번째 사람", number = "" + i + "번째 사람의 전화 번호")
            )
        }
        return phoneBook
    }



    class PhoneBookRecyclerAdapter(
        val phonebookList: Act12e1_PhoneBook.PhoneBook,
        val inflater: LayoutInflater,
        val activity: Activity
    ) : RecyclerView.Adapter<PhoneBookRecyclerAdapter.ViewHolder>() {


        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val personName: TextView

            init {
                personName = itemView.findViewById(R.id.person_name)
                itemView.setOnClickListener {
                    val intent = Intent(activity, Act12e2_PhoneBookDetail::class.java)
                    intent.putExtra("name", phonebookList.personList.get(adapterPosition).name)
                    intent.putExtra("number", phonebookList.personList.get(adapterPosition).number)
                    activity.startActivity(intent)
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = inflater.inflate(R.layout.act12e1_phonebook_item, parent, false)
            return ViewHolder(view)
        }

        override fun getItemCount(): Int {
            return phonebookList.personList.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.personName.setText(phonebookList.personList.get(position).name)
        }
    }
}