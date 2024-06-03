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
    }
    public logInPage goToLogIn(){
        accountDropList = driver.findElement(By.cssSelector("div.account-cart-wrapper "));
        accountDropList.click();
        logInB = driver.findElement(By.cssSelector("div.links ul li.last"));
        logInB.click();
        return new logInPage(this.driver);
    }

    public String getPageTitle(){
        return pTitle;
    }
}
