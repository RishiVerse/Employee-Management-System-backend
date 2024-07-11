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

    private String email;

    private String firstname;

    private String lastname;

    private String address;

    private String mobileNumber;


    private EmployeeDto() {
    }

    private EmployeeDto(Long employeeId, String email, String firstname, String lastname, String address, String mobileNumber) {
        this.employeeId = employeeId;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.mobileNumber = mobileNumber;
    }

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


    public static class EmployeeDtoBuilder {
        private Long employeeId;

        private String email;

        private String firstname;

        private String lastname;

        private String address;

        private String mobileNumber;
        private EmployeeDto employeeDto;


        public EmployeeDtoBuilder setEmployeeId(Long employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public EmployeeDtoBuilder setEmail(String email) {
            this.email = email;
            return this;

        }

        public EmployeeDtoBuilder setFirstname(String firstname) {
            this.firstname = firstname;
            return this;

        }

        public EmployeeDtoBuilder setLastname(String lastname) {
            this.lastname = lastname;
            return this;

        }

        public EmployeeDtoBuilder setAddress(String address) {
            this.address = address;
            return this;

        }

        public EmployeeDtoBuilder setMobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
            return this;

        }

        public EmployeeDto build() {
            this.employeeDto = new EmployeeDto();
            employeeDto.setAddress(address);
            employeeDto.setEmployeeId(employeeId);
            employeeDto.setLastname(lastname);
            employeeDto.setFirstname(firstname);
            employeeDto.setEmail(email);
            employeeDto.setMobileNumber(mobileNumber);
            return this.employeeDto;
        }

        public EmployeeDto getUserDTO() {
            return this.employeeDto;
        }
    }
}

