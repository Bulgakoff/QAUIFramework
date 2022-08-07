package pagesLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import resources.BasePage;

public class ButtonsPage extends BasePage {
    //attributes Class:
    public WebDriver driver;
    // locators for  field:
    private By DOUBLE_CLICK_BTN = By.cssSelector("button[id='doubleClickBtn']");
    private By RIGHT_CLICK_BTN = By.cssSelector("button[id='rightClickBtn']");
    private By CLICK_ME_BTN = By.xpath("//button[text()='Click Me']");
    //results:
    private By SUCCESS_DOUBLE = By.cssSelector("p[id='doubleClickMessage']");
    private By SUCCESS_RIGHT = By.cssSelector("p[id='rightClickMessage']");
    private By SUCCESS_CLICK_ME = By.cssSelector("p[id='dynamicClickMessage']");


    //constructor:
    public ButtonsPage(WebDriver driver) {
        this.driver = driver;
    }

    //methods class getters:

    public WebElement getDOUBLE_CLICK_BTN() {
        return elementIsPresent(DOUBLE_CLICK_BTN);
    }

    public WebElement getRIGHT_CLICK_BTN() {
        return elementIsPresent(RIGHT_CLICK_BTN);
    }

    public WebElement getCLICK_ME_BTN() {
        return elementIsPresent(CLICK_ME_BTN);
    }

    //results GETTERS:

    public WebElement getSUCCESS_DOUBLE() {
        return elementIsPresent(SUCCESS_DOUBLE);
    }

    public WebElement getSUCCESS_RIGHT() {
        return elementIsPresent(SUCCESS_RIGHT);
    }

    public WebElement getSUCCESS_CLICK_ME() {
        return elementIsPresent(SUCCESS_CLICK_ME);
    }

    //others methods:
    public String clickOnDifferentBnts(String typeClick) {
        if (typeClick.equals("double")) {
            actionDoubleClick(getDOUBLE_CLICK_BTN());
            return checkClickedText(getSUCCESS_DOUBLE());
        }
        if (typeClick.equals("right")) {
            actionRightClick(getRIGHT_CLICK_BTN());
            return checkClickedText(getSUCCESS_RIGHT());
        }
        if (typeClick.equals("click")) {
            actionSimpleClick(getCLICK_ME_BTN());
            return checkClickedText(getSUCCESS_CLICK_ME());
        }
        return typeClick;
    }
    public String checkClickedText(WebElement element) {
        return element.getText();
    }



}
