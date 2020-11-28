package Gun01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class _04_Enable {
    public static WebDriver driver;

    @BeforeClass
    void BeforeClass()
    {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("http://opencart.abstracta.us/index.php?route=account/login");
    }

    @AfterClass
    void AfterClass() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    void test1()
    {
       String u1=driver.getCurrentUrl();

        System.out.println(u1);
    }

    @Test(enabled = false)
    void test2()
    {
        String u2=driver.getTitle();

        System.out.println(u2);
    }

    @Test
    void test3()
    {
        String handle=driver.getWindowHandle();

        System.out.println(handle);
    }
}
