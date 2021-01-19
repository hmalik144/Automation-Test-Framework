package constants

enum class Drivers(
        val driverProperty: String,
        val driverFileName: String
){
    Chrome("webdriver.chrome.driver", "chromedriver.exe")
}