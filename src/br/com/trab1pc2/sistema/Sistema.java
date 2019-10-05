package br.com.trab1pc2.sistema;
import br.com.trab1pc2.produto.Produto;

// Sistema será um singleton
public class Sistema {
	private Produto produtos[];
	private Venda vendas[];
	private static int numProdutos=0;
	private static int numVendas=0;
	private static Sistema s = new Sistema();
	
	//Contrutor
	
	private Sistema() {
		produtos = new Produto[1];
	}
	
	public static Sistema getInstance() {
		return s;
	}
	
	// Métodos
	public boolean inserirProduto(Produto produto) {
		if (produto != null) {
			if (numProdutos < produtos.length) {
				produtos[numProdutos] = produto;
				numProdutos++;
			} else {
				produtos = extendeVetor(produtos);
				produtos[numProdutos] = produto;
				numProdutos++;
			}
			
			return true;
		} else {
			return false;
		}
	}
	
	public boolean inserirVenda(Venda venda) {
		if (venda != null) {
			if (numVendas < vendas.length) {
				vendas[numVendas] = venda;
				numVendas++;
			} else {
				vendas = extendeVetor(vendas);
			}
			
			return true;
		} else {
			return false;
		}
	}
	
	public Produto[] extendeVetor(Produto[] produtos) { // extende o vetor produtos[] em +10
		if (numProdutos >= produtos.length) {
			Produto[] aux = new Produto[produtos.length+10];
			for (int i = 0; i < produtos.length; i++) {
				aux[i] = produtos[i];
			}
			
			return aux;
		} else {
			return produtos;
		}
	}
	
	public Venda[] extendeVetor(Venda[] vendas) { // extende o vetor vendas[] em +10
		if (numVendas >= vendas.length) {
			Venda[] aux = new Venda[vendas.length+10];
			for (int i = 0; i < vendas.length; i++) {
				aux[i] = vendas[i];
			}
			
			return aux;
		} else {
			return vendas;
		}
	}
	
	public Produto[] listarProdutos() { // Listar todos os produtos (retorna um vetor produtos[] de Produto)
		Produto[] produtos = new Produto[numProdutos];
		
		for (int i = 0; i < produtos.length; i++) {
			produtos[i] = this.produtos[i];
		}
		
		return produtos;
	}
	
	public Venda[] listarVendas() {	// Listar todas as vendas (retorna um vetor vendas[] de Venda)
		Venda[] vendas = new Venda[numVendas];
		
		for (int i = 0; i < vendas.length; i++) {
			vendas[i] = this.vendas[i];
		}
		
		return vendas;
	}
	
	
}
