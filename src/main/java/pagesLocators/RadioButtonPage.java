package pagesLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import resources.BasePage;

import java.util.HashMap;
import java.util.List;

public class RadioButtonPage extends BasePage {
    //attributes Class: locators for  field:
    public WebDriver driver;
    private By RADIO_YES = By.cssSelector("label[for='yesRadio']");
    private By RADIO_Impressive = By.cssSelector("label[for='impressiveRadio']");
    private By RADIO_noRadio = By.cssSelector("label[for='noRadio']");

    private By RADIO_LIST = By.cssSelector("input[type='radio']");//3


    private By SUCCESS_MESSAGE = By.cssSelector("span[class='text-success']");

    //constructor:
    public RadioButtonPage(WebDriver driver) {
        this.driver = driver;
    }
    //methods class getters:
    public WebElement getRADIO_YES() {
        return this.elementIsPresent(RADIO_YES);
    }

    public WebElement getRADIO_Impressive() {
        return this.elementIsPresent(RADIO_Impressive);
    }

    public WebElement getRADIO_noRadio() {
        return this.elementIsPresent(RADIO_noRadio);
    }

    public WebElement getSUCCESS_MESSAGE() {
        return this.elementIsPresent(SUCCESS_MESSAGE);
    }

    public List<WebElement> getRADIO_LIST() {
        return this.elementArePresent(RADIO_LIST);
    }

    //others methods:
    public String getYesWord() {
        String messageYes = this.getRADIO_YES().getText();
        System.out.println(messageYes);
        return messageYes;
    }
    public String getSuccessWordOutResults() {
        String messageSuccess = this.getSUCCESS_MESSAGE().getText();
//        System.out.println(messageSuccess);
        return messageSuccess;
    }

    public void clickOnRadioButton(String choice) {
        HashMap<String, By> hmChoices = new HashMap<>();
        hmChoices.put("y", this.RADIO_YES);
        hmChoices.put("i", this.RADIO_Impressive);
        hmChoices.put("no", this.RADIO_noRadio);
        this.elementIsVisible(hmChoices.get(choice)).click();
    }
}
