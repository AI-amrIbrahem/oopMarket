/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import pro.Inventory;
import pro.Product;

/**
 *
 * @author LAPTOP1
 */
public class managerJF extends javax.swing.JFrame {

    /**
     * Creates new form managerJF
     */
    public managerJF() {
        initComponents();
        refresh();
    }

    public void refresh()
    {
        DefaultTableModel plList = (DefaultTableModel) pList.getModel();
        int rowCount = plList.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
         plList.removeRow(i);
        }    
        addProductRows();
        idField.setText("");
        quantityField.setText("");
        nameField.setText("");
        priceField.setText("");
    }
    
    public  void addProductRows()
    {
        DefaultTableModel model = (DefaultTableModel) pList.getModel();
        Object rowData[] =new Object[4];
        Inventory s=new Inventory();
        ArrayList<Product> sl=new ArrayList<>();
        sl=s.listProduct();
        for (Product x:sl)
        {
            rowData[0]=x.getId();
            rowData[1]=x.getName();
            rowData[2]=x.getPrice();
            rowData[3]=x.getQuantity();
            model.addRow(rowData);
        }
    }
    
    public void update()
    {
        Inventory s=new Inventory();
        Product tmp=new Product();
        tmp= (Product) s.searchProduct(Integer.parseInt(pIDSEARCH.getText()));
        
        nameField.setText(tmp.getName());
        idField.setText(tmp.getId()+"");
        priceField.setText(tmp.getPrice()+"");
        quantityField.setText(tmp.getQuantity()+"");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        pList = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        pUPDATE = new javax.swing.JButton();
        pREMOVE = new javax.swing.JButton();
        pADD = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        priceField = new javax.swing.JTextField();
        quantityField = new javax.swing.JTextField();
        pSEARCH = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jSeparator19 = new javax.swing.JSeparator();
        pIDSEARCH = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(javax.swing.UIManager.getDefaults().getColor("textHighlight"));

        pList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "name", "price", "quantity"
            }
        ));
        pList.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                pListComponentAdded(evt);
            }
        });
        jScrollPane3.setViewportView(pList);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("name");

        pUPDATE.setBackground(new java.awt.Color(0, 0, 0));
        pUPDATE.setForeground(new java.awt.Color(255, 255, 255));
        pUPDATE.setText("UPDATE");
        pUPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pUPDATEActionPerformed(evt);
            }
        });

        pREMOVE.setBackground(new java.awt.Color(0, 0, 0));
        pREMOVE.setForeground(new java.awt.Color(255, 255, 255));
        pREMOVE.setText("REMOVE");
        pREMOVE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pREMOVEActionPerformed(evt);
            }
        });

        pADD.setBackground(new java.awt.Color(0, 0, 0));
        pADD.setForeground(new java.awt.Color(255, 255, 255));
        pADD.setText("ADD");
        pADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pADDActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("price");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("quantity");

        pSEARCH.setBackground(new java.awt.Color(0, 0, 0));
        pSEARCH.setForeground(new java.awt.Color(255, 255, 255));
        pSEARCH.setText("SEARCH");
        pSEARCH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pSEARCHActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("ID");

        pIDSEARCH.setBackground(javax.swing.UIManager.getDefaults().getColor("textHighlight"));
        pIDSEARCH.setForeground(new java.awt.Color(255, 255, 255));
        pIDSEARCH.setText("Enter User id");
        pIDSEARCH.setBorder(null);
        pIDSEARCH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pIDSEARCHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator19, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(90, 90, 90)
                        .addComponent(pIDSEARCH, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addComponent(pSEARCH, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(pUPDATE, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pREMOVE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(quantityField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addComponent(pADD, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 860, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pIDSEARCH, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pSEARCH, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(jSeparator19, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(13, 13, 13)
                            .addComponent(jLabel3)
                            .addGap(13, 13, 13)
                            .addComponent(jLabel6)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel7))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(7, 7, 7)
                            .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(7, 7, 7)
                            .addComponent(quantityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(pADD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pUPDATE, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pREMOVE, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pListComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_pListComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_pListComponentAdded

    private void pUPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pUPDATEActionPerformed
        // TODO add your handling code here:
        Inventory inventory=new Inventory();        
        inventory.updateProduct(nameField.getText(), Integer.parseInt(quantityField.getText()),Double.parseDouble(priceField.getText()) ,Integer.parseInt(idField.getText()));
        refresh();
    }//GEN-LAST:event_pUPDATEActionPerformed

    private void pREMOVEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pREMOVEActionPerformed
        // TODO add your handling code here:
         Inventory inventory=new Inventory();
         inventory.deleteProduct(Integer.parseInt(idField.getText()));
       
        refresh();
    }//GEN-LAST:event_pREMOVEActionPerformed
    
    private void pADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pADDActionPerformed
        // TODO add your handling code here:
            if (!nameField.getText().equals("")&&!idField.getText().equals("")&&!priceField.getText().equals("")&&!quantityField.getText().equals(""))
            {
                Inventory inventory=new Inventory();       
                inventory.addProduct(nameField.getText(),Integer.parseInt(quantityField.getText()) ,Double.parseDouble(priceField.getText()) ,Integer.parseInt(idField.getText()));
            }
            refresh();
    }//GEN-LAST:event_pADDActionPerformed

    private void pSEARCHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pSEARCHActionPerformed
        // TODO add your handling code here:
        Inventory s=new Inventory();
        Product tmp=new Product();
        tmp= (Product) s.searchProduct(Integer.parseInt(pIDSEARCH.getText()));
        
        nameField.setText(tmp.getName());
        idField.setText(tmp.getId()+"");
        priceField.setText(tmp.getPrice()+"");
        quantityField.setText(tmp.getQuantity()+"");
        
    }//GEN-LAST:event_pSEARCHActionPerformed

    private void pIDSEARCHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pIDSEARCHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pIDSEARCHActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(managerJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(managerJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(managerJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(managerJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new managerJF().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField idField;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JTextField nameField;
    private javax.swing.JButton pADD;
    private javax.swing.JTextField pIDSEARCH;
    private javax.swing.JTable pList;
    private javax.swing.JButton pREMOVE;
    private javax.swing.JButton pSEARCH;
    private javax.swing.JButton pUPDATE;
    private javax.swing.JTextField priceField;
    private javax.swing.JTextField quantityField;
    // End of variables declaration//GEN-END:variables
}