public class ContaPoupanca extends Conta {
    private float limite;
    private LocalDate dataAniversario;
    private float taxaSelicAnual;

    public ContaPoupanca(int numero, int agencia, int tipo, String titular, float saldo, float limite, LocalDate dataAniversario, float taxaSelicAnual) {
        super(numero, agencia, tipo, titular, saldo);
        this.limite = limite;
        this.dataAniversario = dataAniversario;
        this.taxaSelicAnual = taxaSelicAnual;
    }

    // getters e setters para limite, dataAniversario e taxaSelicAnual
    // ...

    @Override
    public boolean depositar(float valor) {
        super.depositar(valor);
        this.dataAniversario = LocalDate.now();
        return true;
    }

    public void calcularRendimento() {
        long mesesDesdeAniversario = ChronoUnit.MONTHS.between(this.dataAniversario, LocalDate.now());

        if (mesesDesdeAniversario >= 1) {
            float taxaMensal;
            if (this.taxaSelicAnual > 8.5) {
                taxaMensal = this.taxaSelicAnual / 12 / 100;
            } else {
                taxaMensal = this.taxaSelicAnual * 0.7f / 12 / 100;
            }

            float rendimento = this.getSaldo() * taxaMensal;
            this.depositar(rendimento);
        }
    }
}

