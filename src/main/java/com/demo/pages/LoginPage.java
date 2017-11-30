package com.demo.pages;

import com.demo.base.PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


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
        System.out.println("Filling up email and password");
     typeIn(email, emailField);
     typeIn(password, passwordField);
    }
    public ProfilePage pushSignInButton(){
        System.out.println("Clicking on Sign In Button");
        click(signInButton);
        return new ProfilePage(driver);
    }

}
