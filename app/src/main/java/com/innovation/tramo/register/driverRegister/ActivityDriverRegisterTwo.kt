package com.innovation.tramo.register.driverRegister

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.innovation.tramo.databinding.ActivityDriverRegisterTwoBinding
import com.innovation.tramo.Fragments.DatePickerFragment
import java.util.*

class ActivityDriverRegisterTwo : AppCompatActivity() {
    private lateinit var binding: ActivityDriverRegisterTwoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDriverRegisterTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val imageGallery = intent.getByteArrayExtra("imagen")
        Log.w("TAG", "se recibio el ByteArray: " + Arrays.toString(imageGallery))



        binding.etDateBirth.setOnClickListener{showDatePickerDialog()}

        setSupportActionBar(binding.toolbarGoDriverThree)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.registerDriverThree.setOnClickListener{ goIrConductor4()}

/*        val spinner: Spinner = binding.spinner
        val items = listOf("Seleccione tipo de Identificación","C.C", "C.E", "Otro")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter*/

        val spinner: Spinner = binding.spinnerDriver
        val items = listOf("Seleccione tipo de Identificación","C.C", "C.E", "Otro")
        val adapter = object : ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items) {
            override fun isEnabled(position: Int): Boolean {
                // Establecemos la primera posición como no seleccionable
                return position != 0
            }

            override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
                val view = super.getDropDownView(position, convertView, parent)

                // Establecemos la apariencia de la primera posición como deshabilitada
                if (position == 0) {
                    view.setBackgroundColor(Color.GRAY)
                } else {
                    view.setBackgroundColor(Color.WHITE)
                }

                return view
            }
        }

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

    }


    val minDate = Calendar.getInstance().apply {
        // set(2022, 0, 1)  1 de enero de 2022

        val c = Calendar.getInstance()
        val year=c.get(Calendar.YEAR)-60
        val month=c.get(Calendar.MONTH)
        val day=c.get(Calendar.DAY_OF_MONTH)
        // c.add(Calendar.YEAR,-18)

        set(year, month, day)

    }.timeInMillis
    val maxDate = Calendar.getInstance().apply {
        //set(2023, 11, 31) // 31 de diciembre de 2023


        val c = Calendar.getInstance()
        val year=c.get(Calendar.YEAR)-18
        val month=c.get(Calendar.MONTH)
        val day=c.get(Calendar.DAY_OF_MONTH)
        // c.add(Calendar.YEAR,-18)

        set(year, month, day)

    }.timeInMillis



    private fun showDatePickerDialog() {
        val datePicker = DatePickerFragment(
            { day, month, year ->onDateSelected(day, month, year)
            },
            minDate,
            maxDate
        )
        datePicker.show(supportFragmentManager, "Fragments")
    }

    private fun onDateSelected(day:Int, month:Int, year:Int){
        year-18
        val fecha = "$day/$month/$year"
       binding.etDateBirth.setText("$fecha")
    }

    private fun goIrConductor4() {

        val spinner: Spinner = binding.spinnerDriver
        val typeId = spinner.selectedItem
        if (typeId is String) { Log.d("SELECIONADO", "La opción seleccionada es: $typeId")}




        val intent = Intent(this, ActivityDriverRegisterThree::class.java)
        startActivity(intent)
    }




}