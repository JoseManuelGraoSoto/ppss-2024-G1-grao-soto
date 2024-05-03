package Ejercicio2.conPO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class HomePage {
    WebDriver driver;
    WebElement accountDropList;
    WebElement logInB;
    String pTitle;

    public HomePage(WebDriver driver){
        this.driver = driver;
        this.driver.get("http://demo-store.seleniumacademy.com/");
        pTitle = this.driver.getTitle();
        accountDropList = driver.findElement(By.cssSelector(" #header > div > div.skip-links > div > a"));

    }
    public void goToLogIn(){
        accountDropList.click();
        logInB = driver.findElement(By.cssSelector("#header-account .links ul li.last a"));
        logInB.click();
    }

    public WebDriver getDriver(){
        return driver;
    }
    public String getPageTitle(){
        return pTitle;
    }
}
