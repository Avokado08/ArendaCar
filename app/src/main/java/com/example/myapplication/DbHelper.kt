package com.example.myapplication

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(context: Context, factory: SQLiteDatabase.CursorFactory? ) :
    SQLiteOpenHelper(context, "app.db", factory, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        val query = "CREATE TABLE users (id INTEGER PRIMARY KEY AUTOINCREMENT, login TEXT, email TEXT, pass TEXT)"
        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS users")
        onCreate(db)
    }

    fun addUser(user: User) {
        val values = ContentValues()
        values.put("login", user.login)
        values.put("email", user.email)
        values.put("pass", user.pass)

        val db = this.writableDatabase
        db.insert("users", null, values)
        db.close()
    }

    fun getUser(login: String, pass: String): Boolean {
        val db = this.readableDatabase
        val result = db.rawQuery("SELECT * FROM users WHERE login = ? AND pass = ?", arrayOf(login, pass))
        val count = result.count
        result.close()
        return count > 0
    }
}