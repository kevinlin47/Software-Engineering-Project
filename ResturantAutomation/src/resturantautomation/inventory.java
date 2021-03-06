/*
Author:
Anthony Caivano
 */
package resturantautomation;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.util.*;

/**
 *
 * @author Anthony Caivano
 */
public class inventory extends javax.swing.JFrame {

    
    //creates new inventory
    public inventory() 
    {
        initComponents();
        populateList();
        getContentPane().setBackground(new Color(128, 0, 0));
    }
    
    public List<String> qlist = new ArrayList<String>();
    public List<String> plist = new ArrayList<String>();
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jListName = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonView = new javax.swing.JButton();
        jButtonRemove = new javax.swing.JButton();
        jButtonEdit = new javax.swing.JButton();
        jButtonNew = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jTextFieldQuantity = new javax.swing.JFormattedTextField();
        jTextFieldCost = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jListName.setBackground(new java.awt.Color(103, 102, 102));
        jListName.setFont(new java.awt.Font("DejaVu Serif", 1, 12)); // NOI18N
        jListName.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListName.setToolTipText("");
        jScrollPane2.setViewportView(jListName);

        jLabel1.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        jLabel1.setText("Quantity:");

        jLabel2.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        jLabel2.setText("Unit Cost:");

        jButtonView.setBackground(new java.awt.Color(0, 0, 0));
        jButtonView.setFont(new java.awt.Font("DejaVu Serif", 1, 12)); // NOI18N
        jButtonView.setForeground(new java.awt.Color(255, 255, 255));
        jButtonView.setText("View Selected Info");
        jButtonView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonViewActionPerformed(evt);
            }
        });

        jButtonRemove.setBackground(new java.awt.Color(0, 0, 0));
        jButtonRemove.setFont(new java.awt.Font("DejaVu Serif", 1, 12)); // NOI18N
        jButtonRemove.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRemove.setText("Remove Selected");
        jButtonRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveActionPerformed(evt);
            }
        });

        jButtonEdit.setBackground(new java.awt.Color(0, 0, 0));
        jButtonEdit.setFont(new java.awt.Font("DejaVu Serif", 1, 12)); // NOI18N
        jButtonEdit.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEdit.setText("Edit Selected");
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });

        jButtonNew.setBackground(new java.awt.Color(0, 0, 0));
        jButtonNew.setFont(new java.awt.Font("DejaVu Serif", 1, 12)); // NOI18N
        jButtonNew.setForeground(new java.awt.Color(255, 255, 255));
        jButtonNew.setText("Add New");
        jButtonNew.setToolTipText("");
        jButtonNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("DejaVu Serif", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextFieldQuantity.setBackground(new java.awt.Color(153, 153, 153));
        jTextFieldQuantity.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###0.###"))));

        jTextFieldCost.setBackground(new java.awt.Color(153, 153, 153));
        jTextFieldCost.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###0.###"))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldQuantity)
                            .addComponent(jTextFieldCost)))
                    .addComponent(jButtonView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonView)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonNew)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(15, 15, 15)
                .addComponent(jButtonRemove)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonViewActionPerformed
        if (!jListName.isSelectionEmpty())
        {   
            jTextFieldCost.setText(plist.get(jListName.getSelectedIndex()));
             jTextFieldQuantity.setText(qlist.get(jListName.getSelectedIndex()));
        }
        
    }//GEN-LAST:event_jButtonViewActionPerformed

    private void jButtonRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveActionPerformed
        // TODO add your handling code here:
        if (!jListName.isSelectionEmpty())
        {
        try{                    
            //sql connections
            Connection conn=DriverManager.getConnection("jdbc:mysql://resturantdb.cul7akmhbeku.us-west-2.rds.amazonaws.com:3306/menudb","root","password");
            Statement st =conn.createStatement();
            st.executeUpdate("DELETE FROM `menudb`.`ingredients` WHERE `name`='"+jListName.getSelectedValue()+"'"); //delete command
            populateList(); //resetting the display
            jTextFieldCost.setText("");
            jTextFieldQuantity.setText("");
        } catch (SQLException ex)
            {
                Logger.getLogger(inventory.class.getName()).log(Level.SEVERE,null,ex);
            } 
        }
    }//GEN-LAST:event_jButtonRemoveActionPerformed

    private void jButtonNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewActionPerformed
        addInventory invAddPage = new addInventory();
        invAddPage.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonNewActionPerformed

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
 try{                    
            //sql connections
            Connection conn=DriverManager.getConnection("jdbc:mysql://resturantdb.cul7akmhbeku.us-west-2.rds.amazonaws.com:3306/menudb","root","password");
            Statement st =conn.createStatement();
            st.executeUpdate("UPDATE `menudb`.`ingredients` SET `quantity`='"+jTextFieldQuantity.getText()+"' WHERE `name`='"+jListName.getSelectedValue()+"'");
            st.executeUpdate("UPDATE `menudb`.`ingredients` SET `price`='"+jTextFieldCost.getText()+"' WHERE `name`='"+jListName.getSelectedValue()+"'");
            populateList();
            } catch (SQLException ex)
            {
                Logger.getLogger(inventory.class.getName()).log(Level.SEVERE,null,ex);
            }     
    }//GEN-LAST:event_jButtonEditActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Chef chef=new Chef();
        chef.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void populateList() //the following function will be responsible for fetching the ingredient list from the SQL database and displaying it to the user
    {
        DefaultListModel initList = new DefaultListModel();
    try{                    
            //sql connections
            Connection conn=DriverManager.getConnection("jdbc:mysql://resturantdb.cul7akmhbeku.us-west-2.rds.amazonaws.com:3306/menudb","root","password");
            Statement st =conn.createStatement();
            ResultSet rs= st.executeQuery("select * from ingredients order by name");
            qlist.clear();
            plist.clear();
            while (rs.next())
            {
                initList.addElement(rs.getString(1)); //adding table data to the temporary list
                qlist.add(rs.getString(2));
                plist.add(rs.getString(3));
            }
            jListName.setModel(initList); //setting the displayed list as the temp list
            } catch (SQLException ex)
            {
                Logger.getLogger(inventory.class.getName()).log(Level.SEVERE,null,ex);
            }     
    }
    
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
            java.util.logging.Logger.getLogger(inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new inventory().setVisible(true);         
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonNew;
    private javax.swing.JButton jButtonRemove;
    private javax.swing.JButton jButtonView;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jListName;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JFormattedTextField jTextFieldCost;
    private javax.swing.JFormattedTextField jTextFieldQuantity;
    // End of variables declaration//GEN-END:variables
}
