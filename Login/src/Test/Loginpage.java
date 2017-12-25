package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Loginpage extends javax.swing.JFrame {

    public Loginpage() {
        initComponents();
        getConnection();
    }

    
    public Connection getConnection()
    {
        Connection con =null;
        try {
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl1","system","Welcome1");
            JOptionPane.showMessageDialog(null,"Connected");
            return con;
        }
        catch (SQLException ex)
        {
            Logger.getLogger(Loginpage.class.getName()).log(Level.SEVERE,null,ex);
            JOptionPane.showMessageDialog(null,"Not connected");
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        uidText = new javax.swing.JTextField();
        passField = new javax.swing.JPasswordField();
        btnReset = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        jPasswordField1.setText("jPasswordField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tekton Pro Ext", 1, 18)); // NOI18N
        jLabel1.setText("Password");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 168, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tekton Pro Ext", 1, 18)); // NOI18N
        jLabel2.setText("UserId");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, -1, -1));

        uidText.setFont(new java.awt.Font("Trajan Pro", 1, 18)); // NOI18N
        uidText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uidTextActionPerformed(evt);
            }
        });
        getContentPane().add(uidText, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 90, 166, -1));

        passField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(passField, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 159, 166, -1));

        btnReset.setFont(new java.awt.Font("Sylfaen", 3, 18)); // NOI18N
        btnReset.setText("Reset");
        getContentPane().add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 271, -1, -1));

        btnLogin.setFont(new java.awt.Font("Sylfaen", 3, 18)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLoginMouseClicked(evt);
            }
        });
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 271, -1, -1));

        jTextField1.setText("jTextField1");
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 280, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void uidTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uidTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uidTextActionPerformed

    private void btnLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseClicked
          String uid = uidText.getText();
            String pass = passField.getText();
        if( uid != null && pass != null  )
            {
             
            try {
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement("insert into loginvalues ( '"+ uid+ "' '" + pass+" ' ); ");
                ps.setString(1, uid);
                ps.setString(2, pass);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data inserted");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Something wenr wrong");
            }
        }
        else {
            System.out.println("uid :" +uid);
            System.out.println("password : " +pass);
            
        }
    }//GEN-LAST:event_btnLoginMouseClicked

    public static void main(String args[]) throws SQLException, ClassNotFoundException {
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
            java.util.logging.Logger.getLogger(Loginpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Loginpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Loginpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Loginpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
       
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Loginpage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnReset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPasswordField passField;
    private javax.swing.JTextField uidText;
    // End of variables declaration//GEN-END:variables
}
