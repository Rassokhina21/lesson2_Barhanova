package lesson13_Barhanova;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class Habrheader {
    private static final Logger logger = LogManager.getLogger(Habrheader.class);
    public static WebDriver driver;

    public static String habrUrl = "https://habr.com/ru/";

    //вкладки
    public static String buttonAllTreads = "//ul[@id='navbar-links']/li/a";
    public static String buttonDevelopers = "//ul[@id='navbar-links']/li[2]/a";
    public static String buttonPopsCi = "//ul[@id='navbar-links']/li[3]/a";
    public static String buttonAdmin = "//ul[@id='navbar-links']/li[4]/a";
    public static String buttonDesign = "//ul[@id='navbar-links']/li[5]/a";
    public static String buttonMarketing = "//ul[@id='navbar-links']/li[7]/a";

    @BeforeClass
    public static void setUpClass() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


    public static void checButtonAllTreads() {
        driver.findElement(By.xpath(buttonAllTreads)).click();
        Assert.assertEquals("Все публикации подряд / Хабр", driver.getTitle());
    }

    public static void checButtonDevelopers() {
        driver.findElement(By.xpath(buttonDevelopers)).click();
        Assert.assertEquals("Все публикации в потоке Разработка / Хабр", driver.getTitle());
    }

    public static void checButtonPopSi() {
        driver.findElement(By.xpath(buttonPopsCi)).click();
        Assert.assertEquals("Все публикации в потоке Научпоп / Хабр", driver.getTitle());
    }

    public static void checButtonAdmin() {
        driver.findElement(By.xpath(buttonAdmin)).click();
        Assert.assertEquals("Все публикации в потоке Администрирование / Хабр", driver.getTitle());
    }

    public static void checButtonDesign() {
        driver.findElement(By.xpath(buttonDesign)).click();
        Assert.assertEquals("Все публикации в потоке Дизайн / Хабр", driver.getTitle());
    }

    public static void checkButtonmarketing() {
        driver.findElement(By.xpath(buttonMarketing)).click();
        Assert.assertEquals("Все публикации в потоке Маркетинг / Хабр", driver.getTitle());
    }
}

//    public static void openStringSearch(String textForSearch) {
//        Actions builder = new Actions(driver);
//        WebElement textField = driver.findElement(By.xpath(buttonSearch));
//        textField.sendKeys(textForSearch + Keys.ENTER);
//        driver.findElement(By.xpath(buttonSearch)).sendKeys(textForSearch);
//        driver.findElement(By.xpath(buttonSearch)).submit();
//    }
//"        @Test
//    public static void checkButtonLanguage(){
//        driver.findElement(By.xpath(buttonLanguage)).click();
//        driver.findElement(By.xpath(buttonRadiobattonLanguageRus)).click();
//}
//
//    public static void checkRadiobattonLanguageRus(){
//        driver.findElement(By.xpath(buttonRadiobattonLanguageRus)).click();
//    }



