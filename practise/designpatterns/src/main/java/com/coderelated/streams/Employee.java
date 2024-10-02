package com.coderelated.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Employee {
    private String name;
    private int salary;
    private String department;

    public Employee(String name, int salary, String department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("name='").append(name).append('\'');
        sb.append(", salary=").append(salary);
        sb.append(", department='").append(department).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public static void main(String args[]){
        Employee sam = new Employee("sam",1000,"dev");
        Employee sam1 = new Employee("sam1",1001,"dev");
        Employee prem = new Employee("prem",1001,"test");
        Employee prem1 = new Employee("prem1",1011,"test");
        Employee rahul = new Employee("rahul",1020,"hr");
        Employee rahul1 = new Employee("rahul1",1021,"hr");

        List<Employee> emps = Arrays.asList(sam,sam1,prem,prem1,rahul,rahul1);
        Map<String,Long> depEmpCnt = emps.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
        depEmpCnt.forEach((key,val)->{System.out.println(key+"::"+val);});
        emps.stream().collect(Collectors.groupingBy(Employee::getDepartment)).values().stream()
                .map(empdep-> empdep.stream().max(Comparator.comparing(Employee::getSalary))).collect(Collectors.toList()).forEach(System.out::println);

        // find most repeated value with count in an array of strings
        List<String> strarr = Arrays.asList("sam","prem","binkam","sam","prem","sam");
        Map.Entry<String, Long> maxCntEntry= strarr.stream().collect(Collectors.groupingBy(str->str,Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).get();
        System.out.println(maxCntEntry.getKey()+":"+maxCntEntry.getValue());

        BiFunction<String, String, String> bif = (s1,s2)-> s1+" "+s2;
        System.out.println(bif.apply("Hello","world"));

        BiConsumer<Integer, Integer> bic = (i1,i2)-> System.out.println("hello world sum :" +(i1+i2));
        bic.accept(2,3);

    }
}
