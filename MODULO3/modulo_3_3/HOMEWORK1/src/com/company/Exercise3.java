package com.company;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Exercise3 {

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        System.out.println("Brasil: " +
                "\n" + LocalDateTime.now(ZoneId.of("UTC-03:00")).format(formatter));
        System.out.println("\nAustralia: " +
                "\n" + LocalDateTime.now(ZoneId.of("UTC+10:00")).format(formatter));
        System.out.println("\nJapão: " +
                "\n" + LocalDateTime.now(ZoneId.of("UTC+09:00")).format(formatter));
        System.out.println("\nRússia: " +
                "\n" + LocalDateTime.now(ZoneId.of("UTC+03:00")).format(formatter));
        System.out.println("\nDubai: " +
                "\n" + LocalDateTime.now(ZoneId.of("UTC+04:00")).format(formatter));
        System.out.println("\nEstados Unidos: " +
                "\n" + LocalDateTime.now(ZoneId.of("UTC-07:00")).format(formatter));
    }
}
