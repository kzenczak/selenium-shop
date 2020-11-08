import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class kalendarz {
    public static WebDriver driver;

    @Test
    public void test() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/selenium/chromedriver.exe");

        driver = new ChromeDriver();

        //Go to selenium-shop website
        driver.get("http://www.selenium-shop.pl/");

        //Go to Ankieta
        driver.findElement(By.linkText("ANKIETA")).click();

        //Open calendar and pick a date
        WebElement datePicker = driver.findElement(By.xpath("//div[@id='datepicker']/input"));
        datePicker.clear();
        datePicker.sendKeys("06-04-2000");

        Thread.sleep(2000);

        //Print out the date
        System.out.println("Selected date is: " + datePicker.getAttribute("value"));
        Assert.assertEquals(datePicker.getAttribute("value"), "06-04-2000");

        driver.quit();
    }
}