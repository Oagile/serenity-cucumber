package ui;

import com.paulhammant.ngwebdriver.ByAngularRepeater;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.annotations.findby.How;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import static utilities.DataItem.TEST_DATA_VIN;
import static utilities.WebComponentHelper.setValue;

import static utilities.WebElementLocators.BOOKABLE_VEHICLE_REPEATER;
import static utilities.WebElementLocators.ROOT_SELECTOR;

public class FindYourDesiredVehiclePage extends PageObject {

    @FindBy(how=How.CLASS_NAME, using = "tda-vs__search__general__input")    WebElementFacade testDriveVehicleSelectionCtrl;
    @FindBy(how=How.CLASS_NAME, using = "tda-vs__search__general__btn") WebElementFacade searchVehicle;
    int TIMEOUT_REST = 3000;

    public WebElementFacade findYourDesiredVehicle() {
        testDriveVehicleSelectionCtrl.waitUntilVisible();
        waitForAngularRequestsToFinish();
        setValue(testDriveVehicleSelectionCtrl, TEST_DATA_VIN);
        searchVehicle.click();
        waitABit(TIMEOUT_REST);
        return getBookableVehicle();
    }


    private WebElementFacade getBookableVehicle(){
        return find(new ByAngularRepeater(ROOT_SELECTOR, BOOKABLE_VEHICLE_REPEATER, true));
    }

    public boolean isFindYourDesiredVehiclePageDisplayed(){
        testDriveVehicleSelectionCtrl.waitUntilVisible();
        return testDriveVehicleSelectionCtrl.isDisplayed();
    }
}
