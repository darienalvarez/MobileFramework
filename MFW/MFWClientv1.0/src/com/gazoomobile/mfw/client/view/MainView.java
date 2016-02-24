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
import com.gazoomobile.mfw.client.exception.ConnectException;
import com.gazoomobile.mfw.platform.clientapi.ControlProperty;
import com.gazoomobile.mfw.platform.clientapi.Application;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.io.IOException;
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
import com.gazoomobile.mfw.client.component.MyOwnLinkButton;
import com.gazoomobile.mfw.client.component.MyOwnComboBox;
import com.gazoomobile.mfw.client.component.MyOwnListBox;
import javax.swing.Box;
import javax.swing.table.DefaultTableModel;
import com.gazoomobile.mfw.client.component.MyOwnCheckBox;
import com.gazoomobile.mfw.client.component.MyOwnHorizontalLayout;
import com.gazoomobile.mfw.client.component.MyOwnLabel;
import com.gazoomobile.mfw.client.component.MyOwnTable;
import com.gazoomobile.mfw.client.component.MyOwnTextBox;
import com.gazoomobile.mfw.client.component.MyOwnEdit;
import com.gazoomobile.mfw.client.component.MyOwnVerticalLayout;
import com.gazoomobile.mfw.client.core.MainPanelForScreenClass;
import com.gazoomobile.mfw.client.core.ControlUidAndControlIDRelation;
import com.gazoomobile.mfw.client.core.ControlUIDpropertiIDAnddefinitioIDRelation;
import com.gazoomobile.mfw.client.interfaces.IControl;
import com.gazoomobile.mfw.client.interfaces.IDataSourceComponent;
import com.gazoomobile.mfw.client.interfaces.IIndexer;
import com.gazoomobile.mfw.client.interfaces.IOptionControl;
import com.gazoomobile.mfw.platform.clientapi.ApplicationWebService;
import com.gazoomobile.mfw.platform.clientapi.ApplicationWebServiceImpl;
import com.gazoomobile.mfw.platform.clientapi.ConnectorType;
import com.gazoomobile.mfw.platform.clientapi.ConnectorWebService;
import com.gazoomobile.mfw.platform.clientapi.ConnectorWebServiceImpl;
import com.gazoomobile.mfw.platform.clientapi.Control;
import com.gazoomobile.mfw.platform.clientapi.ControlDefinition;
import com.gazoomobile.mfw.platform.clientapi.ControlType;
import com.gazoomobile.mfw.platform.clientapi.ControlWebService;
import com.gazoomobile.mfw.platform.clientapi.ControlWebServiceImpl;
import com.gazoomobile.mfw.platform.clientapi.Datasource;
import com.gazoomobile.mfw.platform.clientapi.Screen;
import java.io.FileInputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.border.BevelBorder;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public class MainView extends javax.swing.JFrame {

//  public String GAZOO_DIR = "http://10.5.5.171:8080/MFW/services/";
//    public static String GAZOO_DIR = "http://localhost:8080/MFW/services/";
//        public static String GAZOO_DIR = "http://s15343194.onlinehome-server.com/mfw/services/";
//      public static String GAZOO_DIR = "http://10.8.127.6:8080/MFW/services/";
//    public static String GAZOO_DIR = "http://192.168.0.12:8080/MFW/services/";
    public static String SERVER_URL ;
    static {
    try {
                // Create an appending file handler
                boolean append = true;
                FileHandler handler = new FileHandler("mfw_client.log",  append);
                // Add to the desired logger
                Logger logger = Logger.getLogger(MainView.class.getName());
                logger.addHandler(handler);
            } catch (IOException e) { }
    }

    public MainView() {
        this.applications = new ArrayList<Application>();
        this.applicationNodes = new Vector<DefaultMutableTreeNode>();
        initComponents();
        hideComponents();
        initApplicationTree();
        controlsUidAndIdRelation = new ArrayList<ControlUidAndControlIDRelation>();
        controlsUidPropertieIdAndDefinitionRelation = new ArrayList<ControlUIDpropertiIDAnddefinitioIDRelation>();
        java.util.Properties p = new java.util.Properties();
        try {
                p.load(new FileInputStream("config.properties"));
            } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Unable to find properties file", "File error", JOptionPane.ERROR_MESSAGE);
            
                // Logger.getLogger("global");
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, ex.toString());
        }
        SERVER_URL = p.getProperty("server.url");


        activeComponent = "";
        activePanel = null;
        ControlWebService control = null;
        try {
            control = new ControlWebServiceImpl(new URI(SERVER_URL + "ControlService?wsdl").toURL()).getControlWebServiceImplPort();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Unable to Connect to the server", "Connection error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(MyOwnLinkButton.class.getName()).log(Level.SEVERE, ex.toString());
        }
       
        controlTypes = control.getAllControlTypes();
        mainPanels = new ArrayList<MainPanelForScreenClass>();
    }

    public List<ControlType> getAllControlTypes() {
        return controlTypes;
    }

    public void initApplicationTree() {
        applicationTreeNodeRoot = new DefaultMutableTreeNode("Applications");
        applicationTreeModel = new DefaultTreeModel(applicationTreeNodeRoot);
        left_tree.setModel(applicationTreeModel);
        DefaultTreeCellRenderer render = (DefaultTreeCellRenderer) left_tree.getCellRenderer();
        render.setLeafIcon(new ImageIcon("Resources/test.png"));
        render.setOpenIcon(new ImageIcon("Resources/tree_app_icom.png"));
        render.setClosedIcon(new ImageIcon("Resources/tree_app_icom.png"));
    }

    public void AddAppicationNode(String name) {
        DefaultMutableTreeNode newTreeNode = new DefaultMutableTreeNode("app:" + name);
        applicationNodes.add(newTreeNode);
        applicationTreeNodeRoot.add(newTreeNode);
        applicationTreeModel.setRoot(applicationTreeNodeRoot);
        left_tree.setModel(applicationTreeModel);
    }

    //TODO:  Detectar el index del nodo screen en el arbol
    public void SelectScreenOnLeftTree(String screenToShow){
        for(int i = 0; i< applicationNodes.size(); i++){
            String app = applicationNodes.get(i).toString();
            app = app.substring(4);
            if(app.equals(applicationSelected.getName())){
                DefaultMutableTreeNode appTree = applicationNodes.get(i);
                int indexOfApp = applicationTreeNodeRoot.getIndex(appTree);
                int chieldCount = appTree.getChildCount();
                for (int j = 0; j < chieldCount; j++) {
                    TreeNode node = appTree.getChildAt(j);
                    String screen = node.toString().substring(4);
                    if(screen.equals(screenToShow)){
                        int indexofChield = appTree.getIndex(node) + indexOfApp;
                        left_tree.setSelectionRow(indexofChield);
                        left_tree.repaint();
                        return;
                    }
                }
            }
        }
    }

    public void AddScreenNode(String name) {
        DefaultMutableTreeNode newTreeNode = new DefaultMutableTreeNode("scr:" + name);
        if (selectedNodeLeftTree != null) {
            ((DefaultTreeModel)left_tree.getModel()).insertNodeInto(newTreeNode, selectedNodeLeftTree, selectedNodeLeftTree.getIndex(newTreeNode)+ 1);
            left_tree.repaint();
        }
    }

    public void AddDataSourceNode(Datasource datasource) {
        String name = datasource.getName();
        DefaultMutableTreeNode newTreeNode = new DefaultMutableTreeNode("dts:" + name);
        for(int i = 0; i< datasource.getOutputFields().size(); i++){
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(datasource.getOutputFields().get(i));
            newTreeNode.add(node);
        }
        if (selectedNodeLeftTree != null) {
            ((DefaultTreeModel)left_tree.getModel()).insertNodeInto(newTreeNode, selectedNodeLeftTree, selectedNodeLeftTree.getIndex(newTreeNode)+ 1);
            left_tree.repaint();
        }
        datasourceSelected = datasource;
    }

    public void hideComponents() {
        left_panel.setVisible(false);
        design_screen.setVisible(false);
        screen_tb.setVisible(false);
        saveScreenBtn.setVisible(false);
        rigth_panel.setVisible(false);
    }

    public void showApplicationTree(Application application) {
        if (!left_panel.isVisible()) {
            left_panel.setVisible(true);
        }
        if (applicationTreeNodeRoot == null) {
            initApplicationTree();
        }
        AddAppicationNode(application.getName());
    }

    public void addApplication(Application application){
        applications.add(application);
        applicationSelected = application;
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
        jMenuItem2 = new javax.swing.JMenuItem();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        left_panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        left_tree = new javax.swing.JTree();
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
        jSeparator1 = new javax.swing.JSeparator();
        screen_tb = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        saveScreenBtn = new javax.swing.JButton();
        design_screen = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        app_toolbtn = new javax.swing.JButton();
        screen_toolbtn = new javax.swing.JButton();
        ds_toolbtn = new javax.swing.JButton();
        save_toolbtn = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        jMenuItem1.setText("New Screen");
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setText("Component Properties");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        jPopupMenu3.setToolTipText("Save");
        jPopupMenu3.setLabel("Save");

        jMenuItem3.setText("Save");
        jPopupMenu3.add(jMenuItem3);

        jMenuItem4.setText("Edit");
        jPopupMenu3.add(jMenuItem4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mobile Framework");
        setMinimumSize(new java.awt.Dimension(1030, 7420));
        setResizable(false);
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
            .addGap(0, 0, Short.MAX_VALUE)
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

        javax.swing.GroupLayout left_panelLayout = new javax.swing.GroupLayout(left_panel);
        left_panel.setLayout(left_panelLayout);
        left_panelLayout.setHorizontalGroup(
            left_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
        );
        left_panelLayout.setVerticalGroup(
            left_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
        );

        jPanel1.add(left_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 620));

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
        ButtonButton.setText("Link Button");
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
        TableButton.setEnabled(false);
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
                    .addComponent(CheckButton, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(ComboButton, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(TextBoxButton, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(VLayoutButton, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(LabelButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HLayoutButton, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(TableButton, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(EditButton, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(ListButton, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(ButtonButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
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
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
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
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 630, -1, -1));

        screen_tb.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        screen_tb.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Pruebaaaaaaaaa(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        saveScreenBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/save_1.PNG"))); // NOI18N
        saveScreenBtn.setText("Save");
        saveScreenBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveScreenBtnMouseClicked(evt);
            }
        });
        saveScreenBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveScreenBtnActionPerformed(evt);
            }
        });
        jPanel3.add(saveScreenBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(488, 555, 80, -1));

        design_screen.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        design_screen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                design_screenMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                design_screenMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                design_screenMouseExited(evt);
            }
        });
        design_screen.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(design_screen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 575, 550));

        screen_tb.addTab("Screen1", jPanel3);

        jPanel1.add(screen_tb, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 590, 620));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1020, 650));

        jToolBar1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jToolBar1.setRollover(true);

        app_toolbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nueva_app.PNG"))); // NOI18N
        app_toolbtn.setToolTipText("New Application");
        app_toolbtn.setFocusable(false);
        app_toolbtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        app_toolbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                app_toolbtnActionPerformed(evt);
            }
        });
        jToolBar1.add(app_toolbtn);

        screen_toolbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gazoomobile/mfw/client/images/screen.PNG"))); // NOI18N
        screen_toolbtn.setToolTipText("New Screen");
        screen_toolbtn.setEnabled(false);
        screen_toolbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                screen_toolbtnActionPerformed(evt);
            }
        });
        jToolBar1.add(screen_toolbtn);

        ds_toolbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jdbc.PNG"))); // NOI18N
        ds_toolbtn.setToolTipText("New DataSourse");
        ds_toolbtn.setEnabled(false);
        ds_toolbtn.setFocusable(false);
        ds_toolbtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ds_toolbtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ds_toolbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ds_toolbtnActionPerformed(evt);
            }
        });
        jToolBar1.add(ds_toolbtn);

        save_toolbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gazoomobile/mfw/client/images/save_1.PNG"))); // NOI18N
        save_toolbtn.setToolTipText("Salvar APP");
        save_toolbtn.setEnabled(false);
        save_toolbtn.setFocusable(false);
        save_toolbtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        save_toolbtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        save_toolbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_toolbtnActionPerformed(evt);
            }
        });
        jToolBar1.add(save_toolbtn);

        getContentPane().add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 35));

        jMenuBar1.setEnabled(false);

        jMenu1.setText("File");
        jMenu1.setEnabled(false);
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenu2.setEnabled(false);
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Help");
        jMenu3.setEnabled(false);
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void checkBarToolButtonState(String nodeType){
        if(nodeType.equals("app")){
            app_toolbtn.setEnabled(false);
            screen_toolbtn.setEnabled(true);
            ds_toolbtn.setEnabled(false);
            save_toolbtn.setEnabled(true);
        }
        else if(nodeType.equals("scr")){
            app_toolbtn.setEnabled(false);
            screen_toolbtn.setEnabled(false);
            ds_toolbtn.setEnabled(true);
            save_toolbtn.setEnabled(true);
        }
        else if(nodeType.equals("dts")){
            app_toolbtn.setEnabled(false);
            screen_toolbtn.setEnabled(false);
            ds_toolbtn.setEnabled(false);
            save_toolbtn.setEnabled(true);
        }
        else if(selectedNodeLeftTree.toString().equals("Applications")){
            app_toolbtn.setEnabled(true);
            screen_toolbtn.setEnabled(false);
            ds_toolbtn.setEnabled(false);
            save_toolbtn.setEnabled(false);
        }
    }

    private void ds_toolbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ds_toolbtnActionPerformed
        if (ds_toolbtn.isEnabled()) {
            ConnectorWebService connector = null;
            try {
                connector = new ConnectorWebServiceImpl(new URI(SERVER_URL + "ConnectorService?wsdl").toURL()).getConnectorWebServiceImplPort();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Unable to Connect to the server", "Connection error", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(MyOwnLinkButton.class.getName()).log(Level.SEVERE, ex.toString());
            }
            List<ConnectorType> types = connector.getAllConectorTypes();

            DataSourceSelectionView view = new DataSourceSelectionView(this, types);
            view.setVisible(true);
        }
    }//GEN-LAST:event_ds_toolbtnActionPerformed

    private void left_treeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_left_treeMouseClicked
try{
        selectedNodeLeftTree = (DefaultMutableTreeNode)left_tree.getSelectionPath().getLastPathComponent();
//        selectedNodeLeftTree = (DefaultMutableTreeNode) evt.getNewLeadSelectionPath().getLastPathComponent();
        String selectedNodeLeftTreeStr = selectedNodeLeftTree.toString();
        String nodeSelectedType = getNodeSelectedType();
        if(nodeSelectedType.equals("app")){
            applicationSelected = getApplicationByName(selectedNodeLeftTreeStr.substring(4, selectedNodeLeftTreeStr.length()));
        }
        else if(nodeSelectedType.equals("scr")){
            String screenName = selectedNodeLeftTreeStr.substring(4, selectedNodeLeftTreeStr.length());
            Screen sc = getScreenByName(screenName);
            if( sc != null)
                screenSelectedOnJtree = getScreenByName(selectedNodeLeftTreeStr.substring(4, selectedNodeLeftTreeStr.length()));
        }
        else if(nodeSelectedType.equals("dts")){
            datasourceSelected = getDataSourceByName(selectedNodeLeftTreeStr.substring(4, selectedNodeLeftTreeStr.length()));
        }
        checkBarToolButtonState(nodeSelectedType);
}catch (Exception ex){
    System.out.println(ex.getMessage());
}
    }//GEN-LAST:event_left_treeMouseClicked

    private void left_treeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_left_treeValueChanged
        TreePath tp =  evt.getPath();
        selectedNodeLeftTree =  (DefaultMutableTreeNode)tp.getLastPathComponent();
        String selectedNodeLeftTreeStr = selectedNodeLeftTree.toString();
        String nodeSelectedType = getNodeSelectedType();
        if(nodeSelectedType.equals("app")){
            applicationSelected = getApplicationByName(selectedNodeLeftTreeStr.substring(4, selectedNodeLeftTreeStr.length()));
        }
        else if(nodeSelectedType.equals("scr")){
            if(getScreenByName(selectedNodeLeftTreeStr.substring(4, selectedNodeLeftTreeStr.length())) != null)
                screenSelectedOnJtree = getScreenByName(selectedNodeLeftTreeStr.substring(4, selectedNodeLeftTreeStr.length()));
        }
        else if(nodeSelectedType.equals("dts")){
            datasourceSelected = getDataSourceByName(selectedNodeLeftTreeStr.substring(4, selectedNodeLeftTreeStr.length()));
        }
        checkBarToolButtonState(nodeSelectedType);
    }//GEN-LAST:event_left_treeValueChanged

    private void ButtonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonButtonActionPerformed
        if (activeComponent.equals("linkbutton")) {
            ButtonButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            activeComponent = "";
        } else {
            RaisedAllComponentsBorders();
            ButtonButton.setBorder(null);
            activeComponent = "linkbutton";
        }
    }//GEN-LAST:event_ButtonButtonActionPerformed

    private void ListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListButtonActionPerformed
        if (activeComponent.equals("listbox")) {
            ListButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            activeComponent = "";
        } else {
            RaisedAllComponentsBorders();
            ListButton.setBorder(null);
            activeComponent = "listbox";
        }
}//GEN-LAST:event_ListButtonActionPerformed

    private void ComboButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboButtonActionPerformed
        if (activeComponent.equals("combobox")) {
            ComboButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            activeComponent = "";
        } else {
            RaisedAllComponentsBorders();
            ComboButton.setBorder(null);
            activeComponent = "combobox";
        }
}//GEN-LAST:event_ComboButtonActionPerformed

    private void HLayoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HLayoutButtonActionPerformed
        if (activeComponent.equals("horizontallayout")) {
            HLayoutButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            activeComponent = "";
        } else {
            RaisedAllComponentsBorders();
            HLayoutButton.setBorder(null);
            activeComponent = "horizontallayout";
        }
}//GEN-LAST:event_HLayoutButtonActionPerformed

    private void TextBoxButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextBoxButtonActionPerformed
        if (activeComponent.equals("textbox")) {
            TextBoxButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            activeComponent = "";
        } else {
            RaisedAllComponentsBorders();
            TextBoxButton.setBorder(null);
            activeComponent = "textbox";
        }
}//GEN-LAST:event_TextBoxButtonActionPerformed

    private void CheckButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckButtonActionPerformed
        if (activeComponent.equals("checkbox")) {
            CheckButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            activeComponent = "";
        } else {
            RaisedAllComponentsBorders();
            CheckButton.setBorder(null);
            activeComponent = "checkbox";
        }
}//GEN-LAST:event_CheckButtonActionPerformed

    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButtonActionPerformed
        if (activeComponent.equals("edit")) {
            EditButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            activeComponent = "";
        } else {
            RaisedAllComponentsBorders();
            EditButton.setBorder(null);
            activeComponent = "edit";
        }
}//GEN-LAST:event_EditButtonActionPerformed

    private void VLayoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VLayoutButtonActionPerformed
        if (activeComponent.equals("verticallayout")) {
            VLayoutButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            activeComponent = "";
        } else {
            RaisedAllComponentsBorders();
            VLayoutButton.setBorder(null);
            activeComponent = "verticallayout";
        }
}//GEN-LAST:event_VLayoutButtonActionPerformed

    private void LabelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LabelButtonActionPerformed
        if (activeComponent.equals("label")) {
            LabelButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            activeComponent = "";
        } else {
            RaisedAllComponentsBorders();
            LabelButton.setBorder(null);
            activeComponent = "label";
        }
}//GEN-LAST:event_LabelButtonActionPerformed

    private void TableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TableButtonActionPerformed
        if (activeComponent.equals("table")) {
            TableButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            activeComponent = "";
        } else {
            RaisedAllComponentsBorders();
            TableButton.setBorder(null);
            activeComponent = "table";
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
        } else if (activeComponent.equals("label")) {
            controlType = getControlTypeByName("label");
            String name = "label" + countForComponentName++;
            MyOwnLabel label = new MyOwnLabel(name, ((IIndexer) activePanel).getIndexCounter(),  this, controlType);
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            activePanel.add(label);
            activePanel.add(Box.createRigidArea(new Dimension(5, 5)));
            activePanel.getLayout().layoutContainer(activePanel);
            activePanel.repaint();
        } else if (activeComponent.equals("linkbutton")) {
            controlType = getControlTypeByName("linkbutton");
            String name = "linkbutton" + countForComponentName++;
            MyOwnLinkButton button = new MyOwnLinkButton(name, ((IIndexer) activePanel).getIndexCounter(),  this, controlType);
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            activePanel.add(button);
            activePanel.add(Box.createRigidArea(new Dimension(5, 5)));
            activePanel.getLayout().layoutContainer(activePanel);
            activePanel.repaint();
        } else if (activeComponent.equals("combobox")) {
            controlType = getControlTypeByName("combobox");
            String name = "combobox" + countForComponentName++;
            MyOwnComboBox comboBox = new MyOwnComboBox(name, ((IIndexer) activePanel).getIndexCounter(), this, controlType);
            comboBox.setAlignmentX(Component.CENTER_ALIGNMENT);
            activePanel.add(comboBox);
            activePanel.add(Box.createRigidArea(new Dimension(5, 5)));
            activePanel.getLayout().layoutContainer(activePanel);
            activePanel.repaint();
        } else if (activeComponent.equals("checkbox")) {
            controlType = getControlTypeByName("checkbox");
            String name = "checkbox" + countForComponentName++;
            MyOwnCheckBox checkBox = new MyOwnCheckBox(name, ((IIndexer) activePanel).getIndexCounter(),  this, controlType);
            checkBox.setAlignmentX(Component.CENTER_ALIGNMENT);
            activePanel.add(checkBox);
            activePanel.add(Box.createRigidArea(new Dimension(5, 5)));
            activePanel.getLayout().layoutContainer(activePanel);
            activePanel.repaint();
        } else if (activeComponent.equals("listbox")) {
            controlType = getControlTypeByName("listbox");
            String name = "listbox" + countForComponentName++;
            MyOwnListBox listBox = new MyOwnListBox(name, ((IIndexer) activePanel).getIndexCounter(), this, controlType);
            listBox.setAlignmentX(Component.CENTER_ALIGNMENT);
            activePanel.add(listBox);
            activePanel.add(Box.createRigidArea(new Dimension(5, 5)));
            activePanel.getLayout().layoutContainer(activePanel);
            activePanel.repaint();
        } else if (activeComponent.equals("edit")) {
            controlType = getControlTypeByName("edit");
            String name = "edit" + countForComponentName++;
            MyOwnEdit textField = new MyOwnEdit(name, ((IIndexer) activePanel).getIndexCounter(), this, controlType);
            textField.setAlignmentX(Component.CENTER_ALIGNMENT);
            activePanel.add(textField);
            activePanel.add(Box.createRigidArea(new Dimension(5, 5)));
            activePanel.getLayout().layoutContainer(activePanel);
            activePanel.repaint();
        } else if (activeComponent.equals("textbox")) {
            controlType = getControlTypeByName("textbox");
            String name = "textbox" + countForComponentName++;
            MyOwnTextBox textBox = new MyOwnTextBox(name, ((IIndexer) activePanel).getIndexCounter(), this, controlType);
            textBox.setAlignmentX(Component.CENTER_ALIGNMENT);
            activePanel.add(textBox);
            activePanel.add(Box.createRigidArea(new Dimension(5, 5)));
            activePanel.getLayout().layoutContainer(activePanel);
            activePanel.repaint();
        } else if (activeComponent.equals("table")) {
            controlType = getControlTypeByName("table");
            String name = "table" + countForComponentName++;
            MyOwnTable table = new MyOwnTable(name, ((IIndexer) activePanel).getIndexCounter(), 3, this, controlType);
            table.setAlignmentX(Component.CENTER_ALIGNMENT);
            activePanel.add(table);
            activePanel.add(Box.createRigidArea(new Dimension(5, 5)));
            activePanel.getLayout().layoutContainer(activePanel);
            activePanel.repaint();
        } else if (activeComponent.equals("horizontallayout")) {
            controlType = getControlTypeByName("horizontallayout");
            String name = "horizontallayout" + countForComponentName++;
            MyOwnHorizontalLayout layout = null;
            try {
                layout = new MyOwnHorizontalLayout(name, ((IIndexer) activePanel).getIndexCounter(), this, controlType, new Dimension(5, 10));
            } catch (ConnectException ex) {
                Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, ex.toString());
            }
            activePanel.add(layout);
            activePanel.add(Box.createRigidArea(new Dimension(5, 5)));
            activePanel.revalidate();
            activePanel.repaint();
        } else if (activeComponent.equals("verticallayout")) {
            controlType = getControlTypeByName("verticallayout");
            String name = "verticallayout" + countForComponentName++;
            MyOwnVerticalLayout layout = null;
            try {
                layout = new MyOwnVerticalLayout(name, ((IIndexer) activePanel).getIndexCounter(), this, controlType, new Dimension(5, 10));
            } catch (ConnectException ex) {
                Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, ex.toString());
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
        String propertie = jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 0).toString();
        if(selectedComponent instanceof IDataSourceComponent && propertie.equals("stringvalue")){
            ComponentProperties componentProperties = new ComponentProperties(this, rootPaneCheckingEnabled, (IDataSourceComponent) selectedComponent, datasourceSelected);
            componentProperties.setVisible(true);
        }
        else if(selectedComponent instanceof MyOwnLinkButton && propertie.equals("ref")){
            List<Screen> screens = applicationSelected.getScreens();
            for (int i = 0; i < screens.size(); i++) {
                if(screens.get(i).getIdScreen().equals(currentScreen.getIdScreen()));{
                    screens.remove(i);
                    break;
                }
            }
            SelectScreenForLinkButton screenForLinkButton = new SelectScreenForLinkButton((MyOwnLinkButton)selectedComponent, screens);
            screenForLinkButton.setVisible(true);
        }

        {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                String newValue = jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 1).toString();
                selectedComponent.modifyControlPropetieValue(propertie, newValue);
            }
        }
}//GEN-LAST:event_jTable1onKeyPress

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        // TODO add your handling code here:
}//GEN-LAST:event_jPanel6MouseClicked

    private void rigth_panelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rigth_panelMouseClicked
        // TODO add your handling code here:
}//GEN-LAST:event_rigth_panelMouseClicked

    private void screen_toolbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_screen_toolbtnActionPerformed
        if (screen_toolbtn.isEnabled()) {
            ScreenView screenView = new ScreenView(this, rootPaneCheckingEnabled, this);
            screenView.setVisible(true);
        }
    }//GEN-LAST:event_screen_toolbtnActionPerformed

    public void saveScreen(Screen screen){
        List<Screen> screens =  applicationSelected.getScreens();
        if(screens == null){
            screens = new ArrayList<Screen>();
        }
        boolean screenFound = false;
        for (int i = 0; i < screens.size(); i++) {
            Screen screen1 = screens.get(i);
            if(screen1.getName().equals(screen.getName())){
                screens.set(i, screen);
                screenFound = true;
            }
        }
        if(!screenFound)
            screens.add(screen);
        applicationSelected.setScreens(screens);
        ApplicationWebService applicationWebService = null;
            try {
                try {
                    applicationWebService = new ApplicationWebServiceImpl(new URI(SERVER_URL + "ApplicationService?wsdl").toURL()).getApplicationWebServiceImplPort();
                } catch (MalformedURLException ex) {
                    Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, ex.toString());
                }
            } catch (URISyntaxException ex) {
                Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, ex.toString());
          }
        applicationSelected = applicationWebService.createOrUpdateApplication(applicationSelected);
        List<Screen> screens1 = applicationSelected.getScreens();
        for (Screen screen1 : screens1) {
            List<Control> controls1 = screen1.getControls();
            for (Control control : controls1) {
                setControlIDByUid(control.getUid(), control.getIdControl());
                //seteando ID a los definitions
                List<ControlDefinition> definitions = control.getControlDefinitions();
                for (ControlDefinition definition : definitions) {
                    setDefinitionIDByControlUIDAndPropertieID(definition.getControlProperty().getIdProperty(), control.getUid(), definition.getId());
                }
            }
        }
        updateAPPOnApplications(applicationSelected);
    }

    public void addScreen(final Screen screen){
        currentScreen = screen;
//        screenSelectedOnJtree = screen;
        rigth_panel.setVisible(true);
        saveScreenBtn.setVisible(true);
        design_screen.setSize(590, 590);
        design_screen.setVisible(true);
        screen_tb.setVisible(true);
        if (tabCount == 0) {
            screen_tb.setTitleAt(0, screen.getName());
            tabCount = 1;
            String name = "main_screen";
            controlType = getControlTypeByName("verticallayout");
            try {
                main_panel_layout = new MyOwnVerticalLayout(name, 0, this, controlType, new Dimension(0, 0));
            } catch (ConnectException ex) {
                Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, ex.toString());
            }
            main_panel_layout.setSize(design_screen.getWidth(), design_screen.getHeight());
            design_screen.setLayout(null);
            design_screen.add(main_panel_layout);
            design_screen.revalidate();
            design_screen.repaint();
            MainPanelForScreenClass mpfsc = new MainPanelForScreenClass(screen.getName(), main_panel_layout);
            mainPanels.add(mpfsc);
            applicationSelected.getScreens().add(screen);
            updateAPPOnApplications(applicationSelected);
        } else {
            JPanel backPanel = new JPanel();
            backPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
            backPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
            // creating layout

            JPanel design_screen1 = new javax.swing.JPanel();

            design_screen1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
            design_screen1.addMouseListener(new java.awt.event.MouseAdapter() {

                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    design_screenMouseClicked(evt);
                }

                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    design_screenMouseEntered(evt);
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    design_screenMouseExited(evt);
                }
            });
            design_screen1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
            backPanel.add(design_screen1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 575, 550));

            controlType = getControlTypeByName("verticallayout"); 
            MyOwnVerticalLayout main_panel_layout1 = null;
            String name = "main_screen1";
            try {
                main_panel_layout1 = new MyOwnVerticalLayout(name, 0, this, controlType, new Dimension(0, 0));
            } catch (ConnectException ex) {
                Logger.getLogger(MainView.class.getName()).log(Level.SEVERE,ex.toString());
            }
            main_panel_layout1.setSize(575, 550);
            design_screen1.setLayout(null);
            design_screen1.add(main_panel_layout1);
            design_screen1.revalidate();
            design_screen1.repaint();

            // done
            JButton save = new JButton();
            save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/save_1.PNG"))); // NOI18N
            save.setText("Save");
            save.addMouseListener(new java.awt.event.MouseAdapter() {

                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    saveScreenBtnMouseClicked(evt);
                }
            });
            save.addActionListener(new java.awt.event.ActionListener() {

                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    saveScreenBtnActionPerformed(evt);
                }
            });
            backPanel.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(488, 555, 80, -1));

            backPanel.add(design_screen1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 575, 550));
            backPanel.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(488, 555, 80, -1));
            screen_tb.addTab(screen.getName(), backPanel);
            screen_tb.validate();
            MainPanelForScreenClass mpfsc = new MainPanelForScreenClass(screen.getName(), main_panel_layout1);
            mainPanels.add(mpfsc);
            applicationSelected.getScreens().add(screen);
            updateAPPOnApplications(applicationSelected);
        }
        AddScreenNode(screen.getName());
    }

    public MyOwnVerticalLayout getSuperLayoutByScreenName(String screenName){
        for (int i = 0; i < mainPanels.size(); i++) {
            if(mainPanels.get(i).getScreenName().equals(screenName))
                return mainPanels.get(i).getSuperLayout();
        }
        return null;
    }

    public Screen getScreenByName(String name) {
        if(applicationSelected== null)
            return null;
        List<Screen> screens = applicationSelected.getScreens();
        for (int i = 0; i < screens.size(); i++) {
            if (screens.get(i).getName().equals(name)) {
                return screens.get(i);
            }
        }
        return null;
    }

    public Datasource getDataSourceByName(String name){
        List<Datasource> datasources = currentScreen.getDatasources();
        for (int i = 0; i < datasources.size(); i++) {
            if(datasources.get(i).getName().equals(name)){
                return datasources.get(i);
            }
        }
        return null;
    }

    public String getNodeSelectedType(){
        String nodeSelected = selectedNodeLeftTree.toString();
        String type = nodeSelected.substring(0, 3);
        if(type.equals("app"))
            return "app";
        else if(type.equals("scr"))
            return "scr";
        else if(type.equals("dts"))
            return "dts";
        return "invalid";
    }

    public Application getApplicationByName(String name){
        for (int i = 0; i < applications.size(); i++) {
            if(applications.get(i).getName().equals(name))
                return applications.get(i);
        }
        return null;
    }

    private void createComponentTree(JComponent root) {
        Component[] children = root.getComponents();
        for (Component comp : children) {
            if (comp instanceof IControl) {
                createComponentTree((JComponent) comp);
                IControl cComp = (IControl) comp;
                Control control = cComp.getControl();

                control.setParentControl(((IControl) root).getControl());
                controls.add(control);

                if (comp instanceof IOptionControl) {
                    List<Control> options = ((IOptionControl) comp).getControlOptions();
                    for (Control control1 : options) {
                        controls.add(control1);
                    }
                }
            }
        }
    }

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void saveScreenBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveScreenBtnActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_saveScreenBtnActionPerformed

    private void saveScreenBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveScreenBtnMouseClicked
//        currentScreen = screenSelectedOnJtree;
        controls = new ArrayList<Control>();
        MyOwnVerticalLayout layout = getSuperLayoutByScreenName(currentScreen.getName());
        createComponentTree(layout);
        Control root = layout.getControl();
        root.setParentControl(null);
        controls.add(root);
        for (Control control : controls) {
            control.setIdControl(getControlIDByUid(control.getUid()));
            List<ControlDefinition> definitions = control.getControlDefinitions();
            for(ControlDefinition definition: definitions){
                definition.setId(getDefinitionIDByControlUIDAndPropertieID(definition.getControlProperty().getIdProperty(), control.getUid()));
            }
        }
        currentScreen.setControls(controls);
        saveScreen(currentScreen);
}//GEN-LAST:event_saveScreenBtnMouseClicked
    private Long getControlIDByUid(Long uid){
         for (ControlUidAndControlIDRelation iDRelation : controlsUidAndIdRelation) {
                if(iDRelation.getControlUid().equals(uid)){
                    return iDRelation.getControlID();
                }
        }
         return null;
    }

     private Long getDefinitionIDByControlUIDAndPropertieID(Long propetieID,  Long uid){
         for (ControlUIDpropertiIDAnddefinitioIDRelation iDRelation : controlsUidPropertieIdAndDefinitionRelation) {
                if(iDRelation.getControlUid().equals(uid) && iDRelation.getPropertieID().equals(propetieID)){
                    return iDRelation.getDefinitionID();
                }
        }
         return null;
    }


    private void design_screenMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_design_screenMouseExited
        onJPanelMouseExited(evt);
}//GEN-LAST:event_design_screenMouseExited

    private void design_screenMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_design_screenMouseEntered
        onJPanelMouseEntered(evt);
}//GEN-LAST:event_design_screenMouseEntered

    private void design_screenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_design_screenMouseClicked
        AddComponentToActivePanel();
}//GEN-LAST:event_design_screenMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        String propertie = jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 0).toString();
        if(selectedComponent instanceof IDataSourceComponent && propertie.equals("stringvalue")){
            ComponentProperties componentProperties = new ComponentProperties(this, rootPaneCheckingEnabled, (IDataSourceComponent) selectedComponent, datasourceSelected);
            componentProperties.setVisible(true);
        } else if(selectedComponent instanceof MyOwnLinkButton && propertie.equals("ref")){
//            currentScreen = screenSelectedOnJtree;
            List<Screen> screens = applicationSelected.getScreens();
//            for (int i = 0; i < screens.size(); i++) {
//                if(screens.get(i).getIdScreen()==currentScreen.getIdScreen()){
//                    screens.remove(i);
//                    break;
//                }
//            }
            SelectScreenForLinkButton screenForLinkButton = new SelectScreenForLinkButton((MyOwnLinkButton)selectedComponent, screens);
            screenForLinkButton.setVisible(true);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void save_toolbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_toolbtnActionPerformed
        if (save_toolbtn.isEnabled()) {
            ApplicationWebService applicationWebService = null;
            try {
                try {
                    applicationWebService = new ApplicationWebServiceImpl(new URI(SERVER_URL + "ApplicationService?wsdl").toURL()).getApplicationWebServiceImplPort();
                } catch (MalformedURLException ex) {
                    Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, ex.toString());
                }
            } catch (URISyntaxException ex) {
                Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, ex.toString());
            }
          applicationSelected  = applicationWebService.createOrUpdateApplication(applicationSelected);
            List<Screen> screens = applicationSelected.getScreens();
            for (Screen screen : screens) {
                List<Control> controls = screen.getControls();
                for (Control control : controls) {
                    setControlIDByUid(control.getUid(), control.getIdControl());
                    //seteando ID a los definitions
                    List<ControlDefinition> definitions = control.getControlDefinitions();
                    for (ControlDefinition definition : definitions) {
                        setDefinitionIDByControlUIDAndPropertieID(definition.getControlProperty().getIdProperty(), control.getUid(),definition.getId());
                    }
                }
            }
           updateAPPOnApplications(applicationSelected);
        }
        currentScreen = getScreenByName(currentScreen.getName());
    }//GEN-LAST:event_save_toolbtnActionPerformed

    private void updateAPPOnApplications(Application app){
         for(int i=0; i<applications.size();i++){
                if(applications.get(i).getName().equals(app.getName()))
                    applications.set(i, app);
            }
    }
    private void setControlIDByUid(Long uid, Long id){
        for (ControlUidAndControlIDRelation iDRelation : controlsUidAndIdRelation) {
                if(iDRelation.getControlUid().equals(uid)){
                    iDRelation.setControlID(id);
                    return;
                }
        }
    }

    private Long setDefinitionIDByControlUIDAndPropertieID(Long propetieID,  Long uid, Long defID){
         for (ControlUIDpropertiIDAnddefinitioIDRelation iDRelation : controlsUidPropertieIdAndDefinitionRelation) {
                if(iDRelation.getControlUid().equals(uid) && iDRelation.getPropertieID().equals(propetieID)){
                    iDRelation.setDefinitionID(defID);
                }
        }
         return null;
    }

    private void app_toolbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_app_toolbtnActionPerformed
        ApplicationView application = new ApplicationView(this, true, this);
        application.setVisible(true);
    }//GEN-LAST:event_app_toolbtnActionPerformed

    private void Pruebaaaaaaaaa(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Pruebaaaaaaaaa
            JTabbedPane jtp = (JTabbedPane)evt.getSource();
            String screenSelected = jtp.getTitleAt(jtp.getSelectedIndex());
            currentScreen =  getScreenByName(screenSelected);
//            SelectScreenOnLeftTree(screenSelected);
    }//GEN-LAST:event_Pruebaaaaaaaaa

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
        ((JPanel) evt.getSource()).setBorder(BorderFactory.createLineBorder(Color.GRAY));
        activePanel = null;
    }

    private ControlType getControlTypeByName(String name) {
        for (ControlType controlTypeIt : controlTypes) {
            if (controlTypeIt.getType().equals(name)) {
                System.out.println(controlTypeIt.getType());
                return controlTypeIt;

            }
        }
        return null;
    }

    public void addChildSelectedNode(String childName ){
        DefaultMutableTreeNode newTreeNode = new DefaultMutableTreeNode(childName);
        if (selectedNodeLeftTree != null) {
            ((DefaultTreeModel)left_tree.getModel()).insertNodeInto(newTreeNode, selectedNodeLeftTree, selectedNodeLeftTree.getIndex(newTreeNode)+ 1);
            left_tree.repaint();
        }
    }

    public void addDataSourceChildNode(Datasource ds){
        DefaultMutableTreeNode newTreeNode = new DefaultMutableTreeNode(ds.getName());
        for(int i = 0; i< ds.getOutputFields().size(); i++){
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(ds.getOutputFields().get(i));
            newTreeNode.add(node);
        }
        List<Datasource> datasources = screenSelectedOnJtree.getDatasources();
        datasources.add(ds);
        screenSelectedOnJtree.setDatasources(datasources);
        AddDataSourceNode(ds);
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
    private javax.swing.JButton app_toolbtn;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel design_screen;
    private javax.swing.JButton ds_toolbtn;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel left_panel;
    private javax.swing.JTree left_tree;
    private javax.swing.JPanel rigth_panel;
    private javax.swing.JButton saveScreenBtn;
    private javax.swing.JButton save_toolbtn;
    private javax.swing.JTabbedPane screen_tb;
    private javax.swing.JButton screen_toolbtn;
    // End of variables declaration//GEN-END:variables

    private DefaultTreeModel applicationTreeModel;
    private DefaultTreeModel hostTreeModel;
    private DefaultMutableTreeNode applicationTreeNodeRoot;
    private DefaultMutableTreeNode selectedNodeLeftTree;
    private Vector<DefaultMutableTreeNode> applicationNodes;
    private ArrayList<Application> applications;
    private Application applicationSelected;
    private Screen screenSelectedOnJtree;
    private Datasource datasourceSelected;
    private JPanel activePanel;
    private String activeComponent;
    private List<ControlType> controlTypes;
    private int countForComponentName = 0;
    private IControl selectedComponent;
    private MyOwnVerticalLayout main_panel_layout;
    private Screen currentScreen;
    private List<Control> controls;
    private IControl rootControl;
    private int tabCount = 0;
    private List<MainPanelForScreenClass> mainPanels;
    public static ControlType controlType;
    public static List<ControlUidAndControlIDRelation> controlsUidAndIdRelation;
    public static List<ControlUIDpropertiIDAnddefinitioIDRelation> controlsUidPropertieIdAndDefinitionRelation;
}
