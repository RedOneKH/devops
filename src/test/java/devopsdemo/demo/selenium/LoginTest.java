package devopsdemo.demo.selenium;

import devopsdemo.demo.DemoApplication;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(
classes = DemoApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LoginTest {

    private static WebDriver driver;

    @Value("${local.server.port}")
    private int port;

    @BeforeClass
    public static void openBrowser() {
        //System.setProperty("webdriver.chrome.driver","E:/chromedriver.exe");
        //driver = new ChromeDriver();
        //System.setProperty("webdriver.gecko.driver", "E:/geckodriver.exe");
        System.setProperty("webdriver.gecko.driver", "/home/redone/Downloads/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts() .implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void closeBrowser() {
        driver.quit();
    }


    @Test
    public void firstTest (){
        driver.get("http://localhost:"+port);

        driver.findElement(By.id("email")).sendKeys("redone@mail.io");
        driver.findElement(By.id("password")).sendKeys("pass123");
        driver.findElement(By.id("submit")).click();

        assertThat(true);
    }


}
