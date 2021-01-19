package utils

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions

/*
 * Scroll down to a web element
 */
fun WebElement.scrollTo(driver: WebDriver){
    val actions = Actions(driver)
    actions.moveToElement(this)
    actions.perform()
}