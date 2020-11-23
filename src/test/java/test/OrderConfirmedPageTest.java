package test;

import base.TestBase;
import helpers.GlobalMethods;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderConfirmedPage;

import java.net.MalformedURLException;


public class OrderConfirmedPageTest extends TestBase {
    HomePage homePage;
    LoginPage loginPage;
    AccountPage accountPage;
    OrderConfirmedPage orderConfirmedPage;
    GlobalMethods globalMethods;

    /********* konstruktor ***********/
    public OrderConfirmedPageTest() {
        super();
    }



    // Przed każdym testem uruchomienie przeglądarki wraz z zadeklarowanymi własnościami
    @BeforeMethod
    public void setUp() throws MalformedURLException {
        initialization();
        homePage = new HomePage();
        loginPage = new LoginPage();
        accountPage = new AccountPage();
        orderConfirmedPage = new OrderConfirmedPage();
        globalMethods = new GlobalMethods();


        loginPage = homePage.goToLoginPage();
        accountPage = loginPage.login(user, password);
        accountPage.goToOrders();
    }

    // Po każdym teście zamknięcie przeglądarki
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }



    /*********  TESTY *********/
    @Test(priority = 0)
    public void verifyNoOrders() throws Exception {
        Assert.assertTrue(orderConfirmedPage.getInfoAboutOrders().contains(testdata.getProperty("correctInfoAboutOrder")),
                "Istnieją już złożone zamówienia!");

        globalMethods.takeScreenshot("verifyNoOrders");

    }

}