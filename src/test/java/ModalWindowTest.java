import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ModalWindowTest extends AbsTest {

    @Test
    public void modalWindowTest() {
        String URL = "https://demo.w3layouts.com/demos_new/template_demo/03-10-2020/photoflash-liberty-demo_Free/685659620/web/index.html?_ga=2.181802926.889871791.1632394818-2083132868.1632394818";

        setUp();
        driver.manage().window().maximize();
        driver.get(URL);


        WebElement element = driver.findElement(By.xpath("//*[@class='image-zoom']"));

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click()", element);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Assertions.assertTrue(driver.findElement(By.xpath("//*[@class='pp_hoverContainer']")).isDisplayed());
    }

}
