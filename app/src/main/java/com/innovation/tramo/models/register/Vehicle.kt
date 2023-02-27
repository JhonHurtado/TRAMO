package com.innovation.tramo.models.register

data class Vehicle(
    val marca:String,
    val modelo:String,
    val numeroEjes:String,
    val tipoVehiculo:String,
    val traccionVeh:String,
    val placaVehiculo:String,
    val placasTrailer:String,
    val pesoVacio:String,
    val CombustibleVeh:String,
    val numeroLicenciaVeh:String,
    val numeroSOAT:String,
    val companiaSOAT:String,
    val fechavencSOAT:String,
    val nroPoliza_ResponCivil:String,
    val nroRev_TecMecanica:String,
    val fechaVenc_Tecno:String
)
