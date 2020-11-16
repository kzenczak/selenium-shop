package pages;

import base.TLdriver;
import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;


public class HomePage  extends TestBase {

    /**** repozytorium elementów ****/
    @FindBy(xpath = "//a[@href='http://www.selenium-shop.pl/sklep/']")
    private WebElement shopMenu;

    @FindBy(xpath = "//a[@href='http://www.selenium-shop.pl/moje-konto/']")
    private WebElement myAccountMenu;


    /**** konstruktor ****/
    public HomePage(){
<<<<<<< HEAD
        PageFactory.initElements((WebDriver) driver, this);
=======
        PageFactory.initElements(TLdriver.getTLDriver(), this);
>>>>>>> main
    }


    /****  metody  ****/
    // Przejście na stronę sklepu z produktami
    public ProductListPage goToProductPage(){
        wait.until(visibilityOf(shopMenu));
        shopMenu.click();
        return new ProductListPage();
    }


    // Przejście na zakładkę Moje Konto - zakładka z logowaniem
    public LoginPage goToLoginPage(){
        wait.until(visibilityOf(myAccountMenu));
        myAccountMenu.click();
        return new LoginPage();
    }

}
