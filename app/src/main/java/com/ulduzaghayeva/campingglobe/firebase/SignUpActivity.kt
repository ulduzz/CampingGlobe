package com.ulduzaghayeva.campingglobe.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.ulduzaghayeva.campingglobe.MainActivity
import com.ulduzaghayeva.campingglobe.R
import com.ulduzaghayeva.campingglobe.databinding.ActivitySignUpBinding

class SignUpActivity :BaseActivity() {
    private var binding:ActivitySignUpBinding? = null
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        auth = Firebase.auth

        binding?.tvLoginPage?.setOnClickListener{
            startActivity(Intent(this,SignInActivity::class.java))
            finish()
        }
        binding?.btnSignUp?.setOnClickListener { registerUser() }
    }
    private fun registerUser(){
        val name = binding?.etSinUpName?.text.toString()
        val email = binding?.etSinUpEmail?.text.toString()
        val password = binding?.etSinUpPassword?.text.toString()
        if (validateForm(name,email,password)){

            showProgressBar()
            auth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener { task->
                    if (task.isSuccessful){
                        showToast(this,"User ID created successfully")
                        hideProgressBar()
                        startActivity(Intent(this,MainActivity::class.java))
                        finish()

                    }
                    else
                        showToast(this, "User ID not created.Try again later")
                        hideProgressBar()

                }
            
        }
    }

    private fun validateForm(name: String, email: String, password: String): Boolean {
        return when{
            TextUtils.isEmpty(name)->{
                binding?.tilName?.error = "Enter name"
                false
            }
            TextUtils.isEmpty(email) && !Patterns.EMAIL_ADDRESS.matcher(email).matches()->{
                binding?.tilEmail?.error = "Enter valid email address"
                false
            }
            TextUtils.isEmpty(password)->{
                binding?.tilPassword?.error = "Enter password"
                false
            }
            else ->{ true }
        }

    }

}