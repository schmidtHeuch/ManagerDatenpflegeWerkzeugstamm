/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DBTools.DB_ConnectionManager;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author schmidtu
 */
public class Dialog_DataUse_Glocke extends javax.swing.JDialog {

    /**
     * Creates new form Dialog_DataUse_Glocke
     * @param parent
     * @param modal
     */
    public Dialog_DataUse_Glocke(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    boolean myAnswerIfConnected;
    Connection myConnection;
    DefaultTableModel myTableModel;
    TableRowSorter<DefaultTableModel> mySorter;           
    DB_ConnectionManager MY_DBCM;
    String ChoosenGlocken_ID;

    private void do_preBuild() {                
        getDBConnection();
        get_DBTableData();
        myTableModel = (DefaultTableModel) jTable_dbData.getModel();
        jTable_dbData.setRowHeight(20); 
        createRowSorter(myTableModel);
        lbl_rowCount.setText(String.valueOf(mySorter.getViewRowCount()) + " von " + String.valueOf(myTableModel.getRowCount()));
    }
    private void do_postBuild() {               
        jTable_dbData.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
            if (jTable_dbData.getSelectedRow() > -1) {
                btn_accept.setEnabled(true);
            }
            else {
                btn_accept.setEnabled(false);}
        });
        KeyListener myKeyListener = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER)
                    btn_accept.doClick();
                if (evt.getKeyCode() == KeyEvent.VK_ESCAPE)
                    btn_cancel.doClick();
            }
        };
        MouseListener myMouseListener = new MouseAdapter() {
             @Override
             public void mouseClicked(MouseEvent e){
                if (e.getClickCount() == 2) {
                    btn_accept.doClick();
                }
            }
        };
        
        jTable_dbData.addKeyListener(myKeyListener);
        jTextField_searchValue.addKeyListener(myKeyListener);
        jTable_dbData.addMouseListener(myMouseListener);
    }
    private void createRowSorter(DefaultTableModel aModel) {
        mySorter = new TableRowSorter<>(aModel);
        jTable_dbData.setRowSorter(mySorter);
    }
    
    private void search() {
        String searchTerm = jTextField_searchValue.getText();
        mySorter.setRowFilter(RowFilter.regexFilter(searchTerm));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_base = new javax.swing.JPanel();
        jPanel_dbData = new javax.swing.JPanel();
        jScrollPane_dbData = new javax.swing.JScrollPane();
        jTable_dbData = new javax.swing.JTable();
        lbl_rowCount = new javax.swing.JLabel();
        jTextField_searchValue = new javax.swing.JTextField();
        btn_deleteSearchValue = new javax.swing.JButton();
        lbl_search = new javax.swing.JLabel();
        jPanel_footer = new javax.swing.JPanel();
        btn_accept = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel_base.setBackground(new java.awt.Color(204, 255, 255));

        jPanel_dbData.setOpaque(false);

        jTable_dbData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Glocken-ID", "Bezeichnung"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_dbData.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable_dbData.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane_dbData.setViewportView(jTable_dbData);

        lbl_rowCount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_rowCount.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lbl_rowCount.setPreferredSize(new java.awt.Dimension(34, 23));

        jTextField_searchValue.setPreferredSize(new java.awt.Dimension(120, 20));
        jTextField_searchValue.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_searchValueKeyReleased(evt);
            }
        });

        btn_deleteSearchValue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Löschen.png"))); // NOI18N
        btn_deleteSearchValue.setPreferredSize(new java.awt.Dimension(23, 23));
        btn_deleteSearchValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteSearchValueActionPerformed(evt);
            }
        });

        lbl_search.setText("Suchen");

        javax.swing.GroupLayout jPanel_dbDataLayout = new javax.swing.GroupLayout(jPanel_dbData);
        jPanel_dbData.setLayout(jPanel_dbDataLayout);
        jPanel_dbDataLayout.setHorizontalGroup(
            jPanel_dbDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_dbDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_dbDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_dbDataLayout.createSequentialGroup()
                        .addComponent(lbl_search)
                        .addGap(0, 156, Short.MAX_VALUE))
                    .addComponent(jScrollPane_dbData, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel_dbDataLayout.createSequentialGroup()
                        .addComponent(jTextField_searchValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_deleteSearchValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_rowCount, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel_dbDataLayout.setVerticalGroup(
            jPanel_dbDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_dbDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_dbDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_dbDataLayout.createSequentialGroup()
                        .addGroup(jPanel_dbDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_deleteSearchValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel_dbDataLayout.createSequentialGroup()
                                .addComponent(lbl_search)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_searchValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(9, 9, 9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_dbDataLayout.createSequentialGroup()
                        .addComponent(lbl_rowCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane_dbData, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel_footer.setOpaque(false);

        btn_accept.setText("Übernehmen");
        btn_accept.setEnabled(false);
        btn_accept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_acceptActionPerformed(evt);
            }
        });

        btn_cancel.setText("Abbrechen");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_footerLayout = new javax.swing.GroupLayout(jPanel_footer);
        jPanel_footer.setLayout(jPanel_footerLayout);
        jPanel_footerLayout.setHorizontalGroup(
            jPanel_footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_footerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_accept)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_cancel)
                .addContainerGap(206, Short.MAX_VALUE))
        );
        jPanel_footerLayout.setVerticalGroup(
            jPanel_footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_footerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel_footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_accept)
                    .addComponent(btn_cancel))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel_baseLayout = new javax.swing.GroupLayout(jPanel_base);
        jPanel_base.setLayout(jPanel_baseLayout);
        jPanel_baseLayout.setHorizontalGroup(
            jPanel_baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_footer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel_baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel_dbData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_baseLayout.setVerticalGroup(
            jPanel_baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_baseLayout.createSequentialGroup()
                .addGap(0, 255, Short.MAX_VALUE)
                .addComponent(jPanel_footer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel_baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel_baseLayout.createSequentialGroup()
                    .addComponent(jPanel_dbData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(52, 52, 52)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_base, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_base, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_searchValueKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_searchValueKeyReleased
        // TODO add your handling code here:
        search();
        lbl_rowCount.setText(String.valueOf(mySorter.getViewRowCount()) + " von " + String.valueOf(myTableModel.getRowCount()));
    }//GEN-LAST:event_jTextField_searchValueKeyReleased

    private void btn_deleteSearchValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteSearchValueActionPerformed
        // TODO add your handling code here:
        jTextField_searchValue.setText("");
        search();
        lbl_rowCount.setText(String.valueOf(mySorter.getViewRowCount()) + " von " + String.valueOf(myTableModel.getRowCount()));
    }//GEN-LAST:event_btn_deleteSearchValueActionPerformed

    private void btn_acceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_acceptActionPerformed
        // TODO add your handling code here:
        int myRow = jTable_dbData.convertRowIndexToModel(jTable_dbData.getSelectedRow());
        ChoosenGlocken_ID = myTableModel.getValueAt(myRow, 0).toString();
        this.dispose();
    }//GEN-LAST:event_btn_acceptActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        // TODO add your handling code here:
        ChoosenGlocken_ID = "";
        this.dispose();
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        do_preBuild();
        do_postBuild();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        btn_cancel.doClick();
    }//GEN-LAST:event_formWindowClosing

    public String getChoosenGlocken_ID() {
        return ChoosenGlocken_ID;
    }
    
    private void getDBConnection() { 
        MY_DBCM = new DB_ConnectionManager("jdbc:sqlserver://HV-ABAS-SQL;databaseName=DiafBDE;integratedSecurity=true", "CONNECT");
        if (!MY_DBCM.isConnnected()) {
            JOptionPane.showMessageDialog(null,
                    "Der Verbindungs-Aufbau zur Datenbank ist gescheitert. Bitte wenden Sie sich an den Entwickler.",
                    "Fehler",
                    JOptionPane.ERROR_MESSAGE);
        }        
    }
   
    private void get_DBTableData() {           
        try
        { 
            MY_DBCM.setConnection_CLOSED("jdbc:sqlserver://HV-ABAS-SQL;databaseName=DiafBDE;integratedSecurity=true", "DISCONNECT");
            MY_DBCM = new DB_ConnectionManager("jdbc:sqlserver://HV-ABAS-SQL;databaseName=DiafBDE;integratedSecurity=true", "CONNECT");
            myConnection = MY_DBCM.getConnection();
            Statement myStatement = myConnection.createStatement();
            String mySQL = "SELECT * FROM DiafBDE.dbo.V_Glocke";
            ResultSet myResultSet = myStatement.executeQuery(mySQL);
            int myColumns = myResultSet.getMetaData().getColumnCount();
            myTableModel = (DefaultTableModel) jTable_dbData.getModel();
            int allOldRows = myTableModel.getRowCount();
            if (allOldRows > 0) {
                myTableModel.setRowCount(0);
            }
            while (myResultSet.next()) {
                  
                String[] myValue = new String[myColumns];
                
                for (int i = 1; i <= myColumns; i++) {
                          
                    String myDataSet = myResultSet.getString(i);
                    myValue[i-1] = myDataSet;
                }  
                myTableModel.addRow(myValue); 
            }
            if (!myResultSet.next()) {                
            } 
        }
        catch (SQLException myException )
        {
            System.out.println(myException);
        }
        finally {
            try {
                if (myConnection != null && !myConnection.isClosed()) {
                    myConnection.close();
                }
            } catch (SQLException myException) {
                System.out.println(myException);
            }
        } 
    } 
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
            java.util.logging.Logger.getLogger(Dialog_DataUse_Glocke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dialog_DataUse_Glocke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dialog_DataUse_Glocke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dialog_DataUse_Glocke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            Dialog_DataUse_Glocke dialog = new Dialog_DataUse_Glocke(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_accept;
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_deleteSearchValue;
    private javax.swing.JPanel jPanel_base;
    private javax.swing.JPanel jPanel_dbData;
    private javax.swing.JPanel jPanel_footer;
    private javax.swing.JScrollPane jScrollPane_dbData;
    private javax.swing.JTable jTable_dbData;
    private javax.swing.JTextField jTextField_searchValue;
    private javax.swing.JLabel lbl_rowCount;
    private javax.swing.JLabel lbl_search;
    // End of variables declaration//GEN-END:variables
}
