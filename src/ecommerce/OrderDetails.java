/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Raheela Khanum
 */
public class OrderDetails extends javax.swing.JFrame {

    /**
     * Creates new form OrderDetails
     */
    
    Connection con;
    PreparedStatement ps; 
    ResultSet rs;
    boolean Signin;
    String Name;
    String ID; 
    
    public OrderDetails(String id,String name,boolean Signin) {
        initComponents();
        Connect();
        this.Name=name;
        this.Signin=Signin;
        this.ID=id;
       //this.Signin=Signin;
       //DateTimeFormatter daa=DateTimeFormatter.ofPattern("yyyy-MM-dd");
       //LocalDateTime now=LocalDateTime.now();
       //String date=daa.format(now);
    }

    
    
    public void Connect()
      {
          try{
              Class.forName("com.mysql.cj.jdbc.Driver");
              con = DriverManager.getConnection("jdbc:mysql://localhost/ecommerce","root","Ruk@413255");
              }
          catch(ClassNotFoundException ex)
              {Logger.getLogger(userlog.class.getName()).log(Level.SEVERE, null, ex);
               }
          catch (SQLException ex) {
            Logger.getLogger(userlog.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        OK = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(740, 450));
        setPreferredSize(new java.awt.Dimension(740, 450));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setText("Select date for delivery");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 40, 230, 37);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel2.setText("Enter shipment address");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 110, 220, 40);

        jDateChooser1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        getContentPane().add(jDateChooser1);
        jDateChooser1.setBounds(240, 30, 270, 60);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(110, 160, 290, 100);

        OK.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        OK.setText("OK");
        OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKActionPerformed(evt);
            }
        });
        getContentPane().add(OK);
        OK.setBounds(30, 330, 110, 50);

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(200, 330, 120, 50);

        jLabel3.setIcon(new javax.swing.ImageIcon("G:\\Ruksar 5thsem\\Project\\Icons&Images\\OrderDet.jpg")); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 730, 420);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKActionPerformed
        // TODO add your handling code here:
        //Date date=jDateChooser1.getDate();
        
       DateTimeFormatter daa=DateTimeFormatter.ofPattern("yyyy-MM-dd");
       LocalDateTime now=LocalDateTime.now();
       String date=daa.format(now);
       String Address=jTextArea1.getText();
        int UID=Integer.parseInt(ID);
         try{
             
             ps=con.prepareStatement("insert into orders(u_id,date,address) values(?,?,?)");
            
             ps.setInt(1,UID);
             ps.setString(2,date);
             ps.setString(3,Address);
            
             ps.executeUpdate();
             
              ps=con.prepareStatement("select * from user where u_id=?");
              ps.setInt(1,UID);
             if(rs.next())
             {
                 Name=rs.getString("name");
             }
              
              JOptionPane.showMessageDialog(this,"Your order will be delivered shortly! Thank You!");
            
             
             userpage u=new userpage(ID,Name,Signin);
             ps=con.prepareStatement("delete from cart where u_id=?");
             ps.setInt(1,UID);
             
             ps.executeUpdate();
            this.setVisible(false);
            u.setVisible(true);
           }
        catch (SQLException ex) {
            Logger.getLogger(userlog.class.getName()).log(Level.SEVERE, null, ex);
           }
        
    }//GEN-LAST:event_OKActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        //MyCart cart=new MyCart(ID,Name,Signin);
        //int UID=Integer.parseInt(ID);
        userpage u=new userpage(ID,Name,Signin);
            this.setVisible(false);
            u.setVisible(true);
        //cart.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(OrderDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderDetails("","",true).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton OK;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
