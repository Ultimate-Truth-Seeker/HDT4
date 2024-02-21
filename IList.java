public interface IList<T extends Comparable<T>> extends CustomStack<T> {
    void add(T value);
    T get(int index);
    int size();
}
