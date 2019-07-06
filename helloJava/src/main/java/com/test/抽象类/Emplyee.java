package com.test.抽象类;

import org.junit.Test;

import java.time.LocalDate;

/**
 * @Author buer
 * @create 2019/5/17 0:42
 * @description
 */
public class Emplyee extends Person {

    private double salary;
    private LocalDate hireday;


    //一定要调用父类的构造器

    /**
     *
     * @param name 调用父类的构造器
     * @param salary
     * @param hireday
     */
    public Emplyee(String name, double salary, LocalDate hireday) {
        super(name);
        this.salary = salary;
        this.hireday = hireday;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireday() {
        return hireday;
    }

    @Override
    public String getdDescription() {
        return String.format("an emplyee with A salary of $%.2f", salary);
    }

    public void raiseSalary(double byPercent){
        double raise = salary *  byPercent/100;
        salary += raise;
    }

    @Override
    public String toString() {
        return "Emplyee{" +
                "salary=" + salary +
                ", hireday=" + hireday +
                '}';
    }

    //要是0参数构造器
    @Test
    public  void test(){
        Person aperson = new Emplyee("chen", 10.0, LocalDate.now());
        aperson.getdDescription();
    }
//    public static void main(String[] args) {
//        Person aperson = new Emplyee("chen", 10.00D, LocalDate.now());
//        System.out.println(aperson.toString());
//        String re = aperson.getdDescription();
//        System.out.println(re);
//    }
}
