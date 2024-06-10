/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenut10afr;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * @author l3xfrant3s
 */
public class Lamina extends JPanel{
    private PanelEste panelEste;
    private PanelOeste panelOeste;
    private LaminaTexto panelCentro;
    private BarraMenu barraMenu;
    public Lamina(){
        setLayout(new BorderLayout());
        panelCentro = new LaminaTexto("Alexis", 50, Color.BLACK, Color.YELLOW);
        add(panelCentro, BorderLayout.CENTER);
        panelOeste = new PanelOeste();
        add(panelOeste, BorderLayout.WEST);
        panelEste = new PanelEste();
        add(panelEste, BorderLayout.EAST);
    }
    
    class PanelOeste extends JPanel{
        private JSlider control;
        private EventoJSliderTamano evTamano = new EventoJSliderTamano();
        private EventoJSliderColor evColor = new EventoJSliderColor();
        private EventoJSliderFondo evFondo = new EventoJSliderFondo();
        public PanelOeste(){
            control = new JSlider(JSlider.VERTICAL);
            control.setMajorTickSpacing(25);
            control.setMinorTickSpacing(5);
            control.setPaintTicks(true);
            control.setPaintLabels(true);
            control.addChangeListener(evTamano);
            add(control);
        }
        private class EventoJSliderTamano implements ChangeListener{
            public void stateChanged(ChangeEvent e) {
                panelCentro.setTamanoTexto(control.getValue());
            }
        }
        private class EventoJSliderColor implements ChangeListener{
            public void stateChanged(ChangeEvent e) {
                panelCentro.setColorTexto(new Color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255)));
            }
        }
        private class EventoJSliderFondo implements ChangeListener{
            public void stateChanged(ChangeEvent e) {
                panelCentro.setColorFondo(new Color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255)));
            }
        }
        public void setVisible(boolean esVisible){
            control.setVisible(esVisible);
        }
        public void setListenerTamano(){
            control.removeChangeListener(evColor);
            control.removeChangeListener(evFondo);
            control.addChangeListener(evTamano);
        }
        public void setListenerColor(){
            control.removeChangeListener(evTamano);
            control.removeChangeListener(evFondo);
            control.addChangeListener(evColor);
        }
        public void setListenerFondo(){
            control.removeChangeListener(evTamano);
            control.removeChangeListener(evColor);
            control.addChangeListener(evFondo);
        }
    }
    

    class PanelEste extends JPanel{
        private String[] vec={"Tamaño","Color","Fondo"};
        private JComboBox opcionesSlider;
        private JButton salir;
        public PanelEste(){
            setLayout(new GridLayout(6, 1));
            opcionesSlider = new JComboBox();
            opcionesSlider.addItem("Tamaño");
            opcionesSlider.addItem("Color");
            opcionesSlider.addItem("Fondo");
            opcionesSlider.addActionListener(new EventoJComboBox());
            salir = new JButton();
            add(new JPanel());
            add(opcionesSlider);
            add(new JPanel());
            add(new JPanel());
            add(new JPanel());
            add(new JPanel());
        }
        private class EventoJComboBox implements ActionListener{
    
        public void actionPerformed(ActionEvent e){
            if((String)opcionesSlider.getSelectedItem() == vec[0]) {
                panelOeste.setListenerTamano();
            }
            if((String)opcionesSlider.getSelectedItem() == vec[1]) {
                panelOeste.setListenerColor();
            }
            if((String)opcionesSlider.getSelectedItem() == vec[2]) {
                panelOeste.setListenerFondo();
            }
        }
    }
    }
    
    class PanelBarraMenu extends JPanel{
        public PanelBarraMenu(){
            
        }
    }
    
    class BarraMenu extends JMenuBar implements ActionListener, MenuListener{
        private JMenu slider;
        private JMenuItem visible, noVisible;
        
        public BarraMenu(){
            slider = new JMenu("Slider");
            visible = new JMenuItem("Visible");
            noVisible = new JMenuItem("No visible");
            
            add(slider);
            slider.add(visible);
            slider.add(noVisible);
            
            slider.addMenuListener(this);
            visible.addActionListener(this);
            noVisible.addActionListener(this);
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==visible) panelOeste.setVisible(true);
            if (e.getSource()==noVisible) panelOeste.setVisible(false);
        }
        @Override
        public void menuDeselected(MenuEvent e) {}

        @Override
        public void menuCanceled(MenuEvent e) {}

        @Override
        public void menuSelected(MenuEvent e) {}
    }
}
