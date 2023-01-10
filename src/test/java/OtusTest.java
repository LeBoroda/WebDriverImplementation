import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OtusTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
    }

    @BeforeAll
    public static void init() {
        WebDriverManager.chromedriver().setup();
    }

    public static Logger log = LogManager.getLogger(OtusTest.class);

    @Test
    public void otusTest() {

        String URL = "https://otus.ru";
        String login = "watolak806@dni8.com";
        String password = "Stantestpassword1!";

        driver.get(URL);
        driver.findElement(By.cssSelector(".header3__button-sign-in")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@type = 'text' and @name='email' and @placeholder = 'Электронная почта']")));

        clearAndEnter(By.xpath("//*[@type = 'text' and @name='email' and @placeholder = 'Электронная почта']"), login);
        clearAndEnter(By.xpath("//*[@type = 'password' and @name='password' and @placeholder = 'Введите пароль']"), password);
        driver.findElement(By.xpath("//button[@class='new-button new-button_full new-button_blue new-button_md' and @type='submit']")).submit();
        for (Cookie cookie : driver.manage().getCookies())
            System.out.printf("Cookie <%s>:<%s>%n", cookie.getName(), cookie.getValue());
        Assertions.assertTrue(log.isInfoEnabled());
    }

    public void clearAndEnter(By by, String line) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(line);
    }

    @AfterEach
    public void close() {
        if (driver != null)
            driver.quit();
    }

}
