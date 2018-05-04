package suporte;



import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import java.io.File;

public class Screenshot {

    public static void tirar(WebDriver navegador,String arquivo){
        TakesScreenshot navegador1 = (TakesScreenshot) navegador;
        File screenshot = navegador1.getScreenshotAs(OutputType.FILE);

        //File screenshot = ((TakesScreenshot)navegador).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(arquivo));
        } catch (Exception e){
            System.out.println("Houveram problemas ao copiar ao arquivo para a pasta" + e.getMessage());
        }
        // parei a aula em 7:01 mim

    }

}
