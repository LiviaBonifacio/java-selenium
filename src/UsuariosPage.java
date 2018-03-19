import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

class UsuariosPage {

    private WebDriver driver;

    public UsuariosPage(WebDriver driver) {
        this.driver = driver;
    }

    public void visita() {
        driver.get("localhost:8080/usuarios");
    }

    public AlteraUsuarioPage altera(int posicao) {
        driver.findElements(By.linkText("editar")).get(posicao-1).click();
        return new AlteraUsuarioPage(driver);
    }

    public boolean existeNaListagem(String nome, String email) {
        // verifica se ambos existem na listagem
        return driver.getPageSource().contains(nome) && 
                driver.getPageSource().contains(email);
    }

}

