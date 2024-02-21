import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests para Junit
 */
public class Tests {
    private Calculadora c = Calculadora.getInstance();
    String[] datos = "1 2 + 9 *".split(" ");
    
    @Test
    public void testConvertion() {
        String[] data = c.convertir("(1+2)*9");
        int index = 0;
        for (String string : data) {
            assertEquals(string, datos[index]);
            index ++;
        }
    }

    @Test
    public void testCreation() {

        CustomStack<Float> stack1 = FactoryStack.getCustomStack("ArrayList");
      
        CustomStack<Float> stack2 = FactoryStack.getCustomStack("Vector");
  
        CustomStack<Float> stack3 = FactoryStack.getCustomStack("SinglyLinkedList");
    
        CustomStack<Float> stack4 = FactoryStack.getCustomStack("DoublyLinkedList");
        Boolean b = true;
        
        if (c.calcular(stack4, datos).equals(c.calcular(stack3, datos)) && c.calcular(stack3, datos).equals(c.calcular(stack2, datos)) && c.calcular(stack2, datos).equals(c.calcular(stack1, datos))) {
            b = true;
        } else {
            b = false;
        }
        assertEquals(b, true);
    }

    @Test
    public void testAccuracy() {
        CustomStack<Float> stack1 = FactoryStack.getCustomStack("ArrayList");
      
        CustomStack<Float> stack2 = FactoryStack.getCustomStack("Vector");
  
        CustomStack<Float> stack3 = FactoryStack.getCustomStack("SinglyLinkedList");
    
        CustomStack<Float> stack4 = FactoryStack.getCustomStack("DoublyLinkedList");
        
        float f = c.calcular(stack1, datos);
        assertEquals((int) f, 27);
        f = c.calcular(stack2, datos);
        assertEquals((int) f, 27);
        f = c.calcular(stack3, datos);
        assertEquals((int) f, 27);
        f = c.calcular(stack4, datos);
        assertEquals((int) f, 27);
    }
}
