package com.innovation.tramo.register.driverRegister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.innovation.tramo.Fragments.DatePickerFragment
import com.innovation.tramo.databinding.ActivityDriverRegisterEightBinding
import java.util.*

class ActivityDriverRegisterEight : AppCompatActivity() {
    private lateinit var binding:ActivityDriverRegisterEightBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDriverRegisterEightBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarGoDriverNine)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.RegisterDriverNine.setOnClickListener{
            goDriverNine()
        }
        binding.etDateSOAT.setOnClickListener{ dateSOAT() }
        binding.etDateTECNO.setOnClickListener{ dateTECNO() }


    }


    private fun dateSOAT(){



        val minDate = Calendar.getInstance().apply {
            // set(2022, 0, 1)  1 de enero de 2022

            val c = Calendar.getInstance()
            val year=c.get(Calendar.YEAR)-2
            val month=c.get(Calendar.MONTH)
            val day=c.get(Calendar.DAY_OF_MONTH)
            // c.add(Calendar.YEAR,-18)

            set(year, month, day)

        }.timeInMillis

        val maxDate = Calendar.getInstance().apply {
            //set(2023, 11, 31) // 31 de diciembre de 2023

            val c = Calendar.getInstance()
            val year=c.get(Calendar.YEAR)+2
            val month=c.get(Calendar.MONTH)
            val day=c.get(Calendar.DAY_OF_MONTH)
            set(year, month, day)

        }.timeInMillis






             fun onDateSelected(day:Int,month:Int,year:Int){
                 year-18
                 val fecha = "$day/$month/$year"
                 binding.etDateSOAT.setText("$fecha")

             }

            val datePicker = DatePickerFragment(
                { day, month, year ->onDateSelected(day, month, year)
                },
                minDate,
                maxDate
            )
            datePicker.show(supportFragmentManager, "Fragments")

    }



    private fun dateTECNO(){



        val minDate = Calendar.getInstance().apply {
            // set(2022, 0, 1)  1 de enero de 2022

            val c = Calendar.getInstance()
            val year=c.get(Calendar.YEAR)-2
            val month=c.get(Calendar.MONTH)
            val day=c.get(Calendar.DAY_OF_MONTH)
            // c.add(Calendar.YEAR,-18)

            set(year, month, day)

        }.timeInMillis

        val maxDate = Calendar.getInstance().apply {
            //set(2023, 11, 31) // 31 de diciembre de 2023

            val c = Calendar.getInstance()
            val year=c.get(Calendar.YEAR)+2
            val month=c.get(Calendar.MONTH)
            val day=c.get(Calendar.DAY_OF_MONTH)
            set(year, month, day)

        }.timeInMillis






        fun onDateSelected(day:Int,month:Int,year:Int){
            year-18
            val fecha = "$day/$month/$year"
            binding.etDateTECNO.setText("$fecha")

        }

        val datePicker = DatePickerFragment(
            { day, month, year ->onDateSelected(day, month, year)
            },
            minDate,
            maxDate
        )
        datePicker.show(supportFragmentManager, "Fragments")

    }





    private fun goDriverNine(){
        val intent = Intent(this, ActivityDriverRegisterNine::class.java)
        startActivity(intent)
    }


}