package com.example.Practice.leetcode.firstWeek;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MaxSalary {

    public static void main(String[] args) {
        List<Employee> employeeList = List.of(
                new Employee(1,"Piyush",BigDecimal.valueOf(4000),"Java Web"),
                new Employee(21,"Piyush1",BigDecimal.valueOf(49000),"Java Web"),
                new Employee(12,"Piyush2",BigDecimal.valueOf(9000),"Java Web"),
                new Employee(20, "Rushikesh",BigDecimal.valueOf(12000),"IOS"),
                new Employee(24, "Rushikesh1",BigDecimal.valueOf(23000),"IOS"),
                new Employee(25, "Rushikesh2",BigDecimal.valueOf(13450),"IOS"),
                new Employee(30,"Bhavesh",BigDecimal.valueOf(30000),".net"),
                new Employee(31,"Bhavesh1",BigDecimal.valueOf(34000),".net"),
                new Employee(32,"Bhavesh2",BigDecimal.valueOf(3000),".net")
        );

//        // with optional
//        Map<String, Optional<Employee>> maxSalary = employeeList.stream()
//                .collect(Collectors.groupingBy(
//                        Employee::getDepartment,
//                        Collectors.maxBy(Comparator.comparing(Employee::getSalary))
//                ));

        //without optional
        Map<String, Employee> maxSalary = employeeList.stream()
                .collect(Collectors.toMap(
                        Employee::getDepartment,
                        e->e,
                        (e1,e2)->e1.getSalary().compareTo(e2.getSalary())> 0 ? e1:e2
                ));


        maxSalary.forEach(
//                (dep,emp)-> System.out.println(dep + "->" + emp.get().name)
                (dep,emp)-> System.out.println(dep + "->" + emp.getName())
        );
    }

    private static class Employee{
        Integer id;
        String name;
        BigDecimal salary;
        String department;

        private Employee(){}

        private Employee(Integer id, String name,BigDecimal salary,String department){
            this.id = id;
            this.name = name;
            this.salary = salary;
            this.department = department;
        }

        public Integer getId() {
            return id;
        }public String getName() {
            return name;
        }public BigDecimal getSalary() {
            return salary;
        }public String getDepartment() {
            return department;
        }
    }
}
