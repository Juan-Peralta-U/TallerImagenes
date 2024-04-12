/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import javax.swing.JFileChooser;

/**
 *
 * @author Familia Mora
 */
public class DirectoryChooser {

    private JFileChooser dc;
    
    //Gran parte del codigo recopilada de la documentacion en oracle y youtube
    public String Directory() {
        dc  = new JFileChooser();
        // Establece el directorio actual del JFileChooser en el directorio actual del usuario.
        dc.setCurrentDirectory(new java.io.File("."));
        dc.setDialogTitle("Seleccione un directorio");
        //modifica el JFileChooser para que solo permita directorios
        dc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //Desabilita el filtro de tipo de archivo
        dc.setAcceptAllFileFilterUsed(false);
        if (dc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            //Devuelve la ruta del directorio
            return dc.getSelectedFile().toString();
        } else {
            
            return null;
        }
    }

}
