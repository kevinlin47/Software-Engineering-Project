/*
Author:
Katie Bruett
Kimberly Ngai
Kevin Lin
 */
package resturantautomation;

/**
 *
 * @author Kevin Lin
 */
public class Manager extends javax.swing.JFrame {

    /**
     * Creates new form Manager
     */
    public Manager() {
        initComponents();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        viewStats = new javax.swing.JButton();
        viewBudget = new javax.swing.JButton();
        viewPay = new javax.swing.JButton();
        logOut = new javax.swing.JButton();
        employeeRecord = new javax.swing.JButton();
        clockButton = new javax.swing.JButton();
        viewShift = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(500, 300));
        setPreferredSize(new java.awt.Dimension(400, 300));

        viewStats.setText("View Statistics");
        viewStats.setMaximumSize(new java.awt.Dimension(150, 29));
        viewStats.setMinimumSize(new java.awt.Dimension(110, 29));
        viewStats.setPreferredSize(new java.awt.Dimension(139, 29));
        viewStats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewStatsActionPerformed(evt);
            }
        });

        viewBudget.setText("Budget");
        viewBudget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewBudgetActionPerformed(evt);
            }
        });

        viewPay.setLabel("Employee Payroll");
        viewPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewPayActionPerformed(evt);
            }
        });

        logOut.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        logOut.setText("Log Out");
        logOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutActionPerformed(evt);
            }
        });

        employeeRecord.setText("Employee List");
        employeeRecord.setMaximumSize(new java.awt.Dimension(150, 29));
        employeeRecord.setMinimumSize(new java.awt.Dimension(150, 29));
        employeeRecord.setPreferredSize(new java.awt.Dimension(150, 29));
        employeeRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeRecordActionPerformed(evt);
            }
        });

        clockButton.setText("Time Clock");
        clockButton.setMaximumSize(new java.awt.Dimension(150, 29));
        clockButton.setMinimumSize(new java.awt.Dimension(150, 29));
        clockButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clockButtonActionPerformed(evt);
            }
        });

        viewShift.setText("Schedule");
        viewShift.setMaximumSize(new java.awt.Dimension(150, 29));
        viewShift.setMinimumSize(new java.awt.Dimension(150, 29));
        viewShift.setPreferredSize(new java.awt.Dimension(150, 29));
        viewShift.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewShiftActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(clockButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(viewShift, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(viewPay)
                                    .addComponent(viewStats, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(viewBudget, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(employeeRecord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(logOut, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 466, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewStats, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewBudget, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewPay, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(employeeRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clockButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewShift, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(logOut)
                .addContainerGap(292, Short.MAX_VALUE))
        );

        viewStats.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Pressing the "View Statistics" button brings up the statistics window and closes the manager window
    private void viewStatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewStatsActionPerformed
        // TODO add your handling code here:
        viewStatistics statsPage = new viewStatistics();
        statsPage.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_viewStatsActionPerformed

    //Pressing the "Budget" button brings up the budget window and closes manager menu
    private void viewBudgetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewBudgetActionPerformed
        // TODO add your handling code here:
        viewBudget budgetPage = new viewBudget();
        budgetPage.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_viewBudgetActionPerformed

    //Brings up the payroll windows and closes the manager menu
    private void viewPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewPayActionPerformed
        // TODO add your handling code here:
        viewPayroll payrollPage = new viewPayroll();
        payrollPage.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_viewPayActionPerformed

    //Logs manager out of system and goes back to login menu
    private void logOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutActionPerformed
    Login loginPage = new Login();
        loginPage.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_logOutActionPerformed

    private void employeeRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeRecordActionPerformed
        // TODO add your handling code here:
        EmployeeList emPage = new EmployeeList();
        emPage.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_employeeRecordActionPerformed

    private void clockButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clockButtonActionPerformed
        // TODO add your handling code here:
        timeClock punchT = new timeClock();
        punchT.setVisible(true);
        //this.setVisible(false);
    }//GEN-LAST:event_clockButtonActionPerformed

    private void viewShiftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewShiftActionPerformed
        this.dispose();
        Schedule s=new Schedule();
        s.setVisible(true);
        
    }//GEN-LAST:event_viewShiftActionPerformed

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
            java.util.logging.Logger.getLogger(Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Manager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clockButton;
    private javax.swing.JButton employeeRecord;
    private javax.swing.JButton logOut;
    private javax.swing.JButton viewBudget;
    private javax.swing.JButton viewPay;
    private javax.swing.JButton viewShift;
    private javax.swing.JButton viewStats;
    // End of variables declaration//GEN-END:variables
}
