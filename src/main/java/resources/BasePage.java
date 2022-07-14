package resources;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class BasePage {
    public static WebDriver driver;
    public Properties properties;
    WebDriverWait wait;

    public WebDriver initilizeDriver() throws IOException {
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        properties = new Properties();
        FileInputStream fis =
                new FileInputStream
                        (System.getProperty("user.dir")
                                + "\\src\\main\\java\\resources\\data.properties");
        properties.load(fis);
        String browserName = properties.getProperty("browser");//for testng.xml
//        String browserName = System.getProperty("browser"); //for console
        if (browserName.contains("chrome")) {
            //execute chrome driver chrome:
            System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriverjava\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            if (browserName.contains("headless")) {
                options.addArguments("headless");
            }
            driver = new ChromeDriver(options);
        } else if (browserName.equals("firefox")) {

        } else if (browserName.equals("IE")) {

        }

        return driver;
    }

    public void makeScreenshot() throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File sourceObj = ts.getScreenshotAs(OutputType.FILE);
        String destinationFilePath = System.getProperty("user.dir")
                + "\\reports\\" + System.currentTimeMillis() + "step.png";
        File fileDestinationObj = new File(destinationFilePath);
        FileUtils.copyFile(sourceObj, fileDestinationObj);
    }

    public WebElement elementIsVisible(By locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public List<WebElement> elementAreVisible(By locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public WebElement elementIsPresent(By locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public List<WebElement> elementArePresent(By locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public Boolean elementIsNotVisible(By locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public WebElement elementIsClickable(By locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void goToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }


}
