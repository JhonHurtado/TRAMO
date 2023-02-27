package com.innovation.tramo.register.driverRegister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.innovation.tramo.databinding.ActivityDriverRegisterSixBinding

class ActivityDriverRegisterSix : AppCompatActivity() {
    private lateinit var binding:ActivityDriverRegisterSixBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDriverRegisterSixBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarGoDriverSeven)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)



        binding.RegisterDriverSeven.setOnClickListener{
            goDriverSeven()
        }
    }
    private fun goDriverSeven() {
        val intent = Intent(this, ActivityDriverRegisterSeven::class.java)
        startActivity(intent)
    }
}