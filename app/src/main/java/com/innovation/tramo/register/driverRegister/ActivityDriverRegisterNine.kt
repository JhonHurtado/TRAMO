/*
package com.innovation.tramo.register.driverRegister

import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import com.innovation.tramo.R
import com.innovation.tramo.databinding.ActivityDriverRegisterNineBinding


class ActivityDriverRegisterNine : AppCompatActivity() {


    private lateinit var binding: ActivityDriverRegisterNineBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDriverRegisterNineBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbarGoDriverTen)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)



        binding.RegisterDriverTen.setOnClickListener {goDriverTen()}


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




    */
/*





    // Este método abre el selector de imágenes del dispositivo
    private fun openImageSelector(requestCode: Int, imageView: ImageView) {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, requestCode)
        selectedImageView = imageView
    }

    // Este método se llama cuando el usuario ha seleccionado una imagen desde el selector de imágenes
    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            val imageUri: Uri? = data.data // Obtener la URI de la imagen seleccionada
            selectedImageView?.setImageURI(imageUri)// Mostrar la imagen en la ImageView en la que se ha hecho clic
        }
    }
*//*



//-------------------------------------------------------------------------------------------

    private fun goDriverTen() {
        val intent = Intent(this, ActivityDriverRegisterTen::class.java)
        startActivity(intent)
    }

}*/



package com.innovation.tramo.register.driverRegister


import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AlertDialog
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.innovation.tramo.R
import com.innovation.tramo.databinding.ActivityDriverRegisterNineBinding
import java.io.ByteArrayOutputStream

/*---------------------------------------------------------------------------------------------*/
private const val REQUEST_CAMERA_PERMISSION = 1
private const val REQUEST_IMAGE_CAPTURE = 2
private const val REQUEST_GALLERY = 3
/*---------------------------------------------------------------------------------------------*/


class ActivityDriverRegisterNine : AppCompatActivity() {
    private lateinit var imageCamera: ByteArray
    private lateinit var imageGallery: ByteArray


    private lateinit var binding: ActivityDriverRegisterNineBinding

    /*---------------------------------------------------------------------------------------------*/
    private var ivFrontalVehiculo: ImageView? = null
    private var ivTraseraVehiculo: ImageView? = null
    private var ivLateralIzqVehiculo: ImageView? = null
    private var ivLateralDerVehiculo: ImageView? =null
    private var ivSelected = 0
    private var ftFrontalVehiculo = byteArrayOf() // Crea un arreglo vacío
    private var ftTraseraVehiculo = byteArrayOf() // Crea un arreglo vacío
    private var ftLateralIzqVehiculo = byteArrayOf() // Crea un arreglo vacío
    private var ftLateralDerVehiculo = byteArrayOf() // Crea un arreglo vacío

    /*---------------------------------------------------------------------------------------------*/


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDriverRegisterNineBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbarGoDriverTen)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        /*-------------------------------------------------------------------------*/

        binding.RegisterDriverTen.setOnClickListener { goDriverTen() }
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

         ivFrontalVehiculo = binding.ivFrontalVehiculo
         ivTraseraVehiculo = binding.ivTraseraVehiculo
         ivLateralIzqVehiculo = binding.ivLateralIzqVehiculo
         ivLateralDerVehiculo =binding.ivLateralDerVehiculo


        ivFrontalVehiculo!!.setOnClickListener { showImageDialog(0) }
        ivTraseraVehiculo!!.setOnClickListener { showImageDialog(1) }
        ivLateralIzqVehiculo!!.setOnClickListener { showImageDialog(2) }
        ivLateralDerVehiculo!!.setOnClickListener { showImageDialog(3) }
        /*--------------------------------------------------------------------------------------*/

    }


    private fun showImageDialog(ivSelect: Int) {

        ivSelected = ivSelect
        Log.w("ivselecionada", ivSelected.toString())
        // Crear un cuadro de diálogo para dar opciones al usuario
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Selecciona una opción")
            .setItems(
                arrayOf("Tomar foto", "Elegir foto de la galería")
            ) { _, which ->
                when (which) {
                    0 -> {
                        // El usuario seleccionó "Tomar foto"
                        // Verificar si se tienen los permisos necesarios para abrir la cámara
                        if (ContextCompat.checkSelfPermission(
                                this,
                                Manifest.permission.CAMERA
                            ) != PackageManager.PERMISSION_GRANTED
                        ) {
                            // Si no se tienen los permisos, solicitarlos al usuario
                            ActivityCompat.requestPermissions(
                                this,
                                arrayOf(Manifest.permission.CAMERA),
                                REQUEST_CAMERA_PERMISSION
                            )
                        } else {
                            // Si se tienen los permisos, abrir la cámara
                            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE)
                        }
                    }
                    1 -> {
                        // El usuario seleccionó "Elegir de la galería"
                        // Abrir la galería
                        val intent = Intent(
                            Intent.ACTION_PICK,
                            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
                        )
                        startActivityForResult(intent, REQUEST_GALLERY)
                    }
                }
            }
            .show()
    }

    /*--------------------------------------------------------------------------------------------*/

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK) {
            when (requestCode) {
                REQUEST_IMAGE_CAPTURE -> {
                    // La imagen fue capturada con éxito
                    // Obtener la imagen capturada y mostrarla en el ImageView
                    val bitmap = data?.extras?.get("data") as Bitmap
                    /*--------------------------------------------------------------------------*/
                    when(ivSelected) {
                        0 ->{
                            binding.ivFrontalVehiculo.setImageBitmap(bitmap)
                        }
                        1 ->{
                            binding.ivTraseraVehiculo.setImageBitmap(bitmap)
                        }
                        2 ->{
                            binding.ivLateralIzqVehiculo.setImageBitmap(bitmap)
                        }
                        3 ->{
                            binding.ivLateralDerVehiculo.setImageBitmap(bitmap)
                        }
                    }

                    /*--------------------------------------------------------------------------*/
                    // Convertir la imagen a un array de bytes
                    val stream = ByteArrayOutputStream()
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)
                    imageCamera = stream.toByteArray()
                    Log.w("frontal",imageCamera.toString())
                    when(ivSelected) {
                        0 ->{
                            ftFrontalVehiculo=ftFrontalVehiculo.plus(imageCamera)
                        }
                        1 ->{
                            ftTraseraVehiculo=ftTraseraVehiculo.plus(imageCamera)
                        }
                        2 ->{
                            ftLateralIzqVehiculo=ftLateralIzqVehiculo.plus(imageCamera)
                        }
                        3 ->{
                            ftLateralDerVehiculo=ftLateralDerVehiculo.plus(imageCamera)
                        }
                    }

                }
                REQUEST_GALLERY -> {
                    // La imagen fue seleccionada de la galería con éxito
                    // Obtener la imagen seleccionada y mostrarla en el ImageView
                    val uri: Uri? = data?.data
                    /*--------------------------------------------------------------------------*/
                    when(ivSelected) {
                        0 ->{
                            binding.ivFrontalVehiculo.setImageURI(uri)
                        }
                        1 ->{
                            binding.ivTraseraVehiculo.setImageURI(uri)
                        }
                        2 ->{
                            binding.ivLateralIzqVehiculo.setImageURI(uri)
                        }
                        3 ->{
                            binding.ivLateralDerVehiculo.setImageURI(uri)
                        }
                    }

                    /*--------------------------------------------------------------------------*/
                    // Convertir la imagen a un array de bytes
                    val bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, uri)
                    val stream = ByteArrayOutputStream()
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)
                    imageGallery = stream.toByteArray()
                    Log.w("frontal",imageGallery.toString())
                    when(ivSelected) {
                        0 ->{
                            ftFrontalVehiculo=ftFrontalVehiculo.plus(imageGallery)
                        }
                        1 ->{
                            ftTraseraVehiculo=ftTraseraVehiculo.plus(imageGallery)
                        }
                        2 ->{
                            ftLateralIzqVehiculo=ftLateralIzqVehiculo.plus(imageGallery)
                        }
                        3 ->{
                            ftLateralDerVehiculo=ftLateralDerVehiculo.plus(imageGallery)
                        }
                    }
                }
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode) {
            REQUEST_CAMERA_PERMISSION -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Si se concedieron los permisos, abrir la cámara
                    val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                    startActivityForResult(intent, REQUEST_IMAGE_CAPTURE)
                }
            }
        }
    }

    /*--------------------------------------------------------------------------------------------*/


    private fun goDriverTen() {
        Log.w("frontal",ftFrontalVehiculo.size.toString())
        Log.w("trasera",ftTraseraVehiculo.size.toString())
        Log.w("izquierda",ftLateralIzqVehiculo.size.toString())
        Log.w("derecha",ftLateralDerVehiculo.size.toString())
        val intent = Intent(this, ActivityDriverRegisterTen::class.java)
        startActivity(intent)
    }
}

