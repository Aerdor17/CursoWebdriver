package tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class facebookTest {

    //@Test
    public void FazerCadastro(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Aerdor\\Documents\\desenvolvimento\\cursoSelenium\\drivers\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        //termina a conexão com o navegador

        //define o link que o navegador ira abrir
        navegador.get("https://www.facebook.com/");
        //conexão com o navegador


        //preenche o campo nome do formulário
        navegador.findElement(By.name("firstname")).sendKeys("João");

        //preenche o campo sobre nome do formulário
        navegador.findElement(By.name("lastname")).sendKeys("Silva");

        //preenche o campo e-mail do formulário
        navegador.findElement(By.name("reg_email__")).sendKeys("lucaseduardo.beninca@gmail.com");

        //da um timeOut de 5 segundos
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //preenche o campo confirmação de e-mail do forumulário
        navegador.findElement(By.name("reg_email_confirmation__")).sendKeys("lucaseduardo.beninca@gmail.com");

        //preenche o campo senha do formulário
        navegador.findElement(By.name("reg_passwd__")).sendKeys("T3stando4utomcao");

        //identifica o combobox da data de nascimento de id "day","month","year"
        WebElement comboboxDia = navegador.findElement(By.id("day"));
        WebElement comboboxMes = navegador.findElement(By.id("month"));
        WebElement comboboxAno = navegador.findElement(By.id("year"));

       //trata  especificamento o elemento comboboxDia
        WebElement diaNascimento = comboboxDia.findElement(By.id("day"));
        new Select(diaNascimento).selectByVisibleText("11");

        //trata  especificamento o elemento comboboxMes
        WebElement  mesNascimento = comboboxMes.findElement(By.id("month"));
        new Select(mesNascimento).selectByVisibleText("Fev");

        //trata  especificamento o elemento comboboxAno
        WebElement anoNascimento = comboboxAno.findElement(By.id("year"));
        new Select(anoNascimento).selectByVisibleText("1995");

        WebElement comboboxSex = navegador.findElement(By.id("u_0_10"));

       // WebElement generoSex = comboboxSex.findElement(By.id("u_0_b"));
        navegador.findElement(By.id("u_0_b")).click();
        navegador.findElement(By.id("u_0_13")).click();


   }

}
