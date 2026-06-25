package com.example.myapplication5

import com.google.firebase.FirebaseApp
import com.google.firebase.database.FirebaseDatabase
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class Registration_Pagee : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        FirebaseApp.initializeApp(this)

        setContentView(
            R.layout.activity_registration_pagee
        )


        val username =
            findViewById<EditText>(
                R.id.userName
            )


        val email =
            findViewById<EditText>(
                R.id.email
            )


        val password =
            findViewById<EditText>(
                R.id.password
            )


        val submit =
            findViewById<Button>(
                R.id.submit
            )


        // Login Button
        val loginPage =
            findViewById<Button>(
                R.id.loginButton
            )






        submit.setOnClickListener {

            val user =
                username.text.toString()

            val mail =
                email.text.toString()

            val pass =
                password.text.toString()


            val database =
                FirebaseDatabase.getInstance(
                    "https://my-application5-2b641-default-rtdb.firebaseio.com/"
                )

            val reference =
                database.getReference("Users")


            val userData =
                mapOf(
                    "username" to user,
                    "email" to mail,
                    "password" to pass
                )


            reference.child(user)
                .setValue(userData)
                .addOnSuccessListener {

                    Toast.makeText(
                        this,
                        "Registration Successful",
                        Toast.LENGTH_SHORT
                    ).show()

                }
                .addOnFailureListener {

                    Toast.makeText(
                        this,
                        "Registration Failed",
                        Toast.LENGTH_SHORT
                    ).show()

                }

        }



        loginPage.setOnClickListener {


            val intent =
                Intent(
                    this,
                    LoginActivity::class.java
                )


            startActivity(intent)

        }


    }

}