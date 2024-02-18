import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class E2E {

	public static void main(String[] args) throws InterruptedException {
		// Configuração do WebDriver (no caso, ChromeDriver)
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Matheus\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Abrir o site da SpiceJet
		driver.get("https://www.spicejet.com/");
		
		//Implict wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Selecionar opção "Ida e Volta"
		WebElement idaEVoltaButton = driver.findElement(By.xpath("//div[@data-testid='round-trip-radio-button']"));
		idaEVoltaButton.click();
		// Preencher campo de origem com "Delhi"
		WebElement origemField = driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']"));
		origemField.click();
		WebElement origemInput = driver.findElement(By.xpath("//div[text()='Delhi']"));
		origemInput.click();
		// Preencher campo de destino com "Mumbai"
		WebElement destinoField = driver.findElement(By.xpath("//div[@data-testid='to-testID-destination']"));
		destinoField.click();
		WebElement destinoInput = driver.findElement(By.xpath("//div[text()='Mumbai']"));
		destinoInput.click();

		// Selecionar data de ida
		// WebElement dataIdaField =
		// driver.findElement(By.xpath("//div[@data-testid='undefined-calendar-picker']"));
		// dataIdaField.click(); it clicks automatically
		WebElement dataIda = driver
				.findElement(By.xpath("//div[@data-testid='undefined-month-April-2024']//div[text()='25']"));
		dataIda.click();

		// Selecionar data de volta
		WebElement dataVoltaField = driver
				.findElement(By.xpath("//div[@data-testid='undefined-month-May-2024']//div[text()='20']"));
		dataVoltaField.click();

		// Adicionar 4 passageiros
		WebElement passageirosField = driver.findElement(By.xpath("//div[@data-testid='home-page-travellers']"));
		passageirosField.click();

		WebElement adultosDropdown = driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']"));

		for (int i = 1; i < 4; i++) {
			adultosDropdown.click();
		}

		// Clicar em botão de pesquisa
		WebElement buscarBotao = driver.findElement(By.xpath("//div[@data-testid='home-page-flight-cta']"));
		buscarBotao.click();

		// Verificar se a página de resultados foi carregada corretamente
		WebElement resultadosTitle = driver
				.findElement(By.xpath("//*[normalize-space() = 'Select your Departure to Mumbai']"));
		
		  if (resultadosTitle.isDisplayed()) {
		  System.out.println("Página de resultados carregada com sucesso!"); } else {
		  System.out.println("Erro ao carregar página de resultados."); }
		 

		// Fechar o navegador
		driver.quit();
	}
}
