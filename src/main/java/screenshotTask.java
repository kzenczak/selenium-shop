import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

public class screenshotTask {

    public static WebDriver driver;



    @BeforeTest
    public void initConfig() {

        System.out.println("Starting test");
        //Initial configuration
        System.setProperty("webdriver.chrome.driver", "C:/selenium/chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("http://selenium-shop.pl");
    }

    @AfterTest
    public void closeDriver() {
        driver.quit();
        System.out.println("Test finished");
    }

    public void takeScreenshot(String pathname) throws Exception {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File("src/main/resources/" + pathname);
        FileUtils.copyFile(src, dest);
    }

    @Test
    public void test() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        //Verify homepage title and take screenshot
        Assert.assertEquals(driver.getTitle(), "Selenium Shop Automatyzacja Testów");

        Thread.sleep(1000);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("shop-item-image")));

        takeScreenshot("homepage.png");

        //Go to SKLEP, verify title and take screenshot
        driver.findElement(By.linkText("SKLEP")).click();
        Assert.assertEquals(driver.getTitle(), "Produkty – Selenium Shop Automatyzacja Testów");

        takeScreenshot("sklep.png");

        //Go to KOSZYK, verify title and take screenshot
        driver.findElement(By.className("cart-contents")).click();
        Assert.assertEquals(driver.getTitle(), "Koszyk – Selenium Shop Automatyzacja Testów");

        takeScreenshot("koszyk.png");

    }

}
