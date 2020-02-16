package lesson4_Barhanova;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    private static final Logger logger = LogManager.getLogger(WebDriverFactory.class);


    public static WebDriver createNewDriver(String nameDriver){
        WebDriver driver = null;
        if("FIREFOX".equalsIgnoreCase(nameDriver)){
            WebDriverManager.firefoxdriver().setup();
            driver= new FirefoxDriver();
            logger.info("Параметром выбран браузер FireFox");

        }
        else if("CHROME".equalsIgnoreCase(nameDriver)){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            logger.info("Параметром выбран браузер Chrome");
        }
        else if("EDGE".equalsIgnoreCase(nameDriver)){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            logger.info("Параметром выбран браузер EDGE");
        }else {
            throw new RuntimeException("Невалидный параметр типа браузера");
        }
        return driver;

    }
}
