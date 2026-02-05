/*Set B
a) Write a program to calculate the sum and average of an array of 1000 integers
(generated randomly) using 10 threads. Each thread calculates the sum of 100
integers. Use these values to calculate average. [Use join method ].*/
import java.util.Random;

class SumThread extends Thread {
    private int[] arr;
    private int start, end;
    private long partialSum = 0;

    public SumThread(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    public void run() {
        for (int i = start; i < end; i++) {
            partialSum += arr[i];
        }
    }

    public long getPartialSum() {
        return partialSum;
    }
}

public class SumAverageUsingThreads {
    public static void main(String[] args) {
        int[] arr = new int[1000];
        Random rand = new Random();

        // Generate 1000 random integers
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100);  // values 0–99
        }

        SumThread[] threads = new SumThread[10];

        // Create threads (each handles 100 integers)
        for (int i = 0; i < 10; i++) {
            threads[i] = new SumThread(arr, i * 100, (i + 1) * 100);
            threads[i].start();
        }

        // Wait for all threads using join
        long totalSum = 0;
        try {
            for (int i = 0; i < 10; i++) {
                threads[i].join();
                totalSum += threads[i].getPartialSum();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        double average = totalSum / 1000.0;

        System.out.println("Total Sum = " + totalSum);
        System.out.println("Average = " + average);
    }
}

