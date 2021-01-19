package pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class SubmittedFormFactory(
        driver: WebDriver
) {

    @FindBy(id = "example-modal-sizes-title-lg")
    lateinit var tableHeader: WebElement

    init {
        PageFactory.initElements(driver, this)
    }

    fun checkTableIsDisplayed() = tableHeader.isDisplayed

}