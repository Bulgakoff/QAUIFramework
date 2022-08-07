package testsFolder;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pagesLocators.*;
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
    ButtonsPage btnP;


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
    public void testWebTableUpdateWebPerson() throws InterruptedException {
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
    public void testWebTableDeleteWebPerson() throws InterruptedException {
        driver.get("https://demoqa.com/webtables");
        wtp = new WebTablePage(driver);
        String addNewStr = wtp.addNewPersonWT();
        String email = wtp.convertStringToArray(addNewStr)[3];
        wtp.searchSomePerson(email);
        wtp.deletePersonInfo();
        String text = wtp.checkDeleteText();

        Assert.assertEquals(text, "No rows found", "No matches  No rows found ");

    }
    @Test
    public void testWebTableChangeCountRow() {
        driver.get("https://demoqa.com/webtables");
        wtp = new WebTablePage(driver);
        ArrayList<Integer> listPages = wtp.getListPages();
        ArrayList<Integer> countArrayList = wtp.selectUpToSomeRow(listPages);
        Assert.assertEquals(countArrayList, listPages, "There is don't matched number oof the row");
    }
    @Test
    public void testDifferentClickOnTheBtns() {
        driver.get("https://demoqa.com/buttons");
        btnP = new ButtonsPage(driver);
        String doubleClick = btnP.clickOnDifferentBnts("double");
        String rightClick = btnP.clickOnDifferentBnts("right");
        String simpleClick = btnP.clickOnDifferentBnts("click");
//        System.out.println(doubleClick);
//        System.out.println(rightClick);
//        System.out.println(simpleClick);
        Assert.assertEquals(doubleClick,"You have done a double click");
        Assert.assertEquals(rightClick,"You have done a right click");
        Assert.assertEquals(simpleClick,"You have done a dynamic click");

    }
 

    @AfterTest
    public void tearDown() {
        driver.close();
        driver = null;
    }


}
