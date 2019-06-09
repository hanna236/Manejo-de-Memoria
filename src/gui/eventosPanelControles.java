/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import memoria.controlMemoria;
import modelo.objetoMemoria;

/**
 *
 * @author usuario
 */
public class eventosPanelControles {
    
    public static void eventoCreaTabla(JButton btn,JTextField txt){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] texto = txt.getText().split(",");
                PanelDibujo.original = new ArrayList<>();
                PanelDibujo.editado = new ArrayList<>();
                for(int i=0;i<texto.length;i++){
                    if(texto[i].contains("_")){
                        PanelDibujo.original.add(new objetoMemoria(Integer.parseInt(texto[i].replace("_", "").trim()), false));
                        PanelDibujo.editado.add(new objetoMemoria(Integer.parseInt(texto[i].replace("_", "").trim()), false));
                    }else{
                        PanelDibujo.original.add(new objetoMemoria(Integer.parseInt(texto[i].replace("_", "").trim()), true));
                        PanelDibujo.editado.add(new objetoMemoria(Integer.parseInt(texto[i].replace("_", "").trim()), true));
                    }
                }
                PanelDibujo.getPanelDibujo().repaint();
            }
        });
    } 
    
    public static void eventoAgregaMemoria(JButton btn,JTextField txt,JList lista){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String valor="";
                try{
                valor = lista.getSelectedValue().toString().trim();
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "seleccione un tipo de asignacion");
                }
                controlMemoria c = new controlMemoria();
                if(valor.toLowerCase().equals("first fit".toLowerCase())){
                    System.out.println("1");
                    c.firstFit(Integer.parseInt(txt.getText().trim()));
                }else if(valor.toLowerCase().equals("next fit".toLowerCase())){
                    System.out.println("1");
                    c.nextFit(Integer.parseInt(txt.getText().trim()));
                }else if(valor.toLowerCase().equals("worst fit".toLowerCase())){
                    System.out.println("1");
                    c.worstFit(Integer.parseInt(txt.getText().trim()));
                }else if(valor.toLowerCase().equals("best fit".toLowerCase())){
                    System.out.println("1");
                    c.bestFit(Integer.parseInt(txt.getText().trim()));
                }
                else{
                    JOptionPane.showMessageDialog(null, "seleccione un tipo de asignacion");
                }
                
            }
        });
    } 
    
}

