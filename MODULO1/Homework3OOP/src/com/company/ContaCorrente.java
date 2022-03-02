package com.company;

public class ContaCorrente extends Conta implements Impressao {
    private double chequeEspecial;

    public double getChequeEspecial() {
        return chequeEspecial;
    }
    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    public ContaCorrente(Cliente cliente, String numeroConta, String agencia, double saldo, double chequeEspecial) {
        super(cliente, numeroConta, agencia, saldo);
        this.setChequeEspecial(chequeEspecial);
    }

    public void imprimir() {
        System.out.println(getCliente().getNome()+"\n" +
                "AG: "+getAgencia()+"\n" +
                "CC: "+getNumeroConta()+"\n" +
                "Saldo: "+getSaldo()+"\n" +
                "Saldo do Cheque Especial: "+getChequeEspecial());
    }

    public double retornarSaldoComChequeEspecial() {
        System.out.println(getSaldo()+getChequeEspecial());
        return getSaldo()+getChequeEspecial();
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > getSaldo()+getChequeEspecial()) {
            System.out.println("Você não possui fundos suficientes para sacar.");
            return false;
        }
        else if (valor <= 0) {
            System.out.println("Digite um valor válido.");
            return false;
        }
        else if (valor <= getSaldo()) {
            setSaldo(getSaldo()-valor);
            System.out.println("Você sacou "+valor+".\n" +
                    "Seu novo saldo é de "+getSaldo()+".");
            return true;
        }
        else if (valor > getSaldo() && valor < (getSaldo()+getChequeEspecial())) {
            setSaldo(getSaldo()-valor);
            setChequeEspecial(getChequeEspecial()+getSaldo());
            System.out.println("Você sacou "+valor+".\n" +
                    "Seu novo saldo é de "+getSaldo()+".\n" +
                    "Você ativou seu cheque especial, o saldo atual do mesmo é de "+getChequeEspecial());
        }
        else {
            return true;
        }
        return true;
    }
}