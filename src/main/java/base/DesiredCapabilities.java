package base;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class DesiredCapabilities {
    public Capabilities capabilities;
    FirefoxOptions fOptions = new FirefoxOptions();
    FirefoxProfile profile = new FirefoxProfile();
    ChromeOptions cOptions = new ChromeOptions();


    public Capabilities getCapabilities(String browser) {

        if (browser.equals("firefox"))
            profile.setAcceptUntrustedCertificates(true);
            profile.setAssumeUntrustedCertificateIssuer(false);
            fOptions.setCapability(FirefoxDriver.PROFILE, profile);
            capabilities = fOptions;
        if (browser.equals("chrome"))
            cOptions.addArguments("--start-maximized");
            cOptions.addArguments("--ignore-certificate-errors");
            capabilities = cOptions;
        return capabilities;
    }
}
