import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.Assert;
import org.testng.annotations.Test;


public class multiSessions {

    @Test
    public void clickProductLink_Test_SessionOne() {

        //Konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "C:/selenium/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://www.selenium-shop.pl/");


        WebElement whuShirt = driver.findElement(By.partialLinkText("WEST HAM"));

        whuShirt.click();

        Assert.assertEquals(driver.getTitle(), "Koszulka West Ham United – Selenium Shop Automatyzacja Testów");

        SessionId sessionid = ((RemoteWebDriver) driver).getSessionId();
        long id = Thread.currentThread().getId();
        System.out.println("Test 1. Wątek id: " + id);
        System.out.println("Test 1. Session id: " + sessionid);

        driver.quit();

    }

    @Test
    public void verifyProductName_SessionTwo() {
        //Konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "C:/selenium/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://www.selenium-shop.pl/");

        WebElement whuShirt = driver.findElement(By.partialLinkText("WEST HAM"));

        whuShirt.click();

        WebElement productName = driver.findElement(By.cssSelector("h1"));

        Assert.assertEquals(productName.getText(), "KOSZULKA WEST HAM UNITED");

        SessionId sessionid = ((RemoteWebDriver) driver).getSessionId();
        long id = Thread.currentThread().getId();
        System.out.println("Test 2. Wątek id: " + id);
        System.out.println("Test 2. Session id: " + sessionid);

        driver.quit();

    }

    @Test
    public void verifyProductPrice_SessionThree() {
        //Konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "C:/selenium/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://www.selenium-shop.pl/");


        WebElement whuShirt = driver.findElement(By.partialLinkText("WEST HAM"));

        whuShirt.click();

        WebElement productPrice1 = driver.findElement(By.xpath("//span[contains(@class, 'amount')]"));
        //WebElement productPrice2 = driver.findElement(By.xpath("//span[contains(@class, 'currencySymbol')]"));

        //String productPrice = productPrice1.getText() + productPrice2.getText();

        Assert.assertEquals(productPrice1.getText(), "90,00 ZŁ");

        SessionId sessionid = ((RemoteWebDriver) driver).getSessionId();
        long id = Thread.currentThread().getId();
        System.out.println("Test 3. Wątek id: " + id);
        System.out.println("Test 3. Session id: " + sessionid);

        driver.quit();
    }

    @Test
    public void verifyProductQuantity_SessionFour() {
        //Konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "C:/selenium/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://www.selenium-shop.pl/");


        WebElement whuShirt = driver.findElement(By.partialLinkText("WEST HAM"));

        whuShirt.click();

        WebElement productQuantity = driver.findElement(By.name("quantity"));

        Assert.assertEquals(productQuantity.getAttribute("value"), "1");

        SessionId sessionid = ((RemoteWebDriver) driver).getSessionId();
        long id = Thread.currentThread().getId();
        System.out.println("Test 3. Wątek id: " + id);
        System.out.println("Test 3. Session id: " + sessionid);
        driver.quit();
    }
}