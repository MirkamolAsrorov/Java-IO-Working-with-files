package org.example;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Time;
import java.time.Duration;

public class FileDescriptorDemo {
    public static void main(String[] args) throws IOException {

    }

    private static void readFileDescriptor() {
        try {
            FileInputStream fileInputStream = new FileInputStream("testOut.txt");

            int data;

            while ((data = fileInputStream.read()) != -1){
                System.out.print((char) data);
            }
        }catch (IOException ex){
            throw new RuntimeException(ex);
        }
    }

    private static void writeFileDescription(String text) {
        byte[] fastText = text.getBytes();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("testOut.txt");
            FileDescriptor fd = fileOutputStream.getFD();

            fileOutputStream.write(fastText);
            fileOutputStream.flush();
            fd.sync(); //confirms data to be written to the disk

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
