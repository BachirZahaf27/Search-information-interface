/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Memo;

import java.awt.Desktop;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author user
 */
public class name extends javax.swing.JFrame {

    /**
     * Creates new form name
     */
    Connection conn=null;
ResultSet rs=null;
PreparedStatement stmt=null;

    /**
     * Creates new form name
     */
    public name() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        lb1.setVisible(false);
        lb2.setVisible(false);
    }
   private void Update_table() {
    try{
        conn=database.java_db();
        String sql ="select * from document";
        stmt=conn.prepareStatement(sql);
        rs=stmt.executeQuery();
        table_doc.setModel(DbUtils.resultSetToTableModel(rs));
        
    }
    catch(Exception e){
    //JOptionPane.showMessageDialog(null, e);
    JOptionPane.showMessageDialog(null, "no document found");
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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("jdbc:sqlite:C:\\Users\\user\\Desktop\\la mémoire\\memo\\auteur.dbPU").createEntityManager();
        documentQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT d FROM Document d");
        documentList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : documentQuery.getResultList();
        documentQuery1 = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT d FROM Document d");
        documentList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : documentQuery1.getResultList();
        auteurQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT a FROM Auteur a");
        auteurList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : auteurQuery.getResultList();
        documentQuery2 = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT d FROM Document d");
        documentList2 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : documentQuery2.getResultList();
        documentQuery3 = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT d FROM Document d");
        documentList3 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : documentQuery3.getResultList();
        documentQuery4 = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT d FROM Document d");
        documentList4 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : documentQuery4.getResultList();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Search = new javax.swing.JButton();
        nom_doc = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_doc = new javax.swing.JTable();
        lb1 = new javax.swing.JLabel();
        lb2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("search by name");
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 102, 204));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Memo/Image/doc-icon.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 102, 204));

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("X");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText(" Search by document name");

        Search.setBackground(new java.awt.Color(0, 102, 204));
        Search.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        Search.setForeground(new java.awt.Color(255, 255, 255));
        Search.setText("Search");
        Search.setBorder(null);
        Search.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });

        nom_doc.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        nom_doc.setForeground(new java.awt.Color(51, 51, 51));
        nom_doc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, documentList4, table_doc);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${author}"));
        columnBinding.setColumnName("Author");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${namedocument}"));
        columnBinding.setColumnName("Namedocument");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${pathdocument}"));
        columnBinding.setColumnName("Pathdocument");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        table_doc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_docMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_doc);

        lb1.setText("jLabel2");

        lb2.setText("jLabel2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nom_doc)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lb1)
                        .addGap(495, 495, 495)
                        .addComponent(lb2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 726, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 10, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nom_doc, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb1)
                    .addComponent(lb2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bindingGroup.bind();

        setSize(new java.awt.Dimension(1011, 524));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        // search by name of the document
        String nom=nom_doc.getText();//mettre le mot qui nous veux le rechercher dans nom
        
        conn=database.java_db();
        try {
            if(nom.isEmpty()){
                JOptionPane.showMessageDialog(null, "please insert a value");
            } else {
            }
            
            String sql="SELECT * FROM document WHERE Name_document LIKE '%"+nom+"%'";
            //selctioner tout les ligne de tableau document qui leur nom de document = le nom qui nous veux le rechercher
            stmt=conn.prepareStatement(sql);
            rs=stmt.executeQuery();
            table_doc.setModel(DbUtils.resultSetToTableModel(rs));//afficher le resultat dans le tableau

            //calculate the number
            String sql2="select * from document";
            stmt=conn.prepareStatement(sql);
            rs=stmt.executeQuery();

            String str=rs.getString("Name_document");



        } catch(Exception e)

        {
            //JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "no document found");

        }
         finally {
            
            try{
                rs.close();
                stmt.close();
                
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "insert");
            }
        
        }

        

    }//GEN-LAST:event_SearchActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // if you click on the X
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void table_docMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_docMouseClicked
        // click to open the document:
        int index = table_doc.getSelectedRow();
        TableModel model = table_doc.getModel();
        String p="";
        lb1.setText(model.getValueAt(index, 3).toString());//mettre le chemp dans path_doc

        File filepath=new File(lb1.getText());
        try {
            Desktop.getDesktop().open(filepath);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }//GEN-LAST:event_table_docMouseClicked

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
            java.util.logging.Logger.getLogger(name.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(name.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(name.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(name.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new name().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Search;
    private java.util.List<Memo.Auteur> auteurList;
    private javax.persistence.Query auteurQuery;
    private java.util.List<Memo.Document> documentList;
    private java.util.List<Memo.Document> documentList1;
    private java.util.List<Memo.Document> documentList2;
    private java.util.List<Memo.Document> documentList3;
    private java.util.List<Memo.Document> documentList4;
    private javax.persistence.Query documentQuery;
    private javax.persistence.Query documentQuery1;
    private javax.persistence.Query documentQuery2;
    private javax.persistence.Query documentQuery3;
    private javax.persistence.Query documentQuery4;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JTextField nom_doc;
    private javax.swing.JTable table_doc;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
