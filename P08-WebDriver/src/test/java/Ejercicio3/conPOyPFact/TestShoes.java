package Ejercicio3.conPOyPFact;

import Ejercicio2.conPO.HomePage;
import Ejercicio2.conPO.MyAccountPage;
import Ejercicio2.conPO.logInPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestShoes {

    WebDriver driver;
    logInPage poLogin;
    HomePage poManagerPage;
    MyAccountPage accountPage;

    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        poManagerPage = new HomePage(driver);
    }

    /*@AfterEach
    void close(){
        driver.close();
    }
    */

    @Test
    void compareShoes(){
        if(poManagerPage.getPageTitle().equals("My Account")){

        }
    }
}
