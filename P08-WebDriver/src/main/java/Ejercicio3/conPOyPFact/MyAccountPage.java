package Ejercicio3.conPOyPFact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MyAccountPage {

    WebDriver driver;

    WebElement shoesB;
    String pTitleMyAccount;

    public MyAccountPage(WebDriver driver){

        //


    }

    public String getTitle(){
        return this.pTitleMyAccount;
    }
}
