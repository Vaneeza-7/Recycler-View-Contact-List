package com.vaneezaahmad.myrecyclerviewex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ViewContact : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_contact)

        var name = findViewById<TextView>(R.id.name)
        var number = findViewById<TextView>(R.id.number)
        var email = findViewById<TextView>(R.id.email)

        name.text = intent.getStringExtra("name")
        number.text = intent.getStringExtra("number")
        email.text = intent.getStringExtra("email")

        var close = findViewById<Button>(R.id.close)
        close.setOnClickListener {
            finish();
        }

    }
}