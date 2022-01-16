/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author LAPTOP1
 */
final public class TrueExceptions extends Exception implements Serializable {

    private int flag;
    private String temp;

    public TrueExceptions() {

    }

    public TrueExceptions(String e) {
        super(e);
    }

    public String trueName(String firstName) {
        flag = 0;
        do {
            if (flag == 0) {
                temp = JOptionPane.showInputDialog("Enter name without number or symbol");
            }
            flag = 0;
            for (int i = 0; i < temp.length(); i++) {
                if ((temp.charAt(i) <= 'z' && temp.charAt(i) >= 'a') || (temp.charAt(i) <= 'Z' && temp.charAt(i) >= 'A') || (temp.charAt(i) == '_') || (temp.charAt(i) == ' ')) {

                } else {
                    JOptionPane.showMessageDialog(null, "Not Valid Name ...!");
                    flag = -1;
                    break;
                }
            }
        } while (flag != 0);
        return temp;
    }

    String checkUserName(String x) {
        do {
            temp = JOptionPane.showInputDialog("Enter Valid UserName ...!\n[  use Uppercase , Lowercase , sign  '@'  and  '.'  ]");
            if ((temp.contains("@yahoo.com") && !temp.contains("@gamil.com")) || (!temp.contains("@yahoo.com") && temp.contains("@gamil.com"))) {

            } else {
                JOptionPane.showMessageDialog(null, "Not Valid UserName ...!");
            }
        } while (!((temp.contains("@yahoo.com") && !temp.contains("@gamil.com")) || (!temp.contains("@yahoo.com") && temp.contains("@gamil.com"))));
        return temp;
    }

    String checkPassword(String password) {
        String temp;
        do {
            temp = JOptionPane.showInputDialog("Enter Valid Password !\n[Between 8 to 20 ...]");
            if (!(temp.length() > 8) || !(temp.length() < 20)) {
                JOptionPane.showMessageDialog(null, "Enter Valid Password !\n[Between 8 to 20...]");
            }
        } while (!(temp.length() > 8) || !(temp.length() < 20));
        return temp;
    }

    int checkPositive(int id) {
        int number;
        do {
            number = Integer.parseInt(JOptionPane.showInputDialog("enter positive number !"));
            if (number <= 0) {
                JOptionPane.showMessageDialog(null, "Not valid Input for Positive Int Try Again :(");
            }
        } while (number < 0);
        return number;
    }

    int checkAge(int age) {
        int number;
        do {
            number = Integer.parseInt(JOptionPane.showInputDialog("enter correct age !"));
            if (!(number >= 18 && number <= 60)) {
                JOptionPane.showMessageDialog(null, "Not valid Input age between 18 to 60 :(");
            }
        } while (!(number >= 18 && number <= 60));
        return number;
    }

    double checkSalary(double salary) {
        int number;
        do {
            number = Integer.parseInt(JOptionPane.showInputDialog("enter salary between 400 to 3200 !"));
            if (!(number >= 400 && number <= 3200)) {
                JOptionPane.showMessageDialog(null, "Not valid salary :(");
            }
        } while (!(number >= 400 && number <= 3200));
        return number;
    }

    public int checkProductId(int id) {
        Inventory i = new Inventory();
        int flag = -1;
        ArrayList<Product> p = i.listProduct();
        int temp;
        do {
            flag = -1;
            temp = Integer.parseInt(JOptionPane.showInputDialog("this ID use try again or you use negative number"));
            for (Product c : p) {
                if (c.getId() == temp || temp < 0) {
                    flag = 0;
                    break;
                }
            }
        } while (flag == 0);
        return temp;
    }

    // to only check
    public boolean oldID(int id) {
        Inventory i = new Inventory();
        int flag = -1;
        ArrayList<Product> p = i.listProduct();
        for (Product c : p) {
            if (c.getId() == id) {
                return true;
            }
        }
        return false;
    }
}
