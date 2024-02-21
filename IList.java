/**
 * Interfaz para las pilas de tipo lista
 * 
 * @version 20-02-2024
 */
public interface IList<T extends Comparable<T>> extends CustomStack<T> {
    /**
     * añade un valor
     * @param value el valor a añadr
     */
    void add(T value);
    /**
     * obtiene un valor de la lista
     * @param index el índice del valor
     * @return el valor encontrado
     */
    T get(int index);
    /**
     * retorna el tamaño de la lista
     */
    int size();
}
