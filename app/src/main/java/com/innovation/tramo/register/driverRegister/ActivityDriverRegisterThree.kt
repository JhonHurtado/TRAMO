package com.innovation.tramo.register.driverRegister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.innovation.tramo.databinding.ActivityDriverRegisterThreeBinding

class ActivityDriverRegisterThree : AppCompatActivity() {
    private lateinit var binding:ActivityDriverRegisterThreeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDriverRegisterThreeBinding.inflate(layoutInflater)
        setContentView(binding.root)



        setSupportActionBar(binding.toolbarGoDriverFour)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        binding.RegisterDriverFour.setOnClickListener{
            goDriverFour()
        }
    }

    private fun goDriverFour() {
        val intent = Intent(this, ActivityDriverRegisterFour::class.java)
        startActivity(intent)
    }
}