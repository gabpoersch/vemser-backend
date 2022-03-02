import java.util.*;

public class Exercise03 {
    public static void main(String[] args) {
        double cost = 0;
        double paid = 0;

        Scanner scan = new Scanner(System.in);

        System.out.println("Valor total do consumo: ");
        cost = scan.nextDouble();

        System.out.println("Valor pago: ");
        paid = scan.nextDouble();

        double exch = (paid - cost);

        if (exch == 0) {
            System.out.println("Tudo certo.");
        } else if (exch > 0) {
            System.out.printf("O troco a ser devolvido é de %.2f.", exch);
        } else {
            System.out.println("O cliente não pagou o valor total da comanda.");
        }



    }
}
