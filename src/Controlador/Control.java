/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.VentanaPrincipal;

/**
 *
 * @author cesar
 */
public class Control {
    private VentanaPrincipal view;

    public Control() {
        view = new VentanaPrincipal();
        iniciarVista();
    }
    
    private void iniciarVista(){
        view.setVisible(true);
        view.setLocationRelativeTo(null);
    }
    
}
