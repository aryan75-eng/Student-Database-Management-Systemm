package com.example.myapplication5

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.Toast
import android.app.AlertDialog
import android.view.LayoutInflater
import android.widget.TextView

class Page_2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_page2)

        val backButton = findViewById<Button>(R.id.btnBack)

        val db = DBHelper(this)

        val name = findViewById<EditText>(R.id.etName)
        val email = findViewById<EditText>(R.id.etEmail)
        val uid = findViewById<EditText>(R.id.etUID)
        val submit = findViewById<Button>(R.id.btnSubmit)
        val view = findViewById<Button>(R.id.btnView)
        val update = findViewById<Button>(R.id.btnUpdate)
        val delete = findViewById<Button>(R.id.btnDelete)

        backButton.setOnClickListener {
            finish()
        }

        submit.setOnClickListener {
            val sName = name.text.toString()
            val sEmail = email.text.toString()
            val sUID = uid.text.toString()

            val result = db.insertData(
                sUID.toInt(),
                sName,
                sEmail
            )

            if (result) {
                Toast.makeText(this, "Data Saved Successfully", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Data Not Saved", Toast.LENGTH_SHORT).show()
            }

        }

        view.setOnClickListener {
            val result = db.getAllData()

            if (result.count == 0) {
                Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            update.setOnClickListener {

                val sName = name.text.toString()
                val sEmail = email.text.toString()
                val sUID = uid.text.toString()

                val result = db.updateData(
                    sUID.toInt(),
                    sName,
                    sEmail
                )

                if (result) {
                    Toast.makeText(
                        this,
                        "Data Updated Successfully",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        this,
                        "Data Not Updated",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            delete.setOnClickListener {

                val sUID = uid.text.toString()

                val result = db.deleteData(
                    sUID.toInt()
                )

                if (result) {
                    Toast.makeText(
                        this,
                        "Data Deleted Successfully",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        this,
                        "Data Not Deleted",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            val buffer = StringBuffer()

            while (result.moveToNext()) {

                buffer.append("UID : ${result.getString(0)}\n")
                buffer.append("Name : ${result.getString(1)}\n")
                buffer.append("Email : ${result.getString(2)}\n\n")
            }

            val dialogView = LayoutInflater.from(this)
                .inflate(R.layout.dialog_student_records, null)


            val txtRecords =
                dialogView.findViewById<TextView>(R.id.txtRecords)

            txtRecords.text = buffer.toString()

            val dialog = AlertDialog.Builder(this)
                .setView(dialogView)
                .create()

            val close =
                dialogView.findViewById<Button>(R.id.btnClose)

            close.setOnClickListener {
                dialog.dismiss()
            }
            dialog.show()
        }
    }
}
