package br.com.trab1pc2.produto;

public class Pedido {
	private Item itens[];
	private double precoTotal;
	private static int numItens=0;
	
	// Construtores
	
	private Pedido() {
		itens = new Item[1];
		precoTotal = 0;
		numItens=0;
	}
	
	public static Pedido getInstance() {
		return new Pedido();
	}
	
	// Métodos

	public boolean inserirItem(Item item) {	// faz a inserção de um Item ao vetor itens
		if (item != null) {
			if (numItens >= itens.length) {
				itens = extendeVetor(itens);
			}
			
			if (existeItem(item) != -1) {
				itens[existeItem(item)].somarQtd(item.getQtd());
			} else {
				itens[numItens] = item;
				numItens++;
			}
			atualizarPrecoTotal(item.getPreco(), item.getQtd());
			return true; // item inserido com sucesso
		} else {
			return false; // throw Exception
		}
	}
	
	private double atualizarPrecoTotal(double preco, int qtd) { // atualizar o valor do precoTotal
		return (precoTotal += preco*qtd);
	}
	
	private Item[] extendeVetor(Item[] itens) { // extende o vetor itens[] em +10
		if (numItens >= itens.length) {
			Item[] aux = new Item[itens.length+1];
			for (int i = 0; i < itens.length; i++) {
				aux[i] = itens[i];
			}
			
			return aux;
		} else {
			return itens;
		}
	}

	// Métodos
	
	private int existeItem(Item item) {
		if (item != null) {
			for (int i = 0; i < numItens; i++) {
				if (itens[i].getProduto().getId() == item.getProduto().getId()) {
					return i;
				}
			}
			
			return -1;
		} else {
			return -1;
		}
	}
	
	// Getters and Setters
	
	/**
	 * @return the itens
	 */
	public Item[] getItens() {
		return itens;
	}

	/**
	 * @return the precoTotal
	 */
	public double getPrecoTotal() {
		return precoTotal;
	}
	
	
}
