import java.util.Arrays;

public class Seminar1 {
    public static void main(String[] args) {
        Integer number = sum(6);
        System.out.println(number);

        // Eratosfen eratosfen = new Eratosfen(10);
        // eratosfen.fillSieve();

        boolean[] primes = new boolean[10];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;
        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {
                for (int j = 2; i * j < primes.length; j++) {
                    primes[i * j] = false;
                }
            }
        }

        System.out.println(dice2(4, 2));

        long startTime = System.nanoTime();
        System.out.println(fibFor(10));
        long stopTime = System.nanoTime();
        System.out.println(stopTime - startTime);

        startTime = System.nanoTime();
        System.out.println(fibFor(20));
        stopTime = System.nanoTime();
        System.out.println(stopTime - startTime);

        startTime = System.nanoTime();
        System.out.println(fibFor(30));
        stopTime = System.nanoTime();
        System.out.println(stopTime - startTime);

        startTime = System.nanoTime();
        System.out.println(fibFor(40));
        stopTime = System.nanoTime();
        System.out.println(stopTime - startTime);
    }

    public static int sum(int digit) {
        int result = 0;
        for (int i = 1; i <= digit; i++) {
            result += i;
        }
        return result;
    }

    // public class Eratosfen {
    // // решето Эратосфена
    // boolean[] primes;

    // public Eratosfen(int n) {
    // primes = new boolean[n + 1];
    // }

    // public void fillSieve() {
    // Arrays.fill(primes, true);
    // primes[0] = false;
    // primes[1] = false;
    // for (int i = 2; i < primes.length; i++) {
    // if (primes[i]) {
    // for (int j = 2; i * j < primes.length; j++) {
    // primes[i * j] = false;
    // }
    // }
    // }
    // }
    // }

    public static int dice2 (int k, int n) {
        if (k <= 0) {
            return 0;
        }
        return recursiveCount(1, k, n);
    }

    public static int recursiveCount (int depth, int maxDepth, int side) {
        int count = 0;
        for (int i = 1; i <= side; i++) {
            if(depth == maxDepth) {
                count++;
            } else {
                count += recursiveCount(depth+1, maxDepth, side);
            }
        }
        return count;
    }

    public static int fibFor(int n) {
        int first = 0;
        int second = 1;
        int result = 1;
        for (int i = 1; i < n; i++) {
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }

}
