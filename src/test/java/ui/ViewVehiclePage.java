package ui;

import com.paulhammant.ngwebdriver.ByAngularRepeater;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.JavascriptExecutor;

import static utilities.Constants.GROUP_ASSIGNMENTS;
import static utilities.WebElementLocators.*;

public class ViewVehiclePage extends PageObject {

    public boolean isViewVehiclePageDisplayed(){
        waitForAngularRequestsToFinish();
        return $(new ByAngularRepeater(ROOT_SELECTOR, TABS_REPEATER, true)).isDisplayed();
    }


    public void removeVehicleGroupAssociation (){
        getTab(GROUP_ASSIGNMENTS).waitUntilClickable().click();
        waitFor((WebElementFacade) $(new ByAngularRepeater(ROOT_SELECTOR, TABS_REPEATER, true))).waitUntilVisible();
        ((JavascriptExecutor) getDriver()).executeScript(DELETE_VEHICLE_GROUP_ASSOCIATION);
        confirmAssociationDeletion();
        waitForAbsenceOf(MESSAGE_BANNER);
    }

    private WebElementFacade getTab(String tabName){
        $(new ByAngularRepeater(ROOT_SELECTOR, TABS_REPEATER, true)).waitUntilVisible();
        WebElementFacade webElementFacade = null;
        for(WebElementFacade tab : findAll(new ByAngularRepeater(ROOT_SELECTOR, TABS_REPEATER, true))){
            if(tab.getText().contains(tabName)){
                webElementFacade = tab;
                break;
            }
        }
        return webElementFacade;
    }


    public void deleteVehicleFromTestDriveApp(){
        waitFor((WebElementFacade) $(By.cssSelector(DELETE_VEHICLE))).click();
        confirmAssociationDeletion();
        waitForAbsenceOf(MESSAGE_BANNER);
    }

    private void confirmAssociationDeletion(){
        for(WebElementFacade webElementFacade :  $(By.className(DIALOG_CONTENT))
                                                 .thenFindAll(By.tagName(BUTTON_TAG))){
            if(webElementFacade.getText().contentEquals(OK_BUTTON)) {
                webElementFacade.click();
                return;
            }
        }
    }
}
