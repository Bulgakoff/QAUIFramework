package pagesLocators;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import resources.BasePage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class WebTablePage extends BasePage {
    //attributes Class: locators for  field:
    public WebDriver driver;
    private By ADD_BUTTON = By.cssSelector("button[id='addNewRecordButton']");//
    private By FIRSTNAME_INPUT = By.cssSelector("input[id='firstName']");//
    private By LASTNAME_INPUT = By.cssSelector("input[id='lastName']");//
    private By AGE_INPUT = By.cssSelector("input[id='age']");//
    private By EMAIL_INPUT = By.cssSelector("input[placeholder='name@example.com']");//
    private By SALARY_INPUT = By.cssSelector("input[id='salary']");//
    private By DEPARTMENT_INPUT = By.cssSelector("input[id='department']");//
    private By SUBMIT_BUTTON = By.cssSelector("button[id='submit']");//

    private By SEARCH_BOX = By.cssSelector("input[id='searchBox']");//

    //span[title='Delete']
    private By DELETE_BUTTON = By.cssSelector("span[title='Delete']");//
    private By ROW_PARENT = By.xpath(".//ancestor::div[@class='rt-tr-group']");

    //tables:
    private By FULL_PEOPLE_LIST = By.cssSelector("div[class='rt-tr-group']");//

    //constructor:
    public WebTablePage(WebDriver driver) {
        this.driver = driver;
    }

    //methods class getters:


    public WebElement getDELETE_BUTTON() {
        return elementIsVisible(DELETE_BUTTON);
    }

    public WebElement getSEARCH_BOX() {
        return elementIsVisible(SEARCH_BOX);
    }

    public WebElement getADD_BUTTON() {
        return elementIsPresent(ADD_BUTTON);
    }

    public WebElement getFIRSTNAME_INPUT() {
        return elementIsPresent(FIRSTNAME_INPUT);
    }

    public WebElement getLASTNAME_INPUT() {
        return elementIsPresent(LASTNAME_INPUT);
    }

    public WebElement getAGE_INPUT() {
        return elementIsPresent(AGE_INPUT);
    }

    public WebElement getEMAIL_INPUT() {
        return elementIsPresent(EMAIL_INPUT);
    }

    public WebElement getSALARY_INPUT() {
        return elementIsPresent(SALARY_INPUT);
    }

    public WebElement getDEPARTMENT_INPUT() {
        return elementIsPresent(DEPARTMENT_INPUT);
    }

    public WebElement getSUBMIT_BUTTON() {
        return elementIsPresent(SUBMIT_BUTTON);
    }

    public List<WebElement> getFULL_PEOPLE_LIST() {
        return elementArePresent(FULL_PEOPLE_LIST);
    }

    //others methods:
    public String addNewPersonWT() {
//        Random random = new Random();
        double salaryy = 10000 + Math.random() * 100000;
        int sal2 = (int) Math.round(salaryy);
        int agee = (int) Math.round(10 + Math.random() * 90);

        // Настройка языка, регион
        Locale locale = new Locale("ru", "RU");
        // Создать объект
        Faker faker = new Faker(locale);
        List<String> listAddedValuesWT = new ArrayList<>();

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String age = String.valueOf(agee);
        String email = "faker@email.ru";
        String salary = String.valueOf(sal2);
        String department = faker.company().name();

        getADD_BUTTON().click();

        getFIRSTNAME_INPUT().sendKeys(firstName);
        getLASTNAME_INPUT().sendKeys(lastName);
        getAGE_INPUT().sendKeys(age);
        getEMAIL_INPUT().sendKeys(email);
        getSALARY_INPUT().sendKeys(salary);
        getDEPARTMENT_INPUT().sendKeys(department);
        getSUBMIT_BUTTON().click();

        listAddedValuesWT.add(firstName);
        listAddedValuesWT.add(lastName);
        listAddedValuesWT.add(age);
        listAddedValuesWT.add(email);
        listAddedValuesWT.add(salary);
        listAddedValuesWT.add(department);
        String listAddNewInString = StringUtils.join(listAddedValuesWT, "\n");

        return listAddNewInString;
    }

    public List<String> checkNewAddedPeople() {
        List<WebElement> listAddedPeople = getFULL_PEOPLE_LIST();
        List<String[]> listTexts = new ArrayList<>();
        for (WebElement element : listAddedPeople) {
            listTexts.add(element.getText().split(",(?! )"));
        }
        List<String> listAddedPeoplesNew = new ArrayList<>();
        for (int i = 0; i < listTexts.size(); i++) {
            for (String qwe : listTexts.get(i)) {
                listAddedPeoplesNew.add(qwe);
            }
        }
        return listAddedPeoplesNew;
    }

    public void searchSomePerson(String keyWord) throws InterruptedException {
        getSEARCH_BOX().sendKeys(keyWord);
        Thread.sleep(3000);
    }

    public String[] checkSearchPerson() {
        WebElement deleteButton = getDELETE_BUTTON();//must be list 3 items here
        WebElement row = deleteButton.findElement(ROW_PARENT);//pass to parent element inside found block
        return row.getText().split(",(?! )");
    }
    public String convertStringToArrayAndGetRandomItem(String addNewStr ) {
        String[] addedNewList = addNewStr.split("\n");
        String keyWord = addedNewList[(int) (Math.random() * 5)];
        return keyWord;
    }
   public void convertDataIntoNewArrayCompareSearchWord(String[] arrStr, String keyWord) {
       String arrayStringToString = Arrays.toString(arrStr);
       String[] asd = arrayStringToString.split("\n");
       // полаучили без скобок  массив:
       List<String> newAsd = new ArrayList<>();
       for (String qwe : asd) {
           newAsd.add(qwe.
                   replace("[", "").
                   replace("]", ""));
       }
       // получили без скобок  массив:
       System.out.println(newAsd);
       for (String zzz : newAsd) {
           if (zzz.equals(keyWord)) {
               System.out.println("matched word");
               break;
           } else {
               System.out.println("Нет совпадений");
           }
       }
   }
}
