package com.innovation.tramo.logIn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.innovation.tramo.clientLauncher.ActivityClientLaunchOne
import com.innovation.tramo.databinding.ActivityLogInClientBinding
import com.innovation.tramo.register.clientRegister.ActivityRegisterClientOne
import com.innovation.tramo.register.driverRegister.ActivityDriverRegisterOne

class ActivityLogInClient : AppCompatActivity() {
    private lateinit var binding:ActivityLogInClientBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInClientBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarPersona)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.RegisterPerson.setOnClickListener{
            goPerson()

        }
        binding.btnLogInPerson.setOnClickListener{
            goPersons()

        }
    }

    private fun goPerson() {

        val intent = Intent(this, ActivityRegisterClientOne::class.java)
        startActivity(intent)
    }
    private fun goPersons() {

        val intent = Intent(this, ActivityClientLaunchOne::class.java)
        startActivity(intent)
    }
}