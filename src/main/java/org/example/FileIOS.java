package org.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileIOS {
    public static void main(String[] args) {
        readWholeFile();
    }

    private static void readWholeFile() {
        try {
            FileInputStream fileIn = new FileInputStream("testout.txt");
            int i = 0;
            while ((i = fileIn.read()) != -1) {
                System.out.print((char) i);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void readOneWordInAFile() {
        try {
            FileInputStream fileIn = new FileInputStream("testout.txt");
            int i = fileIn.read();
            System.out.println((char) i);
            fileIn.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeToFileViaConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write a text: ");
        String text = scanner.nextLine();

        try {
            FileOutputStream fileOut = new FileOutputStream("testout.txt");
            String text1 = "Hello Java";
            byte[] bytes = text.getBytes();

            fileOut.write(bytes);
            fileOut.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
