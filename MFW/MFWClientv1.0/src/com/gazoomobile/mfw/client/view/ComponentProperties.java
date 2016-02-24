package com.gazoomobile.mfw.client.view;

import com.gazoomobile.mfw.client.component.MyOwnComboBox;
import com.gazoomobile.mfw.client.component.MyOwnListBox;
import com.gazoomobile.mfw.client.component.MyOwnTable;
import com.gazoomobile.mfw.client.interfaces.IDataSourceComponent;
import com.gazoomobile.mfw.platform.clientapi.Datasource;
import java.util.ArrayList;
public class ComponentProperties extends javax.swing.JDialog {

    public ComponentProperties(java.awt.Frame parent, boolean modal, IDataSourceComponent componentListener, Datasource datasource) {
        super(parent, modal);
        this.componentListener = componentListener;
        this.datasource = datasource;
        initComponents();
        loadComponentProperties();
    }

    public void loadComponentProperties(){
        if(componentListener instanceof MyOwnComboBox){
            setTitle("ComboBox");
        }
        else if(componentListener instanceof MyOwnListBox){
            setTitle("ListBox");
        }
        else if(componentListener instanceof MyOwnTable){
            setTitle("Table");
        }
        ds_combox.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        item_edit = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        ds_combox = new javax.swing.JComboBox();
        item = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("StringValue: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, -1, -1));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(item_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 22));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jdbc.PNG"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 20, 20));

        ds_combox.setEditable(true);
        ds_combox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ds_comboxKeyPressed(evt);
            }
        });
        jPanel4.add(ds_combox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 22));

        item.setText("[Item1, Item2, ..ItemN]");
        jPanel4.add(item, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 170, 150));

        jLabel4.setText("stringValue");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 10, -1, -1));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 23, 240, 150));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Value");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addContainerGap(132, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addContainerGap(143, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 170, 170));

        jLabel3.setText("Properties");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 6, -1, -1));

        jButton2.setText("Done");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 180, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 240, 210));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        item_edit.setVisible(false);
        if (datasource != null) {
            for (int i = 0; i < datasource.getOutputFields().size(); i++) {
                ds_combox.addItem(datasource.getOutputFields().get(i));
            }
        } else {
            ds_combox.addItem("Select Datasource");
        }
        item.setText("");
        dataType = "dynamic";
        ds_combox.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void ds_comboxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ds_comboxKeyPressed
        ds_combox.setVisible(false);
        item_edit.setVisible(true);
    }//GEN-LAST:event_ds_comboxKeyPressed

    public ArrayList<String> splitItems(){
        String allItems = item_edit.getText();
        if (!allItems.equals("")) {
            ArrayList<String> items = new ArrayList<String>();
            String currentItem = "";
            for (int i = 0; i < allItems.length(); i++) {
                if(allItems.charAt(i) == ','){
                    items.add(currentItem);
                    currentItem = "";
                }
                if(allItems.charAt(i) != ',')
                    currentItem+= allItems.charAt(i);
            }
            if(!currentItem.equals(","))
                items.add(currentItem);
            return items;
        }
        return null;
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (!item_edit.getText().equals("")) {
            if(componentListener instanceof MyOwnComboBox || componentListener instanceof MyOwnListBox)
                componentListener.clearDataSource();
            if (dataType.equals("statics")) {
                ArrayList<String> items = splitItems();
                for (int i = 0; i < items.size(); i++) {
                    componentListener.addDataSource(Integer.toString(i), items.get(i), false);
                }
            }

        } else if (dataType.equals("dynamic")) {
            String dataSourceData = "#" + datasource.getName() + ":" + ds_combox.getItemAt(ds_combox.getSelectedIndex());
            componentListener.addDataSource("1", dataSourceData, true);
        }
        setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ds_combox;
    private javax.swing.JLabel item;
    private javax.swing.JTextField item_edit;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
    private Datasource datasource;
    private IDataSourceComponent componentListener;
    private String dataType = "statics";
}
