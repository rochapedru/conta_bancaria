package conta_bancaria.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import conta_bancaria.model.Conta;
import conta_bancaria.repository.ContaRepository;

public class ContaController implements ContaRepository {

	// criar a colletion

	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	int numero = 0;
	public void procurarPorNumero(int numero) {
		Optional<Conta> conta = buscarNaCollection(numero);
		if (conta.isPresent())
			conta.get().visualizar();
		else
			System.out.println("A conta numero: " + numero + " nao foi encontrada");
	}
	public void procurarPorNome(String titular) {
		List<Conta> listaNomes = listaContas.stream()
				.filter(c -> c.getTitular().contains(titular))
				.collect(Collectors.toList());
		for(var conta : listaNomes)
			conta.visualizar();
				
	}
	
	@Override
	public void listarTodas() {
		for (var conta : listaContas) {
			conta.visualizar();
		}        
    }

	

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("A conta numero: " + conta.getNumero() + " foi criada com sucessos");
		// TODO Auto-generated method stub

	}

	@Override
	public void atualizar(Conta conta) {
		Optional<Conta> buscaConta = buscarNaCollection(conta.getNumero());

		if (buscaConta.isPresent()) {
			listaContas.set(listaContas.indexOf(buscaConta.get()), conta);
			System.out.println("A conta numero: " + conta.getNumero() + " Foi excluido com sucesso");
		} else
			System.out.println("a CONTA NAO foi encontrada" + conta.getNumero());

	}

	@Override
	public void deletar(int numero) {
		// TODO Auto-generated method stub
		Optional<Conta> conta = buscarNaCollection(numero);

		if (conta.isPresent()) {
			if (listaContas.remove(conta.get()) == true)
				System.out.println("A conta numero: " + numero + " Foi excluido com sucesso");
		} else
			System.out.println("a CONTA NAO foi encontrada");
	}

	@Override
	public void sacar(int numero, float valor) {

		Optional<Conta> conta = buscarNaCollection(numero);

		if (conta.isPresent()) {
			if (conta.get().sacar(valor) == true)
				System.out.println("A conta numero: " + numero + " Foi excluido com sucesso");
		} else
			System.out.println("a CONTA NAO foi encontrada");
	}

	@Override
	public void depositar(int numero, float valor) {
		Optional<Conta> conta = buscarNaCollection(numero);

		if (conta.isPresent()) {
			conta.get().depositar(valor);
			System.out.println("O deposito na conta n: " + numero + " saque efetuado");
		} else
			System.out.println("deposito nao edetuado " + numero);
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		Optional<Conta> contaOrigem = buscarNaCollection(numero);
		Optional<Conta> contaDestino = buscarNaCollection(numero);

		if (contaOrigem.isPresent() && contaDestino.isPresent()) {
			if (contaOrigem.get().sacar(valor) == true) {
				contaDestino.get().depositar(valor);
				System.out.println("Transferencia com sucesso " + numeroOrigem);
			}
		} else
			System.out.println("a CONTA NAO foi encontrada");
	}

	// metodos auxiliares

	public int gerarNumero() {
		return ++numero;
	}

	public Optional<Conta> buscarNaCollection(int numero) {
		for (var conta : listaContas) {
			if (conta.getNumero() == numero)
				return Optional.of(conta);
		}
		return Optional.empty();
	}

}