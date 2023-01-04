import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OtusTest{
    WebDriver driver;
    @BeforeEach
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public static Logger log = LogManager.getLogger(OtusTest.class);
    @Test
    public void otusTest(){

        String URL = "https://otus.ru";
        String login = "watolak806@dni8.com";
        String password = "Stantestpassword1!";

        driver.get(URL);
        driver.findElement(By.cssSelector(".header3__button-sign-in")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='new-log-reg__form js-login']/descendant::*[@placeholder='Электронная почта']")));

        clearAndEnter(By.xpath("//*[@class='new-log-reg__form js-login']/descendant::*[@placeholder='Электронная почта']"), login);
        clearAndEnter(By.xpath("//*[@class='new-log-reg__form js-login']/descendant::*[@placeholder='Введите пароль']"), password);
        driver.findElement(By.cssSelector("div.new-input-line_last:nth-child(5) > button:nth-child(1)")).submit();

        for(Cookie cookie: driver.manage().getCookies())
            System.out.println(String.format("Cookie <%s>:<%s>", cookie.getName(), cookie.getValue()));
        Assertions.assertTrue(log.isInfoEnabled());
    }

    public void clearAndEnter(By by, String line){
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(line);
    }

    @AfterEach
    public void close(){
        if(driver!=null)
            driver.quit();
    }

}
