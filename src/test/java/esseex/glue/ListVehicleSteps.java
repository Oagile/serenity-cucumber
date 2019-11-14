package esseex.glue;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import ui.FindYourDesiredVehiclePage;
import ui.ListVehiclePage;


import static org.junit.Assert.assertNotNull;

public class ListVehicleSteps {

    ListVehiclePage listVehiclePage;
    FindYourDesiredVehiclePage findYourDesiredVehiclePage;

    @Then("^the newly created vehicle must be returned when searched from vehicle lookup$")
    public void theNewlyCreatedVehicleMustBeReturnedWhenSearchedFromVehicleLookup() {
        WebElementFacade webElementFacade = listVehiclePage.searchVehicleByVin();
        assertNotNull(webElementFacade);
        webElementFacade.click();
    }

    @Then("^find your list vehicles page must be displayed$")
    public void findYourListVehiclesPageMustBeDisplayed() {
        Assert.assertTrue(listVehiclePage.isListVehiclesPageDisplayed());
    }

    @And("^the user select vehicle of interest for test drive$")
    public void theUserSelectVehicleOfInterestForTestDrive()  {
        listVehiclePage.userSelectVehicleOfInterest();
    }

    @Then("^find your desired vehicles page must be displayed$")
    public void findYourDesiredVehiclesPageMustBeDisplayed(){
        Assert.assertTrue(findYourDesiredVehiclePage.isFindYourDesiredVehiclePageDisplayed());

    }
}
