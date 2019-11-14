package esseex.glue;

import cucumber.api.java.en.Given;
import ui.TestDriveLandingPage;

public class OutletHomePageSteps
{
    TestDriveLandingPage testDriveLandingPage;

    @Given("^user is on Outlet landingPage$")
    public void userIsOnOutletLandingPage() throws Throwable
    {
        testDriveLandingPage.userIsOnOutletHomePage();
    }
}
