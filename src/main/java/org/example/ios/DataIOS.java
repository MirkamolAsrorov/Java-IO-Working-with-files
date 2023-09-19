package org.example.ios;

import java.io.*;

public class DataIOS {
    public static void main(String[] args) throws IOException {
    }

    private static void readDataFromInputStream() {
        try {
            DataInputStream dataIn = new DataInputStream(new FileInputStream("testOut.txt"));
            System.out.println(dataIn.available());
        int i = 0;
        while ((i = dataIn.read()) != -1){
            System.out.print((char) i + "-");
        }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeDataUsingNewFeature() {
        try {
            FileOutputStream  fileOut = new FileOutputStream("testOut.txt");
            DataOutputStream dataOut = new DataOutputStream(fileOut);
            dataOut.writeBytes("Hellow world, what is going on here"); // is recommended to use
            dataOut.writeChars("Hello world"); // it prints exactly same, but it creates extra space like NULL in each char
            dataOut.flush();
            dataOut.close();
            fileOut.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
