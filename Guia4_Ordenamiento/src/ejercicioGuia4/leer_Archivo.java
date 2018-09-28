package ejercicioGuia4;
import java.io.File;
import java.util.Scanner;
public class leer_Archivo {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(new File("C:/es.txt"));
            while (input.hasNextLine()) {
                String line = input.nextLine();
                System.out.println(line);
            }
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}