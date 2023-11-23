package conta_bancaria.repository;
import conta_bancaria.model.Conta;

public interface ContaRepository{
	
	//crud
	
	void procurarPorNumero(int numero);
	void listarTodas();
	void cadastrar(Conta conta);
	void atualizar(Conta conta);
	void deletar(int numero);
	
	 //metodos bancario
	
	void sacar(int numero, float valor);
	void depositar(int numero, float valor);
	void transferir(int numeroOrigem, int numeroDestino, float valor);
}
