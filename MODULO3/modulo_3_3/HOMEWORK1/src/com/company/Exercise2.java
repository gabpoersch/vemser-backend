package com.company;

import org.w3c.dom.ls.LSOutput;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) throws ParseException {
        Scanner scan = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Primeira data:");
        String firstDate = scan.nextLine();
        Date firstDateFormat = dateFormat.parse(firstDate);
        LocalDate firstLocalDate = firstDateFormat.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        System.out.println("Segunda data:");
        String secondDate = scan.nextLine();
        Date secondDateFormat = dateFormat.parse(secondDate);
        LocalDate secondLocalDate = secondDateFormat.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        if (firstDateFormat.equals(secondDateFormat)) {
            System.out.println("Não há distância entre as datas.");
        }
        else {
            Period period = Period.between(firstLocalDate, secondLocalDate);
            if (firstDateFormat.after(secondDateFormat)) {
                System.out.println("A distância entre as datas é de " + period.getYears()*-1 + " anos, " + period.getMonths()*-1 + " meses e " + ((period.getDays()*-1)+1) + " dias.");
            } else if (firstDateFormat.before(secondDateFormat)) {
                System.out.println("A distância entre as datas é de " + period.getYears() + " anos, " + period.getMonths() + " meses e " + period.getDays() + " dias.");
            }
        }
    }
}
