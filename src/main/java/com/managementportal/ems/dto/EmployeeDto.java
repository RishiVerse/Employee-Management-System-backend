package com.managementportal.ems.dto;


import com.managementportal.ems.entity.DepartmentTable;
import com.managementportal.ems.entity.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
//    @Override
//    public String toString() {
//        return "EmployeeDto{" +
//                "emailAddress='" + emailAddress + '\'' +
//                ", firstname='" + firstname + '\'' +
//                ", lastname='" + lastname + '\'' +
//                ", address='" + address + '\'' +
//                ", mobileNumber='" + mobileNumber + '\'' +
//                ", employeeId=" + employeeId +
//                ", salary=" + salary +
//                ", leave=" + leave +
//                ", workPerformanceTables=" + workPerformanceTables +
//                ", timesheetTables=" + timesheetTables +
//                ", departments=" + departments +
//                '}';
//    implements Comparable<EmployeeDto> }

    private Long employeeId;

    private String emailAddress;

    private String firstname;

    private String lastname;

    private String address;

    private String mobileNumber;


//    private List<SalaryTable> salary;
//    private List<LeavesTable> leave;
//    private List<WorkPerformanceTable> workPerformanceTables;
//    private List<TimesheetTable> timesheetTables;
//    private List<DepartmentTable> departments;


//    @Override
//    public int compareTo(EmployeeDto o) {
//
//        return (int) (o.getEmployeeId() - this.employeeId);
//
//    }
}
