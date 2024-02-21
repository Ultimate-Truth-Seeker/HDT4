import java.util.LinkedList;
/**
 * Implementación de una lista doblemente encadenada
 * 
 * @version 20-02-2024
 */
public class ListaDoble<T extends Comparable<T>> implements IList<T> {

   private LinkedList<T> listaDoble;
   

    public ListaDoble() {
        listaDoble = new LinkedList<>();
    }

    @Override
    public T pop() {
        return listaDoble.removeLast();
    }

    @Override
    public void push(T value) {
        listaDoble.add(value);
    }

    @Override
    public int size() {
        return listaDoble.size();
    }

    @Override
    public void add(T value) {
        listaDoble.add(value);
    }

    @Override
    public T get(int index) {
        return listaDoble.get(index);
    }
    @Override
    public T peek() {
        if (!listaDoble.isEmpty()) {
            return listaDoble.getLast();
        } else {
            throw new IllegalStateException("Cannot peek into an empty stack");
        }
    }
}