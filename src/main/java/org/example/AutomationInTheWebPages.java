package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AutomationInTheWebPages {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().fullscreen();

        //static dropdown with "Select" tag to access that user Select in build class
        /*if the dropdown creates with select tag then it is a static dropdown there of options indexes are not going
        to change 1 option -> 0th Index
        2 option -> 1st Index
        select option using selectByIndex() to select the option
         */
        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown =new Select(staticDropdown);
        dropdown.selectByIndex(3);

        /*by using this method it returns the web element of the selected option and by using getText method it will
         extract the selected values text
        */
        System.out.println(dropdown.getFirstSelectedOption().getText());



        driver.close();
    }
}
