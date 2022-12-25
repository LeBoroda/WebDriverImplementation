import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class OtusTest extends AbsTest{

    public static Logger log = LogManager.getLogger(OtusTest.class);
    @Test
    public void otusTest(){

        String URL = "https://otus.ru";
        String login = "watolak806@dni8.com";
        String password = "Stantestpassword1!";

        setUp();
        driver.get(URL);
        driver.findElement(By.cssSelector(".header3__button-sign-in")).click();

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        clearAndEnter(By.xpath("//*[@class='new-log-reg__form js-login']/descendant::*[@placeholder='Электронная почта']"), login);
        clearAndEnter(By.xpath("//*[@class='new-log-reg__form js-login']/descendant::*[@placeholder='Введите пароль']"), password);
        driver.findElement(By.cssSelector("div.new-input-line_last:nth-child(5) > button:nth-child(1)")).submit();

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        log.info(driver.manage().getCookies());
        Assertions.assertTrue(log.isInfoEnabled());

    }
}
