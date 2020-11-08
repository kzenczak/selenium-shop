import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class listyRozwijane {
    public static WebDriver driver;

    @Test
    public void test() {

        System.setProperty("webdriver.chrome.driver", "C:/selenium/chromedriver.exe");

        driver = new ChromeDriver();

        //Go to selenium-shop website
        driver.get("http://www.selenium-shop.pl/");

        //Go to Ankieta
        driver.findElement(By.linkText("ANKIETA")).click();

        //Verify if 'Jaki uprawiasz sport?' list has multiple choice
        WebElement sportList = driver.findElement(By.className("moj-select"));
        Select sportSelect = new Select(sportList);

        if(sportSelect.isMultiple()) {
            System.out.println("Lista 'Jaki uprawiasz sport?' jest wielokrotnego wyboru");
        } else {
            System.out.println("Lista 'Jaki uprawiasz sport?' jest jednokrotnego wyboru");
        }

        //Count number of elements in the list
        List<WebElement> sportListItems = driver.findElements(By.xpath("//select[@class='moj-select']/option"));

        System.out.println("Lista 'Jaki uprawiasz sport?' zawiera " + sportListItems.size() + " elementów");

        //Print out the element selected by default

        for(int i = 0; i < sportListItems.size(); i++) {
            if (sportListItems.get(i).isSelected()) {
                System.out.println("Defaultowo zaznaczony jest element: " + sportListItems.get(i).getText());
            }
        }

        //Print out all elements from the list
        System.out.println("Elements in the list: ");

        for(int i = 0; i < sportListItems.size(); i++) {
            System.out.println(sportListItems.get(i).getText());
        }

        //Select "Bieganie" from the list
        sportSelect.selectByVisibleText("Bieganie");

        System.out.println("Zaznaczony element: " + sportSelect.getFirstSelectedOption().getText());


        driver.quit();
    }
}