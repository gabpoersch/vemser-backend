import java.util.Arrays;
import java.util.Scanner;

public class Exercise05Final {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i = 0;
        String arr [] = new String [20];

        while (i < 20) {
            System.out.println("Digite o valor nº "+(i+1)+":");
            arr[(19-i)] = scan.nextLine();
            i++;
        }

        System.out.println(Arrays.toString(arr));

    }
}
