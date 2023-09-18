package org.example;

import java.io.*;
import java.util.Scanner;

public class ByteArrayIOS {
    public static void main(String[] args) {
        readByteArray();
    }

    private static void readByteArray() {
        byte[] bytes = {65,66,67,68};
        ByteArrayInputStream byteArrayIn = new ByteArrayInputStream(bytes);
        int i = 0;
        while ((i = byteArrayIn.read()) != -1){
            System.out.println((char) i);
        }
    }

    private static void writeCommonDataToTwoFiles() {
        try {
            Scanner scanner = new Scanner(System.in);
            FileOutputStream fileOut = new FileOutputStream("testOut.txt");
            FileOutputStream fileOut2 = new FileOutputStream("testOut2.txt");

            ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();

            System.out.println("Write a text to 2 files: ");
            String text = scanner.nextLine();

            byteArrayOut.write(text.getBytes());
            byteArrayOut.writeTo(fileOut);
            byteArrayOut.writeTo(fileOut2);
            byteArrayOut.flush();
            byteArrayOut.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
