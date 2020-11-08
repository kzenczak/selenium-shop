import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class webElementy2 {
        public static WebDriver driver;

        @Test
        public void test() throws InterruptedException {

            System.setProperty("webdriver.chrome.driver", "C:/selenium/chromedriver.exe");

            driver = new ChromeDriver();

            //Go to google website
            driver.get("https://google.com/");

            WebElement gowno = driver.findElement(By.xpath("//div/div/iframe"));
            driver.switchTo().frame(gowno);

            driver.findElement(By.xpath("//span[text()='Zgadzam się']")).click();

            //Search for 'od laika do automatyka'
            WebElement searchField = driver.findElement(By.xpath("//input[@title='Szukaj']"));
            searchField.sendKeys("od laika do automatyka" + Keys.ENTER);

            //Find odlaikadoautomatyka.pl and enter the site
            WebElement odLaika = driver.findElement(By.xpath("//a[contains(@href, 'odlaikadoautomatyka')]"));
            odLaika.click();

            //Verify if the site is correct
            Assert.assertEquals(driver.getTitle(), "Start - Od laika do automatyka");

            System.out.println(driver.getTitle());

            //Go to FAQ
            driver.findElement(By.linkText("FAQ")).click();

            //Expand "Dla kogos jest ten kurs" and print out its content
            driver.findElement(By.xpath("//h5[text()='DLA KOGO DEDYKOWANY JEST KURS?']")).click();
            Thread.sleep(2000);
            String textContent = driver.findElement(By.xpath("//div[contains(@class, 'toggle_open')]/div/p")).getText();

            System.out.println(textContent);

            driver.quit();
        }
}
