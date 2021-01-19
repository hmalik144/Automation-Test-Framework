package pages

import constants.Gender
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import utils.scrollTo

class FormPageFactory(
       val driver: WebDriver
){

    @FindBy(id = "firstName")
    lateinit var firstName: WebElement

    @FindBy(id = "lastName")
    lateinit var lastName: WebElement

    @FindBy(id = "userEmail")
    lateinit var userEmail: WebElement

    @FindBy(xpath = "//*[@id=\"genterWrapper\"]/div[2]/div[1]/label")
    lateinit var male: WebElement
    @FindBy(xpath = "//*[@id=\"genterWrapper\"]/div[2]/div[2]/label")
    lateinit var female: WebElement
    @FindBy(xpath = "//*[@id=\"genterWrapper\"]/div[2]/div[3]/label")
    lateinit var other: WebElement

    @FindBy(id = "userNumber")
    lateinit var mobileNumber: WebElement

    @FindBy(xpath = "//*[@id=\"submit\"]")
    lateinit var submit: WebElement

    init {
        PageFactory.initElements(driver, this)
    }


    fun enterFirstName(first: String) = firstName.sendKeys(first)

    fun enterLastName(last: String) = lastName.sendKeys(last)

    fun enterEmailAddress(email: String) = userEmail.sendKeys(email)

    fun selectGender(gender: Gender) = when(gender){
            Gender.Male-> male.click()
            Gender.Female-> female.click()
            Gender.Other-> other.click()
    }

    fun enterMobileNumber(mobile: String) = mobileNumber.sendKeys(mobile)

    fun submit(){

        submit.apply {
            scrollTo(driver)
            click()
        }
    }

}