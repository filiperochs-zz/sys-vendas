package br.com.trab1pc2.testes;
import br.com.trab1pc2.sistema.*;
import br.com.trab1pc2.produto.*;
import java.util.Scanner;

public class Main {
	private static Scanner inT = new Scanner(System.in);
	private static Scanner inN = new Scanner(System.in);
	private static Sistema sis = Sistema.getInstance();

	public static void main(String[] args) {
		init();
		menuAtendente();

	}
	
	// Menu Atendente
	public static void menuAtendente() {
		int opcao = 1, opcao2 = 1, opcao3 = 1;
		do {
			System.out.printf("\n<---> ATENDENTE <--->\n");
			System.out.printf("1. Criar Pedido\n");
//			System.out.printf("2. Listar Produtos\n");
			System.out.printf("4. Procurar - Listagens\n");
			System.out.printf("4. ...\n");
			System.out.printf("0. SAIR\n");
			System.out.printf(": ");
			opcao = inN.nextInt();
			System.out.printf("\n");
			opcao2 = 1;

			switch (opcao) {
			
			case 4:
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
						listarVendas();
						
						break;
						
					default:
						System.out.printf("Opção Inválida!\n");
						break;
					}
					
				}
				
				break;
				
//			case 2:
//				listarProdutos();
//				
//				break;

			case 1:
				while(opcao2 != 0) {
					System.out.printf("\n<---> Menu de Pedidos <--->\n");
					System.out.printf("1. Adicionar Item ao Pedido.\n");
					System.out.printf("2. Finalizar Pedido.\n");
					System.out.printf("0. Cancelar e Voltar.\n");
					System.out.printf(": ");
					opcao2 = inN.nextInt();
					System.out.printf("\n");
					
					switch (opcao2) {
					case 0:
						break;
						
					case 1:
						Pedido pedido = criarPedido();
						listarProdutos();
						while(opcao3 != 0) {
							System.out.printf("\n<---> ----------------- <--->\n");
							System.out.printf("1. Novo Item.\n");
							System.out.printf("2. Ver itens.\n");
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
				System.out.printf("Saindo da Aplicação.\n");
				break;

			default:
				System.out.printf("Opção Inválida!\n");
				break;

			}

		} while (opcao != 0);
	}
	
	// Menu Adminsitrador
	public static void menuAdministrador() {
		int opcao = 1, opcao2 = 1;
		do {
			System.out.printf("\n<---> ADMINISTRADOR <--->\n");
			System.out.printf("1. Inserir Produto\n");
//			System.out.printf("2. Listar Produtos\n");
			System.out.printf("2. Excluir Produto\n");
			System.out.printf("3. Alterar Produto\n");
			System.out.printf("4. Procurar - Listagens\n");
//			System.out.printf("3. Criar Pedido\n");
			System.out.printf("4. ...\n");
			System.out.printf("0. SAIR\n");
			System.out.printf(": ");
			opcao = inN.nextInt();
			System.out.printf("\n");
			opcao2 = 1;

			switch (opcao) {

			case 1:
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
						listarVendas();
						
						break;
						
					default:
						System.out.printf("Opção Inválida!\n");
						break;
					}
					
				}
				
				break;
				
//			case 2:
//				listarProdutos();
//				
//				break;

//			case 3:
//				while(opcao2 != 0) {
//					System.out.printf("\n<---> Menu de Criação de Pedidos <--->\n");
//					System.out.printf("1. Adicionar Itens ao Pedido.\n");
//					System.out.printf("2. Finalizar Pedido.\n");
//					System.out.printf("0. Cancelar e Voltar.\n");
//					System.out.printf(": ");
//					opcao2 = inN.nextInt();
//					System.out.printf("\n");
//					
//					switch (opcao2) {
//					case 0:
//						break;
//					case 1:
//						int id, qtd;
//						
//						listarProdutos();
//						
//						System.out.println(lerItem());
//						
//						
//						break;
//					default:
//						System.out.printf("Opção Inválida!\n");
//						break;
//					}
//					
//				}
//				
//				break;

			case 0:
				System.out.printf("Saindo da Aplicação.\n");
				break;

			default:
				System.out.printf("Opção Inválida!\n");
				break;

			}

		} while (opcao != 0);
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
	
	private static void listarVendas() {
		Venda[] vendas = sis.listarVendas();
		
		System.out.printf("\n<--> Lista de Vendas: <-->\n");
		for (int i = 0; i < vendas.length; i++) {
			System.out.printf("ID: %d\nPedido: %s\nCliente: %s\nData: %s\n\n", vendas[i].getId(), vendas[i].getPedido(), vendas[i].getCliente(), vendas[i].getData());
		}
		System.out.printf("\n<--> -------------- <-->\n");
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
	}

}
