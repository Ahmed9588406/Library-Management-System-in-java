/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jfame;

import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import static jfame.DataBaseConnection.con;

/**
 *
 * @author Ahmed Alaa
 */
public class ManageStudents extends javax.swing.JFrame {

    /**
     * Creates new form ManageBooks
     */
    
    String studentName,course,branch;
    int student_Id;
    DefaultTableModel model;
    
    public ManageStudents() {
        initComponents();
        setStudentdetails();
    }
    Connection con;
    
    //set the book details into the Table
    public void setStudentdetails(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from student_details");
            
            while(rs.next()){
                String StudentId = rs.getString("student_id");
                String StudentName = rs.getString("name");
                String course = rs.getString("Course");
                String branch = rs.getString("branch");
                
                Object []obj = {StudentId, StudentName, course, branch};
                model = (DefaultTableModel) tbl_studentdetails.getModel();
                model.addRow(obj);
                
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        
        
 
    
    }
    // to add student to student_details table
    
    public boolean addstudent(){
        boolean isAdded = false;
    student_Id = Integer.parseInt(txt_studentId.getText());
    studentName =txt_studentname.getText();
    course = combo_Course.getSelectedItem().toString();
    branch = combo_Branch.getSelectedItem().toString();
        try {
            Connection con = DataBaseConnection.getconnection();
            String sql = "insert into student_details value (?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, student_Id);
            pst.setString(2, studentName);
            pst.setString(3, course);
            pst.setString(4, branch);
            
            int rowCount = pst.executeUpdate();
            if(rowCount > 0){
            isAdded = true;
            }else{
            isAdded = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            
        }

    return isAdded;
    }
    
    // Method to update  student table
    public boolean updateStudent(){
    boolean isUpdated = false;
    student_Id = Integer.parseInt(txt_studentId.getText());
    studentName =txt_studentname.getText();
    course = combo_Course.getSelectedItem().toString();
    branch = combo_Branch.getSelectedItem().toString();
    
        try {
         Connection con = DataBaseConnection.getconnection();
         String sql = "update student_details set name = ?,course = ?,branch = ? where student_id = ?";
         PreparedStatement pst = con.prepareStatement(sql);
         pst.setString(1, studentName);
         pst.setString(2, course);
         pst.setString(3, branch);
         pst.setInt(4, student_Id);
         
         int rowCount = pst.executeUpdate();
         if(rowCount > 0){
       isUpdated = true;
         
         }else{
         isUpdated = false;
         }
                    
        } catch (Exception e) {
            
            e.printStackTrace();
            
        }

    return isUpdated;
    
    }
    //method to delet book
    public boolean deleteStudent(){
    boolean isDeleted = false;
    student_Id =Integer.parseInt(txt_studentId.getText());
        try {
            Connection con = DataBaseConnection.getconnection();
            String sql = "delete from student_details where student_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, student_Id);
            
            int rowCount = pst.executeUpdate();
            if(rowCount > 0){
            isDeleted = true;
            }else{
            isDeleted = false;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    return isDeleted;
    }
    
    
    
    
    // Method to clear table
    public void clearTable(){
    DefaultTableModel model = (DefaultTableModel)tbl_studentdetails.getModel();
    model.setRowCount(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_studentId = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_studentname = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        combo_Branch = new javax.swing.JComboBox<>();
        combo_Course = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_studentdetails = new rojerusan.RSTableMetro();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_studentId.setBackground(new java.awt.Color(102, 102, 255));
        txt_studentId.setText(" Enter Book Id");
        txt_studentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
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
        jPanel1.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 190, 30));

        jPanel3.setBackground(new java.awt.Color(102, 102, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 51, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel1.setText("Back");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 40));

        jLabel12.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Enter Student Id");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, -1, -1));

        jLabel8.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        jLabel13.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Enter Student Name");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, -1, -1));

        jLabel9.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));

        txt_studentname.setBackground(new java.awt.Color(102, 102, 255));
        txt_studentname.setText("Enter Book Name");
        txt_studentname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_studentname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentnameFocusLost(evt);
            }
        });
        txt_studentname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentnameActionPerformed(evt);
            }
        });
        jPanel3.add(txt_studentname, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 190, 30));

        jLabel10.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, -1, -1));

        jLabel14.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Select Course");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 440, -1, -1));

        jLabel17.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 590, -1, -1));

        jLabel18.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Select Branch");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 560, -1, -1));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle1.setText("DELETE");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel3.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 690, 130, 70));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle2.setText("ADD");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel3.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 690, 130, 70));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle3.setText("UPDATE");
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        jPanel3.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 690, 130, 70));

        combo_Branch.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        combo_Branch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "IT", "CS", "PLAIN", "ELECTRONICS" }));
        combo_Branch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_BranchActionPerformed(evt);
            }
        });
        jPanel3.add(combo_Branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 600, 200, 30));

        combo_Course.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        combo_Course.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BSC", "MSC", "PHD" }));
        combo_Course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_CourseActionPerformed(evt);
            }
        });
        jPanel3.add(combo_Course, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 470, 200, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 840));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 830));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_studentdetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "StudentId", "Name", "Course", "Branch"
            }
        ));
        tbl_studentdetails.setColorBackgoundHead(new java.awt.Color(255, 51, 51));
        tbl_studentdetails.setColorBordeFilas(new java.awt.Color(255, 51, 51));
        tbl_studentdetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_studentdetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tbl_studentdetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        tbl_studentdetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        tbl_studentdetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        tbl_studentdetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        tbl_studentdetails.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tbl_studentdetails.setRowHeight(44);
        tbl_studentdetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_studentdetailsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_studentdetails);

        jPanel5.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 840, 320));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Student_Male_100px.png"))); // NOI18N
        jLabel3.setText("Manage Students");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 350, -1));

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 410, 10));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 1150, 830));

        setBounds(0, 0, 1742, 871);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
       HomePage home = new HomePage();
       home.setVisible(true);
       dispose();
       
    }//GEN-LAST:event_jLabel1MouseClicked

    private void txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusLost

    }//GEN-LAST:event_txt_studentIdFocusLost

    private void txt_studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIdActionPerformed

    private void txt_studentnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentnameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentnameFocusLost

    private void txt_studentnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentnameActionPerformed

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
        if (updateStudent()== true) {
            JOptionPane.showMessageDialog(this, "Student Updated");
            clearTable();
            setStudentdetails();
        }else{
        JOptionPane.showMessageDialog(this, "Student Updation Failed");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void tbl_studentdetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_studentdetailsMouseClicked
        int rowNo = tbl_studentdetails.getSelectedRow();
        TableModel model = tbl_studentdetails.getModel();
        txt_studentId.setText(model.getValueAt(rowNo, 0).toString());
        txt_studentname.setText(model.getValueAt(rowNo, 1).toString());
        combo_Course.setSelectedItem(model.getValueAt(rowNo, 2).toString());
        combo_Branch.setSelectedItem(model.getValueAt(rowNo, 3).toString());
        
        
    }//GEN-LAST:event_tbl_studentdetailsMouseClicked

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        if (addstudent()== true) {
            JOptionPane.showMessageDialog(this, "Student Added");
            clearTable();
            setStudentdetails();
        }else{
        JOptionPane.showMessageDialog(this, "Student Addition Failed");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
        if (deleteStudent()== true) {
            JOptionPane.showMessageDialog(this, "Student Deleted");
            clearTable();
            setStudentdetails();
        }else{
        JOptionPane.showMessageDialog(this, "Student Deletion Failed");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void combo_BranchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_BranchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_BranchActionPerformed

    private void combo_CourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_CourseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_CourseActionPerformed

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
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageStudents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo_Branch;
    private javax.swing.JComboBox<String> combo_Course;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private rojerusan.RSTableMetro tbl_studentdetails;
    private javax.swing.JTextField txt_studentId;
    private javax.swing.JTextField txt_studentname;
    // End of variables declaration//GEN-END:variables
}
