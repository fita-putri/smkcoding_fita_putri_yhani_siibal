package com.example.siibal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.siibal.R
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.user_registration.*

class LoginActivity : AppCompatActivity() {

    lateinit var handler: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out)

        handler = DatabaseHelper(this)

        showHome()

        registrasi.setOnClickListener {
            showRegistration()
        }

        login.setOnClickListener {
            showLogin()
        }
        register.setOnClickListener {
            handler.insertUserData(username.text.toString(),alamat.text.toString(),nohp.text.toString(),password.text.toString())
            showHome()
        }

        registrasi.setOnClickListener {
            if (handler.userPresent(username.text.toString(),password.text.toString()))
                Toast.makeText(this,"Login Sukses Yeay!",Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this,"Username atau Password salah:(",Toast.LENGTH_SHORT).show()
        }
    }
    private fun showLogin(){
        registration_layout.visibility=View.GONE
        login_layout.visibility=View.VISIBLE
        home_1.visibility=View.GONE
    }
    private fun showRegistration(){
        registration_layout.visibility=View.VISIBLE
        login_layout.visibility=View.GONE
        home_1.visibility=View.GONE

    }
    private fun showHome(){
        registration_layout.visibility=View.GONE
        login_layout.visibility=View.GONE
        home_1.visibility=View.VISIBLE
    }
}
