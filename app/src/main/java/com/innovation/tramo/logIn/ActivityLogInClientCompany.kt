package com.innovation.tramo.logIn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.innovation.tramo.clientLauncher.ActivityClientLaunchOne
import com.innovation.tramo.databinding.ActivityLogInClientCompanyBinding
import com.innovation.tramo.register.clientRegister.registerCompany.ActivityRegisterClientCompanyOne
import com.innovation.tramo.register.driverRegister.ActivityDriverRegisterOne

class ActivityLogInClientCompany : AppCompatActivity() {
    private lateinit var binding: ActivityLogInClientCompanyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLogInClientCompanyBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setSupportActionBar(binding.toolbarGoClientOrCompany)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)



        binding.btnLogInCompany.setOnClickListener{
            goClientCompany()

        }
        binding.RegisterCompany.setOnClickListener{
            goCompany()

        }
    }

    private fun goClientCompany() {
        val intent = Intent(this, ActivityClientLaunchOne::class.java)
        startActivity(intent)
    }

    private fun goCompany() {

        val intent = Intent(this, ActivityRegisterClientCompanyOne::class.java)
        startActivity(intent)
    }
}