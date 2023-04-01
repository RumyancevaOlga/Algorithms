import java.sql.Date;

public class Seminar2 {
    public static void main(String[] args) {
        int[] arr = new int[] { 2, 5, 3, 7, 4, 8, 6, 9, 1, 0, 10, 45, -4 };
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        quickSort(arr, 0, arr.length - 1);
        
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        for (int i = 10000; i <= 100000; i = i + 10000) {

            int [] array = new int[i];

            for (int j = 0; j < array.length; j++) {
                array[j] = (int) (Math.random() * 100);
            }

            quickSort(array, 0, array.length - 1);

            long startTime = System.nanoTime();
            System.out.println(binarySearch(array, 45, 0, array.length));
            long stopTime = System.nanoTime();
            long binarySearchDuration = (stopTime - startTime) / 3600;

            startTime = System.nanoTime();
            System.out.println(lineSearch(array, 45));
            stopTime = System.nanoTime();
            long lineSearchDuration = (stopTime - startTime) / 3600;

            System.out.printf("i: %s, binary search duration: %s, line search duration: %s%n", i, binarySearchDuration, lineSearchDuration);
        }

        // for (int i = 10000; i <= 100000; i = i + 10000) {
        //     int [] array = new int[i];

        //     for (int j = 0; j < array.length; j++) {
        //         array[j] = (int) (Math.random() * 10000);
        //     }

        //     int[] array2 = array.clone();

        //     long startTime = System.nanoTime();
        //     bubbleSort(array);
        //     long stopTime = System.nanoTime();
        //     long bubbleSortDuration = (stopTime - startTime) / 3600;

        //     startTime = System.nanoTime();
        //     quickSort(array2, 0, array2.length - 1);
        //     stopTime = System.nanoTime();
        //     long quickSortDuration = (stopTime - startTime) / 3600;

        //     System.out.printf("i: %s, bubble sort duration: %s, quick sort duration: %s%n", i, bubbleSortDuration, quickSortDuration);
        // }
    }

    public static void quickSort(int[] array, int startPosition, int endPosition) {
        int leftPosition = startPosition;
        int rightPosition = endPosition;
        int pivot = array[(endPosition + startPosition) / 2];
        do {
            while (array[leftPosition] < pivot) {
                leftPosition++;
            }
            while (array[rightPosition] > pivot) {
                rightPosition--;
            }
            if (leftPosition <= rightPosition) {
                if (leftPosition < rightPosition) {
                    int temp = array[leftPosition];
                    array[leftPosition] = array[rightPosition];
                    array[rightPosition] = temp;
                }
                leftPosition++;
                rightPosition--;
            }
        }
        while (leftPosition <= rightPosition);
        if (leftPosition < endPosition) {
            quickSort(array, leftPosition, endPosition);
        }
        if (startPosition < rightPosition) {
            quickSort(array, startPosition, rightPosition);
        }
    }

    public static void bubbleSort(int[] array) {
        boolean finish;
        do {
            finish = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    finish = false;
                }
            }
        } while (!finish);
    }

    public static int binarySearch(int[] array, int value, int minPos, int maxPos) {
        if(minPos >= maxPos) {
            return -1;
        }
        int midPoint = minPos + (maxPos - minPos) / 2;
        if (array[midPoint] == value) {
            return midPoint;
        } else if (array[midPoint] > value) {
            return binarySearch(array, value, minPos, midPoint - 1);
        } else {
            return binarySearch(array, value, midPoint + 1, maxPos);
        }
    }

    public static int lineSearch(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
