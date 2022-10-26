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
public class IssueedBooks extends javax.swing.JFrame {

    /**
     * Creates new form IssueedBooks
     */
    public IssueedBooks() {
        initComponents();
    }
    
    // to fetch the book details from the database and display it to book details panel
    public void getBookDetails(){
       int bookId = Integer.parseInt(txt_bookId.getText());
        try {
            Connection con = DataBaseConnection.getconnection();
            PreparedStatement  pst = con.prepareStatement("select * from book_details where book_id = ?");
            pst.setInt(1, bookId);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
            lbl_bookId1.setText(rs.getString("book_id"));
            lbl_bookname1.setText(rs.getString("book_name"));
            lbl_author1.setText(rs.getString("author"));
            lbl_quantity1.setText(rs.getString("quantity"));
                
            }else{
            lbl_BookError1.setText("invalid book id");
            }
           
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
    
    // to fetch the student details from the database and display it to student details panel

    
    public void getStudentDetails(){
       int studentId = Integer.parseInt(txt_studentId.getText());
        try {
            Connection con = DataBaseConnection.getconnection();
            PreparedStatement  pst = con.prepareStatement("select * from student_details where student_id = ?");
            pst.setInt(1, studentId);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
            lbl_studentId1.setText(rs.getString("student_id"));
            lbl_studentname1.setText(rs.getString("name"));
            lbl_course1.setText(rs.getString("course"));
            lbl_Branch1.setText(rs.getString("branch"));
                
            }else{
            lbl_StudentError.setText("invalid Student id");
            }
           
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
    
    // insert issue book details to database
    public boolean issueBook(){
    boolean isIssued = false;
    int bookId = Integer.parseInt(txt_bookId.getText());
    int studentId = Integer.parseInt(txt_studentId.getText());
    String bookName = lbl_bookname1.getText();
    String studentName = lbl_studentname1.getText();
    
    Date IssuedDate = date_isuueDate.getDatoFecha();
    Date DueDate = date_dueDate.getDatoFecha();
    
    Long l1 = IssuedDate.getTime();
    Long l2 = DueDate.getTime();
    
    java.sql.Date sIssueDate = new java.sql.Date(l1);
    java.sql.Date sDueDate = new java.sql.Date(l2);
    
        try {
            Connection con = DataBaseConnection.getconnection();
            String sql = "insert into issue_book_details(book_id,book_name,student_id,student_name," 
                    + "issue_date,due_date,status) values(?,?,?,?,?,?,?)";
            
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            pst.setString(2, bookName);
            pst.setInt(3, studentId);
            pst.setString(4, studentName);
            pst.setDate(5, sIssueDate);
            pst.setDate(6, sDueDate);
            pst.setString(7,"Pending");
            
            int rowCount = pst.executeUpdate();
            if(rowCount > 0){
            isIssued = true;
            
            }else{
            isIssued = false;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    return isIssued;
    }
    
    
    // update book count in the database
    public void updateBookCount(){
    
    int bookId = Integer.parseInt(txt_bookId.getText());
    try{
    Connection con = DataBaseConnection.getconnection();
    String sql = "update book_details set quantity = quantity - 1 where book_id = ?";
    PreparedStatement pst = con.prepareStatement(sql);
    pst.setInt(1, bookId);
    int rowcount = pst.executeUpdate();
    
    if(rowcount > 0){
    JOptionPane.showMessageDialog(this, "book count updated");
    int initialCount = Integer.parseInt(lbl_quantity1.getText());
    lbl_quantity1.setText(Integer.toString(initialCount - 1));
    }else{
    JOptionPane.showMessageDialog(this, "can't update book count");
    
    }
    
    }catch(Exception e){
    
    e.printStackTrace();
    }
    
    
    }
    
    // to check if there is a duplicate or not
    public boolean isAlreadyIssued(){
    boolean isAlreadyIssued = false;
    int bookId = Integer.parseInt(txt_bookId.getText());
   

    int studentId = Integer.parseInt(txt_studentId.getText());
    
        try {
             Connection con = DataBaseConnection.getconnection();
             String sql = "select * from issue_book_details where book_id = ? and student_id = ? and status = ?";
             PreparedStatement pst = con.prepareStatement(sql);
             pst.setInt(1, bookId);
             pst.setInt(2, studentId);
             pst.setString(3,"pending");
             ResultSet rs = pst.executeQuery();
             
             
             if(rs.next()){
             
             isAlreadyIssued = true;
             }else{
             isAlreadyIssued = false;
             }
             
        } catch (Exception e) {
            e.printStackTrace();
            
            
        }
        return isAlreadyIssued;
    
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_main = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        txt_bookId = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txt_studentId = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        panel_main1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lbl_Branch1 = new javax.swing.JLabel();
        lbl_studentId1 = new javax.swing.JLabel();
        lbl_studentname1 = new javax.swing.JLabel();
        lbl_course1 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lbl_StudentError = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        lbl_quantity1 = new javax.swing.JLabel();
        lbl_bookId1 = new javax.swing.JLabel();
        lbl_bookname1 = new javax.swing.JLabel();
        lbl_author1 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        lbl_BookError1 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        txt_studentId2 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txt_studentId3 = new javax.swing.JTextField();
        date_isuueDate = new rojeru_san.componentes.RSDateChooser();
        jLabel31 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        date_dueDate = new rojeru_san.componentes.RSDateChooser();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_main.setBackground(new java.awt.Color(255, 255, 255));
        panel_main.setForeground(new java.awt.Color(255, 255, 255));
        panel_main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 0, 0));
        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel2.setText("  Issue Book");
        jLabel2.setToolTipText("");
        panel_main.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 140, 290, -1));

        jPanel7.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        panel_main.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 220, 330, 5));

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
        panel_main.add(txt_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 330, 270, 30));

        jLabel17.setBackground(new java.awt.Color(255, 0, 0));
        jLabel17.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 0, 0));
        jLabel17.setText(" Book ID :");
        panel_main.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 340, -1, -1));

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
        panel_main.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 450, 270, 30));

        jLabel19.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 0, 0));
        jLabel19.setText(" Student ID :");
        panel_main.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 460, -1, -1));

        panel_main1.setBackground(new java.awt.Color(255, 255, 255));
        panel_main1.setForeground(new java.awt.Color(255, 255, 255));
        panel_main1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(0, 0, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 330, 5));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Branch :");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 570, 110, -1));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Student ID :");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 110, -1));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Student Name :");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 140, -1));

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Course :");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 100, -1));
        jPanel4.add(lbl_Branch1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 570, 140, 30));
        jPanel4.add(lbl_studentId1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, 140, 30));
        jPanel4.add(lbl_studentname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, 140, 30));
        jPanel4.add(lbl_course1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 490, 140, 30));

        jLabel21.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Student_Registration_100px_2.png"))); // NOI18N
        jLabel21.setText(" Student Details");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 290, -1));

        lbl_StudentError.setBackground(new java.awt.Color(255, 255, 255));
        lbl_StudentError.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_StudentError.setForeground(new java.awt.Color(255, 255, 255));
        lbl_StudentError.setText("Quantity :");
        jPanel4.add(lbl_StudentError, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 690, 320, -1));

        panel_main1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 410, 810));

        jPanel9.setBackground(new java.awt.Color(255, 0, 0));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(51, 51, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel22.setText("Back");
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });
        jPanel10.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jPanel9.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 40));

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

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Book ID :");
        jPanel9.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 100, -1));

        jLabel26.setBackground(new java.awt.Color(255, 255, 255));
        jLabel26.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Book Name :");
        jPanel9.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 120, -1));

        jLabel27.setBackground(new java.awt.Color(255, 255, 255));
        jLabel27.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Author :");
        jPanel9.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 100, -1));
        jPanel9.add(lbl_quantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 570, 140, 30));
        jPanel9.add(lbl_bookId1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, 140, 30));
        jPanel9.add(lbl_bookname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, 140, 30));
        jPanel9.add(lbl_author1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 490, 140, 30));

        jLabel32.setBackground(new java.awt.Color(255, 255, 255));
        jLabel32.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Quantity :");
        jPanel9.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 570, 110, -1));

        lbl_BookError1.setBackground(new java.awt.Color(255, 255, 255));
        lbl_BookError1.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_BookError1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_BookError1.setText("Quantity :");
        jPanel9.add(lbl_BookError1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 690, 320, -1));

        panel_main1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 810));

        jLabel28.setBackground(new java.awt.Color(255, 0, 0));
        jLabel28.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 0, 0));
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel28.setText("  Issue Book");
        jLabel28.setToolTipText("");
        panel_main1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 140, 290, -1));

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

        panel_main1.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 220, 330, 5));

        txt_studentId2.setText("Enter Book ID");
        txt_studentId2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 0, 0)));
        txt_studentId2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentId2FocusLost(evt);
            }
        });
        txt_studentId2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentId2ActionPerformed(evt);
            }
        });
        panel_main1.add(txt_studentId2, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 330, 270, 30));

        jLabel29.setBackground(new java.awt.Color(255, 0, 0));
        jLabel29.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 0, 0));
        jLabel29.setText(" Book ID :");
        panel_main1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 340, -1, -1));

        jLabel30.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 0, 0));
        jLabel30.setText("Issued Date: ");
        panel_main1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 550, -1, -1));

        txt_studentId3.setText(" Enter Student ID");
        txt_studentId3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 0, 0)));
        txt_studentId3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentId3FocusLost(evt);
            }
        });
        txt_studentId3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentId3ActionPerformed(evt);
            }
        });
        panel_main1.add(txt_studentId3, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 450, 270, 30));

        date_isuueDate.setColorBackground(new java.awt.Color(255, 0, 0));
        date_isuueDate.setColorDiaActual(new java.awt.Color(255, 0, 0));
        date_isuueDate.setColorForeground(new java.awt.Color(255, 0, 0));
        date_isuueDate.setPlaceholder("Selecte Issue Date");
        panel_main1.add(date_isuueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 540, 270, -1));

        jLabel31.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 0, 0));
        jLabel31.setText(" Student ID :");
        panel_main1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 460, -1, -1));

        jLabel18.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 0, 0));
        jLabel18.setText("Due Date");
        panel_main1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 640, -1, -1));

        date_dueDate.setColorBackground(new java.awt.Color(255, 0, 0));
        date_dueDate.setColorDiaActual(new java.awt.Color(255, 0, 0));
        date_dueDate.setColorForeground(new java.awt.Color(255, 0, 0));
        date_dueDate.setPlaceholder("Selecte Due Date");
        panel_main1.add(date_dueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 630, 270, -1));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle3.setText("Issue Book");
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        panel_main1.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 700, 440, 70));

        panel_main.add(panel_main1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1410, 810));

        getContentPane().add(panel_main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1410, 810));

        setBounds(0, 0, 1429, 850);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_jLabel22MouseClicked

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
       if(lbl_quantity1.getText().equals("0")){
       JOptionPane.showMessageDialog(this, "book isn't available");
       }else{
        
        
        if(isAlreadyIssued() == false){
       
        if(issueBook() == true){
       
           JOptionPane.showMessageDialog(this, "Book issued Successfully");
           updateBookCount();
       }else{
       
       JOptionPane.showMessageDialog(this, "Can't issue the book");
       }
       }else{
       JOptionPane.showMessageDialog(this, "this student already has this book ");
       
       }
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed
    }
    private void txt_studentId3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentId3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentId3ActionPerformed

    private void txt_studentId3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentId3FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentId3FocusLost

    private void txt_studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIdActionPerformed

    private void txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusLost
        if(!txt_studentId.getText().equals("")){
            getStudentDetails();
        }
    }//GEN-LAST:event_txt_studentIdFocusLost

    private void txt_studentId2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentId2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentId2ActionPerformed

    private void txt_studentId2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentId2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentId2FocusLost

    private void txt_bookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookIdActionPerformed

    private void txt_bookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookIdFocusLost
        if(!txt_bookId.getText().equals("")){
            getBookDetails();
        }

    }//GEN-LAST:event_txt_bookIdFocusLost

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
            java.util.logging.Logger.getLogger(IssueedBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueedBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueedBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueedBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueedBooks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.componentes.RSDateChooser date_dueDate;
    private rojeru_san.componentes.RSDateChooser date_isuueDate;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lbl_BookError1;
    private javax.swing.JLabel lbl_Branch1;
    private javax.swing.JLabel lbl_StudentError;
    private javax.swing.JLabel lbl_author1;
    private javax.swing.JLabel lbl_bookId1;
    private javax.swing.JLabel lbl_bookname1;
    private javax.swing.JLabel lbl_course1;
    private javax.swing.JLabel lbl_quantity1;
    private javax.swing.JLabel lbl_studentId1;
    private javax.swing.JLabel lbl_studentname1;
    private javax.swing.JPanel panel_main;
    private javax.swing.JPanel panel_main1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private javax.swing.JTextField txt_bookId;
    private javax.swing.JTextField txt_studentId;
    private javax.swing.JTextField txt_studentId2;
    private javax.swing.JTextField txt_studentId3;
    // End of variables declaration//GEN-END:variables
}
