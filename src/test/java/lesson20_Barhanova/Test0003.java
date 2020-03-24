package lesson20_Barhanova;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Test0003 {
    private static final Logger logger = LogManager.getLogger(Test0003.class);


    private WebDriver driver;
    private String localUrl = "http://0.0.0.0:4444/wd/hub";
    private String companyLink = "//a[5]/h3";
    private String companyTitle = "Компании / Хабр";


    @BeforeMethod
    void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();//настройка окружения для тестов
        capabilities.setBrowserName("chrome");//в каком браузере запустить тесты
        capabilities.setVersion("79.0");//версия браузера
        capabilities.setCapability("enableVNC", true);//для просмотра в селедноиде что происходит с тестом (опционально)
        capabilities.setCapability("enableVideo", false);//разрешение записывать видео (опционально)
        //"http://0.0.0.0:4444/wd/hub"
        driver = new RemoteWebDriver((new URL(localUrl)),capabilities);


        driver.get("https://habr.com/ru/");
    }

    @Test
    void test(){
        driver.findElement(By.xpath(companyLink)).click();
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, companyTitle);
        logger.info("Тест 0003 прошел успешно");


    }

    @AfterMethod
    void tearDown(){
        driver.quit();
    }
}
