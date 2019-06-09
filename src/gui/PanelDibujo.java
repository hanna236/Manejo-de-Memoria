/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import modelo.objetoMemoria;

/**
 *
 * @author usuario
 */
public class PanelDibujo extends JPanel {

    public static PanelDibujo panel;
    public static ArrayList<objetoMemoria> original = new ArrayList<>();
    public static ArrayList<objetoMemoria> editado = new ArrayList<>();
   
  

    private PanelDibujo() {
        this.setLayout(null);
        this.setSize(800, 900);
        this.setLocation(300, 30);
        this.setBackground(Color.WHITE);
        
        
    }

    public static PanelDibujo getPanelDibujo() {
        if (panel == null) {
            panel = new PanelDibujo();
        }
        return panel;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        dibujaOriginal(g);
        dibujaEditado(g);
    }

    private void dibujaOriginal(Graphics g) {
        int x = 20;
        int y = 20;
        g.drawLine(x, y, x + 150, y);
        for (int i = 0; i < original.size(); i++) {
            y += original.get(i).getTam() * 20;
            g.drawLine(x, y, x + 150, y);
            if(original.get(i).isLleno()) {
            	g.drawString(String.valueOf(original.get(i).getTam())+"Mb", x+50, y-5);
            }else {
            g.drawString(String.valueOf(original.get(i).getTam()), x-10, y);
            g.drawString("0Mb", x+50, y-5);
        }
        }
        g.drawLine(20, 20, 20, y);
        g.drawLine(170, 20, 170, y);
    }

    private void dibujaEditado(Graphics g) {
        int x = 250;
        int y = 20;
        g.drawLine(x, y, x + 150, y);
        for (int i = 0; i < editado.size(); i++) {
            
            y += editado.get(i).getTam() * 20;
            g.drawLine(x, y, x + 150, y);
            if(editado.get(i).isLleno()){
                            g.drawString(String.valueOf(editado.get(i).getTam())+"Mb", x+50, y-5);
            }else{
                g.drawString(String.valueOf(editado.get(i).getTam()), x-10, y);
                g.drawString("0Mb", x+50, y-5);
               
            }
        }
        g.drawLine(250, 20, 250, y);
        g.drawLine(400, 20, 400, y);
    }

}
