package Gui.Vistas;

import Controlador.ControladorTrabajador;
import Controlador.ControladorUsuario;
import GUI.Utilidades.UtilGui;
import Gui.Busquedas.dlgBuscarUsuario;
import Gui.Interfaces.IGui;
import Modelo.Dtos.TrabajadorDTO;
import Modelo.Dtos.UsuarioDTO;
import Modelo.Objetos.Trabajadores.Trabajador;
import Modelo.Objetos.Usuarios.Rol;
import Modelo.Mappers.TrabajadorMapper;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


public class PnlUsuarios extends javax.swing.JPanel implements IGui {
    
    private ControladorUsuario controladorusuario;
    private UsuarioDTO userdto;
    private ControladorTrabajador controladortrabajador; 
    
    
    public PnlUsuarios() {
        initComponents();
        this.controladorusuario = new ControladorUsuario();
        this.controladortrabajador = new ControladorTrabajador();
        showRol();
        cargarTrabajadores();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        pnlContenedor = new javax.swing.JPanel();
        pnlDatos = new javax.swing.JPanel();
        lblCedula = new javax.swing.JLabel();
        lblPlaca = new javax.swing.JLabel();
        lblFechaInicio = new javax.swing.JLabel();
        lblFechaFinalizacion = new javax.swing.JLabel();
        txtCedula = new javax.swing.JComboBox<>();
        txtRol = new javax.swing.JComboBox<>();
        txtContraseña = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        pnlBotones = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(654, 501));
        setRequestFocusEnabled(false);
        setVerifyInputWhenFocusTarget(false);

        pnlContenedor.setBackground(new java.awt.Color(204, 204, 204));

        lblCedula.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        lblCedula.setText("Cedula trabajador:");

        lblPlaca.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        lblPlaca.setText("Usuario:");

        lblFechaInicio.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        lblFechaInicio.setText("Contraseña:");

        lblFechaFinalizacion.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        lblFechaFinalizacion.setText("Rol:");

        txtCedula.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        txtRol.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRolActionPerformed(evt);
            }
        });

        txtContraseña.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        txtUsuario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        javax.swing.GroupLayout pnlDatosLayout = new javax.swing.GroupLayout(pnlDatos);
        pnlDatos.setLayout(pnlDatosLayout);
        pnlDatosLayout.setHorizontalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCedula)
                    .addComponent(lblFechaInicio)
                    .addComponent(lblPlaca)
                    .addComponent(lblFechaFinalizacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUsuario)
                    .addComponent(txtCedula, 0, 200, Short.MAX_VALUE)
                    .addComponent(txtContraseña)
                    .addComponent(txtRol, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDatosLayout.setVerticalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCedula)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPlaca)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFechaInicio)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFechaFinalizacion)
                    .addComponent(txtRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(121, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlContenedorLayout = new javax.swing.GroupLayout(pnlContenedor);
        pnlContenedor.setLayout(pnlContenedorLayout);
        pnlContenedorLayout.setHorizontalGroup(
            pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlContenedorLayout.setVerticalGroup(
            pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContenedorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnAgregar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Agregar_Usuario.png"))); // NOI18N
        btnAgregar.setText("Agregar  ");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Limpiar_Usuario.png"))); // NOI18N
        btnLimpiar.setText("Limpiar   ");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Remover_Usuario.png"))); // NOI18N
        btnEliminar.setText("Eliminar  ");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnActualizar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Editar_Usuario.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnActualizar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscar_Usuario.png"))); // NOI18N
        btnBuscar.setText("Buscar     ");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBotonesLayout = new javax.swing.GroupLayout(pnlBotones);
        pnlBotones.setLayout(pnlBotonesLayout);
        pnlBotonesLayout.setHorizontalGroup(
            pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonesLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlBotonesLayout.setVerticalGroup(
            pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(pnlContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        lblTitulo.setBackground(new java.awt.Color(51, 51, 51));
        lblTitulo.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Gestión de Usuarios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        save();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        update();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        delete();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        search();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        clear();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRolActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblFechaFinalizacion;
    private javax.swing.JLabel lblFechaInicio;
    private javax.swing.JLabel lblPlaca;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlContenedor;
    private javax.swing.JPanel pnlDatos;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JComboBox<TrabajadorDTO> txtCedula;
    private javax.swing.JTextField txtContraseña;
    private javax.swing.JComboBox<Rol> txtRol;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    @Override
    public void save() {
        if (!validateRequiere()) {
            UtilGui.showErrorMessage(this, "Faltan datos requeridos", "Error");
            return;
        }

        try {
            TrabajadorDTO seleccionado = (TrabajadorDTO) txtCedula.getSelectedItem();
            if (seleccionado == null) {
                UtilGui.showErrorMessage(this, "Debe seleccionar un trabajador", "Error");
                return;
            }
            Trabajador trabajador = new TrabajadorMapper().toEntity(seleccionado);
            String usuario = txtUsuario.getText();
            String contraseña = txtContraseña.getText();
            Rol rol = (Rol) txtRol.getSelectedItem();

            if (controladorusuario.crear(usuario, contraseña, rol, trabajador)) {
                UtilGui.showMessage(this, "Se agregó correctamente", "Éxito");
                clear();
            }

        } catch (NumberFormatException e) {
            UtilGui.showErrorMessage(this, "Error en el formato de los datos", "Error");
        } catch (Exception e) {
            UtilGui.showErrorMessage(this, "Error al guardar: " + e.getMessage(), "Error");
        }

    }

    @Override
    public void clear() {
        txtCedula.setSelectedIndex(-1);
        txtRol.setSelectedIndex(-1);
        txtUsuario.setText("");
        txtContraseña.setText("");
    }

    @Override
    public void delete() {
        try {
            if (userdto == null) {
                UtilGui.showErrorMessage(this, "Debe seleccionar una producción primero", "Error");
                return;
            }

            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro de que quieres eliminar " + "?", 
                    "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {
                try {
                    if (controladorusuario.eliminar(userdto.getId())) {
                        UtilGui.showMessage(this, "Usuario eliminado correctamente", "Éxito");
                        clear();
                        userdto = null;
                    } else {
                        UtilGui.showErrorMessage(this, "No se pudo eliminar el usuario", "Error");
                    }
                } catch (Exception ex) {
                    UtilGui.showErrorMessage(this, "Error al eliminar: " + ex.getMessage(), "Error");
                    ex.printStackTrace();
                }
            }
        } catch (Exception e) {
            UtilGui.showErrorMessage(this, "Error al eliminar: " + e.getMessage(), "Error");
            e.printStackTrace();
        }
    }

    @Override
    public void update() {
        if (!validateRequiere()) {
            UtilGui.showErrorMessage(this, "Faltan datos requeridos", "Error");
            return;
        }

        try {
            if (userdto == null) {
                UtilGui.showErrorMessage(this, "Debe seleccionar un usuario primero", "Error");
                return;
            }

            String password = txtContraseña.getText();
            if (password == null || password.trim().isEmpty()) {
                UtilGui.showErrorMessage(this, "Debe ingresar una contraseña", "Error");
                return;
            }

            Object sel = txtRol.getSelectedItem();
            Rol rol = null;
            if (sel instanceof Rol) {
                rol = (Rol) sel;
            } else if (sel instanceof String) {
                String rolTexto = ((String) sel).trim();
                if (rolTexto.isEmpty()) {
                    UtilGui.showErrorMessage(this, "Debe seleccionar un rol", "Error");
                    return;
                }
                rol = Rol.valueOf(rolTexto);
            } else {
                UtilGui.showErrorMessage(this, "Debe seleccionar un rol", "Error");
                return;
            }

            boolean actualizado = controladorusuario.actualizar(userdto.getId(), password, rol);
        

            if (actualizado) {
                UtilGui.showMessage(this, "Usuario actualizado correctamente", "Éxito");
                clear();
                userdto = null;
            } else {
                UtilGui.showErrorMessage(this, "No se pudo actualizar el usuario", "Error");
            }

        } catch (IllegalArgumentException e) {
            UtilGui.showErrorMessage(this, "Rol inválido: " + e.getMessage(), "Error");
        } catch (Exception e) {
            UtilGui.showErrorMessage(this, "Error al actualizar: " + e.getMessage(), "Error");
            e.printStackTrace();
        }
}



    @Override
    public void search() {
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        dlgBuscarUsuario dlg = new dlgBuscarUsuario(parentFrame, true);
        
        try {
            List<UsuarioDTO> usuarios = controladorusuario.listar();
            
            if (usuarios == null) {
                UtilGui.showErrorMessage(this, "Error: controladorProduccion retornó null", "Error");
                return;
            }
            
            if (usuarios.isEmpty()) {
                UtilGui.showMessage(this, "No hay producciones registradas", "Información");
                return;
            }
            
            dlg.setList(usuarios);
            dlg.setLocationRelativeTo(this);
            dlg.setVisible(true);
            
            userdto = dlg.getUsuario();
            if (userdto != null) {
                showdata();
            }
        } catch (NullPointerException e) {
            UtilGui.showErrorMessage(this, "Error: NullPointerException - " + e.getMessage(), "Error");
            e.printStackTrace();
        } catch (Exception e) {
            UtilGui.showErrorMessage(this, "Error al buscar: " + e.getMessage(), "Error");
            e.printStackTrace();
        }
    }

    @Override
    public boolean validateRequiere() {
        return UtilGui.validateRequiere(txtCedula);
    }

    @Override
    public void showdata() {
        if (userdto == null) {
            return;
        }
        
        try {
            Trabajador idTrab = userdto.getIdTrabajador();
            if (idTrab != null) {
                DefaultComboBoxModel<TrabajadorDTO> model = (DefaultComboBoxModel<TrabajadorDTO>) txtCedula.getModel();
                for (int i = 0; i < model.getSize(); i++) {
                    TrabajadorDTO dto = model.getElementAt(i);
                    if (dto != null && dto.getCedula().equals(idTrab.getCedula())) {
                        txtCedula.setSelectedIndex(i);
                        break;
                    }
                }
            }
            txtUsuario.setText(userdto.getUsername());
            txtContraseña.setText(userdto.getPasswordHash());
            txtRol.setSelectedItem(userdto.getRol());
        } catch (Exception e) {
            UtilGui.showErrorMessage(this, "Error al mostrar producción: " + e.getMessage(), "Error");
        }
    }

    public void ConfirmarReserva() {
    if (!validateRequiere()) {
        UtilGui.showErrorMessage(this,"Faltan datos requeridos", "Error");
        return;
    }
    }
    
    private void showRol() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for (Rol rol : Rol.values()) {
            model.addElement(rol);
        }
        txtRol.setModel(model);
    }
    
    private void cargarTrabajadores() {
    try {
        List<TrabajadorDTO> trabajadores = controladortrabajador.obtenerTodosTrabajadores();
        DefaultComboBoxModel<TrabajadorDTO> model = new DefaultComboBoxModel<>();

        if (trabajadores != null) {
            for (TrabajadorDTO trabajador : trabajadores) {
                model.addElement(trabajador);
            }
        }

        txtCedula.setModel(model);
        
        txtCedula.setRenderer(new javax.swing.DefaultListCellRenderer() {
            @Override
            public java.awt.Component getListCellRendererComponent(javax.swing.JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof TrabajadorDTO) {
                    TrabajadorDTO dto = (TrabajadorDTO) value;
                    setText(String.format("%s - %s", dto.getCedula(), dto.getNombre()));
                } else {
                    setText(value == null ? "" : value.toString());
                }
                return this;
            }
        });

        
        txtCedula.setSelectedIndex(-1);

    } catch (Exception e) {
        UtilGui.showErrorMessage(this, "Error al cargar trabajadores: " + e.getMessage(), "Error");
    }
}

}