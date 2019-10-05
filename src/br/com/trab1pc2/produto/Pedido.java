package br.com.trab1pc2.produto;

public class Pedido {
	private Item itens[];
	private int numItens=0;

	public boolean inserir(Item item) {
		return false;
	}
	
	// Getters and Setters
	
	/**
	 * @return the itens
	 */
	public Item[] getItens() {
		return itens;
	}

	/**
	 * @param itens the itens to set
	 */
	public void setItens(Item[] itens) {
		this.itens = itens;
	}
	
	
}
