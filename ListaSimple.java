import java.util.ArrayList;
/**
 * Implementación de una lista simplemente encadenada
 * 
 * @version 20-02-2024
 */
public class ListaSimple<T extends Comparable<T>> implements IList<T> {

   private ArrayList<T> listaSimple;
    
    public ListaSimple() {
        listaSimple = new ArrayList<>();
    }

    @Override
    public T pop() {
        return listaSimple.remove(listaSimple.size() - 1);
    }

    @Override
    public void push(T value) {
        listaSimple.add(value);
    }

    @Override
    public int size() {
        return listaSimple.size();
    }

    @Override
    public void add(T value) {
        listaSimple.add(value);
    }

    @Override
    public T get(int index) {
        return listaSimple.get(index);
    }
    @Override
    public T peek() {
        if (!listaSimple.isEmpty()) {
            return listaSimple.get(listaSimple.size() - 1);
        } else {
            throw new IllegalStateException("Cannot peek into an empty stack");
        }
    }
}
