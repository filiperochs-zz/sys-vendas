package br.com.trab1pc2.produto;

public class Item {
	private Produto produto;
	private double preco;
	private int qtd;
	
	
	// Construtores
	
	private Item(Produto produto, double preco, int qtd) {
		this.produto = produto;
		this.preco = preco;
		this.qtd = qtd;
	}
	
	public static Item getInstance(Produto produto, double preco, int qtd) {
		if (produto != null && preco > 0 && qtd > 0) {
			return new Item(produto, preco, qtd);
		} else {
			return null;
		}
		
	}
	
	
	// Getters and Setters
	
	/**
	 * @return the preco
	 */
	public double getPreco() {
		return preco;
	}
	/**
	 * @return the qtd
	 */
	public int getQtd() {
		return qtd;
	}
	
	
}
