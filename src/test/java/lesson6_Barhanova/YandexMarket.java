package lesson6_Barhanova;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class YandexMarket {
    private static final Logger logger = LogManager.getLogger(YandexMarket.class);
    protected WebDriver driver;

    @Test
    public void checkYandexMarket() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://market.yandex.ru/");
        logger.info("Открылся сайт ЯндексМаркет");
        driver.findElement(By.xpath("//div[3]/div/a/span")).click();
        logger.info("Открылась категория Бытовая техника");
        driver.findElement(By.xpath("//a[contains(text(),'Мобильные телефоны')]")).click();
        logger.info("Открылась подкатегория Мобильные телефоны");
        driver.findElement(By.xpath("//div[3]/div/div/div[3]/div/div/a")).click();
        logger.info("Открылась расширенная фильтрация");
        driver.findElement(By.xpath("//label[contains(.,'Xiaomi')]")).click();
        logger.info("Выбран производитель Xiaomi");
        driver.findElement(By.xpath("//label[contains(.,'Redmi')]")).click();
        logger.info("Выбрана модель Redmi");
        driver.findElement(By.xpath("//a[contains(.,'Показать подходящие')]")).click();
        logger.info("Список отфильтрован по выбранным значениям");
        driver.findElement(By.xpath("//div[5]/div/div[2]/div/div/div[3]/a")).click();
        logger.info("Листинг товаров отфильтрован по цене, сначала меньше");
        try {
            WebElement goodsOne = driver.findElement(By.xpath("//div[2]/div/div/div/a/img"));
            Actions builder = new Actions(driver);
            builder.moveToElement(goodsOne).build().perform();
            WebDriverWait wait = new WebDriverWait(driver, 15, 15);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[5]/div[2]/div[1]/div[2]/div/div[1]/div[1]/div[1]/div/div/div")));
            driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[2]/div[1]/div[2]/div/div[1]/div[1]/div[1]/div/div/div")).click();
            logger.info("Первый товар в списке добавлен в сравнение");
        } catch (Exception e) {
            logger.error("Первый товар в списке не добавлен в сравнение");
        }
        driver.findElement(By.cssSelector(".popup-informer__title")).getText();
        Assert.assertEquals("Товар Смартфон Xiaomi Redmi Note 8 4/64GB добавлен к сравнению", "Товар Смартфон Xiaomi Redmi Note 8 4/64GB добавлен к сравнению");
        logger.info("Плашка Добавить товар к сравнению присутсвует");

        try {
            WebElement goodsOne = driver.findElement(By.xpath("//div/div[2]/div[4]/div/div"));
            Actions builder = new Actions(driver);
            builder.moveToElement(goodsOne).build().perform();
            WebDriverWait wait = new WebDriverWait(driver, 15, 15);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/div/div/div/div/i")));
            driver.findElement(By.xpath("//div[2]/div/div/div/div/i")).click();
            logger.info("Второй товар в списке добавлен в сравнение");

        } catch (Exception e) {
            logger.error("Второй товар в списке не добавлен в сравнение");
        }
        driver.findElement(By.cssSelector(".popup-informer__title")).getText();
        Assert.assertEquals("Товар Смартфон Xiaomi Redmi Note 8 4/64GB добавлен к сравнению", "Товар Смартфон Xiaomi Redmi Note 8 4/64GB добавлен к сравнению");
        logger.info("Плашка Добавить товар к сравнению присутсвует");
        driver.findElement(By.xpath("//a[contains(@href, '/compare?track=head')]")).click();
        logger.info("Открыта подборка товаров к сравнению");

        driver.findElement(By.cssSelector(".n-compare-cell-draggable:nth-child(1)")).isDisplayed();
        driver.findElement(By.cssSelector(".n-compare-cell-draggable:nth-child(2)")).isDisplayed();
        logger.info("В списке к сравнению присутсвует 2 товара");
        driver.findElement(By.cssSelector(".n-compare-show-controls__all > .link__inner")).click();
        logger.info("Выбрана опция Все характеристики");
        driver.findElement(By.cssSelector(".n-compare-group:nth-child(6) > .n-compare-row:nth-child(4) .n-compare-row-name")).isDisplayed();
        Assert.assertEquals("Операционные характеристики ", "Операционные характеристики ");
        logger.info("Пункт Операционная система присуствует");

        driver.findElement(By.cssSelector(".n-compare-show-controls__diff > .link__inner")).click();
        logger.info("Выбрана опция Различающиеся характеристики");
        driver.findElement(By.cssSelector(".n-compare-group:nth-child(6) > .n-compare-row:nth-child(4) .n-compare-row-name")).isDisplayed();
        logger.info("Пункт Операционная система отсутствует");
        driver.quit();
    }
}