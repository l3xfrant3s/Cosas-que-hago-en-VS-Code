import java.io.File;
import java.io.FileFilter;
import java.nio.file.Files;

public class renombrar implements FileFilter{
    public static void main (String[] args){
        File nuevo = new File("C:\\Users\\l3xfr\\Downloads\\Nueva carpeta\\Lapepa.txt");
        if(accept(nuevo)){
            System.out.println("VAMOO");
        }
    }

    public boolean accept(File pathname) {
        // TODO Auto-generated method stub
        if(pathname.getName().endsWith("txt")){
            return true;
        }
        throw new UnsupportedOperationException("Unimplemented method 'accept'");
    }
}