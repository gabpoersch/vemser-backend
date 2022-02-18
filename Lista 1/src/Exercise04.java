import java.util.*;

public class Exercise04 {
    public static void main(String[] args) {
        String state = "";
        String city = "";

        Scanner scan = new Scanner(System.in);

        System.out.println("Selecione o estado: \n" +
                            "1 - PR \n" +
                            "2 - SC \n" +
                            "3 - RS");
        state = scan.nextLine();

        switch (state) {

            //PR
            case "1":
                System.out.println("Selecione a cidade: \n" +
                        "1 - Curitiba\n" +
                        "2 - Pato Branco");
                city = scan.nextLine();

                switch (city) {
                    case "1":
                        System.out.println("População: 1 963 726 hab.\n" +
                                "IDH: 0,823\n" +
                                "PIB: 87 151 950 mil\n" +
                                "Data de fundação: 29 de março de 1693");
                        break;

                    case "2":
                        System.out.println("População: 82 881 hab.\n" +
                                "IDH: 0,782\n" +
                                "PIB: 1 631 874 mil\n" +
                                "Data de fundação: 14 de novembro de 1951");
                        break;
                }
            break;

            //SC
            case "2":
            System.out.println("Selecione a cidade: \n" +
                        "1 - Florianópolis \n" +
                        "2 - Bombinhas");
                city = scan.nextLine();


                switch (city) {
                    case "1":
                        System.out.println("População: 516 524 hab.\n" +
                                "IDH: 0,847\n" +
                                "PIB: 18 636 407 mil\n" +
                                "Data de fundação: 23 de março de 1673");
                        break;
                    case "2":
                        System.out.println("População: 19 769 hab.\n" +
                                "IDH: 0,781\n" +
                                "PIB: 159 719 mil\n" +
                                "Data de fundação: 30 de março de 1992");
                        break;
                }

            break;

            //RS
            case "3":
            System.out.println("Selecione a cidade: \n" +
                        "1 - Porto Alegre \n" +
                        "2 - Torres");
                city = scan.nextLine();


                switch (city) {
                    case "1":
                        System.out.println("População: 1 492 530 hab.\n" +
                                "IDH: 0,805\n" +
                                "PIB: 68 117 224 mil\n" +
                                "Data de fundação: 26 de março de 1772");
                        break;
                    case "2":
                        System.out.println("População: 39 064 hab.\n" +
                                "IDH: 0,821\n" +
                                "PIB: 378 380 mil\n" +
                                "Data de fundação: 21 de maio de 1878");
                        break;
                }
            break;
            default:
                System.out.println("Opção inválida.");
        }
    }
}