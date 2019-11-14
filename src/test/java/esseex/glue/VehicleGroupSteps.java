package esseex.glue;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import ui.*;

import static utilities.Constants.*;
import static utilities.DataItem.*;


public class VehicleGroupSteps {

    VehicleAdministrationPage vehicleAdministrationPage;
    TestDriveLandingPage testDriveLandingPage;
    ViewVehicleGroupPage viewVehicleGroupPage;
    TestDriveApplicationPage testDriveApplicationPage;
    ViewVehiclePage viewVehiclePage;

    @When("^the user navigates to \"([^\"]*)\" menu-tab and select \"([^\"]*)\"$")
    public void theUserNavigatesToTabAndSelect(String tdaMenu, String menuItemToSelect) {
        testDriveApplicationPage.userClicksClickTestDriveApplicationMenu(tdaMenu);

        if (menuItemToSelect.contains(BOOK_TEST_DRIVE))
            testDriveApplicationPage.selectBookTestDriveFromMenu();
         else
            testDriveApplicationPage.userSelectItemFromTestDriveApplicationMenuItems(menuItemToSelect);
    }


    @When("^the user captures group details and click create group$")
    public void userEntersGroupDetails() {
        vehicleAdministrationPage.captureGroupDetails();
    }

    @Then("^vehicle group is created$")
    public void vehicleGroupIsCreated() {
        testDriveApplicationPage.userClicksClickTestDriveApplicationMenu(VEHICLE_ADMINISTRATION_MENU);
    }

    @Given("^the user selects outlet of interest$")
    public void userHasSelectedOutlet() {
        testDriveLandingPage.selectOutlet(TEST_DATA_OUTLET);
    }

    @Then("^the vehicle group must exist from list of groups$")
    public void theVehicleGroupMustExistFromListOfGroups()
    {
        testDriveApplicationPage.userClicksClickTestDriveApplicationMenu(VEHICLE_ADMINISTRATION_MENU);
        testDriveApplicationPage.userSelectItemFromTestDriveApplicationMenuItems(SHOW_VEHICLE_GROUPS);
        Assert.assertTrue(viewVehicleGroupPage.getVehicleGroup(TEST_DATA_VEHICLE_GROUP_NAME).isDisplayed());
    }

    @Then("^the user removes group and vehicle association$")
    public void theUserRemovesGroupAndVehicleAssociation(){
        Assert.assertTrue(viewVehiclePage.isViewVehiclePageDisplayed());
        viewVehiclePage.removeVehicleGroupAssociation();

    }

    @Then("^the user deletes vehicle group$")
    public void theUserDeletesVehicleGroup() {
        viewVehicleGroupPage.deleteVehicleGroup(TEST_DATA_VEHICLE_GROUP_NAME);
    }


    @Then("^vehicle groups page must be displayed$")
    public void vehicleGroupsPageMustBeDisplayed()  {
        Assert.assertTrue(viewVehicleGroupPage.isVehiclePageDisplayed());
    }
}
