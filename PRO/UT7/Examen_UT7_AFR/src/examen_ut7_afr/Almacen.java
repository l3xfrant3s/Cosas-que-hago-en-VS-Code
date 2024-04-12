package examen_ut7_afr;

import java.util.*;


class comparadorDeZapatos implements Comparator<Zapato>{
    @Override
        public int compare(Zapato uno, Zapato dos){
            if(uno.getTalla() > dos.getTalla()) return -1;
            else if(uno.getTalla() < dos.getTalla()) return 1;
            else return 0;
        }
    }
public class Almacen{
    private String direccion, telefono;
    private ArrayList<Zapato> zapatos;
    
    public Almacen(String direccion, String telefono){
        this.direccion = direccion;
        this.telefono = telefono;
        this.zapatos = new ArrayList();
    }
    
    public boolean addZapato(Zapato aAniadir){
        if (zapatos.contains(aAniadir)){
            return false;
        }
        zapatos.add(aAniadir);
        return true;
    }
    
    public void cualesConTejido(String tejido){
        for(Zapato zapatin:zapatos){
            if(zapatin instanceof Mocasin){
                if(tejido.equals(((Mocasin)zapatin).getTejido())){
                    System.out.println(zapatin.getMarca() + " del numero " +
                        zapatin.getTalla() + ": " + zapatin.getPrecio() + "€");
                }
            }
        }
    }
    
    public void cambiarColor(String colorViejo, String colorNuevo){
        for(Zapato zapatin:zapatos){
            if(zapatin instanceof Deportiva){
                if(colorViejo.equals(zapatin.getColor()) && ((Deportiva)zapatin).getDescripcion().equals("RUNNER")){
                    zapatin.setColor(colorNuevo);
                    System.out.println("Color de " + zapatin.getMarca() + " cambiado de "
                        + colorViejo + " a " + colorNuevo);
                }
            }
        }
    }
    public void borrarPorCodigo(String codigoABorrar){
        for(Zapato zapatin:zapatos){
            if(zapatin.getCodigo().equals(codigoABorrar)){
                char tipo = 'a';
                if(zapatin instanceof Deportiva) tipo = 'D';
                else if(zapatin instanceof Mocasin) tipo = 'M';
                else tipo = 'S';
                
                switch(tipo){
                    case 'D': System.out.println("Se va a eliminar la siguiente deportiva:\n" +
                        zapatin.toString());
                    case 'M':System.out.println("Se va a eliminar el siguiente mocasin:\n" +
                        zapatin.toString());
                    case 'S':System.out.println("Se va a eliminar la siguiente sandalia:\n" +
                        zapatin.toString());
                }
                zapatos.remove(zapatin);
                break;
            }
        }
    }
    
    public void ordenar(){
        ArrayList<Zapato> zapatosOrdenados = new ArrayList();
        Collections.copy(zapatosOrdenados, zapatos);
        Collections.sort(zapatosOrdenados, new comparadorDeZapatos());
        for(Zapato zapatin:zapatos){
            System.out.println(zapatin.toString());
        }
    }
    
    public ArrayList<Zapato> vendidos(){
        ArrayList<Zapato> zapatosVendidos = new ArrayList();
        for(Zapato zapatin:zapatos){
            if(zapatin.getVendido()){
                zapatosVendidos.add(zapatin);
            }
        }
        return zapatosVendidos;
    }
}