/**
 * Interfaz genérica del diseño de una pila
 * 
 * @version 20-2-2024
 */
public interface CustomStack<T extends Comparable<T>> {
    /**
     * Elimina el elemento en la cabeza de la pila
     * @return el elemento eliminado
     */
    public T pop();
    /**
     * agrega un elemento extra a la cabeza de la pila
     * @param value el valor a añadir
     */
    public void push(T value);
    /**
     * indica el tamaño de la pila
     * @return entero para el tamaño
     */
    public int size();
    /**
     * muestra el elemento en la cabeza sin eliminarlo de la pila
     * @return el elemento a la cabeza
     */
    public T peek();
}
