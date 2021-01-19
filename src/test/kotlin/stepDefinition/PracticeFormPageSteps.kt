package stepDefinition

import constants.Drivers
import constants.Gender
import io.cucumber.java.After
import io.cucumber.java.Before
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.openqa.selenium.WebDriver
import pages.FormPageFactory
import pages.SubmittedFormFactory
import stepDefinition.baseSteps.Driver
import stepDefinition.baseSteps.DriverSteps
import java.lang.AssertionError


class PracticeFormPageSteps: DriverSteps() {

    lateinit var webDriver: WebDriver

    lateinit var formPageFactory: FormPageFactory
    lateinit var submittedFormFactory: SubmittedFormFactory

    @Before
    fun setup(){
        webDriver = retrieveWebDriver(Drivers.Chrome)

        formPageFactory = FormPageFactory(webDriver)
        submittedFormFactory = SubmittedFormFactory(webDriver)
    }

    @After
    fun tearDown(){
        webDriver.finish()
    }

    @Given("user is on practice form")
    fun user_is_on_practice_form() {
        webDriver.launchUrl("https://demoqa.com/automation-practice-form")
    }

    @When("user enters first name {string} and last name {string}")
    fun user_enters_first_name_and_last_name(firstName: String?, lastName: String?) {
        formPageFactory.apply {
            firstName?.let { enterFirstName(it) }
            lastName?.let { enterLastName(it) }
        }
    }

    @When("user selects gender \"([^\"]*)\"$")
    fun user_selects_gender(gender: Gender?) {
        gender?.let { formPageFactory.selectGender(it) }
    }

    @When("user enters email address {string}")
    fun user_enters_email_address(email: String?) {
        email?.let { formPageFactory.enterEmailAddress(it) }
    }

    @When("user enters mobile number {string}")
    fun user_enters_mobile_number(mobile: String?) {
        mobile?.let { formPageFactory.enterMobileNumber(it) }
    }

    @When("user clicks submit button")
    fun user_clicks_submit_button() {
        formPageFactory.submit()
    }

    @Then("pop up is displayed")
    fun pop_up_is_displayed() {
        if(!submittedFormFactory.checkTableIsDisplayed()){
            throw AssertionError("Popup not displayed")
        }
    }

}