package examenut10afr;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author l3xfrant3s
 */
public class LaminaTexto extends JPanel{
    private Font fuente;
    private JLabel elTexto;
    
    public LaminaTexto(String texto, int tamanoFuente, Color color, Color fondo){
        this.fuente = new Font("Comic Sans", Font.PLAIN, tamanoFuente);
        JLabel palabraTexto = new JLabel();
        palabraTexto.setText("Texto");
        add(palabraTexto);
        elTexto = new JLabel();
        elTexto.setText(texto);
        elTexto.setFont(fuente);
        elTexto.setForeground(color);
        add(elTexto);
        setBackground(fondo);
    }
    
    public void setColorTexto(Color nuevoColor){
        elTexto.setForeground(nuevoColor);
    }
    
    public void setColorFondo(Color nuevoFondo){
        setBackground(nuevoFondo);
    }
    
    public void setTamanoTexto(int nuevoTamano){
        fuente = new Font("Comic Sans", Font.PLAIN, nuevoTamano);
        elTexto.setFont(fuente);
    }
}
