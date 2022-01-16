/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro;

import java.io.Serializable;
import java.util.ArrayList;
import static javafx.scene.input.KeyCode.P;
import javax.swing.JOptionPane;

/**
 *
 * @author LAPTOP1
 */
public class Order implements /*SellerPart,*/ Serializable {

    private ArrayList<Product> order;
    private ArrayList<ArrayList<Product>> orders = new ArrayList<>();
    private FileBinaryManager fm = new FileBinaryManager();
    private String fileName = "oreders.bin";
    private static Invoice invoice = new Invoice();
    private Inventory inventory = new Inventory();
    private Product product;

    public Order() {
        order = new ArrayList<Product>();
    }

    //use
    public boolean addOrder() {
        Invoice invoice= new Invoice(order);
        orders = (ArrayList<ArrayList<Product>>) fm.loadFromFile(fileName);
        orders.add(order);
        if (fm.commitToFile(fileName, orders)) {
            return true;
        }
        return false;
    }

    //use
    public String printInvoice() {
        return invoice.PrintInvoice(order);
    }

    // to return price of buyyers to client to set new value in file
    double getPrice() {
        return invoice.getPrice();
    }


    private int getIndex(int id) {
        int temp = -1;
        for (int i = 0; i < order.size(); i++) {
            if (id == order.get(i).getId()) {
                return i;
            }
        }
        return temp;
    }

    //use
    public ArrayList<ArrayList<Product>> list() {
        return (ArrayList<ArrayList<Product>>) fm.loadFromFile(fileName);
    }

    //use
    public ArrayList<Product> listProductOfOrder() {
        return order;
    }
    
    public void fresh() {
        Inventory v = new Inventory();
        Product product;
        for (Product p : order) {
            product = v.searchProduct(p.getId());
            v.searchProduct(p.getId()).setQuantity(product.getQuantity() - p.getQuantity());
        }
    }

    //use
    public boolean removeOrder(int id) {
        if (!order.isEmpty()) {
            order.remove(getIndex(id));
            return true;
        }
        return false;
    }

    //use
    public boolean addToOrder(int id, int quantity) {

        if (quantity <= inventory.searchProduct(id).getQuantity()) {
            product = inventory.searchProduct(id);
            product.setQuantity(quantity);
            order.add(product);
            inventory.updateProduct(product.getName(), inventory.searchProduct(id).getQuantity() - product.getQuantity(), product.getPrice(), product.getId());
            return true;
        }
        return false;
    }
}