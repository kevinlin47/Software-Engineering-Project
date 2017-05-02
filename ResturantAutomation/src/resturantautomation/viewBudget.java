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

import java.text.DecimalFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author kimberlyngai
 */
public class viewBudget extends javax.swing.JFrame {

    /**
     * Creates new form viewBugdet
     */
                
    DefaultTableModel dm;
    
    public viewBudget() 
    {
        initComponents();
        setTable();  
        getData(); 
    }
    
    private void setTable()
    {
        dm = new DefaultTableModel(0, 0);  
        String s[] = new String[]{"Type of Expense", "Amount Budgeted", "Amount Spent", "Amount Remaining"};  
        dm.setColumnIdentifiers(s);  
        jTable1.setModel(dm);  
    }
    
    private void getData()
    {
        boolean success=false;
        boolean overspent = false;
        
        String budgetName;
        Double amountB, amountS, amountR;
            
        try{
            Connection conn=DriverManager.getConnection("jdbc:mysql://resturantdb.cul7akmhbeku.us-west-2.rds.amazonaws.com:3306/budgetDB","root","password");
                  
            Statement st =conn.createStatement();
                        
            ResultSet rs = st.executeQuery("SELECT * FROM budgetTable");
            
            while (rs.next())
            {
                String bName = rs.getString(1);
                String aB = rs.getString(2);
                String aS = rs.getString(3);
                String aR = rs.getString(4);
                Double amR = rs.getDouble(4);
                
                if (amR < 0)
                {
                    overspent = true;
                }
                
                Vector <Object> v = new Vector<Object>();
                
                v.add(bName);
                v.add(aB);
                v.add(aS);
                v.add(aR);
                
                dm.addRow(v);
                //System.out.println("hi");
            }
            success=true;
        }catch (SQLException ex)
        {   
            success=false;
            Logger.getLogger(addItem.class.getName()).log(Level.SEVERE,null,ex);
        }
        if (overspent == true)
        {
            JOptionPane.showMessageDialog(null, "Expense is spending over allocated budget!", "ATTENTION", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        returnButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        budgetTitle = new javax.swing.JLabel();
        amtField = new javax.swing.JTextField();
        sptField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        expensePane = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        editButton = new javax.swing.JButton();
        showPosSpend = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 380));

        returnButton.setText("Return");
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Type of Expense", "Amount Budgeted", "Amount Spent", "Amount Remaining"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectItem(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        budgetTitle.setFont(new java.awt.Font("Lucida Grande", 1, 20)); // NOI18N
        budgetTitle.setText("Budget");

        jScrollPane2.setViewportView(expensePane);

        jLabel1.setText("Expense");

        jLabel2.setText("Amount Budgeted");

        jLabel3.setText("Amount Spent");

        editButton.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        editButton.setText("Confirm Changes");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        showPosSpend.setText("Show Possible Expense Spending");
        showPosSpend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPosSpendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(returnButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(showPosSpend)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 491, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sptField, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(amtField, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(349, 349, 349))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(editButton)
                                .addGap(331, 331, 331))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(budgetTitle)
                                .addGap(384, 384, 384))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(budgetTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(amtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sptField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(editButton)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(returnButton)
                    .addComponent(showPosSpend))
                .addGap(421, 421, 421))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //BACK BUTTON
    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
     Manager managePage = new Manager();
        managePage.setVisible(true);
        this.setVisible(false);
            // TODO add your handling code here:
    }//GEN-LAST:event_returnButtonActionPerformed

    String itemName;
    
    private void selectItem(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectItem
        // TODO add your handling code here:
        expensePane.setText(String.valueOf(dm.getValueAt(jTable1.getSelectedRow(), 0)));
        amtField.setText(String.valueOf(dm.getValueAt(jTable1.getSelectedRow(), 1)));
        sptField.setText(String.valueOf(dm.getValueAt(jTable1.getSelectedRow(), 2)));
        
        expensePane.setEditable(false);
        
        itemName = expensePane.getText();
    }//GEN-LAST:event_selectItem

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
        
        dm.setValueAt(amtField.getText(), jTable1.getSelectedRow(), 1);
        dm.setValueAt(sptField.getText(), jTable1.getSelectedRow(), 2);
        
        DecimalFormat df = new DecimalFormat("0.00");
        
        Double newAmt = Double.parseDouble(amtField.getText());
        Double newSpt = Double.parseDouble(sptField.getText());
        Double newRn = newAmt - newSpt;
        
        String newRmn = df.format(newRn);
        
        //based on expense name, the SQL will update values corresponding to it
        if (itemName.equals("Food"))
        {
            dm.setValueAt(newRmn, jTable1.getSelectedRow(), 3);
            
            boolean success=false;
        
            try{
                Connection conn=DriverManager.getConnection("jdbc:mysql://resturantdb.cul7akmhbeku.us-west-2.rds.amazonaws.com:3306/budgetDB","root","password");

                Statement st =conn.createStatement();
                String sqlStatment = "UPDATE budgetTable SET AmountBudgeted = " +newAmt+ ", AmountSpent = " +newSpt+ ", AmountRemaining = " +newRn+ " WHERE TypeOfExpense = '" +itemName+ "'";
                st.executeUpdate(sqlStatment);
                success=true;
            }catch (SQLException ex)
            {   
                success=false;
                Logger.getLogger(addItem.class.getName()).log(Level.SEVERE,null,ex);
            }

            if (success==true)
            {
                JOptionPane.showMessageDialog(null, "Update successful.");
            }
            
            else if (success==false)
            {
                JOptionPane.showMessageDialog(null, "Error.", null, JOptionPane.ERROR_MESSAGE);
            }
        }
        
        else if (itemName.equals("Employees"))
        {
            dm.setValueAt(newRmn, jTable1.getSelectedRow(), 3);
            
            boolean success=false;
        
            try{
                Connection conn=DriverManager.getConnection("jdbc:mysql://resturantdb.cul7akmhbeku.us-west-2.rds.amazonaws.com:3306/budgetDB","root","password");

                Statement st =conn.createStatement();
                String sqlStatment = "UPDATE budgetTable SET AmountBudgeted = " +newAmt+ ", AmountSpent = " +newSpt+ ", AmountRemaining = " +newRn+ " WHERE TypeOfExpense = '" +itemName+ "'";
                st.executeUpdate(sqlStatment);
                success=true;
            }catch (SQLException ex)
            {   
                success=false;
                Logger.getLogger(addItem.class.getName()).log(Level.SEVERE,null,ex);
            }

            if (success==true)
            {
                JOptionPane.showMessageDialog(null, "Update successful.");
            }
            
            else if (success==false)
            {
                JOptionPane.showMessageDialog(null, "Error.", null, JOptionPane.ERROR_MESSAGE);
            }
        }
        
        else if (itemName.equals("Maintenance"))
        {
            dm.setValueAt(newRmn, jTable1.getSelectedRow(), 3);
            
            boolean success=false;
        
            try{
                Connection conn=DriverManager.getConnection("jdbc:mysql://resturantdb.cul7akmhbeku.us-west-2.rds.amazonaws.com:3306/budgetDB","root","password");

                Statement st =conn.createStatement();
                String sqlStatment = "UPDATE budgetTable SET AmountBudgeted = " +newAmt+ ", AmountSpent = " +newSpt+ ", AmountRemaining = " +newRn+ " WHERE TypeOfExpense = '" +itemName+ "'";
                st.executeUpdate(sqlStatment);
                success=true;
            }catch (SQLException ex)
            {   
                success=false;
                Logger.getLogger(addItem.class.getName()).log(Level.SEVERE,null,ex);
            }

            if (success==true)
            {
                JOptionPane.showMessageDialog(null, "Update successful.");
            }
            
            else if (success==false)
            {
                JOptionPane.showMessageDialog(null, "Error.", null, JOptionPane.ERROR_MESSAGE);
            }
        }
        
        else if (itemName.equals("Rent"))
        {
            dm.setValueAt(newRmn, jTable1.getSelectedRow(), 3);
            
            boolean success=false;
        
            try{
                Connection conn=DriverManager.getConnection("jdbc:mysql://resturantdb.cul7akmhbeku.us-west-2.rds.amazonaws.com:3306/budgetDB","root","password");

                Statement st =conn.createStatement();
                String sqlStatment = "UPDATE budgetTable SET AmountBudgeted = " +newAmt+ ", AmountSpent = " +newSpt+ ", AmountRemaining = " +newRn+ " WHERE TypeOfExpense = '" +itemName+ "'";
                st.executeUpdate(sqlStatment);
                success=true;
            }catch (SQLException ex)
            {   
                success=false;
                Logger.getLogger(addItem.class.getName()).log(Level.SEVERE,null,ex);
            }

            if (success==true)
            {
                JOptionPane.showMessageDialog(null, "Update successful.");
            }
            
            else if (success==false)
            {
                JOptionPane.showMessageDialog(null, "Error.", null, JOptionPane.ERROR_MESSAGE);
            }
        }
        
        else
        {
            dm.setValueAt(newRmn, jTable1.getSelectedRow(), 3);
            
            boolean success=false;
        
            try{
                Connection conn=DriverManager.getConnection("jdbc:mysql://resturantdb.cul7akmhbeku.us-west-2.rds.amazonaws.com:3306/budgetDB","root","password");

                Statement st =conn.createStatement();
                String sqlStatment = "UPDATE budgetTable SET AmountBudgeted = " +newAmt+ ", AmountSpent = " +newSpt+ ", AmountRemaining = " +newRn+ " WHERE TypeOfExpense = '" +itemName+ "'";
                st.executeUpdate(sqlStatment);
                success=true;
            }catch (SQLException ex)
            {   
                success=false;
                Logger.getLogger(addItem.class.getName()).log(Level.SEVERE,null,ex);
            }

            if (success==true)
            {
                JOptionPane.showMessageDialog(null, "Update successful. Click on 'Refresh' Button to see changes.");
            }
            
            else if (success==false)
            {
                JOptionPane.showMessageDialog(null, "Error.", null, JOptionPane.ERROR_MESSAGE);
            }
        }
        if (newRn < 0)
        {
            JOptionPane.showMessageDialog(null, "Expense is spending over allocated budget!", "ATTENTION", JOptionPane.ERROR_MESSAGE);
        }
        //setTable();
        //getData();
    }//GEN-LAST:event_editButtonActionPerformed

    private void showPosSpendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPosSpendActionPerformed
        // TODO add your handling code here:
        expenseSpending exSp = new expenseSpending();
        exSp.setVisible(true);
    }//GEN-LAST:event_showPosSpendActionPerformed

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
            java.util.logging.Logger.getLogger(viewBudget.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewBudget.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewBudget.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewBudget.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //food, employee, maintenance, rent, other
        //String[] budgetItems = new String[5];
        //Double[] budgetAmount = new Double[5];
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewBudget().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amtField;
    private javax.swing.JLabel budgetTitle;
    private javax.swing.JButton editButton;
    private javax.swing.JTextPane expensePane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton returnButton;
    private javax.swing.JButton showPosSpend;
    private javax.swing.JTextField sptField;
    // End of variables declaration//GEN-END:variables
}
