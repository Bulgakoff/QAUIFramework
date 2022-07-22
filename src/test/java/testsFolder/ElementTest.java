package testsFolder;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pagesLocators.CheckBoxPage;
import pagesLocators.RadioButtonPage;
import pagesLocators.TextBoxPage;
import resources.BasePage;

import java.io.IOException;
import java.util.List;

public class ElementTest extends BasePage {
//    private WebDriverWait wait;
    public WebDriver driver;
    TextBoxPage txp;
    CheckBoxPage chp;
    RadioButtonPage rbp;


    @BeforeTest
    public void initilizing() throws IOException {
        driver = initilizeDriver();
    }


    @Test
    public void testPage() throws InterruptedException, IOException {
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
//        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
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
//        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        driver.get("https://demoqa.com/checkbox");
        chp = new CheckBoxPage(driver);

        chp.openAllPageElements();
        Thread.sleep(1000);
        List<WebElement> list = chp.getITEM_LIST();
        chp.getRandomCheckBox(list);
        String[] inputCheckBox = chp.getCheckedItemsList();
        String[] outputCheckBox = chp.getOutputResultList();
        Assert.assertEquals(inputCheckBox,outputCheckBox,"chrckboxes have not been selected");
    }
    @Test
    public void testRadioButtinPage() {
        driver.get("https://demoqa.com/radio-button");
        rbp = new RadioButtonPage(driver);
        rbp.clickOnRadioButton("y");
        String outYes = rbp.getSuccessWordOutResults();
        rbp.clickOnRadioButton("i");
        String outImpressive = rbp.getSuccessWordOutResults();
        rbp.clickOnRadioButton("no");
        String outNo = rbp.getSuccessWordOutResults();
        Assert.assertEquals(outYes,"Yes","Yes have not been selected");
        Assert.assertEquals(outImpressive,"Impressive", "Impressive have not been selected");
        Assert.assertEquals(outNo,"No", "No have not been selected");

    }

    @AfterTest
    public void tearDown() {
        driver.close();
        driver = null;
    }


}
