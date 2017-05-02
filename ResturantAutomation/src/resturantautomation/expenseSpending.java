/*
Author:
Kimberly Ngai
Katie Bruett
 */
package resturantautomation;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.text.DecimalFormat;
import java.math.*;
import java.lang.Number;

/**
 *
 * @author kimberlyngai
 */
public class expenseSpending extends javax.swing.JFrame {

    /**
     * Creates new form expenseSpending
     */
    ArrayList<Double> amountRmn = new ArrayList<Double>();

    ArrayList<String> ingredName = new ArrayList<String>();
    ArrayList<Integer> ingredQuant = new ArrayList<Integer>();
    ArrayList<Double> ingredCost = new ArrayList<Double>();
    Double c;
    String cost;
    ArrayList<Double> totalIngredCost = new ArrayList<Double>();

    ArrayList<String> empName = new ArrayList<String>();
    ArrayList<String> empJob = new ArrayList<String>();
    ArrayList<Double> empRate = new ArrayList<Double>();
    
    DecimalFormat df = new DecimalFormat("0.00");
    
    public expenseSpending() {
        initComponents();
        jLabel2.setVisible(false);
        jComboBox2.setVisible(false);
        jLabel3.setVisible(false);
        getValues();
        updateOptions();
        updateOptions2();
        updateLabel3();
    }
    
    private void getValues()
    {
        try {
            //access budget database to get remaining budgets
            Connection conn=DriverManager.getConnection("jdbc:mysql://resturantdb.cul7akmhbeku.us-west-2.rds.amazonaws.com:3306/budgetDB","root","password");                  
            Statement st =conn.createStatement();
            Statement st1 = conn.createStatement();                       
            ResultSet rs = st.executeQuery("SELECT AmountRemaining FROM budgetTable");                        
            while (rs.next())
            {
                amountRmn.add(rs.getDouble(1));
            }
            
            //access menu database to get ingredient data
            conn = DriverManager.getConnection("jdbc:mysql://resturantdb.cul7akmhbeku.us-west-2.rds.amazonaws.com:3306/menudb","root","password");
            String sqlStatement = "SELECT * FROM ingredients";
            st =conn.createStatement();
            rs = st.executeQuery(sqlStatement);
            while (rs.next())
            {
                ingredName.add(rs.getString(1));
                ingredQuant.add(rs.getInt(2));
                ingredCost.add(rs.getDouble(3));
            }
            
            //access employee database to get employee info
            conn = DriverManager.getConnection("jdbc:mysql://resturantdb.cul7akmhbeku.us-west-2.rds.amazonaws.com:3306/employeeDB","root","password");
            sqlStatement = "SELECT * FROM employeeRecords";
            st =conn.createStatement();
            rs = st.executeQuery(sqlStatement);
            while (rs.next())
            {
                empName.add(rs.getString(3));
                empJob.add(rs.getString(4));
                empRate.add(rs.getDouble(5));
            }
            
        }catch (SQLException ex)
        {
            //success = false;
            Logger.getLogger(addItem.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    private void updateOptions()
    {
        String choice = expenseBox.getItemAt(expenseBox.getSelectedIndex());
        spendingText.setText("Remaining Amount of Money: $" +df.format(amountRmn.get(expenseBox.getSelectedIndex())));
        //0: food; 1: employees; 2: maintenance; 3: rent; 4: other        
        
        switch (choice)
        {
            case "Food": //0
                jComboBox1.removeAllItems();                
                
                if(amountRmn.get(0) > 0)
                {
                    jComboBox1.addItem("buy new ingredients");
                    jComboBox1.addItem("allocate extra money to another expense");
                }
                                
                jComboBox1.addItem("make no changes");
                break;
                
            case "Employees": //1
                jComboBox1.removeAllItems();
                
                if(amountRmn.get(1) > 0)
                {
                    jComboBox1.addItem("hire a new employee");
                    jComboBox1.addItem("give a raise");
                    jComboBox1.addItem("give a bonus");
                    jComboBox1.addItem("allocate extra money to another expense");
                }
                
                jComboBox1.addItem("make no changes");
                break;
                
            case "Maintenance": //2
                jComboBox1.removeAllItems();
                
                if(amountRmn.get(2) > 0)
                {
                    jComboBox1.addItem("allocate extra money to another expense");
                }
                
                jComboBox1.addItem("make no changes");
                break;
            case "Rent": //3
                jComboBox1.removeAllItems();
                
                if(amountRmn.get(3) > 0)
                {
                    jComboBox1.addItem("allocate extra money to another expense");
                }
                
                jComboBox1.addItem("make no changes");
                break;
                
            default: //4
                jComboBox1.removeAllItems();
                
                if(amountRmn.get(4) > 0)
                {
                    jComboBox1.addItem("buy new equipment");
                    jComboBox1.addItem("allocate extra money to another expense");
                }
                
                jComboBox1.addItem("make no changes");
        }
    }
    
    private void updateOptions2()
    {
        int n = jComboBox1.getItemCount();
        
        if (n > 1)
        {
            jLabel2.setVisible(true);
            jComboBox2.setVisible(true);
            //jComboBox2.removeAllItems();
            int boxIndex = jComboBox1.getSelectedIndex();
            
            //0=food; 1=employees; 2=maintenance; 3=rent; 4=other
            int expIndex = expenseBox.getSelectedIndex();
            switch (expIndex)
            {
                //food
                case 0: //0=buy new ingredients; 1=allocate; 2=no changes
                    switch(boxIndex)
                    {
                        case 0:
                            jComboBox2.removeAllItems();
                            for (int i = 0; i < ingredName.size(); i++)
                            {
                                Double q = Math.floor(amountRmn.get(0)/ingredCost.get(i));
                                int quant = q.intValue();
                                //cost = df.format(amo(quant*ingredCost.get(i)));
                                c = quant * ingredCost.get(i);
                                totalIngredCost.add(c);
                                //System.out.println(quant);
                                //System.out.println(ingredCost.get(i));
                                //System.out.println(quant*ingredCost.get(i));
                                jComboBox2.addItem("buying a maximum of "+quant+" " +ingredName.get(i)+"(s) for $"+df.format(c));
                            }
                            break;
                        case 1:
                            jComboBox2.removeAllItems();
                            for (int i = 0; i < amountRmn.size(); i++)
                            {
                                if (amountRmn.get(i) <= 0 && i != expIndex)
                                {
                                    switch (i)
                                    {
                                        case 0:
                                            jComboBox2.addItem("allocating money to Food");
                                            break;
                                        case 1:
                                            jComboBox2.addItem("allocating money to Employees");
                                            break;
                                        case 2:
                                            jComboBox2.addItem("allocating money to Maintenance");
                                            break;
                                        case 3:
                                            jComboBox2.addItem("allocating money to Rent");
                                            break;
                                        case 4:
                                            jComboBox2.addItem("allocating money to Other");
                                            break;
                                    }
                                    //jComboBox2.addItem("allocating money to ");
                                }
                            }
                            break;
                        default:
                            jComboBox2.removeAllItems();
                            jLabel2.setVisible(false);
                            jComboBox2.setVisible(false);
                            break;
                    }
                    break;
                //employees    
                case 1:
                    switch(boxIndex)
                    {
                        case 0: //hire new employee
                            jComboBox2.removeAllItems();
                            Double dum = Math.floor(amountRmn.get(expIndex)/40);
                            if (dum >= 20)
                            {
                                jComboBox2.addItem("hiring a new full-time/part-time manager");
                                jComboBox2.addItem("hiring a new full-time/part-time chef");
                                jComboBox2.addItem("hiring a new full-time/part-time waiter");
                            }
                            else if (dum >=14.50)
                            {
                                jComboBox2.addItem("hiring a new part-time manager");
                                jComboBox2.addItem("hiring a new full-time/part-time chef");
                                jComboBox2.addItem("hiring a new full-time/part-time waiter");
                            }
                            else if (dum >= 8.50)
                            {
                                jComboBox2.addItem("hiring a new part-time manager");
                                jComboBox2.addItem("hiring a new part-time chef");
                                jComboBox2.addItem("hiring a new full-time/part-time waiter");
                            }
                            
                            else
                            {
                                jComboBox2.addItem("hiring a temporary waiter");
                            }
                            
                            break;
                        case 1: //give raise
                            jComboBox2.removeAllItems();
                            dum = Math.floor(amountRmn.get(expIndex)/(8.5*1.03));
                            Double dum1 = Math.floor(amountRmn.get(expIndex)/(14.5*1.03));
                            Double dum2 = Math.floor(amountRmn.get(expIndex)/(20*1.03));
                            
                            if (dum >=1)
                            {
                                jComboBox2.addItem("giving maximum of "+dum.intValue()+ " waiter(s) a 3% raise.");
                            }
                            
                            else
                            {
                                jLabel2.setVisible(false);
                                jComboBox2.setVisible(false);
                            }
                            
                            if (dum1 >= 1)
                            {
                                jComboBox2.addItem("giving maximum of "+dum1.intValue()+ " chef(s) a 3% raise.");
                            }
                            
                            if (dum2 >= 1)
                            {
                                jComboBox2.addItem("giving a maximum of "+dum2.intValue()+ " managers(s) a 3% raise.");
                            }
                            
                            break;
                        case 2: //give bonus
                            jComboBox2.removeAllItems();
                            dum = Math.floor(amountRmn.get(expIndex)/150);
                            int d = dum.intValue();
                            if (dum >= 1)
                            {
                                jComboBox2.addItem("giving "+d+" employee(s) the usual bonus of $150.00");
                            }
                            else
                            {
                                //jComboBox2.removeAllItems();
                                jLabel2.setVisible(false);
                                jComboBox2.setVisible(false);
                            }
                            break;
                        case 3: //allocate
                            jComboBox2.removeAllItems();
                            for (int i = 0; i < amountRmn.size(); i++)
                            {
                                if (amountRmn.get(i) <= 0 && i != expIndex)
                                {
                                    switch (i)
                                    {
                                        case 0:
                                            jComboBox2.addItem("allocating money to Food");
                                            break;
                                        case 1:
                                            jComboBox2.addItem("allocating money to Employees");
                                            break;
                                        case 2:
                                            jComboBox2.addItem("allocating money to Maintenance");
                                            break;
                                        case 3:
                                            jComboBox2.addItem("allocating money to Rent");
                                            break;
                                        case 4:
                                            jComboBox2.addItem("allocating money to Other");
                                            break;
                                    }
                                }
                            }
                            break;
                        default:
                            jComboBox2.removeAllItems();
                            jLabel2.setVisible(false);
                            jComboBox2.setVisible(false);
                            break;
                    }
                    break;
                //maintenance
                case 2:
                    jComboBox2.removeAllItems();
                    switch (boxIndex)
                    {
                        case 0:
                            jComboBox2.removeAllItems();
                            for (int i = 0; i < amountRmn.size(); i++)
                            {
                                if (amountRmn.get(i) <= 0 && i != expIndex)
                                {
                                    switch (i)
                                    {
                                        case 0:
                                            jComboBox2.addItem("allocating money to Food");
                                            break;
                                        case 1:
                                            jComboBox2.addItem("allocating money to Employees");
                                            break;
                                        case 2:
                                            jComboBox2.addItem("allocating money to Maintenance");
                                            break;
                                        case 3:
                                            jComboBox2.addItem("allocating money to Rent");
                                            break;
                                        case 4:
                                            jComboBox2.addItem("allocating money to Other");
                                            break;
                                    }
                                    //jComboBox2.addItem("allocating money to ");
                                }
                            }
                            break;
                        default:
                            jComboBox2.removeAllItems();
                            jLabel2.setVisible(false);
                            jComboBox2.setVisible(false);
                            break;
                    }
                    break;
                //rent
                case 3:
                    jComboBox2.removeAllItems();
                    switch (boxIndex)
                    {
                        case 0:
                            jComboBox2.removeAllItems();
                            for (int i = 0; i < amountRmn.size(); i++)
                            {
                                if (amountRmn.get(i) <= 0 && i != expIndex)
                                {
                                    switch (i)
                                    {
                                        case 0:
                                            jComboBox2.addItem("allocating money to Food");
                                            break;
                                        case 1:
                                            jComboBox2.addItem("allocating money to Employees");
                                            break;
                                        case 2:
                                            jComboBox2.addItem("allocating money to Maintenance");
                                            break;
                                        case 3:
                                            jComboBox2.addItem("allocating money to Rent");
                                            break;
                                        case 4:
                                            jComboBox2.addItem("allocating money to Other");
                                            break;
                                    }
                                    //jComboBox2.addItem("allocating money to ");
                                }
                            }
                            break;
                        default:
                            jComboBox2.removeAllItems();
                            jLabel2.setVisible(false);
                            jComboBox2.setVisible(false);
                            break;
                    }
                    break;
                //other
                case 4:
                    jComboBox2.removeAllItems();
                    switch (boxIndex)
                    {
                        case 0:
                            jComboBox2.removeAllItems();
                            jComboBox2.addItem("buying new appliances or equipment");
                            break;
                        case 1:
                            jComboBox2.removeAllItems();
                            for (int i = 0; i < amountRmn.size(); i++)
                            {
                                if (amountRmn.get(i) <= 0 && i != expIndex)
                                {
                                    switch (i)
                                    {
                                        case 0:
                                            jComboBox2.addItem("allocating money to Food");
                                            break;
                                        case 1:
                                            jComboBox2.addItem("allocating money to Employees");
                                            break;
                                        case 2:
                                            jComboBox2.addItem("allocating money to Maintenance");
                                            break;
                                        case 3:
                                            jComboBox2.addItem("allocating money to Rent");
                                            break;
                                        case 4:
                                            jComboBox2.addItem("allocating money to Other");
                                            break;
                                    }
                                    //jComboBox2.addItem("allocating money to ");
                                }
                            }
                            break;
                        default:
                            jComboBox2.removeAllItems();
                            jLabel2.setVisible(false);
                            jComboBox2.setVisible(false);
                            break;
                    }
                    break;
            }
        }
        else
        {
            jLabel2.setVisible(false);
            jComboBox2.setVisible(false);
        }
    }
    
    private void updateLabel3()
    {
        jLabel3.setVisible(false);
        int expIndex = expenseBox.getSelectedIndex();
        int box1Index = jComboBox1.getSelectedIndex();
        int box2Index = jComboBox2.getSelectedIndex();
        
        if (jComboBox2.isVisible())
        {
            if (expIndex == 0 && box1Index == 0)
            {
                jLabel3.setText("Giving a new remaining amount of $"+df.format(amountRmn.get(0) - totalIngredCost.get(box2Index)));
                //System.out.println(c);
                jLabel3.setVisible(true);
            }
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

        titleText = new javax.swing.JLabel();
        expenseBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        spendingText = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titleText.setFont(new java.awt.Font("Lucida Grande", 1, 20)); // NOI18N
        titleText.setText("Possible Spending For");

        expenseBox.setFont(new java.awt.Font("Lucida Grande", 1, 20)); // NOI18N
        expenseBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Food", "Employees", "Maintenance", "Rent", "Other" }));
        expenseBox.setSize(new java.awt.Dimension(120, 35));
        expenseBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expenseBoxActionPerformed(evt);
            }
        });

        jLabel1.setText("You can");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Which means");

        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        spendingText.setFont(new java.awt.Font("Lucida Grande", 2, 16)); // NOI18N
        spendingText.setText("jLabel4");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 2, 16)); // NOI18N
        jLabel3.setText("jLabel3");

        jButton1.setText("Return");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(spendingText))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel1))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addComponent(titleText)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(expenseBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(jLabel3)))
                        .addGap(0, 48, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleText)
                    .addComponent(expenseBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(spendingText)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void expenseBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expenseBoxActionPerformed
        // TODO add your handling code here:
        updateOptions();
        updateOptions2();
        updateLabel3();
    }//GEN-LAST:event_expenseBoxActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        updateOptions2();
        updateLabel3();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        updateLabel3();
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(expenseSpending.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(expenseSpending.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(expenseSpending.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(expenseSpending.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new expenseSpending().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> expenseBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel spendingText;
    private javax.swing.JLabel titleText;
    // End of variables declaration//GEN-END:variables
}
