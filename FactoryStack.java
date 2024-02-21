public class FactoryStack<T extends Comparable<T>> {

    public static <T extends Comparable<T>> CustomStack<T> getCustomStack(String type) {
        switch (type) {
            case "ArrayList":
                break;
        
            default:
                break;
        }
        return null;
    }
}