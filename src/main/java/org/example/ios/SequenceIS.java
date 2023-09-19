package org.example.ios;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

public class SequenceIS {
    public static void main(String[] args) {
        //Note: File can't be read unless it is created
        try {
            FileInputStream fileIn = new FileInputStream("testOut.txt");
            FileInputStream fileIn2 = new FileInputStream("testOut2.txt");
            FileInputStream fileIn4 = new FileInputStream("testOut4");
            FileInputStream fileIn5 = new FileInputStream("testOut5.txt");
            SequenceInputStream sequenceInputStream = new SequenceInputStream(fileIn, fileIn2);
            FileOutputStream fileOut = new FileOutputStream("testOut3.txt");

            //one of methods can be used here

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void readMoreThanTwoFiles(FileInputStream fileIn, FileInputStream fileIn2,
                                             FileInputStream fileIn4, FileInputStream fileIn5) {
        Vector<FileInputStream> collector = new Vector<>();
        collector.add(fileIn);
        collector.add(fileIn2);
        collector.add(fileIn4);
        collector.add(fileIn5);

        Enumeration<FileInputStream> list = collector.elements();

        SequenceInputStream bin = new SequenceInputStream(list);
        int j = 0;
        try {
            while ((j = bin.read()) != -1) {
                System.out.print((char) j);
            }
            bin.close();
            fileIn.close();
            fileIn2.close();
            fileIn4.close();
            fileIn5.close();

        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

        private static void writeFromReadingTwoFiles (FileInputStream fileIn, FileInputStream fileIn2,
                SequenceInputStream sequenceIn, FileOutputStream fileOut){
            try {
                int j = 0;
                while ((j = sequenceIn.read()) != -1) {
                    fileOut.write(j);
                }
                sequenceIn.close();
                fileOut.close();
                fileIn.close();
                fileIn2.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        private static void readTwoFilesOneByOne (FileInputStream fileIn,
                FileInputStream fileIn2,
                SequenceInputStream sequenceIn){
            try {
                int j = 0;
                while ((j = sequenceIn.read()) != -1) {
                    System.out.print((char) j);
                }
                sequenceIn.close();
                fileIn.close();
                fileIn2.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
