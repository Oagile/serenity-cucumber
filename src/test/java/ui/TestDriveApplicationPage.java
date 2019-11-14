package ui;

import com.paulhammant.ngwebdriver.ByAngularRepeater;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import utilities.Constants;
import utilities.NavigationMenu;

import static utilities.NavigationMenu.tdaMenu.BOOKINGS;
import static utilities.NavigationMenu.tdaMenu.VEHICLE_ADMINISTRATION;
import static utilities.WebElementLocators.*;

public class TestDriveApplicationPage extends PageObject {
    VehiclePage vehiclePage;
    NavigationMenu tda_menu;
    DriverDetailsPage driverDetailsPage;
    ListVehiclePage listVehiclePage;

    public void userSelectItemFromTestDriveApplicationMenuItems(String item) {
        waitFor((WebElementFacade) $(By.className(DESKTOP_FLY_OUT_AREA)));
        for (WebElementFacade elementFacade :   $(By.className(DESKTOP_FLY_OUT_AREA))
                                                .thenFindAll(By.tagName(LIST_TAG))) {

            if (elementFacade.getText().equalsIgnoreCase(item)) {
                elementFacade.findBy(By.tagName(A_TAG)).click();
                return;
            }
        }
    }

    private String getMenu(String menuItemToClick) {

        switch (menuItemToClick.toLowerCase().trim())
        {
                case Constants.VEHICLE_ADMINISTRATION_MENU :
                        tda_menu = new NavigationMenu(VEHICLE_ADMINISTRATION);
                        return tda_menu.getMenuItemToClick();

                case Constants.BOOKINGS_MENU:
                        tda_menu = new NavigationMenu(BOOKINGS);
                        return tda_menu.getMenuItemToClick();
        }
        return null;
    }


    public void userClicksClickTestDriveApplicationMenu(String menuItemToClick) {
        waitForAngularRequestsToFinish();
        String item = getMenu(menuItemToClick);
        waitFor((WebElementFacade) $(By.className(item))).waitUntilVisible().click();
    }


    public void completeTestDriveAppointment() {
        listVehiclePage.userSelectVehicleOfInterest().click();
        vehiclePage.clickBookTestDriveButton();
        selectTestDriveTimeSlot();
        driverDetailsPage.populateDriverDetails();
        driverDetailsPage.captureAddress();
        driverDetailsPage.captureCommunication();
        driverDetailsPage.continueWithBooking();
        waitFor((WebElementFacade) $(By.xpath(CONFIRM_BOOKING))).click();
        waitForAngularRequestsToFinish();
        clickTestDriveApplicationButton(OK_BUTTON);
    }

    public void selectTestDriveTimeSlot() {
        waitForAngularRequestsToFinish();
        if(!$(new ByAngularRepeater(ROOT_SELECTOR, TIME_SLOTS_REPEATER, true)).isVisible()){
            show_me_next_week();
        }
        waitFor((WebElementFacade) $(new ByAngularRepeater(ROOT_SELECTOR, TIME_SLOTS_REPEATER, true))).waitUntilVisible().click();
        waitForAngularRequestsToFinish();
    }

    private void show_me_next_week() {
        waitFor((WebElementFacade) $(By.className(TIMELINE_ARROW_CONTROLS)).then().find(By.className(SHOW_ME_NEXT))).click();
        waitForAngularRequestsToFinish();
    }

    public void selectBookTestDriveFromMenu(){
        $(By.partialLinkText(Constants.BOOK_TEST_DRIVE)).waitUntilVisible().click();
    }

    public void clickTestDriveApplicationButton(String buttonToClick){
        for(WebElementFacade webElementFacade : findAll(By.className(GROUP_BUTTONS))) {
            if(webElementFacade.isVisible()) {
                if(webElementFacade.getText().toLowerCase().contains(buttonToClick.toLowerCase())) {
                    waitFor(webElementFacade).click();
                    break;
                }
            }
        }
    }

}
