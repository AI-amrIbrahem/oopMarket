/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro;

/**
 *
 * @author LAPTOP1
 */
public abstract class Stuff extends Instance implements SellerManager {

    private int age;
    private double salary;

    public Stuff() {

    }

    public Stuff(int age, double salary, String firstName, String lastName, String password, int id, String userName) {
        super(firstName, lastName, password, id, userName);

        if (age >= 18 && age <= 60) {
            this.age = age;
        } else {
            this.age = exception.checkAge(age);
        }

        if (salary >= 400 && salary <= 3200) {
            this.salary = salary;
        } else {
            this.salary = exception.checkSalary(salary);
        }

    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary >= 400 && salary <= 3200) {
            this.salary = salary;
        } else {
            this.salary = exception.checkSalary(salary);
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 18 && age <= 60) {
            this.age = age;
        } else {
            this.age = exception.checkAge(age);
        }
    }

}
