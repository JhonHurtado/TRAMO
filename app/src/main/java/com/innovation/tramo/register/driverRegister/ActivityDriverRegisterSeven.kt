package com.innovation.tramo.register.driverRegister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.innovation.tramo.databinding.ActivityDriverRegisterSevenBinding

class ActivityDriverRegisterSeven : AppCompatActivity() {
    private lateinit var binding: ActivityDriverRegisterSevenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDriverRegisterSevenBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setSupportActionBar(binding.toolbarGoDriverEight)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        binding.RegisterDriverEight.setOnClickListener{
            goDriverEight()
        }
    }
    private fun goDriverEight() {
        val intent = Intent(this, ActivityDriverRegisterEight::class.java)
        startActivity(intent)
    }

}