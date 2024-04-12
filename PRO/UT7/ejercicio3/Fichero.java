package PRO.UT7.ejercicio3;

public class Fichero implements Comparable<Fichero>{
    private String titulo;
    private int tamanio;

    public Fichero(String titulo, int tamanio){
        this.titulo = titulo;
        this.tamanio = tamanio;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getTamanio() {
        return tamanio;
    }

    public int compareTo(Fichero otro){
        if (this.tamanio == otro.getTamanio())
			return 0;
		if (this.tamanio < otro.getTamanio())
			return -1;
		return 1;
    }

    public void display(){
        System.out.println(titulo+"    "+tamanio+" bytes");
    }
}