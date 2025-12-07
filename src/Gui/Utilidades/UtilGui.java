/**
 * @author Greivin
 */
package GUI.Utilidades;

import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.text.JTextComponent;

public class UtilGui {
    private static boolean hasValue(JComponent txt) {
        switch (txt) {
            case JTextComponent text -> {
                String s = text.getText();
                return s != null && !s.trim().isEmpty(); //El trim es para quitar los espacios existentes
            }
            case JComboBox<?> combo -> {
                Object i = combo.isEditable() ? combo.getEditor().getItem() : combo.getSelectedItem(); //Obtiene el texto ingresado o el que esta en el comboBox ya seleccionado
                return i != null && !i.toString().trim().isEmpty(); //Se verifica que no este vacio
            }
            case JSpinner sp -> {
                Object v = sp.getValue();
                return v != null && !String.valueOf(v).trim().isEmpty();
            }
            default -> {
                // Por defecto, se asume que es válido si no es uno de los casos anteriores
                return true;
            }
        }
    }
    
    public static boolean validateRequiere(JComponent... txts) { //Los tres puntito significa que puede resivir varios parametros a la vez Y validarlos
        for (JComponent txt : txts) {
            if (!hasValue(txt)) {
                return false;
            }
        }
        return true;
    }
    
    private static void showMessage(Component component, Object message,String title,int messageType) { //Esta es para hacer Joption Custom
        JOptionPane.showMessageDialog(component,message, title,messageType);
    }
    
    public static void showMessage(Component component, Object message,String title) { //Esta para enviar mensaje al usuario de agregado, eliminado etc..
        showMessage(component, message, title,JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void showErrorMessage(Component component, Object message,String title) { //Esta es para mostrar Errores, SOBRE QUE ALGO FALLO, de una forma mas amigable
        showMessage(component, message, title,JOptionPane.ERROR_MESSAGE);
    }
}