package com.innovation.tramo.models.register

import android.graphics.Bitmap

data class VehiclePhotos(
    var FotoFrontal: Bitmap? = null,
    var FotoVolco: Bitmap? = null,
    var Fotolateral_Izq: Bitmap? = null,
    var Fotolateral_Der: Bitmap? = null,
    var Fotolateral_IzqTrailer: Bitmap? = null,
    var Fotolateral_DerTrailertext: Bitmap? = null,
    var FotoVolco_Trailer: Bitmap? = null
)
