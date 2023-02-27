package com.innovation.tramo.register.driverRegister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.innovation.tramo.databinding.ActivityDriverRegisterFourBinding

class ActivityDriverRegisterFour : AppCompatActivity() {
    private lateinit var binding: ActivityDriverRegisterFourBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDriverRegisterFourBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarGoDriverFive)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.RegisterDriverFive.setOnClickListener {
            goDriverFive()
        }
    }

    private fun goDriverFive() {
        val intent = Intent(this, ActivityDriverRegisterFive::class.java)
        startActivity(intent)
    }
}