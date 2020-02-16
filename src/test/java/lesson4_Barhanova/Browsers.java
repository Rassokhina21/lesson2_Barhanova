package lesson4_Barhanova;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.Test;

public class Browsers {
    private static final Logger logger = LogManager.getLogger(Browsers.class);


    @Test
        public static void main(String[] args) {
            WebDriver wd = WebDriverFactory.createNewDriver("chrome");
            wd.get("https://otus.ru/");
            logger.info("WebDriverFactory успешно открыл браузер");
            wd.quit();
        }
    }
