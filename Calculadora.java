import java.util.HashMap;
import java.util.Map;

/**
 * Clase Calculadora que implementa las funciones aritmeticas
 * @author SaintPage Ultimate-Truth-Seeker
 * @version 17-01-2024
 */
public class Calculadora implements ICalculadora<Float> {
    private static Calculadora instance;
    private Calculadora() {

    }
    public static Calculadora getInstance(){
        if (instance == null){
            instance = new Calculadora();
        }
        return instance;
    }
    /**
     * Método para sumar
     * @param stack la pila de numeros
     */
    @Override
    public void suma(CustomStack<Float> stack) {
        float valor1 =  stack.pop();
        float valor2 = stack.pop();
        float resultado = valor1 + valor2;
        stack.push(resultado);
        
    }
    /**
     * Método para restar
     * @param stack la pila de numeros
     */
    @Override
    public void resta(CustomStack<Float> stack) {
        float valor1 =  stack.pop();
        float valor2 = stack.pop();
        float resultado = valor2 - valor1;
        stack.push(resultado);
        
    }
    /**
     * Método para multiplicar
     * @param stack la pila de numeros
     */
    @Override
    public void producto(CustomStack<Float> stack) {
        float valor1 =  stack.pop();
        float valor2 = stack.pop();
        float resultado = valor1 * valor2;
        stack.push(resultado);
        
    }
    /**
     * Método para dividir
     * @param stack la pila de numeros
     */
    @Override
    public void division(CustomStack<Float> stack) {
        float valor1 =  stack.pop();
        float valor2 = stack.pop();
        if (valor1 != 0) {
            float resultado = valor2 / valor1;
            stack.push(resultado);
        } else {
            stack.push(valor2);
            stack.push(valor1);
        }
        
        
    }
    /**
     * Método para añadir un número a la pila
     * @param stack la pila de numeros
     * @param n el número 
     */
    @Override
    public void addNumber(CustomStack<Float> stack, int n) {
        stack.push((float) n);
    }
    /**
     * Método para verificar que el texto es un entero
     * @param s el texto ingresado
     */
    @Override
    public boolean isNumber(String s) {
        try {  
            Integer.parseInt(s);  
            return true;
          } catch(NumberFormatException e){  
            return false;  
          }  
        }
        
    @Override
    public Float calcular(CustomStack<Float> stack, String[] operators) {
        for (var operator : operators) {
            boolean verificador = instance.isNumber(operator);
           if(verificador){
                //si es un numero
                int op = Integer.parseInt(operator);
                instance.addNumber(stack, op);
           }
           else{
            try {
                switch (operator) {
                    case "+":
                       instance.suma(stack);
                        break;
                    case "-":
                        instance.resta(stack);
                        break;
                    case "*":
                        instance.producto(stack);
                        break;
                    case "/":
                        float divisor = stack.pop();
                        if (divisor == 0.0) {
                            System.out.println("Error. División entre cero");
                            return null;
                            
                        }
                        stack.push(divisor);
                        instance.division(stack);
                        break;
                    
                    default:
                    System.out.println("Error. Hay un símbolo ajeno");
                        return null;
                }
            } catch (Exception e) {
                System.out.println("Error, hay más operaciones de las posibles de realizar");

                return null;
            }}}
        return stack.pop();
    }
     private static final Map<Character, Integer> OPERATOR_PRECEDENCE = new HashMap<>() {{
        put('#', 0);  // Carácter especial inicial
        put('+', 1);
        put('-', 1);
        put('*', 2);
        put('/', 2);
        put('^', 3);
    }};
    @Override
    public String[] convertir(String expression) {
        StringBuilder postfix = new StringBuilder();
        CustomStack<Character> stack = FactoryStack.getCustomStack("ListaSimple");  // Cambia "ListaSimple" por el tipo de pila que se quieras usar
        stack.push('#');

        for (char ch : expression.toCharArray()) {
            if (Character.isDigit(ch)) {
                postfix.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == '^') {
                stack.push(ch);
            } else if (ch == ')') {
                while (stack.size() > 0 && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop();  // Elimina el '('
            } else {
                while (stack.size() > 0 && OPERATOR_PRECEDENCE.get(ch) <= OPERATOR_PRECEDENCE.get(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while (stack.size() > 0 && stack.peek() != '#') {
            postfix.append(stack.pop());
        }

        return postfix.toString().split("");
    }
}
