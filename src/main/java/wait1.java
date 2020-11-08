import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class wait1 {

    public static WebDriver driver;

    @Test
    public void test() {

        System.setProperty("webdriver.chrome.driver", "C:/selenium/chromedriver.exe");

        driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, 30);

        //Open selenium-shop website
        driver.get("http://www.selenium-shop.pl");

        //Go to Ankieta
        driver.findElement(By.linkText("ANKIETA")).click();

        //Click PROCES button
        WebElement procesButton = driver.findElement(By.xpath("//input[@value='PROCES']"));
        procesButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("procesText")));

        Assert.assertTrue(driver.findElement(By.id("procesText")).isDisplayed());

        driver.quit();

    }
}