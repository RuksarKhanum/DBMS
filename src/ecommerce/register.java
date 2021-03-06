package ecommerce;
import java.sql.Statement;
import java.sql.ResultSetMetaData;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;


/**
 *
 * @author Raheela Khanum
 */
public class register extends javax.swing.JFrame {

    /**
     * Creates new form register
     */
    public register(String name) {
        initComponents();
        jPanel1.setBackground(new Color(0,0,0,130));
        Connect();
        Update.setVisible(false);
        Delete.setVisible(false);
        Cancel2.setVisible(false);
    }
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String Name;
    boolean Signin;
    String ID;
    
    public register(String id,String name,boolean Signin)
    {
      initComponents();
      this.Name=name;
      this.Signin=Signin;
      this.ID=id;
      int UID=Integer.parseInt(ID);
      Connect();
      jPanel1.setBackground(new Color(0,0,0,130));
      
      Signup.setVisible(false);
      Cancel1.setVisible(false);
      Password.setVisible(false);
      jLabel6.setVisible(false);
        
         try{
             
             String sql = "select * from user where u_id= ?";
             ps= con.prepareStatement(sql);
             ps.setInt(1,UID);
             
             ResultSet rs = ps.executeQuery();
             
             if(rs.next()){
                 Username.setText(rs.getString("name"));
                 Phone.setText(rs.getString("phone"));
                 Email.setText(rs.getString("email"));
                 Address.setText(rs.getString("address"));
             }
             //this.setVisible(false);
                    //userpage u=new userpage(name,Signin);
                    //u.setVisible(true);
         }
         catch (SQLException ex) {
            Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
           }
         
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Username = new javax.swing.JTextField();
        Phone = new javax.swing.JTextField();
        Email = new javax.swing.JTextField();
        Address = new javax.swing.JTextField();
        Password = new javax.swing.JPasswordField();
        Signup = new javax.swing.JButton();
        Cancel1 = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        Cancel2 = new javax.swing.JButton();
        NameValidationLabel = new javax.swing.JLabel();
        PhoneValidationLabel = new javax.swing.JLabel();
        EmailValidationLabel = new javax.swing.JLabel();
        PasswordValidationLabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        PasswordValidationLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1550, 800));
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CREATE ACCOUNT");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 10, 470, 40);

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("User Name");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 70, 140, 40);

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Phone");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(50, 140, 118, 30);

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Email");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(50, 200, 118, 30);

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Address");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(40, 260, 118, 30);

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Password");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(30, 320, 118, 34);

        Username.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        Username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                UsernameKeyReleased(evt);
            }
        });
        jPanel1.add(Username);
        Username.setBounds(160, 70, 250, 40);

        Phone.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        Phone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PhoneKeyReleased(evt);
            }
        });
        jPanel1.add(Phone);
        Phone.setBounds(160, 130, 250, 40);

        Email.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        Email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                EmailKeyReleased(evt);
            }
        });
        jPanel1.add(Email);
        Email.setBounds(160, 190, 250, 40);

        Address.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jPanel1.add(Address);
        Address.setBounds(160, 250, 250, 40);

        Password.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        Password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PasswordKeyReleased(evt);
            }
        });
        jPanel1.add(Password);
        Password.setBounds(160, 320, 250, 40);

        Signup.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Signup.setText("Sign up");
        Signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignupActionPerformed(evt);
            }
        });
        jPanel1.add(Signup);
        Signup.setBounds(60, 390, 130, 40);

        Cancel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Cancel1.setText("Cancel");
        Cancel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cancel1ActionPerformed(evt);
            }
        });
        jPanel1.add(Cancel1);
        Cancel1.setBounds(220, 390, 130, 40);

        Update.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Update.setText("Update");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });
        jPanel1.add(Update);
        Update.setBounds(10, 450, 130, 40);

        Delete.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });
        jPanel1.add(Delete);
        Delete.setBounds(160, 450, 120, 40);

        Cancel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Cancel2.setText("Cancel");
        Cancel2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cancel2ActionPerformed(evt);
            }
        });
        jPanel1.add(Cancel2);
        Cancel2.setBounds(300, 450, 120, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(490, 160, 450, 520);

        NameValidationLabel.setBackground(new java.awt.Color(242, 242, 242));
        NameValidationLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        NameValidationLabel.setForeground(new java.awt.Color(255, 0, 0));
        NameValidationLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        NameValidationLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        getContentPane().add(NameValidationLabel);
        NameValidationLabel.setBounds(950, 230, 320, 30);

        PhoneValidationLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        PhoneValidationLabel.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(PhoneValidationLabel);
        PhoneValidationLabel.setBounds(950, 290, 330, 30);

        EmailValidationLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        EmailValidationLabel.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(EmailValidationLabel);
        EmailValidationLabel.setBounds(950, 350, 330, 30);

        PasswordValidationLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        PasswordValidationLabel.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(PasswordValidationLabel);
        PasswordValidationLabel.setBounds(970, 460, 570, 40);

        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 3, 48)); // NOI18N
        jLabel8.setText("Shopper's Stall");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(550, 70, 400, 60);

        PasswordValidationLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        PasswordValidationLabel2.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(PasswordValidationLabel2);
        PasswordValidationLabel2.setBounds(980, 500, 530, 40);

        jLabel7.setIcon(new javax.swing.ImageIcon("G:\\Ruksar 5thsem\\Project\\Icons&Images\\reg1 page.jpeg")); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(0, 0, 1550, 800);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignupActionPerformed
        // TODO add your handling code here:
        
        
        String name=Username.getText();
        String phone=Phone.getText();
        String email=Email.getText();
        String address=Address.getText();
        String password=Password.getText();
       
         if(name.isEmpty() || phone.isEmpty() || email.isEmpty() || address.isEmpty() || password.isEmpty() )
        {
            JOptionPane.showMessageDialog(this, "Please fill all details !!!!");
        }
         else
         {
        
        try{
             String query="insert into user(name,phone,email,address,password)values(?,?,?,?,?)";
             ps=con.prepareStatement(query,ps.RETURN_GENERATED_KEYS);
             
             ps.setString(1,name);
             ps.setString(2,phone);
             ps.setString(3,email);
             ps.setString(4,address);
             ps.setString(5,password);
             ps.executeUpdate();
             rs=ps.getGeneratedKeys();
             if(rs.next())
             {
                 JOptionPane.showMessageDialog(this,"Registered successfully!");
                 //String uid=rs.getString("u_id");
                 this.setVisible(false);
                 userpage u=new userpage(name,true);
                 u.setVisible(true);
             }
             
             
             
             Username.setText("");
             Phone.setText("");
             Email.setText("");
             Address.setText("");
             Password.setText("");
             
            
           }
        catch (SQLException ex) {
            Logger.getLogger(userlog.class.getName()).log(Level.SEVERE, null, ex);
           }
         }
        
    }//GEN-LAST:event_SignupActionPerformed

    private void Cancel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cancel1ActionPerformed
        // TODO add your handling code here:
        new userlog().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_Cancel1ActionPerformed

    private void UsernameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UsernameKeyReleased
        // TODO add your handling code here:
        String PATTERN ="^[a-zA-Z\\s]{0,120}$";//"^[A-Za-z]+[ '-][A-Za-z][ '-][A-Za-z]+{0,120}$";//[A-Z]+([ '-][a-zA-Z]+)
        Pattern pat = Pattern.compile(PATTERN);
        Matcher match = pat.matcher(Username.getText());
        if(!match.matches())
        {
            NameValidationLabel.setText("Invalid Name!");
            
        }
        else 
        {
            NameValidationLabel.setText(null);

        }

    }//GEN-LAST:event_UsernameKeyReleased

    private void PhoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PhoneKeyReleased
        // TODO add your handling code here:
        String PATTERN ="^[0-9]{0,10}$";
        Pattern pat = Pattern.compile(PATTERN);
        Matcher match = pat.matcher(Phone.getText());
        if(!match.matches())
        {
            PhoneValidationLabel.setText("Phone number is invalid!");
        }
        else
        {
            PhoneValidationLabel.setText(null);
        }

    }//GEN-LAST:event_PhoneKeyReleased

    private void EmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EmailKeyReleased
        // TODO add your handling code here:
        //String PATTERN ="^[a-zA-Z0-9._+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";//"^[a-zA-Z0-9]{0,30}@[a-zA-Z0-9]{0,10}[.][a-zA-Z]{0,5}$";
         String PATTERN ="^[a-zA-Z0-9]{0,30}@[a-zA-Z0-9]{0,10}[.][a-zA-Z]{0,5}$";
        Pattern pat = Pattern.compile(PATTERN);
        Matcher match = pat.matcher(Email.getText());
        if(!match.matches())
        {
            EmailValidationLabel.setText("Invalid Email!");
        }
        else 
        {
            EmailValidationLabel.setText(null);
        }

    }//GEN-LAST:event_EmailKeyReleased

    private void PasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PasswordKeyReleased
        // TODO add your handling code here:
        //
        String PATTERN ="^[a-zA-Z0-9!@#$%^&*_+-=]{8,10}";
        Pattern pat = Pattern.compile(PATTERN);
        Matcher match = pat.matcher(Password.getText());
        if(!match.matches()){
            PasswordValidationLabel.setText("Must Contain 8-10 characters only!!!");
        
            String PAT ="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,256}$";  
             //eg.it will accept srtong passwd like Sumaaiya@123(uppercase, lower, symbol and numbers)String PATTERN ="^[a-zA-Z0-9!@#$%^&*_+-=]{8,10}";
            Pattern pa = Pattern.compile(PAT);
            Matcher ma = pa.matcher(Password.getText());
            if(!ma.matches()){
                PasswordValidationLabel2.setText("Weak Password!!!");
             }
            else{
            PasswordValidationLabel2.setText(null);
        }
        }
        else{
            PasswordValidationLabel.setText(null);
        }

    }//GEN-LAST:event_PasswordKeyReleased

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        // TODO add your handling code here:
        int UID=Integer.parseInt(ID);
        try{
            Connect();
            ps= con.prepareStatement( "update user set name = ?, phone = ?, email = ?, address = ? where  u_id= ?");
            
            ps.setString(1, Username.getText());
            ps.setString(2, Phone.getText());
            ps.setString(3, Email.getText());
            ps.setString(4, Address.getText());
            ps.setInt(5,UID);
            
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(this,"Update Successful !!!");
            this.setVisible(false);
            userpage u=new userpage(ID,Name,Signin);
            u.setVisible(true);
        }
        catch(SQLException ex)
        {
            Logger.getLogger(register.class.getName()).log(Level.SEVERE,null,ex);
        }

    }//GEN-LAST:event_UpdateActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        // TODO add your handling code here:
        int UID=Integer.parseInt(ID);
        int opt=JOptionPane.showConfirmDialog(null,"Are you sure to delete?","Delete",JOptionPane.YES_NO_OPTION);
        if(opt==0)
        {
        try{
            Connect();
            ps= con.prepareStatement("delete from user where u_id= ?");
            ps.setInt(1,UID);
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(this,"Account deleted Successfully !");
            
            Signin=false;
            this.setVisible(false);
            userpage u = new userpage("",Signin);
            u.setVisible(true);
        } 
        catch(SQLException ex)
        {
            Logger.getLogger(register.class.getName()).log(Level.SEVERE,null,ex);
        }
        }
    }//GEN-LAST:event_DeleteActionPerformed

    private void Cancel2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cancel2ActionPerformed
        // TODO add your handling code here:
        Signin=false;
        userpage u=new userpage(Name,Signin);
        u.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_Cancel2ActionPerformed

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
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new register("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Address;
    private javax.swing.JButton Cancel1;
    private javax.swing.JButton Cancel2;
    private javax.swing.JButton Delete;
    private javax.swing.JTextField Email;
    private javax.swing.JLabel EmailValidationLabel;
    private javax.swing.JLabel NameValidationLabel;
    private javax.swing.JPasswordField Password;
    private javax.swing.JLabel PasswordValidationLabel;
    private javax.swing.JLabel PasswordValidationLabel2;
    private javax.swing.JTextField Phone;
    private javax.swing.JLabel PhoneValidationLabel;
    private javax.swing.JButton Signup;
    private javax.swing.JButton Update;
    private javax.swing.JTextField Username;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
