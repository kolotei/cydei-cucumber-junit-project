package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver(){}

    private static WebDriver driver;

    public static WebDriver getDriver(){
        if(driver == null){
            String browserType = ConfigurationReader.getProperty("browser");

    /*
    Depending on the browserType our switch statement will determine
    to open specific type of the browser/driver
    */
            switch (browserType){
                case "chrome":
                    //WebDriverManager.chromedriver().setup(); no more dependency
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

                case "firefox":
                    //WebDriverManager.firefoxdriver().setup(); no more dependency
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }
        }

//Same driver will be returned everytime we call Driver.getDriver() method
        return driver;
    }


    public static void closeDriver(){

        if (driver != null) {
            driver.quit(); // killing driver sesion
            driver = null;
        }

    }


}
