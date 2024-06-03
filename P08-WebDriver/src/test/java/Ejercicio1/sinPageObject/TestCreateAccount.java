package Ejercicio1.sinPageObject;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCreateAccount {

    WebDriver driver;

    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
    }


    @Test
    void S1_scenario_createAccount_should_create_new_account_in_the_demo_store_when_this_account_does_not_exist(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://demo-store.seleniumacademy.com/");
        Assertions.assertEquals("Madison Island", driver.getTitle());
        //Señeccionamos Account y hacemos click (Seleccion mediante tag)
        driver.findElement(By.cssSelector(" div.account-cart-wrapper ")).click();
        //Seleccionamos Log in y hacemos click (CssSelector por titulo)
        //driver.findElement(By.cssSelector("a[title='Log In']")).click();
        // hacemos click (CssSelector por .class)
        driver.findElement(By.cssSelector("div.links ul li.last")).click();
        Assertions.assertEquals("Customer Login", driver.getTitle());
        // hacemos click (CssSelector solo por multiples .class)
        driver.findElement(By.cssSelector("#login-form .buttons-set .button")).click();
        Assertions.assertEquals("Create New Customer Account", driver.getTitle());

        driver.findElement(By.name("firstname")).sendKeys("jose");
        driver.findElement(By.id("middlename")).sendKeys("ppss");
        driver.findElement(By.id("lastname")).sendKeys("grao");
        driver.findElement(By.id("email_address")).sendKeys("jo@gmail.com");
        driver.findElement(By.name("password")).sendKeys("ppss24");
        driver.findElement(By.id("confirmation")).sendKeys("ppss24");

        //Hacemos click y cambiamos de pagina
        driver.findElement(By.xpath("//div[2]/button")).click();

        //Volvemos ya que sale un error
        driver.navigate().refresh();
        Assertions.assertEquals("My Account", driver.getTitle());
    }
}
