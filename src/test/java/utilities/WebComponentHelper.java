package utilities;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import static utilities.WebElementLocators.*;


public class WebComponentHelper extends PageObject {

    public static void selectItem(WebElement element , String itemToSelect)
    {
        element.click();
        Select dropdown= new Select(element);
        dropdown.selectByVisibleText(itemToSelect);
    }

    public static void setValue (WebElementFacade webElementFacade, String val)
    {
        webElementFacade.sendKeys(val);
    }

    public void scrollWebElementIntoView(WebElementFacade webElementFacade) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", webElementFacade);
        waitFor(webElementFacade);
    }

    public void closeMessageBanner(){
        $(net.serenitybdd.core.annotations.findby.By.cssSelector(MESSAGE_BANNER)).then().findBy(net.serenitybdd.core.annotations.findby.By.className(TOASTER_CLOSE)).click();
    }

    public void sendDownArrowAndEnter (){
        Actions action = new Actions(getDriver());
        action.sendKeys(Keys.DOWN).build().perform();
        action.sendKeys(Keys.ENTER).build().perform();
    }


    public static WebElementFacade selectItemFromTDADropdown(WebElementFacade webElementFacade, String itemToSelect)
    {
        webElementFacade.click();
        for (WebElementFacade item : webElementFacade.then().findBy(By.className(GROUP_DROPDOWN_ITEMS))
                                    .thenFindAll(By.tagName(A_TAG))) {
            if (item.getText().trim().contentEquals(itemToSelect)) {
                return item;
            }
        }
        return null;
    }

    public void maximizePage() {
        getDriver().manage().window().maximize();
    }

}
