package Ejercicio3.conPOyPFact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    WebDriver driver;
    @FindBy(css = "#nav ol.nav-primary .level0.nav-3 a.level0.has-children") WebElement shoesB;
    @FindBy(css = "#nav > ol > li.level0.nav-3.parent > ul > li.level1.nav-3-3 > a") WebElement accessoriesMenu;

    public MyAccountPage(WebDriver driver){
        this.driver = driver;
        this.driver.get("http://demo-store.seleniumacademy.com/customer/account/");
    }

    public ShoesPage goToShoes(){
        //movemos el ratón sobre el elemento "accessories"
        Actions builder = new Actions(driver);
        builder.moveToElement(accessoriesMenu);
        builder.perform();
        shoesB.click();
        return PageFactory.initElements(driver, ShoesPage.class);
        //return new ShoesPage(this.driver);

    }
}
