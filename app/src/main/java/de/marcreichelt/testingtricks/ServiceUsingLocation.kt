package de.marcreichelt.testingtricks

import android.content.Context
import android.content.Context.LOCATION_SERVICE
import android.location.LocationManager

class ServiceUsingLocation(
    private val context: Context,
) {

    private fun getLocationManager() = context.getSystemService(LOCATION_SERVICE) as LocationManager

    fun isLocationEnabled() = getLocationManager().isLocationEnabled

    fun noOp() {}

}
