import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AbsTest {
    WebDriver driver;
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    public void setUpHeadlessDriver (){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);
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
