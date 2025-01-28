package edu.eci.arsw.math;

public class ThreadLab extends Thread {
    private int start;
    private int count;
    private byte[] result;

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
