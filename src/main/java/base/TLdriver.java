package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TLdriver {
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();


    public synchronized static void setTLDriver (String browser) {

        if (browser.equals("chrome")) {
            driver = ThreadLocal.withInitial(() -> new ChromeDriver(OptionsManager.getChromeOptions()));
        } if (browser.equals("firefox")) {
            driver = ThreadLocal.withInitial(() -> new FirefoxDriver(OptionsManager.getFirefoxOptions()));
        }
    }

    public synchronized static WebDriver getTLDriver() {
        return driver.get();
    }


}
