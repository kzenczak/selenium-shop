import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class forceExceptions {

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


    @Test
    public void ForceNoAlertExc() {

        //Force NoAlertPresentException
        try {
            driver.switchTo().alert();
        } catch (NoAlertPresentException e) {
            System.out.println("Żaden alert nie jest obecny");
        }
    }

    @Test
    public void ForceNoSuchElementExc() {

        //Force NoSuchElement exception
        try {
            WebElement regButton = driver.findElement(By.xpath("//button[@name='register']"));
            regButton.click();
        } catch (NoSuchElementException e) {
            System.out.println("Przycisku ZAREJESTRUJ SIĘ nie ma na stronie");
        }
    }

    @Test
    public void ForceNotFoundExc() {

        //Force NotFoundException
        try {
            WebElement regButton = driver.findElement(By.xpath("//button[@name='register']"));
            regButton.click();
        } catch (NotFoundException e) {
            System.out.println("Przycisku ZAREJESTRUJ SIĘ nie ma na stronie");
        }
    }

    @Test
    public void ForceTimeoutExc() {

        WebDriverWait wait = new WebDriverWait(driver, 2);

        //Force TimeoutException
        try {
            wait.until(ExpectedConditions.attributeContains(By.linkText("ANKIETA"), "value", "1"));
        } catch (TimeoutException e) {
            System.out.println("Minęło za dużo czasu, element nie załadował się");
        }
    }

    @Test
    public void ForceNotInteractableExc() {
        driver.findElement(By.linkText("ANKIETA")).click();

        //Force ElementNotInteractableException
        try {
            driver.findElement(By.id("rightClickInfo")).click();
        } catch (ElementNotInteractableException e) {
            System.out.println("Element nie jest klikalny");
        }
    }

}
