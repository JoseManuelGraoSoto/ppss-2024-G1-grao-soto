package Ejercicio3.conPOyPFact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class logInPage {

    WebDriver driver;
    WebElement gmailB;
    WebElement passwordB;
    String pTitleLogIn;
    WebElement sendB;
    String errorLogin;

    public logInPage(WebDriver driver){
        this.driver = driver;
        pTitleLogIn = this.driver.getTitle();
        gmailB =  driver.findElement(By.cssSelector("#login-form .form-list .input-box .validate-email"));
        passwordB = driver.findElement(By.cssSelector("#login-form .form-list .input-box .validate-password"));
        sendB = driver.findElement(By.name("send"));
    }

    public void fillInformation(String gmail, String pass){
        gmailB.sendKeys(gmail);
        passwordB.sendKeys(pass);
    }

    public void clickSend(){
        sendB.click();
    }

    public WebDriver getDriver(){
        return driver;
    }

    public String getTitle(){
        return pTitleLogIn;
    }

    public String getErrorLogin(){
        errorLogin = this.driver.findElement(By.cssSelector(".messages .error-msg")).getText();
        return errorLogin;
    }
}
