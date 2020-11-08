import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class asercje1 {
    public static WebDriver driver;

    @Test
    public void test() {

        System.setProperty("webdriver.chrome.driver", "C:/selenium/chromedriver.exe");

        driver = new ChromeDriver();

        String shopTitle = "Produkty – Selenium Shop Automatyzacja Testów";

        //Open selenium-shop website
        driver.get("http://www.selenium-shop.pl");

        //Go to Shop
        driver.findElement(By.linkText("SKLEP")).click();

        Assert.assertTrue(driver.getTitle().equals(shopTitle), "Niepoprawny tytu strony");

        //Verify number of products on the page (correct = 12)
        List<WebElement> numProducts = driver.findElements(By.xpath("//ul/li[contains(@class, 'product')]"));

        Assert.assertEquals(numProducts.size(), 12, "Oczekiwaliśmy 12 produktów a jest " + numProducts.size());

        //Verify if sort list is available
        WebElement sortList = driver.findElement(By.className("orderby"));

        Assert.assertTrue(sortList.isDisplayed(), "Lista sortowania nie jest dostępna");
        System.out.println("Lista sortowania znajduje się na stronie");

        //Enter a product page
        driver.findElement(By.xpath("//h2[contains(text(), 'Manchester United')]")).click();

        //Verify if product quantity field is active
        WebElement quantityField = driver.findElement(By.name("quantity"));

        Assert.assertNotNull(quantityField.getAttribute("value"));

        driver.quit();
    }
}