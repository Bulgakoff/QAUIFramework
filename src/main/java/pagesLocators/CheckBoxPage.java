package pagesLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import resources.BasePage;

import java.util.ArrayList;
import java.util.List;

public class CheckBoxPage extends BasePage {
    //attributes Class:
    public WebDriver driver;
    //locators for  field:
    private By EXPAND_ALL_BUTTON = By.cssSelector("button[title='Expand all']");
    private By ITEM_LIST = By.cssSelector("span[class='rct-title']");
    private By CHECKED_ITEMS = By.cssSelector("svg[class='rct-icon rct-icon-check']");
    private By TITLE_ITEMS = By.xpath(".//ancestor::span[@class='rct-text']//span[@class='rct-title']");
    //  = (By.CSS_SELECTOR, "")
    private By OUTPUT_RESULT_LIST = By.cssSelector("span[class='text-success']");


    //constructor:
    public CheckBoxPage(WebDriver driver) {
        this.driver = driver;
    }
    //methods class getters:

    public WebElement getEXPAND_ALL_BUTTON() {
        return super.elementIsVisible(EXPAND_ALL_BUTTON);
    }

    public List<WebElement> getITEM_LIST() {
        return this.elementAreVisible(ITEM_LIST);
    }

    public List<WebElement> getCHECKED_ITEMS() {
        return this.elementArePresent(CHECKED_ITEMS);
    }

    public List<WebElement> getTITLE_ITEMS() {
        return this.elementArePresent(TITLE_ITEMS);
    }

    public List<WebElement> getOUTPUT_RESULT_LIST() {
        return this.elementArePresent(OUTPUT_RESULT_LIST);
    }

    //others methods:
    public void openAllPageElements() {
        this.getEXPAND_ALL_BUTTON().click();
    }

    public void getRandomCheckBox(List<WebElement> listCheckBox) throws InterruptedException {
        int count = 21;
        while (count != 0) {
            WebElement item = listCheckBox.get((int) (1 + Math.random() * 15));
            if (count > 0) {
                this.goToElement(item);
                item.click();
                count -= 1;
//                System.out.println(item.getText());
            } else {
                break;
            }
        }
    }
    public List<String> getCheckedItemsList() {
        List<WebElement> elements = this.getCHECKED_ITEMS();
        List<String> listData = new ArrayList<>();
        for (WebElement box : elements) {
            WebElement title_item = box.findElement(this.TITLE_ITEMS);
            listData.add(title_item.getText());
        }
        return listData;
    }
    public List<String> getOutputResultList() {
        List<WebElement> elements = this.getOUTPUT_RESULT_LIST();
        List<String> listData = new ArrayList<>();
        for (WebElement item : elements) {
            listData.add(item.getText());
        }
        return listData;
    }
}
