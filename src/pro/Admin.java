/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro;

import java.util.ArrayList;

/**
 *
 * @author LAPTOP1
 */
public class Admin extends Instance {
    
    private static double budget;   

    public Admin() {
    }

    public Admin(String firstName, String lastName, String password, int id, String userName) {
        super(firstName, lastName, password, id, userName);
    }

    

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }
    
    
    @Override
    public String toString()
    {
        return "firstName = "+getFirstName()+"lastName = "+getLastName()+"password = "+getPassword()+"ID = "+getId()+"userName = "+getUserName();
    }
    
    @Override
    public boolean login(String userName, String password) {
        if (userName.equals("admin@yahoo.com") && password.equals("123456789"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
}
