package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AutomationInTheWebPages {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        //driver.manage().window().fullscreen();
        Thread.sleep(500);

        //static dropdown with "Select" tag to access that user Select in build class
        /*if the dropdown creates with select tag then it is a static dropdown there of options indexes are not going
        to change 1 option -> 0th Index
        2 option -> 1st Index
        select option using selectByIndex() to select the option
        This methods working if there using "Select" tag
         */
        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown =new Select(staticDropdown);
        dropdown.selectByIndex(3);

        /*by using this method it returns the web element of the selected option and by using getText method it will
         extract the selected values text
        */
        System.out.println(dropdown.getFirstSelectedOption().getText());

        /*select option using selectByVisibleText() to select the option from the visible option on the UI
         */
        Thread.sleep(500);
        dropdown.selectByVisibleText("AED");
        System.out.println(dropdown.getFirstSelectedOption().getText());

        Thread.sleep(500);
        /*select option using selectByValue() to select the option from the value attribute in the console
         */
        dropdown.selectByValue("INR");
        System.out.println(dropdown.getFirstSelectedOption().getText());
        Thread.sleep(500);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(1000);

        //1st way
        /*driver.findElement(By.id("hrefIncAdt")).click();
        driver.findElement(By.id("hrefIncAdt")).click();
        driver.findElement(By.id("hrefIncAdt")).click();
        driver.findElement(By.id("hrefIncAdt")).click();*/

        //2nd way
        /*repeat for 3 times using for while loop
        when we using while loop it will rotate for infinent time but when we use
        this it will stop after loop condition is ture
        */

        //initialize the variable
        int i =0;
        //comparison
        while (i<4){
            driver.findElement(By.id("hrefIncAdt")).click();
            i++;
        }

        driver.findElement(By.id("btnclosepaxoption")).click();

    }
}
