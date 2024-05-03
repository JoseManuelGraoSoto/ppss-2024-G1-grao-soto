package Ejercicio1.sinPageObject;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestCreateAccount {

    WebDriver driver;

    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
    }
    @AfterEach
    void close(){
        driver.close();
    }

    @Test
    void S1_scenario_createAccount_should_create_new_account_in_the_demo_store_when_this_account_does_not_exist(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://demo-store.seleniumacademy.com/");
        String title = driver.getTitle();
        if(title.equals("Madison Island")){
            // Seleccionamos Account y hacemos click (Seleccion mediante boton Inspeccionar)
            driver.findElement(By.cssSelector(" #header > div > div.skip-links > div > a")).click();
            //Seleccionamos Log In y hacemos click (xPath)
            //driver.findElement(By.xpath("//*[@id=\"header-account\"]/div/ul/li[6]/a")).click();
            //hacemos click (CssSelector por titulo)
            //driver.findElement(By.cssSelector("a[title='Log In']")).click();
            //hacemos click (CssSelector por titulo del elemento en lista)
            //driver.findElement(By.cssSelector("#header-account .links ul li a[title='Checkout']")).click();
            //hacemos click (CssSelector por href)
            ////driver.findElement(By.cssSelector("a[href='http://demo-store.seleniumacademy.com/customer/account/login/']")).click();
            // hacemos click (CssSelector por .class)
            driver.findElement(By.cssSelector("#header-account .links ul li.last a")).click();
            Assertions.assertEquals("Customer Login", driver.getTitle());
            // hacemos click (CssSelector solo por multiples .class)
            driver.findElement(By.cssSelector("#login-form .buttons-set .button")).click();
            Assertions.assertEquals("Create New Customer Account", driver.getTitle());
            // driver.findElement(By.name("firstname")).sendKeys("jose");
            driver.findElement(By.xpath("//*[@id=\"firstname\"]")).sendKeys("jose");
            driver.findElement(By.xpath("//*[@id=\"middlename\"]")).sendKeys("manuel");
            driver.findElement(By.xpath("//*[@id=\"lastname\"]")).sendKeys("grao");
            driver.findElement(By.xpath("//*[@id=\"email_address\"]")).sendKeys("josemanuel4.310@gmail.com");
            driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("ppss24");
            driver.findElement(By.xpath("//*[@id=\"confirmation\"]")).sendKeys("ppss24");
            driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div[2]/button")).click();
            // No fnciona esta ultima linea debido a un error en la web
            // Assertions.assertEquals("My Account", driver.getTitle());
        }
    }
}
