package com.company;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Exercise4 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now().plusDays(15).plusHours(10);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        System.out.println(now.format(formatter));
    }
}
