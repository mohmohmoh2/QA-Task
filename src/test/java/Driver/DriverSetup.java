package Driver;

import DriverSettings.DriverManager;
import Utilities.LogsUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.time.Duration;

import static DriverSettings.DriverManager.*;
import static Utilities.DataUtils.getPropertyValue;

public class DriverSetup {


    @BeforeMethod
    public void setUp() throws IOException {
        String driverType = getPropertyValue("config", "driverType");
        WebDriver driver = DriverManager.createDriver(driverType);
        setDriver(driver);
        getDriver().get(getPropertyValue("config", "BASE_URL"));
        LogsUtils.info(driverType + " driver is opened");
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        quitDriver();
    }
}
