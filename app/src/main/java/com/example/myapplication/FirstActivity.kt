package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        val authMain: TextView = findViewById(R.id.auth)
        val regMain: TextView = findViewById(R.id.reg)

        authMain.setOnClickListener{

            val intent = Intent(this, AuthActivity:: class.java)
            startActivity(intent)
        }

        regMain.setOnClickListener{

            val intent = Intent(this, MainActivity:: class.java)
            startActivity(intent)
        }

    }
}