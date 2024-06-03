package Ejercicio3.conPOyPFact;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


public class TestShoes {

    WebDriver driver;
    MyAccountPage accountPage;
    ShoesPage shoesPage;

    @BeforeAll
    public static void setupCookies(){
        Cookies.storeCookiesToFile("josemanuel4.310@gmail.com", "ppss24");
    }

    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        driver.get("http://demo-store.seleniumacademy.com/customer/account/");
        Cookies.loadCookiesFromFile(driver);
        accountPage = PageFactory.initElements(driver, MyAccountPage.class);
    }

    /*@AfterEach
    void close(){
        driver.close();
    }
    */

    @Test
    void compareShoes(){
        Assertions.assertEquals("My Account", driver.getTitle());
        shoesPage = accountPage.goToShoes();
        Assertions.assertEquals("Shoes - Accessories", driver.getTitle());
        /*shoesPage.clickShoesCompares(5);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        shoesPage.clickShoesCompares(6);
        shoesPage.clickCompare();
        poComparePage = shoesPage.cambiarVentanaCompare();
        Assertions.assertEquals("Products Comparison List ...", driver.getTitle());
         */
    }
}
