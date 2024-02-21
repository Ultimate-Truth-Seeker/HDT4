import java.util.ArrayList;

public class StackArrayList<T extends Comparable<T>> implements CustomStack<T> {
    private ArrayList<T> stack;
    
    public StackArrayList() {
        stack = new ArrayList<>();
    }

    @Override
    public T pop() {
        return stack.remove(0);

    }

    @Override
    public void push(T value) {
        stack.add(0, value);
        
    }

    @Override
    public int size() {

        return stack.size();
    }
    
}
