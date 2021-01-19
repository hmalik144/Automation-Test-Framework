package stepDefinition.baseSteps

import constants.Drivers
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import java.io.IOException

abstract class Driver{

    fun createChromeDriver(driver: Drivers): WebDriver {
        val path = System.getProperty("user.dir")
        System.setProperty(driver.driverProperty, "$path\\src\\test\\resources\\drivers\\${driver.driverFileName}")

        return when(driver){
            Drivers.Chrome -> ChromeDriver()
            else -> { throw IOException("No web driver available")}
        }
    }

}