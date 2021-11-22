package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
		
	private By usuarioLogado = By.id("nav-link-accountList-nav-line-1");
	
	private By numeroItensCarrinho = By.id("nav-cart-count");
	
	private By campoPesquisa = By.id("twotabsearchtextbox");
	
	private By botaoPesquisa = By.id("nav-search-submit-button");
	
	private By textoResultadoDaPesquisa = By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']//span[contains(text(), 'resultados para')]");

	private By produtoSelecionar = By.cssSelector("a.a-link-normal span.a-size-base-plus");
	
	private By textoNomeProduto = By.xpath("//div[@class='a-section a-spacing-medium']//h2//span[contains(text(), 'O último desejo')]");
	
	public void carregarPaginaInicial() {
		driver.get("https://www.amazon.com.br");
	}

	public String obterTituloPagina() {
		return driver.getTitle();
	}

	public Boolean estaLogado() {
		return !"Olá, Faça seu login".contentEquals(driver.findElement(usuarioLogado).getText());
	}

	public Integer qtdItensCarrinho() {
		return Integer.parseInt(driver.findElement(numeroItensCarrinho).getText());
	}

	public void pesquisarProduto(String texto) {
		driver.findElement(campoPesquisa).sendKeys(texto);
	}
	
	public void clicarBotaoPesquisa() {
		driver.findElement(botaoPesquisa).click();
	}

	public String resultadoPesquisa() {
		return driver.findElement(textoResultadoDaPesquisa).getText();
	}

	public ProdutoPage selecionarProduto(int indice) {
		driver.findElements(produtoSelecionar).get(indice).click();
		return new ProdutoPage(driver);
	}

	public String obterNomeProduto() {
		return driver.findElement(textoNomeProduto).getText();
	}

}









