/**
 * @author MARISOL
 */
package Gui.Vistas;

import Controlador.ControladorCultivo;
import GUI.Utilidades.UtilGui;
import Gui.Busquedas.dlgBuscarCultivo;
import java.time.LocalDate;
import Gui.Interfaces.IGui;
import Modelo.Dtos.CultivoDTO;
import Modelo.Objetos.Cultivos.EstadoCrecimiento;
import Modelo.Objetos.Cultivos.TipoCultivo;
import Utilidades.UtilDate;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class PnlCultivos extends javax.swing.JPanel implements IGui {
    private ControladorCultivo controladorCultivo;
    private CultivoDTO cultivo;
    
    public PnlCultivos() {
        initComponents();
        controladorCultivo = new ControladorCultivo();
        cargarDatos();
        
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
        txtFechaCosecha = new javax.swing.JFormattedTextField();
        lblInfoFecha1 = new javax.swing.JLabel();
        lblEstadoContrato = new javax.swing.JLabel();
        lblMonto = new javax.swing.JLabel();
        comboEstado = new javax.swing.JComboBox<>();
        txtFechaSiembra = new javax.swing.JFormattedTextField();
        lblInfoFecha3 = new javax.swing.JLabel();
        txtArea = new javax.swing.JFormattedTextField();
        lblInfoTelefono1 = new javax.swing.JLabel();
        comboTipo = new javax.swing.JComboBox<>();
        txtNombre = new javax.swing.JTextField();
        pnlBotones = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(693, 506));
        setRequestFocusEnabled(false);
        setVerifyInputWhenFocusTarget(false);

        pnlContenedor.setBackground(new java.awt.Color(204, 204, 204));

        lblCedula.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        lblCedula.setText("Nombre:");

        lblPlaca.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        lblPlaca.setText("Tipo de cultivo:");

        lblFechaInicio.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        lblFechaInicio.setText("Area sembrada:");

        lblFechaFinalizacion.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        lblFechaFinalizacion.setText("Estado crecimiento:");

        txtFechaCosecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));

        lblInfoFecha1.setText("Requiere formato: dd/MM/yyyy");

        lblEstadoContrato.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        lblEstadoContrato.setText("Fecha cosecha:");

        lblMonto.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        lblMonto.setText("Fecha de siembra:");

        comboEstado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        txtFechaSiembra.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));

        lblInfoFecha3.setText("Requiere formato: dd/MM/yyyy");

        txtArea.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        lblInfoTelefono1.setText("Requiere formato: 00.0");

        comboTipo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        comboTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoActionPerformed(evt);
            }
        });

        txtNombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        javax.swing.GroupLayout pnlDatosLayout = new javax.swing.GroupLayout(pnlDatos);
        pnlDatos.setLayout(pnlDatosLayout);
        pnlDatosLayout.setHorizontalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFechaFinalizacion)
                            .addComponent(lblCedula))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(comboEstado, javax.swing.GroupLayout.Alignment.LEADING, 0, 237, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlDatosLayout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(lblInfoTelefono1))
                                .addComponent(comboTipo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtArea, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosLayout.createSequentialGroup()
                        .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEstadoContrato)
                            .addGroup(pnlDatosLayout.createSequentialGroup()
                                .addGap(204, 204, 204)
                                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFechaCosecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnlDatosLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(lblInfoFecha1))))
                            .addGroup(pnlDatosLayout.createSequentialGroup()
                                .addComponent(lblMonto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosLayout.createSequentialGroup()
                                        .addComponent(lblInfoFecha3)
                                        .addGap(17, 17, 17))
                                    .addComponent(txtFechaSiembra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(98, 98, 98))
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPlaca)
                            .addComponent(lblFechaInicio))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnlDatosLayout.setVerticalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedula)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPlaca)
                    .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFechaInicio)
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblInfoTelefono1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFechaFinalizacion)
                    .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblMonto)
                        .addComponent(txtFechaSiembra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(lblInfoFecha3)))
                .addGap(18, 18, 18)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEstadoContrato)
                    .addComponent(txtFechaCosecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInfoFecha1)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlContenedorLayout = new javax.swing.GroupLayout(pnlContenedor);
        pnlContenedor.setLayout(pnlContenedorLayout);
        pnlContenedorLayout.setHorizontalGroup(
            pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlContenedorLayout.setVerticalGroup(
            pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnAgregar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/page_add (4).png"))); // NOI18N
        btnAgregar.setText("Agregar  ");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Page_clear.png"))); // NOI18N
        btnLimpiar.setText("Limpiar   ");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/page_remove (4).png"))); // NOI18N
        btnEliminar.setText("Eliminar  ");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnActualizar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/page_edit (4).png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnActualizar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/page_search (4).png"))); // NOI18N
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
                .addContainerGap()
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(274, 274, 274))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblTitulo.setBackground(new java.awt.Color(51, 51, 51));
        lblTitulo.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Gestión de Cultivos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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

    private void comboTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboTipoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> comboEstado;
    private javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblEstadoContrato;
    private javax.swing.JLabel lblFechaFinalizacion;
    private javax.swing.JLabel lblFechaInicio;
    private javax.swing.JLabel lblInfoFecha1;
    private javax.swing.JLabel lblInfoFecha3;
    private javax.swing.JLabel lblInfoTelefono1;
    private javax.swing.JLabel lblMonto;
    private javax.swing.JLabel lblPlaca;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlContenedor;
    private javax.swing.JPanel pnlDatos;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JFormattedTextField txtArea;
    private javax.swing.JFormattedTextField txtFechaCosecha;
    private javax.swing.JFormattedTextField txtFechaSiembra;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    @Override
    public void save() {
        validarCampos();
        try {
            String nombre = txtNombre.getText().trim();
            String tipoNombre = (String) comboTipo.getSelectedItem();
            TipoCultivo tipo = TipoCultivo.valueOf(tipoNombre);
            String areaText = txtArea.getText().trim().replace(",", ".");
            double area = Double.parseDouble(areaText);
            String estadoNombre = (String) comboEstado.getSelectedItem();
            EstadoCrecimiento estado = EstadoCrecimiento.valueOf(estadoNombre);

            LocalDate fechaSiembra = UtilDate.toLocalDate(txtFechaSiembra.getText());
            LocalDate fechaCosecha = UtilDate.toLocalDate(txtFechaCosecha.getText());

            if (fechaSiembra == null) {
                UtilGui.showErrorMessage(this, "La fecha de siembra es obligatoria", "Error");
                return;
            }
            if (fechaCosecha != null && fechaCosecha.isBefore(fechaSiembra)) {
                UtilGui.showErrorMessage(this, "La fecha estimada de cosecha debe ser posterior a la fecha de siembra", "Error");
                return;
            }

            int generatedId = (int) (System.currentTimeMillis() % Integer.MAX_VALUE);

            boolean ok = controladorCultivo.crearCultivo(generatedId, nombre, tipo, area, estado, fechaSiembra, fechaCosecha);
            if (ok) {
                UtilGui.showMessage(this, "Cultivo agregado correctamente", "Exito");
                clear();
            } else {
                UtilGui.showErrorMessage(this, "No se pudo agregar cultivo", "Error");
            }
        } catch (NumberFormatException e) {
            UtilGui.showErrorMessage(this, "Error en el formato del area. Use 00.00", "Error");
        } catch (Exception e) {
            UtilGui.showErrorMessage(this, "Error al guardar: " + e.getMessage(), "Error");
            e.printStackTrace();
        }
    }

    @Override
    public void clear() {
        txtNombre.setText("");
        comboTipo.setSelectedIndex(-1);
        txtArea.setValue(null);
        comboEstado.setSelectedIndex(-1);
        txtFechaSiembra.setText("");
        txtFechaCosecha.setText("");
        cultivo = null;
    }

    @Override
    public void delete() {
        try {
            if (cultivo == null) {
                UtilGui.showErrorMessage(this, "Debe seleccionar un cultivo primero", "Error");
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(this,
                    "¿Esta seguro que desea eliminar el cultivo " + cultivo.getNombre() + " ?",
                    "Confirmar eliminacion", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                if (controladorCultivo.eliminar(cultivo.getId())) {
                    UtilGui.showMessage(this, "Cultivo eliminado correctamente", "Exito");
                    clear();
                } else {
                    UtilGui.showErrorMessage(this, "No se pudo eliminar el cultivo", "Error");
                }
            }
        } catch (Exception e) {
            UtilGui.showErrorMessage(this, "Error al eliminar: " + e.getMessage(), "Error");
            e.printStackTrace();
        }
    }

    @Override
    public void update() {
        try {
            if (cultivo == null) {
                UtilGui.showErrorMessage(this, "Debe seleccionar un cultivo primero", "Error");
                return;
            }
            if (!validateRequiere()) {
                UtilGui.showErrorMessage(this, "Faltan datos requeridos", "Error");
                return;
            }

            String nombre = txtNombre.getText().trim();
            String tipoNombre = (String) comboTipo.getSelectedItem();
            TipoCultivo tipo = TipoCultivo.valueOf(tipoNombre);
            String areaText = txtArea.getText().trim().replace(",", ".");
            double area = Double.parseDouble(areaText);
            String estadoNombre = (String) comboEstado.getSelectedItem();
            EstadoCrecimiento estado = EstadoCrecimiento.valueOf(estadoNombre);
            LocalDate fechaSiembra = UtilDate.toLocalDate(txtFechaSiembra.getText());
            LocalDate fechaCosecha = UtilDate.toLocalDate(txtFechaCosecha.getText());

            if (fechaSiembra == null) {
                UtilGui.showErrorMessage(this, "La fecha de siembra es obligatoria", "Error");
                return;
            }
            if (fechaCosecha != null && fechaCosecha.isBefore(fechaSiembra)) {
                UtilGui.showErrorMessage(this, "La fecha estimada de cosecha debe ser posterior a la fecha de siembra", "Error");
                return;
            }

            CultivoDTO dto = new CultivoDTO(cultivo.getId(), nombre, tipo, area, estado, fechaSiembra, fechaCosecha);
            if (controladorCultivo.actualizarCultivo(dto)) {
                UtilGui.showMessage(this, "Cultivo actualizado correctamente", "Exito");
                clear();
            } else {
                UtilGui.showErrorMessage(this, "No se pudo actualizar el cultivo", "Error");
            }
        } catch (NumberFormatException e) {
            UtilGui.showErrorMessage(this, "Error en el formato del area. Use 00.00", "Error");
        } catch (Exception e) {
            UtilGui.showErrorMessage(this, "Error al actualizar: " + e.getMessage(), "Error");
            e.printStackTrace();
        }
    }
    

    @Override
    public void search() {
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        dlgBuscarCultivo dlg = new dlgBuscarCultivo(parentFrame, true);

        try {
            List<CultivoDTO> cultivos = controladorCultivo.listar();
            if (cultivos == null || cultivos.isEmpty()) {
                UtilGui.showMessage(this, "No hay cultivos registrados", "Informacion");
                return;
            }
            
            dlg.setCultivos(cultivos);
            dlg.setLocationRelativeTo(this);
            dlg.setVisible(true);

            cultivo = dlg.getCultivo();
            if (cultivo != null) {
                showdata();
            }
        } catch (Exception e) {
            UtilGui.showErrorMessage(this, "Error al buscar: " + e.getMessage(), "Error");
            e.printStackTrace();
        }
    }

    @Override
    public boolean validateRequiere() {
        return UtilGui.validateRequiere(txtNombre, comboTipo, txtArea, comboEstado, txtFechaSiembra);
    }

    @Override
    public void showdata() {
        if (cultivo == null) return;

        try {
            txtNombre.setText(cultivo.getNombre());
            comboTipo.setSelectedItem(cultivo.getTipo() != null ? cultivo.getTipo().name() : null);
            txtArea.setValue(cultivo.getAreaSembrada());
            comboEstado.setSelectedItem(cultivo.getEstado() != null ? cultivo.getEstado().name() : null);
            txtFechaSiembra.setText(UtilDate.toString(cultivo.getFechaSiembra()));
            txtFechaCosecha.setText(UtilDate.toString(cultivo.getFechaEstimCosecha()));
        } catch (Exception e) {
            UtilGui.showErrorMessage(this, "Error al mostrar cultivo: " + e.getMessage(), "Error");
            e.printStackTrace();
        }
    }

    private void validarCampos() {
        if (!validateRequiere()) {
            UtilGui.showErrorMessage(this, "Faltan datos requeridos", "Error");
        }
    }
    
    private void cargarDatos() {
        cargarTipos();
        cargarEstados();
    }
    
    private void cargarTipos() {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (TipoCultivo t : TipoCultivo.values()) {
            model.addElement(t.name());
        }
        comboTipo.setModel(model);
    }
    
    private void cargarEstados() {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (EstadoCrecimiento e : EstadoCrecimiento.values()) {
            model.addElement(e.name());
        }
        comboEstado.setModel(model);
    }
}