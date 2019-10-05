package br.com.trab1pc2.testes;
import br.com.trab1pc2.sistema.*;
import br.com.trab1pc2.produto.*;
import java.util.Scanner;

public class Main {
	private static Scanner inT = new Scanner(System.in);
	private static Scanner inN = new Scanner(System.in);
	private static Sistema sis = Sistema.getInstance();

	public static void main(String[] args) {

		menuAdministrador();

	}
	
	// Menu Atendente
	public static void menuAtendente() {
		
	}
	
	// Menu Adminsitrador
	public static void menuAdministrador() {
		int opcao = 1, opcao2 = 1;
		do {
			System.out.printf("\n<---> MERCADIN IGUAÇU <--->\n");
			System.out.printf("1. Inserir Produto\n");
			System.out.printf("2. Listar Produtos\n");
			System.out.printf("3. ...\n");
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
				Produto[] produtos = sis.listarProdutos();
				
				System.out.printf("\n<--> Produtos: <-->\n");
				for (int i = 0; i < produtos.length; i++) {
					System.out.printf("ID: %d\nNome: %s\nDescrição: %s\nPreço: R$%.2f\nQuantidade em estoque: %d\n\n", produtos[i].getId(), produtos[i].getNome(), produtos[i].getDescricao(), produtos[i].getPreco(), produtos[i].getQtdEstoque());
				}
				System.out.printf("\n<--> -------------- <-->\n");
				
				break;

			case 3:

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

}
