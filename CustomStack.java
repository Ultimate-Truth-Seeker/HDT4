public interface CustomStack<T extends Comparable<T>> {
    public T pop();
    public void push(T value);
    public int size();
}
