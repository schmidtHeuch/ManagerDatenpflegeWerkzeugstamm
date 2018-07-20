/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DBTools.DB_ConnectionManager;
//import managerdatenpflegewerkzeugstamm.CustomTableCellRenderer;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import javax.swing.BoundedRangeModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author schmidtu
 */
public class Frame_DataMaintenance_Werkzeugstamm extends javax.swing.JFrame {
    static int InstanceCount;

    /**
     * Creates new form Frame_DataMaintenance_Werkzeugstamm
     */
    public Frame_DataMaintenance_Werkzeugstamm() {
        InstanceCount++;
        this.Old_Bezeichnung = "";
        this.Old_Segment = "";
        this.Old_Grundform = "";
        this.Old_Schnitt = "";
        this.Old_Stapelung = "";
        this.Old_Stanzblech = "";
        this.Old_Stanzbrille = "";
        this.Old_Vorstempel = "";
        this.Old_Niederhalterplatte = "";
        this.Old_Ausbrechstempel = "";
        this.Old_Lochwerkzeug = "";
        this.Old_STAL = "";
        this.Old_Führungskäfig = "";
        this.Old_Säulengestell = "";
        this.Old_Schriftzug = "";
        this.Old_Anlagedatum = "";
        this.Old_Änderungsdatum = "";
        this.Old_Benutzer = "";
        this.DataSet_Mode = "clean";
        initComponents();
        btn_edit.setEnabled(false);
        btn_duplicate.setEnabled(false);
        btn_delete.setEnabled(false);
        btn_accept.setEnabled(false);
        btn_cancel.setEnabled(false);
    } 
    public int getInstance() {
        return InstanceCount;
    }   
   
    boolean myAnswerIfConnected;
    Connection myConnection;
    DefaultTableModel myTableModel; 
    TableRowSorter<DefaultTableModel> mySorter;          
    DB_ConnectionManager MY_DBCM;
    String Old_Key;
    String Old_Bezeichnung;
    String Old_Segment;
    String Old_Grundform;
    String Old_Schnitt;
    String Old_Stapelung;
    String Old_Stanzblech;
    String Old_Stanzbrille;
    String Old_Vorstempel;
    String Old_Niederhalterplatte;
    String Old_Ausbrechstempel;
    String Old_Lochwerkzeug;
    String Old_STAL;
    String Old_Führungskäfig;
    String Old_Säulengestell;
    String Old_Schriftzug;
    String Old_Anlagedatum;
    String Old_Änderungsdatum;
    String Old_Benutzer;
    int OldSelection;
    String DataSet_Mode;
    Timestamp Anlagedatum;
    Timestamp Änderungsdatum;
    String Benutzer;
    String MyDependentValue_Bezeichnung;
    int TableColumns;
    
    private void do_preBuild() {        
        getDBConnection();
        get_DBTableData();
        myTableModel = (DefaultTableModel) jTable_dbData.getModel();
        createRowSorter(myTableModel);
        lbl_rowCount.setText(String.valueOf(mySorter.getViewRowCount()) + " von " + String.valueOf(myTableModel.getRowCount()));
        
        final BoundedRangeModel scrollModel = jScrollPane_dbData.getHorizontalScrollBar().getModel();
        jScrollPane_editData.getHorizontalScrollBar().setModel(scrollModel);
    }
    
    private void createRowSorter(DefaultTableModel aModel) {
        mySorter = new TableRowSorter<>(aModel);
        jTable_dbData.setRowSorter(mySorter);
    }
    
    private void search() {
        String searchTerm = jTextField_searchValue.getText();
        mySorter.setRowFilter(RowFilter.regexFilter(searchTerm));
    }
    
    private void do_postBuild() {                
        jTable_dbData.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
            set_valuesIntoTextFields();
        });
        KeyListener tfKeyListener = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER)
                    btn_accept.doClick();
                if (evt.getKeyCode() == KeyEvent.VK_DELETE)
                    btn_delete.doClick();
            }
        };
        jTextField_key.addKeyListener(tfKeyListener);
        jFormattedTextField_Bezeichnung.addKeyListener(tfKeyListener);
        jFormattedTextField_Segment.addKeyListener(tfKeyListener);
        jFormattedTextField_Grundform.addKeyListener(tfKeyListener);
        jFormattedTextField_Schnitt.addKeyListener(tfKeyListener);
        jFormattedTextField_Stapelung.addKeyListener(tfKeyListener);
        jFormattedTextField_Stanzblech.addKeyListener(tfKeyListener);
        jFormattedTextField_Stanzbrille.addKeyListener(tfKeyListener);
        jFormattedTextField_Vorstempel.addKeyListener(tfKeyListener);
        jFormattedTextField_Niederhalterplatte.addKeyListener(tfKeyListener);
        jFormattedTextField_Ausbrechstempel.addKeyListener(tfKeyListener);
        jFormattedTextField_Lochwerkzeug.addKeyListener(tfKeyListener);
        jFormattedTextField_STAL.addKeyListener(tfKeyListener);
        jFormattedTextField_Führungskäfig.addKeyListener(tfKeyListener);
        jFormattedTextField_Säulengestell.addKeyListener(tfKeyListener);
        jFormattedTextField_Schriftzug.addKeyListener(tfKeyListener);
        jTable_dbData.addKeyListener(tfKeyListener);
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
        jPanel_table = new javax.swing.JPanel();
        jTextField_searchValue = new javax.swing.JTextField();
        btn_deleteSearchValue = new javax.swing.JButton();
        jScrollPane_dbData = new javax.swing.JScrollPane();
        jTable_dbData = new javax.swing.JTable();
        lbl_search1 = new javax.swing.JLabel();
        lbl_rowCount = new javax.swing.JLabel();
        btn_getCurrentDBData = new javax.swing.JButton();
        lbl_tableName = new javax.swing.JLabel();
        jPanel_footer = new javax.swing.JPanel();
        btn_close = new javax.swing.JButton();
        jScrollPane_editData = new javax.swing.JScrollPane();
        jPanel_editData = new javax.swing.JPanel();
        jPanel_editLabels = new javax.swing.JPanel();
        lbl_key = new javax.swing.JLabel();
        lbl_Bezeichnung = new javax.swing.JLabel();
        lbl_Segment = new javax.swing.JLabel();
        btn_openDialog_Segment = new javax.swing.JButton();
        btn_delete_Segment = new javax.swing.JButton();
        jLabel_Grundform = new javax.swing.JLabel();
        btn_openDialog_Grundform = new javax.swing.JButton();
        btn_delete_Grundform = new javax.swing.JButton();
        jLabel_Schnitt = new javax.swing.JLabel();
        btn_openDialog_Schnitt = new javax.swing.JButton();
        btn_delete_Schnitt = new javax.swing.JButton();
        jLabel_Stapelung = new javax.swing.JLabel();
        btn_openDialog_Stapelung = new javax.swing.JButton();
        btn_delete_Stapelung = new javax.swing.JButton();
        jLabel_Stanzblech = new javax.swing.JLabel();
        btn_openDialog_Stanzblech = new javax.swing.JButton();
        btn_delete_Stanzblech = new javax.swing.JButton();
        jLabel_Stanzbrille = new javax.swing.JLabel();
        btn_openDialog_Stanzbrille = new javax.swing.JButton();
        btn_delete_Stanzbrille = new javax.swing.JButton();
        jLabel_Vorstempel = new javax.swing.JLabel();
        btn_openDialog_Vorstempel = new javax.swing.JButton();
        btn_delete_Vorstempel = new javax.swing.JButton();
        jLabel_Niederhalterplatte = new javax.swing.JLabel();
        btn_openDialog_Niederhalterplatte = new javax.swing.JButton();
        btn_delete_Niederhalterplatte = new javax.swing.JButton();
        jLabel_Ausbrechstempel = new javax.swing.JLabel();
        btn_openDialog_Ausbrechstempel = new javax.swing.JButton();
        btn_delete_Ausbrechstempel = new javax.swing.JButton();
        jLabel_Lochwerkzeug = new javax.swing.JLabel();
        btn_openDialog_Lochwerkzeug = new javax.swing.JButton();
        btn_delete_Lochwerkzeug = new javax.swing.JButton();
        jLabel_STAL = new javax.swing.JLabel();
        btn_openDialog_STAL = new javax.swing.JButton();
        btn_delete_STAL = new javax.swing.JButton();
        jLabel_Führungskäfig = new javax.swing.JLabel();
        btn_openDialog_Führungskäfig = new javax.swing.JButton();
        btn_delete_Führungskäfig = new javax.swing.JButton();
        jLabel_Säulengestell = new javax.swing.JLabel();
        btn_openDialog_Säulengestell = new javax.swing.JButton();
        btn_delete_Säulengestell = new javax.swing.JButton();
        jLabel_Schriftzug = new javax.swing.JLabel();
        btn_openDialog_Schriftzug = new javax.swing.JButton();
        btn_delete_Schriftzug = new javax.swing.JButton();
        jLabel_placeholder = new javax.swing.JLabel();
        jPanel_editTextFields = new javax.swing.JPanel();
        jTextField_key = new javax.swing.JTextField();
        jFormattedTextField_Bezeichnung = new javax.swing.JFormattedTextField();
        jFormattedTextField_Segment = new javax.swing.JFormattedTextField();
        jFormattedTextField_Grundform = new javax.swing.JTextField();
        jFormattedTextField_Schnitt = new javax.swing.JTextField();
        jFormattedTextField_Stapelung = new javax.swing.JTextField();
        jFormattedTextField_Stanzblech = new javax.swing.JTextField();
        jFormattedTextField_Stanzbrille = new javax.swing.JTextField();
        jFormattedTextField_Vorstempel = new javax.swing.JTextField();
        jFormattedTextField_Niederhalterplatte = new javax.swing.JTextField();
        jFormattedTextField_Ausbrechstempel = new javax.swing.JTextField();
        jFormattedTextField_Lochwerkzeug = new javax.swing.JTextField();
        jFormattedTextField_STAL = new javax.swing.JTextField();
        jFormattedTextField_Führungskäfig = new javax.swing.JTextField();
        jFormattedTextField_Säulengestell = new javax.swing.JTextField();
        jFormattedTextField_Schriftzug = new javax.swing.JTextField();
        jLabel_placeholder2 = new javax.swing.JLabel();
        btn_new = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_accept = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();
        btn_duplicate = new javax.swing.JButton();
        lbl_Anlagedatum = new javax.swing.JLabel();
        lbl_Änderungsdatum = new javax.swing.JLabel();
        lbl_Benutzer = new javax.swing.JLabel();
        jTextField_Anlagedatum = new javax.swing.JTextField();
        jTextField_Änderungsdatum = new javax.swing.JTextField();
        jTextField_Benutzer = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel_base.setBackground(new java.awt.Color(204, 255, 255));

        jPanel_table.setOpaque(false);

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

        jTable_dbData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "WKZ (Key)", "Bezeichnung", "Segment", "Grundform", "Schnitt", "Stapelung", "Stanzblech", "Stanzbrille", "Vorstempel", "Niederhalterplatte", "Ausbrechstempel", "Lochwerkzeug", "STAL", "Führungskäfig", "Säulengestell", "Schriftzug", "Anlagedatum", "Änderungsdatum", "Benutzer"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_dbData.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable_dbData.setRowHeight(20);
        jTable_dbData.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable_dbData.getTableHeader().setReorderingAllowed(false);
        jScrollPane_dbData.setViewportView(jTable_dbData);
        if (jTable_dbData.getColumnModel().getColumnCount() > 0) {
            jTable_dbData.getColumnModel().getColumn(0).setPreferredWidth(100);
            jTable_dbData.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTable_dbData.getColumnModel().getColumn(2).setPreferredWidth(150);
            jTable_dbData.getColumnModel().getColumn(3).setPreferredWidth(150);
            jTable_dbData.getColumnModel().getColumn(4).setPreferredWidth(150);
            jTable_dbData.getColumnModel().getColumn(5).setPreferredWidth(150);
            jTable_dbData.getColumnModel().getColumn(6).setPreferredWidth(150);
            jTable_dbData.getColumnModel().getColumn(7).setPreferredWidth(150);
            jTable_dbData.getColumnModel().getColumn(8).setPreferredWidth(150);
            jTable_dbData.getColumnModel().getColumn(9).setPreferredWidth(150);
            jTable_dbData.getColumnModel().getColumn(10).setPreferredWidth(150);
            jTable_dbData.getColumnModel().getColumn(11).setPreferredWidth(150);
            jTable_dbData.getColumnModel().getColumn(12).setPreferredWidth(150);
            jTable_dbData.getColumnModel().getColumn(13).setPreferredWidth(150);
            jTable_dbData.getColumnModel().getColumn(14).setPreferredWidth(150);
            jTable_dbData.getColumnModel().getColumn(15).setPreferredWidth(150);
            jTable_dbData.getColumnModel().getColumn(16).setPreferredWidth(150);
            jTable_dbData.getColumnModel().getColumn(17).setPreferredWidth(150);
            jTable_dbData.getColumnModel().getColumn(18).setPreferredWidth(100);
        }

        lbl_search1.setText("Suchen");

        lbl_rowCount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        btn_getCurrentDBData.setText("Aktualisieren");
        btn_getCurrentDBData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_getCurrentDBDataActionPerformed(evt);
            }
        });

        lbl_tableName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_tableName.setText("Tabelle: Werkzeugstamm");

        javax.swing.GroupLayout jPanel_tableLayout = new javax.swing.GroupLayout(jPanel_table);
        jPanel_table.setLayout(jPanel_tableLayout);
        jPanel_tableLayout.setHorizontalGroup(
            jPanel_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_tableLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane_dbData)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_tableLayout.createSequentialGroup()
                        .addGroup(jPanel_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_tableLayout.createSequentialGroup()
                                .addComponent(jTextField_searchValue, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_deleteSearchValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_getCurrentDBData))
                            .addComponent(lbl_tableName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1963, Short.MAX_VALUE)
                        .addComponent(lbl_rowCount, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_tableLayout.createSequentialGroup()
                        .addComponent(lbl_search1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel_tableLayout.setVerticalGroup(
            jPanel_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_tableLayout.createSequentialGroup()
                .addGroup(jPanel_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel_tableLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbl_tableName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_search1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_searchValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_deleteSearchValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_getCurrentDBData)))
                    .addGroup(jPanel_tableLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(lbl_rowCount, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane_dbData, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel_footer.setOpaque(false);

        btn_close.setText("Schließen");
        btn_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_closeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_footerLayout = new javax.swing.GroupLayout(jPanel_footer);
        jPanel_footer.setLayout(jPanel_footerLayout);
        jPanel_footerLayout.setHorizontalGroup(
            jPanel_footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_footerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_close)
                .addContainerGap(845, Short.MAX_VALUE))
        );
        jPanel_footerLayout.setVerticalGroup(
            jPanel_footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_footerLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_close)
                .addGap(23, 23, 23))
        );

        jScrollPane_editData.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jPanel_editData.setBorder(javax.swing.BorderFactory.createTitledBorder("Bearbeitung"));
        jPanel_editData.setOpaque(false);

        jPanel_editLabels.setOpaque(false);
        jPanel_editLabels.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        lbl_key.setText("WKZ (Key)");
        lbl_key.setPreferredSize(new java.awt.Dimension(100, 14));
        jPanel_editLabels.add(lbl_key);

        lbl_Bezeichnung.setText("Bezeichnung");
        lbl_Bezeichnung.setPreferredSize(new java.awt.Dimension(200, 14));
        jPanel_editLabels.add(lbl_Bezeichnung);

        lbl_Segment.setText("Segment");
        lbl_Segment.setPreferredSize(new java.awt.Dimension(104, 14));
        jPanel_editLabels.add(lbl_Segment);

        btn_openDialog_Segment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Lupe.png"))); // NOI18N
        btn_openDialog_Segment.setEnabled(false);
        btn_openDialog_Segment.setPreferredSize(new java.awt.Dimension(23, 23));
        btn_openDialog_Segment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_openDialog_SegmentActionPerformed(evt);
            }
        });
        jPanel_editLabels.add(btn_openDialog_Segment);

        btn_delete_Segment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Löschen.png"))); // NOI18N
        btn_delete_Segment.setEnabled(false);
        btn_delete_Segment.setPreferredSize(new java.awt.Dimension(23, 23));
        btn_delete_Segment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delete_SegmentActionPerformed(evt);
            }
        });
        jPanel_editLabels.add(btn_delete_Segment);

        jLabel_Grundform.setText("Grundform");
        jLabel_Grundform.setPreferredSize(new java.awt.Dimension(104, 14));
        jPanel_editLabels.add(jLabel_Grundform);

        btn_openDialog_Grundform.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Lupe.png"))); // NOI18N
        btn_openDialog_Grundform.setEnabled(false);
        btn_openDialog_Grundform.setPreferredSize(new java.awt.Dimension(23, 23));
        btn_openDialog_Grundform.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_openDialog_GrundformActionPerformed(evt);
            }
        });
        jPanel_editLabels.add(btn_openDialog_Grundform);

        btn_delete_Grundform.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Löschen.png"))); // NOI18N
        btn_delete_Grundform.setEnabled(false);
        btn_delete_Grundform.setPreferredSize(new java.awt.Dimension(23, 23));
        btn_delete_Grundform.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delete_GrundformActionPerformed(evt);
            }
        });
        jPanel_editLabels.add(btn_delete_Grundform);

        jLabel_Schnitt.setText("Schnitt");
        jLabel_Schnitt.setPreferredSize(new java.awt.Dimension(104, 14));
        jPanel_editLabels.add(jLabel_Schnitt);

        btn_openDialog_Schnitt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Lupe.png"))); // NOI18N
        btn_openDialog_Schnitt.setEnabled(false);
        btn_openDialog_Schnitt.setPreferredSize(new java.awt.Dimension(23, 23));
        btn_openDialog_Schnitt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_openDialog_SchnittActionPerformed(evt);
            }
        });
        jPanel_editLabels.add(btn_openDialog_Schnitt);

        btn_delete_Schnitt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Löschen.png"))); // NOI18N
        btn_delete_Schnitt.setEnabled(false);
        btn_delete_Schnitt.setPreferredSize(new java.awt.Dimension(23, 23));
        btn_delete_Schnitt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delete_SchnittActionPerformed(evt);
            }
        });
        jPanel_editLabels.add(btn_delete_Schnitt);

        jLabel_Stapelung.setText("Stapelung");
        jLabel_Stapelung.setPreferredSize(new java.awt.Dimension(104, 14));
        jPanel_editLabels.add(jLabel_Stapelung);

        btn_openDialog_Stapelung.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Lupe.png"))); // NOI18N
        btn_openDialog_Stapelung.setEnabled(false);
        btn_openDialog_Stapelung.setPreferredSize(new java.awt.Dimension(23, 23));
        btn_openDialog_Stapelung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_openDialog_StapelungActionPerformed(evt);
            }
        });
        jPanel_editLabels.add(btn_openDialog_Stapelung);

        btn_delete_Stapelung.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Löschen.png"))); // NOI18N
        btn_delete_Stapelung.setEnabled(false);
        btn_delete_Stapelung.setPreferredSize(new java.awt.Dimension(23, 23));
        btn_delete_Stapelung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delete_StapelungActionPerformed(evt);
            }
        });
        jPanel_editLabels.add(btn_delete_Stapelung);

        jLabel_Stanzblech.setText("Stanzblech");
        jLabel_Stanzblech.setPreferredSize(new java.awt.Dimension(104, 14));
        jPanel_editLabels.add(jLabel_Stanzblech);

        btn_openDialog_Stanzblech.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Lupe.png"))); // NOI18N
        btn_openDialog_Stanzblech.setEnabled(false);
        btn_openDialog_Stanzblech.setPreferredSize(new java.awt.Dimension(23, 23));
        btn_openDialog_Stanzblech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_openDialog_StanzblechActionPerformed(evt);
            }
        });
        jPanel_editLabels.add(btn_openDialog_Stanzblech);

        btn_delete_Stanzblech.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Löschen.png"))); // NOI18N
        btn_delete_Stanzblech.setEnabled(false);
        btn_delete_Stanzblech.setPreferredSize(new java.awt.Dimension(23, 23));
        btn_delete_Stanzblech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delete_StanzblechActionPerformed(evt);
            }
        });
        jPanel_editLabels.add(btn_delete_Stanzblech);

        jLabel_Stanzbrille.setText("Stanzbrille");
        jLabel_Stanzbrille.setToolTipText("");
        jLabel_Stanzbrille.setPreferredSize(new java.awt.Dimension(104, 14));
        jPanel_editLabels.add(jLabel_Stanzbrille);

        btn_openDialog_Stanzbrille.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Lupe.png"))); // NOI18N
        btn_openDialog_Stanzbrille.setEnabled(false);
        btn_openDialog_Stanzbrille.setPreferredSize(new java.awt.Dimension(23, 23));
        btn_openDialog_Stanzbrille.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_openDialog_StanzbrilleActionPerformed(evt);
            }
        });
        jPanel_editLabels.add(btn_openDialog_Stanzbrille);

        btn_delete_Stanzbrille.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Löschen.png"))); // NOI18N
        btn_delete_Stanzbrille.setEnabled(false);
        btn_delete_Stanzbrille.setPreferredSize(new java.awt.Dimension(23, 23));
        btn_delete_Stanzbrille.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delete_StanzbrilleActionPerformed(evt);
            }
        });
        jPanel_editLabels.add(btn_delete_Stanzbrille);

        jLabel_Vorstempel.setText("Vorstempel");
        jLabel_Vorstempel.setPreferredSize(new java.awt.Dimension(104, 14));
        jPanel_editLabels.add(jLabel_Vorstempel);

        btn_openDialog_Vorstempel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Lupe.png"))); // NOI18N
        btn_openDialog_Vorstempel.setEnabled(false);
        btn_openDialog_Vorstempel.setPreferredSize(new java.awt.Dimension(23, 23));
        btn_openDialog_Vorstempel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_openDialog_VorstempelActionPerformed(evt);
            }
        });
        jPanel_editLabels.add(btn_openDialog_Vorstempel);

        btn_delete_Vorstempel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Löschen.png"))); // NOI18N
        btn_delete_Vorstempel.setEnabled(false);
        btn_delete_Vorstempel.setPreferredSize(new java.awt.Dimension(23, 23));
        btn_delete_Vorstempel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delete_VorstempelActionPerformed(evt);
            }
        });
        jPanel_editLabels.add(btn_delete_Vorstempel);

        jLabel_Niederhalterplatte.setText("Niederhalterplatte");
        jLabel_Niederhalterplatte.setPreferredSize(new java.awt.Dimension(104, 14));
        jPanel_editLabels.add(jLabel_Niederhalterplatte);

        btn_openDialog_Niederhalterplatte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Lupe.png"))); // NOI18N
        btn_openDialog_Niederhalterplatte.setEnabled(false);
        btn_openDialog_Niederhalterplatte.setPreferredSize(new java.awt.Dimension(23, 23));
        btn_openDialog_Niederhalterplatte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_openDialog_NiederhalterplatteActionPerformed(evt);
            }
        });
        jPanel_editLabels.add(btn_openDialog_Niederhalterplatte);

        btn_delete_Niederhalterplatte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Löschen.png"))); // NOI18N
        btn_delete_Niederhalterplatte.setEnabled(false);
        btn_delete_Niederhalterplatte.setPreferredSize(new java.awt.Dimension(23, 23));
        btn_delete_Niederhalterplatte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delete_NiederhalterplatteActionPerformed(evt);
            }
        });
        jPanel_editLabels.add(btn_delete_Niederhalterplatte);

        jLabel_Ausbrechstempel.setText("Ausbrechstempel");
        jLabel_Ausbrechstempel.setPreferredSize(new java.awt.Dimension(104, 14));
        jPanel_editLabels.add(jLabel_Ausbrechstempel);

        btn_openDialog_Ausbrechstempel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Lupe.png"))); // NOI18N
        btn_openDialog_Ausbrechstempel.setEnabled(false);
        btn_openDialog_Ausbrechstempel.setPreferredSize(new java.awt.Dimension(23, 23));
        btn_openDialog_Ausbrechstempel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_openDialog_AusbrechstempelActionPerformed(evt);
            }
        });
        jPanel_editLabels.add(btn_openDialog_Ausbrechstempel);

        btn_delete_Ausbrechstempel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Löschen.png"))); // NOI18N
        btn_delete_Ausbrechstempel.setEnabled(false);
        btn_delete_Ausbrechstempel.setPreferredSize(new java.awt.Dimension(23, 23));
        btn_delete_Ausbrechstempel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delete_AusbrechstempelActionPerformed(evt);
            }
        });
        jPanel_editLabels.add(btn_delete_Ausbrechstempel);

        jLabel_Lochwerkzeug.setText("Lochwerkzeug");
        jLabel_Lochwerkzeug.setPreferredSize(new java.awt.Dimension(104, 14));
        jPanel_editLabels.add(jLabel_Lochwerkzeug);

        btn_openDialog_Lochwerkzeug.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Lupe.png"))); // NOI18N
        btn_openDialog_Lochwerkzeug.setEnabled(false);
        btn_openDialog_Lochwerkzeug.setPreferredSize(new java.awt.Dimension(23, 23));
        btn_openDialog_Lochwerkzeug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_openDialog_LochwerkzeugActionPerformed(evt);
            }
        });
        jPanel_editLabels.add(btn_openDialog_Lochwerkzeug);

        btn_delete_Lochwerkzeug.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Löschen.png"))); // NOI18N
        btn_delete_Lochwerkzeug.setEnabled(false);
        btn_delete_Lochwerkzeug.setPreferredSize(new java.awt.Dimension(23, 23));
        btn_delete_Lochwerkzeug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delete_LochwerkzeugActionPerformed(evt);
            }
        });
        jPanel_editLabels.add(btn_delete_Lochwerkzeug);

        jLabel_STAL.setText("STAL");
        jLabel_STAL.setPreferredSize(new java.awt.Dimension(104, 14));
        jPanel_editLabels.add(jLabel_STAL);

        btn_openDialog_STAL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Lupe.png"))); // NOI18N
        btn_openDialog_STAL.setEnabled(false);
        btn_openDialog_STAL.setPreferredSize(new java.awt.Dimension(23, 23));
        btn_openDialog_STAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_openDialog_STALActionPerformed(evt);
            }
        });
        jPanel_editLabels.add(btn_openDialog_STAL);

        btn_delete_STAL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Löschen.png"))); // NOI18N
        btn_delete_STAL.setEnabled(false);
        btn_delete_STAL.setPreferredSize(new java.awt.Dimension(23, 23));
        btn_delete_STAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delete_STALActionPerformed(evt);
            }
        });
        jPanel_editLabels.add(btn_delete_STAL);

        jLabel_Führungskäfig.setText("Führungskäfig");
        jLabel_Führungskäfig.setPreferredSize(new java.awt.Dimension(104, 14));
        jPanel_editLabels.add(jLabel_Führungskäfig);

        btn_openDialog_Führungskäfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Lupe.png"))); // NOI18N
        btn_openDialog_Führungskäfig.setEnabled(false);
        btn_openDialog_Führungskäfig.setPreferredSize(new java.awt.Dimension(23, 23));
        btn_openDialog_Führungskäfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_openDialog_FührungskäfigActionPerformed(evt);
            }
        });
        jPanel_editLabels.add(btn_openDialog_Führungskäfig);

        btn_delete_Führungskäfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Löschen.png"))); // NOI18N
        btn_delete_Führungskäfig.setEnabled(false);
        btn_delete_Führungskäfig.setPreferredSize(new java.awt.Dimension(23, 23));
        btn_delete_Führungskäfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delete_FührungskäfigActionPerformed(evt);
            }
        });
        jPanel_editLabels.add(btn_delete_Führungskäfig);

        jLabel_Säulengestell.setText("Säulengestell");
        jLabel_Säulengestell.setPreferredSize(new java.awt.Dimension(104, 14));
        jPanel_editLabels.add(jLabel_Säulengestell);

        btn_openDialog_Säulengestell.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Lupe.png"))); // NOI18N
        btn_openDialog_Säulengestell.setEnabled(false);
        btn_openDialog_Säulengestell.setPreferredSize(new java.awt.Dimension(23, 23));
        btn_openDialog_Säulengestell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_openDialog_SäulengestellActionPerformed(evt);
            }
        });
        jPanel_editLabels.add(btn_openDialog_Säulengestell);

        btn_delete_Säulengestell.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Löschen.png"))); // NOI18N
        btn_delete_Säulengestell.setEnabled(false);
        btn_delete_Säulengestell.setPreferredSize(new java.awt.Dimension(23, 23));
        btn_delete_Säulengestell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delete_SäulengestellActionPerformed(evt);
            }
        });
        jPanel_editLabels.add(btn_delete_Säulengestell);

        jLabel_Schriftzug.setText("Schriftzug");
        jLabel_Schriftzug.setPreferredSize(new java.awt.Dimension(104, 14));
        jPanel_editLabels.add(jLabel_Schriftzug);

        btn_openDialog_Schriftzug.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Lupe.png"))); // NOI18N
        btn_openDialog_Schriftzug.setEnabled(false);
        btn_openDialog_Schriftzug.setPreferredSize(new java.awt.Dimension(23, 23));
        btn_openDialog_Schriftzug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_openDialog_SchriftzugActionPerformed(evt);
            }
        });
        jPanel_editLabels.add(btn_openDialog_Schriftzug);

        btn_delete_Schriftzug.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Löschen.png"))); // NOI18N
        btn_delete_Schriftzug.setEnabled(false);
        btn_delete_Schriftzug.setPreferredSize(new java.awt.Dimension(23, 23));
        btn_delete_Schriftzug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delete_SchriftzugActionPerformed(evt);
            }
        });
        jPanel_editLabels.add(btn_delete_Schriftzug);

        jLabel_placeholder.setPreferredSize(new java.awt.Dimension(400, 14));
        jPanel_editLabels.add(jLabel_placeholder);

        jPanel_editTextFields.setOpaque(false);
        jPanel_editTextFields.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        jTextField_key.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField_key.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextField_key.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jTextField_key.setEnabled(false);
        jTextField_key.setPreferredSize(new java.awt.Dimension(100, 20));
        jPanel_editTextFields.add(jTextField_key);

        jFormattedTextField_Bezeichnung.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jFormattedTextField_Bezeichnung.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jFormattedTextField_Bezeichnung.setEnabled(false);
        jFormattedTextField_Bezeichnung.setPreferredSize(new java.awt.Dimension(200, 20));
        jPanel_editTextFields.add(jFormattedTextField_Bezeichnung);

        jFormattedTextField_Segment.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormattedTextField_Segment.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jFormattedTextField_Segment.setEnabled(false);
        jFormattedTextField_Segment.setPreferredSize(new java.awt.Dimension(150, 20));
        jPanel_editTextFields.add(jFormattedTextField_Segment);

        jFormattedTextField_Grundform.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormattedTextField_Grundform.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jFormattedTextField_Grundform.setEnabled(false);
        jFormattedTextField_Grundform.setPreferredSize(new java.awt.Dimension(150, 20));
        jPanel_editTextFields.add(jFormattedTextField_Grundform);

        jFormattedTextField_Schnitt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormattedTextField_Schnitt.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jFormattedTextField_Schnitt.setEnabled(false);
        jFormattedTextField_Schnitt.setPreferredSize(new java.awt.Dimension(150, 20));
        jPanel_editTextFields.add(jFormattedTextField_Schnitt);

        jFormattedTextField_Stapelung.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormattedTextField_Stapelung.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jFormattedTextField_Stapelung.setEnabled(false);
        jFormattedTextField_Stapelung.setPreferredSize(new java.awt.Dimension(150, 20));
        jPanel_editTextFields.add(jFormattedTextField_Stapelung);

        jFormattedTextField_Stanzblech.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormattedTextField_Stanzblech.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jFormattedTextField_Stanzblech.setEnabled(false);
        jFormattedTextField_Stanzblech.setPreferredSize(new java.awt.Dimension(150, 20));
        jPanel_editTextFields.add(jFormattedTextField_Stanzblech);

        jFormattedTextField_Stanzbrille.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormattedTextField_Stanzbrille.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jFormattedTextField_Stanzbrille.setEnabled(false);
        jFormattedTextField_Stanzbrille.setPreferredSize(new java.awt.Dimension(150, 20));
        jPanel_editTextFields.add(jFormattedTextField_Stanzbrille);

        jFormattedTextField_Vorstempel.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormattedTextField_Vorstempel.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jFormattedTextField_Vorstempel.setEnabled(false);
        jFormattedTextField_Vorstempel.setPreferredSize(new java.awt.Dimension(150, 20));
        jPanel_editTextFields.add(jFormattedTextField_Vorstempel);

        jFormattedTextField_Niederhalterplatte.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormattedTextField_Niederhalterplatte.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jFormattedTextField_Niederhalterplatte.setEnabled(false);
        jFormattedTextField_Niederhalterplatte.setPreferredSize(new java.awt.Dimension(150, 20));
        jPanel_editTextFields.add(jFormattedTextField_Niederhalterplatte);

        jFormattedTextField_Ausbrechstempel.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormattedTextField_Ausbrechstempel.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jFormattedTextField_Ausbrechstempel.setEnabled(false);
        jFormattedTextField_Ausbrechstempel.setPreferredSize(new java.awt.Dimension(150, 20));
        jPanel_editTextFields.add(jFormattedTextField_Ausbrechstempel);

        jFormattedTextField_Lochwerkzeug.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormattedTextField_Lochwerkzeug.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jFormattedTextField_Lochwerkzeug.setEnabled(false);
        jFormattedTextField_Lochwerkzeug.setPreferredSize(new java.awt.Dimension(150, 20));
        jPanel_editTextFields.add(jFormattedTextField_Lochwerkzeug);

        jFormattedTextField_STAL.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormattedTextField_STAL.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jFormattedTextField_STAL.setEnabled(false);
        jFormattedTextField_STAL.setPreferredSize(new java.awt.Dimension(150, 20));
        jPanel_editTextFields.add(jFormattedTextField_STAL);

        jFormattedTextField_Führungskäfig.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormattedTextField_Führungskäfig.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jFormattedTextField_Führungskäfig.setEnabled(false);
        jFormattedTextField_Führungskäfig.setPreferredSize(new java.awt.Dimension(150, 20));
        jPanel_editTextFields.add(jFormattedTextField_Führungskäfig);

        jFormattedTextField_Säulengestell.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormattedTextField_Säulengestell.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jFormattedTextField_Säulengestell.setEnabled(false);
        jFormattedTextField_Säulengestell.setPreferredSize(new java.awt.Dimension(150, 20));
        jPanel_editTextFields.add(jFormattedTextField_Säulengestell);

        jFormattedTextField_Schriftzug.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormattedTextField_Schriftzug.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jFormattedTextField_Schriftzug.setEnabled(false);
        jFormattedTextField_Schriftzug.setPreferredSize(new java.awt.Dimension(150, 20));
        jPanel_editTextFields.add(jFormattedTextField_Schriftzug);

        jLabel_placeholder2.setPreferredSize(new java.awt.Dimension(400, 14));
        jPanel_editTextFields.add(jLabel_placeholder2);

        btn_new.setText("Neu");
        btn_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newActionPerformed(evt);
            }
        });

        btn_edit.setText("Bearbeiten");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        btn_delete.setText("Löschen");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_accept.setText("Übernehmen");
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

        btn_duplicate.setText("Duplizieren");
        btn_duplicate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_duplicateActionPerformed(evt);
            }
        });

        lbl_Anlagedatum.setText("Anlagedatum:");
        lbl_Anlagedatum.setEnabled(false);
        lbl_Anlagedatum.setPreferredSize(new java.awt.Dimension(120, 20));

        lbl_Änderungsdatum.setText("Änderungsdatum:");
        lbl_Änderungsdatum.setEnabled(false);
        lbl_Änderungsdatum.setPreferredSize(new java.awt.Dimension(120, 20));

        lbl_Benutzer.setText("Benutzer:");
        lbl_Benutzer.setEnabled(false);
        lbl_Benutzer.setPreferredSize(new java.awt.Dimension(120, 20));

        jTextField_Anlagedatum.setEditable(false);
        jTextField_Anlagedatum.setBorder(null);
        jTextField_Anlagedatum.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jTextField_Anlagedatum.setEnabled(false);
        jTextField_Anlagedatum.setOpaque(false);
        jTextField_Anlagedatum.setPreferredSize(new java.awt.Dimension(204, 20));

        jTextField_Änderungsdatum.setEditable(false);
        jTextField_Änderungsdatum.setBorder(null);
        jTextField_Änderungsdatum.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jTextField_Änderungsdatum.setEnabled(false);
        jTextField_Änderungsdatum.setOpaque(false);
        jTextField_Änderungsdatum.setPreferredSize(new java.awt.Dimension(204, 20));

        jTextField_Benutzer.setEditable(false);
        jTextField_Benutzer.setBorder(null);
        jTextField_Benutzer.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jTextField_Benutzer.setEnabled(false);
        jTextField_Benutzer.setOpaque(false);
        jTextField_Benutzer.setPreferredSize(new java.awt.Dimension(204, 20));

        javax.swing.GroupLayout jPanel_editDataLayout = new javax.swing.GroupLayout(jPanel_editData);
        jPanel_editData.setLayout(jPanel_editDataLayout);
        jPanel_editDataLayout.setHorizontalGroup(
            jPanel_editDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_editDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_editDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_editDataLayout.createSequentialGroup()
                        .addComponent(btn_accept)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_cancel)
                        .addGap(126, 126, 126))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_editDataLayout.createSequentialGroup()
                        .addComponent(btn_new)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_edit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_duplicate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_delete)))
                .addGap(56, 56, 56)
                .addGroup(jPanel_editDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_Benutzer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Anlagedatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Änderungsdatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_editDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_Anlagedatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Änderungsdatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Benutzer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel_editDataLayout.createSequentialGroup()
                .addGroup(jPanel_editDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel_editLabels, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_editTextFields, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 387, Short.MAX_VALUE))
        );
        jPanel_editDataLayout.setVerticalGroup(
            jPanel_editDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_editDataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel_editLabels, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_editTextFields, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_editDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel_editDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel_editDataLayout.createSequentialGroup()
                            .addComponent(lbl_Anlagedatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbl_Änderungsdatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbl_Benutzer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel_editDataLayout.createSequentialGroup()
                            .addComponent(jTextField_Anlagedatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField_Änderungsdatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField_Benutzer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel_editDataLayout.createSequentialGroup()
                        .addGroup(jPanel_editDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_new)
                            .addComponent(btn_edit)
                            .addComponent(btn_delete)
                            .addComponent(btn_duplicate))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel_editDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_accept)
                            .addComponent(btn_cancel))))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jScrollPane_editData.setViewportView(jPanel_editData);

        javax.swing.GroupLayout jPanel_baseLayout = new javax.swing.GroupLayout(jPanel_base);
        jPanel_base.setLayout(jPanel_baseLayout);
        jPanel_baseLayout.setHorizontalGroup(
            jPanel_baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_baseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane_editData, javax.swing.GroupLayout.DEFAULT_SIZE, 2829, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel_baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_baseLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel_footer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
                .addComponent(jPanel_table, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_baseLayout.setVerticalGroup(
            jPanel_baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_baseLayout.createSequentialGroup()
                .addContainerGap(406, Short.MAX_VALUE)
                .addComponent(jScrollPane_editData, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
            .addGroup(jPanel_baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel_baseLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel_table, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(189, 189, 189)
                    .addComponent(jPanel_footer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
            String mySQL = "SELECT * FROM DiafBDE.dbo.T_Werkzeugstamm";
            ResultSet myResultSet = myStatement.executeQuery(mySQL);            
            TableColumns = myResultSet.getMetaData().getColumnCount();
            myTableModel = (DefaultTableModel) jTable_dbData.getModel();
            int allOldRows = myTableModel.getRowCount();
            if (allOldRows > 0) {
                myTableModel.setRowCount(0);
            }
            while (myResultSet.next()) {
                  
                String[] myValue = new String[TableColumns];
                SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                for (int i = 1; i <= TableColumns; i++) {
                          
                    String myDataSet = myResultSet.getString(i);
//                    System.out.println(myDataSet);
//                    ---------------------
//                    if (myDataSet != null && i == 5) {
//                        if (myDataSet.equals("1")) {
//                            myValue[5] = "hart";
//                        }
//                        else {myValue[5] = "weich";}
//                    }
//                    ---------------------
                    if (myDataSet != null && i == 17 || myDataSet != null && i == 18) {
                        Timestamp ts = Timestamp.valueOf(myDataSet);
                        myDataSet = myFormat.format(ts);
                    }
//                    if (i <= 5){myValue[i-1] = myDataSet;}
//                    else {myValue[i] = myDataSet;}
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
                set_textFieldsEmpty(); 
                if (myConnection != null && !myConnection.isClosed()) {
                    myConnection.close();
                }
            } catch (SQLException myException) {
                System.out.println(myException);
            }
        }
    }
    
    private String get_dependentValueFromDB(String aKey) {        
        try
        { 
            MY_DBCM.setConnection_CLOSED("jdbc:sqlserver://HV-ABAS-SQL;databaseName=DiafBDE;integratedSecurity=true", "DISCONNECT");
            MY_DBCM = new DB_ConnectionManager("jdbc:sqlserver://HV-ABAS-SQL;databaseName=DiafBDE;integratedSecurity=true", "CONNECT");
            myConnection = MY_DBCM.getConnection();
            Statement myStatement = myConnection.createStatement();
            String mySQL = "SELECT * FROM DiafBDE.dbo.T_Säulengestell Where pKey_SG = '" + aKey + "'";
            ResultSet myResultSet = myStatement.executeQuery(mySQL);            
            int myColumns = myResultSet.getMetaData().getColumnCount();
//            myTableModel = (DefaultTableModel) jTable_dbData.getModel();
//            int allOldRows = myTableModel.getRowCount();
//            if (allOldRows > 0) {
//                myTableModel.setRowCount(0);
//            }
            while (myResultSet.next()) {
                  
                String[] myValue = new String[myColumns];
//                SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                for (int i = 1; i <= myColumns; i++) {
                          
                    String myDataSet = myResultSet.getString(i);
//                    System.out.println(myDataSet);
//                    ---------------------
//                    if (myDataSet != null && i == 5) {
//                        if (myDataSet.equals("1")) {
//                            myValue[5] = "hart";
//                        }
//                        else {myValue[5] = "weich";}
//                    }
//                    ---------------------
//                    if (myDataSet != null && i == 4 || myDataSet != null && i == 5) {
//                        Timestamp ts = Timestamp.valueOf(myDataSet);
//                        myDataSet = myFormat.format(ts);
//                    }
//                    if (i <= 5){myValue[i-1] = myDataSet;}
//                    else {myValue[i] = myDataSet;}
                        myValue[i-1] = myDataSet;
                }  
//                myTableModel.addRow(myValue); 
                MyDependentValue_Bezeichnung = myValue[1];
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
        return MyDependentValue_Bezeichnung;
    }
   
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

    private void btn_getCurrentDBDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_getCurrentDBDataActionPerformed
        // TODO add your handling code here:
        get_DBTableData();
        btn_new.setEnabled(true);
        btn_edit.setEnabled(false);
        btn_duplicate.setEnabled(false);
        btn_delete.setEnabled(false);
        btn_accept.setEnabled(false);
        btn_cancel.setEnabled(false);
    }//GEN-LAST:event_btn_getCurrentDBDataActionPerformed

    private void btn_openDialog_GrundformActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_openDialog_GrundformActionPerformed
        // TODO add your handling code here:
        Dialog_DataUse_Grundformstamm myDialog = new Dialog_DataUse_Grundformstamm(this,true); //noch ändern!!!
        myDialog.setTitle("Grundform");
        myDialog.setLocationRelativeTo(null);
        myDialog.setVisible(true);
        String resultFromDialog_ID = myDialog.getChoosenGrundform_ID();
        if (!resultFromDialog_ID.equals("")) {
            this.jFormattedTextField_Führungskäfig.setText(resultFromDialog_ID);
        }
    }//GEN-LAST:event_btn_openDialog_GrundformActionPerformed

    private void btn_delete_GrundformActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delete_GrundformActionPerformed
        // TODO add your handling code here:
        jFormattedTextField_Grundform.setText("");
    }//GEN-LAST:event_btn_delete_GrundformActionPerformed

    private void btn_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newActionPerformed
        // TODO add your handling code here:
        DataSet_Mode = "new";
        set_textFieldsEnabled(true);
        set_oldValues();
        set_tableEnabled(false);
        set_buttonsEnabled(true);
        set_textFieldsEmpty();
        jTextField_key.setText("WKZ");
        jTextField_key.requestFocus();
        btn_new.setEnabled(false);
        btn_edit.setEnabled(false);
        btn_duplicate.setEnabled(false);
        btn_delete.setEnabled(false);
        btn_accept.setEnabled(true);
        btn_cancel.setEnabled(true);
//        btn_openDialog_Grundform.setEnabled(true);
    }//GEN-LAST:event_btn_newActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        // TODO add your handling code here:
        DataSet_Mode = "edit";
        set_oldValues();
        set_tableEnabled(false);
        set_textFieldsEnabled(true);
        set_buttonsEnabled(true);
        jFormattedTextField_Bezeichnung.requestFocus();
        btn_new.setEnabled(false);
        btn_edit.setEnabled(false);
        btn_duplicate.setEnabled(false);
        btn_delete.setEnabled(false);
        btn_accept.setEnabled(true);
        btn_cancel.setEnabled(true);
        btn_openDialog_Grundform.setEnabled(true);
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        DataSet_Mode = "delete";
        if (DataSet_Mode.equals("delete") && test_isDataSetInDB(jTextField_key.getText().trim()) == true) {
            int myAnswer = JOptionPane.showConfirmDialog(null,
                "Soll der Datensatz WKZ (Key): \n\n >> " + jTextField_key.getText().trim() + " << \n\n wirklich gelöscht werden?",
                "Datensatz löschen?",
                JOptionPane.YES_NO_OPTION);
            if (myAnswer == 0) {
                do_deleteDataSet_inDB();
                get_DBTableData();
                //                set_textFieldsDisabled();
                btn_new.setEnabled(true);
                btn_edit.setEnabled(false);
                btn_duplicate.setEnabled(false);
                btn_delete.setEnabled(false);
                btn_accept.setEnabled(false);
                btn_cancel.setEnabled(false);
                lbl_rowCount.setText(String.valueOf(mySorter.getViewRowCount()) + " von " + String.valueOf(myTableModel.getRowCount()));
            }
        }
        DataSet_Mode = "clean";
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_acceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_acceptActionPerformed
        // TODO add your handling code here:
        if (jTextField_key.getText().isEmpty() || jTextField_key.getText().equals("WKZ")) {
            JOptionPane.showMessageDialog(null,
                "Der Datensatz ist teilweise leer. Erfassen Sie Daten oder klicken Sie auf Abbrechen.",
                "Fehler",
                JOptionPane.ERROR_MESSAGE);
        }
        else {
            boolean myAnswer = test_isDataSetInDB(jTextField_key.getText().trim());

            if (myAnswer == true) {
                if (DataSet_Mode.equals("new")) {
                    JOptionPane.showMessageDialog(null,
                        "Es existiert schon ein Datensatz mit diesem Key: \n\n >> " + jTextField_key.getText().trim() + " <<.",
                        "Fehler",
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (DataSet_Mode.equals("edit")  && !Old_Bezeichnung.equals(jFormattedTextField_Bezeichnung.getText().trim())
                    || !Old_Segment.equals(jFormattedTextField_Segment.getText().trim())
                    || !Old_Grundform.equals(jFormattedTextField_Grundform.getText().trim())
                    || !Old_Grundform.equals(jFormattedTextField_Schnitt.getText().trim())
                    || !Old_Grundform.equals(jFormattedTextField_Stapelung.getText().trim())
                    || !Old_Grundform.equals(jFormattedTextField_Stanzblech.getText().trim())
                    || !Old_Grundform.equals(jFormattedTextField_Stanzbrille.getText().trim())
                    || !Old_Grundform.equals(jFormattedTextField_Vorstempel.getText().trim())
                    || !Old_Grundform.equals(jFormattedTextField_Niederhalterplatte.getText().trim())
                    || !Old_Grundform.equals(jFormattedTextField_Ausbrechstempel.getText().trim())
                    || !Old_Grundform.equals(jFormattedTextField_Lochwerkzeug.getText().trim())
                    || !Old_Grundform.equals(jFormattedTextField_STAL.getText().trim())
                    || !Old_Grundform.equals(jFormattedTextField_Führungskäfig.getText().trim())
                    || !Old_Grundform.equals(jFormattedTextField_Säulengestell.getText().trim())
                    || !Old_Grundform.equals(jFormattedTextField_Schriftzug.getText().trim())) {
                    do_updateDataSet_inDB();
                }
                if (DataSet_Mode.equals("duplicate")) {
                    JOptionPane.showMessageDialog(null,"Beim Duplizieren muss ein neuer Key vergeben werden.",
                        "Fehler",
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            if (myAnswer == false) {
                if (DataSet_Mode.equals("new") || DataSet_Mode.equals("duplicate")) {
                    do_insertDataSet_intoDB();
                }
            }
            set_textFieldsEnabled(false);
            set_buttonsEnabled(false);
            btn_new.setEnabled(true);
            btn_accept.setEnabled(false);
            btn_cancel.setEnabled(false);
            btn_openDialog_Grundform.setEnabled(false);
            btn_delete_Grundform.setEnabled(false);
            //            if (jTable_dbData.getSelectedRow() > -1) {
                //
                //                btn_edit.setEnabled(true);
                //                btn_duplicate.setEnabled(true);
                //                btn_delete.setEnabled(true);
                //            }
            //            else {
                btn_edit.setEnabled(false);
                btn_duplicate.setEnabled(false);
                btn_delete.setEnabled(false);
                set_tableEnabled(true);
                //            }
            get_DBTableData();
            lbl_rowCount.setText(String.valueOf(mySorter.getViewRowCount()) + " von " + String.valueOf(myTableModel.getRowCount()));
            DataSet_Mode = "clean";
        }
    }//GEN-LAST:event_btn_acceptActionPerformed

    private void btn_duplicateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_duplicateActionPerformed
        // TODO add your handling code here:
        DataSet_Mode = "duplicate";
        set_oldValues();
        set_tableEnabled(false);
        set_textFieldsEnabled(true);
        set_buttonsEnabled(true);
        jTextField_key.requestFocus();
        btn_new.setEnabled(false);
        btn_edit.setEnabled(false);
        btn_duplicate.setEnabled(false);
        btn_delete.setEnabled(false);
        btn_accept.setEnabled(true);
        btn_cancel.setEnabled(true);
        btn_openDialog_Grundform.setEnabled(true);
    }//GEN-LAST:event_btn_duplicateActionPerformed

    private void btn_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_closeActionPerformed
        // TODO add your handling code here:
        if (MY_DBCM.isConnnected()) {
            MY_DBCM.setConnection_CLOSED("jdbc:sqlserver://HV-ABAS-SQL;databaseName=DiafBDE;integratedSecurity=true", "DISCONNECT");
        }
        int myReturnValue = test_continueEditing();
        if (myReturnValue != 0 || DataSet_Mode.equals("clean")) {
            InstanceCount = 0;
            this.dispose();
        }
    }//GEN-LAST:event_btn_closeActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        do_preBuild();
        do_postBuild();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        int myReturnValue = test_continueEditing();
            if (myReturnValue != 0) {
                this.dispose();
            }
    }//GEN-LAST:event_formWindowClosing

    private void btn_openDialog_SegmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_openDialog_SegmentActionPerformed
        // TODO add your handling code here:
        Dialog_DataUse_Segment myDialog = new Dialog_DataUse_Segment(this,true); //noch ändern!!!
        myDialog.setTitle("Segment");
//        Point location = MouseInfo.getPointerInfo().getLocation();
//        myDialog.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 2 , Toolkit.getDefaultToolkit().getScreenSize().height / 2);
        myDialog.setLocationRelativeTo(null);
        myDialog.setVisible(true);
        String resultFromDialog_ID = myDialog.getChoosenSegment_ID();
        if (!resultFromDialog_ID.equals("")) {
            this.jFormattedTextField_Segment.setText(resultFromDialog_ID);
        }
    }//GEN-LAST:event_btn_openDialog_SegmentActionPerformed

    private void btn_delete_SegmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delete_SegmentActionPerformed
        // TODO add your handling code here:
        jFormattedTextField_Segment.setText("");
    }//GEN-LAST:event_btn_delete_SegmentActionPerformed

    private void btn_openDialog_SchnittActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_openDialog_SchnittActionPerformed
        // TODO add your handling code here:
        Dialog_DataUse_Schnitt myDialog = new Dialog_DataUse_Schnitt(this,true); //noch ändern!!!
        myDialog.setTitle("Schnitt");
        myDialog.setLocationRelativeTo(null);
        myDialog.setVisible(true);
        String resultFromDialog_ID = myDialog.getChoosenSchnitt_ID();
        if (!resultFromDialog_ID.equals("")) {
            this.jFormattedTextField_Schnitt.setText(resultFromDialog_ID);
        }
    }//GEN-LAST:event_btn_openDialog_SchnittActionPerformed

    private void btn_delete_SchnittActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delete_SchnittActionPerformed
        // TODO add your handling code here:
        jFormattedTextField_Schnitt.setText("");
    }//GEN-LAST:event_btn_delete_SchnittActionPerformed

    private void btn_openDialog_StapelungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_openDialog_StapelungActionPerformed
        // TODO add your handling code here:
        Dialog_DataUse_Stapelung myDialog = new Dialog_DataUse_Stapelung(this,true); //noch ändern!!!
        myDialog.setTitle("Stapelung");
        myDialog.setLocationRelativeTo(null);
        myDialog.setVisible(true);
        String resultFromDialog_ID = myDialog.getChoosenStapelung_ID();
        if (!resultFromDialog_ID.equals("")) {
            this.jFormattedTextField_Stapelung.setText(resultFromDialog_ID);
        }
    }//GEN-LAST:event_btn_openDialog_StapelungActionPerformed

    private void btn_delete_StapelungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delete_StapelungActionPerformed
        // TODO add your handling code here:
        jFormattedTextField_Stapelung.setText("");
    }//GEN-LAST:event_btn_delete_StapelungActionPerformed

    private void btn_openDialog_StanzblechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_openDialog_StanzblechActionPerformed
        // TODO add your handling code here:
        Dialog_DataUse_Stanzblech myDialog = new Dialog_DataUse_Stanzblech(this,true); //noch ändern!!!
        myDialog.setTitle("Stanzblech");
//        Point location = MouseInfo.getPointerInfo().getLocation();
//        myDialog.setLocation(location.x + 20 , location.y - 300);
        myDialog.setLocationRelativeTo(null);
        myDialog.setVisible(true);
        String resultFromDialog_ID = myDialog.getChoosenStanzblech_ID();
        if (!resultFromDialog_ID.equals("")) {
            this.jFormattedTextField_Stanzblech.setText(resultFromDialog_ID);
        }
    }//GEN-LAST:event_btn_openDialog_StanzblechActionPerformed

    private void btn_delete_StanzblechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delete_StanzblechActionPerformed
        // TODO add your handling code here:
        jFormattedTextField_Stanzblech.setText("");
    }//GEN-LAST:event_btn_delete_StanzblechActionPerformed

    private void btn_openDialog_StanzbrilleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_openDialog_StanzbrilleActionPerformed
        // TODO add your handling code here:
        Dialog_DataUse_Stanzbrille myDialog = new Dialog_DataUse_Stanzbrille(this,true); //noch ändern!!!
        myDialog.setTitle("Stanzbrille");
        myDialog.setLocationRelativeTo(null);
        myDialog.setVisible(true);
        String resultFromDialog_ID = myDialog.getChoosenStanzbrillen_ID();
        if (!resultFromDialog_ID.equals("")) {
            this.jFormattedTextField_Stanzbrille.setText(resultFromDialog_ID);
        }
    }//GEN-LAST:event_btn_openDialog_StanzbrilleActionPerformed

    private void btn_delete_StanzbrilleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delete_StanzbrilleActionPerformed
        // TODO add your handling code here:
        jFormattedTextField_Stanzbrille.setText("");
    }//GEN-LAST:event_btn_delete_StanzbrilleActionPerformed

    private void btn_openDialog_VorstempelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_openDialog_VorstempelActionPerformed
        // TODO add your handling code here:
        Dialog_DataUse_Vorstempel myDialog = new Dialog_DataUse_Vorstempel(this,true); //noch ändern!!!
        myDialog.setTitle("Vorstempel");
        myDialog.setLocationRelativeTo(null);
        myDialog.setVisible(true);
        String resultFromDialog_ID = myDialog.getChoosenVorstempel_ID();
        if (!resultFromDialog_ID.equals("")) {
            this.jFormattedTextField_Vorstempel.setText(resultFromDialog_ID);
        }
    }//GEN-LAST:event_btn_openDialog_VorstempelActionPerformed

    private void btn_delete_VorstempelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delete_VorstempelActionPerformed
        // TODO add your handling code here:
        jFormattedTextField_Vorstempel.setText("");
    }//GEN-LAST:event_btn_delete_VorstempelActionPerformed

    private void btn_openDialog_NiederhalterplatteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_openDialog_NiederhalterplatteActionPerformed
        // TODO add your handling code here:
        Dialog_DataUse_Niederhalterplatte myDialog = new Dialog_DataUse_Niederhalterplatte(this,true); //noch ändern!!!
        myDialog.setTitle("Niederhalterplatte");
        myDialog.setLocationRelativeTo(null);
        myDialog.setVisible(true);
        String resultFromDialog_ID = myDialog.getChoosenNiederhalterplatten_ID();
        if (!resultFromDialog_ID.equals("")) {
            this.jFormattedTextField_Niederhalterplatte.setText(resultFromDialog_ID);
        }
    }//GEN-LAST:event_btn_openDialog_NiederhalterplatteActionPerformed

    private void btn_delete_NiederhalterplatteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delete_NiederhalterplatteActionPerformed
        // TODO add your handling code here:
        jFormattedTextField_Niederhalterplatte.setText("");
    }//GEN-LAST:event_btn_delete_NiederhalterplatteActionPerformed

    private void btn_openDialog_AusbrechstempelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_openDialog_AusbrechstempelActionPerformed
        // TODO add your handling code here:
        Dialog_DataUse_Ausbrechstempel myDialog = new Dialog_DataUse_Ausbrechstempel(this,true); //noch ändern!!!
        myDialog.setTitle("Ausbrechstempel");
        myDialog.setSize(800, 500);
        myDialog.setLocationRelativeTo(null);
        myDialog.setVisible(true);
        String resultFromDialog_ID = myDialog.getChoosenAusbrechstempel_ID();
        if (!resultFromDialog_ID.equals("")) {
            this.jFormattedTextField_Ausbrechstempel.setText(resultFromDialog_ID);
        }
    }//GEN-LAST:event_btn_openDialog_AusbrechstempelActionPerformed

    private void btn_delete_AusbrechstempelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delete_AusbrechstempelActionPerformed
        // TODO add your handling code here:
        jFormattedTextField_Ausbrechstempel.setText("");
    }//GEN-LAST:event_btn_delete_AusbrechstempelActionPerformed

    private void btn_openDialog_LochwerkzeugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_openDialog_LochwerkzeugActionPerformed
        // TODO add your handling code here:
        Dialog_DataUse_Lochwerkzeug myDialog = new Dialog_DataUse_Lochwerkzeug(this,true); //noch ändern!!!
        myDialog.setTitle("Lochwerkzeug");
        myDialog.setLocationRelativeTo(null);
        myDialog.setVisible(true);
        String resultFromDialog_ID = myDialog.getChoosenLochwerkzeug_ID();
        if (!resultFromDialog_ID.equals("")) {
            this.jFormattedTextField_Lochwerkzeug.setText(resultFromDialog_ID);
        }
    }//GEN-LAST:event_btn_openDialog_LochwerkzeugActionPerformed

    private void btn_delete_LochwerkzeugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delete_LochwerkzeugActionPerformed
        // TODO add your handling code here:
        jFormattedTextField_Lochwerkzeug.setText("");
    }//GEN-LAST:event_btn_delete_LochwerkzeugActionPerformed

    private void btn_openDialog_STALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_openDialog_STALActionPerformed
        // TODO add your handling code here:
        Dialog_DataUse_STAL myDialog = new Dialog_DataUse_STAL(this,true); //noch ändern!!!
        myDialog.setTitle("STAL");
        myDialog.setLocationRelativeTo(null);
        myDialog.setVisible(true);
        String resultFromDialog_ID = myDialog.getChoosenSTAL_ID();
        if (!resultFromDialog_ID.equals("")) {
            this.jFormattedTextField_STAL.setText(resultFromDialog_ID);
        }
    }//GEN-LAST:event_btn_openDialog_STALActionPerformed

    private void btn_delete_STALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delete_STALActionPerformed
        // TODO add your handling code here:
        jFormattedTextField_STAL.setText("");
    }//GEN-LAST:event_btn_delete_STALActionPerformed

    private void btn_openDialog_FührungskäfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_openDialog_FührungskäfigActionPerformed
        // TODO add your handling code here:
        Dialog_DataUse_Führungskäfig myDialog = new Dialog_DataUse_Führungskäfig(this,true); //noch ändern!!!
        myDialog.setTitle("Führungskäfig");
        myDialog.setLocationRelativeTo(null);
        myDialog.setVisible(true);
        String resultFromDialog_ID = myDialog.getChoosenFührungskäfig_ID();
        if (!resultFromDialog_ID.equals("")) {
            this.jFormattedTextField_Führungskäfig.setText(resultFromDialog_ID);
        }
    }//GEN-LAST:event_btn_openDialog_FührungskäfigActionPerformed

    private void btn_delete_FührungskäfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delete_FührungskäfigActionPerformed
        // TODO add your handling code here:
        jFormattedTextField_Führungskäfig.setText("");
    }//GEN-LAST:event_btn_delete_FührungskäfigActionPerformed

    private void btn_openDialog_SäulengestellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_openDialog_SäulengestellActionPerformed
        // TODO add your handling code here:
        Dialog_DataUse_Säulengestell myDialog = new Dialog_DataUse_Säulengestell(this,true); //noch ändern!!!
        myDialog.setTitle("Säulengestell");
        myDialog.setLocationRelativeTo(null);
        myDialog.setVisible(true);
        String resultFromDialog_ID = myDialog.getChoosenSäulengestell_Nr();
        if (!resultFromDialog_ID.equals("")) {
            this.jFormattedTextField_Säulengestell.setText(resultFromDialog_ID);
        }
    }//GEN-LAST:event_btn_openDialog_SäulengestellActionPerformed

    private void btn_delete_SäulengestellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delete_SäulengestellActionPerformed
        // TODO add your handling code here:
        jFormattedTextField_Säulengestell.setText("");
    }//GEN-LAST:event_btn_delete_SäulengestellActionPerformed

    private void btn_openDialog_SchriftzugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_openDialog_SchriftzugActionPerformed
        // TODO add your handling code here:
        Dialog_DataUse_Schriftzug myDialog = new Dialog_DataUse_Schriftzug(this,true); //noch ändern!!!
        myDialog.setTitle("Schriftzug");
        myDialog.setLocationRelativeTo(null);
        myDialog.setVisible(true);
        String resultFromDialog_ID = myDialog.getChoosenSchriftzug_ID();
        if (!resultFromDialog_ID.equals("")) {
            this.jFormattedTextField_Schriftzug.setText(resultFromDialog_ID);
        }
    }//GEN-LAST:event_btn_openDialog_SchriftzugActionPerformed

    private void btn_delete_SchriftzugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delete_SchriftzugActionPerformed
        // TODO add your handling code here:
        jFormattedTextField_Schriftzug.setText("");
    }//GEN-LAST:event_btn_delete_SchriftzugActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        // TODO add your handling code here:
        get_oldValues();
        //        set_textFieldsDisabled();
        btn_new.setEnabled(true);
        if (!Old_Key.equals("")) {
            btn_edit.setEnabled(true);
            btn_duplicate.setEnabled(true);
            btn_delete.setEnabled(true);
        }
        btn_accept.setEnabled(false);
        btn_cancel.setEnabled(false);
        btn_openDialog_Grundform.setEnabled(false);
        btn_delete_Grundform.setEnabled(false);
        set_tableEnabled(true);
        set_buttonsEnabled(false);
        set_textFieldsEnabled(false);
        DataSet_Mode = "clean";
    }//GEN-LAST:event_btn_cancelActionPerformed
   
    private int test_continueEditing() {
        int myAnswer = 0;
        if (!DataSet_Mode.equals("clean")) {

            myAnswer = JOptionPane.showOptionDialog(null, 
            "Es existieren noch ungespeicherte Änderungenn. \n Möchten Sie die Bearbeitung fortsetzen oder das Fenster schließen?", 
            "Bearbeitung fortsetzen?", 
            JOptionPane.OK_CANCEL_OPTION, 
            JOptionPane.INFORMATION_MESSAGE, 
            null, 
            new String[]{"Bearbeitung fortsetzen", "Fenster schließen"},
            "default");
            }
        return myAnswer;
    }
    
    private void set_textFieldsEmpty() {
        jTextField_key.setText("");
        jFormattedTextField_Bezeichnung.setText("");
        jFormattedTextField_Segment.setText("");
        jFormattedTextField_Grundform.setText("");
        jFormattedTextField_Schnitt.setText("");
        jFormattedTextField_Stapelung.setText("");
        jFormattedTextField_Stanzblech.setText("");
        jFormattedTextField_Stanzbrille.setText("");
        jFormattedTextField_Vorstempel.setText("");
        jFormattedTextField_Niederhalterplatte.setText("");
        jFormattedTextField_Ausbrechstempel.setText("");
        jFormattedTextField_Lochwerkzeug.setText("");
        jFormattedTextField_STAL.setText("");
        jFormattedTextField_Führungskäfig.setText("");
        jFormattedTextField_Säulengestell.setText("");
        jFormattedTextField_Schriftzug.setText("");
        jTextField_Anlagedatum.setText("");
        jTextField_Änderungsdatum.setText("");
        jTextField_Benutzer.setText("");      
    }
    
    private void set_oldValues() {         
        Old_Key = jTextField_key.getText().trim();
        Old_Bezeichnung = jFormattedTextField_Bezeichnung.getText().trim();
        Old_Segment = jFormattedTextField_Segment.getText().trim();
        Old_Grundform = jFormattedTextField_Grundform.getText().trim();
        Old_Schnitt = jFormattedTextField_Schnitt.getText().trim();
        Old_Stapelung = jFormattedTextField_Stapelung.getText().trim();
        Old_Stanzblech = jFormattedTextField_Stanzblech.getText().trim();
        Old_Stanzbrille = jFormattedTextField_Stanzbrille.getText().trim();
        Old_Vorstempel = jFormattedTextField_Vorstempel.getText().trim();
        Old_Niederhalterplatte = jFormattedTextField_Niederhalterplatte.getText().trim();
        Old_Ausbrechstempel = jFormattedTextField_Ausbrechstempel.getText().trim();
        Old_Lochwerkzeug = jFormattedTextField_Lochwerkzeug.getText().trim();
        Old_STAL = jFormattedTextField_STAL.getText().trim();
        Old_Führungskäfig = jFormattedTextField_Führungskäfig.getText().trim();
        Old_Säulengestell = jFormattedTextField_Säulengestell.getText().trim();
        Old_Schriftzug = jFormattedTextField_Schriftzug.getText().trim();
        Old_Anlagedatum = jTextField_Anlagedatum.getText();
        Old_Änderungsdatum = jTextField_Änderungsdatum.getText();
        Old_Benutzer = jTextField_Benutzer.getText();
    }
    
    private void get_oldValues() {         
        jTextField_key.setText(Old_Key);
        jFormattedTextField_Bezeichnung.setText(Old_Bezeichnung);
        jFormattedTextField_Segment.setText(Old_Segment); 
        jFormattedTextField_Grundform.setText(Old_Grundform); 
        jFormattedTextField_Schnitt.setText(Old_Schnitt); 
        jFormattedTextField_Stapelung.setText(Old_Stapelung); 
        jFormattedTextField_Stanzblech.setText(Old_Stanzblech); 
        jFormattedTextField_Stanzbrille.setText(Old_Stanzbrille); 
        jFormattedTextField_Vorstempel.setText(Old_Vorstempel); 
        jFormattedTextField_Niederhalterplatte.setText(Old_Niederhalterplatte); 
        jFormattedTextField_Ausbrechstempel.setText(Old_Ausbrechstempel); 
        jFormattedTextField_Lochwerkzeug.setText(Old_Lochwerkzeug); 
        jFormattedTextField_STAL.setText(Old_STAL); 
        jFormattedTextField_Führungskäfig.setText(Old_Führungskäfig); 
        jFormattedTextField_Säulengestell.setText(Old_Säulengestell); 
        jFormattedTextField_Schriftzug.setText(Old_Schriftzug);
        jTextField_Anlagedatum.setText(Old_Anlagedatum);
        jTextField_Änderungsdatum.setText(Old_Änderungsdatum);
        jTextField_Benutzer.setText(Old_Benutzer);
    }
    
    private void set_textFieldsEnabled(boolean aBoolean) {  
        
        for (int i=1; i < jPanel_editTextFields.getComponentCount(); i++) {
            jPanel_editTextFields.getComponent(i).setEnabled(aBoolean);
        }
        jTextField_key.setEnabled(aBoolean);
    }
        
    private void set_buttonsEnabled(boolean aBoolean) {
              
//        for (int i=0; i < jPanel_editLabels.getComponentCount(); i++) {
//            if (jPanel_editLabels.getComponent(i).getName().substring(1, 4).equals("btn_")) {
//                    jPanel_editLabels.getComponent(i).setEnabled(aBoolean);
//            }
//        }
        btn_openDialog_Segment.setEnabled(aBoolean);
        btn_delete_Segment.setEnabled(aBoolean);
        btn_openDialog_Grundform.setEnabled(aBoolean);
        btn_delete_Grundform.setEnabled(aBoolean);
        btn_openDialog_Schnitt.setEnabled(aBoolean);
        btn_delete_Schnitt.setEnabled(aBoolean);
        btn_openDialog_Stapelung.setEnabled(aBoolean);
        btn_delete_Stapelung.setEnabled(aBoolean);
        btn_openDialog_Stanzblech.setEnabled(aBoolean);
        btn_delete_Stanzblech.setEnabled(aBoolean);
        btn_openDialog_Stanzbrille.setEnabled(aBoolean);
        btn_delete_Stanzbrille.setEnabled(aBoolean);
        btn_openDialog_Vorstempel.setEnabled(aBoolean);
        btn_delete_Vorstempel.setEnabled(aBoolean);
        btn_openDialog_Niederhalterplatte.setEnabled(aBoolean);
        btn_delete_Niederhalterplatte.setEnabled(aBoolean);
        btn_openDialog_Ausbrechstempel.setEnabled(aBoolean);
        btn_delete_Ausbrechstempel.setEnabled(aBoolean);
        btn_openDialog_Lochwerkzeug.setEnabled(aBoolean);
        btn_delete_Lochwerkzeug.setEnabled(aBoolean);
        btn_openDialog_STAL.setEnabled(aBoolean);
        btn_delete_STAL.setEnabled(aBoolean);
        btn_openDialog_Führungskäfig.setEnabled(aBoolean);
        btn_delete_Führungskäfig.setEnabled(aBoolean);
        btn_openDialog_Säulengestell.setEnabled(aBoolean);
        btn_delete_Säulengestell.setEnabled(aBoolean);
        btn_openDialog_Schriftzug.setEnabled(aBoolean);
        btn_delete_Schriftzug.setEnabled(aBoolean);
    }
    
    private boolean test_isDataSetInDB(String aString) {
        boolean myAnswer = false;
        for (int myRow = 0; myRow < jTable_dbData.getRowCount(); ++myRow ) {
            if (myTableModel.getValueAt(myRow, 0).toString().trim().equals(aString))
                myAnswer = true;           
        }
        return myAnswer;
    }
    
    private void do_deleteDataSet_inDB() {        
        try
        {
            MY_DBCM.setConnection_CLOSED("jdbc:sqlserver://HV-ABAS-SQL;databaseName=DiafBDE;integratedSecurity=true", "DISCONNECT");
            MY_DBCM = new DB_ConnectionManager("jdbc:sqlserver://HV-ABAS-SQL;databaseName=DiafBDE;integratedSecurity=true", "CONNECT");
            if (MY_DBCM.isConnnected()) 
            {   
            myConnection = MY_DBCM.getConnection();
            Statement myStatement = myConnection.createStatement();
            myStatement.executeUpdate("DELETE FROM DiafBDE.dbo.T_Werkzeugstamm WHERE pKey_WKZ = '" + jTextField_key.getText().trim() + "'");             
            }   
        }
        catch (/*ClassNotFoundException |*/ SQLException myException )
        {
        }
        finally {
            try {
                if (myConnection != null && !myConnection.isClosed()) {
                    myConnection.close();
                }
            } catch (SQLException myException) {
            }
        }                  
    }
    
    private void do_updateDataSet_inDB() {        
        try
        {
            MY_DBCM.setConnection_CLOSED("jdbc:sqlserver://HV-ABAS-SQL;databaseName=DiafBDE;integratedSecurity=true", "DISCONNECT");
            MY_DBCM = new DB_ConnectionManager("jdbc:sqlserver://HV-ABAS-SQL;databaseName=DiafBDE;integratedSecurity=true", "CONNECT");
            if (MY_DBCM.isConnnected()) 
            {   
            myConnection = MY_DBCM.getConnection();
            SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
            Änderungsdatum = new Timestamp(System.currentTimeMillis());
            String result = myFormat.format(Änderungsdatum);
            Benutzer = System.getProperty("user.name"); 
            Statement myStatement = myConnection.createStatement();
            myStatement.executeUpdate("UPDATE DiafBDE.dbo.T_Werkzeugstamm SET Bezeichnung = '" + jFormattedTextField_Bezeichnung.getText().trim() +
                    "', Segment = '" + jFormattedTextField_Segment.getText().trim() +
                    "', Grundform = '" + jFormattedTextField_Grundform.getText().trim() +
                    "', Schnitt = '" + jFormattedTextField_Schnitt.getText().trim() +
                    "', Stapelung = '" + jFormattedTextField_Stapelung.getText().trim() +
                    "', Stanzblech = '" + jFormattedTextField_Stanzblech.getText().trim() +
                    "', Stanzbrille = '" + jFormattedTextField_Stanzbrille.getText().trim() +
                    "', Vorstempel = '" + jFormattedTextField_Vorstempel.getText().trim() +
                    "', Niederhalterplatte = '" + jFormattedTextField_Niederhalterplatte.getText().trim() +
                    "', Ausbrechstempel = '" + jFormattedTextField_Ausbrechstempel.getText().trim() +
                    "', Lochwerkzeug = '" + jFormattedTextField_Lochwerkzeug.getText().trim() +
                    "', STAL = '" + jFormattedTextField_STAL.getText().trim() +
                    "', Führungskäfig = '" + jFormattedTextField_Führungskäfig.getText().trim() +
                    "', Säulengestell = '" + jFormattedTextField_Säulengestell.getText().trim() +
                    "', Schriftzug = '" + jFormattedTextField_Schriftzug.getText().trim() +
                    "', Änderungsdatum = '" + result +
                    "', Benutzer = '" + Benutzer +
                    
                    "' WHERE pKey_WKZ = '" + jTextField_key.getText() + "'");             
            } 
        }
        catch (/*ClassNotFoundException |*/ SQLException myException )
        {
        }
        finally {
            try {
                if (myConnection != null && !myConnection.isClosed()) {
                    myConnection.close();
                }
            } catch (SQLException myException) {
            }
        }   
    }
    
    private void do_insertDataSet_intoDB() {        
        try
        {
//            System.out.println(((Number) jFormattedTextField_value2.getValue()).floatValue());
            MY_DBCM.setConnection_CLOSED("jdbc:sqlserver://HV-ABAS-SQL;databaseName=DiafBDE;integratedSecurity=true", "DISCONNECT");
            MY_DBCM = new DB_ConnectionManager("jdbc:sqlserver://HV-ABAS-SQL;databaseName=DiafBDE;integratedSecurity=true", "CONNECT");
            if (MY_DBCM.isConnnected()) 
            {    
            myConnection = MY_DBCM.getConnection();
            SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
            Anlagedatum = new Timestamp(System.currentTimeMillis());
            String result = myFormat.format(Anlagedatum);
            Benutzer = System.getProperty("user.name");
            if (jFormattedTextField_Segment.getText().trim().equals("")) {
                jFormattedTextField_Segment.setText("KP0");
            }
            if (jFormattedTextField_Grundform.getText().trim().equals("")) {
                jFormattedTextField_Grundform.setText("GF0");
            }
            if (jFormattedTextField_Schnitt.getText().trim().equals("")) {
                jFormattedTextField_Schnitt.setText("KWS0");
            }
            if (jFormattedTextField_Stapelung.getText().trim().equals("")) {
                jFormattedTextField_Stapelung.setText("KWR0");
            }
            if (jFormattedTextField_Stanzblech.getText().trim().equals("")) {
                jFormattedTextField_Stanzblech.setText("B0");
            }
            if (jFormattedTextField_Stanzbrille.getText().trim().equals("")) {
                jFormattedTextField_Stanzbrille.setText("KSB0");
            }
            if (jFormattedTextField_Vorstempel.getText().trim().equals("")) {
                jFormattedTextField_Vorstempel.setText("KWV0");
            }
            if (jFormattedTextField_Niederhalterplatte.getText().trim().equals("")) {
                jFormattedTextField_Niederhalterplatte.setText("KWNP0");
            }
            if (jFormattedTextField_Ausbrechstempel.getText().trim().equals("")) {
                jFormattedTextField_Ausbrechstempel.setText("ASB0");
            }
            if (jFormattedTextField_Lochwerkzeug.getText().trim().equals("")) {
                jFormattedTextField_Lochwerkzeug.setText("LW0");
            }
            if (jFormattedTextField_STAL.getText().trim().equals("")) {
                jFormattedTextField_STAL.setText("STAL0");
            }
            if (jFormattedTextField_Führungskäfig.getText().trim().equals("")) {
                jFormattedTextField_Führungskäfig.setText("FK0");
            }
            if (jFormattedTextField_Säulengestell.getText().trim().equals("")) {
                jFormattedTextField_Säulengestell.setText("SG0");
            }
            if (jFormattedTextField_Schriftzug.getText().trim().equals("")) {
                jFormattedTextField_Schriftzug.setText("SZ0");
            }
            Statement myStatement = myConnection.createStatement();
            myStatement.executeUpdate("INSERT INTO DiafBDE.dbo.T_Werkzeugstamm (pKey_WKZ, Bezeichnung, Segment, Grundform, Schnitt, Stapelung,"
                    + "Stanzblech, Stanzbrille, Vorstempel, Niederhalterplatte, Ausbrechstempel, Lochwerkzeug, STAL, Führungskäfig,"
                    + "Säulengestell, Schriftzug, Anlagedatum, Benutzer)" 
                    + "VALUES ('" + jTextField_key.getText().trim() + "', '" 
                    + jFormattedTextField_Bezeichnung.getText().trim() + "', '" 
                    + jFormattedTextField_Segment.getText().trim() + "', '" 
                    + jFormattedTextField_Grundform.getText().trim() + "', '" 
                    + jFormattedTextField_Schnitt.getText().trim() + "', '" 
                    + jFormattedTextField_Stapelung.getText().trim() + "', '" 
                    + jFormattedTextField_Stanzblech.getText().trim() + "', '" 
                    + jFormattedTextField_Stanzbrille.getText().trim() + "', '" 
                    + jFormattedTextField_Vorstempel.getText().trim() + "', '" 
                    + jFormattedTextField_Niederhalterplatte.getText().trim() + "', '" 
                    + jFormattedTextField_Ausbrechstempel.getText().trim() + "', '" 
                    + jFormattedTextField_Lochwerkzeug.getText().trim() + "', '" 
                    + jFormattedTextField_STAL.getText().trim() + "', '" 
                    + jFormattedTextField_Führungskäfig.getText().trim() + "', '" 
                    + jFormattedTextField_Säulengestell.getText().trim() + "', '" 
                    + jFormattedTextField_Schriftzug.getText().trim() + "', '" 
                    + result + "', '" 
                    + Benutzer +"')");              
            } 
        }
        catch (/*ClassNotFoundException |*/ SQLException myException )
        {
        }
        finally {
            try {
                if (myConnection != null && !myConnection.isClosed()) {
                    myConnection.close();
                }
            } catch (SQLException myException) {
            }
        }         
    }
    
    
    private void set_valuesIntoTextFields() {        
//        if (!DataSet_Mode.equals("edit")) {
            OldSelection = jTable_dbData.getSelectedRow();
            if(OldSelection != -1) {
                String tempString;

                int myRow = jTable_dbData.convertRowIndexToModel(OldSelection);
                jTextField_key.setText(myTableModel.getValueAt(myRow, 0).toString().trim());

                if (myTableModel.getValueAt(myRow, 1) != null) {
                tempString = myTableModel.getValueAt(myRow, 1).toString();
                jFormattedTextField_Bezeichnung.setText(tempString);
                }
                else {jFormattedTextField_Bezeichnung.setText("");}
                
                if (myTableModel.getValueAt(myRow, 2) != null) {
                tempString = myTableModel.getValueAt(myRow, 2).toString();
                jFormattedTextField_Segment.setText(tempString);
//                jFormattedTextField_Saeulengestell_Bezeichnung.setText(this.get_dependentValueFromDB(tempString));
                }
                else {jFormattedTextField_Segment.setText("");}
                
                if (myTableModel.getValueAt(myRow, 3) != null) {
                tempString = myTableModel.getValueAt(myRow, 3).toString();
                jFormattedTextField_Grundform.setText(tempString);
                }
                else {jFormattedTextField_Grundform.setText("");}
                
                if (myTableModel.getValueAt(myRow, 4) != null) {
                tempString = myTableModel.getValueAt(myRow, 4).toString();
                jFormattedTextField_Schnitt.setText(tempString);
                }
                else {jFormattedTextField_Schnitt.setText("");}
                
                if (myTableModel.getValueAt(myRow, 5) != null) {
                tempString = myTableModel.getValueAt(myRow, 5).toString();
                jFormattedTextField_Stapelung.setText(tempString);
                }
                else {jFormattedTextField_Stapelung.setText("");}
                
                if (myTableModel.getValueAt(myRow, 6) != null) {
                tempString = myTableModel.getValueAt(myRow, 6).toString();
                jFormattedTextField_Stanzblech.setText(tempString);
                }
                else {jFormattedTextField_Stanzblech.setText("");}
                
                if (myTableModel.getValueAt(myRow, 7) != null) {
                tempString = myTableModel.getValueAt(myRow, 7).toString();
                jFormattedTextField_Stanzbrille.setText(tempString);
                }
                else {jFormattedTextField_Stanzbrille.setText("");}
                
                if (myTableModel.getValueAt(myRow, 8) != null) {
                tempString = myTableModel.getValueAt(myRow, 8).toString();
                jFormattedTextField_Vorstempel.setText(tempString);
                }
                else {jFormattedTextField_Vorstempel.setText("");}
                
                if (myTableModel.getValueAt(myRow, 9) != null) {
                tempString = myTableModel.getValueAt(myRow, 9).toString();
                jFormattedTextField_Niederhalterplatte.setText(tempString);
                }
                else {jFormattedTextField_Niederhalterplatte.setText("");}
                
                if (myTableModel.getValueAt(myRow, 10) != null) {
                tempString = myTableModel.getValueAt(myRow, 10).toString();
                jFormattedTextField_Ausbrechstempel.setText(tempString);
                }
                else {jFormattedTextField_Ausbrechstempel.setText("");}
                
                if (myTableModel.getValueAt(myRow, 11) != null) {
                tempString = myTableModel.getValueAt(myRow, 11).toString();
                jFormattedTextField_Lochwerkzeug.setText(tempString);
                }
                else {jFormattedTextField_Lochwerkzeug.setText("");}
                
                if (myTableModel.getValueAt(myRow, 12) != null) {
                tempString = myTableModel.getValueAt(myRow, 12).toString();
                jFormattedTextField_STAL.setText(tempString);
                }
                else {jFormattedTextField_STAL.setText("");}
                
                if (myTableModel.getValueAt(myRow, 13) != null) {
                tempString = myTableModel.getValueAt(myRow, 13).toString();
                jFormattedTextField_Führungskäfig.setText(tempString);
                }
                else {jFormattedTextField_Führungskäfig.setText("");}
                
                if (myTableModel.getValueAt(myRow, 14) != null) {
                tempString = myTableModel.getValueAt(myRow, 14).toString();
                jFormattedTextField_Säulengestell.setText(tempString);
                }
                else {jFormattedTextField_Säulengestell.setText("");}
                
                if (myTableModel.getValueAt(myRow, 15) != null) {
                tempString = myTableModel.getValueAt(myRow, 15).toString();
                jFormattedTextField_Schriftzug.setText(tempString);
                }
                else {jFormattedTextField_Schriftzug.setText("");}
                
                if (myTableModel.getValueAt(myRow, 16) != null) {
                    jTextField_Anlagedatum.setText(myTableModel.getValueAt(myRow, 16).toString().trim());
                }
                else {jTextField_Anlagedatum.setText("");}
                if (myTableModel.getValueAt(myRow, 17) != null) {
                   jTextField_Änderungsdatum.setText(myTableModel.getValueAt(myRow, 17).toString().trim());
                }
                else {jTextField_Änderungsdatum.setText("");}
                if (myTableModel.getValueAt(myRow, 18) != null) {
                    jTextField_Benutzer.setText(myTableModel.getValueAt(myRow, 18).toString().trim()); 
                }
                else {jTextField_Benutzer.setText("");}
                
                
                btn_edit.setEnabled(true);
                btn_duplicate.setEnabled(true);
                btn_delete.setEnabled(true); 
            }
            else {
                btn_edit.setEnabled(false);
                btn_duplicate.setEnabled(false);
                btn_delete.setEnabled(false);
            }  
//        }        
    }
    private void set_tableEnabled(boolean aBoolean) {
        jTextField_searchValue.setEnabled(aBoolean);
        btn_deleteSearchValue.setEnabled(aBoolean);
        btn_getCurrentDBData.setEnabled(aBoolean);
        jTable_dbData.setEnabled(aBoolean);
        for (int i = 0; i < TableColumns; i ++) {
            mySorter.setSortable(i, aBoolean);
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
            java.util.logging.Logger.getLogger(Frame_DataMaintenance_Werkzeugstamm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_DataMaintenance_Werkzeugstamm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_DataMaintenance_Werkzeugstamm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_DataMaintenance_Werkzeugstamm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Frame_DataMaintenance_Werkzeugstamm().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_accept;
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_close;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_deleteSearchValue;
    private javax.swing.JButton btn_delete_Ausbrechstempel;
    private javax.swing.JButton btn_delete_Führungskäfig;
    private javax.swing.JButton btn_delete_Grundform;
    private javax.swing.JButton btn_delete_Lochwerkzeug;
    private javax.swing.JButton btn_delete_Niederhalterplatte;
    private javax.swing.JButton btn_delete_STAL;
    private javax.swing.JButton btn_delete_Schnitt;
    private javax.swing.JButton btn_delete_Schriftzug;
    private javax.swing.JButton btn_delete_Segment;
    private javax.swing.JButton btn_delete_Stanzblech;
    private javax.swing.JButton btn_delete_Stanzbrille;
    private javax.swing.JButton btn_delete_Stapelung;
    private javax.swing.JButton btn_delete_Säulengestell;
    private javax.swing.JButton btn_delete_Vorstempel;
    private javax.swing.JButton btn_duplicate;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_getCurrentDBData;
    private javax.swing.JButton btn_new;
    private javax.swing.JButton btn_openDialog_Ausbrechstempel;
    private javax.swing.JButton btn_openDialog_Führungskäfig;
    private javax.swing.JButton btn_openDialog_Grundform;
    private javax.swing.JButton btn_openDialog_Lochwerkzeug;
    private javax.swing.JButton btn_openDialog_Niederhalterplatte;
    private javax.swing.JButton btn_openDialog_STAL;
    private javax.swing.JButton btn_openDialog_Schnitt;
    private javax.swing.JButton btn_openDialog_Schriftzug;
    private javax.swing.JButton btn_openDialog_Segment;
    private javax.swing.JButton btn_openDialog_Stanzblech;
    private javax.swing.JButton btn_openDialog_Stanzbrille;
    private javax.swing.JButton btn_openDialog_Stapelung;
    private javax.swing.JButton btn_openDialog_Säulengestell;
    private javax.swing.JButton btn_openDialog_Vorstempel;
    private javax.swing.JTextField jFormattedTextField_Ausbrechstempel;
    private javax.swing.JFormattedTextField jFormattedTextField_Bezeichnung;
    private javax.swing.JTextField jFormattedTextField_Führungskäfig;
    private javax.swing.JTextField jFormattedTextField_Grundform;
    private javax.swing.JTextField jFormattedTextField_Lochwerkzeug;
    private javax.swing.JTextField jFormattedTextField_Niederhalterplatte;
    private javax.swing.JTextField jFormattedTextField_STAL;
    private javax.swing.JTextField jFormattedTextField_Schnitt;
    private javax.swing.JTextField jFormattedTextField_Schriftzug;
    private javax.swing.JFormattedTextField jFormattedTextField_Segment;
    private javax.swing.JTextField jFormattedTextField_Stanzblech;
    private javax.swing.JTextField jFormattedTextField_Stanzbrille;
    private javax.swing.JTextField jFormattedTextField_Stapelung;
    private javax.swing.JTextField jFormattedTextField_Säulengestell;
    private javax.swing.JTextField jFormattedTextField_Vorstempel;
    private javax.swing.JLabel jLabel_Ausbrechstempel;
    private javax.swing.JLabel jLabel_Führungskäfig;
    private javax.swing.JLabel jLabel_Grundform;
    private javax.swing.JLabel jLabel_Lochwerkzeug;
    private javax.swing.JLabel jLabel_Niederhalterplatte;
    private javax.swing.JLabel jLabel_STAL;
    private javax.swing.JLabel jLabel_Schnitt;
    private javax.swing.JLabel jLabel_Schriftzug;
    private javax.swing.JLabel jLabel_Stanzblech;
    private javax.swing.JLabel jLabel_Stanzbrille;
    private javax.swing.JLabel jLabel_Stapelung;
    private javax.swing.JLabel jLabel_Säulengestell;
    private javax.swing.JLabel jLabel_Vorstempel;
    private javax.swing.JLabel jLabel_placeholder;
    private javax.swing.JLabel jLabel_placeholder2;
    private javax.swing.JPanel jPanel_base;
    private javax.swing.JPanel jPanel_editData;
    private javax.swing.JPanel jPanel_editLabels;
    private javax.swing.JPanel jPanel_editTextFields;
    private javax.swing.JPanel jPanel_footer;
    private javax.swing.JPanel jPanel_table;
    private javax.swing.JScrollPane jScrollPane_dbData;
    private javax.swing.JScrollPane jScrollPane_editData;
    private javax.swing.JTable jTable_dbData;
    private javax.swing.JTextField jTextField_Anlagedatum;
    private javax.swing.JTextField jTextField_Benutzer;
    private javax.swing.JTextField jTextField_key;
    private javax.swing.JTextField jTextField_searchValue;
    private javax.swing.JTextField jTextField_Änderungsdatum;
    private javax.swing.JLabel lbl_Anlagedatum;
    private javax.swing.JLabel lbl_Benutzer;
    private javax.swing.JLabel lbl_Bezeichnung;
    private javax.swing.JLabel lbl_Segment;
    private javax.swing.JLabel lbl_key;
    private javax.swing.JLabel lbl_rowCount;
    private javax.swing.JLabel lbl_search1;
    private javax.swing.JLabel lbl_tableName;
    private javax.swing.JLabel lbl_Änderungsdatum;
    // End of variables declaration//GEN-END:variables
}
