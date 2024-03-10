package com.vaneezaahmad.myrecyclerviewex

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.SearchView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity(){
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val is mutable
        val list = ArrayList<Model>()
        list.add(Model("Ali", "031233311", "ali@gmail.com"))
        list.add(Model("Zain", "031233311", "zain@gmail.com"))
        list.add(Model("Ahmed", "031233311", "ahmed@gmail.com"))
        list.add(Model("Bilal", "031233311", "bilal@gmail.com"))
        list.add(Model("Zubair", "031233311", "zubair@gmail.com"))
        list.add(Model("Ali", "031233311", "ali@gmail.com"))
        list.add(Model("Zain", "031233311", "zain@gmail.com"))
        list.add(Model("Ahmed", "031233311", "ahmed@gmail.com"))
        list.add(Model("Bilal", "031233311", "bilal@gmail.com"))
        list.add(Model("Zubair", "031233311", "zubair@gmail.com"))
        list.add(Model("Ali", "031233311", "ali@gmail.com"))
        list.add(Model("Zain", "031233311", "zain@gmail.com"))
        list.add(Model("Ahmed", "031233311", "ahmed@gmail.com"))
        list.add(Model("Bilal", "031233311", "bilal@gmail.com"))
        list.add(Model("Zubair", "031233311", "zubair@gmail.com"))


        val sortedList = list.sortedBy { it.name }
        val adapter = MyAdaptor(ArrayList(sortedList),this)
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
                //sort the list again
                val sortedList = list.sortedBy { it.name }
                adapter.updateList(ArrayList(sortedList))
                //adapter.list = ArrayList(sortedList)
                //adapter.notifyDataSetChanged()
            }

        }

        val searchView = findViewById<SearchView>(R.id.search_view)

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val filteredModelList: ArrayList<Model> = ArrayList()

                if (newText != null) {
                    for (model in list) {
                        if (model.name.lowercase().contains(newText.lowercase())) {
                            filteredModelList.add(model)
                        }
                    }
                }

                adapter.filterList(filteredModelList)
                return true
            }
        })

        add.setOnClickListener {
            resultLauncher.launch(Intent(this, NewContact::class.java))

        }
    }


}