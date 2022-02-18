import java.util.Scanner;


/*LEIA:
    O enunciado ficou MUITO confuso e contraintuitivo, primeiro pede pra fazer uma matriz 5x4 declarando os valores e
    depois pede pra calcular a nota final, sendo que quando chega nisso JÁ SE ELABOROU uma matriz contendo as informações.
 */

public class Exercise08 {
    public static void main(String[] args) {
        int arr [][] = {{1, 7, 5, 6},{2, 8, 4, 6},{3, 8, 6, 7},{4, 9, 7, 8},{5, 4, 2, 3}};

        Scanner scan = new Scanner(System.in);

        int matr = 0;

        System.out.println("Digite o número de matrícula: ");
        matr = scan.nextInt();
        scan.nextLine();

        for (int i=0; i<6; i++) {
            if (i == matr) {
                System.out.printf("Matrícula número: %d.", arr[(i-1)][0]);
                System.out.printf("\nMédia das provas: %d.", arr[(i-1)][1]);
                System.out.printf("\nMédia dos trabalhos: %d.", arr[(i-1)][2]);
                System.out.printf("\nNota final: %d.", arr[(i-1)][3]);
            }
        }





    }
}
