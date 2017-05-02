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
import javax.swing.JTextField;
import javax.swing.JTable;


/**
 *
 * @author kimberlyngai
 */
public class EmployeeList extends javax.swing.JFrame {

    /**
     * Creates new form EmployeeList
     */
    DefaultTableModel dm;
    
    private JTextField idField, lastNField, firstNfield, hrRateField;
    private JOptionPane optionPane;
    private String btnString1 = "Submit";
    private String btnString2 = "Cancel";
    
    private void setTable()
    {
        dm = new DefaultTableModel(0, 0);  
        String s[] = new String[]{"Employee ID", "Name", "Job Title" , "Hourly Rate", "Last Punch Type", "Last Punch Date and Time"};  
        dm.setColumnIdentifiers(s);
        //jTable1.setAutoResizeMode(AUTO_RESIZE_ALL_COLUMNS);
        jTable1.setModel(dm);
        //jTable1.setA
        jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(90);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(90);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(140);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(185);
        //TableColumn tableColumn = table.getColumnModel().getColumn(column);
    }
    
    private void getData()
    {
        //boolean success=false;
        
        int emID;
        String emName, jTitle, hRate, lPunch = "IN", lPunchT;
            
        try{
            Connection conn=DriverManager.getConnection("jdbc:mysql://resturantdb.cul7akmhbeku.us-west-2.rds.amazonaws.com:3306/employeeDB","root","password");
                  
            Statement st =conn.createStatement();
            Statement st1 = conn.createStatement();
                        
            ResultSet rs = st.executeQuery("SELECT * FROM employeeRecords");
            
            while (rs.next())
            {   
                emID = rs.getInt(1);
                emName = rs.getString(3) + " " + rs.getString(2);
                jTitle = rs.getString(4);
                hRate = rs.getString(5);
                //System.out.println("hi");
                //lPunch = rs.get
                
                ResultSet rs1 = st1.executeQuery("SELECT lastPunch FROM employeeDB.employeeRecords WHERE employeeID=" +emID);
                
                if (rs1.next())
                {
                    rs1.getString(1);
                    
                    if (rs1.wasNull())
                    {
                        lPunch = "";
                        //System.out.println("null");
                    }
                    else
                    {
                        lPunch = rs1.getString(1);
                        //System.out.println("not null");
                    }
                }
                
                //System.out.println("bye");
                
                if (lPunch.equals("IN"))
                {
                    //System.out.println("in1");
                    lPunchT = rs.getString(6);
                    //System.out.println("in2");
                }
                else if (lPunch.equals("OUT"))
                {
                    //System.out.println("out1");
                    lPunchT = rs.getString(7);
                    //System.out.println("out2");
                }
                else
                {
                    //System.out.println("null1");
                    lPunchT = "";
                    //System.out.println("null2");
                }
//                totHr = rs.getString(9);
//                totP = rs.getString(10);
//                bonus = df.format(rs.getDouble(11));
//                fP = df.format(rs.getDouble(10) + rs.getDouble(11));
//              
                //System.out.println("vectorb4");
                Vector <Object> v = new Vector<Object>();
//                
                v.add(emID);
                v.add(emName);
                v.add(jTitle);
                v.add(hRate);
                v.add(lPunch);
                v.add(lPunchT);
                //System.out.println("vector after");
//                v.add(totHr);
//                v.add(totP);
//                v.add(bonus);
//                v.add(fP);
//                
                dm.addRow(v);
                //System.out.println("add row");
            }
            //success=true;
        }catch (SQLException ex)
        {   
            //success=false;
            Logger.getLogger(addItem.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public EmployeeList() {
        initComponents();
        setTable();  
        getData(); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        returnButton = new javax.swing.JButton();
        addEmployee = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        removeEmployee = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 300));
        setPreferredSize(new java.awt.Dimension(800, 300));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 20)); // NOI18N
        jLabel1.setText("Employees");

        returnButton.setText("Return");
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });

        addEmployee.setText("Add Employee");
        addEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmployeeActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        removeEmployee.setText("Remove Employee");
        removeEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeEmployeeActionPerformed(evt);
            }
        });

        refreshButton.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        refreshButton.setText("Refresh Table");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(returnButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 239, Short.MAX_VALUE)
                        .addComponent(addEmployee)
                        .addGap(18, 18, 18)
                        .addComponent(removeEmployee)
                        .addGap(18, 18, 18)
                        .addComponent(refreshButton)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(332, 332, 332)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addEmployee)
                    .addComponent(removeEmployee)
                    .addComponent(returnButton)
                    .addComponent(refreshButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
        // TODO add your handling code here:
       Manager managePage = new Manager();
        managePage.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_returnButtonActionPerformed

    private void addEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmployeeActionPerformed
        // TODO add your handling code here:
        idField = new JTextField(3);
        lastNField = new JTextField(15);
        firstNfield = new JTextField(15);
        hrRateField = new JTextField(5);
        
        addEmployee emPage = new addEmployee();
        emPage.setVisible(true);
        //addEmp emPage = new addEmp();
        //pull up new frame but keep this one visible
        //in addemployee, have user input id, last name, first name, job, and hourly rate
        //check to make sure id, first name, and last name doesnt already exist (use openMenu code)
    }//GEN-LAST:event_addEmployeeActionPerformed

    private int empID;
    private String empName;
    
    private void removeEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeEmployeeActionPerformed
        // TODO add your handling code here:
        //empName = dm.getValueAt(jTable1.getSelectedRow(), 1).toString();
        //Object [] choices = {"Yes", "No"};
        
        if (empName == null)
        {
            JOptionPane.showMessageDialog(null, "No employee selected from table!", null, JOptionPane.ERROR_MESSAGE);
        }
        
        else
        {
            int n = JOptionPane.showOptionDialog(null, "Remove employee " +empName+ " from system?", "Alert",
             JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
             null, null, null);
            
            if (n == JOptionPane.YES_OPTION)
            {
                boolean success = false;
                
                try{
                    Connection conn=DriverManager.getConnection("jdbc:mysql://resturantdb.cul7akmhbeku.us-west-2.rds.amazonaws.com:3306/employeeDB","root","password");

                    Statement st =conn.createStatement();
                    //Statement st1 = conn.createStatement();
                    
                    String sqlStatement = "DELETE FROM employeeRecords WHERE employeeID = " +empID;
                    
                    st.executeUpdate(sqlStatement);
                    
                    success=true;
                }catch (SQLException ex)
                {   
                    success=false;
                    Logger.getLogger(addItem.class.getName()).log(Level.SEVERE,null,ex);
                }
                
                if (success == true)
                {
                    JOptionPane.showMessageDialog(null, empName+ " removed from system.");
                }
                else if (success == false)
                {
                    JOptionPane.showMessageDialog(null, empName+ " not removed from system.", null, JOptionPane.ERROR_MESSAGE);   
                }
                setTable();
                getData();
            }
        }

        //int n = JOptionPane.showOptionDialog(rootPane, "Remove employee " +empName+ " from system?", "Delete Employee", WIDTH, HEIGHT, icon, choices, optionPane);
    }//GEN-LAST:event_removeEmployeeActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        empID = Integer.parseInt(dm.getValueAt(jTable1.getSelectedRow(), 0).toString());
        empName = dm.getValueAt(jTable1.getSelectedRow(), 1).toString();
    }//GEN-LAST:event_jTable1MouseClicked

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        // TODO add your handling code here:
        setTable();
        getData();
    }//GEN-LAST:event_refreshButtonActionPerformed

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
            java.util.logging.Logger.getLogger(EmployeeList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addEmployee;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton removeEmployee;
    private javax.swing.JButton returnButton;
    // End of variables declaration//GEN-END:variables
}
