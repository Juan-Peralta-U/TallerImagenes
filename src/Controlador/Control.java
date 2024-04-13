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
        gestorImagen = new GestorImagen();
        view = new VentanaPrincipal();        
        iniciarVista();
        
        
        
    }
    
    private void iniciarVista(){
        view.btnBuscar.addActionListener(this);
        view.btnSalir.addActionListener(this);
        iniciarBotonesImagen();
        view.setTitle("Visor Imagenes");
        view.setVisible(true);
        view.setLocationRelativeTo(null);
        view.setDefaultCloseOperation(0);
    }

    private void iniciarBotonesImagen(){
        for(JButton i : view.btnImagenes){
            i.addActionListener(this);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().startsWith("BotonImg")){
            
            String index = e.getActionCommand().substring(8);
            
            int indexBtn = Integer.parseInt(index);
             
            view.mensajeConsola(gestorImagen.getImagenIndex(indexBtn));
            
            return;
        }
        
        
        switch(e.getActionCommand()){
            case "buscarDirectorioBtn" ->{
                
                String directorio = new DirectoryChooser().Directory();
       
                gestorImagen.insertarImagenesRuta(directorio);
                
                gestorImagen.cargarImagenes(view);
                
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
      
}
