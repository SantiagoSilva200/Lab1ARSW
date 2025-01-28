package edu.eci.arsw.math;

public class PiDigits {

    private static final double EPSILON = 1e-17;

    public static byte[] getDigits(int start, int count, int numThreads) throws InterruptedException {
        if (start < 0 || count < 0) {
            throw new IllegalArgumentException("Invalid range");
        }

        byte[] digits = new byte[count];
        int digitsPerThread = count / numThreads;
        int remainder = count % numThreads;

        Thread[] threads = new Thread[numThreads];
        int currentStart = 0;

        for (int i = 0; i < numThreads; i++) {
            int threadCount = digitsPerThread + (i < remainder ? 1 : 0);
            threads[i] = new ThreadLab(start + currentStart, threadCount, digits);
            threads[i].start();
            currentStart += threadCount;
        }

        for (Thread thread : threads) {
            thread.join();
        }

        return digits;
    }

    public static byte[] calculateDigits(int start, int count) {
        byte[] digits = new byte[count];
        for (int i = 0; i < count; i++) {
            digits[i] = (byte) computePiDigit(start + i);
        }
        return digits;
    }

    private static int computePiDigit(int n) {
        double x = 4 * sum(1, n) - 2 * sum(4, n) - sum(5, n) - sum(6, n);
        x = x - Math.floor(x);
        return (int) (x * 16);
    }

    private static double sum(int m, int n) {
        double sum = 0;
        int k = 0;

        while (true) {
            double term = (Math.pow(16, n - k) % (8 * k + m)) / (8 * k + m);
            if (term < EPSILON) break;
            sum += term;
            k++;
        }

        return sum;
    }
}
