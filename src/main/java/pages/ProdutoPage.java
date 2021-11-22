package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProdutoPage {
	
	private WebDriver driver;
	
	private By textoNomeProduto = By.id("productTitle");
	
	public ProdutoPage(WebDriver driver) {
		this.driver = driver;
	}

	public String obterNomeProduto() {
		return driver.findElement(textoNomeProduto).getText();		
	}
}
