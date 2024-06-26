package com.ulduzaghayeva.campingglobe.firebase

import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.ulduzaghayeva.campingglobe.databinding.ActivityForgetPasswordBinding

class ForgetPasswordActivity : BaseActivity() {
    private var binding: ActivityForgetPasswordBinding?= null
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgetPasswordBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        auth = Firebase.auth

        binding?.btnForgotPasswordSubmit?.setOnClickListener { resertPassword() }
    }

    private fun validateForm(email: String): Boolean {
        return when {
            TextUtils.isEmpty(email) && !Patterns.EMAIL_ADDRESS.matcher(email).matches()->{
                binding?.tilEmailForgetPassword?.error = "Enter valid email address"
                false
            }
            else -> true
        }

    }

    private fun resertPassword(){
        val email = binding?.etForgotPasswordEmail?.text.toString()
        if(validateForm(email)){


            showProgressBar()
            auth.sendPasswordResetEmail(email).addOnCompleteListener {task->
                if (task.isSuccessful){
                   hideProgressBar()
                    binding?.tilEmailForgetPassword?.visibility = View.GONE
                    binding?.tvSubmitMsg?.visibility = View.VISIBLE
                    binding?.btnForgotPasswordSubmit?.visibility = View.GONE
                }
                else {
                    hideProgressBar()
                    showToast(this, "Can not reset your password. Try after sometime")
                }
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}