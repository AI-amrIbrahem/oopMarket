/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pro;

import com.sun.org.apache.bcel.internal.generic.FMUL;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author LAPTOP1
 */

public class Client extends Person implements /*SellerPart ,*/ Serializable {

    private ArrayList<Client> clients= new ArrayList<>();
    private String fileName = "Client.bin";
    private double paidMoney;
    private int flag = 0;   // to know he has email or not when open new order
    public Order o;

    public Client() {
        flag = -1;
        o = new Order();
    }

    public Client(String email) {
        o = new Order();
        int index = -1;
        System.out.println("000");
        clients=(ArrayList<Client>) FM.loadFromFile(fileName);
        System.out.println("000");
        if (clients.isEmpty()) {

        } else {
            System.out.println("654");
//            index = getIndex(email);
        }
        if (index == -1) {
            super.setUserName(email);
            this.setpaidmon(0);
            clients.add(this);
            FM.commitToFile(fileName, clients);
        } else {
            System.out.println("456");
            super.setUserName(clients.get(index).getEmail());
            this.setEmail(clients.get(index).getEmail());
            this.setPaidMoney(clients.get(index).getPaidMoney());
        }
    }

    //use
    public int getIndex(String email) {
        int temp = -1;
        System.out.println("123");
        for (int i = 0; i < clients.size(); i++) {
            System.out.println("1");
            if (email.equals(clients.get(i).getEmail())) {
                return i;
            }
        }
        return temp;
    }

    //use
    // conditions
    public double getPaidMoney() {
        return paidMoney;
    }

    public void setPaidMoney(double price) {
        this.paidMoney = this.paidMoney + price;
        clients.set(getIndex(this.getEmail()), this);
        FM.commitToFile(fileName, clients);
    }

    public void setpaidmon(double price) {
        this.paidMoney = price;
    }

    public String getEmail() {
        return super.getUserName();
    }

    public void setEmail(String email) {
        super.setUserName(email);
    }

    //use
    public boolean addOrder() {
        if (flag == 0) {
            if (o.addOrder()) {
                this.setPaidMoney( o.getPrice() );
                return true;
            }
        } else {
            return o.addOrder();
        }
        return false;
    }

    //use
    public boolean addToOrder(int id, int quantity) {
        return o.addToOrder(id, quantity);
    }

    //use
    public void remove(int id) {
        o.removeOrder(id);
    }

    //use
    public String print() {
        return o.printInvoice();
    }
}
