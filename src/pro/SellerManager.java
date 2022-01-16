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
public interface SellerManager {
    boolean addMember();
    boolean updateMember();
    public Object listMember();
    boolean deleteMember(int id);
    Object searchMember(int id);
    int getIndex(int id);
}
