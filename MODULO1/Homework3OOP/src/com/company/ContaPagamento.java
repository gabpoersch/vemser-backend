package com.company;

public class ContaPagamento extends Conta implements Impressao {
    private static final double TAXA_SAQUE;
    static {
        TAXA_SAQUE = 4.25;
    }

    public ContaPagamento(Cliente cliente, String numeroConta, String agencia, double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

    public void imprimir() {
        System.out.println(getCliente().getNome()+"\n" +
                "AG: "+getAgencia()+"\n" +
                "CC: "+getNumeroConta()+"\n" +
                "Saldo: "+getSaldo());
    }

    @Override
    public boolean sacar(double valor) {
        double saldoESaque = getSaldo()-TAXA_SAQUE;
        if (valor > saldoESaque) {
            System.out.println("Você não possui fundos suficientes para sacar.");
            return false;
        }
        else if (valor <= 0) {
            System.out.println("Digite um valor válido");
            return false;
        }

        setSaldo(getSaldo()-valor-TAXA_SAQUE);
        System.out.println("Você sacou "+valor+" (+ TAXA DE 4.25).\n" +
                "Seu novo saldo é de "+getSaldo()+".");
        return true;
    }
}
