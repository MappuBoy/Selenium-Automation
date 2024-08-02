package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        String text = "Navod";
        driver.findElement(By.id("name")).sendKeys(text);
        driver.findElement(By.id("alertbtn")).click();

        //Java script Alerts handling using "SwitchTo method
        // driver.switchTo().alert(); -> means switch you context browser to alert
        //Then it will check whether the alerts are available in the browser
        //to accept the alert using "accept()" method

        Thread.sleep(1000);
        //grab the text from the alert
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        //click the negative like "No" or "Cancel"
        driver.findElement(By.id("confirmbtn")).click();
        driver.switchTo().alert().dismiss();


    }
}
