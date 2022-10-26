/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jfame;

import java.awt.BorderLayout;
import java.awt.Paint;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.scene.AmbientLight;
import javafx.scene.shape.Sphere;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.paint.Color;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.collections.FXCollections;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Ahmed Alaa
 */
public class HomePage extends javax.swing.JFrame {

    /**
     * Creates new form HomePage
     */
    
   
    DefaultTableModel model;
    public HomePage() {
        initComponents();
        showPieChart();
        setStudentdetails();
        setbookdetails();
        setDataToCards();
    }
    
    public void setbookdetails(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from book_details");
            
            while(rs.next()){
                String bookId = rs.getString("book_id");
                String bookName = rs.getString("book_name");
                String author = rs.getString("author");
                int quantity = rs.getInt("quantity");
                
                Object []obj = {bookId, bookName, author, quantity};
                model = (DefaultTableModel) tbl_bookDetails.getModel();
                model.addRow(obj);
                
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        
        
 
    
    }
    public void setDataToCards(){
    Statement st = null;
    ResultSet rs = null;
    
     long l = System.currentTimeMillis();
     Date todaysDate = new Date(l);
     
        try {
            Connection con = DataBaseConnection.getconnection();
            st = con.createStatement();
            
            rs=  st.executeQuery("select * from book_details");
            rs.last();
           lbl_numOfBooks.setText( Integer.toString(rs.getRow()));
           rs = st.executeQuery("select * from student_details");
                  rs.last();
           lbl_numOfStudents.setText( Integer.toString(rs.getRow()));
           
            rs = st.executeQuery("select * from issue_book_details where status = '"+"pending"+"'");
                  rs.last();
           lbl_issueBooks.setText( Integer.toString(rs.getRow()));
           
           
           rs = st.executeQuery("select * from issue_book_details where due_date < '"+todaysDate+"' and status ='"+"pending"+"' ");
                  rs.last();
           lbl_defaulterList.setText( Integer.toString(rs.getRow()));
           
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    
    }
    
     //set the book details into the Table
    public void setStudentdetails(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from student_details");
            
            while(rs.next()){
                String StudentId = rs.getString("student_id");
                String StudentName = rs.getString("name");
                String course = rs.getString("Course");
                String branch = rs.getString("branch");
                
                Object []obj = {StudentId, StudentName, course, branch};
                model = (DefaultTableModel) tbl_StudentDetails.getModel();
                model.addRow(obj);
                
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        
        
 
    
    }
    
  public void showPieChart(){
        
        //create dataset
      DefaultPieDataset barDataset = new DefaultPieDataset( );
      try {
          Connection con = DataBaseConnection.getconnection();
          String sql = "select book_name ,count(*) as issue_count from issue_book_details group by book_id";
          Statement st = con.createStatement();
          ResultSet rs = st.executeQuery(sql);
          barDataset.setValue(rs.getString("book_name"), new Double(rs.getDouble("issue_count")));
      } catch (Exception e) {
          e.printStackTrace();
      }
      
       
       
      
      //create chart
       JFreeChart piechart = ChartFactory.createPieChart("Issue Book Details",barDataset, true,true,false);//explain
      
        PiePlot piePlot =(PiePlot) piechart.getPlot();
      
       //changing pie chart blocks colors
        piePlot.setSectionPaint("IPhone 5s", new java.awt.Color(255,255,102));
        piePlot.setSectionPaint("SamSung Grand", new java.awt.Color(102,255,102));
        piePlot.setSectionPaint("MotoG", new java.awt.Color(255,102,153));
        piePlot.setSectionPaint("Nokia Lumia", new java.awt.Color(0,204,204));
        
      
       
        //piePlot.setBackgroundPaint(Color.white);
        
        //create chartPanel to display chart(graph)
        ChartPanel barChartPanel = new ChartPanel(piechart);
        PanelPiechart.removeAll();
        PanelPiechart.add(barChartPanel, BorderLayout.CENTER);
        PanelPiechart.validate();
    }

  
  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panel1 = new java.awt.Panel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        manage_books = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        lbl_numOfBooks = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        lbl_numOfStudents = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        lbl_issueBooks = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        lbl_defaulterList = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_bookDetails = new rojerusan.RSTableMetro();
        jLabel20 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_StudentDetails = new rojerusan.RSTableMetro();
        PanelPiechart = new javax.swing.JPanel();

        jLabel11.setText("jLabel11");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 102, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_menu_48px_1.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 5, 50));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/male_user_50px.png"))); // NOI18N
        jLabel2.setText("Welcome,Admin");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1630, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Library Management System");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1900, 70));

        panel1.setBackground(new java.awt.Color(51, 51, 51));
        panel1.setForeground(new java.awt.Color(51, 51, 51));
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 102, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel4.setText("Home Page");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        panel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 340, 60));

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel7.setText("LMS Dashboard");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        panel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 340, 60));

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Features");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        panel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 340, 60));

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        manage_books.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        manage_books.setForeground(new java.awt.Color(255, 255, 255));
        manage_books.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Book_26px.png"))); // NOI18N
        manage_books.setText("Manage Books");
        manage_books.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                manage_booksMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                manage_booksMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                manage_booksMouseExited(evt);
            }
        });
        jPanel6.add(manage_books, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        panel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 340, 60));

        jPanel7.setBackground(new java.awt.Color(51, 51, 51));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel7MouseExited(evt);
            }
        });
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Read_Online_26px.png"))); // NOI18N
        jLabel9.setText("Manage Students");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel9MouseEntered(evt);
            }
        });
        jPanel7.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        panel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 340, 60));

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel8MouseEntered(evt);
            }
        });
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Sell_26px.png"))); // NOI18N
        jLabel10.setText("Issue Book");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel8.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        panel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 340, 60));

        jPanel9.setBackground(new java.awt.Color(51, 51, 51));
        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel9MouseEntered(evt);
            }
        });
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Return_Purchase_26px.png"))); // NOI18N
        jLabel12.setText("Return Book");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel9.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        panel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 340, 60));

        jPanel10.setBackground(new java.awt.Color(51, 51, 51));
        jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel10MouseEntered(evt);
            }
        });
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_View_Details_26px.png"))); // NOI18N
        jLabel13.setText("View Records");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        jPanel10.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        panel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 340, 60));

        jPanel11.setBackground(new java.awt.Color(51, 51, 51));
        jPanel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel11MouseEntered(evt);
            }
        });
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Books_26px.png"))); // NOI18N
        jLabel14.setText("View Issued Books");
        jLabel14.setToolTipText("");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        jPanel11.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        panel1.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 340, 60));

        jPanel12.setBackground(new java.awt.Color(51, 51, 51));
        jPanel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel12MouseEntered(evt);
            }
        });
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Conference_26px.png"))); // NOI18N
        jLabel15.setText("Defaulter list");
        jLabel15.setToolTipText("");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        jPanel12.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        panel1.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 600, 340, 60));

        jPanel13.setBackground(new java.awt.Color(51, 51, 255));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Exit_26px_2.png"))); // NOI18N
        jLabel5.setText("Logout");
        jLabel5.setToolTipText("");
        jPanel13.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        panel1.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 670, 340, 60));

        getContentPane().add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 960));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setForeground(new java.awt.Color(255, 255, 255));
        jPanel14.setPreferredSize(new java.awt.Dimension(260, 1));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel15.setBackground(new java.awt.Color(204, 204, 204));
        jPanel15.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 0, 102)));
        jPanel15.setPreferredSize(new java.awt.Dimension(260, 1));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_numOfBooks.setFont(new java.awt.Font("Segoe UI Black", 1, 50)); // NOI18N
        lbl_numOfBooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Book_Shelf_50px.png"))); // NOI18N
        lbl_numOfBooks.setText("10");
        jPanel15.add(lbl_numOfBooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 120, 60));

        jPanel14.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 260, 140));

        jLabel16.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("Book Details");
        jPanel14.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 660, 260, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setText("No of Student ");
        jPanel14.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, 260, -1));

        jPanel16.setBackground(new java.awt.Color(204, 204, 204));
        jPanel16.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 51, 51)));
        jPanel16.setPreferredSize(new java.awt.Dimension(260, 1));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_numOfStudents.setFont(new java.awt.Font("Segoe UI Black", 1, 50)); // NOI18N
        lbl_numOfStudents.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_People_50px.png"))); // NOI18N
        lbl_numOfStudents.setText("10");
        jPanel16.add(lbl_numOfStudents, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 120, 60));

        jPanel14.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, 260, 140));

        jPanel17.setBackground(new java.awt.Color(204, 204, 204));
        jPanel17.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 0, 102)));
        jPanel17.setPreferredSize(new java.awt.Dimension(260, 1));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_issueBooks.setFont(new java.awt.Font("Segoe UI Black", 1, 50)); // NOI18N
        lbl_issueBooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Sell_50px.png"))); // NOI18N
        lbl_issueBooks.setText("10");
        jPanel17.add(lbl_issueBooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 120, 60));

        jLabel24.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(102, 102, 102));
        jLabel24.setText("No of Books ");
        jPanel17.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, 260, -1));

        jPanel14.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 90, 260, 140));

        jLabel21.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setText("Issued Books");
        jPanel14.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 60, 260, -1));

        jLabel25.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(102, 102, 102));
        jLabel25.setText("Defaulter list");
        jPanel14.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 60, 260, -1));

        jPanel18.setBackground(new java.awt.Color(204, 204, 204));
        jPanel18.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 0, 102)));
        jPanel18.setPreferredSize(new java.awt.Dimension(260, 1));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_defaulterList.setFont(new java.awt.Font("Segoe UI Black", 1, 50)); // NOI18N
        lbl_defaulterList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_List_of_Thumbnails_50px.png"))); // NOI18N
        lbl_defaulterList.setText("10");
        jPanel18.add(lbl_defaulterList, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 120, 60));

        jLabel28.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(102, 102, 102));
        jLabel28.setText("No of Books ");
        jPanel18.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, 260, -1));

        jPanel14.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 90, 260, 140));

        tbl_bookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "BookId", "Name", "Author", "Quantity"
            }
        ));
        tbl_bookDetails.setColorBackgoundHead(new java.awt.Color(255, 51, 51));
        tbl_bookDetails.setColorBordeFilas(new java.awt.Color(255, 51, 51));
        tbl_bookDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_bookDetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tbl_bookDetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        tbl_bookDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        tbl_bookDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        tbl_bookDetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        tbl_bookDetails.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tbl_bookDetails.setRowHeight(44);
        jScrollPane1.setViewportView(tbl_bookDetails);

        jPanel14.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 700, 760, 300));

        jLabel20.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 102, 102));
        jLabel20.setText("No of Books ");
        jPanel14.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 260, -1));

        jLabel23.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(102, 102, 102));
        jLabel23.setText("Student Details");
        jPanel14.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 260, -1));

        tbl_StudentDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "StudentId", "Name", "Course", "Branch"
            }
        ));
        tbl_StudentDetails.setColorBackgoundHead(new java.awt.Color(255, 51, 51));
        tbl_StudentDetails.setColorBordeFilas(new java.awt.Color(255, 51, 51));
        tbl_StudentDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_StudentDetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tbl_StudentDetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        tbl_StudentDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        tbl_StudentDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        tbl_StudentDetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        tbl_StudentDetails.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tbl_StudentDetails.setRowHeight(44);
        jScrollPane3.setViewportView(tbl_StudentDetails);

        jPanel14.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 760, 300));

        PanelPiechart.setBackground(new java.awt.Color(255, 255, 255));
        PanelPiechart.setLayout(new java.awt.BorderLayout());
        jPanel14.add(PanelPiechart, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 350, 540, 450));

        getContentPane().add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 1570, 950));

        setSize(new java.awt.Dimension(1919, 1071));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void manage_booksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manage_booksMouseClicked
       ManageBooks books = new ManageBooks();
       books.setVisible(true);
       dispose();
    }//GEN-LAST:event_manage_booksMouseClicked

    private void manage_booksMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manage_booksMouseEntered
       jPanel6.setBackground(java.awt.Color.getHSBColor(0, 0,0));
    }//GEN-LAST:event_manage_booksMouseEntered

    private void manage_booksMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manage_booksMouseExited
       jPanel6.setBackground(java.awt.Color.getHSBColor(500,0,0));
    }//GEN-LAST:event_manage_booksMouseExited

    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseEntered
       jPanel7.setBackground(java.awt.Color.getHSBColor(0, 0,0));
    }//GEN-LAST:event_jLabel9MouseEntered

    private void jPanel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseExited
         jPanel7.setBackground(java.awt.Color.getHSBColor(500,0,0));
    }//GEN-LAST:event_jPanel7MouseExited

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        ManageStudents student = new ManageStudents();
        student.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
       IssueedBooks book = new IssueedBooks();
       book.setVisible(true);
       dispose();
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
       ReturnBook book = new ReturnBook();
       book.setVisible(true);
       dispose();
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jPanel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseEntered
       jPanel9.setBackground(java.awt.Color.black);
    }//GEN-LAST:event_jPanel9MouseEntered

    private void jPanel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseEntered
       jPanel8.setBackground(java.awt.Color.black);
    }//GEN-LAST:event_jPanel8MouseEntered

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        ViewAllRecord view = new ViewAllRecord();
        view.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jPanel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseEntered
        jPanel10.setBackground(java.awt.Color.black);
    }//GEN-LAST:event_jPanel10MouseEntered

    private void jPanel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseEntered
    jPanel11.setBackground(java.awt.Color.black);
    }//GEN-LAST:event_jPanel11MouseEntered

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        IssueBookDetails book = new IssueBookDetails();
        book.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jPanel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseEntered
       jPanel12.setBackground(java.awt.Color.black);
    }//GEN-LAST:event_jPanel12MouseEntered

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        DefaulterList list = new DefaulterList();
        list.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel15MouseClicked

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
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelPiechart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_defaulterList;
    private javax.swing.JLabel lbl_issueBooks;
    private javax.swing.JLabel lbl_numOfBooks;
    private javax.swing.JLabel lbl_numOfStudents;
    private javax.swing.JLabel manage_books;
    private java.awt.Panel panel1;
    private rojerusan.RSTableMetro tbl_StudentDetails;
    private rojerusan.RSTableMetro tbl_bookDetails;
    // End of variables declaration//GEN-END:variables
}
