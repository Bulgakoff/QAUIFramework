package pagesLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import resources.BasePage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class UploadDownloadPage extends BasePage {
    //attributes Class:
    public WebDriver driver;
    // locators for  field:
//    private By SIMPLE_LINK = By.cssSelector("a[id='simpleLink']");

    //constructor:

    public UploadDownloadPage(WebDriver driver) {
        this.driver = driver;
    }


    //methods class getters:

    //others methods:
    public void uploadfile() {
    }

    public void downloadfile() {
    }

    public void generatedFile() throws IOException {
        double salaryy = 1 + Math.random() * 100;
        int sal2 = (int) Math.round(salaryy);
        System.out.println(sal2);
        File file = new File("C:\\Users\\user\\IdeaProjects\\QAUIFramework\\qwe\\testFile"+sal2+".txt");
//create the file.
        if (file.createNewFile()){
            System.out.println("File is created!");
        }
        else{
            System.out.println("File already exists.");
        }
//write content
        FileWriter writer = new FileWriter (file);
        writer.write("Test data");
        writer.close();
    }


}
