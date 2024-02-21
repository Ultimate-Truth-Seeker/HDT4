import java.io.File;
import java.util.Scanner;

/**
 * Clase Main para la conversión de un texto infix a postix y luego calcularlo como en la HDT2
 * 
 * @author SaintPage Ultimate-Truth-Seeker
 */
public class Main {
    public static void main(String[] args) {
        
        //Nombre del archivo a leer, se usa después la misma variable para el texto leído
        String archivo = "datos.txt";
        
        try ( Scanner sc = new Scanner(new File(archivo))){
            archivo = sc.nextLine();
            System.err.println("Archivo \"datos.txt\" leído con éxito");
        } catch (Exception e) {
            System.out.println("Error en la lectura del archivo \"datos.txt\"");
            return;
            
        }

        Scanner s = new Scanner(System.in);
        System.err.println("Bienvenido, Elija el tipo de implementación:\n1. Arraylist\n2. Vector\n3. lista");
        int op = s.nextInt();
        if (op == 3){
            System.err.println("Elija el tipo de lista:\n4. Simplemente encadenada\n5. Doblemente encadenada");
            op = s.nextInt();
        }
        CustomStack<Float> stack = null;
        Calculadora calculadora = Calculadora.getInstance(); // Singleton de calculadora
        s.nextLine();
        
        // Seleccción de implementación en factory según la respuesta del usuario
        switch (op) {
            case 1:
                stack = FactoryStack.getCustomStack("ArrayList");
                break;
            case 2:
                stack = FactoryStack.getCustomStack("Vector");
                break;
            case 4:
                stack = FactoryStack.getCustomStack("SimplyLinkedList");
                break;
            case 5:
                stack = FactoryStack.getCustomStack("DoublyLinkedList");
                break;
            default:
                System.err.println("Opción incorrecta. Reinicie e ingrese una opción válida");
                s.close();
                return;
        }

        // Conversión del texto y cálculo de resultado
        Float f = calculadora.calcular(stack, calculadora.convertir(archivo));
        System.err.println("El resultado es " + f);
        s.close();
    }
}