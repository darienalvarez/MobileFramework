/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainView.java
 *
 * Created on 30-may-2010, 12:45:40
 */
package com.gazoomobile.mfw.client.view;

import com.gazoomobile.clien.exception.ConnectException;
import com.gazoomobile.mfw.platform.client.ControlProperty;
import com.gazoomobile.mfw.platform.client.Application;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import com.gazoomobile.mfw.client.component.MyOwnButton;
import com.gazoomobile.mfw.client.component.MyOwnComboBox;
import com.gazoomobile.mfw.client.component.MyOwnListBox;
import javax.swing.Box;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.gazoomobile.mfw.client.component.MyOwnCheckBox;
import com.gazoomobile.mfw.client.component.MyOwnHorizontalLayout;
import com.gazoomobile.mfw.client.component.MyOwnLabel;
import com.gazoomobile.mfw.client.component.MyOwnTable;
import com.gazoomobile.mfw.client.component.MyOwnTextBox;
import com.gazoomobile.mfw.client.component.MyOwnTextField;
import com.gazoomobile.mfw.client.component.MyOwnVerticalLayout;
import com.gazoomobile.mfw.client.interfaces.IControl;
import com.gazoomobile.mfw.client.interfaces.IIndexer;
import com.gazoomobile.mfw.platform.client.ApplicationWebService;
import com.gazoomobile.mfw.platform.client.ApplicationWebServiceImpl;
import com.gazoomobile.mfw.platform.client.Control;
import com.gazoomobile.mfw.platform.client.ControlType;
import com.gazoomobile.mfw.platform.client.ControlWebService;
import com.gazoomobile.mfw.platform.client.ControlWebServiceImpl;
import com.gazoomobile.mfw.platform.client.Screen;
import java.net.URI;
import java.rmi.ConnectIOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.border.BevelBorder;

/**
 *
 * @author dbuedo
 */
public class MainView extends javax.swing.JFrame {

//  public String GAZOO_DIR = "http://10.36.19.237:8080/MFW/services/";
    public String GAZOO_DIR = "http://localhost:8080/MFW/services/";
    /** Creates new form MainView */
    public MainView() {
        this.applications = new ArrayList<Application>();
        this.applicationNodes = new Vector<DefaultMutableTreeNode>();
        initComponents();
        hideComponents();
        initApplicationTree();
        activeComponent = "";
        activePanel = null;
        ControlWebService control = null;
        try {
            control = new ControlWebServiceImpl(new URI( GAZOO_DIR + "ControlService?wsdl").toURL()).getControlWebServiceImplPort();
        } catch (Exception ex) {
//            Logger.getLogger(MyOwnButton.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ControlService");
        }
        controlTypes = control.getAllControlTypes();
        ControlType controlType = getControlTypeByName("VLayout");
        String name = "main_screen";
        try {
            main_panel_layout = new MyOwnVerticalLayout(name, 0, this, controlType, new Dimension(0, 0));
        } catch (ConnectException ex) {
            JOptionPane.showMessageDialog(this, "Error connecting to the server");
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }

        main_panel_layout.setSize(main_panel.getWidth(), main_panel.getHeight());
        main_panel.setLayout(null);
        main_panel.add(main_panel_layout);
        main_panel.revalidate();
        main_panel.repaint();
    }

    public void initApplicationTree() {
        applicationTreeNodeRoot = new DefaultMutableTreeNode("Applications");
        applicationTreeModel = new DefaultTreeModel(applicationTreeNodeRoot);
        left_tree.setModel(applicationTreeModel);
        DefaultTreeCellRenderer render = (DefaultTreeCellRenderer) left_tree.getCellRenderer();
        render.setLeafIcon(new ImageIcon("Resources/nodetree.png"));
        render.setOpenIcon(new ImageIcon("Resources/tree_app_icom.PNG"));
        render.setClosedIcon(new ImageIcon("Resources/tree_app_icom.PNG"));
    }

    public void AddAppicationNodeTree(String name) {
        DefaultMutableTreeNode newTreeNode = new DefaultMutableTreeNode(name);
        applicationTreeNodeRoot.add(newTreeNode);
        applicationTreeModel.setRoot(applicationTreeNodeRoot);
        left_tree.setModel(applicationTreeModel);
    }

    public void hideComponents() {
        left_panel.setVisible(false);
        main_panel.setVisible(false);
        rigth_panel.setVisible(false);
    }

    public void showApplicationTree(Application application) {
        if (!left_panel.isVisible()) {
            left_panel.setVisible(true);
            main_panel.setVisible(true);
        }
        if (applicationTreeNodeRoot == null) {
            initApplicationTree();
        }
        AddAppicationNodeTree(application.getName());
    }

    public void addApplication(Application application) {
        applications.add(application);
        showApplicationTree(application);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        left_panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        left_tree = new javax.swing.JTree();
        jPanel3 = new javax.swing.JPanel();
        desciption_label = new javax.swing.JLabel();
        main_panel = new javax.swing.JPanel();
        rigth_panel = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        ButtonButton = new javax.swing.JButton();
        ListButton = new javax.swing.JButton();
        ComboButton = new javax.swing.JButton();
        HLayoutButton = new javax.swing.JButton();
        TextBoxButton = new javax.swing.JButton();
        CheckButton = new javax.swing.JButton();
        EditButton = new javax.swing.JButton();
        VLayoutButton = new javax.swing.JButton();
        LabelButton = new javax.swing.JButton();
        TableButton = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        DescriptionArea = new javax.swing.JTextArea();
        jToolBar1 = new javax.swing.JToolBar();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        jMenuItem1.setText("New Screen");
        jPopupMenu1.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1030, 7420));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setMinimumSize(new java.awt.Dimension(900, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(437, 182, 0, -1));

        left_panel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        left_tree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        left_tree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                left_treeMouseClicked(evt);
            }
        });
        left_tree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                left_treeValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(left_tree);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Application Description"));

        desciption_label.setFont(new java.awt.Font("Tahoma", 0, 10));
        desciption_label.setText("jLabel1");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(desciption_label)
                .addContainerGap(145, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(desciption_label)
                .addContainerGap(127, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout left_panelLayout = new javax.swing.GroupLayout(left_panel);
        left_panel.setLayout(left_panelLayout);
        left_panelLayout.setHorizontalGroup(
            left_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
        );
        left_panelLayout.setVerticalGroup(
            left_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, left_panelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(left_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 620));

        main_panel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        main_panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                main_panelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                main_panelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                main_panelMouseExited(evt);
            }
        });
        main_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(main_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 7, 590, 610));

        rigth_panel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        rigth_panel.setAlignmentX(50.0F);
        rigth_panel.setAlignmentY(50.0F);
        rigth_panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rigth_panelMouseClicked(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setAlignmentX(0.0F);
        jPanel5.setAlignmentY(0.0F);

        ButtonButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gazoomobile/mfw/client/images/boton.png"))); // NOI18N
        ButtonButton.setText("Button");
        ButtonButton.setAlignmentY(0.0F);
        ButtonButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ButtonButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ButtonButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        ButtonButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonButtonActionPerformed(evt);
            }
        });

        ListButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gazoomobile/mfw/client/images/list.png"))); // NOI18N
        ListButton.setText("ListBox");
        ListButton.setAlignmentY(0.0F);
        ListButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ListButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ListButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        ListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListButtonActionPerformed(evt);
            }
        });

        ComboButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gazoomobile/mfw/client/images/combo.png"))); // NOI18N
        ComboButton.setText("ComboBox");
        ComboButton.setAlignmentY(0.0F);
        ComboButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ComboButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ComboButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        ComboButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboButtonActionPerformed(evt);
            }
        });

        HLayoutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gazoomobile/mfw/client/images/hlayout.png"))); // NOI18N
        HLayoutButton.setText("HLayayout");
        HLayoutButton.setAlignmentY(0.0F);
        HLayoutButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        HLayoutButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        HLayoutButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        HLayoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HLayoutButtonActionPerformed(evt);
            }
        });

        TextBoxButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gazoomobile/mfw/client/images/textbox.png"))); // NOI18N
        TextBoxButton.setText("TextBox");
        TextBoxButton.setAlignmentY(0.0F);
        TextBoxButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TextBoxButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TextBoxButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        TextBoxButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextBoxButtonActionPerformed(evt);
            }
        });

        CheckButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gazoomobile/mfw/client/images/checkbox.png"))); // NOI18N
        CheckButton.setText("CheckBox");
        CheckButton.setAlignmentX(1.0F);
        CheckButton.setAlignmentY(0.0F);
        CheckButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CheckButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CheckButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        CheckButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckButtonActionPerformed(evt);
            }
        });

        EditButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gazoomobile/mfw/client/images/edit.png"))); // NOI18N
        EditButton.setText("Edit");
        EditButton.setAlignmentY(0.0F);
        EditButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        EditButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        EditButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        EditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButtonActionPerformed(evt);
            }
        });

        VLayoutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gazoomobile/mfw/client/images/vlayout.png"))); // NOI18N
        VLayoutButton.setText("VLayayout");
        VLayoutButton.setAlignmentY(0.0F);
        VLayoutButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        VLayoutButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        VLayoutButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        VLayoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VLayoutButtonActionPerformed(evt);
            }
        });

        LabelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gazoomobile/mfw/client/images/label.png"))); // NOI18N
        LabelButton.setText("Label");
        LabelButton.setAlignmentY(0.0F);
        LabelButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        LabelButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LabelButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        LabelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LabelButtonActionPerformed(evt);
            }
        });

        TableButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gazoomobile/mfw/client/images/table.png"))); // NOI18N
        TableButton.setText("Table");
        TableButton.setAlignmentY(0.0F);
        TableButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TableButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TableButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        TableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TableButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CheckButton, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                    .addComponent(ComboButton, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                    .addComponent(TextBoxButton, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                    .addComponent(VLayoutButton, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                    .addComponent(LabelButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HLayoutButton, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(TableButton, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(EditButton, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(ListButton, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(ButtonButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ListButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CheckButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextBoxButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VLayoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HLayoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setAlignmentX(0.0F);
        jPanel6.setAlignmentY(0.0F);
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Properties", "Values"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTable1inputChanged(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1onKeyPress(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        DescriptionArea.setColumns(20);
        DescriptionArea.setFont(new java.awt.Font("Monospaced", 0, 11));
        DescriptionArea.setRows(5);
        DescriptionArea.setText("Properties description:");
        jScrollPane3.setViewportView(DescriptionArea);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout rigth_panelLayout = new javax.swing.GroupLayout(rigth_panel);
        rigth_panel.setLayout(rigth_panelLayout);
        rigth_panelLayout.setHorizontalGroup(
            rigth_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        rigth_panelLayout.setVerticalGroup(
            rigth_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rigth_panelLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(rigth_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, 230, 620));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1020, 660));

        jToolBar1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jToolBar1.setRollover(true);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gazoomobile/mfw/client/images/appp.PNG"))); // NOI18N
        jButton4.setToolTipText("New Application");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jToolBar1.add(jButton4);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gazoomobile/mfw/client/images/screen.PNG"))); // NOI18N
        jButton1.setToolTipText("New Screen");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jdbc.PNG"))); // NOI18N
        jButton5.setToolTipText("New DataSourse");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton5);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gazoomobile/mfw/client/images/save.png"))); // NOI18N
        jButton2.setToolTipText("Salvar Pantalla");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setMaximumSize(new java.awt.Dimension(23, 21));
        jButton2.setMinimumSize(new java.awt.Dimension(23, 21));
        jButton2.setPreferredSize(new java.awt.Dimension(23, 21));
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gazoomobile/mfw/client/images/save.png"))); // NOI18N
        jButton3.setToolTipText("Salvar APP");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jToolBar1.add(jButton3);

        getContentPane().add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 35));

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Help");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        ApplicationView application = new ApplicationView(this, true, this);
        application.setVisible(true);
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        DataSourceView dataSource = new DataSourceView(this);
        dataSource.setVisible(true);
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    }//GEN-LAST:event_jButton5ActionPerformed

    private void left_treeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_left_treeMouseClicked
    }//GEN-LAST:event_left_treeMouseClicked

    private void left_treeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_left_treeValueChanged
        selectedNodeLeftTree = (DefaultMutableTreeNode) evt.getNewLeadSelectionPath().getLastPathComponent();
    }//GEN-LAST:event_left_treeValueChanged

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        rigth_panel.setVisible(true);
        main_panel.setSize(590, 620);
        main_panel.setVisible(true);
    }//GEN-LAST:event_jButton1MouseClicked

    private void ButtonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonButtonActionPerformed
        if (activeComponent.equals("Button")) {
            ButtonButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            activeComponent = "";
        } else {
            RaisedAllComponentsBorders();
            ButtonButton.setBorder(null);
            activeComponent = "Button";
        }
    }//GEN-LAST:event_ButtonButtonActionPerformed

    private void ListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListButtonActionPerformed
        if (activeComponent.equals("ListBox")) {
            ListButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            activeComponent = "";
        } else {
            RaisedAllComponentsBorders();
            ListButton.setBorder(null);
            activeComponent = "ListBox";
        }
}//GEN-LAST:event_ListButtonActionPerformed

    private void ComboButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboButtonActionPerformed
        if (activeComponent.equals("ComboBox")) {
            ComboButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            activeComponent = "";
        } else {
            RaisedAllComponentsBorders();
            ComboButton.setBorder(null);
            activeComponent = "ComboBox";
        }
}//GEN-LAST:event_ComboButtonActionPerformed

    private void HLayoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HLayoutButtonActionPerformed
        if (activeComponent.equals("HLayout")) {
            HLayoutButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            activeComponent = "";
        } else {
            RaisedAllComponentsBorders();
            HLayoutButton.setBorder(null);
            activeComponent = "HLayout";
        }
}//GEN-LAST:event_HLayoutButtonActionPerformed

    private void TextBoxButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextBoxButtonActionPerformed
        if (activeComponent.equals("TextBox")) {
            TextBoxButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            activeComponent = "";
        } else {
            RaisedAllComponentsBorders();
            TextBoxButton.setBorder(null);
            activeComponent = "TextBox";
        }
}//GEN-LAST:event_TextBoxButtonActionPerformed

    private void CheckButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckButtonActionPerformed
        if (activeComponent.equals("CheckBox")) {
            CheckButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            activeComponent = "";
        } else {
            RaisedAllComponentsBorders();
            CheckButton.setBorder(null);
            activeComponent = "CheckBox";
        }
}//GEN-LAST:event_CheckButtonActionPerformed

    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButtonActionPerformed
        if (activeComponent.equals("TextField")) {
            EditButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            activeComponent = "";
        } else {
            RaisedAllComponentsBorders();
            EditButton.setBorder(null);
            activeComponent = "TextField";
        }
}//GEN-LAST:event_EditButtonActionPerformed

    private void VLayoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VLayoutButtonActionPerformed
        if (activeComponent.equals("VLayout")) {
            VLayoutButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            activeComponent = "";
        } else {
            RaisedAllComponentsBorders();
            VLayoutButton.setBorder(null);
            activeComponent = "VLayout";
        }
}//GEN-LAST:event_VLayoutButtonActionPerformed

    private void LabelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LabelButtonActionPerformed
        if (activeComponent.equals("Label")) {
            LabelButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            activeComponent = "";
        } else {
            RaisedAllComponentsBorders();
            LabelButton.setBorder(null);
            activeComponent = "Label";
        }
}//GEN-LAST:event_LabelButtonActionPerformed

    private void TableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TableButtonActionPerformed
        if (activeComponent.equals("Table")) {
            TableButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            activeComponent = "";
        } else {
            RaisedAllComponentsBorders();
            TableButton.setBorder(null);
            activeComponent = "Table";
        }
}//GEN-LAST:event_TableButtonActionPerformed

    public void RaisedAllComponentsBorders() {
        activeComponent = "";
        LabelButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        ButtonButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        ComboButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        ListButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        TextBoxButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        EditButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        TableButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        HLayoutButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        VLayoutButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        CheckButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    }

    public void AddComponentToActivePanel() {
        if (activeComponent.equals("")) {
            return;
        } else if (activeComponent.equals("Label")) {
            ControlType controlType = getControlTypeByName("Label");
            String name = "Label" + countForComponentName++;
            MyOwnLabel label = new MyOwnLabel(name, ((IIndexer) activePanel).getIndexCounter(), "Label", this, controlType);
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            activePanel.add(label);
            activePanel.add(Box.createRigidArea(new Dimension(5, 5)));
            activePanel.getLayout().layoutContainer(activePanel);
            activePanel.repaint();
        } else if (activeComponent.equals("Button")) {
            ControlType controlType = getControlTypeByName("Button");
            String name = "Button" + countForComponentName++;
            //TODO: Poner owner
            MyOwnButton button = new MyOwnButton(name, ((IIndexer) activePanel).getIndexCounter(), "Button", this, controlType);
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            activePanel.add(button);
            activePanel.add(Box.createRigidArea(new Dimension(5, 5)));
            activePanel.getLayout().layoutContainer(activePanel);
            activePanel.repaint();
        } else if (activeComponent.equals("ComboBox")) {
            ControlType controlType = getControlTypeByName("ComboBox");
            String name = "ComboBox" + countForComponentName++;
            MyOwnComboBox comboBox = new MyOwnComboBox(name, ((IIndexer) activePanel).getIndexCounter(), this, controlType);
            comboBox.setAlignmentX(Component.CENTER_ALIGNMENT);
            activePanel.add(comboBox);
            activePanel.add(Box.createRigidArea(new Dimension(5, 5)));
            activePanel.getLayout().layoutContainer(activePanel);
            activePanel.repaint();
        } else if (activeComponent.equals("CheckBox")) {
            ControlType controlType = getControlTypeByName("CheckBox");
            String name = "CheckBox" + countForComponentName++;
            MyOwnCheckBox checkBox = new MyOwnCheckBox(name, ((IIndexer) activePanel).getIndexCounter(), "CheckBox", this, controlType);
            checkBox.setAlignmentX(Component.CENTER_ALIGNMENT);
            activePanel.add(checkBox);
            activePanel.add(Box.createRigidArea(new Dimension(5, 5)));
            activePanel.getLayout().layoutContainer(activePanel);
            activePanel.repaint();
        } else if (activeComponent.equals("ListBox")) {
            ControlType controlType = getControlTypeByName("ListBox");
            String name = "ListBox" + countForComponentName++;
            MyOwnListBox listBox = new MyOwnListBox(name, ((IIndexer) activePanel).getIndexCounter(), this, controlType);
            listBox.setAlignmentX(Component.CENTER_ALIGNMENT);
            activePanel.add(listBox);
            activePanel.add(Box.createRigidArea(new Dimension(5, 5)));
            activePanel.getLayout().layoutContainer(activePanel);
            activePanel.repaint();
        } else if (activeComponent.equals("TextField")) {
            ControlType controlType = getControlTypeByName("TextField");
            String name = "TextField" + countForComponentName++;
            MyOwnTextField textField = new MyOwnTextField(name, ((IIndexer) activePanel).getIndexCounter(), this, controlType);
            textField.setAlignmentX(Component.CENTER_ALIGNMENT);
            activePanel.add(textField);
            activePanel.add(Box.createRigidArea(new Dimension(5, 5)));
            activePanel.getLayout().layoutContainer(activePanel);
            activePanel.repaint();
        } else if (activeComponent.equals("TextBox")) {
            ControlType controlType = getControlTypeByName("TextBox");
            String name = "TextBox" + countForComponentName++;
            MyOwnTextBox textBox = new MyOwnTextBox(name, ((IIndexer) activePanel).getIndexCounter(), this, controlType);
            textBox.setAlignmentX(Component.CENTER_ALIGNMENT);
            activePanel.add(textBox);
            activePanel.add(Box.createRigidArea(new Dimension(5, 5)));
            activePanel.getLayout().layoutContainer(activePanel);
            activePanel.repaint();
        } else if (activeComponent.equals("Table")) {
            ControlType controlType = getControlTypeByName("Table");
            String name = "Table" + countForComponentName++;
            String titles[] = {"Title 1", "Title 2", "Title 3"};
            MyOwnTable table = new MyOwnTable(name, ((IIndexer) activePanel).getIndexCounter(), titles, this, controlType);
            table.setAlignmentX(Component.CENTER_ALIGNMENT);
            activePanel.add(table);
            activePanel.add(Box.createRigidArea(new Dimension(5, 5)));
            activePanel.getLayout().layoutContainer(activePanel);
            activePanel.repaint();
        } else if (activeComponent.equals("HLayout")) {
            ControlType controlType = getControlTypeByName("HLayout");
            String name = "HLayout" + countForComponentName++;
            MyOwnHorizontalLayout layout = new MyOwnHorizontalLayout(name, ((IIndexer) activePanel).getIndexCounter(), this, controlType, new Dimension(5, 10));
            activePanel.add(layout);
            activePanel.add(Box.createRigidArea(new Dimension(5, 5)));
            activePanel.revalidate();
            activePanel.repaint();
        } else if (activeComponent.equals("VLayout")) {
            ControlType controlType = getControlTypeByName("VLayout");
            String name = "VLayout" + countForComponentName++;
            MyOwnVerticalLayout layout = null;
            try {
                layout = new MyOwnVerticalLayout(name, ((IIndexer) activePanel).getIndexCounter(), this, controlType, new Dimension(5, 10));
            } catch (ConnectException ex) {
                JOptionPane.showMessageDialog(this, "Error connecting to the server");
                Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
            }
            activePanel.add(layout);
            activePanel.add(Box.createRigidArea(new Dimension(5, 5)));
            activePanel.revalidate();
            activePanel.repaint();
        }
    }

    private void jTable1inputChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTable1inputChanged
}//GEN-LAST:event_jTable1inputChanged

    private void jTable1onKeyPress(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1onKeyPress
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JOptionPane.showMessageDialog(this, "Modifying value");
//            String newValue = jTable1.getModel().getValueAt(jTable1.getSelectedRow(), jTable1.getSelectedColumn()).toString();
            String newValue = "Mierdaaa";
//            newValue = jTable1.get
            System.out.print(newValue);
            selectedComponent.modifyControlPropetieValue(jTable1.getSelectedRow(), newValue);
            main_panel.repaint();
        }
}//GEN-LAST:event_jTable1onKeyPress

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        // TODO add your handling code here:
}//GEN-LAST:event_jPanel6MouseClicked

    private void rigth_panelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rigth_panelMouseClicked
        // TODO add your handling code here:
}//GEN-LAST:event_rigth_panelMouseClicked

    private void main_panelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_main_panelMouseClicked
        AddComponentToActivePanel();
    }//GEN-LAST:event_main_panelMouseClicked

    private void main_panelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_main_panelMouseEntered
        onJPanelMouseEntered(evt);
    }//GEN-LAST:event_main_panelMouseEntered

    private void main_panelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_main_panelMouseExited
        onJPanelMouseExited(evt);
    }//GEN-LAST:event_main_panelMouseExited

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        //TODO quitar esto
        currentScreen = new Screen();
        currentScreen.setDescription("Description Screen");
        currentScreen.setName("Name Screen");
        controls = new ArrayList<Control>();
        createComponentTree(main_panel_layout);
        currentScreen.setControls(controls);
        screens = new Vector<Screen>();
        screens.add(currentScreen);
    }//GEN-LAST:event_jButton2MouseClicked

    private void createComponentTree(JComponent root) {
        Component[] children = root.getComponents();
        for (Component comp : children) {
            if (comp instanceof IControl) {
                createComponentTree((JComponent) comp);
                IControl cComp = (IControl) comp;
                Control control = cComp.getControl();

                control.setParentControl(((IControl) root).getControl());
                controls.add(control);
            }
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        app = new Application();
        app.setDescription("Descripcion de la APP");
        app.setName("APP Original");
        app.setScreens(screens);
        app.setUsers(null);

        ApplicationWebService applicationWebService = null;
        try {
            applicationWebService = new ApplicationWebServiceImpl(new URI(GAZOO_DIR + "ApplicationService?wsdl").toURL()).getApplicationWebServiceImplPort();
        } catch (Exception ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ApplicationService");
        }
        applicationWebService.createOrUpdateApplication(app);
    }//GEN-LAST:event_jButton3MouseClicked
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MainView().setVisible(true);
            }
        });
    }
    
    public void addPropertiesToContainer(List<ControlProperty> properties, List<String> propertiesValues, IControl component) {
        selectedComponent = component;
        if (!activeComponent.equals("")) {
            return;
        }
        String[][] values = new String[properties.size()][2];
        for (int i = 0; i < properties.size(); i++) {
            values[i][0] = properties.get(i).getName();
            values[i][1] = propertiesValues.get(i);
        }
        DefaultTableModel dtm = new DefaultTableModel(values, new String[]{"Properties", "Values"}) {

            boolean[] canEdit = new boolean[]{
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        jTable1.setModel(dtm);
    }

    public void OnComponentDelete(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            JPanel owner = (JPanel) evt.getComponent().getParent();
            owner.remove((Component) selectedComponent);
            owner.revalidate();
            owner.repaint();
        }
    }

    public void onJPanelMouseEntered(java.awt.event.MouseEvent evt) {
        if (!activeComponent.equals("")) {
            ((JPanel) evt.getSource()).setBorder(BorderFactory.createLineBorder(Color.BLUE));
            activePanel = (JPanel) evt.getSource();
            activePanel.repaint();
        }
    }

    public void onJPanelMouseExited(java.awt.event.MouseEvent evt) {
        ((JPanel) evt.getSource()).setBorder(BorderFactory.createEtchedBorder());
        activePanel = null;
    }

    private ControlType getControlTypeByName(String name) {
        for (ControlType controlType : controlTypes) {
            if (controlType.getType().equals(name)) {
                return controlType;
            }
        }
        return null;
    }

    public void addChildSelectedNode(String childName) {
        DefaultMutableTreeNode newTreeNode = new DefaultMutableTreeNode(childName);
        if (selectedNodeLeftTree != null) {
            ((DefaultTreeModel) left_tree.getModel()).insertNodeInto(newTreeNode, selectedNodeLeftTree, selectedNodeLeftTree.getIndex(newTreeNode) + 1);
            left_tree.repaint();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonButton;
    private javax.swing.JButton CheckButton;
    private javax.swing.JButton ComboButton;
    private javax.swing.JTextArea DescriptionArea;
    private javax.swing.JButton EditButton;
    private javax.swing.JButton HLayoutButton;
    private javax.swing.JButton LabelButton;
    private javax.swing.JButton ListButton;
    private javax.swing.JButton TableButton;
    private javax.swing.JButton TextBoxButton;
    private javax.swing.JButton VLayoutButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel desciption_label;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel left_panel;
    private javax.swing.JTree left_tree;
    private javax.swing.JPanel main_panel;
    private javax.swing.JPanel rigth_panel;
    // End of variables declaration//GEN-END:variables
    private DefaultTreeModel applicationTreeModel;
    private DefaultTreeModel hostTreeModel;
    private DefaultMutableTreeNode applicationTreeNodeRoot;
    private DefaultMutableTreeNode selectedNodeLeftTree;
    private Vector<DefaultMutableTreeNode> applicationNodes;
    private ArrayList<Application> applications;
    private JPanel activePanel;
    private String activeComponent;
    private List<ControlType> controlTypes;
    private int countForComponentName = 0;
    private IControl selectedComponent;
    private MyOwnVerticalLayout main_panel_layout;
    private Screen currentScreen;
    private List<Control> controls;
    private IControl rootControl;
    private Application app;
    private List<Screen> screens;
    
}
