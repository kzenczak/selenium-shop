package pages;

import base.TLdriver;
import base.TestBase;
import helpers.GlobalMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class OrderConfirmedPage extends TestBase {
    GlobalMethods globalMethods;

    /**** repozytorium elementów ****/
    @FindBy(xpath = "//*[@class='woocommerce-MyAccount-content']/div[2]")
    private WebElement infoAboutOrders;



    /**** konstruktor ****/
    public OrderConfirmedPage(){
        globalMethods = new GlobalMethods();
<<<<<<< HEAD
        PageFactory.initElements((WebDriver) driver, this);
=======
        PageFactory.initElements(TLdriver.getTLDriver(), this);
>>>>>>> main
    }


    /****  metody  ****/
    // Pobranie i zwrócenie komunikatu o liczbie złożonych zamówień
    public String getInfoAboutOrders(){
        return globalMethods.getTextFromElement(infoAboutOrders);
    }

}
