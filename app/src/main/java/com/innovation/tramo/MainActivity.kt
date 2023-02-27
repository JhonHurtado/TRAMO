package com.innovation.tramo


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.innovation.tramo.databinding.ActivityMainBinding
import com.innovation.tramo.logIn.ActivityLogInDriver
import com.innovation.tramo.logIn.ActivityPersonOrCompany


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.supportActionBar?.hide()

        binding.ComoCliente.setOnClickListener{
            goIrCliente()
        }
        binding.ComoConductor.setOnClickListener{
            goIrConductor()
        }
    }

    private fun goIrConductor() {
        val intent = Intent(this,  ActivityLogInDriver::class.java)
        startActivity(intent)
    }

    private fun goIrCliente(){
        val intent = Intent(this, ActivityPersonOrCompany::class.java)
        startActivity(intent)
    }
}