package web.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import web.driver.BaseDriver;

public class Utilidades extends BaseDriver {

    public void esVisibleElemento(WebElement elemento){
        WebDriverWait wait = new WebDriverWait (driver,20);
        wait.until(ExpectedConditions.visibilityOf(elemento));
    }

    public void puedoHacerClickSobreElemento(By elemento){
        WebDriverWait wait = new WebDriverWait (driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(elemento));
    }

    public By actualizarIdentificadorElemento(By elemento, String nombreElemento){
        String updateIdentificador =  elemento.toString();
        updateIdentificador = updateIdentificador.substring(updateIdentificador.indexOf("//"));
        updateIdentificador = String.format(updateIdentificador, nombreElemento);
        return By.xpath(updateIdentificador);
    }

    public void posicionarPunteroMouse(By elemento){
        Actions actions = new Actions(driver);
        WebElement opcion = driver.findElement(elemento);
        actions.moveToElement(opcion).perform();
    }
}