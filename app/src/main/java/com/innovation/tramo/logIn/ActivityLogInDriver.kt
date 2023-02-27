package com.innovation.tramo.logIn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.innovation.tramo.databinding.ActivityLogInDriverBinding
import com.innovation.tramo.register.driverRegister.ActivityDriverRegisterOne

class ActivityLogInDriver : AppCompatActivity() {
    private lateinit var binding:ActivityLogInDriverBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLogInDriverBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarGoDriver)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.registerDriver.setOnClickListener{
            goDriver()

        }
    }

    private fun goDriver() {

        val intent = Intent(this, ActivityDriverRegisterOne::class.java)
        startActivity(intent)
    }
}