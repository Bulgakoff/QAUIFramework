package pagesLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import resources.BasePage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class UploadDownloadPage extends BasePage {
    //attributes Class:
    public WebDriver driver;
    File file;
    // locators for  field:
    private By UPLOAD_FILE = By.cssSelector("input[id='uploadFile']");
    private By UPLOADED_RESULT = By.cssSelector("[id='uploadedFilePath']");

    //constructor:
    public UploadDownloadPage(WebDriver driver) {
        this.driver = driver;
    }


    //methods class getters:

    public WebElement getUPLOAD_FILE() {
        return elementIsPresent(UPLOAD_FILE);
    }

    public WebElement getUPLOADED_RESULT() {
        return elementIsPresent(UPLOADED_RESULT);
    }
    //others methods:

    public int randomNum() {
        double randomPath = 1 + Math.random() * 100;
        int randomPathInt = (int) Math.round(randomPath);
        System.out.println(randomPathInt);
        return randomPathInt;
    }
    public ArrayList<String> uploadfile(int ri) throws IOException {

        ArrayList<String> lstNameAndText = new ArrayList<>();
        ArrayList<String> lstPathAndText = new ArrayList<>();

        ArrayList lstPF = generatedFile(ri);
        getUPLOAD_FILE().sendKeys((CharSequence) lstPF.get(0));
        String filePath = String.valueOf(lstPF.get(0));
        String fileName = String.valueOf(lstPF.get(1));
        try {
            File file = new File(filePath);
            if (file.delete()) {
                System.out.println(file.getName() + " is deleted!");
            } else {
                System.out.println("Sorry, unable to delete the file.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String textResult = getUPLOADED_RESULT().getText();
        System.out.println("Result filePath is "+ filePath);
        System.out.println("Result text is "+ textResult);
        lstPathAndText.add(filePath);
        lstPathAndText.add(textResult);
        String nameFile = lstPathAndText.get(0).split("\\\\")
                [lstPathAndText.get(0).split("\\\\").length - 1];

        String resultText = lstPathAndText.get(1).split("\\\\")
                [lstPathAndText.get(1).split("\\\\").length - 1];
        lstNameAndText.add(nameFile);
        lstNameAndText.add(resultText);

        return lstNameAndText;



    }

    public void downloadfile() {

    }

    public ArrayList<String> generatedFile(int randomPathInt) throws IOException {
        ArrayList<String> lstPathFilName = new ArrayList<>();
        String path = "C:\\Users\\user\\IdeaProjects\\QAUIFramework\\newFiles\\testFile" + randomPathInt + ".txt";
        file = new File(path.trim());


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
