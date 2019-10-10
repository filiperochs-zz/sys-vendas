package br.com.trab1pc2.sistema;
import br.com.trab1pc2.produto.Item;
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
		vendas = new Venda[1];
	}
	
	public static Sistema getInstance() {
		return s;
	}
	
	// Métodos
	
	public boolean inserirProduto(Produto produto) {
		if (produto != null && !existeNome(produto)) {
			if (numProdutos >= produtos.length) {
				produtos = extendeVetor(produtos);
			}
			
			produtos[numProdutos] = produto;
			numProdutos++;
			
			return true;
		} else {
			return false;
		}
	}
	
	public boolean existeNome(Produto produto) {
		if (produto != null) {
			boolean existe=false;
			for (int i = 0; i < numProdutos; i++) {
				if (produtos[i].getNome().equalsIgnoreCase(produto.getNome())) {
					existe = true;
					break;
				} else if (i == numProdutos-1) {
					existe = false;
				}
			}
			
			return existe;
		} else {
			return true;
		}
	}
	
	public boolean inserirVenda(Venda venda) {
		if (venda != null) {
			if (numVendas >= vendas.length) {
				vendas = extendeVetor(vendas);
			}
			
			vendas[numVendas] = venda;
			numVendas++;
			
			return true;
		} else {
			return false;
		}
	}
	
//	public boolean inserirPedido(Pedido pedido) {
//		if (pedido != null) {
//			if (numPedidos >= pedidos.length) {
//				pedidos = extendeVetor(pedidos);
//			}
//			
//			pedidos[numPedidos] = pedido;
//			numPedidos++;
//			
//			return true;
//		} else {
//			return false;
//		}
//	}
//	
//	public boolean inserirItem(Item item) {
//		if (item != null) {
//			if (numItens >= itens.length) {
//				itens = extendeVetor(itens);
//			}
//			
//			
//			
//			itens[numItens] = item;
//			numItens++;
//			
//			return true;
//		} else {
//			return false;
//		}
//	}
	
	private Produto[] extendeVetor(Produto[] produtos) { // extende o vetor produtos[] em +10
		if (numProdutos >= produtos.length) {
			Produto[] aux = new Produto[produtos.length+1];
			for (int i = 0; i < produtos.length; i++) {
				aux[i] = produtos[i];
			}
			
			return aux;
		} else {
			return produtos;
		}
	}
	
	private Venda[] extendeVetor(Venda[] vendas) { // extende o vetor vendas[] em +10
		if (numVendas >= vendas.length) {
			Venda[] aux = new Venda[vendas.length+1];
			for (int i = 0; i < vendas.length; i++) {
				aux[i] = vendas[i];
			}
			
			return aux;
		} else {
			return vendas;
		}
	}
	
//	private Pedido[] extendeVetor(Pedido[] pedidos) { // extende o vetor pedidos[] em +10
//		if (numPedidos >= pedidos.length) {
//			Pedido[] aux = new Pedido[pedidos.length+10];
//			for (int i = 0; i < pedidos.length; i++) {
//				aux[i] = pedidos[i];
//			}
//			
//			return aux;
//		} else {
//			return pedidos;
//		}
//	}
	
//	private Item[] extendeVetor(Item[] itens) { // extende o vetor pedidos[] em +10
//		if (numItens >= itens.length) {
//			Item[] aux = new Item[itens.length+10];
//			for (int i = 0; i < itens.length; i++) {
//				aux[i] = itens[i];
//			}
//			
//			return aux;
//		} else {
//			return itens;
//		}
//	}
	
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
	
//	public Produto criarProduto(String nome, String descricao, double preco, int qtdEstoque) {
//		if (id > 0 && qtd > 0) {
//			Produto produto = buscarProduto(id);
//			Item item;
//			
//			if (produto != null) {
//				item = Item.getInstance(produto, produto.getPreco(), qtd);
//				System.out.println(item);
//			} else {
//				item = null;
//			}
//			
//			return item;
//		} else {
//			return null;
//		}
//	}
	
	public Item criarItem(int id, int qtd) {
		Produto produto = buscarProduto(id);
		Item item;
		
		if (produto != null) {
			item = Item.getInstance(produto, produto.getPreco(), qtd);
			System.out.println(item);
		} else {
			item = null;
		}
			
		return item;
	}
	
	private Produto buscarProduto(int id) {
		if (id > 0) {
			int j = 0;
			for (int i = 0; i < numProdutos; i++) {
				if (produtos[i].getId() == id) {
					j = i;
					break;
				} else if (i == numProdutos-1) {
					j = -1;
				}
			}
			
			if (j != -1) {
				return produtos[j];
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	
	public boolean excluirProduto(int id) {
		if (id > 0) {
			int j = 0;
			for (int i = 0; i < produtos.length; i++) {
				if (produtos[i].getId() != id) {
					j++;
				}
			}
			
			Produto[] produtosAux = new Produto[j];
			
			int index = 0;
			
			for (int i = 0; i < produtos.length; i++) {
				if (produtos[i].getId() != id) {
					produtosAux[index] = produtos[i];
					index++;
				}
			}
			produtos = produtosAux;
			
			return true;
		} else {
			return false;
		}
	}
}
