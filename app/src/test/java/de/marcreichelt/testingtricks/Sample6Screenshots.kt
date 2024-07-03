package de.marcreichelt.testingtricks

import com.github.takahirom.roborazzi.captureRoboImage
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.GraphicsMode

@GraphicsMode(GraphicsMode.Mode.NATIVE)
@RunWith(RobolectricTestRunner::class)
class Sample6Screenshots {

    @Test
    fun `take screenshot with roborazzi`() = captureRoboImage("roborazzi.png") {
        Greeting("Droidcon Berlin 2024")
    }

}

// - record screenshots: ./gradlew :app:recordRoborazziDebug
// - verify:             ./gradlew :app:verifyRoborazziDebug

// - the future: screenshot testing for all your Composable previews! 🎉
//   see: https://developer.android.com/studio/preview/compose-screenshot-testing
