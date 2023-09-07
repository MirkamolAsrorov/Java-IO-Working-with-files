package org.example;

import java.io.*;
import java.util.Scanner;

public class BufferedIOS {
    public static void main(String[] args) {
        readInputFromBufferedFile();
    }

    private static void readInputFromBufferedFile() {
        try {
            FilterInputStream filterInputStream = new BufferedInputStream(new FileInputStream("testout.txt"));
            int i = 0;

            while((i = filterInputStream.read()) != -1){
                System.out.print((char) i);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeToTheBufferedFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write a text: ");
        String outputText = scanner.nextLine();

        try {
            OutputStream bufferedOut = new BufferedOutputStream(new FileOutputStream("testout.txt"));
            byte[] bytes = outputText.getBytes();

            bufferedOut.write(bytes);
            bufferedOut.flush(); // to ensure that all of the buffered data is written to the underlying output stream.
            bufferedOut.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
