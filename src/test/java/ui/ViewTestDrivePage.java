package ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import utilities.WebComponentHelper;

import static utilities.WebComponentHelper.setValue;
import static utilities.WebElementLocators.*;

public class ViewTestDrivePage extends PageObject {

    WebComponentHelper webComponentHelper;
    TestDriveApplicationPage testDriveApplicationPage;

    public String getBookingStatus(){
        waitForAngularRequestsToFinish();
        return waitFor( (WebElementFacade) $(By.cssSelector(TEST_DRIVE_STATUS))).getText();
    }

    public void cancelTestDriveAppointment() {
        waitForAngularRequestsToFinish();
        testDriveApplicationPage.clickTestDriveApplicationButton(CANCEL_TEST_DRIVE);
        setValue($(By.className(GRP_LAYOUT_CONTAINER_WHITE)).then().find(By.id(CANCELLATION_REASON)), "Testing");
        testDriveApplicationPage.clickTestDriveApplicationButton(CONFIRM_CANCEL);
        webComponentHelper.closeMessageBanner();
    }

    public void updateTestDriveAppointment() {
        clickEditAppointment();
        waitForAngularRequestsToFinish();
        waitFor((WebElementFacade) $(By.linkText(SWITCH_TO_TIMESLOT_VIEW))).click();
        WebElementFacade webElementFacade = $(By.className(SHOW_ALL));
        webComponentHelper.scrollWebElementIntoView(webElementFacade);
        testDriveApplicationPage.selectTestDriveTimeSlot();
        testDriveApplicationPage.clickTestDriveApplicationButton(SAVE);
        waitForAngularRequestsToFinish();
        testDriveApplicationPage.clickTestDriveApplicationButton(OK_BUTTON);
        webComponentHelper.closeMessageBanner();
    }


    private void clickEditAppointment (){


        for(WebElementFacade elementFacade : findAll(By.className(ACTION_BUTTONS))){

            System.out.println("============ " + elementFacade.then().find(By.tagName(A_TAG)).getAttribute(TITLE));
  /*          WebElementFacade button = elementFacade.then().find(By.tagName(A_TAG));
            if(button.getAttribute(TITLE).contains(CHANGE_APPOINTMENT)){
               button.click();
            }*/
        }
    }

    private WebElementFacade getAppointmentElement(){
        WebElementFacade webElementFacade = null;

        for(WebElementFacade elementFacade : findAll(By.className(GROUP_COLUMNS))   ){
            WebElementFacade webElementFacade1 = elementFacade.find(By.className(GROUP_COLUMNS_HEADING));
            String title = webElementFacade1.then().getAttribute(TITLE);
            System.out.println(" title : " + title);
            if(title.contains(APPOINTMENT)){
                webElementFacade = elementFacade;
            }
        }
        return webElementFacade;
    }
}
