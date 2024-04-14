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
public class HiloVisor implements ActionListener, Runnable {

    private final Object monitor = new Object();
    private Thread t;
    private VisorImagen visorImagen;
    private GestorImagen gestorImagen;
    private int indexImg;
    private boolean detenido = false; // bandera para detener el hilo
    private boolean enEjecucion = true;

    public HiloVisor(int index, GestorImagen gestorImagen) {
        indexImg = index;
        this.gestorImagen = gestorImagen;
        visorImagen = new VisorImagen();
        iniciarVista();

        t = new Thread(this);
        t.start();
        
    }

    @Override
    public void run() {
        visorImagen.ventanaEmergente("Imagen seleccionada: " + gestorImagen.getImagenIndex(indexImg) + "\n"
                                    + "ID del Hilo a ejecutar: " + Thread.currentThread().getId());
        while (enEjecucion) { // bucle hasta que se detenga el hilo
            
            synchronized (monitor) {
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
        String ruta = gestorImagen.getImagenIndex(indexImg);
        visorImagen.cambiarImagen(ruta, progressBar);
        indexImg = (indexImg < gestorImagen.getSize() - 1) ? indexImg + 1 : 0;
        visorImagen.mensajeConsola(ruta);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case "detenerBtn":
                
                detenido = true; // detener el hilo estableciendo la bandera en true
                visorImagen.ventanaEmergente("Pausar ejecución Hilo ID: " + Thread.currentThread().getId());
                visorImagen.btnDetener.setEnabled(false);
                visorImagen.btnContinuar.setEnabled(true);

                break;

            case "continuarBtn":
                visorImagen.ventanaEmergente("Hilo ID: " + Thread.currentThread().threadId() + ". ¿Está vivo?: " + Thread.currentThread().isAlive() + "\n"
                                            + "Continua ejecución de hilo " + Thread.currentThread().getId());
                synchronized (monitor) {
                    detenido = false; // reanudar el hilo estableciendo la bandera en false
                    monitor.notify();
                }

                visorImagen.btnDetener.setEnabled(true);
                visorImagen.btnContinuar.setEnabled(false);
                break;
            case "salirBtn":
                enEjecucion=false;
                visorImagen.ventanaEmergente("Ejecución terminada Hilo ID: " + Thread.currentThread().getId());
                
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
        visorImagen.setDefaultCloseOperation(0);
    }

}
