package com.example.myapplication5


import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DBHelper(context: Context) :
    SQLiteOpenHelper(
        context,
        "StudentDB",
        null,
        1
    ) {


    override fun onCreate(db: SQLiteDatabase) {


        db.execSQL(
            "CREATE TABLE Student(" +
                    "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "USERNAME TEXT," +
                    "EMAIL TEXT," +
                    "PASSWORD TEXT)"
        )

    }


    override fun onUpgrade(
        db: SQLiteDatabase,
        oldVersion: Int,
        newVersion: Int
    ) {


        db.execSQL(
            "DROP TABLE IF EXISTS Student"
        )


        onCreate(db)

    }



    // Registration Data Save

    fun insertData(
        username: String,
        email: String,
        password: String
    ): Boolean {


        val db = writableDatabase


        val values =
            ContentValues()


        values.put(
            "USERNAME",
            username
        )


        values.put(
            "EMAIL",
            email
        )


        values.put(
            "PASSWORD",
            password
        )


        val result =
            db.insert(
                "Student",
                null,
                values
            )


        return result != -1L

    }



    // View Records

    fun getAllData(): Cursor {


        val db =
            readableDatabase


        return db.rawQuery(
            "SELECT * FROM Student",
            null
        )

    }




    // Update Records

    fun updateData(
        id: Int,
        username: String,
        email: String,
        password: String
    ): Boolean {


        val db =
            writableDatabase


        val values =
            ContentValues()


        values.put(
            "USERNAME",
            username
        )


        values.put(
            "EMAIL",
            email
        )


        values.put(
            "PASSWORD",
            password
        )


        val result =
            db.update(
                "Student",
                values,
                "ID=?",
                arrayOf(id.toString())
            )


        return result > 0

    }





    // Delete Records

    fun deleteData(
        id: Int
    ): Boolean {


        val db =
            writableDatabase


        val result =
            db.delete(
                "Student",
                "ID=?",
                arrayOf(id.toString())
            )


        return result > 0

    }
// Login Check

    fun checkLogin(
        username: String,
        password: String
    ): Boolean {


        val db =
            readableDatabase


        val cursor =
            db.rawQuery(
                "SELECT * FROM Student WHERE USERNAME=? AND PASSWORD=?",
                arrayOf(username, password)
            )


        val result =
            cursor.count > 0


        cursor.close()


        return result

    }

}