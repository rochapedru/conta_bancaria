package conta_bancaria.controller;
import java.util.ArrayList;

import conta_bancaria.model.Conta;
import conta_bancaria.repository.ContaRepository;

public class ContaController implements ContaRepository{
	
	//criar a colletion
	
	private ArrayList<Conta> listaContas = new ArrayList<Conta>();

	
	//variavel para recer o numero da conta
	int numero = 0;
	
	
	
	public void procurarPorNumero(int numero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listarTodas() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("A conta numero: " + conta.getNumero() + " foi criada com sucessos");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Conta conta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(int numero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sacar(int numero, float valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void depositar(int numero, float valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		// TODO Auto-generated method stub
		
	}
	
	// metodos auxiliares
	
	public int gerarNumero() {
		return ++ numero;
	}
	

}
