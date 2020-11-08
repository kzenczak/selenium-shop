import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DrugiTest {
    public static WebDriver driver;

    @Test
    public void test() {

        System.setProperty("webdriver.chrome.driver", "C:/selenium/chromedriver.exe");

        driver = new ChromeDriver();

        //Open selenium-shop website
        driver.get("http://www.selenium-shop.pl");

        driver.manage().window().maximize();

        //Enter "Moje konto"
        driver.findElement(By.linkText("MOJE KONTO")).click();

        //Check for numbers of buttons AND print out buttons' name
        List<WebElement> allButtons = driver.findElements(By.xpath("//button"));

        int numButtons = allButtons.size();

        Assert.assertEquals(numButtons, 2);

        System.out.println("Buttony na stronie to: ");

        for(int i = 0; i < numButtons; i++) {
            System.out.println(allButtons.get(i).getAttribute("value"));
        }

        driver.quit();

    }
}