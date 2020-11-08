import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class asercje2 {

    public static WebDriver driver;

    @Test
    public void test() {

    System.setProperty("webdriver.chrome.driver", "C:/selenium/chromedriver.exe");

    driver = new ChromeDriver();

    //Open selenium-shop website
    driver.get("http://www.selenium-shop.pl");

    //Go to Moje konto
    driver.findElement(By.linkText("MOJE KONTO")).click();

    //Verify if Login button is visible
    WebElement loginButton = driver.findElement(By.name("login"));

    Assert.assertNull(loginButton.getAttribute("disabled"));
    System.out.println("Login button is present");

    //Verify if Register button is visible
    WebElement registerButton = driver.findElement(By.name("register"));

    Assert.assertTrue(registerButton.isDisplayed());
    System.out.println("Register button is present");

    driver.quit();
    }
}
