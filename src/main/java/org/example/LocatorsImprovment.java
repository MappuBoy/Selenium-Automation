package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class LocatorsImprovment {
    public static void main(String[] args) throws InterruptedException {

        //open the browser
        WebDriver driver=new ChromeDriver();

        //Implicit wait globally affete to all the steps - It wait until 5 sec if it performs quickly then it is not wait until 5 sec
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //landing the url
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        //verification logs
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.findElement(By.id("inputUsername")).sendKeys("rahul");

        driver.findElement(By.name("inputPassword")).sendKeys("hello two");

        //driver.findElement(By.className("submit"));
        driver.findElement(By.className("signInBtn")).click();

        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());

        driver.findElement(By.linkText("Forgot your password?")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("ebuilder");

        driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("jhone@sa.com");
        driver.findElement(By.xpath("//input[@type='text'][2]")).clear();

        driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("jhone@sca.com");

        driver.findElement(By.xpath("//form/input[3]")).sendKeys("0123456789");

        driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();

        String password = driver.findElement(By.cssSelector("form p")).getText();
        System.out.println(password);

        //redirect to login page
        driver.findElement(By.cssSelector("button.go-to-login-btn")).click();

        driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();

        //stop the execute code section for 2 sec
        Thread.sleep(2000);

        //using variable to id the username
        String userName = "Rahul";

        //hard coding the username and password
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys(userName);

        //getting the value from the getPassword method
        String retrivePassword = getPassword(password);
        //using css locator with regular expression, by using "*" to state the static word part
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(retrivePassword);

        Thread.sleep(1000);

        //select the checkbox
        driver.findElement(By.id("chkboxOne")).click();
        Thread.sleep(500);
        driver.findElement(By.name("chkboxTwo")).click();

        //click the button
        //using xpath locator with regular expression, by using "contains" keyword to state the static word part

        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
        Thread.sleep(3000);

        //To check the if the loaded page
        System.out.println("Landed page title : "+driver.getTitle());
        System.out.println("Landed page URL : "+driver.getCurrentUrl());


        System.out.println(driver.findElement(By.tagName("p")).getText());

        System.out.println("===================================================================================================");

        //Using assertions to validate the actual and expected results using "Assert" and "assertEquals" method
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello "+userName+",");

        //Click the logout button
        driver.findElement(By.xpath("//button[text() ='Log Out']")).click();

        Thread.sleep(4000);

        //close the browser using close() button
        driver.close();
    }

    //creating method with "String" Keyword and pass parameters as previously extracted password
    public static String getPassword(String password) throws InterruptedException {

        //text - Please use temporary password 'rahulshettyacademy' to Login.
        String [] passwordArray = password.split("'");
        /*after splitiing from the "'"
                0th index : Please use temporary password
                1st index : 'rahulshettyacademy' to Login.
         */
        String split_password = passwordArray[1].split("'")[0];
                /*after splitiing from the "'"
                0th index : 'rahulshettyacademy'
                1st index :  to Login.
                By using [0] accessing the first index value of the previosly splitted
         */
        return split_password;

    }
}
