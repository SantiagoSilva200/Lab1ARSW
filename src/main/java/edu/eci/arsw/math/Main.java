package edu.eci.arsw.math;

public class Main {

    public static void main(String[] a) throws InterruptedException {
        //System.out.println("Primeros 10 dígitos de PI con 1 hilo:");
        //System.out.println(bytesToHex(PiDigits.getDigits(0, 10, 1)));

        //System.out.println("Primeros 100 dígitos de PI con 2 hilos:");
        //System.out.println(bytesToHex(PiDigits.getDigits(0, 100, 2)));

        //System.out.println("Primeros 1,000,000 de dígitos de PI con 3 hilos:");
        //System.out.println(bytesToHex(PiDigits.getDigits(0, 10000, 3)));

        runExperiments();


    }

    private static void runExperiments() throws InterruptedException {
        int totalDigits = 1000; 
        int numCores = Runtime.getRuntime().availableProcessors();

        // Experimento 1: Con un solo hilo
        System.out.println("Ejecutando con 1 hilo...");
        long startTime = System.currentTimeMillis();
        PiDigits.getDigits(0, totalDigits, 1); 
        long endTime = System.currentTimeMillis();
        System.out.println("Tiempo con 1 hilo: " + (endTime - startTime) + " ms");

        // Experimento 2: Con tantos hilos como núcleos de CPU
        System.out.println("Ejecutando con " + numCores + " hilos...");
        startTime = System.currentTimeMillis();
        PiDigits.getDigits(0, totalDigits, numCores); 
        endTime = System.currentTimeMillis();
        System.out.println("Tiempo con " + numCores + " hilos: " + (endTime - startTime) + " ms");

        // Experimento 3: Con el doble de hilos que núcleos
        System.out.println("Ejecutando con " + (numCores * 2) + " hilos...");
        startTime = System.currentTimeMillis();
        PiDigits.getDigits(0, totalDigits, numCores * 2); 
        endTime = System.currentTimeMillis();
        System.out.println("Tiempo con " + (numCores * 2) + " hilos: " + (endTime - startTime) + " ms");

        // Experimento 4: Con 200 hilos
        System.out.println("Ejecutando con 200 hilos...");
        startTime = System.currentTimeMillis();
        PiDigits.getDigits(0, totalDigits, 200); 
        endTime = System.currentTimeMillis();
        System.out.println("Tiempo con 200 hilos: " + (endTime - startTime) + " ms");

        // Experimento 5: Con 500 hilos
        System.out.println("Ejecutando con 500 hilos...");
        startTime = System.currentTimeMillis();
        PiDigits.getDigits(0, totalDigits, 500); 
        endTime = System.currentTimeMillis();
        System.out.println("Tiempo con 500 hilos: " + (endTime - startTime) + " ms");
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
