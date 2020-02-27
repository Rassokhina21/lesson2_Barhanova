package lesson4_Barhanova;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class WebDriverFactory {

    private static final Logger logger = LogManager.getLogger(WebDriverFactory.class);

    public static  DriverManager getManager(DriverNames type){
       DriverManager driverManager = null;
       WebDriverManager driver = null;

       switch (type){
           case CHROME:
               driverManager = new ChromeDriverManager();
               break;
           case FIREFOX:
               driverManager = new FirefoxDriverManager();
               break;
           default: logger.error("Невалидный параметр типа браузера");
           break;
       }
       return driverManager;
   }
}

