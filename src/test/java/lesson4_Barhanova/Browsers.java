package lesson4_Barhanova;

import io.github.bonigarcia.wdm.DriverManagerType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.Driver;

public class Browsers {
    private static final Logger logger = LogManager.getLogger(Browsers.class);

    DriverManager driverManager;
    WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        driverManager = WebDriverFactory.getManager(DriverNames.CHROME);
    }

    @BeforeMethod
    public  void  beforeMethod(){
        driver = driverManager.getDriver();
    }

    @AfterMethod
    public void afterMethod(){
        driverManager.quitDriver();
    }



    @Test
public void googleTest(){
        System.out.println("kj");
        driver.get("https://www.google.com");
        Assert.assertEquals("Google", driver.getTitle());
        logger.info("Тест №1 пройден успешно");
    }
}