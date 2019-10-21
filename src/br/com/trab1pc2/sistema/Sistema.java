package br.com.trab1pc2.sistema;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.trab1pc2.produto.Item;
import br.com.trab1pc2.produto.Pedido;
import br.com.trab1pc2.produto.Produto;

// Sistema será um singleton
public class Sistema {
	private Produto produtos[];
	private Venda vendas[];
	private static int numProdutos = 0;
	private static int numVendas = 0;
	private static Sistema s = new Sistema();
	private static SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

	// Contrutor

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
			boolean existe = false;
			for (int i = 0; i < numProdutos; i++) {
				if (produtos[i].getNome().equalsIgnoreCase(produto.getNome())) {
					existe = true;
					break;
				} else if (i == numProdutos - 1) {
					existe = false;
				}
			}

			return existe;
		} else {
			return false;
		}
	}

	public boolean existeIDProduto(long id) {
		if (id > 0) {
			boolean existe = false;
			for (int i = 0; i < numProdutos; i++) {
				if (produtos[i].getId() == id) {
					existe = true;
					break;
				} else if (i == numProdutos - 1) {
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
			Produto[] aux = new Produto[produtos.length + 1];
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
			Venda[] aux = new Venda[vendas.length + 1];
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
			if (!this.produtos[i].getExcluido()) {
				produtos[i] = this.produtos[i];
			}

		}

		return produtos;
	}

	public Venda[] listarVendas() { // Listar todas as vendas (retorna um vetor vendas[] de Venda)
		Venda[] vendas = new Venda[numVendas];

		for (int i = 0; i < vendas.length; i++) {
			vendas[i] = this.vendas[i];
		}

		return vendas;
	}

	public Item[] listarProdutosVenda(Venda venda) {
		if (venda != null) {
			Item[] itens = new Item[venda.getPedido().getItens().length];

			for (int i = 0; i < venda.getPedido().getItens().length; i++) {
				itens[i] = venda.getPedido().getItens()[i];
			}

			return itens;
		} else {
			return null;
		}
	}

	public Venda[] listarVendasDia(String data) { // Listar todas as vendas no dia (retorna um vetor vendas[] de Venda)
		int cont = 0;
		Venda[] vendas = null;

		Date dataFormatada = null;
		try {
			dataFormatada = formato.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (dataFormatada != null) {
			cont = 0;
			for (int i = 0; i < this.vendas.length; i++) {
				if (this.vendas[i].getData().equals(dataFormatada)) {
					cont++;
				}
			}
			vendas = new Venda[cont];
			int j = 0;
			for (int i = 0; i < this.vendas.length; i++) {
				if (this.vendas[i].getData().equals(dataFormatada)) {
					vendas[j] = this.vendas[i];
					j++;
				}
			}
		}

		return vendas;
	}

	public Venda[] listarVendasCliente(String cliente) { // Listar todas as vendas de um cliente (retorna um vetor vendas[] de Venda)
		if (cliente != null && cliente.length() >= 2) {
		
			int cont = 0;
			Venda[] vendas = null;
			
			cont = 0;
			for (int i = 0; i < this.vendas.length; i++) {
				if (this.vendas[i].getCliente().equalsIgnoreCase(cliente)) {
					cont++;
				}
			}
			
			vendas = new Venda[cont];
			int j = 0;
			
			for (int i = 0; i < this.vendas.length; i++) {
				if (this.vendas[i].getCliente().equalsIgnoreCase(cliente)) {
					vendas[j] = this.vendas[i];
					j++;
				}
			}
	
			return vendas;
			
		} else {
			return null;
		}
	}

	public Venda buscarVendaID(long id) {
		if (id > 0 && numVendas > 0) {
			int j = 0;
			for (int i = 0; i < numVendas; i++) {
				if (vendas[i].getId() == id) {
					j = i;
					break;
				} else if (i == numVendas - 1) {
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

	public boolean buscarProdutoVenda(Produto produto) {
		if (produto != null && existeIDProduto(produto.getId())) {
			for (int i = 0; i < vendas.length; i++) {
				Item[] itens = listarProdutosVenda(vendas[i]);

				for (int j = 0; j < itens.length; j++) {
					if (itens[j].getProduto().getId() == produto.getId()) {
						return true;
					}
				}
			}

			return false;

		} else {
			return false;
		}
	}

	public Item criarItem(long id, int qtd) {
		Produto produto = buscarProduto(id);

		if (produto != null) {
			if (qtd <= produto.getQtdEstoque()) {
				return Item.getInstance(produto, produto.getPreco(), qtd);
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	public Pedido criarPedido() {
		return Pedido.getInstance();
	}

	public boolean realizarVenda(Venda venda) {
		if (venda != null) {
			if (inserirVenda(venda)) {
				Produto produto;
				for (int i = 0; i < venda.getPedido().getItens().length; i++) {
					produto = buscarProduto(venda.getPedido().getItens()[i].getProduto().getId());
					if (!produto.alterarEstoque(venda.getPedido().getItens()[i].getQtd())) {
						return false;
					}
				}

				return true;
			} else {
				return false;
			}

		} else {
			return false;
		}
	}

	public Item[] listarItens(Pedido pedido) {
		if (pedido != null) {
			return pedido.getItens();
		} else {
			return null;
		}
	}

	public Produto buscarProduto(long id) {
		if (id > 0) {
			int j = 0;
			for (int i = 0; i < numProdutos; i++) {
				if (produtos[i].getId() == id) {
					j = i;
					break;
				} else if (i == numProdutos - 1) {
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

	public Produto buscarProdutoNome(String nome) {
		if (nome != null && nome.length() >= 2) {
			int j = 0;
			for (int i = 0; i < numProdutos; i++) {
				if (produtos[i].getNome().equalsIgnoreCase(nome)) {
					j = i;
					break;
				} else if (i == numProdutos - 1) {
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
				} else if (i == numProdutos - 1) {
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
					if (buscarProdutoVenda(buscarProduto(id))) {
						produtos[i].excluir();
					}
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

	private boolean substituirVenda(long id, Venda venda) {
		if (id > 0 && venda != null) {
			int j = 0;
			for (int i = 0; i < numVendas; i++) {
				if (vendas[i].getId() == id) {
					j = i;
					break;
				} else if (i == numVendas - 1) {
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
