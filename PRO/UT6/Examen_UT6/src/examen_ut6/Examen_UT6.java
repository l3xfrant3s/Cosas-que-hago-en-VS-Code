package examen_ut6;

import java.util.HashSet;

public class Examen_UT6 {
    
    public static void main(String[] args) {
        Electrodomestico lavavajillas = new Electrodomestico("sunsun", "Gris", 'D', 53.54);
        lavavajillas.aniadirCaracteristica("Modo Noche");
        lavavajillas.aniadirCaracteristica("Modo Noche");
        lavavajillas.aniadirCaracteristica("Modo Rápido");
        lavavajillas.aniadirCaracteristica("Bajo consumo de agua");
        System.out.println(lavavajillas);
        
        Electrodomestico lavadora = new Electrodomestico("felipes", "grih", '2', 35);
        lavadora.aniadirCaracteristica("Centrifugado");
        lavadora.aniadirCaracteristica("Modo Eco");
        System.out.println(lavadora);
        
        Electrodomestico lavadora1 = new Electrodomestico("felipes1", "Gris", 'A', 35);
        System.out.println(lavadora1);
        Electrodomestico lavadora2 = new Electrodomestico("felipes2", "Rojo", 'A', 35);
        Electrodomestico lavadora3 = new Electrodomestico("felipes3", "Azul", 'B', 35);
        lavadora3.aniadirCaracteristica("Modo Eco");
        Electrodomestico lavadora4 = new Electrodomestico("felipes4", "Gris", 'C', 35);
        lavadora4.aniadirCaracteristica("Modo Noche");
        Electrodomestico lavadora5 = new Electrodomestico("felipes5", "Negro", 'E', 35);
        Electrodomestico lavadora6 = new Electrodomestico("felipes6", "Blanco", 'C', 35);
        Electrodomestico lavadora7 = new Electrodomestico("felipes7", "Rojo", 'C', 35);
        Electrodomestico lavadora8 = new Electrodomestico("felipes8", "Azul", 'D', 35);
        Electrodomestico lavadora9 = new Electrodomestico("felipes9", "Blanco", 'D', 35);
        lavadora9.aniadirCaracteristica("Modo Noche");
        Electrodomestico lavadoraA = new Electrodomestico("felipesA", "Rojo", 'F', 35);
        
        Empresa ejemplar = new Empresa("Lavanderías Cano", "A12345678", "Calle Estrecha Nº3");
        System.out.println(ejemplar.aniadirElectrodomestico(lavadora)?"Se añadió correctamente":"Ya existe");
        System.out.println(ejemplar.aniadirElectrodomestico(lavadora1)?"Se añadió correctamente":"Ya existe");
        System.out.println(ejemplar.aniadirElectrodomestico(lavadora2)?"Se añadió correctamente":"Ya existe");
        System.out.println(ejemplar.aniadirElectrodomestico(lavadora3)?"Se añadió correctamente":"Ya existe");
        System.out.println(ejemplar.aniadirElectrodomestico(lavadora4)?"Se añadió correctamente":"Ya existe");
        System.out.println(ejemplar.aniadirElectrodomestico(lavadora5)?"Se añadió correctamente":"Ya existe");
        System.out.println(ejemplar.aniadirElectrodomestico(lavadora6)?"Se añadió correctamente":"Ya existe");
        System.out.println(ejemplar.aniadirElectrodomestico(lavadora7)?"Se añadió correctamente":"Ya existe");
        System.out.println(ejemplar.aniadirElectrodomestico(lavadora8)?"Se añadió correctamente":"Ya existe");
        System.out.println(ejemplar.aniadirElectrodomestico(lavadora9)?"Se añadió correctamente":"Ya existe");
        System.out.println(ejemplar.aniadirElectrodomestico(lavadoraA)?"Se añadió correctamente":"Ya existe");
        System.out.println(ejemplar.aniadirElectrodomestico(lavadora)?"Se añadió correctamente":"Ya existe");
        System.out.println(ejemplar.aniadirElectrodomestico(lavadora5)?"Se añadió correctamente":"Ya existe");
        System.out.println(ejemplar);
        
        System.out.println("Hay "+ejemplar.cuantosDeCaracteristica("Modo Noche")+" lavadoras con la caracteristica "+ "Modo Noche");
        System.out.println("Hay "+ejemplar.cuantosDeCaracteristica("Modo Lento")+" lavadoras con la caracteristica "+ "Modo Lento");
        
        ejemplar.cuantosPorConsumo();
        
        HashSet<Electrodomestico> azules = ejemplar.borrarDeColor("Azul");
        for(Electrodomestico elec: azules){
        System.out.println(elec);
        }
    }
}