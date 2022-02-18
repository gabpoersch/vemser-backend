import java.util.*;
import java.lang.Math;

public class Exercise04Final {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;

        System.out.println("Digite o primeiro número:");
        num1 = scan.nextInt();
        scan.nextLine();

        System.out.println("Digite o segundo número:");
        num2 = scan.nextInt();
        scan.nextLine();

        System.out.println("Digite o terceiro número:");
        num3 = scan.nextInt();
        scan.nextLine();

        int arr [] = {num1, num2, num3};
        double smallest = Math.min(Math.min(num1, num2),num3);

        for (int i=0;i<3;i++) {
            if (arr[i] == smallest)
                System.out.println("O número está na posição ["+i+"]");
        }
    }
}