package pagesLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import resources.BasePage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class LinksPage extends BasePage {
    //attributes Class:
    public WebDriver driver;
    // locators for  field:
    private By SIMPLE_LINK = By.cssSelector("a[id='simpleLink']");
    private By BAD_REQUEST = By.cssSelector("a[id='bad-request']");
    //p[@id='linkResponse']/b[1]
    private By LINK_RESPONSE = By.xpath("//p[@id='linkResponse']/b[1]");

    //constructor:
    public LinksPage(WebDriver driver) {
        this.driver = driver;
    }

    //methods class getters:

    public WebElement getSIMPLE_LINK() {
        return elementIsPresent(SIMPLE_LINK);
    }

    public WebElement getBAD_REQUEST() {
        return elementIsPresent(BAD_REQUEST);
    }

    public WebElement getLINK_RESPONSE() {
        return elementIsPresent(LINK_RESPONSE);
    }

    //others methods:
    public int connection(String linkHref, WebElement simpleLink) throws IOException {
        HttpURLConnection conn = (HttpURLConnection) new URL(linkHref).openConnection();
        conn.setRequestMethod("HEAD");
        conn.connect();
        int responseCode = conn.getResponseCode();
        System.out.println(responseCode);
        if (responseCode == 200) {
            simpleLink.click();
            return responseCode;
        } else {
            return responseCode;
        }
    }
    public int checkNewTabSimpleLink() throws IOException {
        WebElement simpleLink = getSIMPLE_LINK();
        String linkHref = simpleLink.getAttribute("href");
        return connection(linkHref, simpleLink);
    }

    public int checkNewTabBrokenLink(String url) throws IOException {
        WebElement badLink = getBAD_REQUEST();
        return  connection(url, badLink);
    }


}
