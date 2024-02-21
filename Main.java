import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String archivo;
        try ( Scanner sc = new Scanner(new File("datos.txt"))){
            archivo = sc.nextLine();
            System.err.println("Archivo \"datos.txt\" leído con éxito");
        } catch (Exception e) {
            System.out.println("Error en la lectura del archivo");
            return;
            
        }

        Scanner s = new Scanner(System.in);

        System.err.println("Bienvenido, Elija el tipo de implementación");
        int op = s.nextInt();
        CustomStack<Float> stack = null;
        Calculadora calculadora = Calculadora.getInstance();
        s.nextLine();
        switch (op) {
            case 1:
                break;
        
            default:
                break;
        }
        Float f = calculadora.calcular(stack, calculadora.convertir(archivo));
        System.err.println("El resultado es " + f);
        s.close();
    }
}