import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class webElementy1 {
    public static WebDriver driver;

    @Test
    public void test() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/selenium/chromedriver.exe");

        driver = new ChromeDriver();
        Actions action = new Actions(driver);

        //Go to selenium-shop website
        driver.get("http://www.selenium-shop.pl/");

        //Go to shop
        driver.findElement(By.linkText("SKLEP")).click();

        //Sort by Popularity
        Select sortProductsBy = new Select(driver.findElement(By.name("orderby")));

        sortProductsBy.selectByValue("popularity");

        //Click "Add to cart on 1st product"
        WebElement firstProduct = driver.findElement(By.xpath("//a[contains(@href, 'add-to-cart')]"));

        action.moveToElement(firstProduct).perform();

        firstProduct.click();

        WebElement firstProductName = driver.findElement(By.xpath("//h2[contains(@class, 'woocommerce-loop')]"));
        String productName = firstProductName.getText();

        //Go to Cart
        driver.findElement(By.xpath("//a[@class='cart-contents']")).click();

        //Verify if proper product was added to the cart
        String cartProductName = driver.findElement(By.xpath("//td[@class='product-name']/a")).getText();
        Assert.assertEquals(cartProductName, productName);

        if (cartProductName.equals(productName)) {
            System.out.println("Nazwa produktu jest prawidłowa");
        } else {
            System.out.println("Nazwa produktu jest nieprawidłowa");
        }

        //Verify if number of items in Cart is 1
        WebElement cartItemsNum = driver.findElement(By.className("cart-item-number"));

        Assert.assertEquals(cartItemsNum.getText(), "1");

        if (!cartItemsNum.getText().equals("1")) {
            System.out.println("W koszyku jest za dużo produktów!");
        } else {
            System.out.println("W koszyku jest jeden produkt.");
        }

        driver.quit();
    }
}