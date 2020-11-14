package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;


public class TestBase {
    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public base.DesiredCapabilities desiredCapabilities = new base.DesiredCapabilities();
    public static WebDriverWait wait;
    public static Properties config;
    public static Properties testdata;


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
        DesiredCapabilities capabilities;

        String browser = config.getProperty("browser");
        String pageLoadTimeout = config.getProperty("pageLoadTimeout");
        String windowsMaximize = config.getProperty("windowsMaximize");
        String deleteAllCookies = config.getProperty("deleteAllCookies");
        String waitTimeout = config.getProperty("waitTimeout");
        String grid = config.getProperty("GRID");


        driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), desiredCapabilities.getCapabilities(browser)));

    }

    public WebDriver getDriver() {
        String url = config.getProperty("URL");
        return driver.get();
    }


        /*

        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +
                        "/src/main/resources/chromedriver.exe");

                ChromeOptions options = new ChromeOptions();
                //options.setCapability(CapabilityType.VERSION, "86");
                //options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WIN10);

                if(grid.equalsIgnoreCase("true")) {

                    try {

                        //driver = new RemoteWebDriver(new URL("http://192.168.22.1:4444/wd/hub"), options);

                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }

                }
                else {
                    driver = new ChromeDriver(options);
                }
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +
                        "/src/main/resources/geckodriver.exe");

                FirefoxOptions optionsff = new FirefoxOptions();

                if(grid.equalsIgnoreCase("true")) {

                    try {

                        driver = new RemoteWebDriver(new URL("http://192.168.8.100:4444/wd/hub"), optionsff);

                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }

                }
                else {
                    driver = new FirefoxDriver(optionsff);
                }

                break;

            default:
                throw new IllegalArgumentException("Nierozpoznano typu przeglądarki internetowej." +
                        "Obsługiwane następujące opcje: chrome, firefox, edge");
        }

        if(deleteAllCookies.equalsIgnoreCase("true")) {
            driver.manage().deleteAllCookies();
        }
        if(windowsMaximize.equalsIgnoreCase("true")){
            driver.manage().window().maximize();
        }

        driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(pageLoadTimeout), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Integer.parseInt(waitTimeout));

        driver.get(url);
*/


}