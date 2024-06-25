package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var UserLogin: EditText
    private lateinit var UserEmail: EditText
    private lateinit var UserPass: EditText
    private lateinit var Button: Button
    private lateinit var linkToAuth: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        UserLogin = findViewById(R.id.user_login)
        UserEmail = findViewById(R.id.user_email)
        UserPass = findViewById(R.id.user_pass)
        Button = findViewById(R.id.button_reg)
        linkToAuth = findViewById(R.id.link_to_auth)

        linkToAuth.setOnClickListener {
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }

        Button.setOnClickListener {
            val login = UserLogin.text.toString().trim()
            val email = UserEmail.text.toString().trim()
            val pass = UserPass.text.toString().trim()

            if (login.isEmpty() || email.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_LONG).show()
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "Введите корректный email", Toast.LENGTH_LONG).show()
            } else if (login.length < 5) {
                Toast.makeText(this, "Логин должен содержать минимум 5 символов", Toast.LENGTH_LONG).show()
            } else if (!isPasswordComplexEnough(pass)) {
                Toast.makeText(this, "Пароль должен содержать минимум 8 символов, одну заглавную букву и один спец. символ или цифру", Toast.LENGTH_LONG).show()
            } else {
                val user = User(login, email, pass)

                val db = DbHelper(this, null)
                db.addUser(user)

                Toast.makeText(this, "Пользователь $login добавлен", Toast.LENGTH_LONG).show()

                UserLogin.text.clear()
                UserEmail.text.clear()
                UserPass.text.clear()
            }
        }
    }

    private fun isPasswordComplexEnough(password: String): Boolean {
        val passwordPattern = Regex("^(?=.*[A-Z])(?=.*[!@#\$%^&*(),.?\":{}|<>\\d]).{8,}\$")
        return passwordPattern.containsMatchIn(password)
    }
}