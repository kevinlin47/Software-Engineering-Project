/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resturantautomation;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author kevinlin
 */
public class Tables extends javax.swing.JFrame {

    /**
     * Creates new form Tables
     */
    String statusTableOne="";
    String statusTableTwo="";
    String statusTableThree="";
    String statusTableFour="";
    String statusTableFive="";
    String statusTableSix="";
    
    Timer timer=new Timer();
    TimerTask task=new TimerTask()
    {
        public void run()
        {
          
                checkUpdates();

        }
    };
    
    public Tables() {
        initComponents();
        timer.scheduleAtFixedRate(task, 1000, 15000);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tableOne = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tableOneStatus = new javax.swing.JComboBox<>();
        tableTwo = new javax.swing.JLabel();
        tableTwoStatus = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        tableThree = new javax.swing.JLabel();
        tableThreeStatus = new javax.swing.JComboBox<>();
        tableFour = new javax.swing.JLabel();
        tableFourStatus = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableOne.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        tableOne.setForeground(new java.awt.Color(255, 255, 255));
        tableOne.setOpaque(true);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel1.setText("Table 1");

        tableOneStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No Selection", "Dirty", "Free", "Occupied" }));
        tableOneStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tableOneStatusActionPerformed(evt);
            }
        });

        tableTwo.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        tableTwo.setForeground(new java.awt.Color(255, 255, 255));
        tableTwo.setOpaque(true);

        tableTwoStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No Selection", "Dirty", "Free", "Occupied" }));

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel2.setText("Table 2");

        tableThree.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        tableThree.setForeground(new java.awt.Color(255, 255, 255));
        tableThree.setOpaque(true);

        tableThreeStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No Selection", "Dirty", "Free", "Occupied" }));

        tableFour.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        tableFour.setForeground(new java.awt.Color(255, 255, 255));
        tableFour.setOpaque(true);

        tableFourStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No Selection", "Dirty", "Free", "Occupied" }));

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel3.setText("Table 3");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel4.setText("Table 4");

        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tableThree, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tableOne, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tableOneStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tableThreeStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel3))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(tableFour, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                .addComponent(tableTwo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tableTwoStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tableFourStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(backButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(submitButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tableTwoStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(tableOne, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tableOneStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tableTwo, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(tableThree, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tableThreeStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tableFour, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
                    .addComponent(tableFourStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(submitButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backButton)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableOneStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tableOneStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tableOneStatusActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        this.dispose();
        Waiter waiter=new Waiter();
        waiter.setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        
        //Check Table One Selection
        statusTableOne=tableOneStatus.getSelectedItem().toString();
        
        if (!statusTableOne.equals("No Selection"))
        {
            try{
            Connection conn=DriverManager.getConnection("jdbc:mysql://resturantdb.cul7akmhbeku.us-west-2.rds.amazonaws.com:3306/tabledb","root","password");
            Statement st =conn.createStatement();
            ResultSet rs= st.executeQuery("select * from tablestatus");
            
            String sqlStatement="UPDATE `tabledb`.`tablestatus` SET `status`='"+statusTableOne+"' WHERE `idtable`='1'";;
            st.executeUpdate(sqlStatement);
            } catch (SQLException ex)
            {
                Logger.getLogger(editItem.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
        
        //Check Table Two Selection
        statusTableTwo=tableTwoStatus.getSelectedItem().toString();
        
        if (!statusTableTwo.equals("No Selection"))
        {
            try{
            Connection conn=DriverManager.getConnection("jdbc:mysql://resturantdb.cul7akmhbeku.us-west-2.rds.amazonaws.com:3306/tabledb","root","password");
            Statement st =conn.createStatement();
            ResultSet rs= st.executeQuery("select * from tablestatus");
            
            String sqlStatement="UPDATE `tabledb`.`tablestatus` SET `status`='"+statusTableTwo+"' WHERE `idtable`='2'";;
            st.executeUpdate(sqlStatement);
            } catch (SQLException ex)
            {
                Logger.getLogger(editItem.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
        
        //Check Table Three Selection
        statusTableThree=tableThreeStatus.getSelectedItem().toString();
        
        if (!statusTableThree.equals("No Selection"))
        {
            try{
            Connection conn=DriverManager.getConnection("jdbc:mysql://resturantdb.cul7akmhbeku.us-west-2.rds.amazonaws.com:3306/tabledb","root","password");
            Statement st =conn.createStatement();
            ResultSet rs= st.executeQuery("select * from tablestatus");
            
            String sqlStatement="UPDATE `tabledb`.`tablestatus` SET `status`='"+statusTableThree+"' WHERE `idtable`='3'";;
            st.executeUpdate(sqlStatement);
            } catch (SQLException ex)
            {
                Logger.getLogger(editItem.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
        
        //Check Table Four Selection
        statusTableFour=tableFourStatus.getSelectedItem().toString();
        
        if (!statusTableFour.equals("No Selection"))
        {
            try{
            Connection conn=DriverManager.getConnection("jdbc:mysql://resturantdb.cul7akmhbeku.us-west-2.rds.amazonaws.com:3306/tabledb","root","password");
            Statement st =conn.createStatement();
            ResultSet rs= st.executeQuery("select * from tablestatus");
            
            String sqlStatement="UPDATE `tabledb`.`tablestatus` SET `status`='"+statusTableFour+"' WHERE `idtable`='4'";;
            st.executeUpdate(sqlStatement);
            } catch (SQLException ex)
            {   
                displayError();
                Logger.getLogger(editItem.class.getName()).log(Level.SEVERE,null,ex);
                
            }
        }
        
        if(statusTableOne.equals("No Selection")&&statusTableTwo.equals("No Selection")&&statusTableThree.equals("No Selection")&&statusTableFour.equals("No Selection"))
        {
            JOptionPane.showMessageDialog(null,"No Selection");
        }
        else
        {   
            tableOneStatus.setSelectedIndex(0);
            tableTwoStatus.setSelectedIndex(0);
            tableThreeStatus.setSelectedIndex(0);
            tableFourStatus.setSelectedIndex(0);
            
            displayMessage();
        }
        
        
        
    }//GEN-LAST:event_submitButtonActionPerformed
    
    private void displayError()
    {
        JOptionPane.showMessageDialog(null,"Failed to update");
    }
    
    private void displayMessage()
    {
        JOptionPane.showMessageDialog(null,"Updated Successfully");
    }
    
    private void checkUpdates()
    {
        try{
            Connection conn=DriverManager.getConnection("jdbc:mysql://resturantdb.cul7akmhbeku.us-west-2.rds.amazonaws.com:3306/tabledb","root","password");
            Statement st =conn.createStatement();
            ResultSet rs= st.executeQuery("select * from tablestatus");
            
                rs.next();
                statusTableOne=rs.getString(2);
                rs.next();
                statusTableTwo=rs.getString(2);
                rs.next();
                statusTableThree=rs.getString(2);
                rs.next();
                statusTableFour=rs.getString(2);
                
              
                //table one status
                if (statusTableOne.equals("Free"))
                {
                    tableOne.setText("  Free");
                    tableOne.setBackground(Color.green);
                }
                else if (statusTableOne.equals("Dirty"))
                {
                    tableOne.setText("  Dirty");
                    tableOne.setBackground(Color.black);
                }
                else if (statusTableOne.equals("Occupied"))
                {
                    tableOne.setText("  Occupied");
                    tableOne.setBackground(Color.red);
                }
                
                //table two status
                if (statusTableTwo.equals("Free"))
                {
                    tableTwo.setText("  Free");
                    tableTwo.setBackground(Color.green);
                }
                else if (statusTableTwo.equals("Dirty"))
                {
                    tableTwo.setText("  Dirty");
                    tableTwo.setBackground(Color.black);
                }
                else if (statusTableTwo.equals("Occupied"))
                {
                    tableTwo.setText("  Occupied");
                    tableTwo.setBackground(Color.red);
                }
                
                //table three status
                if (statusTableThree.equals("Free"))
                {
                    tableThree.setText("  Free");
                    tableThree.setBackground(Color.green);
                }
                else if (statusTableThree.equals("Dirty"))
                {
                    tableThree.setText("  Dirty");
                    tableThree.setBackground(Color.black);
                }
                else if (statusTableThree.equals("Occupied"))
                {
                    tableThree.setText("  Occupied");
                    tableThree.setBackground(Color.red);
                }
                
                //table four status
                if (statusTableFour.equals("Free"))
                {
                    tableFour.setText("  Free");
                    tableFour.setBackground(Color.green);
                }
                else if (statusTableFour.equals("Dirty"))
                {
                    tableFour.setText("  Dirty");
                    tableFour.setBackground(Color.black);
                }
                else if (statusTableFour.equals("Occupied"))
                {
                    tableFour.setText("  Occupied");
                    tableFour.setBackground(Color.red);
                }
                
        } catch(SQLException ex)
        {
            Logger.getLogger(editItem.class.getName()).log(Level.SEVERE,null,ex);
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
            java.util.logging.Logger.getLogger(Tables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tables().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton submitButton;
    private javax.swing.JLabel tableFour;
    private javax.swing.JComboBox<String> tableFourStatus;
    private javax.swing.JLabel tableOne;
    private javax.swing.JComboBox<String> tableOneStatus;
    private javax.swing.JLabel tableThree;
    private javax.swing.JComboBox<String> tableThreeStatus;
    private javax.swing.JLabel tableTwo;
    private javax.swing.JComboBox<String> tableTwoStatus;
    // End of variables declaration//GEN-END:variables
}
