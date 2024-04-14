/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import javax.swing.ImageIcon;

/**
 *
 * @author Familia Mora
 */
public class Imagen {
    //me permite trabajar con los datos de la imagen
    private String  rutaImagen;
    private ImageIcon icono;

    public Imagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
        this.icono = new ImageIcon(rutaImagen);
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public ImageIcon getIcono() {
        return icono;
    }
    
}
