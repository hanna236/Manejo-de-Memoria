/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.JFrame;

/**
 *
 * @author usuario
 */
public class Frame extends JFrame{
    
    public Frame(){
        this.setLayout(null);
        PanelControles p = new PanelControles();
        PanelDibujo pd = PanelDibujo.getPanelDibujo();
        this.setSize(800,600);
        this.setLocation(15, 15);
        this.add(p);
        this.add(pd);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
}
