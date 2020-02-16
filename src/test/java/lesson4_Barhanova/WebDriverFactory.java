package lesson4_Barhanova;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    public static WebDriver createNewDriver(String nameDriver){
        WebDriver driver = null;
        if("FIREFOX".equalsIgnoreCase(nameDriver)){
            WebDriverManager.firefoxdriver().setup();
            driver= new FirefoxDriver();
        }
        else if("CHROME".equalsIgnoreCase(nameDriver)){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if("EDGE".equalsIgnoreCase(nameDriver)){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }else {
            throw new RuntimeException("Невалидный параметр типа брауера");
        }
        return driver;

    }
}
