package com.company;

public class Endereco {
    int tipo;
    String logradouro;
    int numero;
    String complemento;
    String cep;
    String cidade;
    String estado;
    String pais;

    public Endereco(int tipo, String logradouro, int numero, String complemento, String cep, String cidade, String estado, String pais) {
        this.tipo = tipo;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    public void imprimirEndereco() {
        if (tipo == 1) {
            String res = "Residencial";
            System.out.println("("+res+") \n"+logradouro+" "+numero+" ("+complemento+") \n" +
                    "CEP: "+cep+"\n" +
                    ""+cidade+"/"+estado+" - "+pais);
        }
        if (tipo == 2) {
            String com = "Comercial";
            System.out.println("("+com+") \n"+logradouro+" "+numero+" ("+complemento+") \n" +
                    "CEP: "+cep+"\n" +
                    ""+cidade+"/"+estado+" - "+pais);
        }
    }
}
