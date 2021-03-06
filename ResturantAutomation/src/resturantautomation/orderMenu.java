/*
Author:
Kevin Lin
 */
package resturantautomation;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
/**
 *
 * @author Kevin Lin
 */
public class orderMenu extends javax.swing.JFrame {


    public orderMenu() {
        initComponents();
        displayPicture();
    }
    




    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backButton = new javax.swing.JButton();
        Appetizers = new javax.swing.JLabel();
        Entrees = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        appetizersList = new javax.swing.JList<>();
        menuButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        entreesList = new javax.swing.JList<>();
        Drinks = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        drinksList = new javax.swing.JList<>();
        Desserts = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        dessertsList = new javax.swing.JList<>();
        hamburgerPicture = new javax.swing.JLabel();
        currentOrder = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        orderList = new javax.swing.JList<>();
        addButton = new javax.swing.JButton();
        submitOrder = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        Appetizers.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Appetizers.setText("Appetizers");

        Entrees.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Entrees.setText("Entrees");

        jScrollPane1.setViewportView(appetizersList);

        menuButton.setText("Menu");
        menuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuButtonActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(entreesList);

        Drinks.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Drinks.setText("Drinks");

        jScrollPane2.setViewportView(drinksList);

        Desserts.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Desserts.setText("Desserts");

        jScrollPane4.setViewportView(dessertsList);

        currentOrder.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        currentOrder.setText("Current Order");

        jScrollPane5.setViewportView(orderList);

        addButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        submitOrder.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        submitOrder.setText("SUBMIT");
        submitOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitOrderActionPerformed(evt);
            }
        });

        deleteButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        deleteButton.setText("REMOVE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        clearButton.setText("CLEAR");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(menuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                    .addComponent(Drinks)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGap(64, 64, 64)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Entrees, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                            .addComponent(Appetizers, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Desserts)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hamburgerPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(currentOrder)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(submitOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(clearButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(58, 58, 58))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Appetizers, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Entrees, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(currentOrder))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(hamburgerPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(68, 68, 68)
                            .addComponent(Desserts)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane4))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(26, 26, 26)
                            .addComponent(Drinks)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(submitOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(menuButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(backButton, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
           this.hide();
           Waiter waiterPage=new Waiter();
           waiterPage.setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    private void menuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuButtonActionPerformed
        DefaultListModel dlm=new DefaultListModel();
        DefaultListModel dlm2=new DefaultListModel();
        DefaultListModel dlm3=new DefaultListModel();
        DefaultListModel dlm4=new DefaultListModel();
        
        
        try
        {   
            //Connect to MySQL Menu table
            Connection conn=DriverManager.getConnection("jdbc:mysql://resturantdb.cul7akmhbeku.us-west-2.rds.amazonaws.com:3306/menudb","root","password");
      
            Statement st =conn.createStatement();
            ResultSet rs= st.executeQuery("select * from menu");
            
            //populate appetizer list
            while (rs.next())
            {
                if ("appetizer".equals(rs.getString(4)))
                {
                    dlm.addElement(rs.getString(1));
                }
            }
            
            //populate entree list
            rs= st.executeQuery("select * from menu");
            while (rs.next())
            {
                if ("entree".equals(rs.getString(4)))
                {
                    dlm2.addElement(rs.getString(1));
                }
            }
            
            //populate drink list
            rs= st.executeQuery("select * from menu");
            while(rs.next())
            {
                if ("drink".equals(rs.getString(4)))
                {
                    dlm3.addElement(rs.getString(1));
                }
            }
            
            //populate dessert list
            rs= st.executeQuery("select * from menu");
            while(rs.next())
            {
                if ("dessert".equals(rs.getString(4)))
                {
                    dlm4.addElement(rs.getString(1));
                }
            }
            
            appetizersList.setModel(dlm);
            entreesList.setModel(dlm2);
            drinksList.setModel(dlm3);
            dessertsList.setModel(dlm4);
        }catch (SQLException ex)
        {
            Logger.getLogger(orderMenu.class.getName()).log(Level.SEVERE,null,ex);
        }
    }//GEN-LAST:event_menuButtonActionPerformed
            DefaultListModel dlm=new DefaultListModel();
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
           
            //check to see what items have been selected and add to the order list
           if(appetizersList.isSelectionEmpty()==false)
           {    
               int[] indexes=appetizersList.getSelectedIndices();
               for (int i=0;i<indexes.length;++i)
               {    
                   ListModel model = appetizersList.getModel();
                   Object o=model.getElementAt(indexes[i]);
                   dlm.addElement(o);
               }
               
           }
           if (drinksList.isSelectionEmpty()==false)
           {    
               int[] indexes=drinksList.getSelectedIndices();
               for (int i=0;i<indexes.length;++i)
               {    
                   ListModel model = drinksList.getModel();
                   Object o=model.getElementAt(indexes[i]);
                   dlm.addElement(o);
               }
               
           }
           if (entreesList.isSelectionEmpty()==false)
           {
               int [] indexes=entreesList.getSelectedIndices();
               for (int i=0;i<indexes.length;++i)
               {
                   ListModel model=entreesList.getModel();
                   Object o=model.getElementAt(indexes[i]);
                   dlm.addElement(o);
               }
           }
           if (dessertsList.isSelectionEmpty()==false)
           {
               int [] indexes=dessertsList.getSelectedIndices();
               for (int i=0;i<indexes.length;++i)
               {
                   ListModel model=dessertsList.getModel();
                   Object o=model.getElementAt(indexes[i]);
                   dlm.addElement(o);
               }
           }
           
           
           orderList.setModel(dlm);
           
           appetizersList.clearSelection();
           drinksList.clearSelection();
           entreesList.clearSelection();
           dessertsList.clearSelection();
           
    }//GEN-LAST:event_addButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        dlm.removeElement(orderList.getSelectedValue());
        orderList.setModel(dlm);
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        for (int i=0;i<orderList.getModel().getSize();++i)
        {
            dlm.removeAllElements();
            orderList.setModel(dlm);
        }
    }//GEN-LAST:event_clearButtonActionPerformed

    private void submitOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitOrderActionPerformed
       try{
            int orderSize=dlm.getSize();
            
            if (orderSize==0)
            {
                JOptionPane.showMessageDialog(null,"Order is Empty");
                return;
            }
            
            ArrayList<String> orders=new ArrayList<String>();
            
            for (int i=0;i<orderSize;++i)
            {
                ListModel model=orderList.getModel();
                String entry=(String)model.getElementAt(i);
                orders.add(entry);
            }
            
            /*for (int i=0;i<orders.size();++i)
            {
            System.out.println(orders.get(i));
            }*/
            String completeOrder="";
            for (int i=0;i<orders.size();++i)
            {
                if (i!=orders.size()-1)
                {
                    completeOrder=completeOrder+orders.get(i)+",";
                }
                else
                {
                    completeOrder=completeOrder+orders.get(i)+";";
                }
                

                
            }
            // Connect to server and send the order
            Socket sock=new Socket("192.168.43.56",1995); //Host machine IP
            PrintStream PS=new PrintStream(sock.getOutputStream());
            PS.println(completeOrder);
            
            InputStreamReader IR = new InputStreamReader(sock.getInputStream());
            BufferedReader BR=new BufferedReader(IR);
            
            String message=BR.readLine();
            
            if (message!=null)
            {
                JOptionPane.showMessageDialog(null,"Order Submitted");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Order Failed");
            }
            
            dlm.removeAllElements();
            orderList.setModel(dlm);
        } catch (IOException ex) {
            Logger.getLogger(orderMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_submitOrderActionPerformed
    


private void displayPicture()
{   
    BufferedImage image;
    URL picURL=this.getClass().getResource("hamburger_by_mis3161.jpg");
   
    try{
   image=ImageIO.read(picURL);
   
   
    ImageIcon icon= new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(hamburgerPicture.getWidth(),hamburgerPicture.getHeight(),Image.SCALE_DEFAULT));
    hamburgerPicture.setIcon(icon);
    
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
            java.util.logging.Logger.getLogger(orderMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(orderMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(orderMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(orderMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new orderMenu().setVisible(true);
                
                
                


            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Appetizers;
    private javax.swing.JLabel Desserts;
    private javax.swing.JLabel Drinks;
    private javax.swing.JLabel Entrees;
    private javax.swing.JButton addButton;
    private javax.swing.JList<String> appetizersList;
    private javax.swing.JButton backButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JLabel currentOrder;
    private javax.swing.JButton deleteButton;
    private javax.swing.JList<String> dessertsList;
    private javax.swing.JList<String> drinksList;
    private javax.swing.JList<String> entreesList;
    private javax.swing.JLabel hamburgerPicture;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JButton menuButton;
    private javax.swing.JList<String> orderList;
    private javax.swing.JButton submitOrder;
    // End of variables declaration//GEN-END:variables
}
