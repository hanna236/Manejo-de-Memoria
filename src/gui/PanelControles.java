/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author usuario
 */
public class PanelControles extends JPanel{
    
    public PanelControles(){
        

        this.setLayout(null);
        
        this.setSize(800, 900);
        this.setLocation(0, 0);
        
        JLabel ori = new JLabel("Original");
        ori.setSize(150, 40);
        ori.setLocation(330, 1);
        JLabel mod = new JLabel("Modificado");
        mod.setSize(150, 40);
        mod.setLocation(580, 1);
        
        JLabel titulo1 = new JLabel("Crear:");
        titulo1.setSize(150, 40);
        titulo1.setLocation(30, 80);
        
        JTextField inicial = new JTextField();
        inicial.setSize(150, 40);
        inicial.setLocation(30, 130);
        
        JButton crear = new JButton("Crear");
        crear.setSize(150, 40);
        crear.setLocation(30, 180);
        
        JLabel titulo2 = new JLabel("Agregar:");
        titulo2.setSize(150, 40);
        titulo2.setLocation(30, 230);
        
        DefaultListModel model = new DefaultListModel();
        model.addElement("first fit");
        model.addElement("best fit");
        model.addElement("worst fit");
        model.addElement("next fit");
        JList lista = new JList(model);
        lista.setSize(150, 100);
        lista.setLocation(30, 280);
        
        JTextField tam = new JTextField();
        tam.setSize(70, 40);
        tam.setLocation(30, 390);
        
        JButton agregar = new JButton("Agregar");
        agregar.setSize(80, 40);
        agregar.setLocation(110, 390);
        
        eventosPanelControles.eventoCreaTabla(crear, inicial);
        eventosPanelControles.eventoAgregaMemoria(agregar, tam, lista);
        
        this.add(titulo1);
        this.add(inicial);
        this.add(crear);
        this.add(lista);
        this.add(titulo2);
        this.add(tam);
        this.add(agregar);
        this.add(ori);
        this.add(mod);
        

    }
       
}
