import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class randomtest {

    public static WebDriver driver;



    @BeforeTest
    public void startBrowser() {
        System.out.println("BeforeTest");

        //Konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("http://www.selenium-shop.pl/");

        driver.manage().window().maximize();

    }

    @AfterTest
    public void closeBrowser() {
        System.out.println("AfterTest");
        driver.quit();
    }


   /* public void takeScreenShot(int NrTestu) {

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(src, new File("src/main/resources/" + NrTestu+ "_screenshot.png"));

        } catch (IOException e) {
            System.out.println(e.getMessage());

        }

    }*/

    //Krok 1
    @Test (priority = 1)
    public void verifyValueImieInput() {
        System.out.println("Test 2");
        WebElement ankietaMenu = driver.findElement(By.linkText("ANKIETA"));
        ankietaMenu.click();

        WebElement imięInput = driver.findElement(By.id("Imię"));
        imięInput.clear();
        imięInput.sendKeys("Adam");

        Assert.assertEquals(imięInput.getAttribute("value"), "Adam", "W polu jest wprowadzona inna " +
                "wartość od oczekiwanej.  Oczekiwaliśmy wartości 'Adam' a jest " + imięInput.getAttribute("value"));


    }

    //Krok 2
    @Test(priority = 2)
    public void verifyValueNazwiskoInput() {
        System.out.println("Test 2");
        WebElement nazwiskoInput = driver.findElement(By.id("Nazwisk"));
        nazwiskoInput.clear();
        nazwiskoInput.sendKeys("Nowak");

        Assert.assertEquals(nazwiskoInput.getAttribute("value"), "Nowak");

    }
}
