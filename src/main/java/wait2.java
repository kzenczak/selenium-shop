import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class wait2 {
    public static WebDriver driver;

    @Test
    public void test() {

        System.setProperty("webdriver.chrome.driver", "C:/selenium/chromedriver.exe");

        driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, 30);

        //Open selenium-shop website
        driver.get("http://www.selenium-shop.pl");

        wait.until(ExpectedConditions.titleIs("Selenium Shop Automatyzacja Testów"));

        //Wait until SEE ALL PRODUCTS is visible and click it
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='See all products']"))).click();

        //Wait until Arsenal London shirt is visible and click it
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(), 'Arsenal London')]"))).click();

        //Wait until DODAJ DO KOSZYKA is visible and click it
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("add-to-cart"))).click();

        //Wait until confirmation is shown
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alert']")));
        Assert.assertTrue(driver.findElement(By.xpath("//div[@role='alert']")).isDisplayed());

        driver.quit();

    }
}
