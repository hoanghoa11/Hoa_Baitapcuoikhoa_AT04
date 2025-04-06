package com.hoa.drivers;

import org.openqa.selenium.WebDriver;

import java.util.HashSet;
import java.util.Set;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static Set<String> allWindowHandles = new HashSet<>();
    private static String originalWindowHandle = "";
    private DriverManager() {
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver.set(driver);
    }
    public static void updateWindowHandles() {
        allWindowHandles = driver.get().getWindowHandles(); //// Lấy tất cả các handle (mã định danh) của các tab đang mở
        System.out.println(allWindowHandles);
    }

    public static void updateOriginalWindowHandle() {
        originalWindowHandle = driver.get().getWindowHandle(); //// Lấy handle (mã định danh) của tab gốc

    }


    public static void switchToOtherTab() {
        String currentWindow = driver.get().getWindowHandle();
        Set<String> handles = driver.get().getWindowHandles();

        for (String windowHandle : handles) {
            if (!windowHandle.equals(currentWindow)) {
                driver.get().switchTo().window(windowHandle);
                System.out.println("Switched from " + currentWindow + " to " + windowHandle);
                break;
            }
        }
    }

    public static void quit() {
        DriverManager.driver.get().quit();
        driver.remove();
    }
}