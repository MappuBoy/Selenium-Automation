package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        String text = "Navod";
        driver.findElement(By.id("name")).sendKeys(text);
        driver.findElement(By.id("alertbtn")).click();

        //Java script Alerts handling using "SwitchTo method
        // driver.switchTo().alert(); -> means switch you context browser to alert
        //Then it will check whether the alerts are available in the browser
        //to accept the alert using "accept()" method

        driver.switchTo().alert().accept();


    }
}
