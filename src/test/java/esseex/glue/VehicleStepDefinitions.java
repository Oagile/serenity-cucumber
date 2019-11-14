package esseex.glue;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import ui.VehiclePage;
import ui.ViewVehiclePage;

public class VehicleStepDefinitions {

    VehiclePage vehiclePage;
    ViewVehiclePage viewVehiclePage;

    @And("^the user manually creates vehicle and assign it to a group$")
    public void userManuallyCreatesVehicleAndAssignItToAGroup() {
        vehiclePage.populateVehicleDetails();
    }


    @Then("^the user deletes a vehicle$")
    public void theUserDeletesAVehicle()  {
        viewVehiclePage.deleteVehicleFromTestDriveApp();
    }
}
