/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Model.Imagen;
import Vista.VisorImagen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Juan
 */
public class HiloVisor implements ActionListener, Runnable {

    private final Object monitor = new Object();
    private Thread t;
    private VisorImagen visorImagen;
    private GestorImagen gestorImagen;
    private int indexImg;
    private boolean detenido = false; // Bandera para detener el hilo
    private boolean enEjecucion = true;

    public HiloVisor(int index, GestorImagen gestorImagen) {
        indexImg = index;
        this.gestorImagen = gestorImagen;

        t = new Thread(this);
        visorImagen = new VisorImagen();
    }

    @Override
    public void run() {
        
        while (enEjecucion) { // Bucle hasta que se detenga el hilo
            
            synchronized (monitor) { // Usa un objeto monitor para bloquear hilo en entorno sincronizado
                if (detenido) {
                    try {
                        monitor.wait(); // Espera aquí hasta que se notifique
                    } catch (InterruptedException ex) {
                        Logger.getLogger(HiloVisor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            
            cambiarImagen();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloVisor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void cambiarImagen() {
        int progressBar = gestorImagen.getPorcentaje(indexImg);
        
        Imagen img = gestorImagen.getImagenIndex(indexImg);
        
        visorImagen.cambiarImagen(img.getIcono(), progressBar);
        
        // Se actualiza el valor del próximo indice
        indexImg = (indexImg < gestorImagen.getSize() - 1) ? indexImg + 1 : 0;
        
        visorImagen.mensajeConsola(img.getRutaImagen());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        // Manejo de eventos
        switch (e.getActionCommand()) {
            case "detenerBtn":
                
                detenido = true; // detener el hilo estableciendo la bandera en true
                visorImagen.ventanaEmergente("Pausar ejecución Hilo ID: " + t.threadId());
                visorImagen.btnDetener.setEnabled(false);
                visorImagen.btnContinuar.setEnabled(true);

                break;

            case "continuarBtn":
                visorImagen.ventanaEmergente("Hilo ID: " + t.threadId() + ". ¿Está vivo?: " + Thread.currentThread().isAlive() + "\n"
                                            + "Continua ejecución de hilo " + t.threadId());
                synchronized (monitor) {
                    detenido = false; // Reanudar el hilo estableciendo la bandera en false
                    monitor.notify();
                }

                visorImagen.btnDetener.setEnabled(true);
                visorImagen.btnContinuar.setEnabled(false);
                break;
            case "salirBtn":
                enEjecucion=false;
                visorImagen.ventanaEmergente("Ejecución terminada Hilo ID: " + t.threadId());
                
                visorImagen.setVisible(false);
                visorImagen.dispose();
                break;
        }
    }

    public void iniciarVista() {
        
        
        visorImagen.mensajeConsola("Imagen seleccionada: " + gestorImagen.getImagenIndex(indexImg).getRutaImagen() + "\n"
                                    + "Hilo a ejecutar: " + t.getName());
        
        visorImagen.setTitle("Visor Imagenes");
        visorImagen.setVisible(true);
        visorImagen.setLocationRelativeTo(null);
        visorImagen.setDefaultCloseOperation(0);
        visorImagen.btnContinuar.addActionListener(this);
        visorImagen.btnDetener.addActionListener(this);
        visorImagen.btnSalir.addActionListener(this);
        visorImagen.setDefaultCloseOperation(0);
        
        t.start();
    }

    public Thread getHilo() {
        return t;
    }

}
