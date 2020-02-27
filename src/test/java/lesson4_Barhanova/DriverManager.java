package lesson4_Barhanova;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

        protected WebDriver driver;
        protected abstract void startService();
        protected abstract void stopService();



        public void quitDriver() {
            if (null != driver) {
                driver.quit();
                driver = null;
            }
        }

        public WebDriver getDriver() {
            if (null == driver) {
                startService();
            }
            return driver;
        }
    }

