package com.elmaravilla.roomdatabaseexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.UserManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.room.Room

class MainActivity : AppCompatActivity() {
    lateinit var usernameBox:EditText
    lateinit var passwordBox:EditText
    lateinit var submitBtn:Button
    lateinit var TextViewDB:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Instantiation a database
        val db = UserDatabase.getInstance(this)
        usernameBox = findViewById(R.id.edit_user)
        passwordBox = findViewById(R.id.edit_password)
        submitBtn = findViewById(R.id.submit_btn)
        TextViewDB = findViewById(R.id.textView)
        submitBtn.setOnClickListener {
            //Insert new data to the database
            db!!.userDao().insert(User(usernameBox.text.toString() , passwordBox.text.toString()))
            //Get all usernames and show it in the TextView
            for (i in db.userDao().getAll()){
                TextViewDB.append(i.username + " ")
            }

        }


    }
}