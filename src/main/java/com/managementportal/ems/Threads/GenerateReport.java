package com.managementportal.ems.Threads;

import com.managementportal.ems.dto.EmployeeDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GenerateReport implements Runnable {


    private EmployeeDto employeeDto;

    @Override
    public void run() {
        String fileName = "employee_report.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(employeeDto.toString());
            writer.newLine();
            System.out.println("EmployeeTable details written to file successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }

    }
}
