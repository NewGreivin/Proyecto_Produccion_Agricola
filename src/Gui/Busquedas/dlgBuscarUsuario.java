/**
 * @author Greivin
 */
package Gui.Busquedas;

import GUI.Utilidades.UtilGui;
import Modelo.Dtos.UsuarioDTO;
import java.util.List;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class dlgBuscarUsuario extends javax.swing.JDialog {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(dlgBuscarUsuario.class.getName());
    private List<UsuarioDTO> usuario;
    private UsuarioDTO usuarioSeleccionado;
    
    private DefaultTableModel model;
    private TableRowSorter<DefaultTableModel> sorter;
    private RowFilter<DefaultTableModel, Object> rowFilter;

    public void setList(List<UsuarioDTO> usuario) {
        this.usuario = usuario;
        loadTable();
    }

    public UsuarioDTO getUsuario() {
        return usuarioSeleccionado;
    }

    public dlgBuscarUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        model = (DefaultTableModel) tblUsuario.getModel();
        sorter = new TableRowSorter<>(model);
        tblUsuario.setRowSorter(sorter);
    }

    private void loadTable() {
    model.setRowCount(0); // Limpiar tabla
        if (usuario == null) return;
    for (UsuarioDTO u : usuario) {
        Object trabajadorId = "";
            if (u.getIdTrabajador() != null) {
                trabajadorId = String.valueOf(u.getIdTrabajador().getCedula());
            }
        Object[] data = {
            u.getId(),
            u.getUsername(),
            u.getPasswordHash(),
            u.getRol(),
            trabajadorId
        };
        model.addRow(data);
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        pnlIntroducir = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuario = new javax.swing.JTable();
        txtFiltro = new javax.swing.JTextField();
        pnlBotones = new javax.swing.JPanel();
        btnEliminar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblTitulo.setBackground(new java.awt.Color(255, 255, 255));
        lblTitulo.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Buscar Produccion");

        tblUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Usuario", "Contraseña", "Rol", "Trabajador"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblUsuario);

        txtFiltro.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtFiltro.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFiltroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlIntroducirLayout = new javax.swing.GroupLayout(pnlIntroducir);
        pnlIntroducir.setLayout(pnlIntroducirLayout);
        pnlIntroducirLayout.setHorizontalGroup(
            pnlIntroducirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIntroducirLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlIntroducirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(txtFiltro))
                .addContainerGap())
        );
        pnlIntroducirLayout.setVerticalGroup(
            pnlIntroducirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlIntroducirLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnEliminar.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Salir.png"))); // NOI18N
        btnEliminar.setText("Cancelar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnAgregar.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Aceptar.png"))); // NOI18N
        btnAgregar.setText("Confirmar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBotonesLayout = new javax.swing.GroupLayout(pnlBotones);
        pnlBotones.setLayout(pnlBotonesLayout);
        pnlBotonesLayout.setHorizontalGroup(
            pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonesLayout.createSequentialGroup()
                .addContainerGap(146, Short.MAX_VALUE)
                .addComponent(btnAgregar)
                .addGap(147, 147, 147)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153))
        );
        pnlBotonesLayout.setVerticalGroup(
            pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnEliminar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlIntroducir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlIntroducir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        int row =tblUsuario.getSelectedRow();
    if (row == -1) {
        UtilGui.showErrorMessage(this, "Debe seleccionar un contrato", "Error");
        return;
    }
    
    int modelRow = tblUsuario.convertRowIndexToModel(row);
    String idUsuario = String.valueOf(model.getValueAt(modelRow, 0));
    
        for (UsuarioDTO user : usuario) {
            if (String.valueOf(user.getId()).equals(idUsuario)) {
                usuarioSeleccionado = user;
                break;
            }
        }
        
        if (usuarioSeleccionado == null) {
            UtilGui.showErrorMessage(this, "Usuario no encontrada", "Error");
            return;
        }
         
        setVisible(false);
        dispose();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFiltroActionPerformed
        rowFilter = RowFilter.regexFilter("(?i)" + txtFiltro.getText());
        sorter.setRowFilter(rowFilter);
    }//GEN-LAST:event_txtFiltroActionPerformed

    public static void main(String args[]) {
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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                dlgBuscarUsuario dialog = new dlgBuscarUsuario(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlIntroducir;
    private javax.swing.JTable tblUsuario;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables
}
