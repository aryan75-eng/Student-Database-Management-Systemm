package com.example.myapplication5


import android.app.AlertDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class PageActivity2 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(
            R.layout.activity_page2
        )


        val db =
            DBHelper(this)


        val view =
            findViewById<Button>(
                R.id.btnView
            )


        val update =
            findViewById<Button>(
                R.id.btnUpdate
            )


        val delete =
            findViewById<Button>(
                R.id.btnDelete
            )
        val back =
            findViewById<Button>(
                R.id.btnBack
            )


        back.setOnClickListener {

            finish()

        }



        // View Data


        view.setOnClickListener {


            val result =
                db.getAllData()


            if(result.count == 0){

                Toast.makeText(
                    this,
                    "No Data Found",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener

            }



            val buffer =
                StringBuffer()



            while(result.moveToNext()){


                buffer.append(
                    "ID : ${result.getString(0)}\n"
                )

                buffer.append(
                    "Username : ${result.getString(1)}\n"
                )

                buffer.append(
                    "Email : ${result.getString(2)}\n"
                )

                buffer.append(
                    "Password : ${result.getString(3)}\n\n"
                )


            }



            val dialogView =
                LayoutInflater.from(this)
                    .inflate(
                        R.layout.dialog_student_records,
                        null
                    )


            val txt =
                dialogView.findViewById<TextView>(
                    R.id.txtRecords
                )


            txt.text =
                buffer.toString()



            val dialog =
                AlertDialog.Builder(this)
                    .setView(dialogView)
                    .create()



            val close =
                dialogView.findViewById<Button>(
                    R.id.btnClose
                )


            close.setOnClickListener {

                dialog.dismiss()

            }


            dialog.show()

        }




        // Update Data


        update.setOnClickListener {


            val layout =
                LinearLayout(this)


            layout.orientation =
                LinearLayout.VERTICAL


            val id =
                EditText(this)

            id.hint =
                "Enter ID"


            val name =
                EditText(this)

            name.hint =
                "Enter New Username"



            val email =
                EditText(this)

            email.hint =
                "Enter New Email"



            val pass =
                EditText(this)

            pass.hint =
                "Enter New Password"



            layout.addView(id)
            layout.addView(name)
            layout.addView(email)
            layout.addView(pass)



            AlertDialog.Builder(this)

                .setTitle(
                    "Update Student"
                )

                .setView(layout)


                .setPositiveButton(
                    "Update"
                ){_,_->


                    val result =
                        db.updateData(

                            id.text.toString().toInt(),

                            name.text.toString(),

                            email.text.toString(),

                            pass.text.toString()
                        )


                    if(result)

                        Toast.makeText(
                            this,
                            "Updated Successfully",
                            Toast.LENGTH_SHORT
                        ).show()


                    else

                        Toast.makeText(
                            this,
                            "Update Failed",
                            Toast.LENGTH_SHORT
                        ).show()


                }

                .show()


        }






        // Delete Data


        delete.setOnClickListener {



            val id =
                EditText(this)


            id.hint =
                "Enter ID"



            AlertDialog.Builder(this)

                .setTitle(
                    "Delete Student"
                )

                .setView(id)


                .setPositiveButton(
                    "Delete"
                ){_,_->



                    val result =
                        db.deleteData(

                            id.text.toString().toInt()

                        )



                    if(result)

                        Toast.makeText(
                            this,
                            "Deleted Successfully",
                            Toast.LENGTH_SHORT
                        ).show()


                    else


                        Toast.makeText(
                            this,
                            "Delete Failed",
                            Toast.LENGTH_SHORT
                        ).show()


                }

                .show()


        }


    }

}