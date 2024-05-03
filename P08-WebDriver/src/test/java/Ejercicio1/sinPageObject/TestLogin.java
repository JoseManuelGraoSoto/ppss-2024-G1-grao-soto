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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://demo-store.seleniumacademy.com/");
        String title = driver.getTitle();
        if(title.equals("Madison Island")){
            // Seleccionamos Account y hacemos click (Seleccion mediante boton Inspeccionar)
            driver.findElement(By.cssSelector(" #header > div > div.skip-links > div > a")).click();
            driver.findElement(By.cssSelector("#header-account .links ul li.last a")).click();
            Assertions.assertEquals("Customer Login", driver.getTitle());
            driver.findElement(By.cssSelector("#login-form .form-list .input-box .validate-email")).sendKeys("josemanuel4.310@gmail.com");
            driver.findElement(By.name("send")).click();
            String warn = driver.findElement(By.id("advice-required-entry-pass")).getText();
            if(warn.equals("This is a required field.")){
                driver.findElement(By.cssSelector("#login-form .form-list .input-box .validate-password")).sendKeys("ppss24");
                driver.findElement(By.name("send")).click();
                Assertions.assertEquals("My Account", driver.getTitle());
            }else{
                Assertions.fail("Title is -" + title + "- This is a required field.-.");
            }
        }
    }

    @Test
    void S3_scenario_loginFailed_should_try_login_in_the_demo_store_but_fails_incorrect_password(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://demo-store.seleniumacademy.com/");
        String title = driver.getTitle();
        if(title.equals("Madison Island")){
            // Seleccionamos Account y hacemos click (Seleccion mediante boton Inspeccionar)
            driver.findElement(By.cssSelector(" #header > div > div.skip-links > div > a")).click();
            driver.findElement(By.cssSelector("#header-account .links ul li.last a")).click();
            Assertions.assertEquals("Customer Login", driver.getTitle());
            driver.findElement(By.cssSelector("#login-form .form-list .input-box .validate-email")).sendKeys("josemanuel4.310@gmail.com");
            driver.findElement(By.cssSelector("#login-form .form-list .input-box .validate-password")).sendKeys("ppss25");
            driver.findElement(By.name("send")).click();
            String error = driver.findElement(By.cssSelector(".messages .error-msg")).getText();
            error.equals("Invalid login or password.");
        }
    }
}
