package com.gazoomobile.mfw.client.view;
import com.gazoomobile.mfw.platform.clientapi.Datasource;
import java.awt.event.ComponentEvent;
import java.awt.Component;
import java.awt.event.ComponentListener;
import java.awt.event.ItemEvent;
import com.gazoomobile.mfw.client.database.Database;
import java.awt.event.ItemListener;
import java.beans.PropertyVetoException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;
import com.gazoomobile.mfw.client.interfaces.IDataSource;
import com.gazoomobile.mfw.platform.clientapi.AssociationColumn;
import com.gazoomobile.mfw.platform.clientapi.Column;
import com.gazoomobile.mfw.platform.clientapi.Table;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.logging.FileHandler;

public class SQLCommandView extends javax.swing.JFrame implements ItemListener, ComponentListener {

    static {
    try {
                // Create an appending file handler
                boolean append = true;
                FileHandler handler = new FileHandler("mfw_client.log",  append);
                // Add to the desired logger
                Logger logger = Logger.getLogger(SQLCommandView.class.getName());
                logger.addHandler(handler);
            } catch (IOException e) { }
    }

    public SQLCommandView(IDataSource listener, Datasource dataSource, Database database) {
        this.sqlCommand = "";
        this.listener = listener;
        this.database = database;
        this.datasource = dataSource;
        setTitle("Query Designer");
        initComponents();
        hideComponent();
        hideRadioButton();
        loadTableList();
        loadDataSourceInfo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel10 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        edit_sqlcommand_table_panel = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tables_list = new javax.swing.JList();
        jPanel4 = new javax.swing.JPanel();
        datasource_label = new javax.swing.JLabel();
        database_label = new javax.swing.JLabel();
        tables = new javax.swing.JLabel();
        tables_panel = new javax.swing.JPanel();
        selection_table_panel = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        condition_container = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        condition = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        outputFieldsList1 = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        operatorWhere = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        outputFieldsList2 = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        value1_bt_criteria = new javax.swing.JTextField();
        andLabel = new javax.swing.JLabel();
        value2_bt_criteria = new javax.swing.JTextField();
        andOP = new javax.swing.JRadioButton();
        orOP = new javax.swing.JRadioButton();
        jPanel20 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton6 = new javax.swing.JButton();

        jMenuItem1.setText("Add Condition");
        jPopupMenu1.add(jMenuItem1);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setText("Sortied Fields");
        jPanel16.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 2, -1, -1));

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setText("Sortied Fields");
        jPanel17.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 2, -1, -1));

        jPanel16.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 170, 19));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tables_list.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tables_list.setFont(new java.awt.Font("Tahoma", 0, 10));
        tables_list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tables_listMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tables_list);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 170, 580));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel4.setFocusable(false);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        datasource_label.setText("DataSource: ");
        jPanel4.add(datasource_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 6, -1, -1));

        database_label.setText("Database: ");
        jPanel4.add(database_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 32, -1, -1));

        tables.setText("Tables: ");
        jPanel4.add(tables, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 60, -1, -1));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 80));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 11, 170, 660));

        tables_panel.setBackground(new java.awt.Color(255, 255, 255));
        tables_panel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout tables_panelLayout = new javax.swing.GroupLayout(tables_panel);
        tables_panel.setLayout(tables_panelLayout);
        tables_panelLayout.setHorizontalGroup(
            tables_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 828, Short.MAX_VALUE)
        );
        tables_panelLayout.setVerticalGroup(
            tables_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 448, Short.MAX_VALUE)
        );

        jPanel1.add(tables_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 11, 840, 460));

        selection_table_panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        selection_table_panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selection_table_panelMouseClicked(evt);
            }
        });

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        condition_container.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        condition_container.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        condition.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        condition.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Table.Attrubute|Value", "Operator", "Table.Attribute|Value"
            }
        ));
        jScrollPane4.setViewportView(condition);

        condition_container.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 560, 140));

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel13.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 80, -1));

        jLabel2.setText("Operator");
        jPanel13.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, -1, -1));

        jLabel3.setText("Table.attribute 1| Value");
        jPanel13.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 6, -1, -1));

        outputFieldsList1.setEditable(true);
        outputFieldsList1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<value>" }));
        outputFieldsList1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                outputFieldsList1ItemStateChanged(evt);
            }
        });
        jPanel13.add(outputFieldsList1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 24, 165, 18));

        jLabel9.setText("Operator");
        jPanel13.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 53, -1, -1));

        operatorWhere.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "=", "<>", ">", "<", ">=", "<=", "~", "~*", "!~", "!~*", "LIKE", "NOT LIKE", "IN", "NOT IN", "BETWEEN", "NOT BETWEEN", "IS NULL", "IS NOT NULL", " ", " ", " " }));
        operatorWhere.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                operatorWhereItemStateChanged(evt);
            }
        });
        jPanel13.add(operatorWhere, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 71, 110, 18));

        jLabel6.setText("Table.attribute 2 | Value");
        jPanel13.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        outputFieldsList2.setEditable(true);
        outputFieldsList2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<value>" }));
        outputFieldsList2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                outputFieldsList2ItemStateChanged(evt);
            }
        });
        outputFieldsList2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                outputFieldsList2KeyPressed(evt);
            }
        });
        jPanel13.add(outputFieldsList2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 117, 165, 18));

        jButton2.setText("Add");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jPanel13.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 115, 60, 20));
        jPanel13.add(value1_bt_criteria, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 116, 50, -1));

        andLabel.setText("AND");
        jPanel13.add(andLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 120, -1, -1));
        jPanel13.add(value2_bt_criteria, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 116, 60, -1));

        andOP.setText("AND");
        andOP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                andOPMouseClicked(evt);
            }
        });
        jPanel13.add(andOP, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, -1, -1));

        orOP.setText("OR");
        orOP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                orOPMouseClicked(evt);
            }
        });
        jPanel13.add(orOP, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, -1, -1));

        condition_container.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 143));

        jPanel5.add(condition_container, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 145));

        selection_table_panel.addTab("Criteria", jPanel5);

        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        jPanel23.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 810, 130));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, 823, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
        );

        selection_table_panel.addTab("DML", jPanel20);

        jPanel1.add(selection_table_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 473, 830, 170));

        jButton6.setText("Done");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 650, -1, -1));

        edit_sqlcommand_table_panel.addTab("Design Query", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(edit_sqlcommand_table_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 1020, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(edit_sqlcommand_table_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void tables_listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tables_listMouseClicked
        String tableSelected = tables_list.getSelectedValue().toString();
        if (!isActiveTable(tableSelected)) {
            Table table = this.database.getTableByName(tableSelected);
            JInternalFrame tableInternaFrame = new JInternalFrame();
            tableInternaFrame.setTitle(tableSelected);
            tableInternaFrame.setBounds(30, 30, 130, 30 + table.getColumns().size()*25);
            tableInternaFrame.setVisible(true);
            tableInternaFrame.getContentPane().setLayout(new BoxLayout(tableInternaFrame.getContentPane(), BoxLayout.Y_AXIS));
            tableInternaFrame.setAlignmentY(Component.TOP_ALIGNMENT);
            try{
//            tableInternaFrame.setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gazoomobile/mfw/client/images/tableInternal.png")));
            } catch (Exception ex){
                Logger.getLogger(SQLCommandView.class.getName()).log(Level.SEVERE, ex.toString());
            }
            
            try {
                tableInternaFrame.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(SQLCommandView.class.getName()).log(Level.SEVERE, ex.toString());
            }
            ArrayList<Column> attributes = (ArrayList<Column>) table.getColumns();
            for (int k = 0; k < attributes.size(); k++) {
                Column attribute = attributes.get(k);
                MyAttributeCheckBox attCheckbox;
                if (attribute instanceof AssociationColumn) {
                    attCheckbox = new MyAttributeCheckBox(attribute.getColumnName() + "(FK)", table);
                } else {
                    attCheckbox = new MyAttributeCheckBox(attribute.getColumnName(), table);
                }
                attCheckbox.addItemListener(this);
                tableInternaFrame.add(attCheckbox);
                tableInternaFrame.revalidate();
                tableInternaFrame.repaint();
            }
            activeDiagramTables.add(tableInternaFrame);
            tables_panel.add(tableInternaFrame);
            tableInternaFrame.addComponentListener(this);
        }
    }//GEN-LAST:event_tables_listMouseClicked

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        
    }//GEN-LAST:event_jButton6MouseClicked

    private void selection_table_panelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selection_table_panelMouseClicked

}//GEN-LAST:event_selection_table_panelMouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        String value1 = outputFieldsList1.getItemAt(outputFieldsList1.getSelectedIndex()).toString();
        String value2 = outputFieldsList2.getItemAt(outputFieldsList2.getSelectedIndex()).toString();
        String opr = operatorWhere.getItemAt(operatorWhere.getSelectedIndex()).toString();
        String OpConcat = " ";
        if(andOP.isSelected())
            OpConcat = "AND";
        else if(orOP.isSelected())
            OpConcat = "OR";
        Vector<String> data = null;
        if (operatorWhere.getItemAt(operatorWhere.getSelectedIndex()).toString().equals("IS NULL") || operatorWhere.getItemAt(operatorWhere.getSelectedIndex()).toString().equals("IS NOT NULL")) {
            if (value1 != null && opr != null && (value1 == null ? "<value>" != null : !value1.equals("<value>"))) {
                DefaultTableModel tableModel = (DefaultTableModel) condition.getModel();
                data = new Vector<String>();
                data.add(value1);
                data.add(opr);
                tableModel.addRow(data);
                condition.setModel(tableModel);
                if(where.size()==0)
                    where.add(value1 + " " + opr);
                else
                    where.add(" " + OpConcat + " " + value1 + " " + opr);
            }
        }
        else if (operatorWhere.getItemAt(operatorWhere.getSelectedIndex()).toString().equals("BETWEEN") || operatorWhere.getItemAt(operatorWhere.getSelectedIndex()).toString().equals("NOT BETWEEN")) {
            if (value1_bt_criteria.getText() != null && value2_bt_criteria.getText() != null && (value1 == null ? "<value>" != null : !value1.equals("<value>"))) {
                String betweenValues = value1_bt_criteria.getText() + " AND " + value2_bt_criteria.getText();
                DefaultTableModel tableModel = (DefaultTableModel) condition.getModel();
                data = new Vector<String>();
                data.add(value1);
                data.add(opr);
                data.add(betweenValues);
                tableModel.addRow(data);
                condition.setModel(tableModel);
                if(where.size() == 0)
                    where.add(value1 + " " + opr + " " + betweenValues);
                else
                    where.add(" " + OpConcat + " " + value1 + " " + opr + " " + betweenValues);
            }
        }
        else if (operatorWhere.getItemAt(operatorWhere.getSelectedIndex()).toString().equals("LIKE") || operatorWhere.getItemAt(operatorWhere.getSelectedIndex()).toString().equals("NOT LIKE")) {
            if(value1 != null && (value1 == null ? "<value>" != null : !value1.equals("<value>"))){
                DefaultTableModel tableModel = (DefaultTableModel) condition.getModel();
                String likeValue = value1_bt_criteria.getText();
                data = new Vector<String>();
                data.add(value1);
                data.add(opr);
                data.add(likeValue);
                tableModel.addRow(data);
                condition.setModel(tableModel);
                if(where.size() == 0)
                    where.add(value1 + " " + opr + " " + likeValue);
                else
                    where.add(" " + OpConcat + " " + value1 + " " + opr + " " + likeValue);
            }
        }
        else if (jLabel6.getText().equals("Value")) {
            if (value1 != null && (value1 == null ? "<value>" != null : !value1.equals("<value>"))) {
                String whereValue = value1_bt_criteria.getText();
                DefaultTableModel tableModel = (DefaultTableModel) condition.getModel();
                data = new Vector<String>();
                data.add(value1);
                data.add(opr);
                data.add(whereValue);
                tableModel.addRow(data);
                condition.setModel(tableModel);
                if (where.size() == 0)
                    where.add(value1 + " " + opr + " " + whereValue);
                else
                    where.add(" " + OpConcat + " " + value1 + " " + opr + " " + whereValue);
                outputFieldsList2.setVisible(true);
                jLabel6.setText("Table.attribute 2 | Value");
                value1_bt_criteria.setVisible(false);

            }
        }
        else {
            if (value1 != null && value2 != null && (value1 == null ? "<value>" != null : !value1.equals("<value>")) && (value2 == null ? "<value>" != null : !value2.equals("<value>"))) {
                DefaultTableModel tableModel = (DefaultTableModel) condition.getModel();
                data = new Vector<String>();
                data.add(value1);
                data.add(opr);
                data.add(value2);
                tableModel.addRow(data);
                condition.setModel(tableModel);
                if(where.size() == 0)
                    where.add(value1 + " " + opr + " " + value1);
                else
                    where.add(" " + OpConcat + " " + value1 + " " + opr + " " + value1);
            }
        }
        if(where.size()>=1){
            andOP.setVisible(true);
            orOP.setVisible(true);
        }
}//GEN-LAST:event_jButton2MouseClicked

    private void outputFieldsList2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_outputFieldsList2KeyPressed

}//GEN-LAST:event_outputFieldsList2KeyPressed

    private void operatorWhereItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_operatorWhereItemStateChanged
        if (operatorWhere.getItemAt(operatorWhere.getSelectedIndex()).toString().equals("IS NULL") || operatorWhere.getItemAt(operatorWhere.getSelectedIndex()).toString().equals("IS NOT NULL")) {
            if (jLabel6.getText().equals("AND"))
                jLabel6.setText("Table.attribute 2 | Value");
            jLabel6.setEnabled(false);
            outputFieldsList2.setVisible(true);
            outputFieldsList2.setEnabled(false);
        }
        else if (operatorWhere.getItemAt(operatorWhere.getSelectedIndex()).toString().equals("BETWEEN") || operatorWhere.getItemAt(operatorWhere.getSelectedIndex()).toString().equals("NOT BETWEEN")) {
            jLabel6.setVisible(false);
            outputFieldsList2.setVisible(false);
            value1_bt_criteria.setVisible(true);
            value2_bt_criteria.setVisible(true);
            andLabel.setVisible(true);
        } 
        else if (operatorWhere.getItemAt(operatorWhere.getSelectedIndex()).toString().equals("LIKE") || operatorWhere.getItemAt(operatorWhere.getSelectedIndex()).toString().equals("NOT LIKE")) {
            jLabel6.setVisible(false);
            outputFieldsList2.setVisible(false);
            value1_bt_criteria.setVisible(true);
            value2_bt_criteria.setVisible(false);
            andLabel.setVisible(false);
        }
        else {
            if (jLabel6.getText().equals("AND"))
                jLabel6.setText("Table.attribute 2 | Value");
            jLabel6.setEnabled(true);
            outputFieldsList2.setVisible(true);
            outputFieldsList2.setEnabled(true);
            hideComponent();
        }
}//GEN-LAST:event_operatorWhereItemStateChanged

    private void outputFieldsList2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_outputFieldsList2ItemStateChanged
        if(outputFieldsList2.getItemAt(outputFieldsList2.getSelectedIndex()).equals("<value>")){
            outputFieldsList2.setVisible(false);
            jLabel6.setText("Value");
            value1_bt_criteria.setVisible(true);
        }
    }//GEN-LAST:event_outputFieldsList2ItemStateChanged

    private void outputFieldsList1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_outputFieldsList1ItemStateChanged
        
    }//GEN-LAST:event_outputFieldsList1ItemStateChanged

    private void andOPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_andOPMouseClicked
        if(andOP.isSelected())
            orOP.setSelected(false);
    }//GEN-LAST:event_andOPMouseClicked

    private void orOPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orOPMouseClicked
        if(orOP.isSelected())
            andOP.setSelected(false);
    }//GEN-LAST:event_orOPMouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        List<String> outputFields = new ArrayList<String>();
        Enumeration<String> attKeys = selectFromHash.keys();
        while (attKeys.hasMoreElements())
            outputFields.add(attKeys.nextElement());
        listener.setDataSource(sqlCommand, outputFields);
        setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    public void itemStateChanged(ItemEvent e) {
        Table tableSelected = ((MyAttributeCheckBox) e.getItem()).getTable();
        Column colSelected = tableSelected.getColumnByName(removePK(((MyAttributeCheckBox) e.getItem()).getText()));
        if (e.getStateChange() == ItemEvent.SELECTED) {
            selectFromHash.put(tableSelected.getName() + "." + colSelected.getColumnName(), tableSelected.getName());
            outputFieldsList1.addItem(tableSelected.getName() + "." + colSelected.getColumnName());
            outputFieldsList2.addItem(tableSelected.getName() + "." + colSelected.getColumnName());
            sqlCommand = selectBlock() + fromBlock() + whereBlock();
            jTextArea1.setText(sqlCommand);
        } else if (e.getStateChange() == ItemEvent.DESELECTED) {
            selectFromHash.remove(tableSelected.getName() + "." + colSelected.getColumnName());
            String itemToDelete = new String(tableSelected.getName() + "." + colSelected.getColumnName());
            outputFieldsList1.removeItem(itemToDelete);
            outputFieldsList2.removeItem(itemToDelete);
            sqlCommand = selectBlock() + fromBlock() + whereBlock();
            jTextArea1.setText(sqlCommand);
        }
    }

    public boolean isActiveTable(String tableName) {
        for (int i = 0; i < activeDiagramTables.size(); i++) {
            if (activeDiagramTables.get(i).getTitle().equals(tableName)) {
                return true;
            }
        }
        return false;
    }

    public void hideComponent() {
        value1_bt_criteria.setVisible(false);
        value2_bt_criteria.setVisible(false);
        andLabel.setVisible(false);
    }

    public void hideRadioButton(){
        orOP.setVisible(false);
        andOP.setVisible(false);
    }

    public JInternalFrame getInternalFrameByName(Vector<JInternalFrame> internalTablesFrames, String name) {
        for (int i = 0; i < internalTablesFrames.size(); i++) {
            if (internalTablesFrames.elementAt(i).getTitle().equals(name)) {
                return internalTablesFrames.elementAt(i);
            }
        }
        return null;
    }

    public void loadTableList() {
        DefaultListModel listModel = new DefaultListModel();
        for (int i = 0; i < this.database.getTables().size(); i++) {
            Table tables = database.getTables().get(i);
            listModel.addElement(tables.getName());
        }
        tables_list.setModel(listModel);
    }

    public void loadDataSourceInfo(){
        datasource_label.setText(datasource_label.getText() + datasource.getName());
        database_label.setText(database_label.getText()+ database.getName());
        tables.setText(tables.getText()+ "["+ database.getTables().size() +"]");
    }

    public String getAttributeByAttributeTable(String attributeTable) {
        String attribute = new String("");
        for (int i = 0; i < attributeTable.length(); i++) {
            if (attributeTable.charAt(i) == '.') {
                for (int j = i + 1; j < attributeTable.length(); j++) {
                    attribute += attributeTable.charAt(j);
                }
            }
        }
        return attribute;
    }

    public String getTableByAttributeTable(String attributeTable) {
        String table = new String("");
        int index = 0;
        while (attributeTable.charAt(index) != '.' && index < attributeTable.length()) {
            table += attributeTable.charAt(index);
            index++;
        }
        return table;
    }

    public boolean isAttributeSelected(String attribute){
        return selectFromHash.contains(attribute);
    }

    public String selectBlock() {
        String query = new String(" ");
        if (selectFromHash.size() > 0) {
            query = new String("SELECT ");
            Enumeration<String> attKeys = selectFromHash.keys();
            while (attKeys.hasMoreElements()) {
                String current = attKeys.nextElement();
                query += current + ", ";
            }
            query = removeComma(query) + " ";
        }
        return query;
    }

    public String fromBlock() {
        String query = new String(" ");
        if (selectFromHash.size() > 0) {
            query = " FROM ";
            Iterator<String> tbValues = selectFromHash.values().iterator();
            ArrayList<String> tempList = new ArrayList<String>();
            while (tbValues.hasNext()) {
                String current = tbValues.next();
                boolean flag = false;
                if (tempList.size() > 0) {
                    for (int i = 0; i < tempList.size(); i++) {
                        if (tempList.get(i).equals(current)) {
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        tempList.add(current);
                    }
                } else {
                    tempList.add(current);
                }
            }
            Iterator<String> tbValues1 = tempList.iterator();
            while (tbValues1.hasNext()) {
                String current = tbValues1.next();
                query += current + ", ";
            }
            query = removeComma(query) + " ";
        }
        return query;
    }

    public String whereBlock() {
        String query = new String(" ");
        if (where.size() > 0) {
            query = " WHERE ";
            Iterator<String> condItr = where.iterator();
            while (condItr.hasNext()) {
                String current = condItr.next();
                query += current;
            }
            return query + " ";
        }
        return query;
    }

    public String removeComma(String data) {
        return data = data.substring(0, data.length() - 2);
    }

    public String removeAND(String data) {
        return data = data.substring(0, data.length() - 4);
    }

    public String removePK(String string) {
        if (string.contains("(FK)"))
            return string.substring(0, string.length() - 4);
        return string;
    }

    public void componentResized(ComponentEvent e) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void componentMoved(ComponentEvent e) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void componentShown(ComponentEvent e) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void componentHidden(ComponentEvent e) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel andLabel;
    private javax.swing.JRadioButton andOP;
    private javax.swing.JTable condition;
    private javax.swing.JPanel condition_container;
    private javax.swing.JLabel database_label;
    private javax.swing.JLabel datasource_label;
    private javax.swing.JTabbedPane edit_sqlcommand_table_panel;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JComboBox operatorWhere;
    private javax.swing.JRadioButton orOP;
    private javax.swing.JComboBox outputFieldsList1;
    private javax.swing.JComboBox outputFieldsList2;
    private javax.swing.JTabbedPane selection_table_panel;
    private javax.swing.JLabel tables;
    private javax.swing.JList tables_list;
    private javax.swing.JPanel tables_panel;
    private javax.swing.JTextField value1_bt_criteria;
    private javax.swing.JTextField value2_bt_criteria;
    // End of variables declaration//GEN-END:variables
    private IDataSource listener;
    private ArrayList<JInternalFrame> activeDiagramTables = new ArrayList<JInternalFrame>();
    private Hashtable<String, String> selectFromHash = new Hashtable<String, String>();
    private ArrayList<String> where = new ArrayList<String>();
    private String sqlCommand;
    private Database database;
    private Datasource datasource;
}
