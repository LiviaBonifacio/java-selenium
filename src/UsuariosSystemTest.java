import org.junit.Test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UsuariosSystemTest {

    private WebDriver driver;
    private UsuariosPage usuarios;

    @Before
    public void inicializa() {
        this.driver = new FirefoxDriver();
        this.usuarios = new UsuariosPage(driver);

        // visitamos a pagina de usuarios
        usuarios.visita();
    }

    @Test
    public void deveAlterarUmUsuario() {

        usuarios.novo()
                .cadastra("Ronaldo Luiz de Albuquerque", "ronaldo2009@terra.com.br");
    usuarios.altera(1).para("José da Silva", "jose@silva.com");

        assertFalse(usuarios.existeNaListagem(
                "Ronaldo Luiz de Albuquerque", "ronaldo2009@terra.com.br"));
        assertTrue(usuarios.existeNaListagem("José da Silva", "jose@silva.com"));
    }

    @After
    public void encerra() {
        driver.close();
    }

}
	  

