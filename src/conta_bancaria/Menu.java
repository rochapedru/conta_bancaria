package conta_bancaria;

import java.util.Scanner;

public class Menu {
	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);

		int opcao;

		imprimirMenu();

		while (true) {

			opcao = leia.nextInt();

			if (opcao == 9) {
				System.out.println("\nBanco do Brazil com Z - O seu Futuro começa aqui!");
				sobre();
                leia.close();
				System.exit(0);
			}

			switch (opcao) {
				case 1 -> criarConta();
				case 2 -> listarContas();
				case 3 -> buscarConta();
				case 4 -> atualizarConta();
				case 5 -> apagarConta();
				case 6 -> sacar();
				case 7 -> depositar();
				case 8 -> transferir();
				default -> System.out.println("\nOpção Inválida!\n");
			};
		}
	}

	public static void imprimirMenu() {
		System.out.println("*****************************************************");
		System.out.println("                BANCO DO BRAZIL COM Z                ");
		System.out.println("*****************************************************");
		System.out.println("            1 - Criar Conta                          ");
		System.out.println("            2 - Listar todas as Contas               ");
		System.out.println("            3 - Buscar Conta por Numero              ");
		System.out.println("            4 - Atualizar Dados da Conta             ");
		System.out.println("            5 - Apagar Conta                         ");
		System.out.println("            6 - Sacar                                ");
		System.out.println("            7 - Depositar                            ");
		System.out.println("            8 - Transferir valores entre Contas      ");
		System.out.println("            9 - Sair                                 ");
		System.out.println("*****************************************************");
		System.out.println("Entre com a opção desejada:                          ");
		System.out.println("                                                     ");
	}

	public static void criarConta() {
		imprimirMenu();
		System.out.println("Criar Conta\n\n");
	
	}

	public static void listarContas() {
		imprimirMenu();
		System.out.println("Listar todas as Contas\n\n");

	}

	public static void buscarConta() {
		imprimirMenu();
		System.out.println("Consultar dados da Conta - por número\n\n");
	
	}

	public static void atualizarConta() {
		imprimirMenu();
		System.out.println("Atualizar dados da Conta\n\n");
		
	}

	public static void apagarConta() {
		imprimirMenu();
		System.out.println("Apagar a Conta\n\n");
		
	}

	public static void sacar() {
		imprimirMenu();
		System.out.println("Saque\n\n");
	
	}

	public static void depositar() {
		imprimirMenu();
		System.out.println("Depósito\n\n");
		
	}

	public static void transferir() {
		imprimirMenu();
		System.out.println("Transferência entre Contas\n\n");
		
	}
    
	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por Joao Pedro O. Rocha: ");
		System.out.println("PedroRocha2info@gmail.com");
		System.out.println("https://github.com/rochapedru/conta_bancaria");
		System.out.println("*********************************************************");
	}
}

