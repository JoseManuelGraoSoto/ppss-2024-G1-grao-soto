package Ejercicio3.conPOyPFact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {
    WebDriver driver;
    WebElement accesoriesB;
    WebElement shoesB;
    String pTitle;

    public HomePage(WebDriver driver){
        this.driver = driver;
        this.driver.get("http://demo-store.seleniumacademy.com/");
        pTitle = this.driver.getTitle();
        //accesoriesB = driver.findElement(By.cssSelector("#header-nav .nav-primary .level0.nav-3 a"));
        accesoriesB = driver.findElement(By.cssSelector("#nav .nav-primary li:nth-child(3) a"));
        //movemos el ratón sobre el elemento "accessories"
        Actions builder = new Actions(driver);
        builder.moveToElement(accesoriesB);
        builder.perform();
        //ahora serán visibles los hiperenlaces, y podremos clickar sobre "shoes"
        shoesB = driver.findElement(By.cssSelector("#nav .nav-primary li:nth-child(3) .level1.nav-3-3 > a"));
        shoesB.click();
    }
    public void goToShoes(){
    }

    public WebDriver getDriver(){
        return driver;
    }
    public String getPageTitle(){
        return pTitle;
    }
}
