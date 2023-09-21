package org.example;

import java.io.*;

public class WriterAndReader {

    public static void main(String[] args) {

    }

    private static void convertByteStreamsIntoCharStreams() {
        try {
            InputStreamReader fileReader = new InputStreamReader(
                    new FileInputStream("testOut.txt"));
            int aByte;
            while ((aByte = fileReader.read()) != -1){
                System.out.print((char) aByte);
            }
        }catch (IOException ex){
            throw new RuntimeException(ex);
        }
    }

    private static void convertCharStreamsIntoByteStreams() {
        try {
            OutputStream file = new FileOutputStream("testOut.txt");
            Writer fileWriter = new OutputStreamWriter(file);
            fileWriter.write("Hello world");
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeCommonDataToMultipleFiles() {
        CharArrayWriter charArrayWriter = new CharArrayWriter();

        try {
            FileWriter file1 = new FileWriter("testOut.txt");
            FileWriter file2 = new FileWriter("testOut2.txt");
            FileWriter file3 = new FileWriter("testOut3.txt");
            FileWriter file4 = new FileWriter("testOut4.txt");

            String commonData = "This is paradigm";
            charArrayWriter.write(commonData);

            charArrayWriter.writeTo(file1);
            charArrayWriter.writeTo(file2);
            charArrayWriter.writeTo(file3);
            charArrayWriter.writeTo(file4);

            file4.close();
            file3.close();
            file2.close();
            file1.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void readDataFromCharArray() {
        CharArrayReader charArrayReader = new CharArrayReader(
                new char[]{'j', 'a', 'v', 'a'});
        try {
            int charIndex;
            while ((charIndex = charArrayReader.read()) != -1) {
                char element = (char) charIndex;
                System.out.print(element);
                System.out.println(": " + charIndex);
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private static void readDataFromConsoleViaInputStreamReaderAndBufferedReader() {
        BufferedReader bufferedFile = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("Name:");
        try {
            String text = bufferedFile.readLine();
            System.out.println("Welcome\t" + text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void readBuffer() {
        try {
            BufferedReader file = new BufferedReader
                    (new FileReader("C:\\Users\\dJ_Sherzodbey\\OneDrive\\Рабочий стол\\experiment.docx"));
            int character;
            while ((character = file.read()) != -1) {
                System.out.print((char) character);
            }
            file.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }


    private static void writeBuffer() {
        try {
            Writer file = new FileWriter("C:\\Users\\dJ_Sherzodbey\\OneDrive\\Рабочий стол\\experiment.docx");
            BufferedWriter bufferedfile = new BufferedWriter(file);
            bufferedfile.write("I love my country");
            bufferedfile.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private static void readFileViaFileReader() {
        try {
            Reader reader = new FileReader("testOut.txt");
            int i;
            while ((i = reader.read()) != -1) {
                System.out.print((char) i);
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeViaFileWriterClass() {
        try {
            Writer writer = new FileWriter("testOut.txt");
            writer.write("Hello world");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
