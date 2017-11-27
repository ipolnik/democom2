package com.demo.pages;

import com.demo.base.PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 * Created by ipolnik on 11/27/2017.
 */
public class LoginPage extends PageObjects <LoginPage> {
    private static final String URL = "https://www.dice.com/dashboard/login";

    private By emailField = By.xpath("//*[@id=\"email\"]");
    private By passwordField = By.xpath("//*[@id=\"password\"]");
    private By signInButton = By.xpath("//button[type='submit']");


     public LoginPage(WebDriver driver) {

        super(driver);
    }
    public void openLogonPage(){
         getPage(URL);
    }
    public void fillUpEmailAndPassword(String email, String password){
     type(email, emailField);
     type(password, passwordField);
    }
    public ProfilePage pushSignInButton(){
        click(signInButton);
        return new ProfilePage(driver);
    }

}
