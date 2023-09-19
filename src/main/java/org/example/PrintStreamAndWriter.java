package org.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

public class PrintStreamAndWriter {
    public static void main(String[] args) {
        writeDataInFileUsingPritnWriter();
    }

    private static void writeDataInFileUsingPritnWriter() {
        try {
            PrintWriter writer = new PrintWriter("testOut.txt");
            writer.println("This is printWriter");
            writer.println("And i could implement it ");
            writer.flush();
            writer.close();
        }catch (IOException ex){
            throw new RuntimeException(ex);
        }
    }

    private static void writeDataOnConsoleUsingPrintWriter() {
        System.out.print("Write something:\t");

        PrintWriter writer = new PrintWriter(System.out);

        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();

        writer.write(data);
        writer.flush();
        writer.close();
    }

    private static void writeDataWithPrintingLine() {
        Date date = new Date();
        try {
            PrintStream printStream = new PrintStream(
                    new FileOutputStream("testOut.txt"));
            printStream.println("date: " + date.getDate());
            printStream.println("place: Local library");
            printStream.println("local time: " + date.getTime());
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
