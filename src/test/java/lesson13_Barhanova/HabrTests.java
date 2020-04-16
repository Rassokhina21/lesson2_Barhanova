package lesson13_Barhanova;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HabrTests {

    private static final Logger logger = LogManager.getLogger(HabrTests.class);
    public static WebDriver driver;

    //список необходимых перемменных
    public static String habrUrl = "https://habr.com/ru/";
    public static String buttonLanguage = "//div[2]/button";
    public static String buttonRadiobattonLanguageRus = "//form[@id='lang-settings-form']/fieldset/div[2]/label/span";
    public static String getButtonLanguageSave = "//form[@id='lang-settings-form']/div/button";
    public static String buttonRadiobattonLanguageEng = "//form[@id='lang-settings-form']/fieldset/div[2]/label/span";
    public static String buttonHowToBecomeToAutor = "//a[contains(@href, 'https://habr.com/sandbox/start/')]";
    public static String buttonWritePost = "//a[contains(@href, '/ru/sandbox/add/')]";
    public static String buttonAllArticles = "//div[2]/ul/li/a";
    public static String buttonTopArticles = "(//a[contains(@href, 'https://habr.com/ru/top/')])[2]";

    //переменные для авторизации
    public static String buttonSignIn = "//a[@id='login']";
    public static String inputFieldEmail = "//form[@id='login_form']/fieldset/div/input";
    public static String inputFieldPass = "//input[@id='password_field']";
    public static String buttonSignInAutorizathionForm = "//button[@name='go']";

    //переменные с данными для аторизации
    public static String validEmail = "e.barhanova@21vek.by";
    public static String validPass = "LcpCX27Csnd_BLW";
    public static String invalidEmail = "test@test.test";
    public static String invalidPass = "LcpCX27Csnd_BLW";


    @BeforeClass
    public static void setUpClass() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }

    //Тест №1
    @Test
    public void checkTitleHabr() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(habrUrl);
        try {
            Assert.assertEquals("Лучшие публикации за сутки / Хабр", driver.getTitle());
            logger.info("Тест №1. Провека title сайта Habr.com прошла успешно");
        } catch (Exception e) {
            logger.error("Тест №1. Провека title сайта Habr.com прошла неуспешно");
        }
        driver.quit();
    }
    //Тест №2
    @Test
    public void testNavigationBarTabs() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(habrUrl);

        try {
            try {
                Habrheader.checButtonAllTreads();
                logger.info("Вкладка Все потоки успешно открыта");
            } catch (Exception e) {
                logger.error("Вкладка Все потоки не открыта");
            }
            try {
                Habrheader.checButtonDevelopers();
                logger.info("Вкладка Разработка успешно открыта");
            } catch (Exception e) {
                logger.error("Вкладка Разработка не открыта");
            }
            try {
                Habrheader.checButtonPopSi();
                logger.info("Вкладка Научпоп успешно открыта");
            } catch (Exception e) {
                logger.error("Вкладка Научпоп не открыта");
            }
            try {
                Habrheader.checButtonAdmin();
                logger.info("Вкладка Администрирование успешно открыта");
            } catch (Exception e) {
                logger.error("Вкладка Администрирование не открыта");
            }
            try {
                Habrheader.checButtonDesign();
                logger.info("Вкладка Дизайн успешно открыта");
            } catch (Exception e) {
                logger.error("Вкладка Дизайн не открыта");
            }
            try {
                Habrheader.checkButtonmarketing();
                logger.info("Вкладка Маркетинг успешно открыта");
            } catch (Exception e) {
                logger.error("Вкладка Маркетинг не открыта");
            }
            logger.info("Тест №2. Проверка типов вкладок прошел успешно");
        } catch (Exception e) {
            logger.error("Тест №2. Проверка типов вкладок прошел неуспешно");
        }
        driver.quit();
    }
    //Тест №3
    @Test
    public void testSwitchingToRussian() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(habrUrl);
        try {
            driver.findElement(By.xpath(buttonLanguage)).click();
            driver.findElement(By.xpath(buttonRadiobattonLanguageRus)).click();
            logger.info("Тест №3. Выбор русского языка прошел успешно");
        } catch (Exception e) {
            logger.error("Тест №3. Выбор русского языка прошел неуспешно");
        }
        driver.quit();
    }
    //Тест №4
    @Test
    public void testSwitchingToRusAndSave() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(habrUrl);
        try {
            driver.findElement(By.xpath(buttonLanguage)).click();
            driver.findElement(By.xpath(buttonRadiobattonLanguageRus)).click();
            driver.findElement(By.xpath(getButtonLanguageSave));
            logger.info("Тест №4. Выбор русского языка и сохранение результата прошло успешно");
        } catch (Exception e) {
            logger.error("Тест №4. Выбор русского языка и сохранение результата прошло успешно");
        }
        driver.quit();
    }
    //Тест №5
    @Test
    public void testSwitchingToEnglish() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(habrUrl);
        try {
            driver.findElement(By.xpath(buttonLanguage)).click();
            driver.findElement(By.xpath(buttonRadiobattonLanguageEng)).click();
            logger.info("Тест №5. Выбор английского языка прошел успешно");
        } catch (Exception e) {
            logger.error("Тест №5. Выбор английского языка прошел неуспешно");
        }
        driver.quit();
    }
    //Тест №6
    @Test
    public void testSwitchingToEngAndSave() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(habrUrl);
        try {
            driver.findElement(By.xpath(buttonLanguage)).click();
            driver.findElement(By.xpath(buttonRadiobattonLanguageEng)).click();
            driver.findElement(By.xpath(getButtonLanguageSave));
            logger.info("Тест №6. Выбор английского языка и сохранение результата прошло успешно");
        } catch (Exception e) {
            logger.error("Тест №6. Выбор английского языка и сохранение результата прошло успешно");
        }
        driver.quit();
    }
    //Тест №7
    @Test
    public static void checkHowToBecomeToAutor() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(habrUrl);
        try {
            driver.findElement(By.xpath(buttonHowToBecomeToAutor)).click();
            logger.info("Тест №7. Проверка доступности кнопки Как стать автором прошла успешно");
        } catch (Exception e) {
            logger.error("Тест №7. Проверка доступности кнопки Как стать автором прошла неуспешно");
        }
        driver.quit();
    }
    //Тест №8
    @Test
    public static void checkWritePost() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(habrUrl);
        try {
            driver.findElement(By.xpath(buttonHowToBecomeToAutor)).click();
            driver.findElement(By.xpath(buttonWritePost));
            logger.info("Тест №8. Проверка доступности кнопки Написать пост прошла успешно");
        } catch (Exception e) {
            logger.error("Тест №8. Проверка доступности кнопки Написать пост автором прошла неуспешно");
        }
        driver.quit();
    }
    //Тест №9
    @Test
    public static void  checkButtonSignIn(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(habrUrl);
        try {
            driver.findElement(By.xpath(buttonSignIn)).click();
            logger.info("Тест №9. Проверка доступности кнопки Войти прошла успешно");
        }catch (Exception e){
            logger.error("Тест №9. Проверка доступности кнопки Войти прошла успешно");
        }
        driver.quit();
    }
    //Тест №10
    @Test
    public static void  checkSuccessfulAuthorization(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(habrUrl);
        try {
            driver.findElement(By.xpath(buttonSignIn)).click();
            driver.findElement(By.xpath(inputFieldEmail)).sendKeys(validEmail);
            driver.findElement(By.xpath(inputFieldPass)).sendKeys(validPass);
            driver.findElement(By.xpath(buttonSignInAutorizathionForm)).click();
            logger.info("Тест №10. Проверка входа с валидными авторизационными данными прошла успешно");
        }catch (Exception E){
            logger.error("Тест №10. Проверка входа с валидными авторизационными данными прошла успешно");
        }
        driver.quit();
    }
    //Тест №11
    @Test
    public static void  checkUnsuccessfulAuthorizationInvalidEmail(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(habrUrl);
        try {
            driver.findElement(By.xpath(buttonSignIn)).click();
            driver.findElement(By.xpath(inputFieldEmail)).sendKeys(invalidEmail);
            driver.findElement(By.xpath(inputFieldPass)).sendKeys(validPass);
            driver.findElement(By.xpath("//span[@id='recaptcha-anchor']/div")).click();
            driver.findElement(By.xpath(buttonSignInAutorizathionForm)).click();
            logger.info("Тест №11. Проверка невозможности входа с невалидными (email) авторизационными данными прошла успешно");
        }catch (Exception E){
            logger.error("Тест №11. Проверка невозможности входа с невалидными (email) авторизационными данными прошла неуспешно");
        }
        driver.quit();
    }
    //Тест №12
    @Test
    public static void  checkUnsuccessfulAuthorizationInvalidPass(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(habrUrl);
        try {
            driver.findElement(By.xpath(buttonSignIn)).click();
            driver.findElement(By.xpath(inputFieldEmail)).sendKeys(validEmail);
            driver.findElement(By.xpath(inputFieldPass)).sendKeys(invalidPass);
            driver.findElement(By.xpath(buttonSignInAutorizathionForm)).click();
            logger.info("Тест №12. Проверка невозможности входа с невалидными (pass) авторизационными данными прошла успешно");
        }catch (Exception E){
            logger.error("Тест №12. Проверка невозможности входа с невалидными (pass) авторизационными данными прошла неуспешно");
        }
        driver.quit();
    }
    //Тест №13
    @Test
    public static void  checkUnsuccessfulAuthorizationOffSaveButton(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(habrUrl);
        try {
            driver.findElement(By.xpath(buttonSignIn)).click();
            driver.findElement(By.xpath(inputFieldEmail)).sendKeys(validEmail);
            driver.findElement(By.xpath(inputFieldPass)).sendKeys(validPass);
            driver.findElement(By.xpath(buttonSignInAutorizathionForm)).click();
            logger.info("Тест №13. Проверка невозможности входа с валидными авторизационными данными, но не нажатии кнопки Войти прошла успешно");
        }catch (Exception E){
            logger.error("Тест №13. Проверка невозможности входа с невалидными (pass) авторизационными данными, но не нажатии кнопки Войти  прошла неуспешно");
        }
        driver.quit();
    }
    //Тест №14
    @Test
    public static void checkSwitchingToAllArticles(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(habrUrl);
        try {
            driver.findElement(By.xpath(buttonAllArticles)).click();
            Assert.assertEquals("Все публикации подряд / Хабр", driver.getTitle());
            logger.info("Тест №14. Проверка переключения на все публикаици подряд прошла успешно");
        }catch (Exception e){
            logger.error("Тест №14. Проверка переключения на все публикаици подряд прошла успешно");
        }
    }
    //Тест №15
    @Test
    public static void checkSwitchingToTopArticles(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(habrUrl);
        try {
            driver.findElement(By.xpath(buttonAllArticles)).click();
            driver.findElement(By.xpath(buttonTopArticles)).click();
            Assert.assertEquals("Лучшие публикации за сутки / Хабр", driver.getTitle());
            logger.info("Тест №14. Проверка переключения на все публикаици подряд прошла успешно");
        }catch (Exception e){
            logger.error("Тест №14. Проверка переключения на все публикаици подряд прошла успешно");
        }
        driver.quit();
    }




}











