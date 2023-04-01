import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Lesson1 {

    public static void main(String[] args) {
        // List<Integer> availableDivider = findSimpleNumbers(6);
        // for (Integer integer : availableDivider) {
        //     System.out.println(integer);
        // }
        AtomicInteger counter = new AtomicInteger(0);
        int fib = fib(10, counter);
        System.out.println("Fib number: " + fib);
        System.out.println("Counter: " + counter.get());

        counter = new AtomicInteger(0);
        fib = fib(11, counter);
        System.out.println("Fib number: " + fib);
        System.out.println("Counter: " + counter.get());

        counter = new AtomicInteger(0);
        fib = fib(12, counter);
        System.out.println("Fib number: " + fib);
        System.out.println("Counter: " + counter.get());
    }

    public static List<Integer> findAvailableDivider(int number) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                result.add(i);
            }
        }
        return result;
    }

    public static List<Integer> findSimpleNumbers(int max) {
        int counter = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= max; i++) {
            boolean simple = true;
            for (int j = 2; j < i; j++) {
                counter++;
                if (i % j == 0) {
                    simple = false;
                }
            }
            if (simple) {
                result.add(i);
            }
        }
        System.out.println("Counter: " + counter);
        return result;
    }

    //Для трех шестигранных кубиков
    public static double findSum(int sum) {
        int count = 0;
        int successResult = 0;
        for (int i = 1; i <= 6 ; i++) {
            for (int j = 1; j <= 6; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (i + j + k == sum) {
                        count++;
                    }
                }   
            }
        }
        return ((double) successResult) / ((double) count);
    }

    //Числа Фибоначчи
    public static int fib(int position, AtomicInteger counter) {
        counter.incrementAndGet();
        if (position == 1) {
            return 0;
        }
        if (position == 2) {
            return 1;
        }
        return fib(position - 1, counter) + fib(position - 2, counter);
    }
}
