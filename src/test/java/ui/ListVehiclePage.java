package ui;

import com.paulhammant.ngwebdriver.ByAngularRepeater;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.annotations.findby.How;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;

import static utilities.DataItem.TEST_DATA_VIN;
import static utilities.WebComponentHelper.setValue;
import static utilities.WebElementLocators.*;

public class ListVehiclePage extends PageObject {

    @FindBy(how = How.ID, using         = "frmsearchbox1") WebElementFacade searchVehicleUsingVin;
    @FindBy(how = How.CLASS_NAME, using = "vehicle-search-button") WebElementFacade searchVehicleButton;


    public boolean isListVehiclesPageDisplayed(){
        return waitForAnyRenderedElementOf(By.id(SEARCH_VEHICLE)).isElementVisible(By.id(SEARCH_VEHICLE));
    }

    public WebElementFacade searchVehicleByVin(){
        waitForAngularRequestsToFinish();
        populate_vin_number();
        click_search_vehicle();
        waitForAngularRequestsToFinish();
        return vehicle(TEST_DATA_VIN);
    }

    private WebElementFacade vehicle(String vehicleVin){
        WebElementFacade vehicle = null;
        for(WebElementFacade webElementFacade : findAll(new ByAngularRepeater(ROOT_SELECTOR, DISPLAYED_VEHICLE_REPEATER, true))) {
             for (WebElementFacade webElement : webElementFacade.thenFindAll(new By.ByTagName(TD_TAG))) {
                 if (webElement.getText().contains(vehicleVin)) {
                     vehicle =  $(By.className(VEHICLE_CLASS));
                     break;
                 }
             }
        }
        return vehicle;
    }
    private void click_search_vehicle() {
        searchVehicleButton.click();
    }


    private void populate_vin_number() {
        setValue(searchVehicleUsingVin.then(new By.ByTagName(INPUT_TAG)), TEST_DATA_VIN);
    }

    public WebElement userSelectVehicleOfInterest(){
        waitForAngularRequestsToFinish();

        /* Jady's work in progress
            List<WebElementFacade>  vehicles = findAll(new ByAngularRepeater(ROOT_SELECTOR, BOOKABLE_VEHICLE_REPEATER, true));
            int vehicleCount = vehicles.size()
            int random = (int) (Math.random() * vehicleCount + 0);
            return  findAll(new ByAngularRepeater(ROOT_SELECTOR, BOOKABLE_VEHICLE_REPEATER, true)).get(random);
        */

        return find(new ByAngularRepeater(ROOT_SELECTOR, BOOKABLE_VEHICLE_REPEATER, true));
    }
}
