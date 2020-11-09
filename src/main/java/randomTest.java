import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class randomTest {
    public static WebDriver driver;

    @BeforeTest
    public void startBrowser() {
        System.out.println("BeforeTest");

        //Konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "C:/selenium/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://www.selenium-shop.pl/");

    }

    @AfterTest
    public void closeBrowser() {
        System.out.println("AfterTest");
        driver.quit();
    }



    //Testy
    //Krok 1
    @Test (priority = 1)
    public void clickAnkieta_Test() {
        System.out.println("Test 1");
        WebElement ankietaMenu = driver.findElement(By.linkText("ANKIETA"));
        ankietaMenu.click();
    }


    //Krok 2
    @Test (priority = 2,groups = {"NotImportant","nazwagrupy2"})
    public void verifyValueImieInput() {
        System.out.println("Test 2");
        WebElement imięInput = driver.findElement(By.id("Imię"));
        imięInput.clear();
        imięInput.sendKeys("Adam");

        Assert.assertEquals(imięInput.getAttribute("value"), "Adam", "W polu jest wprowadzona inna " +
                "wartość od oczekiwanej.  Oczekiwaliśmy wartości 'Adam' a jest " + imięInput.getAttribute("value"));
    }


    //Krok 3
    @Test(priority = 3 ,groups = {"NotImportant"})
    public void verifyIsSelectedPrzedzialWieku20_29() {
        System.out.println("Test 3");
        WebElement przedziałWieku20_29 = driver.findElement(By.xpath("//input[@name='przedzialWieku'][@value='20-29']"));
        if (!przedziałWieku20_29.isSelected()) {
            przedziałWieku20_29.click();
        }
        Assert.assertTrue(przedziałWieku20_29.isSelected());
    }


    //Krok 4
    @Test(priority = 4)
    public void writeConsoleLog() {
        System.out.println("Test 4");
        WebElement wyslaneInformacje = driver.findElement(By.id("info"));
        System.out.println(wyslaneInformacje.getText());
    }

}