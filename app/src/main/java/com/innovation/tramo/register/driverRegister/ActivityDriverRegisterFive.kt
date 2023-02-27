package com.innovation.tramo.register.driverRegister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.innovation.tramo.databinding.ActivityDriverRegisterFiveBinding


class ActivityDriverRegisterFive : AppCompatActivity() {

    private lateinit var binding: ActivityDriverRegisterFiveBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDriverRegisterFiveBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarGoDriverSix)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.RegisterDriverSix.setOnClickListener {
            goDriverSix()
        }
    }

    private fun goDriverSix(){
        val intent = Intent(this, ActivityDriverRegisterSix::class.java)
        startActivity(intent)
    }

}