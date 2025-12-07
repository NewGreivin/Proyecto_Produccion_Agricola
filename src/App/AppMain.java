
package App;

import Gui.Vistas.DlgLogin;

/**
 * @author Greivin
 */
public class AppMain {
    
    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(() -> {
            mostrarLogin();
        });
    }

    public static void mostrarLogin() {
        DlgLogin login = new DlgLogin(null, true);
        login.setVisible(true);
    }
}