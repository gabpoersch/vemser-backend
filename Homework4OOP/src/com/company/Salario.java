package com.dbc.aula6;

public class Salario {
    private final int id;
    private final double salario;

    public Salario(int id, double salario) {
        this.id = id;
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", salario=" + salario +
                '}';
    }
}
