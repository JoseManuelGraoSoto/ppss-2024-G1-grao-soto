package Ejercicio2.conPO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class MyAccountPage {

    WebDriver driver;
    String pTitleMyAccount;

    public MyAccountPage(WebDriver driver){
        this.driver = driver;
        pTitleMyAccount = this.driver.getTitle();
    }

    public String getTitle(){
        return this.pTitleMyAccount;
    }
}
