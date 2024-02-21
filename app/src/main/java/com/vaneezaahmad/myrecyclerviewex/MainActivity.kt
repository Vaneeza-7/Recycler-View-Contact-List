package com.vaneezaahmad.myrecyclerviewex

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val is mutable
        val list = ArrayList<Model>()
        list.add(Model("Ali", "031233311", "ali@gmail.com"))
        list.add(Model("Ahmed", "0311234", "ahmed@gmail.com"))
        list.add(Model("Asad", "03135346", "asad@gmail.com"))
        list.add(Model("Nofil", "032233311", "nofil@gmail.com"))
        list.add(Model("Ali", "031233311", "ali@gmail.com"))
        list.add(Model("Ahmed", "0311234", "ahmed@gmail.com"))
        list.add(Model("Asad", "03135346", "asad@gmail.com"))
        list.add(Model("Nofil", "032233311", "nofil@gmail.com"))
        list.add(Model("Ali", "031233311", "ali@gmail.com"))
        list.add(Model("Ahmed", "0311234", "ahmed@gmail.com"))
        list.add(Model("Asad", "03135346", "asad@gmail.com"))
        list.add(Model("Nofil", "032233311", "nofil@gmail.com"))
        list.add(Model("Ali", "031233311", "ali@gmail.com"))
        list.add(Model("Ahmed", "0311234", "ahmed@gmail.com"))
        list.add(Model("Asad", "03135346", "asad@gmail.com"))
        list.add(Model("Nofil", "032233311", "nofil@gmail.com"))
        list.add(Model("Ali", "031233311", "ali@gmail.com"))
        list.add(Model("Ahmed", "0311234", "ahmed@gmail.com"))
        list.add(Model("Asad", "03135346", "asad@gmail.com"))
        list.add(Model("Nofil", "032233311", "nofil@gmail.com"))

        val adapter = MyAdaptor(list,this)
        val rv = findViewById<RecyclerView>(R.id.rv)
        rv. layoutManager = LinearLayoutManager(this)
        rv.adapter=adapter

        var add = findViewById<Button>(R.id.add)
        var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        {
            if(it.resultCode == Activity.RESULT_OK){
                val data: Intent? = it.data
                val name = data?.getStringExtra("name")
                val number = data?.getStringExtra("number")
                val email = data?.getStringExtra("email")
                list.add(Model(name.toString(), number.toString(),email.toString()))
                adapter.notifyDataSetChanged()
            }

        }


        add.setOnClickListener {
            resultLauncher.launch(Intent(this, NewContact::class.java))
        }
    }


}