package test;

import helpers.GlobalMethods;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;

import base.*;

import java.util.ArrayList;
import java.util.Arrays;

public class ProductListPageTest extends TestBase {
    HomePage homePage;
    ProductListPage productListPage;
    GlobalMethods globalMethods;

    ArrayList<String> correctProductListSortByPriceFromLowest = new ArrayList<>(Arrays.asList
            ("PIŁKA NOŻNA KIPSTA F100", "KOSZULKA NEWCASTLE FC UNITED", "KOSZULKA WEST HAM UNITED", "PIŁKA NOŻNA ADIDAS REPLIKA LIGA MISTRZÓW",
                    "PIŁKA NOŻNA ADIDAS EURO 2020", "KOSZULKA TOTTENHAM HOTSPUR F.C.", "KOSZULKA ARSENAL LONDON", "KOSZULKA CHELSEA LONDON",
                    "KOSZULKA MANCHESTER UNITED", "KOSZULKA MANCHESTER FC CITY", "KOSZULKA LIVERPOOL FC", "KOSZULKA LEICESTER FC CITY"));



    /********* konstruktor ***********/
    public ProductListPageTest() {
        super();
    }



    // Przed każdym testem uruchomienie przeglądarki wraz z zadeklarowanymi własnościami
    @BeforeMethod
    public void setUp() {
        initialization();
        homePage = new HomePage();
        productListPage = new ProductListPage();
        globalMethods = new GlobalMethods();

        productListPage = homePage.goToProductPage();
    }


    // Po każdym teście zamknięcie przeglądarki
    @AfterMethod
    public void closeBrowser(){
        TLdriver.getTLDriver().quit();
    }



    /*********  TESTY *********/
    @Test(priority = 0)
    public void verifyProductNumber() throws Exception {
        Assert.assertEquals(productListPage.getProductsNumber(),
                Integer.parseInt(testdata.getProperty("correctProductNumber")));

        globalMethods.takeScreenshot("verifyProductNumber");
    }

    @Test(priority = 1)
    public void verifySortProducts() throws Exception {
        Assert.assertEquals(productListPage.getProductsNameAfterOrderByPrice(), correctProductListSortByPriceFromLowest);

        globalMethods.takeScreenshot("verifySortProducts");
    }
}
