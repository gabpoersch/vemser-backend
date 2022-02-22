package com.company;

public interface Movimentacao {
    boolean sacar(double valor);
    boolean depositar(double valor);
    boolean transferir(Conta cc, double valor);
}
