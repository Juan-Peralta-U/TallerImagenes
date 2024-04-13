/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Model.Imagen;
import Vista.VentanaPrincipal;
import java.util.ArrayList;
import java.io.File;

/**
 *
 * @author Juan
 */
public class GestorImagen {
    
    private ArrayList<Imagen> imagenes; 

    public GestorImagen() {
        this.imagenes = new ArrayList<>();
    }
    
    public void insertarImagenesRuta(String ruta){
        
        for(File file : new File(ruta).listFiles()){
            if(!file.isDirectory()){
                
                String dataType = file.getName().substring(file.getName().length()-3).toLowerCase();

                if(dataType.equals("jpg") || dataType.equals("png")){
                    
                    imagenes.add(new Imagen(file.getAbsolutePath()));
                    
                }
            }
        }
        
    }
    
    public void cargarImagenes(VentanaPrincipal vista){
        
        for(Imagen i : imagenes){
            vista.agregarImagen(i.getRutaImagen());
            System.out.println(i.getRutaImagen());
        }
        
    }
    
    
    public int getSize(){
        return imagenes.size();
    }
    
    public String getImagenIndex(int i){
        
        return imagenes.get(i).getRutaImagen();
    }

    int getPorcentaje(int index) {
        
       return ((100 / imagenes.size()) * (index + 1));
       
    }
    
    
}
