package Ejercicio2.conPO;

import Ejercicio3.conPOyPFact.ShoesPage;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {

    WebDriver driver;
    String pTitleMyAccount;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        pTitleMyAccount = this.driver.getTitle();
    }

    public String getTitle() {
        return this.pTitleMyAccount;
    }

}
