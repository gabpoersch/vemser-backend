import java.util.*;

public class exercise02 {
    public static void main(String[] args) {
        String name = "";
        double exam1 = 0;
        double exam2 = 0;
        double exam3 = 0;
        double exam4 = 0;

        Scanner scan = new Scanner(System.in);

        System.out.println("Digite o nome do aluno: ");
        name = scan.nextLine();

        //Loop da primeira prova
        System.out.println("Digite a nota da primeira prova: ");
        exam1 = scan.nextDouble();
        while (exam1 < 0 || exam1 > 10) {
            System.out.println("Nota inválida. Digite uma nota de 0 a 10: ");
            exam1 = scan.nextDouble();
        }

        //Loop da segunda prova
        System.out.println("Digite a nota da segunda prova: ");
        exam2 = scan.nextDouble();
        while (exam2 < 0 || exam2 > 10) {
            System.out.println("Nota inválida. Digite uma nota de 0 a 10: ");
            exam2 = scan.nextDouble();
        }

        //Loop da terceira prova
        System.out.println("Digite a nota da terceira prova: ");
        exam3 = scan.nextDouble();
        while (exam3 < 0 || exam3 > 10) {
            System.out.println("Nota inválida. Digite uma nota de 0 a 10: ");
            exam3 = scan.nextDouble();
        }

        //Loop da quarta prova
        System.out.println("Digite a nota da quarta prova: ");
        exam4 = scan.nextDouble();
        while (exam4 < 0 || exam4 > 10) {
            System.out.println("Nota inválida. Digite uma nota de 0 a 10: ");
            exam4 = scan.nextDouble();
        }

        double avg = (exam1 + exam2 + exam3 + exam4) / 4;

        if (avg >= 0 && avg <= 5) {
            System.out.println("Média: "+avg+" - O aluno foi reprovado.");
        } else if (avg > 5 && avg < 7) {
            System.out.println("Média: "+avg+" - O aluno está em exame.");
        } else {
            System.out.println("Média: "+avg+" - O aluno foi aprovado!");
        }
    }
}
