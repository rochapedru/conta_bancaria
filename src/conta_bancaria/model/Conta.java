package conta_bancaria.model;

public class Conta {
	public Conta(int numero, int agencia, int tipo, String titular, float saldo) {
		this.numero = numero;
		this.agencia = agencia;
		this.tipo = tipo;
		this.titular = titular;
		this.saldo = saldo;
	}
	// Definir os atributos da classe
	// clikar na classe, ir em Source, e generate construicion using fields, e selecionar Omit call to default
	private int numero;
	private int agencia;
	private int tipo;
	private String titular;
	private float saldo;
}
