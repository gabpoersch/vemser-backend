package com.company;

public class Main {
    public static void main(String[] args) {

        Contato cont1 = new Contato("Celular", "999001456", 1);
        Endereco end1 = new Endereco(1, "Rua João de Barro", 10, "Fundos", "94070-987", "Gravataí", "RS", "Brasil");
        Cliente cli1 = new Cliente("Gabriel", 1234-10, new Contato[]{cont1}, new Endereco[]{end1});
        ContaCorrente cc1 = new ContaCorrente(cli1, "0001", "1001", 0, 500);

        Contato cont2 = new Contato("Empresa", "33002178", 2);
        Endereco end2 = new Endereco(2, "Rua Pardal", 20, "Sala 205", "97020-040", "Porto Alegre", "RS", "Brasil");
        Cliente cli2 = new Cliente("Maicon", 2345-20, new Contato[]{cont2}, new Endereco[]{end2});
        ContaCorrente cc2 = new ContaCorrente(cli2, "0001", "1002", 500, 300);


        //IMPRIMIR CONTA CORRENTE 1
//        cc1.imprimirContaCorrente();
//        System.out.println();
//        cli1.imprimirCliente();


        //IMPRIMIR CONTA CORRENTE 2
//        cc2.imprimirContaCorrente();
//        System.out.println();
//        cli2.imprimirCliente();

        //SACAR VALOR DA CC1 (troque o valor pra testar)
//        cc1.imprimirContaCorrente();
//        System.out.println();
//        cc1.sacar(470);

        //SACAR VALOR DA CC2 (troque o valor pra testar)
//        cc2.imprimirContaCorrente();
//        System.out.println();
//        cc2.sacar(470);

        //DEPOSITAR VALOR CC1 (troque o valor pra testar)
//        cc1.imprimirContaCorrente();
//        System.out.println();
//        cc1.depositar(200);

        //DEPOSITAR VALOR CC2 (troque o valor pra testar)
//        cc2.imprimirContaCorrente();
//        System.out.println();
//        cc2.depositar(200);

        //TRANSFERÊNCIA
//        cc2.transferir(cc1, 200);
//        System.out.println();

        //SE QUISER USAR SÓ PRA CONFERIR A TRANSFERÊNCIA
//        cc1.imprimirContaCorrente();

        //SE FOR NECESSÁRIO INFORMAR AO CLIENTE
//        cc1.retornarSaldoComChequeEspecial();
//        cc2.retornarSaldoComChequeEspecial();









    }
}