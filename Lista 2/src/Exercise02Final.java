import java.lang.Math;
import java.util.*;

public class Exercise02Final {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = (int)(Math.random()*11);
        int ans = 0;

        System.out.println("Adivinhe o número que estou pensando (de 0 a 10):");
        ans = scan.nextInt();
        scan.nextLine();

        do {
            if (num>ans) {
                System.out.println("O número é maior que " + ans + ", tente novamente.");
                ans = scan.nextInt();
                scan.nextLine();
            }

            if (num<ans) {
                System.out.println("O número é menor que " + ans + ", tente novamente.");
                ans = scan.nextInt();
                scan.nextLine();
            }
        } while (ans != num);

        if (ans == num) {
            System.out.println("Parabéns, você acertou!");
        }
    }
}