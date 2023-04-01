import java.util.Random;
import java.util.Scanner;

public class HomeWork1 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите количеcтво элементов массива: ");
        String N_String = iScanner.nextLine();
        int N = 0;
        while (N == 0) {
            try {
                N = Integer.parseInt(N_String);
            } catch (Exception ex) {
                System.out.println("Ошибка ввода. Введите количеcтво элементов массива: ");
                N_String = iScanner.nextLine();
            }
        }
        int[] my_array = getArray(N);
        printArray(my_array);
        System.out.println();
        HeapSort(my_array);
        printArray(my_array);
    }
    public static int[] getArray (int N) {
        int[] my_array = new int[N];
        Random r = new Random();
        for (int i = 0; i < my_array.length; i++) {
            my_array[i] = r.nextInt(1, 40);
        }
        return my_array;
    }
    public static void printArray (int[] my_array) {
        for (int i = 0; i < my_array.length; i++) {
            System.out.printf("%d ", my_array[i]);
        }
    }

    // моя пирамидальная сортировка
    public static void HeapSort (int[] my_array) {
        int N = my_array.length;
        for (int i = N / 2 - 1; i >= 0; i--) {
            Heap(my_array, N, i);
        }
        for (int i = N - 1; i >= 0; i--) {
            int temp = my_array[0];
            my_array[0] = my_array[i];
            my_array[i] = temp;
            Heap(my_array, i, 0);
        }
    }
    public static void Heap (int[] my_array, int N, int i) {
        int big = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < N && my_array[left] > my_array[big]) {
            big = left;
        }
        if (right < N && my_array[right] > my_array[big]) {
            big = right;
        }
        if (big != i) {
            int temp = my_array[i];
            my_array[i] = my_array[big];
            my_array[big] = temp;
            Heap(my_array, N, big);
        }
    }

    // эталонное решение на сайте неверное, так что сравнивать не с чем

}
