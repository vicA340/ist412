package com.example.atzfinance.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Date;

public class LoggingService {
 
    private final String LOG_FILE = "src\\main\\resources\\templates\\log.html";

    public void log(String data) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(LOG_FILE, true));
            out.write("[" + new Date().toString() + "]<div style=\"background-color:lightgrey;\"> " + data + "</div>");
            out.newLine();
            out.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
