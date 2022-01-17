package com.omGroupInc.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    private Driver(){
    }
    public static WebDriver getDriver(){
        if (driverPool.get()==null){
            synchronized (Driver.class){
                String browser = ConfigurationReader.getProperty("browser");

                if(System.getProperty("browser") != null){
                    System.out.println("Browser type changed to: " + System.getProperty("browser"));
                    browser = System.getProperty("browser");
                }
                switch (browser){
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        driverPool.set(new ChromeDriver());
                        break;

                    case "headLessChrome":
                        ChromeOptions options = new ChromeOptions();
                        options.addArguments("--headless");
                        options.addArguments("--disable-gpu");
                        options.addArguments("--window-size=1280,800");
                        options.addArguments("--allow-insecure-localhost");

                        WebDriverManager.chromedriver().setup();
                        driverPool.set(new ChromeDriver(options));
                        break;


                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        driverPool.set(new FirefoxDriver());
                        break;

                    case "edge":
                        WebDriverManager.edgedriver().setup();
                        driverPool.set(new EdgeDriver());
                        break;

                }
            }
        }
        return driverPool.get();
    }
    public static void closeDriver(){
        if(driverPool.get() != null){
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}
