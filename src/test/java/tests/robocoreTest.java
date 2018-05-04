package tests;

import net.bytebuddy.implementation.bytecode.Throw;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class robocoreTest {
    @Test
    public void robocoreTest2() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\Aerdor\\Documents\\desenvolvimento\\cursoSelenium\\drivers\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        navegador.get("https://www.robocore.net/modules.php?name=Your_Account&op=logout");
        Thread.sleep(5000);
        navegador.findElement(By.name("username")).sendKeys("lebbeninca@gmail.com");




       // https://www.robocore.net/modules.php?name=Your_Account&op=logout
    }
}
