/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro;

import java.io.Serializable;

/**
 *
 * @author LAPTOP1
 */
public abstract class Person implements Serializable {

    protected TrueExceptions exception = new TrueExceptions();
    protected FileBinaryManager FM = new FileBinaryManager();
    private String userName;

    public Person() {

    }

    public Person(String userName) {
        if (!((userName.contains("@yahoo.com") && !userName.contains("@gamil.com")) || (!userName.contains("@yahoo.com") && userName.contains("@gamil.com")))) {
            this.userName = exception.checkUserName(userName);
        } else {
            this.userName = userName;
        }
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        if (!((userName.contains("@yahoo.com") && !userName.contains("@gmail.com")) || (!userName.contains("@yahoo.com") && userName.contains("@gmail.com")))) {
            this.userName = exception.checkUserName(userName);
        } else {
            this.userName = userName;
        }
    }

}
   
    
    
    
    
    
    
    
    
    
    
  
    
    /*
    protected String firstName;
    protected String lastName;
    
    TrueExceptions exception = new TrueExceptions();
    FileBinaryManager FM=new FileBinaryManager();
    Person()
    {
        
    }
    
    public Person(String firstName,String lastName)
    {
        if (checkTrueName(firstName))
        {
            this.firstName=firstName;
        }
        else
        {
            this.firstName=exception.trueName(firstName);
        }
        
        if (checkTrueName(lastName))
        {
            this.lastName=lastName;
        }
        else
        {
            this.lastName=exception.trueName(lastName);
        }
    }
    // check true firstName , secondName with role
    private boolean checkTrueName(String name)
    {
        for (int i=0;i<name.length();i++)
            {
                 if ((name.charAt(i)<='z'&&name.charAt(i)>='a')||(name.charAt(i)<='Z'&&name.charAt(i)>='A')||(name.charAt(i)=='_'))
                    {

                    }
                else 
                    {
                        return false;
                    }
            }
        return true;
    }
    
    public void setFirstName(String firstName)
    {
        if (checkTrueName(firstName))
        {
            this.firstName=firstName;
        }
        else
        {
            this.firstName=exception.trueName(firstName);
        }
    }
    public void setLastName(String lastName)
    {
        if (checkTrueName(lastName))
        {
            this.lastName=lastName;
        }
        else
        {
            this.lastName=exception.trueName(lastName);
        }
    }
    public String getFirstName()
    {
        return this.firstName;
    }
    public String getLastName()
    {
        return this.lastName;
    }
    @Override
    public String toString()
    {
        return "First name : "+getFirstName()+" "+"Second name : "+getLastName();
    }
*/
