package de.marcreichelt.testingtricks

import android.content.Context.LOCATION_SERVICE
import android.location.LocationManager
import androidx.test.platform.app.InstrumentationRegistry
import assertk.assertThat
import assertk.assertions.isFalse
import assertk.assertions.isTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows.shadowOf

@RunWith(RobolectricTestRunner::class)
class Sample6Robolectric {

    private val context = InstrumentationRegistry.getInstrumentation().context
    private fun getLocationManager() = context.getSystemService(LOCATION_SERVICE) as LocationManager

    @Test
    fun `location is enabled`() {
        val service = ServiceUsingLocation(context)
        shadowOf(getLocationManager()).setLocationEnabled(true)
        assertThat(service.isLocationEnabled()).isTrue()
    }

    @Test
    fun `location is disabled`() {
        val service = ServiceUsingLocation(context)
        shadowOf(getLocationManager()).setLocationEnabled(false)
        assertThat(service.isLocationEnabled()).isFalse()
    }

    @Test
    fun `some test that is not using location`() {
        val service = ServiceUsingLocation(context)
        service.noOp()
    }

}

// - use Robolectric to test Android APIs
// - bigger overhead: use only when necessary
