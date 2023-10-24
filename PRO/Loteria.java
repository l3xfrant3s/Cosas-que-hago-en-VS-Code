package PRO;
import java.util.Scanner;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.RingPlot;
import org.jfree.chart.plot.SpiderWebPlot;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.plot.WaferMapPlot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.RendererUtilities;
import org.jfree.chart.renderer.WaferMapRenderer;
import org.jfree.chart.renderer.WaterfallBarRenderer;
import org.jfree.chart.renderer.WaterfallItemRenderer;
import org.jfree.chart.renderer.WaterfallXYBarRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.ShortTextTitle;
import org.jfree.chart.urls.CustomCategoryURLGenerator;
import org.jfree.chart.urls.CustomXYURLGenerator;
import org.jfree.chart.urls.StandardCategoryURLGenerator;
import org.jfree.chart.urls.StandardXYURLGenerator;
import org.jfree.chart.urls.TimeSeriesURLGenerator;
import org.jfree.chart.urls.XYURLGenerator;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.category.DefaultIntervalCategoryDataset;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.category.SlidingCategoryDataset;
import org.jfree.data.general.DefaultKeyedValues2DDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.xy.DefaultXYZDataset;
import org.jfree.data.xy.XYZDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Loteria {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);

        int cont = 0;
        System.out.println("comenzar");
        cont++;
        //System.out.print("Indique número entre el 0 y el 99999: ");
        //int numero = scanner.nextInt();
        int contador[] = new int[100000];
        int intentos = 0;
        int contador2 = 0;

        //System.out.println(numero);

        while (intentos < 200000) {
            int loteria = (int) (Math.random() * 100000);
            //System.out.println(intentos + " " + loteria);
            contador[loteria]++;
            intentos++;
        }
        for (int i = 0; i < 100000; i++){
            /*if(contador[i] > 0){
                System.out.printf("El número %05d ha salido %d ve"+(contador[i]==1?"z.\n":"ces.\n"), i, contador[i]);
            }*/
            /*if(contador[i] == 0){
                System.out.printf("El número %05d no ha salido ni una vez.\n", i);
                contador2++;
            }*/
            if(contador[i] >= 10){
                System.out.printf("El número %05d ha salido como mínimo 10 veces\n", i);
                contador2++;
            }
        }
        //System.out.println("En total no salieron "+noSalio+" numeros en "+intentos+" intentos");
        System.out.println("En total salieron "+contador2+" premiados 10 veces o más");

        /*int coste = 30000;
        int euros = contador * 3;
        int dine = coste - euros;
        System.out.println("El numero escogido ha sido " + String.format("%05d", numero));

        System.out.println("El numero de intentos ha sido " + contador + " por lo que ha tenido que gastar " + euros + " Euros para ganar 30000€");

        if (dine < 0) {
            System.out.println("Ha tenido una perdida de " + (-dine) + " euros");
        } else {
            System.out.println("Ha tenido una ganancia de " + dine + " euros");
        }

        int dias = contador * 7;
        System.out.println("Los dias que ha tardado en que coincida su numero son " + dias);
        System.out.println("Los años que tardaría en que coincida su número con el de la loteria son " + Math.round(dias / 365));*/

        // Crear un gráfico de barras
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < 100000; i++) {
            dataset.addValue(contador[i], "Veces", String.format("%05d", i));
        }
        JFreeChart chart = ChartFactory.createBarChart("Resultados de la Lotería", "Número de Lotería", "Veces", dataset, PlotOrientation.VERTICAL, false, true, false);

        // Mostrar el gráfico en una ventana
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        JFrame frame = new JFrame("Gráfico de Lotería");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(chartPanel);
        frame.pack();
        frame.setVisible(true);
    }
    //public static void SOP(String aImprimir){System.out.println(aImprimir);}
}