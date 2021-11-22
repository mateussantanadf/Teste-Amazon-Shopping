# language: pt
Funcionalidade: Verificar que esta na home page
  se o carrinho esta vazio 
  e pesquisar produto e seleciona-lo

  @fluxoinicial
  Cenario: Na pagina inicial pesquisar produto e seleciona-lo
    Dado que estou na paginal inicial
    Quando nao estou logado
    E o carrinho esta vazio
    E pesquiso um produto
    E seleciono o produto especifco
    Entao vai para a tela do produto especifico
