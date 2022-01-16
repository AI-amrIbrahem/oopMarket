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
public class Product implements Serializable {

    private String name;
    private int quantity;
    private double price;
    private int id;
    TrueExceptions exceptions = new TrueExceptions();

    public Product(String name, int quantity, double price, int id) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.id=id;
    }

    public Product() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (exceptions.oldID(id)) {
            this.id = exceptions.checkProductId(id);
        } else {
            this.id = id;
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
