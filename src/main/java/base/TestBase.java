package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class TestBase {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Properties config;
    public static Properties testdata;

    public static String user;
    public static String password;
    public static String browser;
    public static String windowsMaximize;
    public static String deleteAllCookies;
    public static String url;
    public static int pageLoadTimeout;
    public static int waitTimeout;

    public TestBase(){
        try {
            config = new Properties();
            FileInputStream file = new FileInputStream(System.getProperty("user.dir") +
                    "/src/main/java/config/config.properties");
            config.load(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            testdata = new Properties();
            FileInputStream file = new FileInputStream(System.getProperty("user.dir") +
                    "/src/main/java/testdata/testdata.properties");
            testdata.load(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initialization() throws MalformedURLException {

          /*  String browser = config.getProperty("browser");
            String url = config.getProperty("URL");
            int pageLoadTimeout = Integer.parseInt(config.getProperty("pageLoadTimeout"));
            String windowsMaximize = config.getProperty("windowsMaximize");
            String deleteAllCookies = config.getProperty("deleteAllCookies");
            int waitTimeout = Integer.parseInt(config.getProperty("waitTimeout"));*/
            String grid = config.getProperty("GRID");


            user = System.getProperty("User");
            password = System.getProperty("Password");
            browser = System.getProperty("Browser");
            windowsMaximize = System.getProperty("windowsMaximize");
            deleteAllCookies = System.getProperty("deleteAllCookies");
            url = System.getProperty("URL");
            pageLoadTimeout = Integer.parseInt(System.getProperty("pageLoadTimeout"));
            waitTimeout = Integer.parseInt(System.getProperty("waitTimeout"));


//            user = "UserTest3";
//            password = "HasloTestowe3";

            switch (browser) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +
                            "/src/main/resources/chromedriver.exe");

                    ChromeOptions options = new ChromeOptions();
                    //options.setCapability(CapabilityType.VERSION, "86");
                    //options.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);

                    if (grid.equalsIgnoreCase("true")) {

                        driver = new RemoteWebDriver(new URL("http://192.168.56.1:4444/wd/hub"), options);

                    } else {
                        driver = new ChromeDriver(options);
                    }
                    break;

                case "firefox":
                    System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +
                            "/src/main/resources/geckodriver.exe");

                    FirefoxOptions optionsff = new FirefoxOptions();
                    //optionsff.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);


                    if (grid.equalsIgnoreCase("true")) {

                        try {

                            driver = new RemoteWebDriver(new URL("http://192.168.56.1:4444/wd/hub"), optionsff);

                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }

                    } else {
                        driver = new FirefoxDriver(optionsff);
                    }

                    break;

                case "opera":
                    System.setProperty("webdriver.opera.driver", System.getProperty("user.dir") +
                            "/src/main/resources/operadriver.exe");

                    OperaOptions optionsop = new OperaOptions();

                    if (grid.equalsIgnoreCase("true")) {

                        try {

                            driver = new RemoteWebDriver(new URL("http://192.168.56.1:4444/wd/hub"), optionsop);

                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }

                    } else {
                        driver = new OperaDriver(optionsop);
                    }

                    break;

                case "edge":
                    System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") +
                            "/src/main/resources/msedgedriver.exe");

                    EdgeOptions optionsedg = new EdgeOptions();
                    //optionsedg.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);


                    if (grid.equalsIgnoreCase("true")) {

                        try {

                            driver = new RemoteWebDriver(new URL("http://192.168.56.1:4444/wd/hub"), optionsedg);

                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }

                    } else {
                        driver = new EdgeDriver(optionsedg);
                    }

                    break;


                default:
                    throw new IllegalArgumentException("Nierozpoznano typu przeglądarki internetowej." +
                            "Obsługiwane następujące opcje: chrome, firefox, edge, opera");
            }

            if (deleteAllCookies.equalsIgnoreCase("true")) {
                driver.manage().deleteAllCookies();
            }
            if (windowsMaximize.equalsIgnoreCase("true")) {
                driver.manage().window().maximize();
            }

            driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
            wait = new WebDriverWait(driver, waitTimeout);

            driver.get(url);
        }
}