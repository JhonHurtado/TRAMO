package com.innovation.tramo.models.register

import android.graphics.Bitmap
import java.util.*

data class RegisterDriver(
    var fotoperfilCON: Bitmap? = null,
    val nombreCON: String,
    val apellidoCON: String,
    val usuarioCON: String,
    val tipo_DocumentoCON: String,
    val nroDocumentoCON: String,
    val nacionalidadCON: String,
    val DireccionResidenciaCON: String,
    val ciudadCON: String,
    val fechaNacimientoCON: Date,
    val nroTelefonoCON: String,
    val correoElectronicoCON: String,
    val correoRecuperacionCON: String,
    val nroLicenciaCON: Char,
    val contrasenaCON: String,
    val preguntaSeguridadCON: String,
    val respuestaSeguridadCON: String,
)
