import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;


@Listeners(ExecutionListener.class)

public class FirstTest {

    private static final Logger logger = LogManager.getLogger(FirstTest.class);
    protected WebDriver driver;


    @Test
    public void checkForBrowsers() {

      int BrowserType = 1;
        //Если нужно выполнить в Chrome, выставить BrowserType = 1
        //Если нужно выполнить в Firefox, выставить BrowserType = 2

        if (BrowserType == 1) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

            try {
                driver.get(" https://otus.ru/");
                logger.info("Открылся сайт Otus.ru в браузере Google");
            } catch (Exception ex) {
                logger.error("Cайт Otus.ru не открыт в браузере Google");
            }
            driver.quit();
        }
        else  {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            try {
                driver.get(" https://otus.ru/");
                logger.info("Открылся сайт Otus.ru в браузере Firefox");
            } catch (Exception ex) {
                logger.error("Cайт Otus.ru не открыт браузере Firefox");
            }
            driver.quit();

        }
    }

    public static void main(String[] args) {

        logger.info("INFO");
        logger.debug("DEBUG");
        logger.error("ERROR");
        logger.fatal("FATAL");
        logger.warn("WARN");
    }
}


