import java.util.Vector;

public class StackVector<T extends Comparable<T>> implements CustomStack<T>{
    private Vector<T> vector;
    public StackVector() {
        vector = new Vector<>();
    }

    @Override
    public T pop() {
        return vector.remove(0);
    }

    @Override
    public void push(T value) {
        vector.add(0, value);
        
    }

    @Override
    public int size() {
        return vector.size();
    }
    @Override
    public T peek() {
        if (!vector.isEmpty()) {
            return vector.get(0);
        } else {
            throw new IllegalStateException("Cannot peek into an empty stack");
        }
    }
}
