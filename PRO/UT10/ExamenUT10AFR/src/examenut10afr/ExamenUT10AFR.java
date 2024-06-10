/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examenut10afr;

import examenut10afr.Lamina.BarraMenu;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;

/**
 *
 * @author l3xfrant3s
 */
public class ExamenUT10AFR extends JFrame{
    public static void main(String[] args) {        
        Marco marco=new Marco();
        marco.setVisible(true);
        marco.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
}

class Marco extends JFrame{
    
    public Marco(){
        Toolkit mipantalla=Toolkit.getDefaultToolkit();
        Dimension tamanoPantalla=mipantalla.getScreenSize();
        int alturaPantalla=tamanoPantalla.height;
        int anchoPantalla=tamanoPantalla.width;
        setTitle("Examen UT 10");
        setSize(500,350);
        setResizable(false);
        setLocation(anchoPantalla/2-250, alturaPantalla/2-175);
        Lamina nueva = new Lamina();
        add(nueva);
    }
}






