/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author LAPTOP1
 */

public class Invoice implements Serializable{
    private double price;
    private double tax=0;
    private static ArrayList<Product> order;
    String fileName="invoice.bin";
    ArrayList<Invoice> invoices=new ArrayList<>();
    FileBinaryManager fm=new FileBinaryManager();
    public Invoice() {
    }
    public Invoice(ArrayList<Product> order) {
        this.order=order;
    }
    
    public  ArrayList<Invoice> list()
    {
        return (ArrayList<Invoice>) fm.loadFromFile(fileName);
    }
    
    public double getPrice() {
        double sum=0;
        for (int i=0; i< order.size() ;i++)
        sum=sum+((order.get(i).getQuantity())* order.get(i).getPrice());
        sum+=getTax();
        return sum;
    }
    
    public Date getDate() { 
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
        return date;
    }
    
    public double getTax() {
        return tax;
    }
    
    public void setTax(double tax) {
        this.tax = tax;
    }
    
   
    
    public String PrintInvoice(ArrayList<Product> order)
    {
        this.order=order;
        invoices=(ArrayList<Invoice>) fm.loadFromFile(fileName);
        invoices.add(this);
        fm.commitToFile(fileName, invoices);
        return "price = "+ getPrice()+ "     date = "+getDate()+"      tax = "+getTax();
    }
}