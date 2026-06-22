package com.example.myapplication5

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) :
    SQLiteOpenHelper(context, "StudentDB", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            "CREATE TABLE Student(" +
                    "UID INTEGER PRIMARY KEY," +
                    "NAME TEXT," +
                    "EMAIL TEXT)"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS Student")
        onCreate(db)
    }

    fun insertData(uid: Int, name: String, email: String): Boolean {

        val db = writableDatabase
        val values = ContentValues()

        values.put("UID", uid)
        values.put("NAME", name)
        values.put("EMAIL", email)

        val result = db.insert("Student", null, values)

        return result != -1L
    }

    fun getAllData(): Cursor {

        val db = readableDatabase

        return db.rawQuery("SELECT * FROM Student", null)
    }

    fun updateData(uid: Int, name: String, email: String): Boolean {

        val db = writableDatabase
        val values = ContentValues()

        values.put("NAME", name)
        values.put("EMAIL", email)

        val result = db.update(
            "Student",
            values,
            "UID=?",
            arrayOf(uid.toString())
        )

        return result > 0
    }

    fun deleteData(uid: Int): Boolean {

        val db = writableDatabase

        val result = db.delete(
            "Student",
            "UID=?",
            arrayOf(uid.toString())
        )

        return result > 0
    }
}
