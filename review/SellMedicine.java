
import Common.OpenPdf;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dao.ConnectionProvider;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.table.TableModel;
import java.util.Date;
import dao.PharmacyUtils;
import java.io.FileOutputStream;


public class SellMedicine extends javax.swing.JFrame {
    public String numberPattern="^[0-9]*$";
    private int finalTotalPrice=0;
    private String billId="";
    private String username="";
    private String price;
    

    
    public SellMedicine() {
        initComponents();
    }
      public SellMedicine(String tempUsername) {
        initComponents();
        username=tempUsername;
        setLocationRelativeTo(null);
    }
      private void medicineName(String nameOrUniqueId){
      DefaultTableModel model=(DefaultTableModel)MedicineTable.getModel();
      model.setRowCount(0);
      try{
          Connection con=ConnectionProvider.getCon();
          Statement st=con.createStatement();
          ResultSet rs=st.executeQuery("select*from medicine where name like '"+nameOrUniqueId+"%'or uniqueId like'"+nameOrUniqueId+"%'");
          while(rs.next()){
              model.addRow(new Object[]{rs.getString("uniqueId")+"- "+rs.getString("name")});
          }
      }
      catch(Exception e){
          JOptionPane.showMessageDialog(null,e);
      }
      }
      private void ClearMedicineField(){
      txtUniqueId.setText("");
      txtName.setText("");
      txtCompanyName.setText("");
      txtPricePerUnit.setText("");
      txtNoOfUnits.setText("");
      txtTotalPrice.setText("");
      }
      
      public String getUniqueId(String prefix){
         return prefix+System.nanoTime();
      }   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        MedicineTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtUniqueId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCompanyName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPricePerUnit = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNoOfUnits = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTotalPrice = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        CartTable = new javax.swing.JTable();
        btnAddToCart = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        lblFinalTotalPrice = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Sell Medicine");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 50, 1406, 10));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/close.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1374, 6, -1, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Search");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 78, -1, -1));

        txtSearch.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtSearch.setForeground(new java.awt.Color(0, 0, 0));
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        getContentPane().add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 100, 301, -1));

        MedicineTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicine"
            }
        ));
        MedicineTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MedicineTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(MedicineTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 301, 628));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("MedicineID");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(594, 78, -1, -1));

        txtUniqueId.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtUniqueId.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txtUniqueId, new org.netbeans.lib.awtextra.AbsoluteConstraints(591, 100, 300, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Name");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(591, 134, -1, -1));

        txtName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtName.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(591, 168, 300, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Company Name");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(591, 208, -1, -1));

        txtCompanyName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtCompanyName.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txtCompanyName, new org.netbeans.lib.awtextra.AbsoluteConstraints(591, 242, 300, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Price Per Unit");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(953, 78, -1, -1));

        txtPricePerUnit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtPricePerUnit.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txtPricePerUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(959, 100, 300, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("No.Of Units");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(959, 134, -1, -1));

        txtNoOfUnits.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtNoOfUnits.setForeground(new java.awt.Color(0, 0, 0));
        txtNoOfUnits.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNoOfUnitsKeyReleased(evt);
            }
        });
        getContentPane().add(txtNoOfUnits, new org.netbeans.lib.awtextra.AbsoluteConstraints(959, 168, 300, -1));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Total Price");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(959, 208, -1, -1));

        txtTotalPrice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtTotalPrice.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txtTotalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(959, 242, 300, -1));

        CartTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MedicineID", "Name", "Company Name", "Price Per Unit", "No Of Units", "Total Price"
            }
        ));
        CartTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CartTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(CartTable);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 320, 667, 177));

        btnAddToCart.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAddToCart.setForeground(new java.awt.Color(0, 0, 0));
        btnAddToCart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add to cart.png"))); // NOI18N
        btnAddToCart.setText("Add To Cart");
        btnAddToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToCartActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddToCart, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 282, -1, -1));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("RS:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(724, 520, -1, -1));

        lblFinalTotalPrice.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblFinalTotalPrice.setForeground(new java.awt.Color(0, 0, 0));
        lblFinalTotalPrice.setText("00");
        getContentPane().add(lblFinalTotalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(766, 517, 150, -1));

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/generate bill & print.png"))); // NOI18N
        jButton3.setText("Purchase & Print");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1111, 520, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/close.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 10, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/adminDashboardBackground.png"))); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    setVisible(false);   
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
    medicineName(""); 
    txtUniqueId.setEditable(false);
    txtName.setEditable(false);
    txtCompanyName.setEditable(false);
    txtPricePerUnit.setEditable(false);
    txtTotalPrice.setEditable(false);
    
    }//GEN-LAST:event_formComponentShown

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchKeyPressed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
    String search=txtSearch.getText();
    medicineName(search);
    }//GEN-LAST:event_txtSearchKeyReleased

    private void MedicineTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MedicineTableMouseClicked
    int index=MedicineTable.getSelectedRow();
    TableModel model=MedicineTable.getModel();
    String nameOrUniqueId=model.getValueAt(index,0).toString();
    
    String[] uniqueId = nameOrUniqueId.split("-", 2);
    try{
        Connection con=ConnectionProvider.getCon();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select * from medicine where uniqueId = '" + uniqueId[0] + "'"); 
        while(rs.next()){
            txtUniqueId.setText(uniqueId[0]);
            txtName.setText(rs.getString("name"));
            txtCompanyName.setText(rs.getString("CompanyName"));
            txtPricePerUnit.setText(rs.getString("price"));
            //txtNoOfUnits.setText(rs.getString(""));
          // txtTotalPrice.setText(rs.getString(""));
            
    }
}
    catch(Exception e){
        JOptionPane.showMessageDialog(null,e);
    }
    }//GEN-LAST:event_MedicineTableMouseClicked

    private void txtNoOfUnitsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoOfUnitsKeyReleased
    String noOfUnits=txtNoOfUnits.getText();
    if(!noOfUnits.equals("")){
        String price=txtPricePerUnit.getText();
    if(!noOfUnits.matches(numberPattern)){    
        JOptionPane.showMessageDialog(null,"Number Of Units Fileds Is Invalid");
}
    int totalPrice=Integer.parseInt(noOfUnits)*Integer.parseInt(price);
    txtTotalPrice.setText(String.valueOf(totalPrice));
    }
    else{
        txtTotalPrice.setText("");
    }    
    
    
   
       
    }//GEN-LAST:event_txtNoOfUnitsKeyReleased

    private void btnAddToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToCartActionPerformed
    String noOfUnits=txtNoOfUnits.getText();
    String uniqueId=txtUniqueId.getText();
    if(!noOfUnits.equals("")&&!uniqueId.equals("")){
    String name=txtName.getText();
    String companyName=txtCompanyName.getText();
    String PricePerUnit=txtPricePerUnit.getText();
    String totalPrice=txtTotalPrice.getText();
    int checkStock=0;
    int checkMedicineAlreadyExistInCart=0;
    
    try{
        Connection con=ConnectionProvider.getCon();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select*from medicine where uniqueId="+uniqueId+"");
        while(rs.next()){
            if(rs.getInt("quantity")>=Integer.parseInt(noOfUnits)){
                checkStock=1;
            }else{
                JOptionPane.showMessageDialog(null,"Medicine Is Out Of Stock.Only"+rs.getInt("quantity")+"Left");
            }
        }
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(null,e);
    }
    if(checkStock==1){
        DefaultTableModel dtm=(DefaultTableModel)CartTable.getModel();
        if(CartTable.getRowCount()!=0){
            for(int i=0;i<CartTable.getRowCount();i++){
                if(Integer.parseInt(dtm.getValueAt(i,0).toString())==Integer.parseInt(uniqueId)){
                    checkMedicineAlreadyExistInCart=1;
                    JOptionPane.showMessageDialog(null,"Medicine Already Exist In Cart");
                }
            }
        }
        if(checkMedicineAlreadyExistInCart==0){
            dtm.addRow(new Object[]{uniqueId,name,companyName,PricePerUnit,noOfUnits,totalPrice});
            finalTotalPrice=finalTotalPrice+Integer.parseInt(totalPrice);
            lblFinalTotalPrice.setText(String.valueOf(finalTotalPrice));
            JOptionPane.showMessageDialog(null,"Added Successfully");
            
        }
         ClearMedicineField();
    }
    }else{
        JOptionPane.showMessageDialog(null,"No Of Units And Medicine ID Field Is Required");
    }
    
    }//GEN-LAST:event_btnAddToCartActionPerformed

    private void CartTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CartTableMouseClicked
    int index=CartTable.getSelectedRow();
    int a=JOptionPane.showConfirmDialog(null,"Do You Want To Remove This Medicine","select",JOptionPane.YES_NO_OPTION);
    if(a==0){
        TableModel model=CartTable.getModel();
        String total=model.getValueAt(index,5).toString();
        finalTotalPrice=finalTotalPrice-Integer.parseInt(total);
        lblFinalTotalPrice.setText(String.valueOf(finalTotalPrice));
        ((DefaultTableModel)CartTable.getModel()).removeRow(index);
    }
    }//GEN-LAST:event_CartTableMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    if(finalTotalPrice!=0){
        billId=getUniqueId("Bill=");
        
    DefaultTableModel dtm=(DefaultTableModel)CartTable.getModel();
    if(CartTable.getRowCount()!=0){
        for(int i=0;i<CartTable.getRowCount();i++){
          try{
              Connection con=ConnectionProvider.getCon();
              Statement st=con.createStatement();
              st.executeUpdate("update medicine set quantity=quantity-"+Integer.parseInt(dtm.getValueAt(i,4).toString())+" where uniqueId="+Integer.parseInt(dtm.getValueAt(i,0).toString()));
              
          }
          catch(Exception e){
              JOptionPane.showMessageDialog(null,e);
          }
        }
    }
    try{
        SimpleDateFormat myFormat=new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal=Calendar.getInstance();
        Connection con=ConnectionProvider.getCon();
        PreparedStatement ps=con.prepareStatement("insert into bill(billId,billDate,totalPaid,generatedBy)values(?,?,?,?)");
        ps.setString(1,billId);
        ps.setString(2,myFormat.format(cal.getTime()));
        ps.setInt(3,finalTotalPrice);
        ps.setString(4,username);
        ps.executeUpdate();
        
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(null,e);
    }
    //createBill
    com.itextpdf.text.Document doc=new com.itextpdf.text.Document();
    try{
        PdfWriter.getInstance(doc,new FileOutputStream(PharmacyUtils.billPath+""+billId+".pdf"));
        doc.open();
        Paragraph pharmacyName=new Paragraph("                                                                Pharmacy Management System\n");
        doc.add(pharmacyName);
        Paragraph starLine=new Paragraph("****************************************************************************************************************");
        doc.add(starLine);
        Paragraph details=new Paragraph("\tBill ID:"+billId+"\nDate:"+new Date()+"\nTotal Paid:"+finalTotalPrice);
        doc.add(details);
        doc.add(starLine);
        PdfPTable tb1=new PdfPTable(6);
        tb1.addCell("Medicine ID");
        tb1.addCell("Name");
        tb1.addCell("Company Name");
        tb1.addCell("Price Per Unit");
        tb1.addCell("NoOfUnits");
        tb1.addCell("Sub Total Price");
        for(int i=0;i<CartTable.getRowCount();i++){
            String a=CartTable.getValueAt(i,0).toString();
            String b=CartTable.getValueAt(i,1).toString();
            String c=CartTable.getValueAt(i,2).toString();
            String d=CartTable.getValueAt(i,3).toString();
            String e=CartTable.getValueAt(i,4).toString();
            String f=CartTable.getValueAt(i,5).toString();
            tb1.addCell(a);
            tb1.addCell(b);
            tb1.addCell(c);
            tb1.addCell(d);
            tb1.addCell(e);
            tb1.addCell(f);
            
        }
        doc.add(tb1);
        doc.add(starLine);
        Paragraph thanksMsg=new Paragraph("Thank You,Please Visit Again.(NVDS)");
        doc.add(thanksMsg);
        //Open pdf
        OpenPdf.openById(String.valueOf(billId));
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(null,e);
    }
    doc.close();
    setVisible(false);
    new SellMedicine(username).setVisible(true);
    }
    else{
        JOptionPane.showMessageDialog(null,"Please Add Some Medicine To Cart");
    }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    setVisible(false);   
    }//GEN-LAST:event_jButton2ActionPerformed

   
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
            java.util.logging.Logger.getLogger(SellMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SellMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SellMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SellMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SellMedicine().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable CartTable;
    private javax.swing.JTable MedicineTable;
    private javax.swing.JButton btnAddToCart;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField lblFinalTotalPrice;
    private javax.swing.JTextField txtCompanyName;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNoOfUnits;
    private javax.swing.JTextField txtPricePerUnit;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTotalPrice;
    private javax.swing.JTextField txtUniqueId;
    // End of variables declaration//GEN-END:variables
}
