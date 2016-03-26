import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Find prime between two given numbers.
 *
 * @author Benjapol Worakan
 */
public class PrimeBetween {

    /**
     * Entry point. Receive to numbers from the console.
     *
     * @param args not used
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt(), n = scanner.nextInt();
        for (Integer i : primeBetween(m, n)) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * Give a List of primes between two given integers (from m to n).
     *
     * @param m the first value
     * @param n the second value
     * @return a List of primes between two given integers
     */
    public static List<Integer> primeBetween(int m, int n) {
        if (m > n) {
            // Swap if m > n.
            int temp = m;
            m = n;
            n = temp;
        }
        List<Integer> primeList = new LinkedList<>();
        for (int i = m + 1; i < n; i++) {
            if (isPrime(i)) {
                primeList.add(i);
            }
        }
        return primeList;
    }

    /**
     * Test whether the given number is a prime.
     *
     * @param n a number to be tested
     * @return true if n is a prime, false otherwise
     */
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
