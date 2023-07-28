package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class HomeActivity : AppCompatActivity() {

    lateinit var mobile_no: TextView
    lateinit var email: TextView
    lateinit var Last_name: TextView
    lateinit var First_name: TextView
    lateinit var token: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        mobile_no=findViewById(R.id.mobile_no)
        email=findViewById(R.id.email)
        Last_name=findViewById(R.id.Last_name)
        First_name=findViewById(R.id.First_name)
        token=findViewById(R.id.token)

        val FirstName = intent.getStringExtra("Firstname")
        val LastNmae = intent.getStringExtra("lastname")
        val PhoneNo = intent.getStringExtra("phone")
        val Token = intent.getStringExtra("token")
        val Email = intent.getStringExtra("email")



        First_name.text = FirstName
        Last_name.text = LastNmae
        mobile_no.text = PhoneNo
        email.text = Email
        token.text = Token
    }
}