/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LAPTOP1
 */
public class FileBinaryManager implements Serializable{
    /*private boolean write(String fileName,Object data)
    {
        try
        {
            ObjectOutputStream writer=new ObjectOutputStream(new FileOutputStream(new File(fileName)));
            writer.writeObject(data);
            writer.close();
            return true;
        }catch(IOException e){
            System.out.println(e);
        }catch(Exception ee)
        {
            System.out.println(ee);
        }
        return false;
    }
    */
     private boolean write(String FilePath, Object data) {

        try {
            System.out.print("\nwritting in ! " + FilePath);

            ObjectOutputStream writter = new ObjectOutputStream(new FileOutputStream(FilePath));

            writter.writeObject(data);

            System.out.println(" ... Done ! ");
            writter.close();
            return true;

        } catch (IOException e) {
            System.out.println("Can't write ...!\n" + e);
        }

        return false;
    }
    
   public Object read(String fileName)
    {
        Object temp=null;
        try
        {
            System.out.println("Reading ! From " + fileName);
            ObjectInputStream reader =new ObjectInputStream(new FileInputStream(new File(fileName)));
            temp=reader.readObject();
            reader.close();
        }catch(IOException e1)
        {
                    System.out.println(e1);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FileBinaryManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;
    }
    
    public boolean commitToFile(String fileName,Object o)
    {
        return write(fileName, o);
    }
    public Object loadFromFile(String fileName)
    {
        return read(fileName);
    }

    
}
