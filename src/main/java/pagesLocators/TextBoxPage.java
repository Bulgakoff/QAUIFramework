package pagesLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextBoxPage {
    //attributes Class:
    //form field:
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
    public  WebElement getFULL_NAME() {
         return  driver.findElement(FULL_NAME);
    }

    public  WebElement getEMAIL() {
         return  driver.findElement(EMAIL);
    }

    public  WebElement getCURRENT_ADDRESS() {
         return  driver.findElement(CURRENT_ADDRESS);
    }

    public  WebElement getPermanent_Address() {
         return  driver.findElement(Permanent_Address);
    }

    public  WebElement getSUBMIT_BUTTON() {
         return  driver.findElement(SUBMIT_BUTTON);
    }

    public  WebElement getCREATED_FULL_NAME() {
         return  driver.findElement(CREATED_FULL_NAME);
    }

    public  WebElement getCREATED_EMAIL() {
         return  driver.findElement(CREATED_EMAIL);
    }

    public  WebElement getCREATED_CURRENT_ADDRESS() {
         return  driver.findElement(CREATED_CURRENT_ADDRESS);
    }

    public  WebElement getCREATED_Permanent_Address() {
         return  driver.findElement(CREATED_Permanent_Address);
    }
    //others methods:
    public void fillAllFieldsApi() throws InterruptedException {
        this.getFULL_NAME().sendKeys("sa");
        this.getEMAIL().sendKeys("sadf@sdgfs.ru");
        this.getCURRENT_ADDRESS().sendKeys("sadf");
        this.getPermanent_Address().sendKeys("sad");
        this.getSUBMIT_BUTTON().click();
        Thread.sleep(5000);
    }
}
