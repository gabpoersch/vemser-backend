package com.company;

public class ContaPoupanca extends Conta implements Impressao {
    private static final double JUROS_MENSAL;
    static {
        JUROS_MENSAL = 1.01;
    }

    public ContaPoupanca(Cliente cliente, String numeroConta, String agencia, double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

    public void imprimir() {
        System.out.println(getCliente().getNome()+"\n" +
                "AG: "+getAgencia()+"\n" +
                "CC: "+getNumeroConta()+"\n" +
                "Saldo: "+getSaldo());
    }

    public void creditarTaxa() {
        System.out.println("Saldo anterior: "+getSaldo());
        setSaldo(getSaldo() * JUROS_MENSAL);
        System.out.println("Saldo atual (somado aos rendimentos): "+getSaldo());
    }
}
