package ui;


import com.paulhammant.ngwebdriver.ByAngularModel;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import static utilities.DataItem.*;
import static utilities.MenuItems.CREATE_VEHICLE;

import static utilities.WebComponentHelper.selectItemFromTDADropdown;
import static utilities.WebComponentHelper.setValue;
import static utilities.WebElementLocators.*;

public class VehiclePage extends PageObject {

    @ByAngularModel.FindBy(model   = "VehicleCreateCtrl.manual.vin17")   WebElementFacade vin17;
    @ByAngularModel.FindBy(model    = "VehicleCreateCtrl.manual.modelName")   WebElementFacade modelName;
    @ByAngularModel.FindBy(model    = "VehicleCreateCtrl.manual.brand")   WebElementFacade brand;
    @ByAngularModel.FindBy(model    = "VehicleCreateCtrl.manual.productType") WebElementFacade productType;
    @ByAngularModel.FindBy(model    = "VehicleCreateCtrl.manual.vehicleGroupId") WebElementFacade vehicleGroupId;

    public void populateVehicleDetails() {
        waitForAngularRequestsToFinish();
        click_manually_create_vehicle();
        populate_vin();
        select_vehicle_brand();
        populate_model();
        select_product_type();
        populate_licence_plate();
        select_vehicle_group();
        click_create_vehicle();

    }

    private void click_create_vehicle(){
        $(By.name(CREATE_MANUAL_FORM)).then().findBy(new By.ByCssSelector(CREATE_VEHICLE_GROUP_BUTTON)).click();
        $(By.cssSelector(MESSAGE_BANNER)).then().findBy(By.className(TOASTER_CLOSE)).click();
    }
    private void select_vehicle_group() {
        waitFor((WebElementFacade) vehicleGroupId.then(By.name(VEHICLE_GROUP)));
        selectItemFromTDADropdown(vehicleGroupId.then(By.name(VEHICLE_GROUP)), TEST_DATA_VEHICLE_GROUP_NAME).click();
    }

    private void populate_licence_plate() {
        setValue(element(By.xpath(LICENCE_PLATE)), TEST_DATA_LICENSE_PLATE);
    }

    private void select_product_type() {
        selectItemFromTDADropdown(productType.then(By.name(PRODUCT_TYPE)),TEST_DATA_PROD_TYPE).click();
    }

    private void populate_model() {
        setValue(modelName, TEST_DATA_MODEL);
    }

    private void select_vehicle_brand() {
        selectItemFromTDADropdown( brand.then(By.name(BRAND)), TEST_DATA_BRAND_NAME).click();
    }

    private void populate_vin() {
        setValue(vin17 , TEST_DATA_VIN);
    }

    private void click_manually_create_vehicle() {
        selectItemFromTestDriveAppMenuGrid(element(By.className(GRP_AREA_COMPANY)),  CREATE_VEHICLE);
        selectFromTab(MANUAL).waitUntilClickable().click();
        waitForAngularRequestsToFinish();
    }

    private WebElementFacade selectFromTab(String tabName) {
        WebElementFacade webElementFacade = null;
        for (WebElementFacade tab : $(By.className(TABS))
                                    .thenFindAll(By.tagName(LIST_TAG))) {
            if (tab.getText().toLowerCase().contains(tabName)) {
                webElementFacade = tab;
                break;
            }
        }
        return webElementFacade;
    }

    public void selectItemFromTestDriveAppMenuGrid(WebElementFacade elementFacade, String menuItemToSelect) {

        elementFacade.waitUntilVisible().click();
        waitFor((WebElementFacade) $(By.className(MENU_ITEMS_CONTAINER)));

        for (WebElementFacade webElementFacade  :    $(By.className(MENU_ITEMS_CONTAINER))
                                                     .thenFindAll(By.tagName(LIST_TAG))) {

            if(webElementFacade.getText().equalsIgnoreCase(menuItemToSelect)) {
                  webElementFacade.then().findBy(By.tagName(A_TAG)).waitUntilClickable().click();
                return;
            }
        }
    }

    public void clickBookTestDriveButton() {
        waitFor((WebElementFacade) $(By.className(VEHICLE_DETAILS)));
        $(By.className(VEHICLE_DETAILS)).then().findBy(By.className(BOOK_TEST_DRIVE)).click();
        waitForAngularRequestsToFinish();
        waitFor((WebElementFacade) $(By.linkText(SWITCH_TO_TIMESLOT_VIEW))).click();
        waitForAngularRequestsToFinish();
    }
}
