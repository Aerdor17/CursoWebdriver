package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import suporte.Web;

public class informacoesUsuarioPageObjectsTest {

    private WebDriver navegador;

    @Before
    public void SetUp(){

        navegador = Web.createChrome();

    }

    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(){
        // utilizando os metodos criados em loginPage e LofinFormPage
    new LoginPage(navegador)

            .clickSignIn()
            .fazerLogin("julio0001","123456")
            .clickInMe()
            .clickMoreDataAboutYou()
            .clickButtonAddMoreData();
    }

    @After
    public void tearDwon(){

       navegador.quit();

    }

}
