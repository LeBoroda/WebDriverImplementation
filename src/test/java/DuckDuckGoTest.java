import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DuckDuckGoTest{

    WebDriver driver;
    @BeforeEach
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);
    }
    @Test
    public void duckDuckGoTest(){
        String inputLine = "Отус";
        String testLine = "Онлайн‑курсы для профессионалов, дистанционное обучение";

        driver.get("https://duckduckgo.com");

        driver.findElement(By.id("search_form_input_homepage")).clear();
        driver.findElement(By.id("search_form_input_homepage")).sendKeys(inputLine);
        driver.findElement(By.id("search_button_homepage")).submit();

        String firstResultText = driver.findElement(By.xpath("//*[@id='r1-0']")).getText();

        Assertions.assertTrue(firstResultText.contains(testLine));
    }
    @AfterEach
    public void close(){
        if(driver!=null)
            driver.quit();
    }

}