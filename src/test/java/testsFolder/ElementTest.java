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
import pagesLocators.WebTablePage;
import resources.BasePage;

import java.io.IOException;
import java.util.*;

public class ElementTest extends BasePage {
    //    private WebDriverWait wait;
    public WebDriver driver;
    TextBoxPage txp;
    CheckBoxPage chp;
    RadioButtonPage rbp;
    WebTablePage wtp;


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
        Assert.assertEquals(inputCheckBox, outputCheckBox, "chrckboxes have not been selected");
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
        Assert.assertEquals(outYes, "Yes", "Yes have not been selected");
        Assert.assertEquals(outImpressive, "Impressive", "Impressive have not been selected");
        Assert.assertEquals(outNo, "No", "No have not been selected");
    }

    @Test
    public void testWebTablePageAddPerson() throws InterruptedException, IOException {
        driver.get("https://demoqa.com/webtables");
        wtp = new WebTablePage(driver);
        String addNew = wtp.addNewPersonWT();
        List<String> checkNew = wtp.checkNewAddedPeople();
        Assert.assertEquals(addNew, checkNew.get(3));
    }

    @Test
    public void testWebTableSearchPerson() throws InterruptedException {
        driver.get("https://demoqa.com/webtables");
        wtp = new WebTablePage(driver);
        String addNewStr = wtp.addNewPersonWT();
        String keyWord = wtp.convertStringToArrayAndGetRandomItem(addNewStr);
        wtp.searchSomePerson(keyWord);
        String[] arrStr = wtp.checkSearchPerson();
        wtp.convertDataIntoNewArrayCompareSearchWord(arrStr, keyWord);

    }

    @Test
    public void testUpdateWebPerson() throws InterruptedException {
        driver.get("https://demoqa.com/webtables");
        wtp = new WebTablePage(driver);
        String addNewStr = wtp.addNewPersonWT();
        String lastName = wtp.convertStringToArray(addNewStr)[1];
        wtp.searchSomePerson(lastName);
        String age = wtp.updatePersonInfo();
        String[] arr = wtp.convertStringToArray(addNewStr);
        Assert.assertEquals(age, arr[2], "Совпадения не найдено");
    }
    @Test
    public void testDeleteWebPerson() throws InterruptedException {
        driver.get("https://demoqa.com/webtables");
        wtp = new WebTablePage(driver);
        String addNewStr = wtp.addNewPersonWT();
        String email = wtp.convertStringToArray(addNewStr)[3];
        wtp.searchSomePerson(email);
        wtp.deletePersonInfo();
        String text = wtp.checkDeleteText();

        Assert.assertEquals(text, "No rows found", "No matches  No rows found ");

    }
 

    @AfterTest
    public void tearDown() {
        driver.close();
        driver = null;
    }


}
