package uebungen.beispiele;

public class ArrayAWholeABC {
    public static void main(String[] args) {

        // Create a char array of 26 characters.
        // ... Add all letters to it.
        char[] array = new char[26];
        int index = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            array[index++] = c;
        }
        String result = new String(array); // Convert to a string.
        // ... Display parts of our new string.
        System.out.println(result.startsWith("abc"));
        System.out.println(result.length());
        System.out.println(result);
    }
}
