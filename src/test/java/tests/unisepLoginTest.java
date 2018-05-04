package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class unisepLoginTest {
    @Test
    public void unisepTest()  {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Aerdor\\Documents\\desenvolvimento\\cursoSelenium\\drivers\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        navegador.get("http://www.unisep.edu.br/home.php");

        navegador.findElement(By.linkText("FAED - Faculdade Educacional de Dois Vizinhos")).click();

        navegador.findElement(By.linkText("MOODLE")).click();
             // WebElement formularioLogin = navegador.findElement(By.id(""));



       navegador.findElement(By.id("")).findElements(By.id("username"));


        navegador.quit();



    }

}
