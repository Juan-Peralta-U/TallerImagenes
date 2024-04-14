/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Model.Imagen;
import Vista.VentanaPrincipal;
import java.util.ArrayList;
import java.io.File;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author Juan
 */
public class GestorImagen {
    
    private ArrayList<Imagen> imagenes;
    private Control control;

    public GestorImagen(Control control) {
        this.control = control;
        this.imagenes = new ArrayList<>();
    }
    
    public void insertarImagenesRuta(String ruta){
        
        if(ruta == null){
            
            // No existe carpeta o canceló operación de seleccionar carpeta
            return;
        }
        
        for(File file : new File(ruta).listFiles()){
            if(!file.isDirectory()){
                
                String dataType = file.getName().substring(file.getName().length()-3).toLowerCase();

                if(dataType.equals("jpg") || dataType.equals("png")){
                    
                    imagenes.add(new Imagen(file.getAbsolutePath()));

                }
            }
        }
        
    }
    
    public void cargarImagenes(){
        
        int nBotones = control.getView().getBtnImagenes().size();
        
        for(Imagen i : imagenes.subList(nBotones, imagenes.size())){
            
            control.getView().agregarImagen(i.getIcono());
            control.getView().mensajeConsola(i.getRutaImagen());
        }
        
    }
    
    
    public int getSize(){
        return imagenes.size();
    }

    public ArrayList<Imagen> getImagenes() {
        return imagenes;
    }
    
    public Imagen getImagenIndex(int i){
        
        return imagenes.get(i);
    }

    int getPorcentaje(int index) {
        
        return (int)((100 / (double)imagenes.size()) * (index + 1)); // Obtiene porcentaje 
    }
    
    
}
