package com.company;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Exercise5 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();

        System.out.println("BR: "+now.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(new Locale("pt-BR"))));
        System.out.println("US: "+now.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(new Locale("en"))));
        System.out.println("FR: "+now.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(new Locale("fr"))));
    }
}
