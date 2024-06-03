package Ejercicio2.conPO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class logInPage {

    WebDriver driver;
    WebElement gmailB;
    WebElement passwordB;
    String pTitleLogIn;
    WebElement sendB;


    public logInPage(WebDriver driver){
        this.driver = driver;
        pTitleLogIn = this.driver.getTitle();
        gmailB =  this.driver.findElement(By.cssSelector("div.input-box input.validate-email"));
        passwordB = this.driver.findElement(By.cssSelector("div.input-box input.validate-password"));
        sendB = this.driver.findElement(By.name("send"));
    }

    public MyAccountPage fillInformation(String gmail, String pass){
        gmailB.sendKeys(gmail);
        passwordB.sendKeys(pass);
        sendB.click();
        return new MyAccountPage(this.driver);
    }

    public void fillInformationWithError(String gmail, String pass){
        gmailB.sendKeys(gmail);
        passwordB.sendKeys(pass);
        sendB.click();
    }

    public String getTitle(){
        return pTitleLogIn;
    }

    public String getErrorLogin(){
        String errorLogin;
        errorLogin = this.driver.findElement(By.cssSelector(".messages .error-msg")).getText();
        return errorLogin;
    }
}
