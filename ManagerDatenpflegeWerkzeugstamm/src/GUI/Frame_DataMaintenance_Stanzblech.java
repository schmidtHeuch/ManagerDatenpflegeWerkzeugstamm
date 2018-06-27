/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DBTools.DB_ConnectionManager;
//import managerdatenpflegewerkzeugstamm.CustomTableCellRenderer;

import java.awt.Point;
import java.awt.MouseInfo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author schmidtu
 */
public class Frame_DataMaintenance_Stanzblech extends javax.swing.JFrame {
    
    /**
     * Creates new form Frame_DataMaintenance_Segment
     */
    public Frame_DataMaintenance_Stanzblech() {
        this.Old_Bezeichnung = "";
        this.Old_Länge = "";
        this.Old_Breite = "";
        this.Old_Materialtyp_ID = "";
        this.DataSet_Mode = "clean";
        initComponents();
        btn_edit.setEnabled(false);
        btn_duplicate.setEnabled(false);
        btn_delete.setEnabled(false);
        btn_accept.setEnabled(false);
        btn_cancel.setEnabled(false);
        }
    
    boolean myAnswerIfConnected;
    Connection myConnection;
    DefaultTableModel myTableModel; 
    TableRowSorter<DefaultTableModel> mySorter;          
    DB_ConnectionManager MY_DBCM;
    String Old_Key;
    String Old_Bezeichnung;
    String Old_Länge;
    String Old_Breite;
    String Old_Materialtyp_ID;
    String Old_Bestand;
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
        lbl_rowCount.setText(String.valueOf(mySorter.getViewRowCount()) + " / " + String.valueOf(myTableModel.getRowCount()));
    }
    
    private void createRowSorter(DefaultTableModel aModel) {
        mySorter = new TableRowSorter<>(aModel);
        jTable_dbData.setRowSorter(mySorter);
    }
    
    public void search() {
        String searchTerm = jTextField_searchValue.getText();
        mySorter.setRowFilter(RowFilter.regexFilter(searchTerm));
    }
    
    private void do_postBuild() {                
        jTable_dbData.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
            set_valuesIntoTextFields();
        });   
        
//        DefaultTableCellRenderer myRenderer = new DefaultTableCellRenderer() {
//        @Override
//        public Component getTableCellRendererComponent(  
//        JTable aTable, Object value, boolean isSelected, boolean hasFocus, int aRow, int aColumn) {
//
////        JLabel label;  
////        if(!(value instanceof JLabel)) {  
////            label = new JLabel((String)value);  
////        } else {  
////           label = (JLabel) value;  
////        }  
//        setOpaque(true);  
//        setFont(aTable.getFont());  
//        setForeground(aTable.getForeground());  
//        setBackground(aTable.getBackground());
//
//        if(isSelected) {  
//            setBackground(aTable.getSelectionBackground());  
//            setForeground(aTable.getSelectionForeground());  
//        }
//        setText(value.toString());
//        int rightRow = aTable.convertRowIndexToModel(aRow);
//        int rightColumn = aTable.convertColumnIndexToModel(aColumn);
//        
//        if (rightColumn == 1 || rightColumn == 2) { 
//            setHorizontalAlignment(SwingConstants.LEFT);
//        }
////        if (rightColumn == 2) { 
////            setHorizontalAlignment(SwingConstants.LEFT);
////        }
//        else { 
//            setHorizontalAlignment(SwingConstants.RIGHT);
//        }
//        return this;  
//        }         
//    };
//        JLabel label = new JLabel();
//        label.setHorizontalAlignment(SwingConstants.LEFT);
//        myRenderer.getTableCellRendererComponent(jTable_dbData, label, true, true,1 ,1 );
//        myRenderer.getTableCellRendererComponent(jTable_dbData, label, true, true,1 ,2 );
//        jTable_dbData.setDefaultRenderer(Object.class, myRenderer);
//        myRenderer.setHorizontalAlignment(SwingConstants.LEFT);
//        jTable_dbData.getColumnModel().getColumn(4).setCellRenderer(myRenderer);
//        jTable_dbData.getColumnModel().getColumn(0).setCellRenderer(myRenderer);
//        jTable_dbData.setDefaultRenderer(Object.class, myRenderer);
//        for (int aColumn = 1; aColumn < myTableModel.getColumnCount(); aColumn++) {
//            myRenderer.getTableCellRendererComponent(jTable_dbData, label, true, true, 1, aColumn);
//            jTable_dbData.setDefaultRenderer(Object.class, myRenderer);
//        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_table = new javax.swing.JPanel();
        jTextField_searchValue = new javax.swing.JTextField();
        btn_deleteSearchValue = new javax.swing.JButton();
        jScrollPane_dbData = new javax.swing.JScrollPane();
        jTable_dbData = new javax.swing.JTable();
        lbl_search1 = new javax.swing.JLabel();
        lbl_rowCount = new javax.swing.JLabel();
        btn_getCurrentDBData = new javax.swing.JButton();
        lbl_tableName = new javax.swing.JLabel();
        jPanel_editData = new javax.swing.JPanel();
        jPanel_editLabels = new javax.swing.JPanel();
        lbl_key = new javax.swing.JLabel();
        lbl_Bezeichnung = new javax.swing.JLabel();
        lbl_Länge = new javax.swing.JLabel();
        lbl_Breite = new javax.swing.JLabel();
        lbl_Materialtyp_ID = new javax.swing.JLabel();
        lbl_Materialtyp_Bezeichnung = new javax.swing.JLabel();
        btn_openDialog_Materialtyp = new javax.swing.JButton();
        btn_delete_Materialtyp = new javax.swing.JButton();
        lbl_Bestand = new javax.swing.JLabel();
        jPanel_editTextFields = new javax.swing.JPanel();
        jTextField_key = new javax.swing.JTextField();
        jFormattedTextField_Bezeichnung = new javax.swing.JFormattedTextField();
        jFormattedTextField_Länge = new javax.swing.JFormattedTextField();
        jFormattedTextField_Breite = new javax.swing.JFormattedTextField();
        jFormattedTextField_Materialtyp_ID = new javax.swing.JFormattedTextField();
        jFormattedTextField_MaterialtypBezeichnung = new javax.swing.JTextField();
        jFormattedTextField_Bestand = new javax.swing.JFormattedTextField();
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
        jPanel_footer = new javax.swing.JPanel();
        btn_close = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jTextField_searchValue.setPreferredSize(new java.awt.Dimension(120, 20));
        jTextField_searchValue.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_searchValueKeyReleased(evt);
            }
        });

        btn_deleteSearchValue.setIcon(new javax.swing.ImageIcon("U:\\Eigene\\schmidtu\\images\\Löschen.png")); // NOI18N
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
                "Stanzblech-ID (Key)", "Stanzblech-Bezeichnung", "Länge", "Breite", "Materialtyp-ID", "Bestand", "Anlagedatum", "Änderungsdatum", "Benutzer"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.Long.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
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
            jTable_dbData.getColumnModel().getColumn(0).setPreferredWidth(120);
            jTable_dbData.getColumnModel().getColumn(1).setPreferredWidth(204);
            jTable_dbData.getColumnModel().getColumn(2).setPreferredWidth(120);
            jTable_dbData.getColumnModel().getColumn(3).setPreferredWidth(120);
            jTable_dbData.getColumnModel().getColumn(4).setPreferredWidth(250);
            jTable_dbData.getColumnModel().getColumn(5).setMinWidth(100);
            jTable_dbData.getColumnModel().getColumn(5).setPreferredWidth(100);
            jTable_dbData.getColumnModel().getColumn(6).setMinWidth(150);
            jTable_dbData.getColumnModel().getColumn(6).setPreferredWidth(150);
            jTable_dbData.getColumnModel().getColumn(7).setMinWidth(150);
            jTable_dbData.getColumnModel().getColumn(7).setPreferredWidth(150);
            jTable_dbData.getColumnModel().getColumn(8).setMinWidth(100);
            jTable_dbData.getColumnModel().getColumn(8).setPreferredWidth(100);
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
        lbl_tableName.setText("Tabelle: Stanzblech");

        javax.swing.GroupLayout jPanel_tableLayout = new javax.swing.GroupLayout(jPanel_table);
        jPanel_table.setLayout(jPanel_tableLayout);
        jPanel_tableLayout.setHorizontalGroup(
            jPanel_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_tableLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane_dbData)
                    .addGroup(jPanel_tableLayout.createSequentialGroup()
                        .addGroup(jPanel_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_tableLayout.createSequentialGroup()
                                .addComponent(jTextField_searchValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_deleteSearchValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_getCurrentDBData))
                            .addComponent(lbl_search1)
                            .addComponent(lbl_tableName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_rowCount, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel_tableLayout.setVerticalGroup(
            jPanel_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_tableLayout.createSequentialGroup()
                .addGroup(jPanel_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_tableLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbl_tableName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addComponent(jScrollPane_dbData, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel_editData.setBorder(javax.swing.BorderFactory.createTitledBorder("Bearbeitung"));

        jPanel_editLabels.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        lbl_key.setText("Stanzblech-ID (Key)");
        lbl_key.setPreferredSize(new java.awt.Dimension(120, 14));
        jPanel_editLabels.add(lbl_key);

        lbl_Bezeichnung.setText("Stanzblech-Bezeichnung");
        lbl_Bezeichnung.setPreferredSize(new java.awt.Dimension(204, 14));
        jPanel_editLabels.add(lbl_Bezeichnung);

        lbl_Länge.setText("Länge");
        lbl_Länge.setPreferredSize(new java.awt.Dimension(120, 14));
        jPanel_editLabels.add(lbl_Länge);

        lbl_Breite.setText("Breite");
        lbl_Breite.setPreferredSize(new java.awt.Dimension(120, 14));
        jPanel_editLabels.add(lbl_Breite);

        lbl_Materialtyp_ID.setText("Materialtyp-ID");
        lbl_Materialtyp_ID.setPreferredSize(new java.awt.Dimension(100, 14));
        jPanel_editLabels.add(lbl_Materialtyp_ID);

        lbl_Materialtyp_Bezeichnung.setText("Bezeichnung");
        lbl_Materialtyp_Bezeichnung.setPreferredSize(new java.awt.Dimension(104, 14));
        jPanel_editLabels.add(lbl_Materialtyp_Bezeichnung);

        btn_openDialog_Materialtyp.setIcon(new javax.swing.ImageIcon("U:\\Eigene\\schmidtu\\images\\Lupe.png")); // NOI18N
        btn_openDialog_Materialtyp.setEnabled(false);
        btn_openDialog_Materialtyp.setPreferredSize(new java.awt.Dimension(23, 23));
        btn_openDialog_Materialtyp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_openDialog_MaterialtypActionPerformed(evt);
            }
        });
        jPanel_editLabels.add(btn_openDialog_Materialtyp);

        btn_delete_Materialtyp.setIcon(new javax.swing.ImageIcon("U:\\Eigene\\schmidtu\\images\\Löschen.png")); // NOI18N
        btn_delete_Materialtyp.setEnabled(false);
        btn_delete_Materialtyp.setPreferredSize(new java.awt.Dimension(23, 23));
        btn_delete_Materialtyp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delete_MaterialtypActionPerformed(evt);
            }
        });
        jPanel_editLabels.add(btn_delete_Materialtyp);

        lbl_Bestand.setText("Bestand");
        lbl_Bestand.setPreferredSize(new java.awt.Dimension(100, 14));
        jPanel_editLabels.add(lbl_Bestand);

        jPanel_editTextFields.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        jTextField_key.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField_key.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextField_key.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jTextField_key.setEnabled(false);
        jTextField_key.setPreferredSize(new java.awt.Dimension(120, 20));
        jPanel_editTextFields.add(jTextField_key);

        jFormattedTextField_Bezeichnung.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jFormattedTextField_Bezeichnung.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jFormattedTextField_Bezeichnung.setEnabled(false);
        jFormattedTextField_Bezeichnung.setPreferredSize(new java.awt.Dimension(204, 20));
        jPanel_editTextFields.add(jFormattedTextField_Bezeichnung);

        jFormattedTextField_Länge.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jFormattedTextField_Länge.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormattedTextField_Länge.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jFormattedTextField_Länge.setEnabled(false);
        jFormattedTextField_Länge.setPreferredSize(new java.awt.Dimension(120, 20));
        jPanel_editTextFields.add(jFormattedTextField_Länge);

        jFormattedTextField_Breite.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jFormattedTextField_Breite.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormattedTextField_Breite.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jFormattedTextField_Breite.setEnabled(false);
        jFormattedTextField_Breite.setPreferredSize(new java.awt.Dimension(120, 20));
        jPanel_editTextFields.add(jFormattedTextField_Breite);

        jFormattedTextField_Materialtyp_ID.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        jFormattedTextField_Materialtyp_ID.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormattedTextField_Materialtyp_ID.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jFormattedTextField_Materialtyp_ID.setEnabled(false);
        jFormattedTextField_Materialtyp_ID.setPreferredSize(new java.awt.Dimension(100, 20));
        jPanel_editTextFields.add(jFormattedTextField_Materialtyp_ID);

        jFormattedTextField_MaterialtypBezeichnung.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormattedTextField_MaterialtypBezeichnung.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jFormattedTextField_MaterialtypBezeichnung.setEnabled(false);
        jFormattedTextField_MaterialtypBezeichnung.setPreferredSize(new java.awt.Dimension(150, 20));
        jPanel_editTextFields.add(jFormattedTextField_MaterialtypBezeichnung);

        jFormattedTextField_Bestand.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        jFormattedTextField_Bestand.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormattedTextField_Bestand.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jFormattedTextField_Bestand.setEnabled(false);
        jFormattedTextField_Bestand.setPreferredSize(new java.awt.Dimension(100, 20));
        jPanel_editTextFields.add(jFormattedTextField_Bestand);

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
        jTextField_Anlagedatum.setPreferredSize(new java.awt.Dimension(204, 20));

        jTextField_Änderungsdatum.setEditable(false);
        jTextField_Änderungsdatum.setBorder(null);
        jTextField_Änderungsdatum.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jTextField_Änderungsdatum.setEnabled(false);
        jTextField_Änderungsdatum.setPreferredSize(new java.awt.Dimension(204, 20));

        jTextField_Benutzer.setEditable(false);
        jTextField_Benutzer.setBorder(null);
        jTextField_Benutzer.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jTextField_Benutzer.setEnabled(false);
        jTextField_Benutzer.setPreferredSize(new java.awt.Dimension(204, 20));

        javax.swing.GroupLayout jPanel_editDataLayout = new javax.swing.GroupLayout(jPanel_editData);
        jPanel_editData.setLayout(jPanel_editDataLayout);
        jPanel_editDataLayout.setHorizontalGroup(
            jPanel_editDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_editLabels, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addGroup(jPanel_editDataLayout.createSequentialGroup()
                        .addComponent(lbl_Anlagedatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField_Anlagedatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_editDataLayout.createSequentialGroup()
                        .addComponent(lbl_Änderungsdatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField_Änderungsdatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_editDataLayout.createSequentialGroup()
                        .addComponent(lbl_Benutzer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField_Benutzer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(216, 216, 216))
            .addComponent(jPanel_editTextFields, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel_editDataLayout.setVerticalGroup(
            jPanel_editDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_editDataLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel_editLabels, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_editTextFields, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_editDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_editDataLayout.createSequentialGroup()
                        .addGroup(jPanel_editDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_new)
                            .addComponent(btn_edit)
                            .addComponent(btn_delete)
                            .addComponent(btn_duplicate))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel_editDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_accept)
                            .addComponent(btn_cancel)))
                    .addGroup(jPanel_editDataLayout.createSequentialGroup()
                        .addGroup(jPanel_editDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_Anlagedatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_Anlagedatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel_editDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_Änderungsdatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_Änderungsdatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel_editDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_Benutzer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_Benutzer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_footerLayout.setVerticalGroup(
            jPanel_footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_footerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_close)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_table, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel_footer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel_editData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel_table, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_editData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_footer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
//            String myTempSQL = "CREATE TABLE #tempSegment FROM DiafBDE.dbo.T_Segment";
            String mySQL = "SELECT * FROM DiafBDE.dbo.T_Stanzblech"; // ORDER BY T_Segment.pKey_KP"; // WHERE tma_abt='Technik'";
            ResultSet myResultSet = myStatement.executeQuery(mySQL);            
            TableColumns = myResultSet.getMetaData().getColumnCount();
            myTableModel = (DefaultTableModel) jTable_dbData.getModel();
            int allOldRows = myTableModel.getRowCount();
            if (allOldRows > 0) {
                myTableModel.setRowCount(0);
            }
            while (myResultSet.next()) {
                  
                String[] myValue = new String[TableColumns + 1];
                SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                for (int i = 1; i <= TableColumns; i++) {
                          
                    String myDataSet = myResultSet.getString(i);
                    if (myDataSet != null && i == 7 || myDataSet != null && i == 8) {
                        Timestamp ts = Timestamp.valueOf(myDataSet);
                        myDataSet = myFormat.format(ts);
                    }
                    myValue[i-1] = myDataSet;
                }
//                          
//                    String myDataSet = myResultSet.getString(i);
////                    System.out.println(myDataSet);
////                    ---------------------
//                    if (myDataSet != null && i == 5) {
//                        if (myDataSet.equals("1")) {
//                            myValue[5] = "hart";
//                        }
//                        if (myDataSet.equals("2")) {
//                            myValue[5] = "weich";
//                        }
//                        else {myValue[5] = "keine Auswahl";}
//                    }
////                    ---------------------
//                    if (myDataSet != null && i == 6 || myDataSet != null && i == 7) {
//                        Timestamp ts = Timestamp.valueOf(myDataSet);
//                        myDataSet = myFormat.format(ts);
//                    }
//                    if (i <= 5){myValue[i-1] = myDataSet;}
//                    else {myValue[i] = myDataSet;}
//                }  
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
            String mySQL = "SELECT * FROM DiafBDE.dbo.T_Materialtyp Where pKey_Materialtyp_ID = '" + aKey + "'";
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
    
    private void btn_deleteSearchValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteSearchValueActionPerformed
        // TODO add your handling code here:
        jTextField_searchValue.setText("");
        search();
        lbl_rowCount.setText(String.valueOf(mySorter.getViewRowCount()) + " / " + String.valueOf(myTableModel.getRowCount()));
    }//GEN-LAST:event_btn_deleteSearchValueActionPerformed

    private void btn_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_closeActionPerformed
        // TODO add your handling code here:
        if (MY_DBCM.isConnnected()) {
            MY_DBCM.setConnection_CLOSED("jdbc:sqlserver://HV-ABAS-SQL;databaseName=DiafBDE;integratedSecurity=true", "DISCONNECT");
        }
        int myReturnValue = test_continueEditing();
            if (myReturnValue != 0 || DataSet_Mode.equals("clean")) {
                this.dispose();
            }
    }//GEN-LAST:event_btn_closeActionPerformed

    private void btn_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newActionPerformed
        // TODO add your handling code here:
        DataSet_Mode = "new";
        set_textFieldsEnabled(true); 
        set_oldValues();
        set_tableEnabled(false);
        set_textFieldsEmpty();
        jTextField_key.setText("B");
        jTextField_key.requestFocus();
        btn_new.setEnabled(false);
        btn_edit.setEnabled(false);
        btn_duplicate.setEnabled(false);
        btn_delete.setEnabled(false);
        btn_accept.setEnabled(true);
        btn_cancel.setEnabled(true);   
        btn_openDialog_Materialtyp.setEnabled(true);
        btn_delete_Materialtyp.setEnabled(true);
    }//GEN-LAST:event_btn_newActionPerformed

    private void set_valuesIntoTextFields() {        
        OldSelection = jTable_dbData.getSelectedRow();
        if(OldSelection != -1) {
            String tempString;
            
            int myRow = jTable_dbData.convertRowIndexToModel(OldSelection);
            
            jTextField_key.setText(myTableModel.getValueAt(myRow, 0).toString().trim());
            
            if (myTableModel.getValueAt(myRow, 1) != null) {
            tempString = myTableModel.getValueAt(myRow, 1).toString();
            jFormattedTextField_Bezeichnung.setValue(tempString);
            }
            else {jFormattedTextField_Bezeichnung.setValue("");}
            
            if (myTableModel.getValueAt(myRow, 2) != null) {
            tempString = myTableModel.getValueAt(myRow, 2).toString();
            jFormattedTextField_Länge.setValue(Float.parseFloat(tempString));
            }
            else {jFormattedTextField_Länge.setValue("");}
            
            if (myTableModel.getValueAt(myRow, 3) != null) {
            tempString = myTableModel.getValueAt(myRow, 3).toString();
            jFormattedTextField_Breite.setValue(Float.parseFloat(tempString));
            }
            else {jFormattedTextField_Breite.setValue("");}
            
            if (myTableModel.getValueAt(myRow, 4) != null) {
            tempString = myTableModel.getValueAt(myRow, 4).toString();
            jFormattedTextField_Materialtyp_ID.setValue(Integer.parseInt(tempString));
            jFormattedTextField_MaterialtypBezeichnung.setText(this.get_dependentValueFromDB(tempString));
            }
            else {jFormattedTextField_Materialtyp_ID.setValue("");}            
            
            if (myTableModel.getValueAt(myRow, 5) != null) {
                jFormattedTextField_Bestand.setText(myTableModel.getValueAt(myRow, 5).toString().trim());
            }
            else {jFormattedTextField_Bestand.setText("");}
            if (myTableModel.getValueAt(myRow, 6) != null) {
                jTextField_Anlagedatum.setText(myTableModel.getValueAt(myRow, 6).toString().trim());
            }
            else {jTextField_Anlagedatum.setText("");}
            if (myTableModel.getValueAt(myRow, 7) != null) {
               jTextField_Änderungsdatum.setText(myTableModel.getValueAt(myRow, 7).toString().trim());
            }
            else {jTextField_Änderungsdatum.setText("");}
            if (myTableModel.getValueAt(myRow, 8) != null) {
                jTextField_Benutzer.setText(myTableModel.getValueAt(myRow, 8).toString().trim()); 
            }
            else {jTextField_Benutzer.setText("");}
            
            btn_edit.setEnabled(true);
            btn_duplicate.setEnabled(true);
            btn_delete.setEnabled(true); 
        }        
    }
    
    private void btn_acceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_acceptActionPerformed
        // TODO add your handling code here:
        if (jTextField_key.getText().isEmpty() || jTextField_key.getText().equals("B")) {
            
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
                        || !Old_Länge.equals(jFormattedTextField_Länge.getText().trim())
                        || !Old_Breite.equals(jFormattedTextField_Breite.getText().trim())
                        || !Old_Materialtyp_ID.equals(jFormattedTextField_Materialtyp_ID.getText().trim())
                        || !Old_Bestand.equals(jFormattedTextField_Bestand.getText().trim())) {
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
            set_textFieldsDisabled();  
            btn_new.setEnabled(true); 
            btn_accept.setEnabled(false);
            btn_cancel.setEnabled(false);   
            btn_openDialog_Materialtyp.setEnabled(false);
            btn_delete_Materialtyp.setEnabled(false);
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
//            }
            set_tableEnabled(true);
            get_DBTableData();
            lbl_rowCount.setText(String.valueOf(mySorter.getViewRowCount()) + " / " + String.valueOf(myTableModel.getRowCount()));      
        }
        DataSet_Mode = "clean";     
    }//GEN-LAST:event_btn_acceptActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        DataSet_Mode = "delete";
        if (DataSet_Mode.equals("delete") && test_isDataSetInDB(jTextField_key.getText().trim()) == true) {
            int myAnswer = JOptionPane.showConfirmDialog(null,
                    "Soll der Datensatz Stanzblech-ID (Key): \n\n >> " + jTextField_key.getText().trim() + " << \n\n wirklich gelöscht werden?",
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
                lbl_rowCount.setText(String.valueOf(mySorter.getViewRowCount()) + " / " + String.valueOf(myTableModel.getRowCount()));       
            }
        }
        DataSet_Mode = "clean";
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        // TODO add your handling code here:
        get_oldValues();   
        set_textFieldsDisabled(); 
        btn_new.setEnabled(true);
        if (!Old_Key.equals("")) {
            btn_edit.setEnabled(true);
            btn_duplicate.setEnabled(true);
            btn_delete.setEnabled(true);
        }
        btn_accept.setEnabled(false);
        btn_cancel.setEnabled(false);    
        btn_openDialog_Materialtyp.setEnabled(false);
        btn_delete_Materialtyp.setEnabled(false);
        set_tableEnabled(true);
        DataSet_Mode = "clean";
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        do_preBuild();
        do_postBuild();
    }//GEN-LAST:event_formWindowOpened

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

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        // TODO add your handling code here:
        DataSet_Mode = "edit";
        set_oldValues();
        set_tableEnabled(false);
        set_textFieldsEnabled(false);
        jFormattedTextField_Bezeichnung.requestFocus();
        btn_new.setEnabled(false);
        btn_edit.setEnabled(false);
        btn_duplicate.setEnabled(false);
        btn_delete.setEnabled(false);
        btn_accept.setEnabled(true);
        btn_cancel.setEnabled(true);  
        btn_openDialog_Materialtyp.setEnabled(true);
        btn_delete_Materialtyp.setEnabled(true);
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_duplicateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_duplicateActionPerformed
        // TODO add your handling code here:
        DataSet_Mode = "duplicate";
        set_oldValues();
        set_tableEnabled(false);
        set_textFieldsEnabled(true);
        jTextField_key.requestFocus();
        btn_new.setEnabled(false);
        btn_edit.setEnabled(false);
        btn_duplicate.setEnabled(false);
        btn_delete.setEnabled(false);
        btn_accept.setEnabled(true);
        btn_cancel.setEnabled(true); 
        btn_openDialog_Materialtyp.setEnabled(true);
        btn_delete_Materialtyp.setEnabled(true);
    }//GEN-LAST:event_btn_duplicateActionPerformed

    private void btn_openDialog_MaterialtypActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_openDialog_MaterialtypActionPerformed
        // TODO add your handling code here:
        Dialog_DataUse_Materialtyp myDialog = new Dialog_DataUse_Materialtyp(this,true);
        myDialog.setTitle("Materialtyp");
        Point location = MouseInfo.getPointerInfo().getLocation();
        myDialog.setLocation(location.x + 20 , location.y - 40);
        myDialog.setVisible(true);
        int resultFromDialog_ID = myDialog.getChoosenMaterialtypID();
        if (resultFromDialog_ID != 0) {
            String resultFromDialog_Descriptiong = myDialog.getChoosenMaterialtypDescription().trim();
            this.jFormattedTextField_Materialtyp_ID.setValue(resultFromDialog_ID);
            this.jFormattedTextField_MaterialtypBezeichnung.setText(resultFromDialog_Descriptiong);
        }
    }//GEN-LAST:event_btn_openDialog_MaterialtypActionPerformed

    private void jTextField_searchValueKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_searchValueKeyReleased
        // TODO add your handling code here:
        search();
        lbl_rowCount.setText(String.valueOf(mySorter.getViewRowCount()) + " / " + String.valueOf(myTableModel.getRowCount()));
    }//GEN-LAST:event_jTextField_searchValueKeyReleased

    private void btn_delete_MaterialtypActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delete_MaterialtypActionPerformed
        // TODO add your handling code here:
        jFormattedTextField_Materialtyp_ID.setText("0"); 
        jFormattedTextField_MaterialtypBezeichnung.setText("");
    }//GEN-LAST:event_btn_delete_MaterialtypActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        int myReturnValue = test_continueEditing();
            if (myReturnValue != 0) {
                this.dispose();
            }
    }//GEN-LAST:event_formWindowClosing

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
        jFormattedTextField_Länge.setText("");
        jFormattedTextField_Breite.setText("");
        jFormattedTextField_Materialtyp_ID.setText(""); 
        jFormattedTextField_MaterialtypBezeichnung.setText("");
        jFormattedTextField_Bestand.setText("");
        jTextField_Anlagedatum.setText("");
        jTextField_Änderungsdatum.setText("");
        jTextField_Benutzer.setText("");
    }
    
    private void set_oldValues() {        
        Old_Key = jTextField_key.getText().trim();
        Old_Bezeichnung = jFormattedTextField_Bezeichnung.getText().trim();
        Old_Länge = jFormattedTextField_Länge.getText().trim();
        Old_Breite = jFormattedTextField_Breite.getText().trim();
        Old_Materialtyp_ID = jFormattedTextField_Materialtyp_ID.getText().trim();
        Old_Bestand = jFormattedTextField_Bestand.getText().trim();
    }
    
    private void get_oldValues() {         
        jTextField_key.setText(Old_Key);
        jFormattedTextField_Bezeichnung.setText(Old_Bezeichnung); 
        jFormattedTextField_Länge.setText(Old_Länge); 
        jFormattedTextField_Breite.setText(Old_Breite); 
        jFormattedTextField_Materialtyp_ID.setText(Old_Materialtyp_ID);
        if (Old_Materialtyp_ID.isEmpty()) {
            jFormattedTextField_MaterialtypBezeichnung.setText("");
        }
        jFormattedTextField_Bestand.setText(Old_Bestand);
    }
    
    private void set_textFieldsEnabled(boolean aBoolean) {        
        jTextField_key.setEnabled(aBoolean);
        jFormattedTextField_Bezeichnung.setEnabled(true); 
        jFormattedTextField_Länge.setEnabled(true); 
        jFormattedTextField_Breite.setEnabled(true);
        jFormattedTextField_Bestand.setEnabled(true);
    }
    
    private void set_textFieldsDisabled() {        
        jTextField_key.setEnabled(false);
        jFormattedTextField_Bezeichnung.setEnabled(false);
        jFormattedTextField_Länge.setEnabled(false); 
        jFormattedTextField_Breite.setEnabled(false);
        jFormattedTextField_Bestand.setEnabled(false);      
    }
    
    private void do_insertDataSet_intoDB() {        
        try
        {
            MY_DBCM.setConnection_CLOSED("jdbc:sqlserver://HV-ABAS-SQL;databaseName=DiafBDE;integratedSecurity=true", "DISCONNECT");
            MY_DBCM = new DB_ConnectionManager("jdbc:sqlserver://HV-ABAS-SQL;databaseName=DiafBDE;integratedSecurity=true", "CONNECT");
            if (MY_DBCM.isConnnected()) 
            {   
            myConnection = MY_DBCM.getConnection();
            SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
            Anlagedatum = new Timestamp(System.currentTimeMillis());
            String result = myFormat.format(Anlagedatum);
            Benutzer = System.getProperty("user.name"); 
            Statement myStatement = myConnection.createStatement();
            myStatement.executeUpdate("INSERT INTO DiafBDE.dbo.T_Stanzblech (pKey_B, Bezeichnung, Länge, Breite, Materialtyp_ID, Bestand, Anlagedatum, Benutzer)" 
                    + "VALUES ('" + jTextField_key.getText().trim() + "', '" 
                    + jFormattedTextField_Bezeichnung.getText().trim() + "', '" 
                    + jFormattedTextField_Länge.getText().trim() + "', '" 
                    + jFormattedTextField_Breite.getText().trim() + "', '" 
                    + jFormattedTextField_Materialtyp_ID.getText().trim() + "', '" 
                    + jFormattedTextField_Bestand.getText().trim() + "', '" 
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
            myStatement.executeUpdate("UPDATE DiafBDE.dbo.T_Stanzblech SET Bezeichnung = '" + jFormattedTextField_Bezeichnung.getText().trim() + 
                    "', Länge = '" + jFormattedTextField_Länge.getText().trim() + 
                    "', Breite = '" + jFormattedTextField_Breite.getText().trim() +
                    "', Materialtyp_ID = '" + jFormattedTextField_Materialtyp_ID.getText().trim() +
                    "', Bestand = '" + jFormattedTextField_Bestand.getText().trim() +
                    "', Änderungsdatum = '" + result +
                    "', Benutzer = '" + Benutzer +
                    "' WHERE pKey_B = '" + jTextField_key.getText() + "'");             
            } 
        }
        catch (/*ClassNotFoundException |*/ SQLException myException ) {
            myException.printStackTrace();
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
    
    private void do_deleteDataSet_inDB() {        
        try
        {
            MY_DBCM.setConnection_CLOSED("jdbc:sqlserver://HV-ABAS-SQL;databaseName=DiafBDE;integratedSecurity=true", "DISCONNECT");
            MY_DBCM = new DB_ConnectionManager("jdbc:sqlserver://HV-ABAS-SQL;databaseName=DiafBDE;integratedSecurity=true", "CONNECT");
            if (MY_DBCM.isConnnected()) 
            { 
            myConnection = MY_DBCM.getConnection();
            Statement myStatement = myConnection.createStatement();
            myStatement.executeUpdate("DELETE FROM DiafBDE.dbo.T_Stanzblech WHERE pKey_B = '" + jTextField_key.getText() + "'");  
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
    private boolean test_isDataSetInDB(String aString) {
        boolean myAnswer = false;
        for (int i = 0; i < jTable_dbData.getRowCount(); ++i ) {
            int myRow = jTable_dbData.convertRowIndexToModel(i);
            if (myTableModel.getValueAt(myRow, 0).toString().trim().equals(aString))
                myAnswer = true;           
        }
        return myAnswer;
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
            java.util.logging.Logger.getLogger(Frame_DataMaintenance_Stanzblech.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_DataMaintenance_Stanzblech.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_DataMaintenance_Stanzblech.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_DataMaintenance_Stanzblech.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Frame_DataMaintenance_Stanzblech().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_accept;
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_close;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_deleteSearchValue;
    private javax.swing.JButton btn_delete_Materialtyp;
    private javax.swing.JButton btn_duplicate;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_getCurrentDBData;
    private javax.swing.JButton btn_new;
    private javax.swing.JButton btn_openDialog_Materialtyp;
    private javax.swing.JFormattedTextField jFormattedTextField_Bestand;
    private javax.swing.JFormattedTextField jFormattedTextField_Bezeichnung;
    private javax.swing.JFormattedTextField jFormattedTextField_Breite;
    private javax.swing.JFormattedTextField jFormattedTextField_Länge;
    private javax.swing.JTextField jFormattedTextField_MaterialtypBezeichnung;
    private javax.swing.JFormattedTextField jFormattedTextField_Materialtyp_ID;
    private javax.swing.JPanel jPanel_editData;
    private javax.swing.JPanel jPanel_editLabels;
    private javax.swing.JPanel jPanel_editTextFields;
    private javax.swing.JPanel jPanel_footer;
    private javax.swing.JPanel jPanel_table;
    private javax.swing.JScrollPane jScrollPane_dbData;
    private javax.swing.JTable jTable_dbData;
    private javax.swing.JTextField jTextField_Anlagedatum;
    private javax.swing.JTextField jTextField_Benutzer;
    private javax.swing.JTextField jTextField_key;
    private javax.swing.JTextField jTextField_searchValue;
    private javax.swing.JTextField jTextField_Änderungsdatum;
    private javax.swing.JLabel lbl_Anlagedatum;
    private javax.swing.JLabel lbl_Benutzer;
    private javax.swing.JLabel lbl_Bestand;
    private javax.swing.JLabel lbl_Bezeichnung;
    private javax.swing.JLabel lbl_Breite;
    private javax.swing.JLabel lbl_Länge;
    private javax.swing.JLabel lbl_Materialtyp_Bezeichnung;
    private javax.swing.JLabel lbl_Materialtyp_ID;
    private javax.swing.JLabel lbl_key;
    private javax.swing.JLabel lbl_rowCount;
    private javax.swing.JLabel lbl_search1;
    private javax.swing.JLabel lbl_tableName;
    private javax.swing.JLabel lbl_Änderungsdatum;
    // End of variables declaration//GEN-END:variables
}
