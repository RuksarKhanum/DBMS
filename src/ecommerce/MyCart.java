/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce;

import java.awt.Color;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Raheela Khanum
 */
public class MyCart extends javax.swing.JFrame {

    /**
     * Creates new form MyCart
     */
    public MyCart() {
        initComponents();
    }
    
    Connection con;
    PreparedStatement ps; 
    ResultSet rs;
    boolean Signin;
    String Name;
    String ID;
    
    public MyCart(String name,boolean Signin) {
      initComponents(); 
      Connect();
      this.Name=name;
      this.Signin=Signin;
       
      cartTable();
      
    }
    
    public MyCart(String id,String name,boolean Signin) {
     initComponents(); 
      Connect();
      this.Name=name;
      this.Signin=Signin;
       this.ID=id;    
      cartTable();
      jLabel3.setText(ID);
      
      
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
    
    public void cartTable()
    {
        int U_ID=Integer.parseInt(ID);
        //int U_ID=Integer.parseInt(jLabel3.getText());
         cartTable.setBackground(new Color(137, 196, 244, 1));
         //cartTable.getColumnModel().getColumn(0).setPreferredWidth(0);
         cartTable.getColumnModel().getColumn(0).setPreferredWidth(700);
         cartTable.getColumnModel().getColumn(1).setPreferredWidth(200);
         cartTable.getColumnModel().getColumn(2).setPreferredWidth(300);
         cartTable.getColumnModel().getColumn(3).setPreferredWidth(300);
         cartTable.getColumnModel().getColumn(4).setPreferredWidth(0);
         //Color background=new Color(0,0,0,0);
        try
        {                      
           ps=con.prepareStatement("select * from cart where u_id=?");
           ps.setInt(1,U_ID);
           rs=ps.executeQuery();
           
           ResultSetMetaData Rsm=rs.getMetaData();
           int c;
           c=Rsm.getColumnCount();
           
           DefaultTableModel d1=(DefaultTableModel)cartTable.getModel();
           d1.setRowCount(0);
           
           while(rs.next())
           {
              
               Vector v2=new Vector();
               for(int i=1;i<=c;i++)
               {
                  
                   v2.add(rs.getString("p_name"));
                   v2.add(rs.getInt("quantity"));
                   v2.add(rs.getInt("price"));
                   v2.add(rs.getInt("totalPrice"));
                   v2.add(rs.getString("p_id"));
                   
               }
               d1.addRow(v2);
               
           }
          
           int sum=0;
           int i;
           for(i=0;i<cartTable.getRowCount();i++)
           {
               sum=sum + Integer.parseInt(cartTable.getValueAt(i, 3).toString());
           }
           TotalAmount.setText(Integer.toString(sum));
       
           
        } catch (SQLException ex) {
            Logger.getLogger(MobilesAndAccessories.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }     
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Home = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cartTable = new javax.swing.JTable();
        PlaceOrder = new javax.swing.JButton();
        TotalLabel = new javax.swing.JLabel();
        TotalAmount = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(1550, 800));
        jPanel1.setLayout(null);

        Home.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Home.setIcon(new javax.swing.ImageIcon("G:\\Ruksar 5thsem\\Project\\Icons&Images\\Home.png")); // NOI18N
        Home.setText("Home");
        Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeActionPerformed(evt);
            }
        });
        jPanel1.add(Home);
        Home.setBounds(0, 0, 131, 49);

        jLabel1.setBackground(new java.awt.Color(0, 0, 102));
        jLabel1.setFont(new java.awt.Font("Cambria", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 255, 255));
        jLabel1.setText("Shopper's Stall");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(660, 0, 170, 50);

        cartTable.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        cartTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Product", "Quantity", "Price", "Total Price", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        cartTable.setColumnSelectionAllowed(true);
        cartTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cartTable.setOpaque(false);
        cartTable.setRowHeight(60);
        cartTable.setShowHorizontalLines(false);
        cartTable.setShowVerticalLines(false);
        cartTable.getTableHeader().setReorderingAllowed(false);
        cartTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(cartTable);
        cartTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (cartTable.getColumnModel().getColumnCount() > 0) {
            cartTable.getColumnModel().getColumn(0).setResizable(false);
            cartTable.getColumnModel().getColumn(1).setResizable(false);
            cartTable.getColumnModel().getColumn(2).setResizable(false);
            cartTable.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(60, 100, 1440, 610);

        PlaceOrder.setBackground(new java.awt.Color(153, 204, 255));
        PlaceOrder.setFont(new java.awt.Font("Candara", 1, 24)); // NOI18N
        PlaceOrder.setForeground(new java.awt.Color(0, 0, 153));
        PlaceOrder.setText("Place Order");
        PlaceOrder.setOpaque(false);
        PlaceOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlaceOrderActionPerformed(evt);
            }
        });
        jPanel1.add(PlaceOrder);
        PlaceOrder.setBounds(790, 720, 210, 60);

        TotalLabel.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        TotalLabel.setForeground(new java.awt.Color(0, 204, 204));
        TotalLabel.setText("Total");
        jPanel1.add(TotalLabel);
        TotalLabel.setBounds(1230, 720, 70, 50);

        TotalAmount.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        TotalAmount.setForeground(new java.awt.Color(102, 255, 255));
        jPanel1.add(TotalAmount);
        TotalAmount.setBounds(1310, 720, 180, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon("G:\\Ruksar 5thsem\\Project\\Icons&Images\\1.jpg")); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 0, 1550, 800);

        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(290, 30, 50, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void PlaceOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlaceOrderActionPerformed
        // TODO add your handling code here:
        OrderDetails od=new OrderDetails(ID,Name,Signin);
        this.setVisible(false);
        od.setVisible(true);
    }//GEN-LAST:event_PlaceOrderActionPerformed

    private void HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeActionPerformed
        // TODO add your handling code here:
        
         try {
                int U_ID=Integer.parseInt(jLabel3.getText());
            ps=con.prepareStatement("select * from user where u_id=?");
            ps.setInt(1,U_ID);
            rs=ps.executeQuery();
            
            if(rs.next())
            {
                ID=jLabel3.getText();
                String N=rs.getString("name");
                Signin=true;
                userpage u=new userpage(ID,N,true);
                this.setVisible(false);
                u.setVisible(true);
            }
            
        }
        
        catch (SQLException ex) {
            Logger.getLogger(MyCart.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_HomeActionPerformed

    
    MyCartSelectedRow r=new MyCartSelectedRow(ID,Name,Signin);
    
    private void cartTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartTableMouseClicked
        // TODO add your handling code here:
        int index=cartTable.getSelectedRow();
            TableModel model=cartTable.getModel();
            
            String ProductName=model.getValueAt(index,0).toString();
            String Quantity=model.getValueAt(index,1).toString();
            String Price=model.getValueAt(index,2).toString();
            String TotalPrice=model.getValueAt(index,3).toString();
            String PID=model.getValueAt(index,4).toString();
            int q=Integer.parseInt(Quantity);
           
            this.setVisible(false);
            r.setVisible(true);
            r.pack();
            r.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            r.pname.setText(ProductName);
            r.quan.setValue(q);
            r.cost.setText(Price);
            r.totcost.setText(TotalPrice);
            r.jLabel5.setText(PID);
            r.jLabel6.setText(ID);  
        
    }//GEN-LAST:event_cartTableMouseClicked

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
            java.util.logging.Logger.getLogger(MyCart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyCart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyCart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyCart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyCart("4","Sneha",true).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Home;
    private javax.swing.JButton PlaceOrder;
    private javax.swing.JLabel TotalAmount;
    private javax.swing.JLabel TotalLabel;
    public javax.swing.JTable cartTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}