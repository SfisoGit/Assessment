package selenium;

import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEDriverManager extends DriverManager {
    @Override
    protected void createWebDriver() {

        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\IEDriverServer.exe";
        System.setProperty("webdriver.ie.driver", path);

        driver = new InternetExplorerDriver();
        driver.manage().window().maximize();

    }
}
