package pagesLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import resources.BasePage;

public class CheckBoxPage extends BasePage {
    //attributes Class:
    public WebDriver driver;
    //locators for  field:
    private By EXPAND_ALL_BUTTON = By.cssSelector("button[title='Expand all']");
    private By ITEM_LIST = By.cssSelector("span[class='rct-title']");


    //constructor:
    public CheckBoxPage(WebDriver driver) {
        this.driver = driver;
    }
    //methods class getters:

    public WebElement getEXPAND_ALL_BUTTON() {
        return driver.findElement(EXPAND_ALL_BUTTON);
    }

    public WebElement getITEM_LIST() {
        return driver.findElement(ITEM_LIST);
    }
    //others methods:
}
