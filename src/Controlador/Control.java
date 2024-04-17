/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.DirectoryChooser;
import Vista.VentanaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/*
@author cesar
*/


public class Control implements ActionListener{
    private VentanaPrincipal view;
    private GestorImagen gestorImagen;

    public Control() {
        gestorImagen = new GestorImagen(this);
        view = new VentanaPrincipal();        
        iniciarVista();
    }
    
    private void iniciarVista(){
        
        //Método para inicialización de vista de catálogo
        view.btnBuscar.addActionListener(this);
        view.btnSalir.addActionListener(this);
        
        iniciarBotonesImagen();
        view.setTitle("Catálogo");
        view.setVisible(true);
        view.setLocationRelativeTo(null);
        view.setDefaultCloseOperation(0);
    }

    private void iniciarBotonesImagen(){
        for(JButton i : view.btnImagenes){
            if(i.getActionListeners().length > 0) { // No agregar actionlistener otra vez al mismo botón
                continue;
            }
            
            i.addActionListener(this);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        // Se obtiene ActionCommand que se definió anteriormente para los botones con imágenes
        if(e.getActionCommand().startsWith("BotonImg")){
            
            String index = e.getActionCommand().substring(8);
            
            int indexBtn = Integer.parseInt(index);
            
            HiloVisor hiloNuevo = new HiloVisor(indexBtn, gestorImagen);
            view.ventanaEmergente("Imagen seleccionada: " + gestorImagen.getImagenIndex(indexBtn).getRutaImagen() + "\n"
                                    + "ID del Hilo a ejecutar: " + hiloNuevo.getHilo().threadId());
            hiloNuevo.iniciarVista();
            
            
            return;
        }
        
        // Manejo de eventos buscar y salir
        switch(e.getActionCommand()){
            case "buscarDirectorioBtn" ->{
                
                String directorio = new DirectoryChooser().Directory();
                
                gestorImagen.insertarImagenesRuta(directorio);
                
                gestorImagen.cargarImagenes();
                
                iniciarBotonesImagen();
                
                view.repaint();
                
            }
            
            case "salirBtn" ->{
                view.setVisible(false);
                view.dispose();
                System.exit(0);
            }
            
       }
        
        
    }

    public VentanaPrincipal getView() {
        return view;
    }
      
}
