package com.example.tp;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogManager {
    private final String logPath;
    private final DateTimeFormatter dtf =
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public LogManager(String logPath) {
        this.logPath = logPath;
    }


    public void log(String level, String message) {
        String timestamp = LocalDateTime.now().format(dtf);
        try (PrintWriter pw = new PrintWriter(new FileWriter(logPath, true))) {
            pw.printf("%s [%s] %s%n", timestamp, level, message);
        } catch (IOException e) {
            System.err.println("Erreur de log : " + e.getMessage());
        }
    }
}