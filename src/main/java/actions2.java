import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class actions2 {

    public static WebDriver driver;

    @BeforeTest
    public void initConfig() {

        System.out.println("Starting test");
        //Initial configuration
        System.setProperty("webdriver.chrome.driver", "C:/selenium/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();
    }

    @AfterTest
    public void closeDriver() {
        driver.quit();
        System.out.println("Test finished");
    }


    @Test
    public void test() {

        //Go to Selenium shop and MOJE KONTO
        driver.get("http://selenium-shop.pl");
        driver.findElement(By.partialLinkText("KONTO")).click();

        //Click ZAREJESTRUJ SIĘ

        try {
            WebElement regButton = driver.findElement(By.xpath("//button[@name='register']"));
            regButton.click();
        } catch (NoSuchElementException e1) {
            System.out.println("Przycisku ZAREJESTRUJ SIĘ nie ma na stronie");
            driver.navigate().refresh();
        } catch (ElementNotVisibleException e2) {
            System.out.println("Przycisk ZAREJESTRUJ SIĘ nie jest widoczny");
            driver.navigate().refresh();
        } catch (ElementNotInteractableException e3) {
            System.out.println("Nie można wejść w interakcję z przyciskiem ZAREJESTRUJ SIĘ");
            driver.navigate().refresh();
        }


    }
}