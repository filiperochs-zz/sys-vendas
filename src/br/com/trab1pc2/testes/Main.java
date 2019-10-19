package br.com.trab1pc2.testes;
import br.com.trab1pc2.sistema.*;
import br.com.trab1pc2.produto.*;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
	private static Scanner inT = new Scanner(System.in);
	private static Scanner inN = new Scanner(System.in);
	private static Sistema sis = Sistema.getInstance();
	private static SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

	public static void main(String[] args) {
		init();
		ligarSys();

	}
	
	// Menu Atendente
	public static void menuAtendente() {
		int opcao = 1, opcao2 = 1, opcao3 = 1;
		do {
			opcao = 1; opcao2 = 1;
			System.out.printf("\n<---> ATENDENTE <--->\n");
			System.out.printf("1. Criar Venda\n");
			System.out.printf("2. Procurar - Listagens\n");
			System.out.printf("0. Deslogar\n");
			System.out.printf(": ");
			opcao = inN.nextInt();
			System.out.printf("\n");
			opcao2 = 1;

			switch (opcao) {
			
			case 1:
				opcao2 = 1;
				Pedido pedido = criarPedido();
				while(opcao2 != 0) {
					System.out.printf("\n<---> Menu de Venda <--->\n");
					System.out.printf("1. Adicionar Item ao Pedido.\n");
					System.out.printf("2. Finalizar Venda.\n");
					System.out.printf("0. Cancelar e Voltar.\n");
					System.out.printf(": ");
					opcao2 = inN.nextInt();
					System.out.printf("\n");
					
					switch (opcao2) {
					case 0:
						break;
						
					case 1:
						listarProdutoNome();
						lerItem(pedido);
						opcao3 = 1;
						while(opcao3 != 0) {
							System.out.printf("\n<---> ----------------- <--->\n");
							System.out.printf("1. Novo Item.\n");
							System.out.printf("2. Ver itens no pedido.\n");
							System.out.printf("3. Listar produtos.\n");
							System.out.printf("0. Voltar.\n");
							System.out.printf(": ");
							opcao3 = inN.nextInt();
							System.out.printf("\n");
							
							switch (opcao3) {
							case 0:
								break;
								
							case 1:
								lerItem(pedido);
								
								break;
								
							case 2:
								listarItens(pedido);
								
								break;
								
							case 3:
								listarProdutos();
								
								break;
								
							default:
								System.out.printf("Opção Inválida!\n");
								break;
							}
							
						}
						
						break;
						
					case 2:
						listarItens(pedido);
						
						criarVenda(pedido);
						
						System.out.printf("\n\n");
						
						listarVendas();
						opcao2 = 0;
						break;
						
					default:
						System.out.printf("Opção Inválida!\n");
						break;
					}
					
				}
				
				break;
			
			case 2:
				opcao2 = 1;
				while(opcao2 != 0) {
					System.out.printf("\n<---> Menu de Pesquisa <--->\n");
					System.out.printf("1. Ver produtos.\n");
					System.out.printf("0. Voltar ao Menu Principal.\n");
					System.out.printf(": ");
					opcao2 = inN.nextInt();
					System.out.printf("\n");
					
					switch (opcao2) {
					case 0:
						break;
						
					case 1:
						listarProdutos();
						
						break;
							
					default:
						System.out.printf("Opção Inválida!\n");
						break;
					}
					
				}
				
				break;
				
			case 0:
				System.out.printf("Deslogando...\n");
				break;

			default:
				System.out.printf("Opção Inválida!\n");
				break;

			}

		} while (opcao != 0);
	}
	
	// Menu Adminsitrador
	public static void menuAdministrador() {
		int opcao = 1, opcao2 = 1, opcao3 = 1;
		do {
			opcao = 1; opcao2 = 1; opcao3 = 1;
			System.out.printf("\n<---> ADMINISTRADOR <--->\n");
			System.out.printf("1. Inserir Produto\n");
			System.out.printf("2. Excluir Produto\n");
			System.out.printf("3. Alterar Produto\n");
			System.out.printf("4. Procurar - Listagens\n");
			System.out.printf("0. Deslogar\n");
			System.out.printf(": ");
			opcao = inN.nextInt();
			System.out.printf("\n");
			opcao2 = 1;

			switch (opcao) {

			case 1:
				opcao2 = 1;
				while(opcao2 != 0) {
					System.out.printf("\n<---> Menu de Inserção de Produtos <--->\n");
					System.out.printf("1. Inserir produto.\n");
					System.out.printf("0. Voltar ao Menu Principal.\n");
					System.out.printf(": ");
					opcao2 = inN.nextInt();
					System.out.printf("\n");
					
					switch (opcao2) {
					case 0:
						break;
					case 1:
						Produto produto = lerProduto();
						
						if (sis.inserirProduto(produto)) {
							System.out.printf("Produto inserido com sucesso.\n");
						} else {
							System.out.println("Falha ao inserir produto.\n");
						}
						break;
					default:
						System.out.printf("Opção Inválida!\n");
						break;
					}
					
				}
				
				break;
				
			case 2:
				opcao2 = 1;
				while(opcao2 != 0) {
					System.out.printf("\n<---> Menu de Exclusão de Produtos <--->\n");
					System.out.printf("1. Ver produtos.\n");
					System.out.printf("2. Excluir produto.\n");
					System.out.printf("0. Voltar ao Menu Principal.\n");
					System.out.printf(": ");
					opcao2 = inN.nextInt();
					System.out.printf("\n");
					
					switch (opcao2) {
					case 0:
						break;
						
					case 1:
						listarProdutos();
						
						break;
						
					case 2:
						boolean retorno;
						
						retorno = excluirProduto();
						
						
						if (retorno) {
							System.out.printf("Produto excluído com sucesso!\n");
						} else {
							System.out.printf("Falha ao excluir. Produto não existe ou ID inválido.\n");
						}
						
						break;
						
					default:
						System.out.printf("Opção Inválida!\n");
						break;
					}
					
				}
				
				break;
			
			case 3:
				opcao2 = 1;
				while(opcao2 != 0) {
					System.out.printf("\n<---> Menu de Alteração de Produtos <--->\n");
					System.out.printf("1. Ver produtos.\n");
					System.out.printf("2. Alterar produto.\n");
					System.out.printf("0. Voltar ao Menu Principal.\n");
					System.out.printf(": ");
					opcao2 = inN.nextInt();
					System.out.printf("\n");
					
					switch (opcao2) {
					case 0:
						break;
						
					case 1:
						listarProdutos();
						
						break;
						
					case 2:
						boolean retorno;
						
						retorno = alterarProduto();
						
						if (retorno) {
							System.out.printf("Produto alterado com sucesso!\n");
						} else {
							System.out.printf("Falha ao alterar. Produto não existe ou ID inválido.\n");
						}
						
						break;
						
					default:
						System.out.printf("Opção Inválida!\n");
						break;
					}
					
				}
				
				break;
				
			case 4:
				opcao2 = 1;
				while(opcao2 != 0) {
					System.out.printf("\n<---> Menu de Pesquisa <--->\n");
					System.out.printf("1. Ver produtos.\n");
					System.out.printf("2. Ver vendas.\n");
					System.out.printf("0. Voltar ao Menu Principal.\n");
					System.out.printf(": ");
					opcao2 = inN.nextInt();
					System.out.printf("\n");
					
					switch (opcao2) {
					case 0:
						break;
						
					case 1:
						listarProdutos();
						
						break;
						
					case 2:
						opcao3 = 1;
						while(opcao3 != 0) {
							System.out.printf("\n<---> -------------- <--->\n");
							System.out.printf("1. Ver todas as vendas.\n");
							System.out.printf("2. Ver todas as vendas em determinado dia.\n");
							System.out.printf("3. Ver venda com código.\n");
							System.out.printf("0. Voltar ao Menu Principal.\n");
							System.out.printf(": ");
							opcao3 = inN.nextInt();
							System.out.printf("\n");
							
							switch (opcao3) {
							
							case 1:
								listarVendas();
								
								break;
								
							case 2:
								listarVendasDia();
								
								break;
								
							case 3:
								listarVendaID();
								
								break;
								
							case 0:
								
								break;
							
							default:
								System.out.printf("Opção Inválida!\n");
								break;
							}
							
							
						}
						
						break;
						
					default:
						System.out.printf("Opção Inválida!\n");
						break;
					}
					
				}
				
				break;
				
			case 0:
				System.out.printf("Deslogando...\n");
				break;

			default:
				System.out.printf("Opção Inválida!\n");
				break;

			}

		} while (opcao != 0);
	}
	
	public static void ligarSys() {
		int opcao = 1;
		do {
			opcao = 1;
			System.out.printf("\n<---> Mercadinho Iguaçu <--->\n");
			System.out.printf("1. Fazer login.\n");
			System.out.printf("0. Desligar sistema.\n");
			System.out.printf(": ");
			opcao = inN.nextInt();
			System.out.printf("\n");
			
			switch (opcao) {
			
			case 1:
				login();
				
				break;
				
			case 0:
				System.out.printf("Desligando sistema...\n");
				break;
			
			default:
				System.out.printf("Opção Inválida!\n");
				break;
			}
			
		} while(opcao != 0);
	}
	
	public static void login() {
		System.out.printf("Usuário: ");
		String user = inT.nextLine();
		System.out.printf("Senha: ");
		String pass = inT.nextLine();
		
		if (user != null && pass != null) {
			if (user.equalsIgnoreCase("adm") && pass.equalsIgnoreCase("123")) {
				menuAdministrador();
			} else if(user.equalsIgnoreCase("atend") && pass.equalsIgnoreCase("123")) {
				menuAtendente();
			} else {
				System.out.printf("\nUsuário ou senha incorretos.\n");
			}
		}
	}
	
	// Ler os dados do produto informados pelo usuário
	private static Produto lerProduto() {
		
		System.out.printf("\nNome do Produto: ");
		String nome = inT.nextLine();
		System.out.printf("\nDescrição: ");
		String descricao = inT.nextLine();
		System.out.printf("\nPreço: ");
		double preco = inN.nextDouble();
		System.out.printf("\nQuantidade em estoque: ");
		int qtdEstoque = inN.nextInt();
		
		Produto produto = Produto.getInstance(nome, descricao, preco, qtdEstoque); // retorna objeto produto
		
		if (produto == null) {
			System.out.printf("Dados incorretos!\n");
			produto = lerProduto();
		} else {
			System.out.printf("Inserindo dados...\n");
		}
		
		return produto;
	}
	
	private static boolean excluirProduto() {
		
		int id;
		
		System.out.printf("ID do produto: ");
		id = inN.nextInt();
		System.out.printf("\n");
		
		return sis.excluirProduto(id);
		
	}
	
	private static boolean alterarProduto() {
		
		System.out.printf("ID do Produto: ");
		long id = inN.nextLong();
		System.out.printf("\nAlterar Dados:\n");
		Produto produto = lerProduto();
		
		return sis.alterarProduto(id, produto);
		
	}
	
	private static Item lerItem(Pedido pedido) { 
		
		System.out.printf("\nID do Produto: ");
		int id = inN.nextInt();
		System.out.printf("\nQuantidade: ");
		int qtd = inN.nextInt();
		
		Item item = sis.criarItem(id, qtd);
		
		if (item == null) {
			System.out.printf("Dados incorretos!\n");
		} else {
			pedido.inserirItem(item);
			System.out.printf("Inserindo dados...\n");
		}
		
		return item;
	}
	
	private static Pedido criarPedido() {
		return sis.criarPedido();
	}
	
	private static void criarVenda(Pedido pedido) {
		
		System.out.printf("\nNome do Cliente: ");
		String cliente = inT.nextLine();
		System.out.printf("\nData: ");
		String data = inT.nextLine();
		
		Venda venda = Venda.getInstance(pedido, cliente, data);
		
		if (venda != null) {
			if (sis.realizarVenda(venda)) {
				System.out.printf("\nVenda realizada com sucesso.\n");
			} else {
				System.out.printf("\nFalha ao realizar venda.\n");
			}
		} else {
			System.out.printf("\nFalha ao criar venda.\n");
		}
		
	}
	
	private static void listarItens(Pedido pedido) {
		if (pedido != null) {
			Item[] itens = sis.listarItens(pedido);
			
			System.out.printf("\n<--> Lista de Itens: <-->\n");
			for (int i = 0; i < itens.length; i++) {
				System.out.printf("Produto: %s\nPreço: R$%.2f\nQuantidade: %d\n\n", itens[i].getProduto().getNome(), itens[i].getPreco(), itens[i].getQtd());
			}
			System.out.printf("\n<--> -------------- <-->\n");
			
		} else {
			System.out.println("Erro ao listar itens.");
		}
	}
	
	private static void listarProdutos() {
		Produto[] produtos = sis.listarProdutos();
		
		System.out.printf("\n<--> Lista de Produtos: <-->\n");
		for (int i = 0; i < produtos.length; i++) {
			System.out.printf("ID: %d\nNome: %s\nDescrição: %s\nPreço: R$%.2f\nQuantidade em estoque: %d\n\n", produtos[i].getId(), produtos[i].getNome(), produtos[i].getDescricao(), produtos[i].getPreco(), produtos[i].getQtdEstoque());
		}
		System.out.printf("\n<--> -------------- <-->\n");
	}
	
	private static void listarProdutoNome() {
		
		System.out.printf("\nNome: ");
		String nome = inT.nextLine();
		
		Produto produto = sis.buscarProdutoNome(nome);
		if (produto != null) {
			System.out.printf("\n<--> Produto: <-->\n");
			System.out.printf("ID: %d\nNome: %s\nDescrição: %s\nPreço: R$%.2f\nQuantidade em estoque: %d\n\n", produto.getId(), produto.getNome(), produto.getDescricao(), produto.getPreco(), produto.getQtdEstoque());
			System.out.printf("\n<--> -------------- <-->\n");
		} else {
			System.out.printf("\nProduto não encontrado.\n");
			listarProdutoNome();
		}
	}
	
	private static void listarVendas() {
		Venda[] vendas = sis.listarVendas();
		
		System.out.printf("\n<--> Lista de Vendas: <-->\n");
		for (int i = 0; i < vendas.length; i++) {
			System.out.printf("ID: %d\nPedido: \n", vendas[i].getId());
			listarProdutosVenda(vendas[i]);
			System.out.printf("\nPreço total: R$%.2f\nCliente: %s\nData: %s\n\n", vendas[i].getPedido().getPrecoTotal(), vendas[i].getCliente(), formato.format(vendas[i].getData()));
		}
		System.out.printf("\n<--> -------------- <-->\n");
	}
	
	private static void listarVendasDia() {
		
		System.out.printf("\nBuscar vendas no dia: ");
		String data = inT.nextLine();
		
		if (data != null && (data.length() >= 8 && data.length() <= 10)) {
			Venda[] vendas = sis.listarVendasDia(data);
			System.out.printf("\n<--> Lista de Vendas do dia %s: <-->\n", data);
			for (int i = 0; i < vendas.length; i++) {
				System.out.printf("ID: %d\nPedido: \n", vendas[i].getId());
				listarProdutosVenda(vendas[i]);
				System.out.printf("\nPreço total: R$%.2f\nCliente: %s\nData: %s\n\n", vendas[i].getPedido().getPrecoTotal(), vendas[i].getCliente(), formato.format(vendas[i].getData()));
			}
			System.out.printf("\n<--> -------------- <-->\n");
			
		} else {
			System.out.printf("\nData incorreta (dia/mês/ano).\n");
		}
	}
	
	private static void listarVendaID() {
		
		System.out.printf("\nID da venda: ");
		long id = inN.nextLong();
		
		Venda venda = sis.buscarVendaID(id);
		
		if (venda != null) {
		
			System.out.printf("\nID: %d\nPedido: \n", venda.getId());
			listarProdutosVenda(venda);
			System.out.printf("\nPreço total: R$%.2f\nCliente: %s\nData: %s\n\n", venda.getPedido().getPrecoTotal(), venda.getCliente(), formato.format(venda.getData()));
		
			System.out.printf("\n<--> -------------- <-->\n");
		} else {
			System.out.printf("\nID não encontrado.\n");
		}
	}
	
	private static void listarProdutosVenda(Venda venda) {
		Item[] itens = sis.listarProdutosVenda(venda);
		
		if (itens != null) {
			for (int i = 0; i < itens.length; i++) {
				System.out.printf("\n-> %s\nPreço: R$%.2f\nQuantidade: %d\n", itens[i].getProduto().getNome(), itens[i].getPreco(), itens[i].getQtd());
			}
		}
	}
	
	private static void init() {
		
		Produto produto = Produto.getInstance("Jaca", "Fruta", 12.99, 50);
		sis.inserirProduto(produto);
		produto = Produto.getInstance("Uva", "Fruta", 10.99, 10);
		sis.inserirProduto(produto);
		produto = Produto.getInstance("Melão", "Fruta", 5.99, 40);
		sis.inserirProduto(produto);
		produto = Produto.getInstance("Melancia", "Fruta", 1.99, 5);
		sis.inserirProduto(produto);
		produto = Produto.getInstance("Maracujá", "Fruta", 16.99, 45);
		sis.inserirProduto(produto);
		
		Pedido pedido = criarPedido();
		Item item;
		item = sis.criarItem(sis.buscarProduto(1).getId(), 3);
		pedido.inserirItem(item);
		item = sis.criarItem(sis.buscarProduto(2).getId(), 2);
		pedido.inserirItem(item);
		item = sis.criarItem(sis.buscarProduto(4).getId(), 4);
		pedido.inserirItem(item);
		
		Venda venda = Venda.getInstance(pedido, "João", "10/07/2019");
		sis.realizarVenda(venda);
		
		pedido = criarPedido();
		item = sis.criarItem(sis.buscarProduto(2).getId(), 3);
		pedido.inserirItem(item);
		item = sis.criarItem(sis.buscarProduto(2).getId(), 2);
		pedido.inserirItem(item);
		item = sis.criarItem(sis.buscarProduto(3).getId(), 4);
		pedido.inserirItem(item);
		
		venda = Venda.getInstance(pedido, "Filipe", "19/10/2019");
		sis.realizarVenda(venda);
		
		pedido = criarPedido();
		item = sis.criarItem(sis.buscarProduto(3).getId(), 3);
		pedido.inserirItem(item);
		item = sis.criarItem(sis.buscarProduto(1).getId(), 2);
		pedido.inserirItem(item);
		
		venda = Venda.getInstance(pedido, "Luciano", "20/10/2019");
		sis.realizarVenda(venda);
		
		
		
	}

}
