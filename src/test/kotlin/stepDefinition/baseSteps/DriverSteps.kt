package stepDefinition.baseSteps

import constants.Drivers
import constants.TIMEOUT_DURATION
import org.openqa.selenium.WebDriver
import java.util.concurrent.TimeUnit


abstract class DriverSteps : Driver(){

    fun createWebDriver(driver: Drivers): WebDriver{
        return createChromeDriver(driver).apply {
            manage().timeouts().let { tO ->
                tO.implicitlyWait(TIMEOUT_DURATION, TimeUnit.SECONDS)
                tO.pageLoadTimeout(TIMEOUT_DURATION, TimeUnit.SECONDS)
            }
        }
    }

    fun WebDriver.launchUrl(url: String){
        navigate().to(url)
    }

    fun WebDriver.finish(){
        close()
        quit()
    }

}

