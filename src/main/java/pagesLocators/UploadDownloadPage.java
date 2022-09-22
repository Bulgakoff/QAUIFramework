package pagesLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import resources.BasePage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class UploadDownloadPage extends BasePage {
    //attributes Class:
    public WebDriver driver;
    // locators for  field:
    private By UPLOAD_FILE = By.cssSelector("input[id='uploadFile']");

    //constructor:
    public UploadDownloadPage(WebDriver driver) {
        this.driver = driver;
    }


    //methods class getters:

    //others methods:
    public void uploadfile() throws IOException {
        ArrayList lstPF = generatedFile();
        elementIsPresent(UPLOAD_FILE).sendKeys((CharSequence) lstPF.get(0));
    }

    public void downloadfile() {
    }

    public ArrayList<String> generatedFile() throws IOException {
        ArrayList<String> lstPathFilName = new ArrayList<>();

        double randomPath = 1 + Math.random() * 100;
        int randomPathInt = (int) Math.round(randomPath);
        System.out.println(randomPathInt);
        String path = "C:\\Users\\user\\IdeaProjects\\QAUIFramework\\qwe\\testFile" + randomPathInt + ".txt";
        File file = new File(path.trim());
        String fileName = file.getName();
        System.out.println("fileName = " + fileName);
//create the file.
        if (file.createNewFile()){
            System.out.println("File is created!");
            lstPathFilName.add(path);
            lstPathFilName.add(fileName);
        }
        else{
            System.out.println("File already exists.");
        }
//write content
        FileWriter writer = new FileWriter (file);
        writer.write("Test data");
        writer.close();
        return lstPathFilName;
    }


}
