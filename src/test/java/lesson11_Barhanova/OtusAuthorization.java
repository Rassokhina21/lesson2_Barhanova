package lesson11_Barhanova;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

 public class OtusAuthorization{

    private static final Logger logger = LogManager.getLogger(OtusAuthorization.class);
     public static WebDriver driver;

     public static String otusUrl = "https://otus.ru";
     public static String emailOtus = "lekalarina@mail.ru";//"ebarhanova@mail.ru";
     public static String passOtus = "392846Sniff";//"123456789Otus";

     public static String personalDataFirstName = "Елена";
     public static String personalDataLastName = "Барханова";
     public static String personalDataFirstNameLatin = "Elena";
     public static String personalDataLastNameLatin = "Barhanova";
     public static String personalDataBlogName = "Елена Барханова";
     public static String personalDataBirthday = "21.05.1992";
     public static String personalDataPhoneOne = "+375255178852";
     public static String PersonalDataPhoneTwo = "+375255177788";



     public static void OtusAutorizationAndAddPersonalData (){
         WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        try{
            driver.get(otusUrl);
            logger.info("Открылся сайт Otus.ru");
        }catch(Exception e) {
            logger.error("Сайт Otus.ru не открылся");
        }
        try {
            driver.findElement(By.xpath("//button[contains(.,'Вход и регистрация')]")).click();
            driver.findElement(By.cssSelector(".new-input-line:nth-child(3) > .new-input")).sendKeys(emailOtus);
            driver.findElement(By.cssSelector(".js-psw-input")).sendKeys(passOtus);
            driver.findElement(By.cssSelector(".new-input-line_relative > .new-button")).click();
            logger.info("Пользователь залогинен на сайте Otus.ru");
        }catch (Exception e){
            logger.error("Пользователь не залогинен на сайте Otus.ru\"");
        }
        try {
            driver.findElement(By.xpath("//header[2]/div/div[3]/a")).click();
            driver.findElement(By.xpath("(//a[contains(@href, '/lk/biography/personal/')])[2]")).click();
            logger.info("Открыт личный кабинет пользователя");
        }catch (Exception e){
            logger.error("Личный кабинет пользователя не открыт");
        }

        try {
            driver.findElement(By.xpath("//input[@id='id_fname']")).clear();
            driver.findElement(By.xpath("//input[@id='id_fname']")).sendKeys(personalDataFirstName);
            logger.info("Заполнено имя");
            driver.findElement(By.xpath("//input[@id='id_lname']")).clear();
            driver.findElement(By.xpath("//input[@id='id_lname']")).sendKeys(personalDataLastName);
            logger.info("Заполнена фамилия");
            driver.findElement(By.xpath("//input[@id='id_fname_latin']")).clear();
            driver.findElement(By.xpath("//input[@id='id_fname_latin']")).sendKeys(personalDataFirstNameLatin);
            logger.info("Заполнено имя на латинском");
            driver.findElement(By.xpath("//input[@id='id_lname_latin']")).clear();
            driver.findElement(By.xpath("//input[@id='id_lname_latin']")).sendKeys(personalDataLastNameLatin);
            logger.info("Заполнена фамилия на латинском");
            driver.findElement(By.xpath("//input[@id='id_blog_name']")).clear();
            driver.findElement(By.xpath("//input[@id='id_blog_name']")).sendKeys(personalDataBlogName);
            logger.info("Заполнено имя в блоге");
            driver.findElement(By.xpath("//input[@name='date_of_birth']")).clear();
            driver.findElement(By.xpath("//input[@name='date_of_birth']")).sendKeys(personalDataBirthday);
            logger.info("Заполнена дата рождения");
        }catch (Exception e){
            logger.error("Блок с личными данными не заполнен");
        }
        try{
            driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
            driver.findElement(By.xpath("//input[@id='id_contact-1-value']")).clear();
            driver.findElement(By.xpath("//input[@id='id_contact-1-value']")).sendKeys(personalDataPhoneOne);
            driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
            driver.findElement(By.xpath("//input[@id='id_contact-2-value']")).clear();
            driver.findElement(By.xpath("//input[@id='id_contact-2-value']")).sendKeys(PersonalDataPhoneTwo);
            logger.info("Добавлено два контакта");
        }catch (Exception e){
            logger.error("Два контакта не добавлено");
        }
        driver.findElement(By.xpath("//button[@name='continue']")).click();
         driver.quit();
    }

    public static void checkOtusPersonalData(){
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        try{
            driver.get(otusUrl);
            driver.findElement(By.xpath("//button[contains(.,'Вход и регистрация')]")).click();
            driver.findElement(By.cssSelector(".new-input-line:nth-child(3) > .new-input")).sendKeys(emailOtus);
            driver.findElement(By.cssSelector(".js-psw-input")).sendKeys(passOtus);
            driver.findElement(By.cssSelector(".new-input-line_relative > .new-button")).click();
            logger.info("Пользователь залогинен на сайте Otus.ru");
            driver.findElement(By.xpath("//header[2]/div/div[3]/a")).click();
            driver.findElement(By.xpath("(//a[contains(@href, '/lk/biography/personal/')])[2]")).click();
            logger.info("Пользователь залогинен и вошел в личный кабинет");
        }catch (Exception e){
            logger.error("Пользователь не вошел в личный кабинет");
        }
        try {
            String name = driver.findElement(By.xpath("//input[@id='id_fname']")).getText();
            Assert.assertEquals(personalDataFirstName, "Елена");
            logger.info("Имя эквивалентно заданному");

        }catch (Exception e){
            logger.error("Имя не эквивалентно заданному");
        }
        try {
            String name = driver.findElement(By.xpath("//input[@id='id_lname']")).getText();
            Assert.assertEquals(personalDataLastName, "Барханова");
            logger.info("Фамилия эквивалентна заданной");

        }catch (Exception e){
            logger.error("Фамилия не эквивалентна заданной");
        }
        try {
            String name = driver.findElement(By.xpath("//input[@id='id_fname_latin']")).getText();
            Assert.assertEquals(personalDataFirstNameLatin, "Elena");
            logger.info("Имя латиницей эквивалентно заданному");

        }catch (Exception e){
            logger.error("Имя латиницей не эквивалентно заданному");
        }
        try {
            String name = driver.findElement(By.xpath("//input[@id='id_fname_latin']")).getText();
            Assert.assertEquals(personalDataLastNameLatin, "Barhanova");
            logger.info("Фамилия латиницей эквивалентна заданной");

        }catch (Exception e){
            logger.error("Фамилия латиницей не эквивалентна заданной");
        }
        try {
            String name = driver.findElement(By.xpath("//input[@id='id_blog_name']")).getText();
            Assert.assertEquals(personalDataBlogName, "Елена Барханова");
            logger.info("Имя в блоге эквивалентно заданному");

        }catch (Exception e){
            logger.error("Имя в блоге не эквивалентно заданному");
        }
        try {
            String name = driver.findElement(By.xpath("//input[@name='date_of_birth']")).getText();
            Assert.assertEquals(personalDataBirthday, "21.05.1992");
            logger.info("Дата рождения эквивалентна заданной");

        }catch (Exception e){
            logger.error("Дата рождения не эквивалентна заданной");
        }
        driver.quit();
    }
}