package conta_bancaria;

import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.util.Cores;

public class Menu {
	static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {
		
		Scanner leia = new Scanner(System.in);

		int opcao, numero, agencia, tipo, aniversario;
		String titular;
		float saldo, limite;
		
		ContaController contas = new ContaController();
		
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "Joao da Silva", 1000.00f, 100.00f);
		contas.cadastrar(cc1);
		
		
		

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
			
			case 2 -> printlistarContas();
			case 3 -> printbuscarConta();
			case 4 -> printatualizarConta();
			case 5 -> printapagarConta();
			case 6 -> printsacar();
			case 7 -> printdepositar();
			case 8 -> printtransferir();
			default -> System.out.println("\nOpção Inválida!\n");
			}
			;
		}
	}

	public static void imprimirMenu() {
		System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_GREEN_BOLD_BRIGHT);
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
		System.out.println("                                                    " + Cores.TEXT_RESET);
	}



	public static void printlistarContas() {
		imprimirMenu();
		System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND);
		System.out.println("Listar todas as Contas\n\n");
		System.out.println("        " + Cores.TEXT_RESET);
		
	}

	public static void printbuscarConta() {
		imprimirMenu();
		System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND);
		System.out.println("Consultar dados da Conta - por número\n\n");
		System.out.println("        " + Cores.TEXT_RESET);
	}

	public static void printatualizarConta() {
		imprimirMenu();
		System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND);
		System.out.println("Atualizar dados da Conta\n\n");
		System.out.println("        " + Cores.TEXT_RESET);
	}

	public static void printapagarConta() {
		imprimirMenu();
		System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND);
		System.out.println("Apagar a Conta\n\n");
		System.out.println("        " + Cores.TEXT_RESET);
	}

	public static void printsacar() {
		imprimirMenu();
		System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND);
		System.out.println("Saque\n\n");
		System.out.println("        " + Cores.TEXT_RESET);
	}

	public static void printdepositar() {
		imprimirMenu();
		System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND);
		System.out.println("Depósito\n\n");
		System.out.println("        " + Cores.TEXT_RESET);
	}

	public static void printtransferir() {
		imprimirMenu();
		System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND);
		System.out.println("Transferência entre Contas\n\n");
		System.out.println("        " + Cores.TEXT_RESET);
	}

	public static void sobre() {
		System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND);
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por Joao Pedro O. Rocha: ");
		System.out.println("PedroRocha2info@gmail.com");
		System.out.println("https://github.com/rochapedru/conta_bancaria");
		System.out.println("*********************************************************");
		System.out.println("        " + Cores.TEXT_RESET);
	}
	/**
	 * public static void sobre() { System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT
	 * + Cores.ANSI_BLACK_BACKGROUND);
	 * System.out.println("\n*********************************************************");
	 * System.out.println("Projeto Desenvolvido por Joao Pedro O. Rocha: ");
	 * System.out.println("PedroRocha2info@gmail.com");
	 * System.out.println("https://github.com/rochapedru/conta_bancaria");
	 * System.out.println("*********************************************************");
	 * System.out.println(" " + Cores.TEXT_RESET); }
	 */

}