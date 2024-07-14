package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");


        //run in the maximise mode
        driver.manage().window().fullscreen();

        Thread.sleep(2000);

        //navigate to google  page
        driver.navigate().to("https://www.google.co.uk/");

        Thread.sleep(2000);

        //navigate back to rahul shetty web
        driver.navigate().back();

        Thread.sleep(2000);

        //navigate again to google
        driver.navigate().forward();
    }
}
