package de.marcreichelt.testingtricks

import app.cash.paparazzi.DeviceConfig.Companion.PIXEL_6
import app.cash.paparazzi.Paparazzi
import com.github.takahirom.roborazzi.captureRoboImage
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.GraphicsMode

@GraphicsMode(GraphicsMode.Mode.NATIVE)
@RunWith(RobolectricTestRunner::class)
class Sample7Roborazzi {

    @Test
    fun `take screenshot with roborazzi`() = captureRoboImage("roborazzi.png") {
        Greeting("Droidcon Berlin 2024")
    }

}


class Sample7Paparazzi {

    @get:Rule
    val paparazzi = Paparazzi(
        deviceConfig = PIXEL_6,
        theme = "android:Theme.Material.Light.NoActionBar"
    )

    @Test
    fun `take screenshot with paparazzi`() = paparazzi.snapshot {
        Greeting("Droidcon Berlin 2024")
    }

}

// - record screenshots: ./gradlew :app:recordRoborazziDebug :app:recordPaparazziDebug
// - verify:             ./gradlew :app:verifyRoborazziDebug :app:verifyPaparazziDebug

// - the future: screenshot testing for all your Composable previews! 🎉
//   see: https://developer.android.com/studio/preview/compose-screenshot-testing
