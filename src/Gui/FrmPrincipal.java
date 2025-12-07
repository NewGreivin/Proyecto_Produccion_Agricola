/**
 * @author Greivin
 */
package Gui;

import Gui.Vistas.PnlAlmacenamiento;
import Gui.Vistas.PnlProduccion;
import Gui.Vistas.PnlCultivos;
import Gui.Vistas.PnlTrabajadores;
import Gui.Vistas.PnlUsuarios;
import javax.swing.JPanel;

public class FrmPrincipal extends javax.swing.JFrame {
    private PnlAlmacenamiento pnlAlmacenamiento;
    private PnlCultivos pnlCultivos;
    private PnlProduccion pnlProduccion;
    private PnlTrabajadores pnlTrabajadores;
    private PnlUsuarios pnlUsuarios;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmPrincipal.class.getName());

    public FrmPrincipal() {
        initComponents();
        //pnlUsuarios = new PnlUsuarios();
        //pnlTrabajadores = new PnlTrabajadores();
        //pnlCultivos = new PnlCultivos();
        pnlProduccion = new PnlProduccion();
        //pnlAlmacenamiento = new PnlAlmacenamiento();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlContenedor = new javax.swing.JPanel();
        pnlCreditos = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lpbCreditos = new javax.swing.JLabel();
        lblDashboard = new javax.swing.JPanel();
        lblNombreEmpresa = new javax.swing.JLabel();
        bntCultivos = new javax.swing.JButton();
        btnTrabajadores = new javax.swing.JButton();
        btnProduccion = new javax.swing.JButton();
        btnAlmacenamiento = new javax.swing.JButton();
        btnUsuarios = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnCerrarSeccion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DriveUp - Gestion y Alquiler de vehiculos");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocationByPlatform(true);
        setResizable(false);

        pnlContenedor.setBackground(new java.awt.Color(255, 255, 255));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Icon.png"))); // NOI18N

        lblTitulo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Sistema de Produccion Agricola");

        lpbCreditos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lpbCreditos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lpbCreditos.setText("Software creado por Código Blindado @ 2025");

        javax.swing.GroupLayout pnlCreditosLayout = new javax.swing.GroupLayout(pnlCreditos);
        pnlCreditos.setLayout(pnlCreditosLayout);
        pnlCreditosLayout.setHorizontalGroup(
            pnlCreditosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCreditosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCreditosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCreditosLayout.createSequentialGroup()
                        .addComponent(lblLogo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lpbCreditos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlCreditosLayout.setVerticalGroup(
            pnlCreditosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCreditosLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addGap(45, 45, 45)
                .addComponent(lpbCreditos)
                .addGap(68, 68, 68))
        );

        javax.swing.GroupLayout pnlContenedorLayout = new javax.swing.GroupLayout(pnlContenedor);
        pnlContenedor.setLayout(pnlContenedorLayout);
        pnlContenedorLayout.setHorizontalGroup(
            pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenedorLayout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addComponent(pnlCreditos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(228, Short.MAX_VALUE))
        );
        pnlContenedorLayout.setVerticalGroup(
            pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenedorLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(pnlCreditos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblDashboard.setBackground(new java.awt.Color(0, 102, 102));

        lblNombreEmpresa.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblNombreEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreEmpresa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombreEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo.png"))); // NOI18N
        lblNombreEmpresa.setText("DriveUp");

        bntCultivos.setBackground(new java.awt.Color(0, 153, 153));
        bntCultivos.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        bntCultivos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Clientes.png"))); // NOI18N
        bntCultivos.setText("Cultivos");
        bntCultivos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bntCultivos.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        bntCultivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCultivosActionPerformed(evt);
            }
        });

        btnTrabajadores.setBackground(new java.awt.Color(0, 153, 153));
        btnTrabajadores.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnTrabajadores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Reservas.png"))); // NOI18N
        btnTrabajadores.setText("Trabajadores");
        btnTrabajadores.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnTrabajadores.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnTrabajadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrabajadoresActionPerformed(evt);
            }
        });

        btnProduccion.setBackground(new java.awt.Color(0, 153, 153));
        btnProduccion.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnProduccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Vehiculos.png"))); // NOI18N
        btnProduccion.setText("Produccion");
        btnProduccion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnProduccion.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnProduccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProduccionActionPerformed(evt);
            }
        });

        btnAlmacenamiento.setBackground(new java.awt.Color(0, 153, 153));
        btnAlmacenamiento.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnAlmacenamiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Alquileres.png"))); // NOI18N
        btnAlmacenamiento.setText("Almacenamiento");
        btnAlmacenamiento.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAlmacenamiento.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAlmacenamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlmacenamientoActionPerformed(evt);
            }
        });

        btnUsuarios.setBackground(new java.awt.Color(0, 153, 153));
        btnUsuarios.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Empleados.png"))); // NOI18N
        btnUsuarios.setText("Usuarios");
        btnUsuarios.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnUsuarios.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(204, 0, 51));
        btnSalir.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Salir.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setBorderPainted(false);
        btnSalir.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnCerrarSeccion.setBackground(new java.awt.Color(102, 102, 102));
        btnCerrarSeccion.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnCerrarSeccion.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrarSeccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Salir.png"))); // NOI18N
        btnCerrarSeccion.setText("Cerrar Sesion");
        btnCerrarSeccion.setBorderPainted(false);
        btnCerrarSeccion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCerrarSeccion.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCerrarSeccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSeccionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout lblDashboardLayout = new javax.swing.GroupLayout(lblDashboard);
        lblDashboard.setLayout(lblDashboardLayout);
        lblDashboardLayout.setHorizontalGroup(
            lblDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblDashboardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lblDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAlmacenamiento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNombreEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTrabajadores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProduccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bntCultivos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCerrarSeccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        lblDashboardLayout.setVerticalGroup(
            lblDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblDashboardLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblNombreEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bntCultivos, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTrabajadores, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnProduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAlmacenamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCerrarSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(lblDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mostrarPanel(JPanel panel) { //Cargador de paneles
    pnlContenedor.removeAll();
    // Calcula el tamaño del contenedor
    int anchoCont = pnlContenedor.getWidth();
    int altoCont = pnlContenedor.getHeight();
    // Calcula el tamaño del panel
    int anchoPanel = panel.getWidth();
    int altoPanel = panel.getHeight();
    // Si el panel no tiene tamaño aún, lo ajustamos a su preferredSize
    if (anchoPanel == 0 || altoPanel == 0) {
        panel.setSize(panel.getPreferredSize());
        anchoPanel = panel.getWidth();
        altoPanel = panel.getHeight();
    }
    // Calcula la posición para centrarlo
    int x = (anchoCont - anchoPanel) / 2;
    int y = (altoCont - altoPanel) / 2;
    panel.setLocation(x, y);
    pnlContenedor.setLayout(null);
    pnlContenedor.removeAll();      // Limpia lo que haya en el contenedor
    pnlContenedor.add(panel);       // Agrega el nuevo panel
    pnlContenedor.revalidate();     // Reorganiza el layout
    pnlContenedor.repaint();        // Redibuja
}
    
    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        //pnlReservas.cargarCombos();
        mostrarPanel(pnlUsuarios);
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void bntCultivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCultivosActionPerformed
        mostrarPanel(pnlCultivos);
    }//GEN-LAST:event_bntCultivosActionPerformed

    private void btnTrabajadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrabajadoresActionPerformed
        mostrarPanel(pnlTrabajadores);
    }//GEN-LAST:event_btnTrabajadoresActionPerformed

    private void btnProduccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProduccionActionPerformed
        mostrarPanel(pnlProduccion);
    }//GEN-LAST:event_btnProduccionActionPerformed

    private void btnAlmacenamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlmacenamientoActionPerformed
        //pnlContratos.cargarCombos();
        mostrarPanel(pnlAlmacenamiento);  
    }//GEN-LAST:event_btnAlmacenamientoActionPerformed

    private void btnCerrarSeccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSeccionActionPerformed
        dispose();
        App.AppMain.mostrarLogin();
    }//GEN-LAST:event_btnCerrarSeccionActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new FrmPrincipal().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntCultivos;
    private javax.swing.JButton btnAlmacenamiento;
    private javax.swing.JButton btnCerrarSeccion;
    private javax.swing.JButton btnProduccion;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnTrabajadores;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JPanel lblDashboard;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNombreEmpresa;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lpbCreditos;
    private javax.swing.JPanel pnlContenedor;
    private javax.swing.JPanel pnlCreditos;
    // End of variables declaration//GEN-END:variables
}
