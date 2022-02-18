import java.util.Scanner;

public class Exercise03Final {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String[][] arr = new String[99][5];

        String input = "";
        int qty = 0;

        double height = 0;
        double tallest = 0;
        double totalHeight = 0;

        int age = 0;
        int oldest = 0;
        String oldname = "";

        double weight = 0;
        double heaviest = 0;
        String heavyname = "";

        do {
            System.out.println("Digite o nome do jogador ou digite \"sair\" para encerrar o programa:");
            input = scan.nextLine();
            if (!input.equalsIgnoreCase("sair")) {
                String name = input;
                System.out.println("Digite a altura:");
                height = scan.nextDouble();
                if (height>tallest){
                    tallest = height;
                    totalHeight += height;
                }
                scan.nextLine();
                System.out.println("Digite a idade:");
                age = scan.nextInt();
                if (age>oldest){
                    oldest = age;
                    oldname = name;
                }
                scan.nextLine();
                System.out.println("Digite o peso:");
                weight = scan.nextDouble();
                if (weight>heaviest){
                    heaviest = weight;
                    heavyname = name;
                }
                scan.nextLine();
                qty++;
            }
        } while (!input.equalsIgnoreCase("sair"));

        double avg = totalHeight / qty;

        System.out.println("Jogadores cadastrados: "+qty+"\n" +
                "Maior altura: "+tallest+"\n" +
                "Jogador mais velho: "+oldname+"\n" +
                "Jogador mais pesado: "+heavyname+"\n" +
                "Média de altura: "+avg);
    }
}