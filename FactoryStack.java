/**
 * Clase Factory para las implementaciones de pila y lista
 * Contiene el método para instanciar el stack
 * 
 * @author Ultimate-Truth-Seeker SaintPAge
 * @version 20 feb 2024
 */
public class FactoryStack {
    /**
     * Instancia la pila según el tipo que se le ingresa
     * En este factory se pueden instanciar de una vez las pilas y las listas
     * Hay tres tipos de lista: ArrayList, Vector, y Lista
     * Del tipo Lista está la simplemente encadenada y la doblemente encadenada
     * Se ingresa un String que represente el tipo de implementación a usar.
     * 
     * @param <T> tipo de dato que alamacen el stack. Para este ejercicio se usan comparables.
     * @param type el tipo de implementación a usar
     * @return el objeto instanciado
     */
    public static <T extends Comparable<T>> CustomStack<T> getCustomStack(String type) {
        switch (type) {
            case "ArrayList":
                return new StackArrayList<T>();
            case "Vector":
                return new StackVector<T>();
            case "SimplyLinkedList":
                return new ListaSimple<T>();
            case "DoublyLinkedList":
                return new ListaDoble<T>();
            default:
                break;
        }
        return null;
    }
}