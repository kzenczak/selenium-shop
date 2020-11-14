package helpers;

import base.TLdriver;
import base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class GlobalMethods extends TestBase {

    public GlobalMethods(){}


    public String getPageTitle(){
        String title = TLdriver.getTLDriver().getTitle();
        System.out.println("Page title: " + title);
        return title;
    }

    public void setInput(WebElement inputElement, String text){
        wait.until(visibilityOf(inputElement));
        inputElement.clear();
        inputElement.sendKeys(text);
    }

    public void clickButton(WebElement buttonElement){
        wait.until(elementToBeClickable(buttonElement)).click();
    }

    public String getTextFromElement(WebElement element){
        wait.until(visibilityOf(element));
        String  text = element.getText();
        return text;
    }

    public void takeScreenshot(String pathname) throws Exception {
        File src = ((TakesScreenshot) TLdriver.getTLDriver()).getScreenshotAs(OutputType.FILE);
        File dest = new File("src/main/resources" + pathname + ".png");
        FileUtils.copyFile(src, dest);
    }

}