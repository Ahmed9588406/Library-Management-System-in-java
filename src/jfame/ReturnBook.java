/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jfame;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Ahmed Alaa
 */
public class ReturnBook extends javax.swing.JFrame {

    /**
     * Creates new form IssueedBooks
     */
    public ReturnBook() {
        initComponents();
    }
    
    
    
    // to fetch the issuebook details from the database and display it to student details panel
    
    public void getIssueBookDetails(){
    
    int bookId = Integer.parseInt(txt_bookId.getText());
    int studentId = Integer.parseInt(txt_bookId.getText());
        try {
            
            Connection con =  DataBaseConnection.getconnection();
            String sql = "select * from issue_book_details where book_id = ? and student_id = ? and status = ?";
            
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            pst.setInt(2, studentId);
            pst.setString(3, "pending");
            
            ResultSet rs = pst.executeQuery();
            
            
            if(rs.next()){
             
            lbl_issueId.setText(rs.getString("id"));
            lbl_bookname1.setText(rs.getString("book_name"));
            lbl_studentname.setText(rs.getString("student_name"));
            lbl_issuedate.setText(rs.getString("issue_date"));
            lbl_duedate.setText(rs.getString("due_date"));
            lbl_BookError1.setText("");
            }else{
            lbl_BookError1.setText("No Record Found");
            
            lbl_issueId.setText("");
            lbl_bookname1.setText("");
            lbl_studentname.setText("");
            lbl_issuedate.setText("");
            lbl_duedate.setText("");
            
            }
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
            
            
        }
    
    
    }
    
    //return the book
    public boolean returnBook(){
    boolean isReturened = false;
    int bookId = Integer.parseInt(txt_bookId.getText());
    int studentId = Integer.parseInt(txt_studentId.getText());
    
        try {
            Connection con = DataBaseConnection.getconnection();
            String sql = "update issue_book_details set status = ? where student_id = ? and book_id = ? and status = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, "returned");
            pst.setInt(2, studentId);
            pst.setInt(3, bookId);
            pst.setString(4, "pending");
            
            int rowCount = pst.executeUpdate();
            if(rowCount > 0){
            isReturened = true;
            }else{
            isReturened = false;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    return isReturened;
    }
    
    
    
    
    // insert issue book details to database
   
    
    
    // update book count in the database
    
    public void updateBookCount(){
    int bookId = Integer.parseInt(txt_bookId.getText());
    try{
    Connection con = DataBaseConnection.getconnection();
    String sql = "update book_details set quantity = quantity + 1 where book_id = ?";
    PreparedStatement pst = con.prepareStatement(sql);
    pst.setInt(1, bookId);
    int rowcount = pst.executeUpdate();
    
    if(rowcount > 0){
    JOptionPane.showMessageDialog(this, "book count updated");
    
    }else{
    JOptionPane.showMessageDialog(this, "can't update book count");
    
    }
    
    }catch(Exception e){
    
    e.printStackTrace();
    }
    
    
    }
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_main = new javax.swing.JPanel();
        panel_main1 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        lbl_duedate = new javax.swing.JLabel();
        lbl_issueId = new javax.swing.JLabel();
        lbl_bookname1 = new javax.swing.JLabel();
        lbl_studentname = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        lbl_BookError1 = new javax.swing.JLabel();
        lbl_issuedate = new javax.swing.JLabel();
        lbl_BookError2 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        txt_bookId = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txt_studentId = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle4 = new rojerusan.RSMaterialButtonCircle();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_main.setBackground(new java.awt.Color(255, 255, 255));
        panel_main.setForeground(new java.awt.Color(255, 255, 255));
        panel_main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_main1.setBackground(new java.awt.Color(255, 255, 255));
        panel_main1.setForeground(new java.awt.Color(255, 255, 255));
        panel_main1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(255, 0, 0));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel23.setText(" Book Details");
        jPanel9.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 260, -1));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel9.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 330, 5));

        jLabel26.setBackground(new java.awt.Color(255, 255, 255));
        jLabel26.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Book Name :");
        jPanel9.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 120, -1));

        jLabel27.setBackground(new java.awt.Color(255, 255, 255));
        jLabel27.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Student Name :");
        jPanel9.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 150, -1));
        jPanel9.add(lbl_duedate, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 660, 140, 30));
        jPanel9.add(lbl_issueId, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, 140, 30));
        jPanel9.add(lbl_bookname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, 140, 30));
        jPanel9.add(lbl_studentname, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 490, 140, 30));

        jLabel32.setBackground(new java.awt.Color(255, 255, 255));
        jLabel32.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Issue Date :");
        jPanel9.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 570, 110, -1));

        lbl_BookError1.setBackground(new java.awt.Color(255, 255, 255));
        lbl_BookError1.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_BookError1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel9.add(lbl_BookError1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 740, 320, 30));
        jPanel9.add(lbl_issuedate, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 570, 140, 30));

        lbl_BookError2.setBackground(new java.awt.Color(255, 255, 255));
        lbl_BookError2.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_BookError2.setForeground(new java.awt.Color(255, 255, 255));
        lbl_BookError2.setText("Due Date :");
        jPanel9.add(lbl_BookError2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 660, 100, -1));

        jLabel30.setBackground(new java.awt.Color(255, 255, 255));
        jLabel30.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Issue ID :");
        jPanel9.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 100, -1));

        panel_main1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 410, 810));

        jLabel28.setBackground(new java.awt.Color(255, 0, 0));
        jLabel28.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 0, 0));
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel28.setText("Return Book");
        jLabel28.setToolTipText("");
        panel_main1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 140, 290, -1));

        jPanel12.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        panel_main1.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 220, 330, 5));

        txt_bookId.setText("Enter Book ID");
        txt_bookId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 0, 0)));
        txt_bookId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookIdFocusLost(evt);
            }
        });
        txt_bookId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookIdActionPerformed(evt);
            }
        });
        panel_main1.add(txt_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 370, 270, 30));

        jLabel29.setBackground(new java.awt.Color(255, 0, 0));
        jLabel29.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 0, 0));
        jLabel29.setText(" Book ID :");
        panel_main1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 370, -1, -1));

        txt_studentId.setText(" Enter Student ID");
        txt_studentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 0, 0)));
        txt_studentId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentIdFocusLost(evt);
            }
        });
        txt_studentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentIdActionPerformed(evt);
            }
        });
        panel_main1.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 470, 270, 30));

        jLabel31.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 0, 0));
        jLabel31.setText(" Student ID :");
        panel_main1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 470, -1, -1));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle3.setText("Return");
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        panel_main1.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 670, 440, 70));

        rSMaterialButtonCircle4.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle4.setText("Find");
        rSMaterialButtonCircle4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle4ActionPerformed(evt);
            }
        });
        panel_main1.add(rSMaterialButtonCircle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 580, 440, 70));

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel1.setText("Back");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, 20));

        panel_main1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 40));

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/library-2.png"))); // NOI18N
        jLabel25.setText("Issue ID :");
        panel_main1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 660, 600));

        panel_main.add(panel_main1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1720, 810));

        getContentPane().add(panel_main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1720, 810));

        setBounds(0, 0, 1737, 852);
    }// </editor-fold>//GEN-END:initComponents

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
        if (returnBook() == true) {
            JOptionPane.showMessageDialog(this, "Book Returned Successfully");
            updateBookCount();
        }else{
        JOptionPane.showMessageDialog(this, "Book Returned Faild");
        }
       
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed
    
    private void txt_studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIdActionPerformed

    private void txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIdFocusLost

    private void txt_bookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookIdActionPerformed

    private void txt_bookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookIdFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookIdFocusLost

    private void rSMaterialButtonCircle4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle4ActionPerformed
        getIssueBookDetails();
    }//GEN-LAST:event_rSMaterialButtonCircle4ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
       HomePage home = new HomePage();
       home.setVisible(true);
       dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

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
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReturnBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lbl_BookError1;
    private javax.swing.JLabel lbl_BookError2;
    private javax.swing.JLabel lbl_bookname1;
    private javax.swing.JLabel lbl_duedate;
    private javax.swing.JLabel lbl_issueId;
    private javax.swing.JLabel lbl_issuedate;
    private javax.swing.JLabel lbl_studentname;
    private javax.swing.JPanel panel_main;
    private javax.swing.JPanel panel_main1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle4;
    private javax.swing.JTextField txt_bookId;
    private javax.swing.JTextField txt_studentId;
    // End of variables declaration//GEN-END:variables
}
