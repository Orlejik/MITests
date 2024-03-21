package Core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

abstract public class BaseSeleniumTest {
    protected WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        BaseSeleniumPage.setDriver(driver);
    }

    @After
    public void termDown() {
        try {
            Thread.sleep(5000);
            driver.close();
            driver.quit();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
