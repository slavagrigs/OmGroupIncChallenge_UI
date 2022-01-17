package com.omGroupInc.utils;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowserUtils {
    private static WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(120,1));

    public static void wait(int seconds){
        try{
            Thread.sleep(seconds*1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
