package com.innovation.tramo.register.clientRegister.registerCompany

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.innovation.tramo.databinding.ActivityRegisterClientCompanyOneBinding
import com.innovation.tramo.register.clientRegister.ActivityRegisterClientTwo


class ActivityRegisterClientCompanyOne : AppCompatActivity() {
    private lateinit var binding:ActivityRegisterClientCompanyOneBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRegisterClientCompanyOneBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setSupportActionBar(binding.toolbarGoLogInClientCompany)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        binding.registerPersonOne.setOnClickListener{
            goCompany()

        }
    }

    private fun goCompany() {

        val intent = Intent(this, ActivityRegisterClientCompanyTwo::class.java)
        startActivity(intent)
    }
}