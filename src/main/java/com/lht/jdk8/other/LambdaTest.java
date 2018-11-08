package com.lht.jdk8.other;

import com.lht.jdk8.entity.Employee;
import com.lht.jdk8.other.interfa.MyPredicate;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaTest {

    //需求：获取当前公司中年龄大于35的员工信息
    List<Employee> employees = Arrays.asList(
            new Employee("张三", 22, 3333.33),
            new Employee("李四", 82, 4444.44),
            new Employee("王武", 42, 5555.55),
            new Employee("赵柳", 12, 6666.66),
            new Employee("田七", 32, 7777.77),
            new Employee("阿花", 18, 8888.88)
    );

    public List<Employee> filterEmp(List<Employee> list) {
        List<Employee> emps = new ArrayList<>();
        for (Employee emp : list) {
            if (emp.getAge() >= 35) {
                emps.add(emp);
            }
        }
        return emps;
    }

    @Test
    public void test1() {
        List<Employee> emps = filterEmp(this.employees);
        for (Employee emp : emps) {
            System.out.println(emp);
        }
    }

    //需求：获取公司中员工工资大于5000的员工信息
    public List<Employee> filterEmp2(List<Employee> list) {
        List<Employee> emps = new ArrayList<>();
        for (Employee emp : list)
            if (emp.getSalary() >= 5000) {
                emps.add(emp);
            }
        return emps;
    }

    //优化方式1
    public List<Employee> filterEmp3(List<Employee> list, MyPredicate<Employee> predicate) {
        List<Employee> emps = new ArrayList<>();
        for (Employee emp : list)
            if (predicate.test(emp)) {
                emps.add(emp);
            }
        return emps;
    }

    @Test
    public void test3() {
        List<Employee> emps = filterEmp3(this.employees, employee -> employee.getSalary() < 5000);
        for (Employee emp : emps) {
            System.out.println(emp);
        }
    }

}

