import java.util.*;

public class exercise06 {
    public static void main(String[] args) {
        String word = "";

        Scanner scan = new Scanner(System.in);

        System.out.println("Informe a palavra a ser traduzida: ");
        word = scan.nextLine();
        word = word.toLowerCase();

        //PT-BR => EN-US
        switch (word) {
            case "cachorro":
                System.out.println("Dog");
                break;
            case "tempo":
                System.out.println("Time");
                break;
            case "amor":
                System.out.println("Love");
                break;
            case "cidade":
                System.out.println("City");
                break;
            case "feliz":
                System.out.println("Happy");
                break;

        //EN-US => PT-BR
            case "dog":
                System.out.println("Cachorro");
                break;
            case "time":
                System.out.println("Tempo");
                break;
            case "love":
                System.out.println("Amor");
                break;
            case "city":
                System.out.println("Cidade");
                break;
            case "happy":
                System.out.println("Feliz");
                break;
            default:
                System.out.println("Essa palavra não é válida.");
        }

    }
}
