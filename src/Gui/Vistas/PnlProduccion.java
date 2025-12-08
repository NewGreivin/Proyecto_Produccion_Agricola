package Gui.Vistas;

import Controlador.ControladorCultivo;
import Controlador.ControladorProduccion;
import GUI.Utilidades.UtilGui;
import Gui.Busquedas.dlgBuscarProduccion;
import Gui.Interfaces.IGui;
import Modelo.Dtos.CultivoDTO;
import Modelo.Dtos.ProduccionDTO;
import Modelo.Objetos.Cultivos.Cultivo;
import Modelo.Objetos.Produccion.CalidadProduccion;
import Modelo.Objetos.Produccion.DestinoProduccion;
import Reportes.ReporteProduccionPDF;
import Utilidades.UtilDate;
import java.awt.Desktop;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author Greivin
 */
public class PnlProduccion extends javax.swing.JPanel implements IGui {

    private ControladorProduccion controladorProduccion;
    private ControladorCultivo controladorCultivo;
    private ProduccionDTO produccion;

    public PnlProduccion() {
        initComponents();
        controladorProduccion = new ControladorProduccion();
        controladorCultivo = new ControladorCultivo();
        cargarDatos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        pnlContenedor = new javax.swing.JPanel();
        pnlDatos = new javax.swing.JPanel();
        lblFechaNacimiento = new javax.swing.JLabel();
        txtFechaProduccion = new javax.swing.JFormattedTextField();
        lblTelefono = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        lblLicencia = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cmdDestino = new javax.swing.JComboBox<>();
        cmbCalidad = new javax.swing.JComboBox<>();
        cmdCultivo = new javax.swing.JComboBox<>();
        txtCantidadRecolectada = new javax.swing.JFormattedTextField();
        lblInfoTelefono1 = new javax.swing.JLabel();
        lblSalario = new javax.swing.JLabel();
        btnGenerarReporte = new javax.swing.JButton();
        pnlBotones = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        pnlContenedor.setBackground(new java.awt.Color(204, 204, 204));

        lblFechaNacimiento.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        lblFechaNacimiento.setText("Fecha de produccion:");

        txtFechaProduccion.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));

        lblTelefono.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        lblTelefono.setText("Calidad:");

        lblCorreo.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        lblCorreo.setText("Destino:");

        lblLicencia.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        lblLicencia.setText("Cultivo:");

        jLabel1.setText("Requiere formato: dd/MM/yyyy");

        cmdDestino.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        cmbCalidad.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        cmdCultivo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        txtCantidadRecolectada.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        lblInfoTelefono1.setText("Requiere formato: 00.0");

        lblSalario.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        lblSalario.setText("Cantidad Recolectada:");

        btnGenerarReporte.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnGenerarReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Aceptar.png"))); // NOI18N
        btnGenerarReporte.setText("Generar Reporte PDF");
        btnGenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDatosLayout = new javax.swing.GroupLayout(pnlDatos);
        pnlDatos.setLayout(pnlDatosLayout);
        pnlDatosLayout.setHorizontalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDatosLayout.createSequentialGroup()
                                .addComponent(lblLicencia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmdCultivo, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlDatosLayout.createSequentialGroup()
                                .addComponent(lblCorreo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmdDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlDatosLayout.createSequentialGroup()
                                .addComponent(lblTelefono)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbCalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosLayout.createSequentialGroup()
                                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblFechaNacimiento)
                                    .addComponent(lblSalario))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFechaProduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCantidadRecolectada, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnlDatosLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(lblInfoTelefono1)))))))
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnGenerarReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlDatosLayout.setVerticalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFechaNacimiento)
                    .addComponent(txtFechaProduccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSalario)
                    .addComponent(txtCantidadRecolectada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInfoTelefono1)
                .addGap(24, 24, 24)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTelefono)
                    .addComponent(cmbCalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCorreo)
                    .addComponent(cmdDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLicencia)
                    .addComponent(cmdCultivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnGenerarReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
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
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        lblTitulo.setText("Gestión de Produccion");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        clear();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        delete();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        update();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        search();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporteActionPerformed
        try {
            List<ProduccionDTO> producciones = controladorProduccion.obtenerTodasLasProducciones();
            
            if (producciones == null || producciones.isEmpty()) {
                UtilGui.showErrorMessage(this, "No hay producciones registradas para generar el reporte", "Sin Datos");
                return;
            }
            
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar Reporte PDF");
            fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos PDF", "pdf"));
            
            String nombreSugerido = "Reporte_Produccion_" + 
                LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")) + ".pdf";
            fileChooser.setSelectedFile(new java.io.File(nombreSugerido));
            
            int result = fileChooser.showSaveDialog(this);
            
            if (result == JFileChooser.APPROVE_OPTION) {
                String rutaArchivo = fileChooser.getSelectedFile().getAbsolutePath();
                
                // Esto asegura que termine en .pdf
                if (!rutaArchivo.toLowerCase().endsWith(".pdf")) {
                    rutaArchivo += ".pdf";
                }
                
                ReporteProduccionPDF reporte = new ReporteProduccionPDF();
                reporte.generarReporte(producciones, rutaArchivo);
                
                int opcion = JOptionPane.showConfirmDialog(this,
                    "Reporte PDF generado exitosamente en:\n" + rutaArchivo + "\n\n¿Desea abrir el archivo?",
                    "Reporte Generado",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE);
                
                if (opcion == JOptionPane.YES_OPTION) {
                    try {
                        Desktop.getDesktop().open(new File(rutaArchivo));
                    } catch (Exception ex) {
                        UtilGui.showErrorMessage(this, "No se pudo abrir el archivo: " + ex.getMessage(), "Error");
                    }
                }
            }
            
        } catch (Exception e) {
            UtilGui.showErrorMessage(this, "Error al generar el reporte: " + e.getMessage(), "Error");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnGenerarReporteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGenerarReporte;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cmbCalidad;
    private javax.swing.JComboBox<String> cmdCultivo;
    private javax.swing.JComboBox<String> cmdDestino;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblFechaNacimiento;
    private javax.swing.JLabel lblInfoTelefono1;
    private javax.swing.JLabel lblLicencia;
    private javax.swing.JLabel lblSalario;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlContenedor;
    private javax.swing.JPanel pnlDatos;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JFormattedTextField txtCantidadRecolectada;
    private javax.swing.JFormattedTextField txtFechaProduccion;
    // End of variables declaration//GEN-END:variables

    @Override
    public void save() {
        validarCampos();

        try {
            LocalDate fecha = UtilDate.toLocalDate(txtFechaProduccion.getText());
            String cantidadText = txtCantidadRecolectada.getText().trim().replace(",", ".");
            double cantidad = Double.parseDouble(cantidadText);
            String calidadNombre = (String) cmbCalidad.getSelectedItem();
            CalidadProduccion calidad = CalidadProduccion.valueOf(obtenerCalidadPorNombre(calidadNombre));
            String destinoNombre = (String) cmdDestino.getSelectedItem();
            DestinoProduccion destino = DestinoProduccion.valueOf(obtenerDestinoPorNombre(destinoNombre));
            int indiceCultivo = cmdCultivo.getSelectedIndex();
            List<CultivoDTO> cultivos = controladorCultivo.listar();

            CultivoDTO cultivoDTO = cultivos.get(indiceCultivo);
            Cultivo cultivo = new Cultivo(
                    cultivoDTO.getId(), cultivoDTO.getNombre(),
                    cultivoDTO.getTipo(),
                    cultivoDTO.getAreaSembrada(),
                    cultivoDTO.getEstado(),
                    cultivoDTO.getFechaSiembra(),
                    cultivoDTO.getFechaEstimCosecha()
            );

            if (controladorProduccion.crearProduccion(fecha, cantidad, calidad, destino, cultivo)) {
                UtilGui.showMessage(this, "Producción agregada correctamente", "Éxito");
                clear();
                cargarCultivos();
            }
        } catch (NumberFormatException e) {
            UtilGui.showErrorMessage(this, "Error en el formato de cantidad. Use formato: 00.0", "Error");
        } catch (Exception e) {
            UtilGui.showErrorMessage(this, "Error al guardar: " + e.getMessage(), "Error");
        }
    }

    @Override
    public boolean validateRequiere() {
        return UtilGui.validateRequiere(txtFechaProduccion, txtCantidadRecolectada, cmbCalidad, cmdCultivo, cmdDestino);
    }

    @Override
    public void clear() {
        txtFechaProduccion.setText("");
        txtCantidadRecolectada.setText("");
        cmbCalidad.setSelectedIndex(-1);
        cmdCultivo.setSelectedIndex(-1);
        cmdDestino.setSelectedIndex(-1);
    }

    @Override
    public void delete() {
        try {
            if (produccion == null) {
                UtilGui.showErrorMessage(this, "Debe seleccionar una producción primero", "Error");
                return;
            }

            int confirmacion = JOptionPane.showConfirmDialog(this,
                    "¿Está seguro de que desea eliminar la producción del " + UtilDate.toString(produccion.getFecha()) + "?", 
                    "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {
                try {
                    if (controladorProduccion.eliminarProduccion(produccion.getId())) {
                        UtilGui.showMessage(this, "Producción eliminada correctamente", "Éxito");
                        clear();
                        produccion = null;
                    } else {
                        UtilGui.showErrorMessage(this, "No se pudo eliminar la producción", "Error");
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
        try {
            if (produccion == null) {
                UtilGui.showErrorMessage(this, "Debe seleccionar una producción primero", "Error");
                return;
            }

            String calidadNombre = (String) cmbCalidad.getSelectedItem();
            if (calidadNombre == null) {
                UtilGui.showErrorMessage(this, "Debe seleccionar una calidad", "Error");
                return;
            }
            
            String destinoNombre = (String) cmdDestino.getSelectedItem();
            if (destinoNombre == null) {
                UtilGui.showErrorMessage(this, "Debe seleccionar un destino", "Error");
                return;
            }
            
            CalidadProduccion calidad = CalidadProduccion.valueOf(obtenerCalidadPorNombre(calidadNombre));
            DestinoProduccion destino = DestinoProduccion.valueOf(obtenerDestinoPorNombre(destinoNombre));

            if (controladorProduccion.actualizarProduccion(String.valueOf(produccion.getId()), produccion.getFecha(), produccion.getCantidadRecolectada(), calidad, destino)) {
                UtilGui.showMessage(this, "Producción actualizada correctamente", "Éxito");
                clear();
                produccion = null;
            } else {
                UtilGui.showErrorMessage(this, "No se pudo actualizar la producción", "Error");
            }
        } catch (Exception e) {
            UtilGui.showErrorMessage(this, "Error al actualizar: " + e.getMessage(), "Error");
            e.printStackTrace();
        }
    }

    @Override
    public void search() {
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        dlgBuscarProduccion dlg = new dlgBuscarProduccion(parentFrame, true);
        
        try {
            List<ProduccionDTO> producciones = controladorProduccion.obtenerTodasLasProducciones();
            
            if (producciones == null) {
                UtilGui.showErrorMessage(this, "Objeto null recibido", "Error");
                return;
            }
            
            if (producciones.isEmpty()) {
                UtilGui.showMessage(this, "No hay producciones registradas", "Información");
                return;
            }
            
            dlg.setProduciones(producciones);
            dlg.setLocationRelativeTo(this);
            dlg.setVisible(true);
            
            produccion = dlg.getProduccion();
            if (produccion != null) {
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
    public void showdata() {
        if (produccion == null) {
            return;
        }

        try {
            txtFechaProduccion.setText(UtilDate.toString(produccion.getFecha()));
            txtCantidadRecolectada.setText(String.valueOf(produccion.getCantidadRecolectada()));
            cmbCalidad.setSelectedItem(produccion.getCalidad().getCalidad());
            cmdDestino.setSelectedItem(produccion.getDestino().getDestino());
            cmdCultivo.setSelectedItem(produccion.getIdCultivo().getNombre());
        } catch (Exception e) {
            UtilGui.showErrorMessage(this, "Error al mostrar produccion: " + e.getMessage(), "Error");
        }
    }

    private void validarCampos() {
        if (!validateRequiere()) {
            UtilGui.showErrorMessage(this, "Faltan datos requeridos", "Error");
            return;
        }
    }
    
    private String obtenerCalidadPorNombre(String nombre) {
        for (CalidadProduccion c : CalidadProduccion.values()) {
            if (c.getCalidad().equalsIgnoreCase(nombre)) {
                return c.name();
            }
        }
        return "EXTRA";
    }

    private String obtenerDestinoPorNombre(String nombre) {
        for (DestinoProduccion d : DestinoProduccion.values()) {
            if (d.getDestino().equalsIgnoreCase(nombre)) {
                return d.name();
            }
        }
        return "VENTA";
    }

    private void cargarDatos() {
        cargarCalidades();
        cargarDestinos();
        cargarCultivos();
    }

    private void cargarCalidades() {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (CalidadProduccion calidad : CalidadProduccion.values()) {
            model.addElement(calidad.getCalidad());
        }
        cmbCalidad.setModel(model);
    }

    private void cargarDestinos() {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (DestinoProduccion destino : DestinoProduccion.values()) {
            model.addElement(destino.getDestino());
        }
        cmdDestino.setModel(model);
    }

    private void cargarCultivos() {
        try {
            List<CultivoDTO> cultivos = controladorCultivo.listar();
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
            for (CultivoDTO cultivo : cultivos) {
                model.addElement(cultivo.getNombre());
            }
            cmdCultivo.setModel(model);
        } catch (Exception e) {
            UtilGui.showErrorMessage(this, "Error al cargar cultivos: " + e.getMessage(), "Error");
        }
}
}