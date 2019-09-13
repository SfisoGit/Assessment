package selenium;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager extends DriverManager {

    @Override
    protected void createWebDriver() {
        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\geckodriver.exe";
        System.setProperty("webdriver.Firefox.driver", path);

        driver = new FirefoxDriver();
        driver.manage().window().maximize();

    }
}
