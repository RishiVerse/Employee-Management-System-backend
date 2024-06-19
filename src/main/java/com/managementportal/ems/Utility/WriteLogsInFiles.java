package com.managementportal.ems.Utility;


import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class WriteLogsInFiles {
    private static final String LOG_DIR = "src/main/Logs";

    // Method to print logs
    public void printLogs(String msg, String filename) {
        // Ensure the log directory exists
        File logDirectory = new File(LOG_DIR);
        if (!logDirectory.exists()) {
            logDirectory.mkdirs(); // Create the directory if it does not exist
        }

        // Full path to the log file
        String filePath = LOG_DIR + File.separator + filename;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(msg);
            writer.newLine();
            System.out.println("Log message written to file successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}


