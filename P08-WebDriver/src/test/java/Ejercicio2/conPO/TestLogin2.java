package Ejercicio2.conPO;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLogin2 {

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
    void S4_scenario_PO_loginOK_should_login_with_success_when_user_account_exists(){
        if(poManagerPage.getPageTitle().equals("Madison Island")){
            poManagerPage.goToLogIn();
            poLogin = new logInPage(poManagerPage.getDriver());
            Assertions.assertEquals("Customer Login", poLogin.getTitle());
            poLogin.fillInformation("josemanuel4.310@gmail.com", "ppss24");
            poLogin.clickSend();
            accountPage = new MyAccountPage(poLogin.getDriver());
            Assertions.assertEquals("My Account", accountPage.getTitle());
        }
    }

    @Test
    void S5_scenario_PO_loginFailed_should_fail_when_user_account_not_exists(){
        if(poManagerPage.getPageTitle().equals("Madison Island")){
            poManagerPage.goToLogIn();
            poLogin = new logInPage(poManagerPage.getDriver());
            Assertions.assertEquals("Customer Login", poLogin.getTitle());
            poLogin.fillInformation("josemanuel4.310@gmail.com", "ppss25");
            poLogin.clickSend();
            poLogin.getErrorLogin().equals("Invalid login or password.");
        }
    }
}
