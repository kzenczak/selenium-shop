import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class actions1 {
    public static WebDriver driver;

    @BeforeTest
    public void initConfig() {
        //Initial configuration
        System.setProperty("webdriver.chrome.driver", "C:/selenium/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();
    }

    @AfterTest
    public void closeDriver() {
        driver.quit();
    }

    /*public void takeScreenShot(int testNo) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(src, new File("src/main/resources/" + testNo + "_screenshot.png"));
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }*/

    @Test
    public void test() {

        Actions action = new Actions(driver);

        //Go to Selenium-shop
        driver.get("http://www.selenium-shop.pl/");

        //Go to Ankieta
        driver.findElement(By.linkText("ANKIETA")).click();

        //Perform double click on DWUKLIK button
        WebElement doubleClickButton = driver.findElement(By.xpath("//input[contains(@value, 'Dwuklik')]"));
        action.doubleClick(doubleClickButton).perform();

        //Verify if proper text was displayed after double click
        WebElement doubleClickMessage = driver.findElement(By.id("p-doubleClick"));
        Assert.assertTrue(doubleClickMessage.isDisplayed());
        System.out.println(doubleClickMessage.getText());

        //Right click on KLIKNIJ RIGHT button
        WebElement rightClickButton = driver.findElement(By.id("rightClick"));
        action.contextClick(rightClickButton).perform();

        //Verify if proper text was displayed after right click
        WebElement rightClickMessage = driver.findElement(By.id("rightClickInfo"));
        Assert.assertTrue(rightClickMessage.isDisplayed());
        System.out.println(rightClickMessage.getText());

        //Input 'NOWAK' into Nazwisko using keyDown
        WebElement nazwiskoInput = driver.findElement(By.id("Nazwisk"));

        action.keyDown(nazwiskoInput, Keys.SHIFT)
                .sendKeys(nazwiskoInput, "nowak")
                .keyUp(nazwiskoInput, Keys.SHIFT)
                .build()
                .perform();

        Assert.assertEquals(nazwiskoInput.getAttribute("value"), "NOWAK");

    }
}