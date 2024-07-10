package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

       /* //Invoking the browser

        //System.setProperty("webdriver.chrome.drier","/location");

        //step2 use Selenium Manager

        //for maven project those steps are not using
        // step 1 to invoke chrome browser file
       // WebDriver driver = new ChromeDriver();

        // step 1 to invoke firefox browser file
       // WebDriver driver = new FirefoxDriver();

        WebDriver driver = new EdgeDriver();
        //open the url
        driver.get("https://rahulshettyacademy.com/");
        //Check the title of the page and using sout to log the tile
        System.out.println(driver.getTitle());
        //Check the validating the landing page and log the current page url
        System.out.println(driver.getCurrentUrl());
        //close the browser
        //driver.close();
        //driver.quit(); - this will close all the associate browsers



        //Invoking browsers according with webdriver


        WebDriver ed = new EdgeDriver();
        WebDriver sd = new SafariDriver();
*/

        //Locators

        //open the browser
        WebDriver driver=new ChromeDriver();
        //Implicit wait globally affete to all the steps - It wait until 5 sec if it performs quickly then it is not wait until 5 sec
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //landing the url
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        //verification logs
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        //using the locators

        /*using ID locator
        ===================
        driver.findElement(By.id("inputUsername")) -  to find the element by the id "inputUsername"
        sendKeys - use to input values to element that represent the id
        */

        driver.findElement(By.id("inputUsername")).sendKeys("rahul");

          /*using Name locator
        ===================
        driver.findElement(By.name("inputPassword")) -  to find the element by the name "inputPassword"
        sendKeys - use to input values to element that represent the id
        */

        driver.findElement(By.name("inputPassword")).sendKeys("hello two");

        /*using Class Name locator
        ===================
         <button class="submit signInBtn" type="submit">Sign In</button>
        driver.findElement(By.className("signInBtn")) -  to find the element by the class name "signInBtn"
        There is a class name with space "submit signInBtn" -> it means to class name that can represent "submit and signInBtn" space use to  divide two names
        click - use to button element that represent the id
        */

        //driver.findElement(By.className("submit"));
        driver.findElement(By.className("signInBtn")).click();

        /*using CSSSelector locator
        ===================
        Value must unique with other elements.
        tagname#id
        tagname.class
        tagnae[attribute='value']
        using getText() method to retrieve the data that locator identified
        */

        //Exception in thread "main" org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {"method":"css selector","selector":"p.error"}
        //error displays because it is not display the error message when code execute to avoid the need to have a wait mechanism
        //Using Implicit Wait
        //if it is on the above the line it effect to line below
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());

    }
}