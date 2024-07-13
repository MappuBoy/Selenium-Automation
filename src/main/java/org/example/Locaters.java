package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Locaters {
    public static void main(String[] args) {

        //open the browser
        WebDriver driver=new ChromeDriver();

        //Implicit wait globally affete to all the steps - It wait until 5 sec if it performs quickly then it is not wait until 5 sec
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //landing the url
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        //hard coding the username and password
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Rahul");

        //using css locator with regular expression, by using "*" to state the static word part
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");

        //select the checkbox
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.name("chkboxTwo")).click();

        //click the button
        //using xpath locator with regular expression, by using "contains" keyword to state the static word part
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();

        //To check the if the loaded page
        System.out.println("Landed page title : "+driver.getTitle());
        System.out.println("Landed page URL : "+driver.getCurrentUrl());

        // if there
    }
}
