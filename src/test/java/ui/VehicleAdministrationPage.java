package ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.annotations.findby.How;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;


import static utilities.WebElementLocators.*;
import static utilities.DataItem.*;
import static utilities.WebComponentHelper.setValue;

@At("app-url*")
public class VehicleAdministrationPage extends PageObject {

    @FindBy(how = How.CSS, using        = "#textfieldLocation") WebElementFacade textfieldStreetName;
    @FindBy(how = How.CSS, using        = "#textfieldDescription") WebElementFacade description;

    public void captureGroupDetails() {
        populate_group_name(TEST_DATA_VEHICLE_GROUP_NAME);
        populate_group_description(TEST_DATA_GROUP_DESCRIPTION);
        element(new By.ByCssSelector(CREATE_VEHICLE_GROUP_BUTTON)).click();
    }

    private void populate_group_name(String groupName){
        setValue(textfieldStreetName , groupName);
    }

    private void populate_group_description(String groupDescription){
        setValue(description, groupDescription);
    }
}
