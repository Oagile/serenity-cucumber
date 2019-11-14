package ui;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.annotations.findby.How;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import utilities.WebComponentHelper;

import static utilities.DataItem.*;
import static utilities.WebComponentHelper.setValue;
import static utilities.WebElementLocators.*;

public class DriverDetailsPage extends PageObject {


    @FindBy(how = How.NAME,     using =  "textfieldFirstName") WebElementFacade textfieldFirstName;
    @FindBy(how = How.NAME,     using =  "textfieldSurname")  WebElementFacade textfieldSurname;
    @FindBy(how = How.NAME,     using =  "textfieldStreetName") WebElementFacade textfieldStreetName;
    @FindBy(how = How.NAME,     using =  "textfieldStreetAddOn") WebElementFacade textfieldStreetAddOn;
    @FindBy(how = How.NAME,     using =  "textfieldZipCode") WebElementFacade textfieldZipCode;
    @FindBy(how = How.NAME,     using =  "textfieldState")   WebElementFacade textfieldState;
    @FindBy(how = How.NAME,     using =  "textfieldCity")   WebElementFacade textfieldCity;
    @FindBy(how = How.NAME,     using =  "textfieldEmail") WebElementFacade textfieldEmail;
    @FindBy(how = How.NAME,     using =  "textfieldPhone")   WebElementFacade textfieldPhone;
    @FindBy(how = How.NAME,     using =  "textfieldCellPhone")   WebElementFacade textfieldCellPhone;
    @FindBy(how = How.XPATH,    using =  "//a[@title='Continue']") WebElementFacade continueButton;

    WebComponentHelper webComponentHelper;

    public void populateDriverDetails() {
        setValue(textfieldFirstName , TEST_DATA_FIRST_NAME);
        setValue(textfieldSurname , TEST_DATA_LAST_NAME);
    }

    public void captureAddress()
    {
        setValue( textfieldStreetName, TEST_DATA_STREET_AND_NUMBER);
        setValue( textfieldStreetAddOn, TEST_DATA_STREET);
        setValue( textfieldZipCode, TEST_DATA_ZIP_CODE);
        setValue( textfieldState, TEST_DATA_STATE);
        setValue( textfieldCity, TEST_DATA_CITY);
    }

    public void captureCommunication()
    {
        setValue( textfieldEmail, TEST_DATA_EMAIL);
        $(By.cssSelector(CORRESPONDENCE_LANGUAGE )).click();
        webComponentHelper.sendDownArrowAndEnter();
        setValue( textfieldPhone, TEST_DATA_PHONE );
        setValue( textfieldCellPhone, TEST_DATA_CELLPHONE );
    }

    public void continueWithBooking()
    {
        continueButton.click();
    }


}
