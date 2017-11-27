package com.demo.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;



/**
 * Created by ipolnik on 11/27/2017.
 */
public class PageObjects<T> {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public PageObjects(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    @SuppressWarnings("unchked")
    protected T getPage(String url) {
        driver.get(url);
        return (T) this;
    }
    protected void type(String text, By element){
        find(element).sendKeys(text);

    }
    protected void click (By element){
        find(element).click();
    }

    private WebElement find(By element) {
        return driver.findElement(element);
    }




}
