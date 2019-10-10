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
		menuAdministrador();

	}
	
	// Menu Atendente
	public static void menuAtendente() {
		
	}
	
	// Menu Adminsitrador
	public static void menuAdministrador() {
		int opcao = 1, opcao2 = 1;
		do {
			System.out.printf("\n<---> ADMINISTRADOR <--->\n");
			System.out.printf("1. Inserir Produto\n");
			System.out.printf("2. Listar Produtos\n");
			System.out.printf("3. Criar Pedido\n");
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
				listarProdutos();
				
				break;

			case 3:
				while(opcao2 != 0) {
					System.out.printf("\n<---> Menu de Criação de Pedidos <--->\n");
					System.out.printf("1. Adicionar Itens ao Pedido.\n");
					System.out.printf("2. Finalizar Pedido.\n");
					System.out.printf("0. Cancelar e Voltar.\n");
					System.out.printf(": ");
					opcao2 = inN.nextInt();
					System.out.printf("\n");
					
					switch (opcao2) {
					case 0:
						break;
					case 1:
						int id, qtd;
						
						listarProdutos();
						
						System.out.println(lerItem());
						
						
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
	
	private static Item lerItem() { 
		
		System.out.printf("\nID do Produto: ");
		int id = inN.nextInt();
		System.out.printf("\nQuantidade: ");
		int qtd = inN.nextInt();
		
		Item item = sis.criarItem(id, qtd);
		
		if (item == null) {
			System.out.printf("Dados incorretos!\n");
			item = lerItem();
		} else {
			System.out.printf("Inserindo dados...\n");
		}
		
		return item;
	}
	
	private static void listarProdutos() {
		Produto[] produtos = sis.listarProdutos();
		
		System.out.printf("\n<--> Lista de Produtos: <-->\n");
		for (int i = 0; i < produtos.length; i++) {
			System.out.printf("ID: %d\nNome: %s\nDescrição: %s\nPreço: R$%.2f\nQuantidade em estoque: %d\n\n", produtos[i].getId(), produtos[i].getNome(), produtos[i].getDescricao(), produtos[i].getPreco(), produtos[i].getQtdEstoque());
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
		sis.excluirProduto(3);
		//sis.excluirProduto(3);
		//sis.excluirProduto(5);
	}

}
