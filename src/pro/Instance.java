/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro;

/**
 *
 * @author LAPTOP1
 */
public abstract class Instance extends Person implements ILogin {

    private String firstName;
    private String lastName;
    private String password;
    private int id;

    public Instance() {

    }

    public Instance(String firstName, String lastName, String password, int id, String userName) {
        super(userName);
        if (checkTrueName(firstName)) {
            this.firstName = firstName;
        } else {
            this.firstName = exception.trueName(firstName);
        }

        if (checkTrueName(lastName)) {
            this.lastName = lastName;
        } else {
            this.lastName = exception.trueName(lastName);
        }

        if (!(password.length() > 8) || !(password.length() < 20)) {
            this.password = exception.checkPassword(password);
        } else {
            this.password = password;
        }

        if (id <= 0) {
            this.id = exception.checkPositive(id);
        } else {
            this.id = id;
        }
    }

    public void setFirstName(String firstName) {
        if (checkTrueName(firstName)) {
            this.firstName = firstName;
        } else {
            this.firstName = exception.trueName(firstName);
        }
    }

    public void setLastName(String lastName) {
        if (checkTrueName(lastName)) {
            this.lastName = lastName;
        } else {
            this.lastName = exception.trueName(lastName);
        }
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            this.id = exception.checkPositive(id);
        } else {
            this.id = id;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (!(password.length() > 8) || !(password.length() < 20)) {
            this.password = exception.checkPassword(password);
        } else {
            this.password = password;
        }
    }

    //condtion of check name
    private boolean checkTrueName(String name) {
        for (int i = 0; i < name.length(); i++) {
            if ((name.charAt(i) <= 'z' && name.charAt(i) >= 'a') || (name.charAt(i) <= 'Z' && name.charAt(i) >= 'A') || (name.charAt(i) == '_')) {

            } else {
                return false;
            }
        }
        return true;
    }

}
