package lesson4_Barhanova;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public  class ChromeDriverManager extends DriverManager {

        private ChromeDriverService chService;


@Override
    protected void startService() {
                if (null == chService){
            try {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
@Override
    protected void stopService() {
        if (null != chService && chService.isRunning())
            chService.stop();
    }
}
