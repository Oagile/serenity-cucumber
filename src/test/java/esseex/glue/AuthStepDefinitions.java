package esseex.glue;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ui.LoginPage;
import ui.TestDriveLandingPage;
import utilities.WebComponentHelper;

import static utilities.DataItem.*;


public class AuthStepDefinitions {

    LoginPage loginPage;
    TestDriveLandingPage landingPage;
    WebComponentHelper webComponentHelper;

    @Given("^that the user navigates to SGATE homepage on his browser$")
    public void userNavigatesToSGATEHomepageOnHisBrowser() {
        webComponentHelper.maximizePage();
        loginPage.open();
    }

    @When("^the user enters username, Password and language$")
    public void userEntersUsernamePasswordAndLanguage()  {
        loginPage.waitUntilSGATEisFullyLoaded();
        loginPage.loginToTDA(TEST_DATA_USERNAME  , TEST_DATA_PREFERRED_LANGUAGE);
    }

    @When("^the user clicks login$")
    public void userClicksLogin() {
           loginPage.userClicksLoginButton();
    }

    @Then("^the landingPage is displayed and fully loaded$")
    public void landingPageIsDisplayedAndFullyLoaded()
    {
        landingPage.waitForLandingPageToFullyLoad();
    }

    @When("^user navigates to Bookings tab and select show customer bookings$")
    public void userNavigatesToBookingsTabAndSelectShowCustomerBookings() {
        landingPage.userNavigatesToBookingsTab();
        landingPage.userSelectShowCustomerBookings();
    }

    @Given("^user is on landingPage$")
    public void userIsOnLandingPage() {
        landingPage.waitForLandingPageToFullyLoad();
    }
}
