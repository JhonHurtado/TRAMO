package com.innovation.tramo.register.clientRegister

import android.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.innovation.tramo.databinding.ActivityRegisterClientOneBinding

class ActivityRegisterClientOne : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterClientOneBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRegisterClientOneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarGoLogInClient)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        binding.registerPersonOne.setOnClickListener{
            goPerson()

        }

        val spinner: Spinner = binding.spinner
        val items = listOf("Seleccione tipo de Identificación","C.C", "C.E", "Otro")
        val adapter = ArrayAdapter(this, R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

    }

    private fun goPerson() {

        val intent = Intent(this, ActivityRegisterClientTwo::class.java)
        startActivity(intent)
    }

}