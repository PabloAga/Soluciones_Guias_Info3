package ejercicioGuia4;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class leer_Mauro {
    public static void main(String[] args) {

        // Making the array
        int size = 2014322; // 2014322 Elements to be sorted
        String arrayS[] = new String[size];
        String arrayB[] = new String[size];
        String arrayQ[] = new String[size];

        FileReader reader = null;
        BufferedReader bufferedReader = null;

        try {
            reader = new FileReader("src\\ejercicioGuia4\\es.txt");
            bufferedReader = new BufferedReader(reader);

            String line;
            for (int i = 0; (line = bufferedReader.readLine()) != null; ++i) {
                arrayS[i] = line;
                arrayQ[i] = line;
                arrayB[i] = line;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ignored) {
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ignored) {
                }
            }
        }

        // Sorting
        long tNow, tBS, tSS, tQS;

        /*tNow = System.nanoTime();
        bubbleSort(arrayB);
        tBS = System.nanoTime() - tNow;
*/
        tNow = System.nanoTime();
        shellSort(arrayS);
        tSS = System.nanoTime() - tNow;

        tNow = System.nanoTime();
        quickSort(arrayQ, 0, arrayQ.length - 1);
        tQS = System.nanoTime() - tNow;

        System.out.print("BubbleSort took " +/* tBS / 1e9 +*/ " seconds.\nShellSort took " + tSS / 1e9 + " seconds.\nQuickSort took " + tQS / 1e9 + " seconds.\n");
    }

    private static void bubbleSort(String array[]) {

        for (int i = 0; i < array.length - 1; ++i) {
            boolean swapped = false;
            for (int j = 0; j < array.length - i - 1; ++j) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    final String tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    private static void shellSort(String array[]) {
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                for (int j = i - gap; j >= 0 && array[j].compareTo(array[j + gap]) > 0; j -= gap) {
                    final String temp = array[j];
                    array[j] = array[j + gap];
                    array[j + gap] = temp;
                }
            }
        }
    }

    private static void quickSort(String array[], int left, int right) {
        int i = left, j = right;

        do {
            while (array[j].compareTo(array[i]) > 0 && j > i) {
                j--;
            }

            if (i < j) {
                final String temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
            }

            while (array[i].compareTo(array[j]) < 0 && i < j) {
                i++;
            }

            if (i < j) {
                final String temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                j--;
            }
        }
        while (i < j);

        if (left < j) {
            quickSort(array, left, j - 1);
        }

        if (i < right) {
            quickSort(array, i + 1, right);
        }
    }
}
