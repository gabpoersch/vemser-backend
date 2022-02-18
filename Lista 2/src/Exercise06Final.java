import java.util.Arrays;
import java.util.Scanner;

public class Exercise06Final {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String search = "";
        String arr[] = {"2", "3", "5", "7", "11", "13", "17", "19", "23", "29"};

        System.out.println("Digite o número a ser buscado:");
        search = scan.nextLine();

        if (Arrays.stream(arr).anyMatch(search::equals)) {
            System.out.println("O valor foi encontrado.");
        } else {
            System.out.println("O valor não foi encontrado.");
        }
    }
}