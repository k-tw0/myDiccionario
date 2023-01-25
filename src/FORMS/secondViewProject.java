/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FORMS;

import UML.CodexMenuDic;
import UML.MenuDictionary;


import CONSULTS.C_menuDictionary;
import CONSULTS.C_codexMenu;


import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author franco
 */
public class secondViewProject extends javax.swing.JFrame {
    // Titulos columnas
    String[] columnas = {"id_Menu", "name_Menu", "id_Dic"};
    
    String[] columnas2 = {"id_Codigo", "codex", "id_Menu"};
    
    DefaultTableModel modelo;
    DefaultTableModel modelo2;
   
    C_menuDictionary operationMenuDic = new C_menuDictionary();
    C_codexMenu operationCodexMenu = new C_codexMenu();
 
    CodexMenuDic umlCodexMenu = new CodexMenuDic();
    
    List<MenuDictionary> data = new ArrayList<>();
    List<CodexMenuDic> data3 = new ArrayList<>();
    
    public void cargarTablaMenus() {
        
        tablaCodigo.getTableHeader().setReorderingAllowed(false);
        this.modelo.setRowCount(0);
        data.clear();
        String text = txtIDX.getText();
       
        System.out.println("cargar tabla: "+text);
         
        data = (List<MenuDictionary>) operationMenuDic.__SelectObject(text);
        Object[] obj = new Object[3];
        for (MenuDictionary fila : data) {
            obj[0] = fila.getIdMenu();
            obj[1] = fila.getNombreMenu();
            obj[2] = fila.getIdDic().getIdDic();
            
            this.modelo.addRow(obj);
        }
        this.tablaCodigo.setModel(modelo);
        
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);

        tablaCodigo.getColumnModel().getColumn(0).setCellRenderer(tcr); 
        tablaCodigo.getColumnModel().getColumn(2).setCellRenderer(tcr);
       
    }
    
    public void cargarTablaContenido() {
        
        tablaCodex.getTableHeader().setReorderingAllowed(false);
        this.modelo2.setRowCount(0);
        data3.clear();
        
        String idMen = IDMENU.getText();
        data3 = (List<CodexMenuDic>) operationCodexMenu.selectMenu(idMen);
        Object[] obj = new Object[3];
        for (CodexMenuDic fila : data3) {
            obj[0] = fila.getIdCodigo();
            obj[1] = fila.getCodex();
            obj[2] = fila.getIdMenu().getIdMenu();
            
            this.modelo2.addRow(obj);
        }
        this.tablaCodex.setModel(modelo2);
        
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        
        tcr.setHorizontalAlignment(SwingConstants.CENTER);

        tablaCodex.getColumnModel().getColumn(0).setCellRenderer(tcr); 
        tablaCodex.getColumnModel().getColumn(2).setCellRenderer(tcr);
       
    }
    
    public void cargarTxtAr() {
         data3.clear();
         String idCodex = IDCODEX.getText();
         String idMen = IDMENU.getText();
         data3 = (List<CodexMenuDic>) operationCodexMenu.mostrarTextArea(idMen, idCodex);
         Object[] obj = new Object[3];
         for (CodexMenuDic fila : data3) {
            obj[0] = fila.getIdCodigo();
            obj[1] = fila.getCodex();
            obj[2] = fila.getIdMenu().getIdMenu();
            
            txtAreaCode.setText("" + obj[1]);
        }     
    }
    
    public void viewRadioBtn(){
        radioBtnView.setSelected(true);
        radioBtnEdit.setSelected(false);
        radioBtnExec.setSelected(false);
        
        txtAreaCode.setEditable(false);
        
        btnTxt.setEnabled(false);
        btnTxt.setVisible(false);
        tablaCodex.setVisible(false);
    }
    
    public void radioBtnExec(){
        radioBtnExec.setSelected(true);
        radioBtnEdit.setSelected(false);
        radioBtnView.setSelected(false);
        btnTxt.setEnabled(true);
        btnTxt.setVisible(true);
        txtAreaCode.setEditable(false);
        btnTxt.setText("Ejecutar");
    }
    
    public void radioBtnEdit(){
        radioBtnEdit.setSelected(true);
        radioBtnExec.setSelected(false);
        radioBtnView.setSelected(false);
        
        btnTxt.setEnabled(true);
        btnTxt.setVisible(true);
        txtAreaCode.setEditable(true);
        btnTxt.setText("Guardar");
        txtAreaCode.setText("");
        
    }
    
    /**
     * Creates new form Visualizar
     */
    public secondViewProject() {
        initComponents();
        setLocationRelativeTo(null);
        
    }
    
    public secondViewProject(String msgID, String msgName) {
        this.modelo = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int filas, int columnas) {
                return columnas == 3;
            }
        };
        
        this.modelo2 = new DefaultTableModel(columnas2,0) {
            @Override
            public boolean isCellEditable(int filas, int columnas) {
                return columnas == 3;
            }
        };
        
        
        initComponents();
        txtIDX.setText(msgID);
        txtLenguaje.setText(msgName);
        cargarTablaMenus();
        viewRadioBtn();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCodigo = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        IDMENU = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaCode = new javax.swing.JTextArea();
        btnTxt = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaCodex = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        txtLenguaje = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        txtIDX = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        radioBtnEdit = new javax.swing.JRadioButton();
        radioBtnExec = new javax.swing.JRadioButton();
        radioBtnView = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel10 = new javax.swing.JPanel();
        IDCODEX = new javax.swing.JTextField();
        btnNew = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        MenuPrincipal = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        jMenuItem2.setText("Borrar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 0, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Liberation Sans", 1, 15), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 0, 51));
        jPanel2.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(51, 0, 51));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Carpetas disponibles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Liberation Sans", 1, 15), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaCodigo.setBackground(new java.awt.Color(102, 102, 102));
        tablaCodigo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tablaCodigo.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        tablaCodigo.setForeground(new java.awt.Color(255, 255, 255));
        tablaCodigo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        tablaCodigo.setToolTipText("");
        tablaCodigo.setGridColor(new java.awt.Color(51, 0, 51));
        tablaCodigo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaCodigoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaCodigo);

        jPanel7.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 460, 210));

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 480, 240));

        jPanel9.setBackground(new java.awt.Color(51, 0, 51));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Menu id:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Liberation Sans", 1, 15), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        IDMENU.setEditable(false);
        IDMENU.setBackground(new java.awt.Color(51, 0, 51));
        IDMENU.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        IDMENU.setForeground(new java.awt.Color(255, 255, 255));
        IDMENU.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        IDMENU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDMENUActionPerformed(evt);
            }
        });
        jPanel9.add(IDMENU, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 60, 30));

        jPanel2.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 80, 60));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 540, 360));

        jPanel3.setBackground(new java.awt.Color(51, 0, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel3.setForeground(new java.awt.Color(51, 0, 51));

        txtAreaCode.setBackground(new java.awt.Color(0, 0, 51));
        txtAreaCode.setColumns(20);
        txtAreaCode.setFont(new java.awt.Font("Noto Sans Mono", 0, 16)); // NOI18N
        txtAreaCode.setForeground(new java.awt.Color(204, 255, 204));
        txtAreaCode.setRows(5);
        txtAreaCode.setTabSize(4);
        txtAreaCode.setCaretColor(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(txtAreaCode);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 100, 620, 580));

        btnTxt.setBackground(new java.awt.Color(51, 0, 0));
        btnTxt.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        btnTxt.setForeground(new java.awt.Color(255, 255, 255));
        btnTxt.setText("Guardar");
        btnTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTxtActionPerformed(evt);
            }
        });
        jPanel1.add(btnTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 690, 100, 30));

        jPanel4.setBackground(new java.awt.Color(51, 0, 51));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Archivos disponibles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Liberation Sans", 1, 15), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel4.setForeground(new java.awt.Color(0, 153, 153));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaCodex.setBackground(new java.awt.Color(102, 102, 102));
        tablaCodex.setBorder(new javax.swing.border.MatteBorder(null));
        tablaCodex.setForeground(new java.awt.Color(255, 255, 255));
        tablaCodex.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaCodex.setComponentPopupMenu(jPopupMenu1);
        tablaCodex.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablaCodex.setGridColor(new java.awt.Color(51, 0, 51));
        tablaCodex.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaCodexMouseClicked(evt);
            }
        });
        tablaCodex.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaCodexKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(tablaCodex);

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 500, 160));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 530, 210));

        jPanel5.setBackground(new java.awt.Color(51, 0, 51));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Titulo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Liberation Sans", 1, 15), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtLenguaje.setEditable(false);
        txtLenguaje.setBackground(new java.awt.Color(51, 0, 0));
        txtLenguaje.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        txtLenguaje.setForeground(new java.awt.Color(204, 204, 204));
        txtLenguaje.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtLenguaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLenguajeActionPerformed(evt);
            }
        });
        jPanel5.add(txtLenguaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 190, 30));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, 210, 60));

        jPanel6.setBackground(new java.awt.Color(51, 0, 51));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ID", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Liberation Sans", 1, 15), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtIDX.setEditable(false);
        txtIDX.setBackground(new java.awt.Color(51, 0, 51));
        txtIDX.setForeground(new java.awt.Color(255, 255, 204));
        txtIDX.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIDX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDXActionPerformed(evt);
            }
        });
        jPanel6.add(txtIDX, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 30, 30));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, 50, 60));

        jPanel8.setBackground(new java.awt.Color(51, 0, 51));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mod", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Liberation Sans", 1, 15), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        radioBtnEdit.setBackground(new java.awt.Color(51, 0, 51));
        radioBtnEdit.setFont(new java.awt.Font("Liberation Mono", 0, 15)); // NOI18N
        radioBtnEdit.setForeground(new java.awt.Color(255, 255, 204));
        radioBtnEdit.setText("Edit");
        radioBtnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtnEditActionPerformed(evt);
            }
        });
        jPanel8.add(radioBtnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, 30));

        radioBtnExec.setBackground(new java.awt.Color(51, 0, 51));
        radioBtnExec.setFont(new java.awt.Font("Liberation Mono", 0, 15)); // NOI18N
        radioBtnExec.setForeground(new java.awt.Color(255, 255, 255));
        radioBtnExec.setText("Exec");
        radioBtnExec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtnExecActionPerformed(evt);
            }
        });
        jPanel8.add(radioBtnExec, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 70, 30));

        radioBtnView.setBackground(new java.awt.Color(51, 0, 51));
        radioBtnView.setFont(new java.awt.Font("Liberation Mono", 0, 15)); // NOI18N
        radioBtnView.setForeground(new java.awt.Color(255, 255, 255));
        radioBtnView.setText("View");
        radioBtnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtnViewActionPerformed(evt);
            }
        });
        jPanel8.add(radioBtnView, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 70, 30));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setToolTipText("");
        jPanel8.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 10, 30));

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator3.setToolTipText("");
        jPanel8.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 10, 30));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 20, 260, 70));

        jPanel10.setBackground(new java.awt.Color(51, 0, 51));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "id Archivo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Liberation Sans", 1, 15), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        IDCODEX.setEditable(false);
        IDCODEX.setBackground(new java.awt.Color(51, 0, 51));
        IDCODEX.setForeground(new java.awt.Color(255, 255, 255));
        IDCODEX.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel10.add(IDCODEX, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 70, 30));

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 90, 60));

        btnNew.setBackground(new java.awt.Color(51, 0, 0));
        btnNew.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        btnNew.setForeground(new java.awt.Color(255, 255, 255));
        btnNew.setText("Nuevo");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        jPanel1.add(btnNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 690, 100, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1230, 730));

        jMenu1.setText("File");

        MenuPrincipal.setText("Menu principal");
        MenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuPrincipalActionPerformed(evt);
            }
        });
        jMenu1.add(MenuPrincipal);

        jMenuItem1.setText("Crear diccionario");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaCodigoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCodigoMouseClicked
        // TODO add your handling code here:       
        
         String idDiccionario = tablaCodigo.getValueAt(tablaCodigo.getSelectedRow(),2).toString();
         String idMenu = tablaCodigo.getValueAt(tablaCodigo.getSelectedRow(),0).toString();
         
         System.out.println("idDiccionario: " + idDiccionario);
         System.out.println("idMenu: " + idMenu);
         
         IDMENU.setText(idMenu);           
         cargarTablaContenido();
         tablaCodex.setVisible(true);
         btnTxt.setText("Guardar");
         txtAreaCode.setText("");
    }//GEN-LAST:event_tablaCodigoMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        threeViewProject edit = new threeViewProject();
        edit.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTxtActionPerformed
 
        if(btnTxt.getText().equals("Guardar")){
        // TODO add your handling code here:
         if(IDMENU.getText().equals("") || txtAreaCode.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Seleccione un elemento y escriba algo para guardar.");
        }else{
            this.umlCodexMenu.setCodex(this.txtAreaCode.getText());
           
            this.umlCodexMenu.setIdMenu(new MenuDictionary(Integer.parseInt(this.IDMENU.getText())));
            
            if(operationCodexMenu.insert(this.umlCodexMenu)) {
                JOptionPane.showMessageDialog(this, "Registro guardado correctamente!!");
                cargarTablaMenus(); 
                cargarTablaContenido();
                tablaCodex.setVisible(true);
                txtAreaCode.setText("");
                
            }else {
                JOptionPane.showMessageDialog(this, "Error al insertar");
                
            }
            
        }
    }else if(btnTxt.getText().equals("Modificar")){
            if(IDCODEX.getText().equals("") || txtAreaCode.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Seleccione un codigo");
        }else{
              this.umlCodexMenu.setIdCodigo(Integer.parseInt(this.IDCODEX.getText()));
            this.umlCodexMenu.setCodex(this.txtAreaCode.getText());
            
             int resp = JOptionPane.showConfirmDialog(null, "Estas seguro que deseas modificar el codex del Proyecto  ?",
                     "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            
            if(resp == JOptionPane.YES_OPTION) {
                if(operationCodexMenu.update(this.umlCodexMenu)) {
                    JOptionPane.showMessageDialog(this, "Verifica el codex, en la base de datos.");
                    cargarTablaContenido();
                    tablaCodex.setVisible(true);
                    txtAreaCode.setText("");
                }else {
                    JOptionPane.showMessageDialog(this,"No se ha modificado");
                }
            }
        }
    }
        

    
    }//GEN-LAST:event_btnTxtActionPerformed

    private void txtIDXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDXActionPerformed
        // TODO add your handling code here:
         
    }//GEN-LAST:event_txtIDXActionPerformed

    private void txtLenguajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLenguajeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLenguajeActionPerformed

    private void tablaCodexMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCodexMouseClicked
        // TODO add your handling code here:
        
        String idCodex = tablaCodex.getValueAt(tablaCodex.getSelectedRow(),0).toString();
        IDCODEX.setText(idCodex);
        cargarTxtAr();
        btnTxt.setEnabled(true);
        btnTxt.setText("Modificar");
                     
    }//GEN-LAST:event_tablaCodexMouseClicked

    private void radioBtnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtnEditActionPerformed
        // TODO add your handling code here:
        
        radioBtnEdit();
    }//GEN-LAST:event_radioBtnEditActionPerformed

    private void radioBtnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtnViewActionPerformed
        // TODO add your handling code here:
        viewRadioBtn();
    }//GEN-LAST:event_radioBtnViewActionPerformed

    private void IDMENUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDMENUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDMENUActionPerformed

    private void radioBtnExecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtnExecActionPerformed
        // TODO add your handling code here:
        radioBtnExec();
    }//GEN-LAST:event_radioBtnExecActionPerformed

    private void tablaCodexKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaCodexKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaCodexKeyPressed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // TODO add your handling code here:
        radioBtnEdit();
        IDCODEX.setText("");
        txtAreaCode.setText("");
        tablaCodex.setVisible(false);
    }//GEN-LAST:event_btnNewActionPerformed

    private void MenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuPrincipalActionPerformed
        // TODO add your handling code here:
        firstViewProject first = new firstViewProject();
        first.setVisible(true);
        dispose();
    }//GEN-LAST:event_MenuPrincipalActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        if(IDCODEX.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Por favor seleccione.");
        } else {
          
            this.umlCodexMenu.setIdCodigo(Integer.parseInt(this.IDCODEX.getText()));
            this.umlCodexMenu.setCodex(this.txtAreaCode.getText());
            
            int resp = JOptionPane.showConfirmDialog(null, "Estas seguro que deseas eliminar el codex ?",
                     "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
            
            if(resp == JOptionPane.YES_OPTION) {
                if(operationCodexMenu.delete(this.umlCodexMenu)) {
                    JOptionPane.showMessageDialog(this, "El registro se ha eliminado!");
                     cargarTablaMenus(); 
                     cargarTablaContenido();
                     tablaCodex.setVisible(true);
                     txtAreaCode.setText("");
                }else {
                    JOptionPane.showMessageDialog(this,"No se ha eliminado");
                }
            }
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(secondViewProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(secondViewProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(secondViewProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(secondViewProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new secondViewProject().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IDCODEX;
    private javax.swing.JTextField IDMENU;
    private javax.swing.JMenuItem MenuPrincipal;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnTxt;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JRadioButton radioBtnEdit;
    private javax.swing.JRadioButton radioBtnExec;
    private javax.swing.JRadioButton radioBtnView;
    private javax.swing.JTable tablaCodex;
    private javax.swing.JTable tablaCodigo;
    private javax.swing.JTextArea txtAreaCode;
    public javax.swing.JTextField txtIDX;
    public javax.swing.JTextField txtLenguaje;
    // End of variables declaration//GEN-END:variables

    public String txtIDX() {
       
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
