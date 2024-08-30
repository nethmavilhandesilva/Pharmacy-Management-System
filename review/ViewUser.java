
import dao.ConnectionProvider;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.table.TableModel;


public class ViewUser extends javax.swing.JFrame {
private String username="";

   
    public ViewUser() {
        initComponents();
    }
    public ViewUser(String tempUsername) {
        initComponents();
        username=tempUsername;
        setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("View User");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/close.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 10, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1371, 62, 1, 10));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Role", "Date Of Birth(DOB)", "MobileNumber", "Email", "Username", "Password", "Address"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 850, 365));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 850, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Click On Row To Delete User");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 460, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/all_pages_background.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jLabel3.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jLabel3ComponentShown(evt);
            }
        });
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jLabel3ComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3ComponentShown

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
    DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
    try{
        Connection con=ConnectionProvider.getCon();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select*from appuser");
        while(rs.next()){
            model.addRow(new Object[]{rs.getString("appuser_pk"),rs.getString("name"),rs.getString("userRole"),rs.getString("dob"),rs.getString("mobileNumber"),rs.getString("email"),rs.getString("username"),rs.getString("password"),rs.getString("address")});
            
        }
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(null,e);
    }
    }//GEN-LAST:event_formComponentShown

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
    int index = jTable1.getSelectedRow();
    TableModel model=jTable1.getModel();
    String id=model.getValueAt(index,0).toString();
    String usernameTable=model.getValueAt(index,6).toString();
    if(username.equals(usernameTable)){
        JOptionPane.showMessageDialog(null,"You Cant Delete Your Own Account");
}else{
        int a=JOptionPane.showConfirmDialog(null,"Do You Wnat To Delete This User","Select",JOptionPane.YES_NO_OPTION);
        if(a==0){
            try{
                Connection con=ConnectionProvider.getCon();
                PreparedStatement ps=con.prepareStatement("delete from appuser where appuser_pk=?");
                ps.setString(1, id);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null,"User Successfully Deleted");
                setVisible(false);
                new ViewUser(username).setVisible(true);
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,username);
            }
        }
    }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed
     
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
            java.util.logging.Logger.getLogger(ViewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
