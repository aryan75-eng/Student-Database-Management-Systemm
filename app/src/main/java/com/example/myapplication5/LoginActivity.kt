package com.example.myapplication5


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class LoginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(
            R.layout.activity_login
        )


        val username =
            findViewById<EditText>(
                R.id.user
            )


        val password =
            findViewById<EditText>(
                R.id.pass
            )


        val login =
            findViewById<Button>(
                R.id.loginButton
            )


        val db =
            DBHelper(this)



        login.setOnClickListener {


            val user =
                username.text.toString()


            val pass =
                password.text.toString()



            val check =
                db.checkLogin(
                    user,
                    pass
                )



            if(check){


                Toast.makeText(
                    this,
                    "Login Successful",
                    Toast.LENGTH_SHORT
                ).show()



                val intent =
                    Intent(
                        this,
                        PageActivity2
                        ::class.java
                    )


                startActivity(intent)


            }

            else{


                Toast.makeText(
                    this,
                    "Invalid Username or Password",
                    Toast.LENGTH_SHORT
                ).show()


            }


        }


    }

}