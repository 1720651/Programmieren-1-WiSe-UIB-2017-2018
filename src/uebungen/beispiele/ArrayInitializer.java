package uebungen.beispiele;
public class ArrayInitializer {
    public static void main(String[] args) {

        // Use array initializer syntax.
        char[] array = { 'a', 'r', 't', 'i', 's', 't' };
        // Add only the first three characters to a new string.
        String result = new String(array, 0, 3);
        System.out.println(result);
    }
}
