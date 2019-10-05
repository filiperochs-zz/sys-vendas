package br.com.trab1pc2.produto;

public class Pedido {
	private Item itens[];
	private static int numItens=0;
	
	// Construtores
	
	private Pedido() {
		itens = new Item[1];
	}
	
	public static Pedido getInstance() {
		return new Pedido();
	}
	
	// Métodos

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
