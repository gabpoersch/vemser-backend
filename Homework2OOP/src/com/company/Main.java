package com.company;

public class Main {
    public static void main(String[] args) {

        Contato cont1 = new Contato(1,"WhatsApp","99878145");
        Endereco end1 = new Endereco(1, "Rua João de Barro", 10, "Fundos", "94070-987", "Gravataí", "RS", "Brasil");
        Cliente cli1 = new Cliente("Gabriel", 1234-10, new Contato[]{cont1}, new Endereco[]{end1});
        ContaCorrente cc1 = new ContaCorrente(cli1, "1001","0001",300,200);

        Contato cont2 = new Contato(2,"Empresa","34529715");
        Endereco end2 = new Endereco(2, "Rua Pardal", 20, "Sala 205", "97020-040", "Porto Alegre", "RS", "Brasil");
        Cliente cli2 = new Cliente("Maicon", 2345-20, new Contato[]{cont2}, new Endereco[]{end2});
        ContaPoupanca cp1 = new ContaPoupanca(cli2, "2001","0001",500);


        //CONTATOS E ENDEREÇOS
//        cli1.imprimirContatos();
//        System.out.println();
//        cli1.imprimirEnderecos();

//        cli2.imprimirContatos();
//        System.out.println();
//        cli2.imprimirEnderecos();


        //IMPRIMIR
//        cc1.imprimir();
//        System.out.println();
//        cp1.imprimir();
//        System.out.println();

        //MÉTODOS DA CONTA CORRENTE
//        cc1.retornarSaldoComChequeEspecial();
//        System.out.println();
//        cc1.setChequeEspecial(50);
//        System.out.println(cc1.getChequeEspecial());
//        System.out.println();
//        cc1.sacar(345);

        //MÉTODOS DA CONTA POUPANÇA
//        cp1.creditarTaxa();

        //TRANSFERÊNCIA
//        cc1.transferir(cp1, 250);

        //MOVIMENTAÇÕES
//        cc1.sacar(200);
//        cp1.sacar(200);
//        cc1.depositar(200);
//        cp1.depositar(200);
    }
}