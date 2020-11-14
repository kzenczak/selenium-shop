package pages;

import base.TLdriver;
import base.TestBase;
import helpers.GlobalMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends TestBase {
    GlobalMethods globalMethods;

    /**** repozytorium elementów *****/
    @FindBy(id = "username")
    public WebElement loginInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@name='login']")
    private WebElement  logInButton;



    /**** konstruktor ****/
    public LoginPage(){
        globalMethods = new GlobalMethods();
        PageFactory.initElements(TLdriver.getTLDriver(), this);
    }


    /****  metody  ****/
    // Metoda wykonująca pełną akcję logowania
    // zwracająca stronę AccountPage
    public AccountPage login(String login, String password){
        globalMethods.setInput(loginInput, login);
        globalMethods.setInput(passwordInput, password);
        globalMethods.clickButton(logInButton);
        return new AccountPage();
    }

}
