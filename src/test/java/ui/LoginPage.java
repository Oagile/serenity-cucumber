package ui;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;

import org.openqa.selenium.By;

import static utilities.TestDataProperty.getPassword;
import static utilities.WebComponentHelper.selectItem;
import static utilities.WebComponentHelper.setValue;
import static utilities.WebElementLocators.*;

@DefaultUrl("app-url")
public class LoginPage extends PageObject
{
    @WhenPageOpens
    public void waitUntilSGATEisFullyLoaded() {
        $(LOGIN_BUTTON).waitUntilVisible();
    }

    public void loginToTDA (String username , String languagePreference) {
        open();
        getDriver().manage().window().maximize();
        populate_username(username);
        populate_password(getPassword());
        populate_language(languagePreference);
    }

    private void populate_username(String user){
        setValue($(By.name(USER)), user);
    }

    private void populate_password(String user_password){
        setValue($(By.name(PASSWORD)), user_password);
    }

    private void populate_language(String user_language){
        selectItem($(By.name(LANGUAGE_SELECTION)) , user_language);
    }

    public void userClicksLoginButton() {
        $(LOGIN_BUTTON).click();
    }
}
