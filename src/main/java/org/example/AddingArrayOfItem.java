package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AddingArrayOfItem {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        //adding items to the cart by generic buttons
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        //to get the items from loop
        for (int i = 0; i < products.size(); i++) {

           String name = products.get(i).getText();

           //check the "name" string if the value is "cucumber" using "Contains" mail to check value
           if(name.contains("Cucumber")){

               // findElements fetch all the buttons and filter "i" index and according to the "i" index if the contains
               // method matches then click it.

               driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
               break;

           }
        }
        



    }
}
