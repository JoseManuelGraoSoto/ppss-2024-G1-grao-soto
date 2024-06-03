package Ejercicio3.conPOyPFact;

import org.openqa.selenium.*;

public class ShoesPage {

    WebDriver driver;
    public ShoesPage(WebDriver driver){
        this.driver = driver;
    }
    /*
    public void clickShoesCompares(int n){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        switch(n){
            case 5:
                jse.executeScript("arguments[0].scrollIntoView();", shoeCompare1);
                shoeCompare1.click();
                break;
            case 6:
                jse.executeScript("arguments[0].scrollIntoView();", shoeCompare2);
                shoeCompare2.click();
                break;
        }
    }
    public void clickCompare(){
        JavascriptExecutor jse  = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", compareButton);
        compareButton.click();
    }

    public ComparePage cambiarVentanaCompare(){
        Set<String> setIds = driver.getWindowHandles();
        String[] handleIds = setIds.toArray(new String[setIds.size()]);
        driver.switchTo().window(handleIds[1]);
        return PageFactory.initElements(driver, ComparePage.class);
    }
     */
}
