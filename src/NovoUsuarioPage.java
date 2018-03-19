import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

	class NovoUsuarioPage {

	    private WebDriver driver;

	    public NovoUsuarioPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void cadastra(String nome, String email) {
	        WebElement nome = driver.findElement(By.name("usuario.nome"));
	        WebElement email = driver.findElement(By.name("usuario.email"));

	        nome.sendKeys(nome);
	        email.sendKeys(email);

	        nome.submit();

	    } 

	    public boolean validacaoDeNomeObrigatorio() {
	        return driver.getPageSource().contains("Nome obrigatorio!");
	    }
	}


