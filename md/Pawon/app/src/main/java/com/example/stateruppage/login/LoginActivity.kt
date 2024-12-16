package com.example.stateruppage.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.stateruppage.ApiObject
import com.example.stateruppage.R
import com.example.stateruppage.data.LoginRequest
import com.example.stateruppage.home.HomeActivity
import com.example.stateruppage.register.RegisterActivity
import com.google.android.material.button.MaterialButton

class LoginActivity : AppCompatActivity() {

    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: MaterialButton
    private lateinit var progressBar: ProgressBar
    private lateinit var textRegister: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnlogin)
        progressBar = findViewById(R.id.progressBar)
        textRegister = findViewById(R.id.textRegister)

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            // Validasi input email dan password
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Email dan Password tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else if (!isValidEmail(email)) {
                Toast.makeText(this, "Email tidak valid", Toast.LENGTH_SHORT).show()
            } else if (password.length < 4) {
                Toast.makeText(this, "Password harus lebih dari 6 karakter", Toast.LENGTH_SHORT).show()
            } else {
                login(email, password)
            }
        }

        textRegister.setOnClickListener {
            // Arahkan ke halaman registrasi
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    // Fungsi untuk validasi email
    private fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun login(email: String, password: String) {
        progressBar.visibility = View.VISIBLE // Menampilkan ProgressBar
        btnLogin.isEnabled = false // Menonaktifkan tombol login

        val loginRequest = LoginRequest(email, password)

        // Menggunakan ApiObject untuk login
        ApiObject.loginUser(loginRequest, { loginResponse ->
            progressBar.visibility = View.GONE // Sembunyikan ProgressBar
            btnLogin.isEnabled = true // Aktifkan kembali tombol login

            if (loginResponse?.status == "success") {
                Toast.makeText(this, loginResponse.message, Toast.LENGTH_SHORT).show()

                // Berpindah ke HomeActivity
                val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                intent.putExtra("USER_FULLNAME", loginResponse.data?.fullname)
                startActivity(intent)
                finish() // Menyelesaikan aktivitas login
            } else {
                Toast.makeText(this, loginResponse?.message, Toast.LENGTH_SHORT).show()
            }
        }, { error ->
            progressBar.visibility = View.GONE // Sembunyikan ProgressBar
            btnLogin.isEnabled = true // Aktifkan kembali tombol login
            Toast.makeText(this, "Terjadi kesalahan: ${error.message}", Toast.LENGTH_SHORT).show()
        })
    }
}
