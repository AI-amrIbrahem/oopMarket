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
public class Inventory implements Serializable {
    TrueExceptions exceptions=new TrueExceptions();
    private ArrayList<Product> a=new ArrayList<Product>();
    private FileBinaryManager fileManager=new FileBinaryManager();
    private String fileName="Inventory.bin";

    public Inventory() {
        
    }
    
    //use
    
    public boolean addProduct(String name, int quantity, double price,int id)
    {
        try
        {
            if (exceptions.oldID(id)) {
            id = exceptions.checkProductId(id);
            }
            Product b=new Product(name,quantity,price,id);
            a=(ArrayList<Product>) fileManager.loadFromFile(fileName);
            a.add(b);
            return   fileManager.commitToFile(fileName,a);
        }
        catch(java.lang.NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null,"please enter number ");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return false;    
    }
    
     //use
    
    public boolean updateProduct(String name, int quantity, double price,int id)
    {
        Product p=new Product(name,quantity,price,id);
        a=(ArrayList<Product>) fileManager.loadFromFile(fileName); 
        int index=getIndex(id);
        if (index!=-1)
        {
            a.set(index, new Product(name,quantity,price,id));
            return fileManager.commitToFile(fileName, a);
        }
        return false;
    }
    
    
    
    //use
    private int getIndex(int id)
    {
        a=(ArrayList<Product>) fileManager.loadFromFile(fileName);
        for (int i=0;i<a.size();i++)
        {
            if (id==a.get(i).getId())
            {
                return i;
            }
        }
        return -1;
    }
    
    //use
 
    public ArrayList<Product> listProduct()
    {
        return (ArrayList<Product>) fileManager.loadFromFile(fileName);
    }
    
    //use
  
    public boolean deleteProduct(int id)
    {
        a=(ArrayList<Product>) fileManager.loadFromFile(fileName);
        int index=getIndex(id);
        if (index != -1)
        {
              a.remove(index);
              return fileManager.commitToFile(fileName, a);
        }
        return false;
    }
    //use
    
    public Product searchProduct(int id)
    {
        Product temp=new Product();
        a=(ArrayList<Product>) fileManager.loadFromFile(fileName);
        int index=getIndex(id);
        if (index!=-1)
            return a.get(index);
        else
            return temp;
    }
}
