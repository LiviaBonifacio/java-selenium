import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteAutomatizado {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","/Users/liviabonifacio/Downloads");
		WebDriver driver = new ChromeDriver();
		
		WebElement campoDeTexto = driver.findElement(By.name("q"));
		campoDeTexto.sendKeys("Caelum");
		
		campoDeTexto.submit();
	}

}
