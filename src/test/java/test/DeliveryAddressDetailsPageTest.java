package test;

import base.TestBase;
import helpers.GlobalMethods;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import java.net.MalformedURLException;

public class DeliveryAddressDetailsPageTest extends TestBase{
    HomePage homePage;
    LoginPage loginPage;
    AccountPage accountPage;
    AddressPage addressPage;
    DeliveryAddressDetailsPage deliveryAddressDetailsPage;
    GlobalMethods globalMethods;


    /********* konstruktor ***********/
    public DeliveryAddressDetailsPageTest() {
        super();
    }



    // Przed każdym testem uruchomienie przeglądarki wraz z zadeklarowanymi własnościami
    @BeforeMethod
    public void setUp() throws MalformedURLException {
        initialization();
        homePage = new HomePage();
        loginPage = new LoginPage();
        accountPage = new AccountPage();
        addressPage = new AddressPage();
        globalMethods = new GlobalMethods();


        loginPage = homePage.goToLoginPage();
        accountPage = loginPage.login(user, password);
        addressPage = accountPage.goToAddresses();
        deliveryAddressDetailsPage = addressPage.goToAddDeliveryAddress();
        }

    // Po każdym teście zamknięcie przeglądarki
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }


    /*********  TESTY *********/
    @Test(priority = 0)
    public void addDeliveryAddress() throws Exception {
        addressPage = deliveryAddressDetailsPage.fillForm("Jan","Testowy2","Polska",
                "Słoneczna","00-001","Warszawa");


        Assert.assertEquals(addressPage.getInfoDeliveryAddress(),
                "Jan Testowy2\n" +
                        "Słoneczna\n" +
                        "00-001 Warszawa");

        globalMethods.takeScreenshot("addedDeliveryAddress");
    }

}
