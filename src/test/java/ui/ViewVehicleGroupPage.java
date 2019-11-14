package ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import org.openqa.selenium.By;

import static utilities.WebElementLocators.*;


@At("app-url/*")
public class ViewVehicleGroupPage extends PageObject {

    TestDriveApplicationPage testDriveApplicationPage;

    public boolean isVehiclePageDisplayed (){
        waitForAngularRequestsToFinish();
        waitFor((WebElementFacade) $(By.className(VEHICLE_GROUP_TABLES)));
        return $(By.className(VEHICLE_GROUP_TABLES)).isDisplayed();
    }

    public WebElementFacade getVehicleGroup(String vehicleGroupName )
    {
        waitForAngularRequestsToFinish();
        waitFor((WebElementFacade) $(By.className(VEHICLE_GROUP_TABLES)));
        WebElementFacade webElement = null;
        for(WebElementFacade webElementFacade :  $(new By.ByClassName(VEHICLE_GROUP_TABLES))
                                                .thenFindAll(new By.ByClassName(VEHICLE_GROUP_TAG))) {
            if(webElementFacade.getText().trim().equalsIgnoreCase(vehicleGroupName.trim())) {
                webElement = webElementFacade;
                break;
            }
        }
        return webElement;
    }

    public void deleteVehicleGroup(String vehicleGroupName){
        getVehicleGroup(vehicleGroupName).click();
        waitForAngularRequestsToFinish();
        testDriveApplicationPage.clickTestDriveApplicationButton(DELETE_VEHICLE_GROUP);
        waitFor((WebElementFacade) $(By.className(DIALOG_CONTENT)));
        testDriveApplicationPage.clickTestDriveApplicationButton(OK_BUTTON);
        waitForAngularRequestsToFinish();
    }
}

