import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

/**
 * Find the maximum and minimum of eight numbers.
 *
 * @author Benjapol Worakan
 */
public class MaxMinOfEightNumbers {
    /** Default input size. */
    private static final int N = 8;
    /** A Scanner that is shared between methods. */
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Entry point.
     *
     * @param args not used
     */
    public static void main(String[] args) {
        MutableInteger max = new MutableInteger(), min = new MutableInteger();
        max.setValue(scanner.nextInt());
        min.setValue(max.getValue());
        receive(N - 1, max, min);
        System.out.println(max + " " + min);
    }

    /**
     *
     * @param times numbers of data - 1.
     * @param max a reference to MutableInteger, its value will be updated to the max value.
     * @param min a reference to MutableInteger, its value will be updated to the min value.
     */
    private static void receive(int times, MutableInteger max, MutableInteger min) {
        if (times <= 0) {
            return;
        }
        int i = scanner.nextInt();
        if (i > max.getValue()) {
            max.setValue(i);
        }
        if (i < min.getValue()) {
            min.setValue(i);
        }
        receive(times - 1, max, min);
    }

    /**
     * A mutable integer wrapper. Created due to no pointer in Java.
     */
    private static final class MutableInteger {
        private int value;

        /**
         * Get the value of this MutableInteger.
         *
         * @return the value of this MutableInteger.
         */
        public int getValue() {
            return value;
        }

        /**
         * Set the value of this MutableInteger.
         *
         * @param value the new value of this MutableInteger.
         */
        public void setValue(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return Integer.toString(value);
        }
    }
}
