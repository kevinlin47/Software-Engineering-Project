/*
Author:
Kimberly Ngai
Katie Bruett
 */
package resturantautomation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

/**
 *
 * @author kimberlyngai
 */
public class addEmployee extends javax.swing.JFrame {

    /**
     * Creates new form addEmployee
     */
    public addEmployee() {
        initComponents();
        HRTextField.setText("8.50");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cancelButton = new javax.swing.JButton();
        emID = new javax.swing.JLabel();
        emFName = new javax.swing.JLabel();
        emLName = new javax.swing.JLabel();
        emJobT = new javax.swing.JLabel();
        emHrR = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        IDTextField = new javax.swing.JTextField();
        FNTextField = new javax.swing.JTextField();
        LNTextField = new javax.swing.JTextField();
        JTComboBox = new javax.swing.JComboBox<>();
        HRTextField = new javax.swing.JTextField();
        submitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        emID.setText("Employee ID:");

        emFName.setText("First Name:");

        emLName.setText("Last Name:");

        emJobT.setText("Job Title:");

        emHrR.setText("Hourly Rate:");

        title.setFont(new java.awt.Font("Lucida Grande", 1, 20)); // NOI18N
        title.setText("Add Employee");

        JTComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Waiter", "Chef", "Manager" }));
        JTComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTComboBoxActionPerformed(evt);
            }
        });

        submitButton.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(title)
                .addGap(124, 124, 124))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cancelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(submitButton)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(LNTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(112, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emLName)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(emFName)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(FNTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(emID)
                            .addGap(18, 18, 18)
                            .addComponent(IDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(emJobT)
                            .addGap(18, 18, 18)
                            .addComponent(JTComboBox, 0, 1, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(emHrR)
                            .addGap(18, 18, 18)
                            .addComponent(HRTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(105, 105, 105))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emID)
                    .addComponent(IDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FNTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emFName))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emLName)
                    .addComponent(LNTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emJobT)
                    .addComponent(JTComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emHrR)
                    .addComponent(HRTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(submitButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // TODO add your handling code here:
        try {
            Integer.parseInt(IDTextField.getText());
        }catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "ID not a number", null, JOptionPane.ERROR_MESSAGE);
        }
        
        try {
            Double.parseDouble(HRTextField.getText());
        }catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "Hourly Rate not valid.", null, JOptionPane.ERROR_MESSAGE);           
        }
        
        int empID = Integer.parseInt(IDTextField.getText());
        String empFName = FNTextField.getText();
        String empLName = LNTextField.getText();
        String jobT = JTComboBox.getItemAt(JTComboBox.getSelectedIndex());
        Double hrRate = Double.parseDouble(HRTextField.getText());
        
        boolean dupe = false;
        boolean success = false;
        
        try {
            Connection conn=DriverManager.getConnection("jdbc:mysql://resturantdb.cul7akmhbeku.us-west-2.rds.amazonaws.com:3306/employeeDB","root","password");
                  
            Statement st =conn.createStatement();
            Statement st1 = conn.createStatement();
                        
            ResultSet rs = st.executeQuery("SELECT * FROM employeeRecords");
            
            System.out.println("b4 select");
            while (rs.next())
            {
                //check for existing ID or person
                if (rs.getInt(1) == empID || (rs.getString(2).equals(empLName) && rs.getString(3).equals(empFName)))
                {
                    dupe = true; 
                }
            }
            System.out.println("after select");
            
            if (dupe == false)
            {
                System.out.println("b4 insert");
               String sqlStatement = "INSERT INTO employeeDB.employeeRecords VALUES ('"+empID+"', '"+empLName+"', '"+empFName+"', '"+jobT+"', "+hrRate+", null, null, 0.00, 0.00, 0.00, 0.00, null, 0.00)";
               st1.executeUpdate(sqlStatement); 
               //Connection conn1=DriverManager.getConnection("jdbc:mysql://resturantdb.cul7akmhbeku.us-west-2.rds.amazonaws.com:3306/budgetDB","root","password");

               
               success = true;
            }
            System.out.println("after insert");
            
        }catch (SQLException ex)
        {
            success = false;
            Logger.getLogger(addItem.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        if (success == true)
        {
            JOptionPane.showMessageDialog(null, "Employee added. Refresh Employee List to see change.");
            this.setVisible(false);
        }
        
        if (dupe == true)
        {
            JOptionPane.showMessageDialog(null, "ID or employee already exists!", null, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    private void JTComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTComboBoxActionPerformed
        // TODO add your handling code here:
        String jobT = JTComboBox.getItemAt(JTComboBox.getSelectedIndex());
        Double hrRate;
        String hR;
        switch (jobT)
        {
            case "Waiter":
                hrRate = 8.50;
                hR = "8.50";
                break;
            case "Chef":
                hrRate = 14.50;
                hR = "14.50";
                break;
            default:
                hrRate = 20.00;
                hR = "20.00";
        }
        HRTextField.setText(hR);
    }//GEN-LAST:event_JTComboBoxActionPerformed

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
            java.util.logging.Logger.getLogger(addEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addEmployee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField FNTextField;
    private javax.swing.JTextField HRTextField;
    private javax.swing.JTextField IDTextField;
    private javax.swing.JComboBox<String> JTComboBox;
    private javax.swing.JTextField LNTextField;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel emFName;
    private javax.swing.JLabel emHrR;
    private javax.swing.JLabel emID;
    private javax.swing.JLabel emJobT;
    private javax.swing.JLabel emLName;
    private javax.swing.JButton submitButton;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
