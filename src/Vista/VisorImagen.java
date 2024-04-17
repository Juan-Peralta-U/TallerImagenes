/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author cesar
 */
public class VisorImagen extends javax.swing.JFrame {

    /**
     * Creates new form VisorImagen1
     */
    public VisorImagen() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barraProgreso = new javax.swing.JProgressBar();
        labImagen = new javax.swing.JLabel();
        btnDetener = new javax.swing.JButton();
        btnContinuar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        barraProgreso.setFont(new java.awt.Font("Dubai Medium", 0, 10)); // NOI18N
        barraProgreso.setForeground(new java.awt.Color(0, 0, 0));
        barraProgreso.setToolTipText("");
        barraProgreso.setValue(40);
        barraProgreso.setStringPainted(true);

        btnDetener.setBackground(new java.awt.Color(255, 204, 102));
        btnDetener.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        btnDetener.setForeground(new java.awt.Color(7, 39, 29));
        btnDetener.setText("Detener");
        btnDetener.setActionCommand("detenerBtn");
        btnDetener.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));

        btnContinuar.setBackground(new java.awt.Color(255, 204, 102));
        btnContinuar.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        btnContinuar.setForeground(new java.awt.Color(7, 39, 29));
        btnContinuar.setText("Continuar");
        btnContinuar.setActionCommand("continuarBtn");
        btnContinuar.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));
        btnContinuar.setEnabled(false);

        btnSalir.setBackground(new java.awt.Color(255, 204, 102));
        btnSalir.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(7, 39, 29));
        btnSalir.setText("Salir");
        btnSalir.setActionCommand("salirBtn");
        btnSalir.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(barraProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(labImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnDetener, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(barraProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDetener, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    public void cambiarImagen(ImageIcon img, int valorPB){ // valor Progress Bar
        int tamaño = 500;
        
        // Se esacala la imagen al tamaño deseado
        Image imagenEscalada = img.getImage().getScaledInstance(tamaño, tamaño, Image.SCALE_SMOOTH);

        img = new ImageIcon(imagenEscalada);
        
        labImagen.setIcon(img); 
        
        // Se cambia el progreso de la barra de progreso
        barraProgreso.setValue(valorPB);
        labImagen.revalidate();
        labImagen.repaint();
    }
    
    public void mensajeConsola(String msj){
        System.out.println(msj);
    }
    
    public void ventanaEmergente(String msj){
        JOptionPane.showMessageDialog(null, msj);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JProgressBar barraProgreso;
    public javax.swing.JButton btnContinuar;
    public javax.swing.JButton btnDetener;
    public javax.swing.JButton btnSalir;
    public javax.swing.JLabel labImagen;
    // End of variables declaration//GEN-END:variables
}
