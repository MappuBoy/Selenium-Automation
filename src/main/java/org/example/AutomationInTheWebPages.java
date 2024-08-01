package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class AutomationInTheWebPages {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        //driver.manage().window().fullscreen();

        /*Thread.sleep(500);

        //static dropdown with "Select" tag to access that user Select in build class
        *//*if the dropdown creates with select tag then it is a static dropdown there of options indexes are not going
        to change 1 option -> 0th Index
        2 option -> 1st Index
        select option using selectByIndex() to select the option
        This methods working if there using "Select" tag
         *//*
        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown =new Select(staticDropdown);
        dropdown.selectByIndex(3);

        *//*by using this method it returns the web element of the selected option and by using getText method it will
         extract the selected values text
        *//*
        System.out.println(dropdown.getFirstSelectedOption().getText());

        *//*select option using selectByVisibleText() to select the option from the visible option on the UI
         *//*
        Thread.sleep(500);
        dropdown.selectByVisibleText("AED");
        System.out.println(dropdown.getFirstSelectedOption().getText());

        Thread.sleep(500);
        *//*select option using selectByValue() to select the option from the value attribute in the console
         *//*
        dropdown.selectByValue("INR");
        System.out.println(dropdown.getFirstSelectedOption().getText());
        Thread.sleep(500);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("Before selecting the values : "+driver.findElement(By.id("divpaxinfo")).getText());
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(1000);

        //1st way
        *//*driver.findElement(By.id("hrefIncAdt")).click();
        driver.findElement(By.id("hrefIncAdt")).click();
        driver.findElement(By.id("hrefIncAdt")).click();
        driver.findElement(By.id("hrefIncAdt")).click();*//*

        //2nd way
        *//*repeat for 3 times using for while loop
        when we using while loop it will rotate for infinent time but when we use
        this it will stop after loop condition is ture
        *//*

        //initialize the variable
        int i =0;
        //comparison
        while (i<4){
            driver.findElement(By.id("hrefIncAdt")).click();
            i++;
        }*//*

        //using for loop for the execution
        for (int i = 0; i < 4; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }

        driver.findElement(By.id("btnclosepaxoption")).click();
        //when we know exact endpoint of the iteration then using for loop if not we using while loop

        System.out.println("After selecting the values : "+driver.findElement(By.id("divpaxinfo")).getText());
        Thread.sleep(1000); */

        //Dynamic dropdowns - These dropdowns displays according to the user selected option

        //Xpath ->//a[@value='BLR'],//a[@value='MAA'][2] using "[2]" because need to select it from second option

/*        driver.findElement(By.xpath("//select[@id='ctl00_mainContent_ddl_originStation1']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//option[@value='IXG'])")).click();
        Thread.sleep(1000);
        //identifing the instances and getting them
        driver.findElement(By.xpath("//option[@value='MAA'][2]")).click();*/


// dynamic dromdown without using indexes

//  //a[@value='MAA']  - Xpath for chennai

//  //a[@value='BLR']
/*

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

        driver.findElement(By.xpath("//a[@value='BLR']")).click();

        Thread.sleep(2000);

//driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();

        //travese xpath
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();

        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //Auto suggest dropdown

        //sort the india option
        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        Thread.sleep(1000);

        //because of the grab item palce can be changes therefore grab the full element list and sort
        //using List <WebElement> to store the values
        //driver.findElements(By.xpath("//li[@class = 'ui-menu-item']/a")) by using locate all the items under the "ind"
        //Because it getting muliple values there using "findElements" keyword
        /*for (WebElement option : options):

         This is a for-each loop in Java.
         options is a collection of WebElement objects (likely obtained from a previous Selenium command such as findElements).
         The loop iterates over each element (option) in the options collection one by one.

        //"//li[@class = 'ui-menu-item']/a" -> Genaric location

        List <WebElement> options = driver.findElements(By.xpath("//li[@class = 'ui-menu-item']/a"));


        for (WebElement option:options){
            if(option.getText().equalsIgnoreCase("India")){
                option.click();
                break;
            }
        }
*/
        System.out.println(driver.findElement(By.name("ctl00$mainContent$chk_friendsandfamily")).isSelected());

        System.out.println("====================================================================================");

        //assertFalse expects false values there it check if output is equals to false and also the expectation is false the it will pass
        Assert.assertFalse(driver.findElement(By.name("ctl00$mainContent$chk_friendsandfamily")).isSelected());
        driver.findElement(By.name("ctl00$mainContent$chk_friendsandfamily")).click();


         //check it select or not using "isSelected();" method
        //assertTrue expects true values there it check if output is equals to true and also the expectation is true the it will pass

         driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

        System.out.println("====================================================================================");

         //print the count the number of check boxes
        //step 1 -> find a common locator
        //step 2 -> user "findElements" because it is plural and using "size" method get the count

        System.out.println("Number of check boxes : "+driver.findElements(By.cssSelector("input[type = 'checkbox']"
        )).size());

        //Assertion


    }
}

