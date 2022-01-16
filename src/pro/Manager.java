
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author LAPTOP1
 */
public class Manager extends Stuff implements Serializable {

    private String fileManagerName = "Manager.bin";
    private ArrayList<Manager> managers = new ArrayList<Manager>();
    Inventory inventory = new Inventory();

    public Manager(int age, double salary, String firstName, String lastName, String password, int id, String userName) {
        super(age, salary, firstName, lastName, password, id, userName);
    }

    public Manager() {
    }

    //use
    public boolean addMember() {
        managers = (ArrayList<Manager>) FM.loadFromFile(fileManagerName);
        managers.add(this);
        return FM.commitToFile(fileManagerName, managers);
    }

    //use
    public int getIndex(int id) {
        managers = (ArrayList<Manager>) FM.loadFromFile(fileManagerName);
        for (int i = 0; i < managers.size(); i++) {
            if (id == managers.get(i).getId()) {
                return i;
            }
        }
        return -1;
    }

    //use
    public boolean updateMember() {
        managers = (ArrayList<Manager>) FM.loadFromFile(fileManagerName);
        int index = getIndex(getId());
        if (index != -1) {
            managers.set(index, this);
            return FM.commitToFile(fileManagerName, managers);
        }
        return false;
    }

    //use
    @Override
    public Object listMember() {
        return managers = (ArrayList<Manager>) FM.loadFromFile(fileManagerName);
        /*
        try {
            return managers = (ArrayList<Manager>) FM.loadFromFile(fileManagerName);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
         */
    }

    //use
    public boolean deleteMember(int id) {
        managers = (ArrayList<Manager>) FM.loadFromFile(fileManagerName);
        int index = getIndex(id);
        if (index != -1) {
            managers.remove(index);
            return FM.commitToFile(fileManagerName, managers);
        }
        return false;
    }

    //use
    public Object searchMember(int id) {
        managers = (ArrayList<Manager>) FM.loadFromFile(fileManagerName);
        // public Manager(int age, double salary, String firstName, String lastName, String password, int id, String userName)
        Manager temp = new Manager();
        int i = getIndex(id);
        if (i != -1) {
            return managers.get(i);
        } else {
            return temp;
        }
    }

    @Override
    public boolean login(String userName, String password) {
        if (userName.equals("manager@yahoo.com") && password.equals("123456789")) {
            return true;
        } else {
            return false;
        }
    }
}
