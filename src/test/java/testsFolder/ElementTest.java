package testsFolder;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pagesLocators.TextBoxPage;
import resources.BasePage;

import java.io.IOException;
import java.time.Duration;

public class ElementTest extends BasePage {
    private WebDriverWait wait;
    public WebDriver driver;
    TextBoxPage txp;


    @BeforeTest
    public void initilizing() throws IOException {
        driver = initilizeDriver();
    }


    @Test
    public void testPage() throws InterruptedException, IOException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        driver.get(properties.getProperty("url"));
        txp = new TextBoxPage(driver);
        txp.fillAllFieldsApi();
        txp.verifyFilledFormsValues();

    }

    @AfterTest
    public void tearDown() {
        driver.close();
        driver = null;
    }


}
