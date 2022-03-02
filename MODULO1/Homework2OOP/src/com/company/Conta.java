package com.company;

public abstract class Conta implements Movimentacao {
    private Cliente cliente;
    private String agencia;
    private String numeroConta;
    private double saldo;

    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getAgencia() {
        return agencia;
    }
    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNumeroConta() {
        return numeroConta;
    }
    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Conta(Cliente cliente, String agencia, String numeroConta, double saldo) {
        this.setCliente(cliente);
        this.setAgencia(agencia);
        this.setNumeroConta(numeroConta);
        this.setSaldo(saldo);
    }

    public boolean sacar(double valor) {
        if (valor > getSaldo()) {
            System.out.println("Você não possui fundos suficientes para sacar.");
            return false;
        }
        else if (valor <= 0) {
            System.out.println("Digite um valor válido");
            return false;
        }

        setSaldo(getSaldo()-valor);
        System.out.println("Você sacou "+valor+".\n" +
                "Seu novo saldo é de "+getSaldo()+".");
        return true;
        }

    public boolean depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Deposite um valor válido.");
            return false;
        }
        setSaldo(getSaldo()+valor);
        System.out.println("Você depositou "+valor+".\n" +
                "Seu novo saldo é de "+getSaldo()+".");
        return true;
    }

    public boolean transferir(Conta cc, double valor) {
        if (valor > getSaldo()) {
            System.out.println("Você não possui fundos suficientes.");
            return false;
        }
        else if (valor <=0) {
            System.out.println("Deposite um valor válido.");
            return false;
        }

        this.saldo -= valor;
        cc.saldo -= valor;
            System.out.println("Você transferiu "+valor+" para "+cc.getCliente().getNome()+".\n" +
                    "Seu saldo atual é de: "+this.getSaldo());

        return true;
    }
}
