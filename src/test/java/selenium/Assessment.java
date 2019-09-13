package selenium;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Assessment {

    DriverManager driverManager;

    @After
    public void quit(Scenario scenario)
    {

        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driverManager.driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
        driverManager.driver.close();
        driverManager.quitWebDriver();
    }

    @Given("^A user is on iLab page and want apply for jobs using browser \"([^\"]*)\"$")
    public void aUserIsOnILabPageAndWantApplyForJobsUsingBrowser(String browser) throws Throwable
    {
        driverManager = DriverManagerFactory.getDriverManager(DriverType.valueOf(browser));
        driverManager.driver= driverManager.getWebDriver();
        driverManager.driver.get("https://www.ilabquality.com/");
        driverManager.driver.manage().window().maximize();
        Thread.sleep(1000);
    }


    @And("^A user click on Careers$")
    public void aUserClickOnCareers() throws Throwable
    {

        driverManager.driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driverManager.driver.findElement(By.linkText("CAREERS")).click();
    }

    @And("^A user select South Africa hyperlink$")
    public void aUserSelectSouthAfricaHyperlink() throws Throwable
    {

        driverManager.driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
        driverManager.driver.findElement(By.xpath("//a[contains(.,'South Africa')]")).click();
    }

    @And("^A user click on the first available job hyperlink$")
    public void aUserClickOnTheFirstAvailableJobHyperlink() throws Throwable
    {

        driverManager.driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driverManager.driver.findElement(By.xpath("/html/body/section/div[2]/div/div/div/div[3]/div[2]/div/div/div/div/div/div[1]/div[1]/div[2]/span[1]/a")).click();
    }

    @And("^A user select Apply online button$")
    public void aUserSelectApplyOnlineButton() throws Throwable
    {
        driverManager.driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
        driverManager.driver.findElement(By.xpath("//a[contains(.,'Apply Online')]")).click();
    }


    @And("^A user enter name as \"([^\"]*)\" in the name field$")
    public void aUserEnterNameAsInTheNameField(String name) throws Throwable
    {
        driverManager.driver.findElement(By.id("applicant_name")).sendKeys(name);
    }

    @And("^A user enter email as \"([^\"]*)\" in the email field$")
    public void aUserEnterEmailAsInTheEmailField(String email) throws Throwable
    {
        driverManager.driver.findElement(By.id("email")).sendKeys(email);
    }

    @And("^A user enter phone number in the phone field$")
    public void aUserEnterPhoneNumberInThePhoneField() throws Throwable
    {
        String randomPhoneNumber = String.format("083"+" %03d %04d",
                (int) Math.floor(999*Math.random()),
                (int) Math.floor(9999*Math.random()));
        driverManager.driver.findElement(By.id("phone")).sendKeys(randomPhoneNumber);
    }

    @And("^A user clicks on Send button$")
    public void aUserClicksOnSendButton() throws Throwable
    {
        driverManager.driver.findElement(By.id("wpjb_submit")).click();
    }

    @Then("^Validation message should be displayed$")
    public void validationMessageShouldBeDisplayed() throws Throwable
    {
        Thread.sleep(1500); // pause for 15 seconds
        driverManager.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        String expectedError= "You need to upload at least one file.";

        String actualError = driverManager.driver.findElement(By.className("wpjb-errors")).getText();
        Assert.assertTrue(actualError.contains(expectedError));
    }

}