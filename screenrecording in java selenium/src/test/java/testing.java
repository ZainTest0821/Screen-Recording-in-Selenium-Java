import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import src.ScreenRecorderUtil;
import java.time.Duration;

public class testing {

    WebDriver driver;

    
    @BeforeMethod
    public void Launch() throws Exception {

        ScreenRecorderUtil.startRecord("Launch");
        WebDriverManager.firefoxdriver();
        driver= new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");

    }
    @AfterMethod
    void teardown() throws Exception {
        ScreenRecorderUtil.stopRecord();
        driver.quit();
    }
    @Test
    void fb() throws Exception {
        Wait<WebDriver> wait= new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        WebElement test= wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
        test.sendKeys("Elion Misk");

        WebElement passoword= wait.until(ExpectedConditions.elementToBeClickable(By.id("pass")));
        passoword.sendKeys("Elion Musk");

        WebElement loginclick =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='u_0_5_tn']")));
        loginclick.click();

        ScreenRecorderUtil.stopRecord();

    }
}
