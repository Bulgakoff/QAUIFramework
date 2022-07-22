package testsFolder;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pagesLocators.CheckBoxPage;
import pagesLocators.TextBoxPage;
import resources.BasePage;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class ElementTest extends BasePage {
    private WebDriverWait wait;
    public WebDriver driver;
    TextBoxPage txp;
    CheckBoxPage chp;


    @BeforeTest
    public void initilizing() throws IOException {
        driver = initilizeDriver();
    }


    @Test
    public void testPage() throws InterruptedException, IOException {
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        driver.get(properties.getProperty("url"));
        txp = new TextBoxPage(driver);

        List<String> filledValueLst = txp.fillAllFieldsApi();
        makeScreenshot();
        List<String> lstVerifiedVals = txp.verifyFilledFormsValues();
        String egg = txp.compareSubmitAndReceivedData(filledValueLst, lstVerifiedVals);
        Assert.assertEquals(egg, null, "There is mismatch");
    }

    @Test
    public void testCheckPage() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        driver.get("https://demoqa.com/checkbox");
        chp = new CheckBoxPage(driver);

        chp.openAllPageElements();
        Thread.sleep(1000);
        List<WebElement> list = chp.getITEM_LIST();
        chp.getRandomCheckBox(list);
        String[] inputCheckBox = chp.getCheckedItemsList();
        String[] outputCheckBox = chp.getOutputResultList();
        System.out.println(inputCheckBox);
        System.out.println(outputCheckBox);
        Assert.assertEquals(inputCheckBox,outputCheckBox);
    }

    @AfterTest
    public void tearDown() {

        driver.close();
        driver = null;
    }


}
