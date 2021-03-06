/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cic.view;

import cic.controller.CClaimManager;
import cic.controller.CInsuredCheck;
import cic.entity.Claim;
import cic.entity.ClaimComplexity;
import cic.entity.ClaimStatus;
import cic.entity.exceptions.PriorityException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alfredo
 */
public class ClassifiedClaimsPage extends CicPageWithMenu {

    
    private ArrayList<Claim> claims;
    
    DefaultTableModel model;
    
    private Claim currentClaim;
    
    
    /***
     * 
     * for acceptance test
     * 
     * 
     **/

    public void clickCheckInsuranceButton(){
        CheckInsuranceButton.doClick();
    }
    
    public void clickConfirmHistoryButton(){
        ConfirmHistoryButton.doClick();
    }
    
    public void clickSendSmsButton(){
        SendSmsButton.doClick();
    }
    
    
    public void selectClaimNumber(Integer toFind){
        
        Boolean done=false;
        
        for (int i=0;i<this.ClaimsTable.getModel().getRowCount() && !done;i++){
            String x= (String)this.ClaimsTable.getModel().getValueAt(i, 0);
          
            
            if(x.compareTo(toFind.toString())==0){
                
                done=true;
                ListSelectionModel selectionModel =   this.ClaimsTable.getSelectionModel();
        selectionModel.setSelectionInterval(i-1, i);
            }
           
        }
    }
    
    
    
    /**
     * Creates new form ClassifiedClaimsPage
     */
    public ClassifiedClaimsPage() {
        initComponents();
        refreshContent(); 
        
       
    }
    
    private void refreshContent(){
        
        
        
        
        this.LowerPanel.setVisible(false);
        
     CClaimManager contr = CClaimManager.getInstance();
       
        
        claims=contr.getClassifiedClaimsNotPreliminaryComplete();
        
        model=(DefaultTableModel)this.ClaimsTable.getModel();
        
        
        for(Claim claim:this.claims){
            model.addRow(new Object[]{claim.getId().toString(), claim.getOwnerSsn(), 
                
                claim.getDescription(), claim.getComplexity().toString()});
        }
        
        
         ListSelectionModel cellSelectionModel = this.ClaimsTable.getSelectionModel();
         cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
         
         cellSelectionModel.addListSelectionListener(
                 new ListSelectionListener() {
                   public void valueChanged(ListSelectionEvent e) {
                        int index=ClaimsTable.getSelectedRow();
        
                       currentClaim=claims.get(index);
                       updateLowerPart();
      }

    });
    
    }

    private void updateLowerPart(){
        
        this.LowerPanel.setVisible(true);
          //update labels
       Claim c=currentClaim;
       
       //check insurance status
       if(currentClaim.getCheckInsuranceStatus()==ClaimStatus.COMPLETED){
           this.CheckInsuranceStatusLabel.setText("(Completed)");
           this.CheckInsuranceButton.setEnabled(false);
       }
       else{
           this.CheckInsuranceStatusLabel.setText("(Not completed)");
           this.CheckInsuranceButton.setEnabled(true);
       }
       
         if(currentClaim.getComplexity()==ClaimComplexity.SIMPLE){
           
           this.WrapperHistoryjPanel.setVisible(false);
           
           
               //phone garage status
       if(currentClaim.getPhoneGarageStatus()==ClaimStatus.COMPLETED){
           this.PhoneGarageStatusLabel.setText("(Completed)");
           this.SendSmsButton.setEnabled(false);
       }
       else{
           this.PhoneGarageStatusLabel.setText("(Not completed)");
           this.SendSmsButton.setEnabled(true);
       }
       
       
           
       }
       else{
           this.WrapperHistoryjPanel.setVisible(true);
           
           this.historyJPanel2.updateHistoryTable(currentClaim);
           
       
           
           if(currentClaim.getComplexity()==ClaimComplexity.COMPLEX){
               
              
               
                 //check history status
              if(currentClaim.getCheckHistoryStatus()==ClaimStatus.COMPLETED){
                 this.HistoryLabel.setText("(Completed)");
                 this.ConfirmHistoryButton.setEnabled(false);
          }
       else{
           this.HistoryLabel.setText("(Not completed)");
           this.ConfirmHistoryButton.setEnabled(true);
       }
              
                //implementing precedence of operations            
               if(currentClaim.getCheckInsuranceStatus()==ClaimStatus.NOT_COMPLETED){
                   
                   this.ConfirmHistoryButton.setEnabled(false);
                   
               }
               
               
               if(currentClaim.getCheckHistoryStatus()==ClaimStatus.NOT_COMPLETED){
                   this.SendSmsButton.setEnabled(false);
               }
           
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

        jScrollPane1 = new javax.swing.JScrollPane();
        ClaimsTable = new javax.swing.JTable();
        LowerPanel = new javax.swing.JPanel();
        PhoneGarageStatusLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        SendSmsButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        CheckInsuranceButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        CheckInsuranceStatusLabel = new javax.swing.JLabel();
        WrapperHistoryjPanel = new javax.swing.JPanel();
        ConfirmHistoryButton = new javax.swing.JButton();
        HistoryLabel = new javax.swing.JLabel();
        TextLabel = new javax.swing.JLabel();
        historyJPanel2 = new cic.view.HistoryJPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ClaimsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Ssn", "Description", "Complexity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(ClaimsTable);

        PhoneGarageStatusLabel.setText("(Not completed)");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        SendSmsButton.setText("Send sms");
        SendSmsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendSmsButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Inform Garage");

        CheckInsuranceButton.setText("Check");
        CheckInsuranceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckInsuranceButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Check Insurance");

        CheckInsuranceStatusLabel.setText("(Not completed)");

        ConfirmHistoryButton.setText("Confirm History");
        ConfirmHistoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmHistoryButtonActionPerformed(evt);
            }
        });

        HistoryLabel.setText("(Not completed)");

        TextLabel.setText("Table of history is disabled for simple claims.");

        javax.swing.GroupLayout WrapperHistoryjPanelLayout = new javax.swing.GroupLayout(WrapperHistoryjPanel);
        WrapperHistoryjPanel.setLayout(WrapperHistoryjPanelLayout);
        WrapperHistoryjPanelLayout.setHorizontalGroup(
            WrapperHistoryjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WrapperHistoryjPanelLayout.createSequentialGroup()
                .addGroup(WrapperHistoryjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(WrapperHistoryjPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(WrapperHistoryjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(WrapperHistoryjPanelLayout.createSequentialGroup()
                                .addComponent(ConfirmHistoryButton)
                                .addGap(31, 31, 31)
                                .addComponent(HistoryLabel))
                            .addComponent(TextLabel)))
                    .addGroup(WrapperHistoryjPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(historyJPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        WrapperHistoryjPanelLayout.setVerticalGroup(
            WrapperHistoryjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WrapperHistoryjPanelLayout.createSequentialGroup()
                .addComponent(TextLabel)
                .addGap(30, 30, 30)
                .addComponent(historyJPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(WrapperHistoryjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ConfirmHistoryButton)
                    .addComponent(HistoryLabel))
                .addContainerGap())
        );

        javax.swing.GroupLayout LowerPanelLayout = new javax.swing.GroupLayout(LowerPanel);
        LowerPanel.setLayout(LowerPanelLayout);
        LowerPanelLayout.setHorizontalGroup(
            LowerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LowerPanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(LowerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LowerPanelLayout.createSequentialGroup()
                        .addGroup(LowerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(PhoneGarageStatusLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(SendSmsButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(LowerPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CheckInsuranceStatusLabel)
                        .addGap(29, 29, 29)
                        .addComponent(CheckInsuranceButton)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(LowerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(WrapperHistoryjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 48, Short.MAX_VALUE))
        );
        LowerPanelLayout.setVerticalGroup(
            LowerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LowerPanelLayout.createSequentialGroup()
                .addGroup(LowerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LowerPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(LowerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(CheckInsuranceStatusLabel)))
                    .addGroup(LowerPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(CheckInsuranceButton)))
                .addGap(18, 18, 18)
                .addComponent(WrapperHistoryjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addGroup(LowerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SendSmsButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LowerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(LowerPanelLayout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(PhoneGarageStatusLabel))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(LowerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LowerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SendSmsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendSmsButtonActionPerformed
        try {
            // TODO add your handling code here:

            CClaimManager.getInstance().phoneGarage(currentClaim);
        } catch (PriorityException ex) {
            Logger.getLogger(ClassifiedClaimsPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        ClassifiedClaimsPage ccp=new ClassifiedClaimsPage();
        ccp.setVisible(true);
        this.dispose();
        
        
    }//GEN-LAST:event_SendSmsButtonActionPerformed

    private void CheckInsuranceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckInsuranceButtonActionPerformed
        // TODO add your handling code here:
        CInsuredCheck cont=new CInsuredCheck();
        Boolean res=cont.checkInsuranceOfUserGivenClaim(currentClaim);
                
        ClassifiedClaimsPage ccp=new ClassifiedClaimsPage();
        ccp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CheckInsuranceButtonActionPerformed

    private void ConfirmHistoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmHistoryButtonActionPerformed
        try {
            // TODO add your handling code here:
            CClaimManager.getInstance().CheckHistory(currentClaim);
        } catch (PriorityException ex) {
            Logger.getLogger(ClassifiedClaimsPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        ClassifiedClaimsPage ccp=new ClassifiedClaimsPage();
        ccp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ConfirmHistoryButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ClassifiedClaimsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClassifiedClaimsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClassifiedClaimsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClassifiedClaimsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClassifiedClaimsPage().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CheckInsuranceButton;
    private javax.swing.JLabel CheckInsuranceStatusLabel;
    private javax.swing.JTable ClaimsTable;
    private javax.swing.JButton ConfirmHistoryButton;
    private javax.swing.JLabel HistoryLabel;
    private javax.swing.JPanel LowerPanel;
    private javax.swing.JLabel PhoneGarageStatusLabel;
    private javax.swing.JButton SendSmsButton;
    private javax.swing.JLabel TextLabel;
    private javax.swing.JPanel WrapperHistoryjPanel;
    private cic.view.HistoryJPanel historyJPanel2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
