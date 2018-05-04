package tests;
import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginFacebook {

    @Test
    public void fazerLoginNoFacebook(){

        System.setProperty("webdriver.chrome.driver","C:\\Users\\Aerdor\\Documents\\desenvolvimento\\cursoSelenium\\drivers\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.get("http://www.facebook.com");

        navegador.findElement(By.id("email")).sendKeys("lucaseduardo.beninca@gmail.com");
        navegador.findElement(By.id("pass")).sendKeys("T3stando4utomcao");
        navegador.findElement(By.id("u_0_2")).click();
        //fazer uma validação assertEquals





    }

}
