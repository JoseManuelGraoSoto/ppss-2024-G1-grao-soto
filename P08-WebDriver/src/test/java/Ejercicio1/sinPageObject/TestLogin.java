package Ejercicio1.sinPageObject;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class TestLogin {


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
    void S2_scenario_loginOK_should_login_in_the_demo_store_when_previous_account_exist(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://demo-store.seleniumacademy.com/");
        Assertions.assertEquals("Madison Island", driver.getTitle());
        //Señeccionamos Account y hacemos click (Seleccion mediante tag)
        driver.findElement(By.cssSelector(" div.account-cart-wrapper ")).click();
        // hacemos click (CssSelector por .class)
        driver.findElement(By.cssSelector("div.links ul li.last")).click();
        Assertions.assertEquals("Customer Login", driver.getTitle());
        driver.findElement(By.cssSelector("div.input-box input.validate-email")).sendKeys("josemanuel4.310@gmail.com");
        driver.findElement(By.name("send")).click();
        String warn = driver.findElement(By.id("advice-required-entry-pass")).getText();
        if(warn.equals("This is a required field.")){
            driver.findElement(By.cssSelector("div.input-box input.validate-password")).sendKeys("ppss24");
            driver.findElement(By.name("send")).click();
            Assertions.assertEquals("My Account", driver.getTitle());
        }else{
            Assertions.fail("Title is -" + warn + "- This is a required field.-.");
        }
    }

    @Test
    void S3_scenario_loginFailed_should_try_login_in_the_demo_store_but_fails_incorrect_password(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://demo-store.seleniumacademy.com/");
        Assertions.assertEquals("Madison Island", driver.getTitle());
        //Señeccionamos Account y hacemos click (Seleccion mediante tag)
        driver.findElement(By.cssSelector(" div.account-cart-wrapper ")).click();
        // hacemos click (CssSelector por .class)
        driver.findElement(By.cssSelector("div.links ul li.last")).click();
        Assertions.assertEquals("Customer Login", driver.getTitle());
        driver.findElement(By.cssSelector("div.input-box input.validate-email")).sendKeys("josemanuel4.310@gmail.com");
        driver.findElement(By.cssSelector("div.input-box input.validate-password")).sendKeys("ppss25");
        driver.findElement(By.name("send")).click();
        String error = driver.findElement(By.cssSelector(".messages .error-msg")).getText();
        error.equals("Invalid login or password.");
    }
}
