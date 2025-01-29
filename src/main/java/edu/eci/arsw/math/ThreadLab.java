package edu.eci.arsw.math;

public class ThreadLab extends Thread {
    private final int start;
    private final int count;
    private final byte[] result;

    public ThreadLab(int start, int count, byte[] result) {
        this.start = start;
        this.count = count;
        this.result = result;
    }

    @Override
    public void run() {
        byte[] digits = PiDigits.calculateDigits(start, count);
        System.arraycopy(digits, 0, result, start, count);
    }
}
