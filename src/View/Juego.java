/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.AWTException;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 *
 * @author uuse
 */
public class Juego extends javax.swing.JFrame {

    
    int posX;
    int posY;
    Color colorObstaculo;
    public Juego() {
        
        initComponents();
        this.colorObstaculo = Obs1.getBackground();
        this.posX = gallina.getX();
        this.posY = gallina.getY() ; 
    }

    
    public int getPosX(){
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    
    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void avanzarGallina(int aumentoY) {
        this.posY += aumentoY;
        gallina.setLocation(posX, posY);
        /*int derecha = gallina.getX();
        int izq = gallina.getY();
        
        if(evt.getKeyChar() == 'a'){
        derecha += 5;
        gallina.setLocation(derecha, izq);
        }
        
        if (evt.getKeyChar() == 's'){
        izq -=5;
        gallina.setLocation(derecha, izq);
        }*/
    }
    /*Como saber si me voy a la derecha o a la izquierda?*/
   /* pubic void izquierda(){
        
    }*/
    public void detectarObs(){
        int posObs1Y = Obs1.getY();
        int posGallinaY = gallina.getY();
        int distancia =  posGallinaY - Obs1.getY();
        int distancia2 =  posGallinaY- Obs2.getY();
        
        if (distancia <= 30 && distancia >=25){
             System.out.println("Esta cerca un objeto 111!!! =========================" + distancia);
             decidirDireccion(Obs1);
        }
           
        else
            System.out.println("Avance" + distancia);
        
        if (distancia2 <= 30 && distancia2 >= 25){
            System.out.println("Esta cerca un objeto 111!!! =========================" + distancia2);
            decidirDireccion(Obs2);
        }
        
        else
            System.out.println("Avance" + distancia2);
            
    }
    public void decidirDireccion(JPanel obstaculo){
        int posObstX = obstaculo.getX();
        if (posObstX == 0)
            System.out.println("Debes irte para la derecha");
        else 
            System.out.println("Debes irte para la izquierda");
        
    }
    
    public void moverDerecha(){
        
    }
    
    public void moverIzquierda(){
        
    }

    
    public void verificarMeta() throws AWTException{
       
        
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        Meta = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Obs1 = new javax.swing.JPanel();
        Obs2 = new javax.swing.JPanel();
        Obs3 = new javax.swing.JPanel();
        gallina = new javax.swing.JLabel();
        puntero = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setForeground(new java.awt.Color(255, 255, 255));

        Meta.setBackground(new java.awt.Color(0, 144, 21));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("META");

        javax.swing.GroupLayout MetaLayout = new javax.swing.GroupLayout(Meta);
        Meta.setLayout(MetaLayout);
        MetaLayout.setHorizontalGroup(
            MetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MetaLayout.createSequentialGroup()
                .addGap(263, 263, 263)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MetaLayout.setVerticalGroup(
            MetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MetaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("INICIO");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(263, 263, 263)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Obs1.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout Obs1Layout = new javax.swing.GroupLayout(Obs1);
        Obs1.setLayout(Obs1Layout);
        Obs1Layout.setHorizontalGroup(
            Obs1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        Obs1Layout.setVerticalGroup(
            Obs1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 17, Short.MAX_VALUE)
        );

        Obs2.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout Obs2Layout = new javax.swing.GroupLayout(Obs2);
        Obs2.setLayout(Obs2Layout);
        Obs2Layout.setHorizontalGroup(
            Obs2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 352, Short.MAX_VALUE)
        );
        Obs2Layout.setVerticalGroup(
            Obs2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );

        Obs3.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout Obs3Layout = new javax.swing.GroupLayout(Obs3);
        Obs3.setLayout(Obs3Layout);
        Obs3Layout.setHorizontalGroup(
            Obs3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 174, Short.MAX_VALUE)
        );
        Obs3Layout.setVerticalGroup(
            Obs3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        gallina.setBackground(new java.awt.Color(255, 51, 51));
        gallina.setForeground(new java.awt.Color(255, 0, 0));
        gallina.setText("G");

        puntero.setText("pun");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Meta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGap(0, 291, Short.MAX_VALUE)
                .addComponent(Obs2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Obs3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Obs1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addComponent(puntero))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(287, 287, 287)
                        .addComponent(gallina, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(Meta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(Obs3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(Obs2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95)
                .addComponent(Obs1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(puntero)
                .addGap(34, 34, 34)
                .addComponent(gallina)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        int variableX = gallina.getX();
        int variableY = gallina.getY();
        detectarObs();
        switch (evt.getKeyChar()){
            case 'a':
                variableX -= 5;
                break;
            case 'w':
                variableY -= 5;
                break;
            case 's':
                variableY += 5;
                break;
                
            case 'd':
                variableX += 5;
                break;
                
        }
        gallina.setLocation(variableX, variableY);
        setPosX(variableX);
        setPosY(variableY);
        /*System.out.println(String.format("Obs1 la medida de x es %d y el de y es %d", Obs1.getX(), Obs1.getY()));
         System.out.println(String.format("Obs2 la medida de x es %d y el de y es %d", Obs2.getX(), Obs2.getY()));
        System.out.println(String.format("Gallina de x es %d y el de y es %d", gallina.getX(), gallina.getY()));
        System.out.println(String.format("obs1 el largo %d y el ancho %d", Obs1.getWidth(), Obs1.getHeight()));*/
        variableY-=20;
       // puntero.setLocation(variableX, variableY);
        
        try {
            verificarMeta();
        } catch (AWTException ex) {
            Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Juego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Meta;
    private javax.swing.JPanel Obs1;
    private javax.swing.JPanel Obs2;
    private javax.swing.JPanel Obs3;
    private javax.swing.JLabel gallina;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel puntero;
    // End of variables declaration//GEN-END:variables
}
