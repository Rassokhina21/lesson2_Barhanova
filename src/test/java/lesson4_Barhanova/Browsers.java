package lesson4_Barhanova;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.Test;

public class Browsers {

        @Test
        public static void main(String[] args) {
            WebDriver wd = WebDriverFactory.createNewDriver("chrome");
            wd.get("https://otus.ru/");
            wd.quit();
        }
    }
