import static org.junit.Assert.assertTrue;

import org.apache.bcel.generic.Select;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NovoLeilaoPage {

    private WebDriver driver;

    public NovoLeilaoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void preenche(String nome, double valor, String usuario, boolean usado) {

        WebElement txtNome = driver.findElement(By.name("leilao.nome"));
        WebElement txtValor = driver.findElement(By.name("leilao.valorInicial"));

        txtNome.sendKeys(nome);
        txtValor.sendKeys(String.valueOf(valor));

        WebElement combo = driver.findElement(By.name("leilao.usuario.id"));
        Select cbUsuario = new Select(combo);
        cbUsuario.selectByVisibleText(usuario);

        if(usado) {
            WebElement ckUsado = driver.findElement(By.name("leilao.usado"));
            ckUsado.click();
        }

        txtNome.submit();
    }

    public boolean validacaoDeProdutoApareceu() {
        return driver.getPageSource().contains("Nome obrigatorio!");
    }

    public boolean validacaoDeValorApareceu() {
        return driver.getPageSource()
                .contains("Valor inicial deve ser maior que zero!");
    }

}