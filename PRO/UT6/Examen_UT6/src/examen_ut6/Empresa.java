package examen_ut6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Empresa {
    private String nombre, NIF, direccion;
    private ArrayList<Electrodomestico> electrodomesticos;
    
    public Empresa(String nombre, String NIF, String direccion){
        this.nombre = nombre;
        this.NIF = NIF;
        this.direccion = direccion;
        this.electrodomesticos = new ArrayList<>();
    }
    
    public boolean aniadirElectrodomestico(Electrodomestico porAniadir){
        if (electrodomesticos.contains(porAniadir))return false;
        electrodomesticos.add(porAniadir);
        return true;
    }
      
    public int cuantosDeCaracteristica(String carac){
        int cuantos = 0;
        for(Electrodomestico aComprobar:electrodomesticos){
            for(int i = 0; i < aComprobar.getCuantas(); i++){
                if(aComprobar.getEcologico()[i].equals(carac)) cuantos++;
            }
        }
        return cuantos;
    }
    
    public HashSet<Electrodomestico> borrarDeColor(String aBorrar){
        HashSet<Electrodomestico> borrados = new HashSet<>();
        Iterator<Electrodomestico> iter = electrodomesticos.iterator();
        int pos = 0;
        while(iter.hasNext()){      
            if(iter.next().getColor().equals(aBorrar)){
                Electrodomestico aux = electrodomesticos.remove(pos);
                pos--;
                borrados.add(aux);
            }
            pos++;
        }
        return borrados;
    }
    
    public void cuantosPorConsumo(){
        int[] cuantos = new int[6];
        for(Electrodomestico aComprobar:electrodomesticos){
            switch(aComprobar.getConsumo()){
                case 'A':cuantos[0]++;break;
                case 'B':cuantos[1]++;break;
                case 'C':cuantos[2]++;break;
                case 'D':cuantos[3]++;break;
                case 'E':cuantos[4]++;break;
                case 'F':cuantos[5]++;break;
            }
        }
        System.out.printf("A-%d; B-%d; C-%d; D-%d; E-%d; F-%d;\n",
        cuantos[0], cuantos[1], cuantos[2], cuantos[3], cuantos[4], cuantos[5]);
    }
    
    @Override
    public String toString(){
        String aDevolver = "Empresa "+nombre+" con NIF "+NIF+" en "+direccion+
                " tiene los siguientes electrodomesticos:";
        for(Electrodomestico aComprobar:electrodomesticos){
            aDevolver += "\n\n"+aComprobar.toString();
        }
        return aDevolver;
    }
}