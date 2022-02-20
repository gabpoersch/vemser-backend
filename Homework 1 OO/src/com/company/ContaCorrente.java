package com.company;

public class ContaCorrente {
    Cliente cliente;
    String agencia;
    String numeroConta;
    double saldo;
    double chequeEspecial;

    public ContaCorrente(Cliente cliente, String agencia, String numeroConta, double saldo, double chequeEspecial) {
        this.cliente = cliente;
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.chequeEspecial = chequeEspecial;
    }

    public void imprimirContaCorrente() {
        System.out.println(cliente.nome+
                        "\nAG: "+agencia+
                        "\nCC: "+numeroConta+
                        "\nSaldo: "+saldo+
                        "\nSaldo do Cheque Especial: "+chequeEspecial);
    }

    public boolean sacar(double valor) {
        if (valor > (saldo+chequeEspecial)) {
            System.out.println("Você não possui fundos suficientes para sacar.");
            return false;
        }

        if (saldo >= valor) {
            saldo -= valor;
            System.out.println("Você sacou "+valor+".\n" +
                    "Seu novo saldo é de "+saldo+".");
        } else if (saldo+chequeEspecial >= valor) {
            double regsaldo = saldo;
            valor -= saldo;
            saldo = 0;
            chequeEspecial = chequeEspecial-valor;
            System.out.println("Você sacou "+regsaldo+" do seu saldo e "+valor+" do seu Cheque Especial.\n" +
                    "Você não possui saldo e o valor atual do seu Cheque Especial é de "+chequeEspecial+".");
        }

        return true;
    }


    public boolean depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Deposite um valor válido.");
            return false;
        }

        saldo += valor;
        System.out.println("Você depositou R$ "+valor+".\n" +
                "Seu novo saldo é de "+saldo+".");
        return true;
    }

    public double retornarSaldoComChequeEspecial() {
        System.out.println(saldo+chequeEspecial);
        return saldo+chequeEspecial;
    }

    public boolean transferir(ContaCorrente cc, double valor) {

        if (valor > (this.saldo + this.chequeEspecial)) {
            System.out.println("Você não possui fundos suficientes.");
            return false;
        }

        if (this.saldo >= valor) {
            cc.saldo += valor;
            this.saldo -= valor;
            System.out.println("Você transferiu "+valor+" para "+cc.cliente.nome+".\n" +
                    "Seu saldo atual é de: "+saldo);
        }

        else if (this.saldo + this.chequeEspecial >= valor) {
            cc.saldo += valor;
            double regsaldo = saldo;
            valor -= this.saldo;
            this.saldo = 0;
            this.chequeEspecial = this.chequeEspecial-valor;
            System.out.println("Valor enviado para "+cc.cliente.nome+".\n" +
                    "Você transferiu "+regsaldo+" do seu saldo e "+valor+" do seu Cheque Especial.\n" +
                    "Você não possui saldo e o valor atual do seu Cheque Especial é de "+chequeEspecial+".");
        }
        return true;
    }
}
