package conta_bancaria.model;

public class Conta {
	// souce, generate getters and seterrs,, construction antes
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	public boolean sacar(float valor) {
		if( this.getSaldo() < valor) {
			System.out.println("\n Saldo Insificiente");
			return false;
		}
		this.setSaldo(this.getSaldo() - valor);
		return true;
	}
	
	public void depositar(float valor) {
		this.setSaldo(this.getSaldo() + valor);
	}
		

	// construtor mesmo nome que classe
	// * .this é atributo, os int parametros
	public Conta(int numero, int agencia, int tipo, String titular, float saldo) {
		this.numero = numero;
		this.agencia = agencia;
		this.tipo = tipo;
		this.titular = titular;
		this.saldo = saldo;
	}

	// Definir os atributos da classe
	// clikar na classe, ir em Source, e generate construicion using fields, e
	// selecionar Omit call to default
	private int numero;
	private int agencia;
	private int tipo;
	private String titular;
	private float saldo;

	// pois nao retorna, so printa na tela
	public void visualizar() {
		String tipo = "";
		switch (this.tipo) {
		case 1 -> tipo = "Conta Corrente";
		case 2 -> tipo = "conta poupança";
		}
		System.out.println("\n\n************ Dados Da Conta ********************");
		System.out.println("Numero da conta: " + this.numero);
		System.out.println("Agencia: " + this.agencia);
		System.out.println("Tipo da conta: " + tipo);
		System.out.println("Saldo da Conta: " + this.saldo);
	}
}
