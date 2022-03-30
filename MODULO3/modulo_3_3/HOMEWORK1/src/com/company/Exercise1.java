package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) throws ParseException {
        Scanner scan = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Informe seu aniversário (DD/MM/YYYY): ");
        String birthday = scan.nextLine();

        Date formattedBirthday = dateFormat.parse(birthday);
        int isolatedDate = formattedBirthday.getDate();
        int isolatedMonth = formattedBirthday.getMonth()+1;

        Date formattedToday = new Date(System.currentTimeMillis());
        int isolatedTodayDate = formattedToday.getDate();
        int isolatedTodayMonth = formattedToday.getMonth()+1;

        String getNextAnniversary =       isolatedDate+"/"+isolatedMonth+"/"+LocalDate.now().getYear();
        Date nextAnniversary = dateFormat.parse(getNextAnniversary);

        String getToday = isolatedTodayDate+"/"+isolatedTodayMonth+"/"+LocalDate.now().getYear();
        Date today = dateFormat.parse(getToday);

        LocalDate nextAnni = nextAnniversary.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate tod = today.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();


        if (formattedBirthday.getYear() > formattedToday.getYear()) {
            System.out.println("Você precisa ter nascido em "+tod.getYear()+" ou antes.");
        }
        else {
            if (today.equals(nextAnniversary)) {
                System.out.println("Hoje é seu aniversário!");
            } else if (today.before(nextAnniversary)) {
                Period period = Period.between(tod, nextAnni);
                System.out.println("Faltam " + period.getMonths() + " meses e " + period.getDays() + " dias para o seu aniversário.");
            } else if (today.after(nextAnniversary)) {
                LocalDate nextYear = nextAnni.withYear(nextAnni.getYear() + 1);
                Period period = Period.between(tod, nextYear);
                System.out.println("Faltam " + period.getMonths() + " meses e " + period.getDays() + " dias para o seu aniversário.");
            }
        }
    }
}