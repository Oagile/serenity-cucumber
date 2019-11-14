package ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.annotations.findby.How;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.WhenPageOpens;

import static utilities.DataItem.TEST_DATA_BUS_NO;
import static utilities.WebElementLocators.*;


@At("app-url/*")
public class TestDriveLandingPage extends PageObject
{
    @FindBy(how = How.ID, using = "currentOutletLegalEntityName") WebElementFacade currentOutletLegalEntityName;

    @WhenPageOpens
    public void waitForLandingPageToFullyLoad() {
        element(By.className(AREA_HOME)).waitUntilVisible();
    }


    public void selectOutlet(String outletToSelect) {
            waitForAngularRequestsToFinish();
            $(By.className(GROUP_LIST_ITEM)).waitUntilVisible().waitUntilClickable();
            for (WebElementFacade outlet : findAll(By.className(GROUP_LIST_ITEM))) {
                if (outlet.getText().toLowerCase().trim().toLowerCase().contains(outletToSelect.toLowerCase())) {
                    outlet.click();
                    return;
                }
            }

    }

    public void userNavigatesToBookingsTab()
    {
    }

    public void userSelectShowCustomerBookings()
    {
    }

    public void userIsOnOutletHomePage() {
        currentOutletLegalEntityName.click();
        WebElementFacade parentObject = $(OUTLET_SELECTION);
        for (WebElementFacade el : parentObject.thenFindAll(By.className(GROUP_LIST_ITEM))){
            if(el.getText().contains(TEST_DATA_BUS_NO)){
                el.click();
                return;
            }
        }
    }
}
