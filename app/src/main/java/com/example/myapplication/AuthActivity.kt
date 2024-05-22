package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class AuthActivity : AppCompatActivity() {
    private lateinit var userLogin: EditText
    private lateinit var UserPass: EditText
    private lateinit var Button: Button
    private lateinit var linkToReg: TextView
    

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        userLogin = findViewById(R.id.user_login_auth)
        UserPass = findViewById(R.id.user_pass)
        Button = findViewById(R.id.button_auth)
        linkToReg = findViewById(R.id.link_to_reg)



        linkToReg.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        Button.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val pass = UserPass.text.toString().trim()

            if (login.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_LONG).show()
            } else {
                val db = DbHelper(this, null)
                val isAuth = db.getUser(login, pass)

                if (isAuth) {
                    Toast.makeText(this, "Пользователь $login авторизован", Toast.LENGTH_LONG).show()

                    userLogin.text.clear()
                    UserPass.text.clear()


                    val intent = Intent(this, itemsActivity::class.java)
                    startActivity(intent)

                } else {
                    Toast.makeText(this, "Неверный логин или пароль", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}