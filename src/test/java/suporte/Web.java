package suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Web {

    public static WebDriver createChrome(){ // !!! Arrumar Fazer com que o cromeDriver abra em Tela cheia !!!
        // abrindo o navegador
        System.setProperty("webdriver.chrome.driver", "/home/aerdor/desenvolvimento/chromedriver/chromedriver_linux64/chromedriver");
        WebDriver  navegador =  new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //até aqui abre o navegador
        //Navegando para a página do Taskit
        navegador.get("http://www.juliodelima.com.br/taskit");

        return navegador;


    }
}
