package com.innovation.tramo.register.clientRegister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.innovation.tramo.R
import com.innovation.tramo.databinding.ActivityRegisterClientTwoBinding
import com.innovation.tramo.logIn.ActivityLogInClient

class ActivityRegisterClientTwo : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterClientTwoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterClientTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarGoLogInClient)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.RegisterPersonTwo.setOnClickListener {
            logInClient()
        }


        binding.termsAndConditions.setOnClickListener {
            val inflater = LayoutInflater.from(this)
            val view = inflater.inflate(R.layout.activity_terms_and_conditions, null)
            val dialogBuilder = AlertDialog.Builder(this).setView(view)

            val dialog = dialogBuilder.create()
            dialog.show()

            val btnClose = view.findViewById<Button>(R.id.btnClose)
            btnClose.setOnClickListener {
                dialog.dismiss()

            }


        }
    }

    private fun logInClient() {

        val intent = Intent(this, ActivityLogInClient::class.java)
        startActivity(intent)
    }
}