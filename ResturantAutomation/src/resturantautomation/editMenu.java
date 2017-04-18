/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resturantautomation;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Kevin Lin
 */
public class editMenu extends javax.swing.JFrame {

    /**
     * Creates new form editMenu
     */
    public editMenu() {
        initComponents();
        displayMenuPic();
        populateAppetizer();
        populateDrink();
        populateEntree();
        populateDessert();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        appetizerBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        entreesBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        drinksBox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        dessertsBox = new javax.swing.JComboBox<>();
        editButton = new javax.swing.JButton();
        addItem = new javax.swing.JButton();
        removeItem = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        menuPic = new javax.swing.JLabel();
        jButtonPopularity = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        appetizerBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appetizerBoxActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Appetizers");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Entrees");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Drinks");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Desserts");

        editButton.setText("EDIT");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        addItem.setText("ADD");
        addItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItemActionPerformed(evt);
            }
        });

        removeItem.setText("REMOVE");
        removeItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeItemActionPerformed(evt);
            }
        });

        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jButtonPopularity.setText("Popularity");
        jButtonPopularity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPopularityActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(drinksBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                    .addComponent(appetizerBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(entreesBox, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(dessertsBox, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 260, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButtonPopularity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(editButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(addItem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(removeItem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)))
                                .addGap(93, 93, 93))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(menuPic, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(183, 183, 183))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel4)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(editButton, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(dessertsBox)
                            .addComponent(entreesBox)
                            .addComponent(appetizerBox))
                        .addGap(18, 18, 18)
                        .addComponent(addItem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(removeItem, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 184, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(drinksBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(140, 140, 140))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jButtonPopularity, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(menuPic, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void populateAppetizer()
    {       
            try{
            Connection conn=DriverManager.getConnection("jdbc:mysql://resturantdb.cul7akmhbeku.us-west-2.rds.amazonaws.com:3306/menudb","root","password");
      
            Statement st =conn.createStatement();
            ResultSet rs= st.executeQuery("select * from menu");
            appetizerBox.addItem("No Selection");
            
            while (rs.next())
            {
                if ("appetizer".equals(rs.getString(4)))
                {
                    appetizerBox.addItem(rs.getString(1));
                }
            }
            } catch (SQLException ex)
            {
                Logger.getLogger(editMenu.class.getName()).log(Level.SEVERE,null,ex);
            }
    }
    
    private void populateDrink()
    {
            try{
            Connection conn=DriverManager.getConnection("jdbc:mysql://resturantdb.cul7akmhbeku.us-west-2.rds.amazonaws.com:3306/menudb","root","password");
      
            Statement st =conn.createStatement();
            ResultSet rs= st.executeQuery("select * from menu");
            drinksBox.addItem("No Selection");
            
            while (rs.next())
            {
                if ("drink".equals(rs.getString(4)))
                {
                    drinksBox.addItem(rs.getString(1));
                }
            }
            } catch (SQLException ex)
            {
                Logger.getLogger(editMenu.class.getName()).log(Level.SEVERE,null,ex);
            }
    }
    
    private void populateEntree()
    {
            try{
            Connection conn=DriverManager.getConnection("jdbc:mysql://resturantdb.cul7akmhbeku.us-west-2.rds.amazonaws.com:3306/menudb","root","password");
      
            Statement st =conn.createStatement();
            ResultSet rs= st.executeQuery("select * from menu");
            entreesBox.addItem("No Selection");
            
            while (rs.next())
            {
                if ("entree".equals(rs.getString(4)))
                {
                    entreesBox.addItem(rs.getString(1));
                }
            }
            } catch (SQLException ex)
            {
                Logger.getLogger(editMenu.class.getName()).log(Level.SEVERE,null,ex);
            }
    }
    
    private void populateDessert()
    {
            try{
            Connection conn=DriverManager.getConnection("jdbc:mysql://resturantdb.cul7akmhbeku.us-west-2.rds.amazonaws.com:3306/menudb","root","password");
      
            Statement st =conn.createStatement();
            ResultSet rs= st.executeQuery("select * from menu");
            dessertsBox.addItem("No Selection");
            
            while (rs.next())
            {   
                
                if ("dessert".equals(rs.getString(4)))
                {
                    dessertsBox.addItem(rs.getString(1));
                }
            }
            } catch (SQLException ex)
            {
                Logger.getLogger(editMenu.class.getName()).log(Level.SEVERE,null,ex);
            }
    }
    
    private void appetizerBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appetizerBoxActionPerformed
        
    }//GEN-LAST:event_appetizerBoxActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        editItem editItemPage=new editItem();
        editItemPage.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_editButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        Chef chefPage=new Chef();
        chefPage.setVisible(true);
        this.hide();
    }//GEN-LAST:event_backButtonActionPerformed

    private void addItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemActionPerformed
        addItem addItemPage=new addItem();
        addItemPage.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_addItemActionPerformed

    private void removeItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeItemActionPerformed
        if (entreesBox.getSelectedItem()!="No Selection")
       {
           String toRemove = entreesBox.getSelectedItem().toString();
           try{
                Connection conn=DriverManager.getConnection("jdbc:mysql://resturantdb.cul7akmhbeku.us-west-2.rds.amazonaws.com:3306/menudb","root","password");
                Statement st =conn.createStatement();
                String sqlStatement="DELETE FROM `menudb`.`menu` WHERE `foodname`='"+toRemove+"'";
                st.executeUpdate(sqlStatement);
                JOptionPane.showMessageDialog(null,"'"+toRemove+"' removed successfully");

                
           }catch(SQLException ex)
           {
               Logger.getLogger(editMenu.class.getName()).log(Level.SEVERE,null,ex);
           }
       }
        if (dessertsBox.getSelectedItem()!="No Selection")
       {
           String toRemove = dessertsBox.getSelectedItem().toString();
           try{
                Connection conn=DriverManager.getConnection("jdbc:mysql://resturantdb.cul7akmhbeku.us-west-2.rds.amazonaws.com:3306/menudb","root","password");
                Statement st =conn.createStatement();
                String sqlStatement="DELETE FROM `menudb`.`menu` WHERE `foodname`='"+toRemove+"'";
                st.executeUpdate(sqlStatement);
                JOptionPane.showMessageDialog(null,"'"+toRemove+"' removed successfully");

                
           }catch(SQLException ex)
           {
               Logger.getLogger(editMenu.class.getName()).log(Level.SEVERE,null,ex);
           }
       }
       if (drinksBox.getSelectedItem()!="No Selection")
       {
           String toRemove = drinksBox.getSelectedItem().toString();
           try{
                Connection conn=DriverManager.getConnection("jdbc:mysql://resturantdb.cul7akmhbeku.us-west-2.rds.amazonaws.com:3306/menudb","root","password");
                Statement st =conn.createStatement();
                String sqlStatement="DELETE FROM `menudb`.`menu` WHERE `foodname`='"+toRemove+"'";
                st.executeUpdate(sqlStatement);
                JOptionPane.showMessageDialog(null,"'"+toRemove+"' removed successfully");

                
           }catch(SQLException ex)
           {
               Logger.getLogger(editMenu.class.getName()).log(Level.SEVERE,null,ex);
           }
       }
       if (appetizerBox.getSelectedItem()!="No Selection")
       {
           String toRemove = appetizerBox.getSelectedItem().toString();
           try{
                Connection conn=DriverManager.getConnection("jdbc:mysql://resturantdb.cul7akmhbeku.us-west-2.rds.amazonaws.com:3306/menudb","root","password");
                Statement st =conn.createStatement();
                String sqlStatement="DELETE FROM `menudb`.`menu` WHERE `foodname`='"+toRemove+"'";
                st.executeUpdate(sqlStatement);
                JOptionPane.showMessageDialog(null,"'"+toRemove+"' removed successfully");

                
           }catch(SQLException ex)
           {
               Logger.getLogger(editMenu.class.getName()).log(Level.SEVERE,null,ex);
           }
       }
       
       if (drinksBox.getSelectedItem()=="No Selection"&&dessertsBox.getSelectedItem()=="No Selection"&&appetizerBox.getSelectedItem()=="No Selection"&&entreesBox.getSelectedItem()=="No Selection")
       {
           JOptionPane.showMessageDialog(null,"No item was selected");
           return;
       }
       
        appetizerBox.removeAllItems();
        populateAppetizer();
        entreesBox.removeAllItems();
        populateEntree();
        dessertsBox.removeAllItems();
        populateDessert();
        drinksBox.removeAllItems();
        populateDrink();
        

       

    }//GEN-LAST:event_removeItemActionPerformed

    private void jButtonPopularityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPopularityActionPerformed
        menuStats mensPage = new menuStats();
        mensPage.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonPopularityActionPerformed
    
    private void displayMenuPic()
    {
            BufferedImage image;
            URL picURL=this.getClass().getResource("280186.png");
   
    try{
   image=ImageIO.read(picURL);
   
   
    ImageIcon icon= new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(menuPic.getWidth(),menuPic.getHeight(),Image.SCALE_DEFAULT));
    menuPic.setIcon(icon);
    
    }catch (IOException e)
    {
        e.printStackTrace();
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
            java.util.logging.Logger.getLogger(editMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addItem;
    private javax.swing.JComboBox<String> appetizerBox;
    private javax.swing.JButton backButton;
    private javax.swing.JComboBox<String> dessertsBox;
    private javax.swing.JComboBox<String> drinksBox;
    private javax.swing.JButton editButton;
    private javax.swing.JComboBox<String> entreesBox;
    private javax.swing.JButton jButtonPopularity;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel menuPic;
    private javax.swing.JButton removeItem;
    // End of variables declaration//GEN-END:variables
}
