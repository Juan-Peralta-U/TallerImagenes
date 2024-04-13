/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.VisorImagen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan
 */
public class HiloVisor extends Thread implements ActionListener {
    
    VisorImagen visorImagen;
    GestorImagen gestorImagen;
    int indexImg;
    private boolean detenido = false; // bandera para detener el hilo
    
    public HiloVisor(int index, GestorImagen gestorImagen) {
        indexImg = index;
        this.gestorImagen = gestorImagen;
        visorImagen = new VisorImagen();
        iniciarVista();
        start();
    }
    
    @Override
    public void run() {
        while (true) { // bucle hasta que se detenga el hilo
            if(!detenido){
            cambiarImagen();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloVisor.class.getName()).log(Level.SEVERE, null, ex);
            }    
            }
            System.out.println("A");
        }
    }
    
    private void cambiarImagen() {
        int progressBar = gestorImagen.getPorcentaje(indexImg);
        String ruta = gestorImagen.getImagenIndex(indexImg);
        visorImagen.cambiarImagen(ruta, progressBar);
        indexImg = (indexImg < gestorImagen.getSize() - 1) ? indexImg + 1 : 0;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "detenerBtn":
                detenido = true; // detener el hilo estableciendo la bandera en true
                visorImagen.btnDetener.setEnabled(false);
                visorImagen.btnContinuar.setEnabled(true);
                break;
            case "continuarBtn":
                detenido = false; // reanudar el hilo estableciendo la bandera en false
                visorImagen.btnDetener.setEnabled(true);
                visorImagen.btnContinuar.setEnabled(false);
                break;
            case "salirBtn":
                visorImagen.setVisible(false);
                visorImagen.dispose();
                break;
        }
    }

    private void iniciarVista() {
        visorImagen.setTitle("Visor Imagene");
        visorImagen.setVisible(true);
        visorImagen.setLocationRelativeTo(null);
        visorImagen.setDefaultCloseOperation(0);
        visorImagen.btnContinuar.addActionListener(this);
        visorImagen.btnDetener.addActionListener(this);
        visorImagen.btnSalir.addActionListener(this);
        
    }
    
    
}
