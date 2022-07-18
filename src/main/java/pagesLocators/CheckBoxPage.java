package pagesLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import resources.BasePage;

import java.util.List;

public class CheckBoxPage extends BasePage {
    //attributes Class:
    public WebDriver driver;
    //locators for  field:
    private By EXPAND_ALL_BUTTON = By.cssSelector("button[title='Expand all']");
    private By ITEM_LIST = By.cssSelector("span[class='rct-title']");


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
                System.out.println(item.getText());
            } else {
                break;
            }
        }
    }
}
