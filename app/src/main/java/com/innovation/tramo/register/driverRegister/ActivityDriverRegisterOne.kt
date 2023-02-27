package com.innovation.tramo.register.driverRegister


import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import android.Manifest
import android.util.Log
import com.innovation.tramo.databinding.ActivityDriverRegisterOneBinding
import java.io.ByteArrayOutputStream


private const val REQUEST_CAMERA_PERMISSION = 1
private const val REQUEST_IMAGE_CAPTURE = 2
private const val REQUEST_GALLERY = 3


@Suppress("DEPRECATION")
class ActivityDriverRegisterOne : AppCompatActivity() {
    private var imageCamera: ByteArray? = null
    private var imageGallery: ByteArray? = null
    private lateinit var binding: ActivityDriverRegisterOneBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDriverRegisterOneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarGoDriverTwo)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        /*-------------------------------------------------------------------------*/

        val imageViewSelected = binding.imageViewSelected
        imageViewSelected.setOnClickListener {
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
        binding.registerDriverTwo.setOnClickListener { goDriverRegisterTwo() }
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK) {
            when (requestCode) {
                REQUEST_IMAGE_CAPTURE -> {
                    // La imagen fue capturada con éxito
                    // Obtener la imagen capturada y mostrarla en el ImageView
                    val bitmap = data?.extras?.get("data") as Bitmap
                    binding.imageViewSelected.setImageBitmap(bitmap)
                    // Convertir la imagen a un array de bytes
                    val stream = ByteArrayOutputStream()
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)
                    imageCamera = stream.toByteArray()
                }
                REQUEST_GALLERY -> {
                    // La imagen fue seleccionada de la galería con éxito
                    // Obtener la imagen seleccionada y mostrarla en el ImageView
                    val uri: Uri? = data?.data
                    binding.imageViewSelected.setImageURI(uri)
                    // Convertir la imagen a un array de bytes
                    val bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, uri)
                    val stream = ByteArrayOutputStream()
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)
                    imageGallery = stream.toByteArray()
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


/*-------------------------------------------------------------------------*/


    private fun goDriverRegisterTwo() {

        val intent = Intent(this, ActivityDriverRegisterTwo::class.java)
        /*--------------------------------------------------*/

        if(imageCamera != null || imageGallery != null) {
            if (imageCamera!=null){
                Log.w("camara","la camara contiene una imagen")
                // Agregar el ByteArray como un extra
                intent.putExtra("imagen", imageCamera)
            }else{
                Log.w("galeria","la galeria seleciono una imagen")
                // Agregar el ByteArray como un extra
                intent.putExtra("imagen", imageGallery)
            }
        } else {
            Log.w("ninguna","no hay imagen selecionada")
        }
        /*--------------------------------------------------*/

        startActivity(intent)
        imageCamera = null
        imageGallery = null
        Log.d("SELECIONADO", "La opción seleccionada es: $imageGallery")
        Log.d("SELECIONADO", "La opción seleccionada es: $imageCamera")
    }
}


