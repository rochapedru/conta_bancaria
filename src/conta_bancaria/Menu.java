package conta_bancaria;
import java.io.IOException;
import java.util.Scanner;
import conta_bancaria.controller.ContaController;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;
public class Menu {
	static Scanner leia = new Scanner(System.in);
	static int opcao, numero, agencia, tipo, aniversario, numeroDestino;
	static String titular;
	static float saldo, limite, valor;
	static ContaController contas = new ContaController();
	public static void keyPress() {
		try {
			System.out.println("\n\n pressione a tecla Enter para  continuar");
			System.in.read();
		} catch (IOException e) {
			System.out.println("voce prescionou uma tecla invalida: ");
		}
	}
	public static void main(String[] args) {
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "Joao da Silva", 1000.00f, 100.00f);
		contas.cadastrar(cc1);
		while (true) {
			imprimirMenu();
			opcao = leia.nextInt();

			if (opcao == 13) {
				System.out.println("\nBanco do Brazil com Z - O seu Futuro começa aqui!");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1 -> printcriarConta();
			case 2 -> printlistarConta();
			case 3 -> printbuscarConta();
			case 4 -> printatualizarConta();
			case 5 -> printapagarConta();
			case 6 -> printsacar();
			case 7 -> printdepositar();
			case 8 -> printtransferir();
			case 9 ->  {
				System.out.println("Consulta por titular ");
				
				System.out.println("Digite nome titular ");
				leia.skip("\\R");
				
				titular = leia.nextLine();
				contas.procurarPorNome(titular);
				
				keyPress();
				
			}
			
			default -> System.out.println("\nOpção Inválida!\n");
			}
		}
		
	}
	public static void imprimirMenu() {
		System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_GREEN_BOLD_BRIGHT);
		System.out.println("*****************************************************");
		System.out.println("                BANCO DO BRAZIL COM Z                ");
		System.out.println("***** ************************************************");
		System.out.println("            1 - Criar Conta                          ");
		System.out.println("            2 - Listar todas as Contas               ");
		System.out.println("            3 - Buscar Conta por Numero              ");
		System.out.println("            4 - Atualizar Dados da Conta             ");
		System.out.println("            5 - Apagar Conta                         ");
		System.out.println("            6 - Sacar                                ");
		System.out.println("            7 - Depositar                            ");
		System.out.println("            8 - Transferir valores entre Contas      ");
		System.out.println("            9 - consulta por titular                                ");
		System.out.println("*****************************************************");
		System.out.println("Entre com a opção desejada:                          ");
		System.out.println("                                                    " + Cores.TEXT_RESET);
	}
	public static void printcriarConta() {
		System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND);
		System.out.println("1 - criar contas \n\n");
		System.out.println("        " + Cores.TEXT_RESET);

		System.out.println("Digite o Numero da Agência: ");
		agencia = leia.nextInt();
		System.out.println("Digite o Nome do Titular: ");
		leia.skip("\\R?");
		titular = leia.nextLine();
		do {
			System.out.println("Digite o Tipo da Conta (1-CC ou 2-CP): ");
			tipo = leia.nextInt();
		} while (tipo < 1 && tipo > 2);
		System.out.println("Digite o Saldo da Conta (R$): ");
		saldo = leia.nextFloat();
		switch (tipo) {
		case 1 -> {
			System.out.println("Digite o Limite de Crédito  (R$): ");
			limite = leia.nextFloat();
			contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
			break;
		}
		case 2 -> {
			System.out.println("Digite o dia do Aniversario da Conta: ");
			aniversario = leia.nextInt();
			contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
			break;
		}
		}
		keyPress();
	}
	public static void printlistarConta() {
		System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND);
		System.out.println("2 - Listar todas as Contas\n\n");
		System.out.println("        " + Cores.TEXT_RESET);
		contas.listarTodas();
		keyPress();
	}
	public static void printbuscarConta() {
		System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND);
		System.out.println("3 - Consultar dados da Conta - por número\n\n");
		System.out.println("        " + Cores.TEXT_RESET);
		System.out.println("dige o numero da conta: ");
		numero = leia.nextInt();
		contas.procurarPorNumero(numero);
		keyPress();
		
	}
	
	public static void printatualizarConta() {
		System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND);
		System.out.println(" 4 -Atualizar dados da Conta\n\n");
		System.out.println("        " + Cores.TEXT_RESET);
		System.out.println("Digite n da conta");
		numero = leia.nextInt();
		if (contas.buscarNaCollection(numero).isPresent()) {

		} else
			System.out.println("A conta " + numero + " nao foi encontrada");
		keyPress();
	}
	public static void printapagarConta() {
		System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND);
		System.out.println(" 5 - Apagar a Conta\n\n");
		System.out.println("        " + Cores.TEXT_RESET);
		System.out.println("Digite numero da conta para deletar");
		numero = leia.nextInt();
		contas.deletar(numero);
		keyPress();
	}
	public static void printsacar() {
		System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND);
		System.out.println("6 - Saque\n\n");
		System.out.println("        " + Cores.TEXT_RESET);
		System.out.println("Digite numero da conta para sacar");
		numero = leia.nextInt();
		System.out.println("Digite o valor do saque");
		valor = leia.nextInt();
		contas.sacar(numero, valor);
		keyPress();
	}
	public static void printdepositar() {
		System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND);
		System.out.println("7 - Depósito\n\n");
		System.out.println("        " + Cores.TEXT_RESET);
		System.out.println("Digite numero da conta para deposito");
		numero = leia.nextInt();
		System.out.println("Digite o valor do deposito");
		valor = leia.nextInt();
		contas.depositar(numero, valor);
		keyPress();
	}
	public static void printtransferir() {
		System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND);
		System.out.println("8 - Transferência entre Contas\n\n");
		System.out.println("        " + Cores.TEXT_RESET);
		System.out.println("Digite numero da conta de origem ");
		numero = leia.nextInt();
		System.out.println("Digite o numero da conta de destino");
		numeroDestino = leia.nextInt();
		System.out.println("Digite o valor da  transfeencia");
		valor = leia.nextInt();
		if (numero != numeroDestino)
			contas.transferir(numero, numeroDestino, valor);
		else
			System.out.println("Os  numeros das contas sao os mesmos");
		keyPress();
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