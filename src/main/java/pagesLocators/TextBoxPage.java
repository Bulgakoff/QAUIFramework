package pagesLocators;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import resources.BasePage;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TextBoxPage extends BasePage {
    //attributes Class:
    //locators for  field:
    public WebDriver driver;
    private By FULL_NAME = By.cssSelector("input[placeholder*='Full']");
    private By EMAIL = By.cssSelector("input[placeholder*='name@']");
    private By CURRENT_ADDRESS = By.cssSelector("textarea[placeholder*='Current']");
    private By Permanent_Address = By.cssSelector("textarea[id*='permanentAddress']");
    private By SUBMIT_BUTTON = By.cssSelector("button[id*='submit']");
    //created form field:
    private By CREATED_FULL_NAME = By.cssSelector("p[id*='name']");
    private By CREATED_EMAIL = By.cssSelector("p[id*='email']");
    private By CREATED_CURRENT_ADDRESS = By.cssSelector("p[id*='currentAddress']");
    private By CREATED_Permanent_Address = By.cssSelector("p[id*='permanentAddress']");

    //constructor:
    public TextBoxPage(WebDriver driver) {
        this.driver = driver;
    }

    //methods class getters:
    public WebElement getFULL_NAME() {
        return driver.findElement(FULL_NAME);
    }

    public WebElement getEMAIL() {
        return driver.findElement(EMAIL);
    }

    public WebElement getCURRENT_ADDRESS() {
        return driver.findElement(CURRENT_ADDRESS);
    }

    public WebElement getPermanent_Address() {
        return driver.findElement(Permanent_Address);
    }

    public WebElement getSUBMIT_BUTTON() {
        return driver.findElement(SUBMIT_BUTTON);
    }

    public WebElement getCREATED_FULL_NAME() {
        return driver.findElement(CREATED_FULL_NAME);
    }

    public WebElement getCREATED_EMAIL() {
        return driver.findElement(CREATED_EMAIL);
    }

    public WebElement getCREATED_CURRENT_ADDRESS() {
        return driver.findElement(CREATED_CURRENT_ADDRESS);
    }

    public WebElement getCREATED_Permanent_Address() {
        return driver.findElement(CREATED_Permanent_Address);
    }

    //others methods:
    public List<String> fillAllFieldsApi() throws InterruptedException {
        // Настройка языка, регион
        Locale locale = new Locale("ru", "RU");
        // Создать объект
        Faker faker = new Faker(locale);
        List<String> lstEnteredValues = new ArrayList<>();

        String fullName = faker.name().fullName();
        String email = "faker@email.ru";
        String currentAddress = faker.address().fullAddress();
        String permanentAddress = faker.address().fullAddress();
        lstEnteredValues.add(fullName);
        lstEnteredValues.add(email);
        lstEnteredValues.add(currentAddress);
        lstEnteredValues.add(permanentAddress);


        this.getFULL_NAME().sendKeys(fullName);
        this.getEMAIL().sendKeys(email);
        this.getCURRENT_ADDRESS().sendKeys(currentAddress);
        this.getPermanent_Address().sendKeys(permanentAddress);
        this.getSUBMIT_BUTTON().click();
        Thread.sleep(5000);

        return lstEnteredValues;

    }

    public List<String> verifyFilledFormsValues() {
        List<String> lstvVerifiedVals = new ArrayList<>();
        lstvVerifiedVals.add(super.splitByСolonTakeSecondElement(super.elementIsVisible(CREATED_FULL_NAME).getText()));
        lstvVerifiedVals.add(super.splitByСolonTakeSecondElement(super.elementIsVisible(CREATED_EMAIL).getText()));
        lstvVerifiedVals.add(super.splitByСolonTakeSecondElement(super.elementIsVisible(CREATED_CURRENT_ADDRESS).getText()));
        lstvVerifiedVals.add(super.splitByСolonTakeSecondElement(super.elementIsVisible(CREATED_Permanent_Address).getText()));

        return lstvVerifiedVals;
    }

    public String compareSubmitAndReceivedData(List<String> lstEnteredValues, List<String> lstvVerifiedVals) {
        if (lstEnteredValues.size() == lstvVerifiedVals.size()) {
            for (int i = 0; i < lstEnteredValues.size(); i++) {
                if (lstEnteredValues.get(i).equals(lstvVerifiedVals.get(i))) {
                    System.out.println(lstEnteredValues.get(i)+" Равно "+lstvVerifiedVals.get(i));
                } else {
                    System.out.println(lstEnteredValues.get(i)+" NO equal "+lstvVerifiedVals.get(i));
                    return "Yes";
                }
            }
        }
        return null;
    }


}
