public interface ICalculadora<T extends Comparable<T>> {
    public void suma(CustomStack<T> stack);
    public void resta(CustomStack<T> stack);
    public void producto(CustomStack<T> stack);
    public void division(CustomStack<T> stack);
    public void addNumber(CustomStack<T> stack, int n);
    public boolean isNumber(String s);
    public T calcular(CustomStack<T> stack, String[] operators);
    public String[] convertir(String expression);
}