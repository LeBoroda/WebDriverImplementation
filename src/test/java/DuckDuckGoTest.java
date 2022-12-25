import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class DuckDuckGoTest extends AbsTest{
    @Test
    public void duckDuckGoTest(){
        String inputLine = "Отус";
        String testLine = "Онлайн‑курсы для профессионалов, дистанционное обучение";

        setUpHeadlessDriver();

        driver.get("https://duckduckgo.com");
        clearAndEnter(By.id("search_form_input_homepage"), inputLine);
        driver.findElement(By.id("search_button_homepage")).submit();
        String firstResultText = driver.findElement(By.xpath("//*[@id='r1-0']")).getText();

        Assertions.assertTrue(firstResultText.contains(testLine));
    }

}
