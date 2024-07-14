package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Locaters {
    public static void main(String[] args) throws InterruptedException {

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

        // if there is a tag that only used in one time on the page then can user "Tag name" locator
        //in the "https://rahulshettyacademy.com/locatorspractice/" page only one <p> tag therefore using that tag to locate\

        Thread.sleep(2000);

        System.out.println(driver.findElement(By.tagName("p")).getText());

        System.out.println("===================================================================================================");

        //Using assertions to validate the actual and expected results using "Assert" and "assertEquals" method
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");
/*
        //Exception in thread "main" java.lang.AssertionError: expected [You are successfully logged in.] but found []
        //This exception display because of not using the timeout to load the page successfully. because it is a single
        // page app it takes some time to load the page if mot it cjeck the results from the parent page
        //there needs to use Thread.sleep() method in the 42 line
*/

        //using findElement method inside in the assertion

        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")),"Hello Rahul,");


    }
}
