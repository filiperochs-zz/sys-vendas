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
	
	public boolean alterarProduto(long id, Produto produto) {
		if (produto != null) {
			boolean retorna = substituirProduto(id, produto);
			
			return retorna;
		} else {
			return false;
		}
	}
	
	public boolean alterarVenda(Venda venda) {
		if (venda != null) {
			boolean retorna = substituirVenda(venda.getId(), venda);
			
			return retorna;
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
			return false;
		}
	}
	
	public boolean existeIDProduto(int id) {
		if (id > 0) {
			boolean existe=false;
			for (int i = 0; i < numProdutos; i++) {
				if (produtos[i].getId() == id) {
					existe = true;
					break;
				} else if (i == numProdutos-1) {
					existe = false;
				}
			}
			
			return existe;
		} else {
			return false;
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
	
	private Produto[] extendeVetor(Produto[] produtos) { // extende o vetor produtos[] em +1
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
	
	private Venda[] extendeVetor(Venda[] vendas) { // extende o vetor vendas[] em +1
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
	
	private boolean substituirProduto(long id, Produto produto) {
		if (id > 0 && produto != null) {
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
				produtos[j] = produto;
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public boolean excluirProduto(int id) {
		if (id > 0) {
			int j = 0;
			boolean existe = false;
			for (int i = 0; i < produtos.length; i++) {
				if (produtos[i].getId() != id) {
					j++;
				} else {
					existe = true;
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
			
			if (existe) {
				produtos = produtosAux;
				numProdutos--;
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	private Venda buscarVenda(int id) {
		if (id > 0) {
			int j = 0;
			for (int i = 0; i < numVendas; i++) {
				if (vendas[i].getId() == id) {
					j = i;
					break;
				} else if (i == numVendas-1) {
					j = -1;
				}
			}
			
			if (j != -1) {
				return vendas[j];
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	
	private boolean substituirVenda(long id, Venda venda) {
		if (id > 0 && venda != null) {
			int j = 0;
			for (int i = 0; i < numVendas; i++) {
				if (vendas[i].getId() == id) {
					j = i;
					break;
				} else if (i == numVendas-1) {
					j = -1;
				}
			}
			
			if (j != -1) {
				vendas[j] = venda;
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public boolean excluirVenda(int id) {
		if (id > 0) {
			int j = 0;
			boolean existe = false;
			for (int i = 0; i < vendas.length; i++) {
				if (vendas[i].getId() != id) {
					j++;
				} else {
					existe = true;
				}
			}
			
			Venda[] vendasAux = new Venda[j];
			
			int index = 0;
			
			for (int i = 0; i < vendas.length; i++) {
				if (vendas[i].getId() != id) {
					vendasAux[index] = vendas[i];
					index++;
				}
			}
			
			if (existe) {
				vendas = vendasAux;
				numVendas--;
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
