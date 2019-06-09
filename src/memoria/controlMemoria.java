/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoria;

import gui.PanelDibujo;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import modelo.objetoMemoria;

/**
 *
 * @author usuario
 */
public class controlMemoria {
    public static int ultimo=-1;
    /*
    
    _1,_2,_3,_4,_5,_6
    _3,_4,_1,_2,_5,_6
     */
    public void firstFit(int tam) {
        boolean ok = false;
        ArrayList<objetoMemoria> aux = new ArrayList();
        for (int i = 0; i < PanelDibujo.editado.size(); i++) {
            if (!ok) {
                if (!PanelDibujo.editado.get(i).isLleno()) {
                    if (PanelDibujo.editado.get(i).getTam() >= tam) {
                        aux.add(new objetoMemoria(tam, true));
                        if (PanelDibujo.editado.get(i).getTam() - tam > 0) {
                            aux.add(new objetoMemoria(PanelDibujo.editado.get(i).getTam() - tam, false));
                        }
                        ok = true;
                        ultimo=i;
                    } else {
                        aux.add(PanelDibujo.editado.get(i));
                    }
                } else {
                    aux.add(PanelDibujo.editado.get(i));
                }
            } else {
                aux.add(PanelDibujo.editado.get(i));
            }
        }
        if (ok) {
            PanelDibujo.editado = aux;
            PanelDibujo.panel.repaint();
        } else {
            JOptionPane.showMessageDialog(null, "no hay espacio");
        }

    }

    public void worstFit(int tam) {
        boolean ok = false;
        boolean espacio = false;
        ArrayList<objetoMemoria> aux = new ArrayList();
        for (int i = 0; i < PanelDibujo.editado.size(); i++) {
            if (!ok) {
                if (!PanelDibujo.editado.get(i).isLleno()) {
                    if (PanelDibujo.editado.get(i).getTam() >= tam) {
                        espacio = true;
                        Random r = new Random();
                        int valor = r.nextInt(4);
                        if (valor == 1) {
                            aux.add(new objetoMemoria(tam, true));
                            if (PanelDibujo.editado.get(i).getTam() - tam > 0) {
                                aux.add(new objetoMemoria(PanelDibujo.editado.get(i).getTam() - tam, false));
                            }
                            ultimo=i;
                            ok = true;
                        } else {
                            aux.add(PanelDibujo.editado.get(i));
                        }

                    } else {
                        aux.add(PanelDibujo.editado.get(i));
                    }
                } else {
                    aux.add(PanelDibujo.editado.get(i));
                }
            } else {
                aux.add(PanelDibujo.editado.get(i));
            }
        }
        if (ok) {
            PanelDibujo.editado = aux;
            PanelDibujo.panel.repaint();
        } else if (!espacio) {
            JOptionPane.showMessageDialog(null, "no hay espacio");
        }

        if (espacio && !ok) {
            worstFit(tam);
        }

    }

    public void bestFit(int tam) {
        boolean ok = false;
        int indice = -1;
        int dif = 100000000;
        ArrayList<objetoMemoria> aux = new ArrayList();
        for (int i = 0; i < PanelDibujo.editado.size(); i++) {
            if (!ok) {
                if (!PanelDibujo.editado.get(i).isLleno()) {
                    if (PanelDibujo.editado.get(i).getTam() >= tam) {

                        if (PanelDibujo.editado.get(i).getTam() - tam < dif) {
                            dif = PanelDibujo.editado.get(i).getTam() - tam;
                            indice = i;
                        }

                    }
                } 
            }
        }

        for (int i = 0; i < PanelDibujo.editado.size(); i++) {
            if (i == indice) {
                aux.add(new objetoMemoria(tam, true));
                if (PanelDibujo.editado.get(i).getTam() - tam > 0) {
                    aux.add(new objetoMemoria(PanelDibujo.editado.get(i).getTam() - tam, false));
                }
                ultimo=i;
                ok = true;
            }else{
                aux.add(PanelDibujo.editado.get(i));
            }
        }

        if (ok) {
            PanelDibujo.editado = aux;
            PanelDibujo.panel.repaint();
        } else {
            JOptionPane.showMessageDialog(null, "no hay espacio");
        }

    }
    
    public void nextFit(int tam) {
        boolean ok = false;
        ArrayList<objetoMemoria> aux = new ArrayList();


        for (int i = 0; i < PanelDibujo.editado.size(); i++) {
            if (!ok && i>=ultimo) {
                if (!PanelDibujo.editado.get(i).isLleno()) {
                    if (PanelDibujo.editado.get(i).getTam() >= tam) {
                        aux.add(new objetoMemoria(tam, true));
                        if (PanelDibujo.editado.get(i).getTam() - tam > 0) {
                            aux.add(new objetoMemoria(PanelDibujo.editado.get(i).getTam() - tam, false));
                        }
                        ok = true;
                        ultimo=i;
                    } else {
                        aux.add(PanelDibujo.editado.get(i));
                    }
                } else {
                    aux.add(PanelDibujo.editado.get(i));
                }
            } else {
                aux.add(PanelDibujo.editado.get(i));
            }
        }

        if (ok) {
            PanelDibujo.editado = aux;
            PanelDibujo.panel.repaint();
        } else {
            firstFit(tam);
        }

    }

}
