import java.util.*;

/*LEIA ANTES:
Eu incrementei bastante pra ir me experimentando já que eu tenho pouquíssima prática com Java (eu estudava Python antes)
mas pra tu ler e corrigir mais facilmente eu vou colocar comentários a cada parte pra facilitar :D
 */

public class Exercise01Final {
    public static void main(String[] args) {
        //Declarei o preço dos produtos aqui já pensando na facilidade de alterar futuramente
        float prod1 = 2.00f;
        float prod2 = 1.50f;
        float prod3 = 14.90f;
        float prod4 = 20.10f;

        Scanner scan = new Scanner(System.in);

        //Printzinho básico dos produtos que minha loja oferece
        int prod = 0;

        System.out.println("Digite o número do produto que você quer comprar: \n" +
                "1 - Lápis Faber Castell \n" +
                "2 - Caneta BIC \n" +
                "3 - Caderno Tilibra 96 folhas\n" +
                "4 - Pacote Folha A4\n\n" +
                "(Estamos com desconto de até 50% somente hoje!)");
        prod = scan.nextInt();
        scan.nextLine();

        //Se o cliente selecionar um produto inexistente, acusar e pedir pra selecionar um produto válido:
        while (prod < 1 || prod > 4) {
            System.out.println("Selecione um produto válido:\n" +
                    "1 - Lápis Faber Castell \n" +
                    "2 - Caneta BIC \n" +
                    "3 - Caderno Tilibra 96 folhas\n" +
                    "4 - Pacote Folha A4");
            prod = scan.nextInt();
            scan.nextLine();
        }

        //De acordo com o produto, informar o cliente do preço pra ele saber quantas unidades vai poder comprar
        switch (prod) {
            case 1:
                System.out.printf("Valor do produto: R$ %.2f.", prod1);
                break;
            case 2:
                System.out.printf("Valor do produto: R$ %.2f.", prod2);
                break;
            case 3:
                System.out.printf("Valor do produto: R$ %.2f.", prod3);
                break;
            case 4:
                System.out.printf("Valor do produto: R$ %.2f.", prod4);
                break;
        }


        //Declarei a variável quantidade (qty) pro cliente selecionar quantos ele vai levar, mas PRECISA ser um valor
        //entre 1 e 10
        int qty = 0;

        System.out.println("\nDeseja levar quantos?");
        qty = scan.nextInt();
        scan.nextLine();

        if (qty > 10 || qty < 1) {
            System.out.println("Você precisa selecionar uma quantidade entre 1 e 10 unidades:");
            qty = scan.nextInt();
            scan.nextLine();
        }


        //Aqui declarei a variável discount (eu uso códigos em inglês pq meu foco futuramente é o mercado internacional
        // e tbm pq aprendi quase tudo que sei vendo vídeo da gringa e acostumei) pra facilitar e pra não dar conflito,
        //declarei as variáveis dentro dos cases dentro de escopos isolados p n dar conflito
        double disc = 1 - (qty * 0.05);

        switch (prod) {
            case 1: {
                double total = prod1 * qty;
                double finalPrice = prod1 * qty * disc;
                System.out.printf("Valor dos produtos: R$ %.2f.", total);
                System.out.printf("\nValor a pagar (após descontos): R$ %.2f.", finalPrice);
                break;}
            case 2: {
                double total = prod2 * qty;
                double finalPrice = prod2 * qty * disc;
                System.out.printf("Valor dos produtos: R$ %.2f.", total);
                System.out.printf("\nValor a pagar (após descontos): R$ %.2f.", finalPrice);
                break;}
            case 3: {
                double total = prod3 * qty;
                double finalPrice = prod3 * qty * disc;
                System.out.printf("Valor dos produtos: R$ %.2f.", total);
                System.out.printf("\nValor a pagar (após descontos): R$ %.2f.", finalPrice);
                break;}
            case 4: {
                double total = prod4 * qty;
                double finalPrice = prod4 * qty * disc;
                System.out.printf("Valor dos produtos: R$ %.2f.", total);
                System.out.printf("\nValor a pagar (após descontos): R$ %.2f.", finalPrice);
                break;}
        }
    }
}