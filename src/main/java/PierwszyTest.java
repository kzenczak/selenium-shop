import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PierwszyTest {

   public static WebDriver driver;

   @Test
   public void test() {

      System.setProperty("webdriver.chrome.driver", "C:/selenium/chromedriver.exe");

      driver = new ChromeDriver();

      //Open selenium-shop website
      driver.get("http://www.selenium-shop.pl");

      driver.manage().window().maximize();

      System.out.println("Tytuł strony: " + driver.getTitle());

      Assert.assertEquals(driver.getTitle(), "Selenium Shop Automatyzacja Testów");

      //Go to 'Shop' section
      WebElement shopSection = driver.findElement(By.xpath("//a[text()='Sklep']"));
      shopSection.click();

      Assert.assertEquals(driver.getTitle(), "Produkty – Selenium Shop Automatyzacja Testów");

      //Find a Chelsea London shirt and go to its page
      WebElement chelseaShirt = driver.findElement(By.xpath("//a[@href='http://www.selenium-shop.pl/produkt/kopia/']"));
      chelseaShirt.click();

      Assert.assertEquals(driver.getTitle(), "Koszulka Chelsea London – Selenium Shop Automatyzacja Testów");

      //In quantity field input 2
      WebElement quantityField = driver.findElement(By.xpath("//input[@name='quantity']"));
      quantityField.clear();
      quantityField.sendKeys("2");

      //Assert.assertEquals(driver.findElement(By.xpath("//input[@name='quantity']")), "2");

      //Add 2 items to the Cart
      WebElement addToCart = driver.findElement(By.name("add-to-cart"));
      addToCart.click();

      //Click 'Zobacz koszyk' after it's shown
      WebElement seeCart = driver.findElement(By.xpath("//a[@class='button wc-forward']"));
      seeCart.click();

      Assert.assertEquals(driver.getTitle(), "Koszyk – Selenium Shop Automatyzacja Testów");

      //In Coupon Code field enter "Wiosna2020"
      WebElement couponInput = driver.findElement(By.cssSelector("input#coupon_code"));
      couponInput.sendKeys("Wiosna2020");

      //Click "Zastosuj kupon"
      WebElement couponApply = driver.findElement(By.xpath("//button[@name='apply_coupon']"));
      couponApply.click();

      driver.quit();
   }
}

