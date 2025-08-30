import JE2.Box;

import java.util.Arrays;

public class GenericTest {
    public static void main(String[] args){
        Box<String> stringBox = new Box<>("Hello");
        Box<Integer> integerBox = new Box<>(2);

        System.out.println("String box: " + stringBox.getValue());
        System.out.println("Int box: "+ integerBox.getValue());
        System.out.println("stringBox empty? " + stringBox.isEmpty());

        // TODO: Create a generic method that prints any array
        // Example: printArray(new Integer[]{1,2,3});

        printArray(new Integer[]{1, 2, 3});
        printArray(new String[]{"a", "b", "c"});

    }

    public static <T> void printArray(T[] array){
        System.out.println(Arrays.toString(array));
    }
}
