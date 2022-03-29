package com.company;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Exercise6 {
    public static void main(String[] args) {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    LocalDateTime show = LocalDateTime.of(2024, 9, 14, 18, 30);

    Duration duration = Duration.between(now, show);

    int years = (int) duration.toDays() / 365;
    int months = (int) (((duration.toDays() % 365) / 30));
    int days = now.getDayOfMonth() - show.getDayOfMonth();
    int hours = show.getHour() - LocalDateTime.now().getHour();
    int minutes = 60 - (show.getMinute() + LocalDateTime.now().getMinute());
    int seconds = 60 - (show.getSecond() + LocalDateTime.now().getSecond());


    if (seconds != 0) {
        minutes = minutes - 1;
    }

    if (minutes < 0) {
        minutes = minutes * -1;
        hours = hours - 1;
    }

    System.out.println("Faltam "+years+" anos, "+months+" meses, "+days+" dias, "+hours+" horas, "+minutes+" minutos e "+seconds+" segundos para o evento!");
    }
}
