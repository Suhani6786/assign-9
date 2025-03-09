import java.util.Arrays;
import java.util.Random;

public class SortComparison {

    // Generic method for Merge Sort
    public static <T extends Comparable<T>> void mergeSort(T[] array) {
        if (array.length < 2) return;
        int mid = array.length / 2;
        T[] left = Arrays.copyOfRange(array, 0, mid);
        T[] right = Arrays.copyOfRange(array, mid, array.length);
        
        mergeSort(left);
        mergeSort(right);
        merge(array, left, right);
    }

    private static <T extends Comparable<T>> void merge(T[] array, T[] left, T[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }
        while (i < left.length) array[k++] = left[i++];
        while (j < right.length) array[k++] = right[j++];
    }

    // Generic method for Bubble Sort
    public static <T extends Comparable<T>> void bubbleSort(T[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Method to generate a random Integer array
    public static Integer[] generateRandomArray(int size, int bound) {
        Random random = new Random();
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(bound);
        }
        return array;
    }

    // Main method to test sorting performance
    public static void main(String[] args) {
        int size = 1000; // Adjust size for testing
        int bound = 10000;

        Integer[] array1 = generateRandomArray(size, bound);
        Integer[] array2 = Arrays.copyOf(array1, array1.length);

        // Measure time for Merge Sort
        long startMerge = System.nanoTime();
        mergeSort(array1);
        long endMerge = System.nanoTime();
        System.out.println("Merge Sort took: " + (endMerge - startMerge) + " ns");

        // Measure time for Bubble Sort
        long startBubble = System.nanoTime();
        bubbleSort(array2);
        long endBubble = System.nanoTime();
        System.out.println("Bubble Sort took: " + (endBubble - startBubble) + " ns");
    }
}
