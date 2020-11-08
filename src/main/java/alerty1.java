import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class alerty1 {
    public static WebDriver driver;

    @Test
    public void test() throws InterruptedException {

        System.setProperty("webdriver.gecko.driver", "C:/selenium/geckodriver.exe");

        driver = new FirefoxDriver();

        //Open selenium-shop website
        driver.get("http://www.selenium-shop.pl");

        Thread.sleep(1000);

        //Go to ANKIETA
        driver.findElement(By.linkText("ANKIETA")).click();

        //Click ALERT button
        driver.findElement(By.id("alertPrzycisk")).click();

        //Accept alert message
        driver.switchTo().alert().accept();

        //Click PROMPT ALLERT button
        //Input text in alert and accept
        WebElement promptAlertButton = driver.findElement(By.id("promtAlertPrzycisk"));
        promptAlertButton.click();

        Thread.sleep(2000);

        driver.switchTo().alert().sendKeys("Warszawa");

        Thread.sleep(1000);

        driver.switchTo().alert().accept();

        //Click CONFIRM ALERT
        driver.findElement(By.id("confimationAlertPrzycisk")).click();

        //Get alert text and print out
        String alertText = driver.switchTo().alert().getText();

        System.out.println("Tekst alertu to: " + alertText);

        //Decline alert
        driver.switchTo().alert().dismiss();

        driver.quit();

    }
}