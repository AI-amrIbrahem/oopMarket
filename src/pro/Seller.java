/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author LAPTOP1
 */
public class Seller extends Stuff  {

    private static ArrayList<Seller> sellers = new ArrayList<Seller>();
    private String fileSellerName = "Seller.bin";
    Client client;

    public Seller() {
    }

    public Seller(int age, double salary, String firstName, String lastName, String password, int id, String userName) {
        super(age, salary, firstName, lastName, password, id, userName);
    }

    //use
    @Override
    public boolean addMember() {

        sellers = (ArrayList<Seller>) FM.loadFromFile(fileSellerName);
        sellers.add(this);
        return FM.commitToFile(fileSellerName, sellers);
    }

    //use
    @Override
    public int getIndex(int ID) {
        sellers = (ArrayList<Seller>) FM.loadFromFile(fileSellerName);
        for (int i = 0; i < sellers.size(); i++) {
            if (sellers.get(i).getId() == ID) {
                return i;
            }
        }
        return -1;
    }

    //use
    @Override
    public boolean updateMember() {
        sellers = (ArrayList<Seller>) FM.loadFromFile(fileSellerName);
        if (!sellers.isEmpty()) {
            int i = getIndex(this.getId());
            if (i != -1) {
                sellers.set(i, this);
                return FM.commitToFile(fileSellerName, sellers);
            }
        }
        return false;
    }

    //use
    @Override
    public boolean deleteMember(int id) {
        sellers = (ArrayList<Seller>) FM.loadFromFile(fileSellerName);
        int i = getIndex(id);
        if (i != -1) {
            sellers.remove(i);
        }
        return FM.commitToFile(fileSellerName, sellers);
    }

    //use
    @Override
    public Object listMember() {
        return (ArrayList<Seller>) FM.loadFromFile(fileSellerName);
    }

    //use
    @Override
    public Object searchMember(int id) {
        Seller temp = new Seller();
        sellers = (ArrayList<Seller>) FM.loadFromFile(fileSellerName);
        int i = getIndex(id);
        if (i != -1) {
            return sellers.get(i);
        } else {
            return temp;
        }
    }

    //use
    public void openOrder(String email) {
        client = new Client(email);
    }

    //use
    public void openOrder() {
        client = new Client();
    }

    //use
    public boolean addToOrder(int id, int quantity) {
        return client.addToOrder(id, quantity);
    }

    //use
    public void remove(int id) {
        client.remove(id);
    }

    //use
    public void print() {
        client.addOrder();
        JOptionPane.showMessageDialog(null, client.print());

    }

    //use
    @Override
    public boolean login(String userName, String password) {
        if (userName.equals("seller@yahoo.com") && password.equals("123456789")) {
            return true;
        }
        return false;
    }

}
