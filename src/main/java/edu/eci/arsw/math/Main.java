package edu.eci.arsw.math;

public class Main {

    public static void main(String[] a) throws InterruptedException {
        int numThreads = 4;

        System.out.println("Primeros 10 dígitos de PI con 1 hilo:");
        System.out.println(bytesToHex(PiDigits.getDigits(0, 10, 1)));

        System.out.println("Primeros 100 dígitos de PI con 2 hilos:");
        System.out.println(bytesToHex(PiDigits.getDigits(0, 100, 2)));

        System.out.println("Primeros 1,000,000 de dígitos de PI con 3 hilos:");
        System.out.println(bytesToHex(PiDigits.getDigits(0, 10000, 3)));
    }

    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();
    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < hexChars.length; i = i + 2) {
            sb.append(hexChars[i + 1]);
        }
        return sb.toString();
    }
}
