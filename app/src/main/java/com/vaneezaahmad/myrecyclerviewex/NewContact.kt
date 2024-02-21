package com.vaneezaahmad.myrecyclerviewex

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class NewContact : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_contact)

        var name = findViewById<EditText>(R.id.name)
        var number = findViewById<EditText>(R.id.number)
        var email = findViewById<EditText>(R.id.email)
        var save = findViewById<Button>(R.id.save)

        save.setOnClickListener {
            var intent = intent;
            intent.putExtra("name", name.text.toString())
            intent.putExtra("number", number.text.toString())
            intent.putExtra("email", email.text.toString())
            //complete activity and go back to main activity
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}