import java.util.*;

public class exercise05 {
    public static void main(String[] args) {
        double hourly = 0;
        double hours = 0;
        double ex50 = 0;
        double ex100 = 0;

        Scanner scan = new Scanner(System.in);

        System.out.println("Informe o salário por hora: ");
        hourly = scan.nextDouble();
        System.out.println("Informe o número de horas sem adicional trabalhadas: ");
        hours = scan.nextDouble();
        System.out.println("Informe número de horas extras com adicional de 50%: ");
        ex50 = scan.nextDouble();
        System.out.println("Informe número de horas extras com adicional de 100%: ");
        ex100 = scan.nextDouble();

        double wage = (hourly * hours) + (hourly * ex50 * 1.5) + (hourly * ex100 * 2);

        System.out.println("O salário final do colaborador é de: "+wage);
    }
}
