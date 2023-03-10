/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FORMS;

import UML.Dictionary;
import CONSULTS.C_dictionary;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author franco
 */
public class firstViewProject extends javax.swing.JFrame {
    
    //
    String[] columnas = {"id_Diccionario", "nombre_Diccionario", "Version"};
    DefaultTableModel modelo;
    C_dictionary operationsDic = new C_dictionary();
    List<Dictionary> data = new ArrayList<>();
    
    public void cargarTablaDic() {
        
        tblFirstView.getTableHeader().setReorderingAllowed(false);
        this.modelo.setRowCount(0);
        data.clear();
        data = (List<Dictionary>) operationsDic.__SelectObject(null);
        Object[] obj = new Object[3];
        for (Dictionary fila : data) {
            obj[0] = fila.getIdDic();
            obj[1] = fila.getNombreDic();
            obj[2] = fila.getVersionDic();
            
            this.modelo.addRow(obj);
        }
        this.tblFirstView.setModel(modelo);
        //RESTABLECER CELDAS Y CENTRAR CONTENIDO.
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);

        tblFirstView.getColumnModel().getColumn(0).setCellRenderer(tcr); 
        tblFirstView.getColumnModel().getColumn(2).setCellRenderer(tcr);
    }
    
    /**
     * Creates new form Visualizar
     */
    public firstViewProject() {
        this.modelo = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int filas, int columnas) {
                return columnas == 3;
            }
        };
         
        initComponents();
        setLocationRelativeTo(null);
        cargarTablaDic();
        
        if(open.getText().equals("Abrir")){
            open.setEnabled(false);
        }
       
    }

    /**
     * Creates new form NewJFrame
     */

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFirstView = new javax.swing.JTable();
        open = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txtID = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        txtName = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        CrearDic = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblFirstView.setBackground(new java.awt.Color(0, 0, 102));
        tblFirstView.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        tblFirstView.setForeground(new java.awt.Color(255, 255, 255));
        tblFirstView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblFirstView.setToolTipText("");
        tblFirstView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFirstViewMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblFirstView);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 470, 360));

        open.setBackground(new java.awt.Color(0, 0, 51));
        open.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        open.setForeground(new java.awt.Color(255, 255, 255));
        open.setText("Abrir");
        open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openActionPerformed(evt);
            }
        });
        jPanel1.add(open, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, 90, 30));

        jPanel2.setBackground(new java.awt.Color(0, 0, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Diccionarios disponibles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Liberation Sans", 1, 15), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 530, 410));

        jPanel3.setBackground(new java.awt.Color(0, 0, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ID", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Liberation Sans", 1, 15), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtID.setEditable(false);
        txtID.setBackground(new java.awt.Color(0, 0, 51));
        txtID.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        txtID.setForeground(new java.awt.Color(255, 255, 255));
        txtID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });
        jPanel3.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 40, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 60, 60));

        jPanel4.setBackground(new java.awt.Color(0, 0, 51));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Titulo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Liberation Sans", 1, 15), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtName.setEditable(false);
        txtName.setBackground(new java.awt.Color(0, 0, 51));
        txtName.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        txtName.setForeground(new java.awt.Color(255, 255, 255));
        txtName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel4.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 130, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 170, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 690, 560));

        jMenu2.setText("File");

        CrearDic.setText("Crear nuevo diccionario");
        CrearDic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearDicActionPerformed(evt);
            }
        });
        jMenu2.add(CrearDic);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblFirstViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFirstViewMouseClicked
           
         //Obtener el id de la tabla en la columna posicion 0 
         String idX = tblFirstView.getValueAt(tblFirstView.getSelectedRow(),0).toString();
         String name = tblFirstView.getValueAt(tblFirstView.getSelectedRow(),1).toString();
         
         System.out.println("" + name);
         System.out.println("" + idX);
         
         this.txtID.setText(idX);
         this.txtName.setText(name);
         open.setEnabled(true);
        
                 
    }//GEN-LAST:event_tblFirstViewMouseClicked
      
    
    
    private void openActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openActionPerformed
        //Obtener el id y nombre del jTextField
        String msgID=txtID.getText();  String msgName=txtName.getText();
        new secondViewProject(msgID, msgName).setVisible(true);
        setVisible(false);
        
        open.setEnabled(false);
    }//GEN-LAST:event_openActionPerformed

    
    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void CrearDicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearDicActionPerformed
        // TODO add your handling code here:
        threeViewProject three = new threeViewProject();
        three.setVisible(true);
        dispose();
    }//GEN-LAST:event_CrearDicActionPerformed
   
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
            java.util.logging.Logger.getLogger(firstViewProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(firstViewProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(firstViewProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(firstViewProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new firstViewProject().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CrearDic;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton open;
    private javax.swing.JTable tblFirstView;
    public javax.swing.JTextField txtID;
    public javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}