package lesson4_Barhanova;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;


public class FirefoxDriverManager extends DriverManager{
    private GeckoDriverService firefoxService;

@Override
    protected void startService() {
        if (null == firefoxService){
            try {
                WebDriverManager.firefoxdriver().setup();
                driver= new FirefoxDriver();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
@Override
    protected void stopService() {
    if (null != firefoxService && firefoxService.isRunning())
        firefoxService.stop();

    }


}
