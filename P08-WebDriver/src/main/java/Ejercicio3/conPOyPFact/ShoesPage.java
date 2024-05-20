package Ejercicio3.conPOyPFact;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ShoesPage {

    WebDriver driver;

    String pTitleShoesPage;

    public ShoesPage(WebDriver driver){
        this.driver = driver;
        pTitleShoesPage = this.driver.getTitle();


    }

    /*
    public void selectShoeToCompare(int number) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        switch(number) {
            case 5: jse.executeScript("arguments[0].scrollIntoView();", wingtipShoe);
                wingtipShoe.click();
                break;
            case 6: jse.executeScript("arguments[0].scrollIntoView();", suedeShoe);
                suedeShoe.click();
                break;
        }
    }

    public String getTitle(){
        return this.pTitleShoesPage;
    }
     */
}
