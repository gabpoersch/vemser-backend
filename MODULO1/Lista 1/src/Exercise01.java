import java.util.*;

public class Exercise01 {
    public static void main(String[] args) {
        String name = "";
        int age = 0;
        String city = "";
        String state = "";

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite seu nome: ");
        name = scanner.nextLine();
        System.out.println("Digite sua idade: ");
        age = scanner.nextInt();

        scanner.nextLine();

        System.out.println("Digite sua cidade: ");
        city = scanner.nextLine();
        System.out.println("Digite sua UF: ");
        state = scanner.nextLine();

        System.out.println("Olá, "+name+"! Você tem "+age+" anos e mora na cidade de "+city+"/"+state+".");
    }
}