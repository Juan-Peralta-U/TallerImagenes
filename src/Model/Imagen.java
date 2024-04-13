/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author Familia Mora
 */
public class Imagen {
    //me permite trabajar con los datos de la imagen
    private String  rutaImagen;

    public Imagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }
    
    //verifica si el archivo es una imagen
    public static boolean tipoImagen(File file){
        //extensiones que permite el taller
        String[] extensionImagen={"jpg","png"};
        //pasa el nombre a minuscula para que se mas facil comparar
        String nombreImagen = file.getName().toLowerCase();
        //Recorre cada extensión en la lista de extensiones de archivos de imagen
        for (String extension: extensionImagen){
            //comprueba si el archivo tiene la extension
            if(nombreImagen.endsWith(extension)){
                return true;
            }
        }
        return false;
    }
    
}
