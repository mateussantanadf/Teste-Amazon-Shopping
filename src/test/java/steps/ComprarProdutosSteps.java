package steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pages.HomePage;
import pages.ProdutoPage;

public class ComprarProdutosSteps {
	
	private static WebDriver driver;
	private HomePage homePage = new HomePage(driver);
	
	@Before
	public static void inicializar() {
		System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver\\95\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Dado("que estou na paginal inicial")
	public void que_estou_na_paginal_inicial() {
	    homePage.carregarPaginaInicial();
	    assertThat(homePage.obterTituloPagina(), is("Amazon.com.br | Compre livros, Kindle, Echo, Fire Tv e mais."));
	}

	@Quando("nao estou logado")
	public void nao_estou_logado() {
		assertThat(homePage.estaLogado(), is(false));
	}

	@Quando("o carrinho esta vazio")
	public void o_carrinho_esta_vazio() {
	    assertThat(homePage.qtdItensCarrinho(), is(0));
	}

	@Quando("pesquiso um produto")
	public void pesquiso_um_produto() {
	    homePage.pesquisarProduto("o último desejo");
	    homePage.clicarBotaoPesquisa();
	    assertTrue(homePage.resultadoPesquisa().endsWith("resultados para"));
	}
	
	ProdutoPage produtoPage;
	String esperado_nomeProduto;
	
	@Quando("seleciono o produto especifco")
	public void seleciono_o_produto_especifco() {
		int indice = 0;
		esperado_nomeProduto= homePage.obterNomeProduto().toLowerCase();
		produtoPage = homePage.selecionarProduto(indice);
		assertTrue(esperado_nomeProduto.contains("o último desejo".toLowerCase()));
	}

	@Entao("vai para a tela do produto especifico")
	public void vai_para_a_tela_do_produto_especifico() {
	    assertThat(produtoPage.obterNomeProduto().toUpperCase(), is(esperado_nomeProduto.toUpperCase()));
	}
	
	@After
	public static void finalizar() {
		driver.quit();
	}
}
