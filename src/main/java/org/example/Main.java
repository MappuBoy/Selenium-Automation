package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;

import java.time.Duration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {

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



           /*using link locator
        ===================
         to use link text locator it should need link ("a href")*/
        driver.findElement(By.linkText("Forgot your password?")).click();

        Thread.sleep(2000);
          /*using xpath locator
        ===================
         //tagname[@attribute = 'value']
         to validate xpath on th console = $x('//input[@placeholder='Name']')
         */
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("ebuilder");
        /*using xpath locator
        ===================
         //tagname[@attribute = 'value']
         to validate xpath on th console = $x('//input[@placeholder='Name']')
          and also clear the text box using clear method to clear the textbox
          Problem if there is an attributes with multiple elements - using indexing method to uniqualy point the value //input[@type='text'][2]
         */

        driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("jhone@sa.com");
        driver.findElement(By.xpath("//input[@type='text'][2]")).clear();

        //using css with indexing method
        //indexing methd is not recomending
        driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("jhone@sca.com");

        //xpath with parent to child using html tag (traverse) with indexing method
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("0123456789");

        /*clicking the reset button
       // driver.findElement(By.xpath("//form/div/button[2]")).click();
       Error happens because it is not in the stable state it is in the transition state with moving this pade to next page
       using code 114 -> Thread.sleep method to stop the execution of code
       after clicking the forget password link it will stop to give some time
       Error msg displaying -ElementClickInterceptedException: element click intercepted: Element <button
       class="reset-pwd-btn">...</button> is not clickable at point (577, 437). Other element would receive the
       click: <button class="go-to-login-btn">...</button>

       */
       driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();

        //grab the infield validation by parent child traverse through csslocator
        //assigning extracted value to variable
        String password = driver.findElement(By.cssSelector("form p")).getText();
        System.out.println(password);

        //redirect to login page
        driver.findElement(By.cssSelector("button.go-to-login-btn")).click();

        //to get xpath every element with parent to child traverse
        //Customize xpath - //div[@class='forgot-pwd-btn-conainer']/button[1]
        //Parent - //div[@class='forgot-pwd-btn-conainer']
        //Child - /button[1]
        //travers - first button [1]
        //div[@class='forgot-pwd-btn-conainer']/button[1]
        driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();

        //stop the execute code section for 2 sec
        Thread.sleep(2000);

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


    }
}