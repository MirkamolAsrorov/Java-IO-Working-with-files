package org.example;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileExample {
    public static void main(String[] args) {
        try {

            RandomAccessFile randomAccessFile = new RandomAccessFile("testOut.txt", "r");
            int data;
            //readFrom21tth Letter - position
            randomAccessFile.seek(21);

            while ((data = randomAccessFile.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeToFileAt() {
        String text = "This is the beginning";
        byte[] bytes = text.getBytes();
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("testOut.txt", "rw");

            //startWritingAt21tth Letter - position
            randomAccessFile.seek(21);
            randomAccessFile.write(bytes);
            randomAccessFile.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
