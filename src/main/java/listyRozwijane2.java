import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class listyRozwijane2 {
    public static WebDriver driver;

    @Test
    public void test() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/selenium/chromedriver.exe");

        driver = new ChromeDriver();

        //Go to selenium-shop website
        driver.get("http://www.selenium-shop.pl/");

        //Go to Ankieta
        driver.findElement(By.linkText("ANKIETA")).click();

        Assert.assertTrue(driver.findElement(By.id("moj-formularz")).isDisplayed());

        //Fill out Imię field
        WebElement name = driver.findElement(By.id("Imię"));
        name.clear();
        name.sendKeys("Adam");

        //Fill out Nazwisko field
        WebElement surname = driver.findElement(By.id("Nazwisk"));
        surname.clear();
        surname.sendKeys("Nowak");

        //In Płeć section select Mężczyzna
        WebElement sex = driver.findElement(By.xpath("//input[@value='Mężczyzna']"));
        sex.click();

        //In Podaj wiek section select 20-29
        WebElement age = driver.findElement(By.xpath("//input[@value='20-29']"));
        age.click();

        //In "Jakiego produktu szukałeś" section select Torba sportowa
        WebElement productSearched = driver.findElement(By.xpath("//input[@value='Torba sportowa']"));
        productSearched.click();

        //In "Jaki uprawiasz sport" section select Siatkówka
        WebElement sportList = driver.findElement(By.className("moj-select"));
        Select sportSelect = new Select(sportList);

        sportSelect.selectByValue("siatkowka");

        //In "Jakie lubisz marki" section select Kappa
        WebElement brandList = driver.findElement(By.id("Marki"));
        Select brandSelect = new Select(brandList);

        Thread.sleep(1000);

        brandSelect.deselectByIndex(0);
        brandSelect.selectByIndex(2);

        //Verifications
        Assert.assertEquals(name.getAttribute("value"), "Adam");
        Assert.assertNotEquals(surname.getAttribute("value"), "Kowalski");
        Assert.assertTrue(sex.isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//input[@value='15-19']")).isSelected());
        Assert.assertNull(productSearched.getAttribute("disabled"));


        //Click Wyślij button
        WebElement sendButton = driver.findElement(By.id("Wyslij"));
        sendButton.click();

        //Verify if survey was sent successfully
        if(!driver.findElements(By.className("pokazInfo")).isEmpty()) {
            System.out.println("Survey sent successfully!");
        } else {
            System.out.println("Survey was not sent");
        }

        //Print out all data from Wysłane dane element
        WebElement sentData = driver.findElement(By.id("info"));
        System.out.println(sentData.getText());


        driver.quit();
    }
}