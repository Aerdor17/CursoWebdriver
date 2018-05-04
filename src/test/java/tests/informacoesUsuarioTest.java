package tests;

import static org.junit.Assert.*;

import com.sun.org.apache.bcel.internal.ExceptionConstants;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import suporte.Generator;
import suporte.Screenshot;
import suporte.Web;

import java.util.concurrent.TimeUnit;
// aponta a classe de testes do easy tests
@RunWith(DataDrivenTestRunner.class) // aponta a classe de testes do easy tests

@DataLoader(filePaths = "informacoesUsuarioTestData.csv") // aponta o local onde os dados de login sçai armazenados

public class informacoesUsuarioTest {


    private WebDriver navegador; // exponho essa variavel a todos os metodos.

    @Rule
    public TestName test = new TestName();
    @Before
    public void SetUP(){
        // recebe da classe Web o creatChrome
        navegador = Web.createChrome();
        //Clicar no link que possui o texto sing in
        //o texto esta dentro do navegador, findElement() busca um elemento dentro do escopo no caso a pagina web By.linkText("aqui vai o texto") busca um link de texto
        //. logo depois diz respeito a interação no caso .click(); dar um click no elemento

        navegador.findElement(By.linkText("Sign in")).click();

        //identificando o formulário de "login"
        WebElement formularioSignInbox = navegador.findElement(By.id("signinbox"));

        //Digital no campo com name "login" que esta dentro do formulário de id "signinbox" o texto "julio0001"
        formularioSignInbox.findElement(By.name("login")).sendKeys("julio0001");

        //Digital no campo com name "login" que está dentro do formulário id "signinbox" o texto "123456"
        formularioSignInbox.findElement(By.name("password")).sendKeys("123456");

        navegador.findElement(By.linkText("SIGN IN")).click();


        //Clicar e um link que tenha a class "me".
        navegador.findElement(By.className("me")).click();

        //Clicar em um link que tenha "MORE DATE ABOUT".
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();

    }


    // preciso passar na classe os dados que vem lá do arquivo.csv no caso tipo,contato e a mensagem
    // e esses @Param são representados por uma variavel do tipo String  preciso passar na classe os dados que vem lá do arquivo.csv no caso tipo,contato e a mensagem
    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(@Param(name = "tipo")String tipo,@Param(name="contato")String contato,@Param(name="mensagem")String mensagemEsperada) {

        //clicar no botão através do seu xpath //button[@data-target="addmoredata"]
         navegador.findElement(By.xpath("//div[@id=\"moredata\"]//button[@data-target=\"addmoredata\"]")).click();

        //identificar a popup onde está o formulário de id addmoredata
        WebElement popupAddMoreData = navegador.findElement(By.id("addmoredata"));

        // Na combobox de name "type" escolher a opção "Phone".
      // WebElement campoType = popupAddMoreData.findElements(By.name("type"));
        WebElement campoType = popupAddMoreData.findElement(By.name("type"));
       new Select(campoType).selectByVisibleText(tipo);

        // No campo de name "contact" digitar "+5519999999".
        popupAddMoreData.findElement(By.name("contact")).sendKeys(contato);

        // Clicar no link de text "SAVE" que esta na popup
        popupAddMoreData.findElement(By.linkText("SAVE")).click();

        // Na mensagem de id "toast-container" validar que o texto é ""
        WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
        String mensagem = mensagemPop.getText();
        assertEquals(mensagemEsperada,mensagem);


    }

    @Test
    public void removerUmContatoDeUmUsuario(){
        // apagar +551133334444

        // Cliacar no elemento pelo sue xpach "//span [text()="+551133334444"]/following-sibling::a"
        navegador.findElement(By.xpath("//span [text()=\"+551133334444\"]/following-sibling::a")).click(); // following-sibling o proximo elemento

        // Confirmar a janela JavaScript
        navegador.switchTo().alert().accept();



        // Validar que a mensangem apresentada foi Rest in Peace, dear phone!
        WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
        String mensagem = mensagemPop.getText();
        assertEquals("Rest in peace, dear phone!",mensagem);

        // tirar um screenshot depois que a mensagem aparece
        String screenshotArquivo = "C:\\Users\\Aerdor\\Pictures\\screenshotsSelenium" + Generator.dataHoraParaArquivo() + test.getMethodName()+ ".png";
        Screenshot.tirar(navegador, screenshotArquivo );

        // Aguardar 10 segundos para que a janela desaparece
        WebDriverWait aguardar = new WebDriverWait(navegador, 10);
        aguardar.until(ExpectedConditions.stalenessOf(mensagemPop));

        // Clicar no link com o texto logout
        navegador.findElement(By.linkText("Logout")).click();

    }



    @After
    public void tearDown(){
        //Fecha o Navegador
       //navegador.quit();

    }
}

