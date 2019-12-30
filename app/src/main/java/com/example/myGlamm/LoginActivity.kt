package com.example.myGlamm

import androidx.appcompat.app.AppCompatActivity

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity() {
    lateinit var etUsername: EditText
    lateinit var etPassword: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnSignIn:Button = findViewById(R.id.btnSignIn)
        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnSignIn.setOnClickListener {
            if (null != etUsername.text && !TextUtils.isEmpty(etUsername.text) && null != etPassword.text && !TextUtils.isEmpty(etPassword.text)
                    && TextUtils.equals(etUsername.text, "test@android.com") && TextUtils.equals(etPassword.text, "123456")) {
                val i = Intent(this@LoginActivity, ListActivity::class.java)
                startActivity(i)
            }
        }
    }
}
