package org.example;

import java.io.*;

public class WriterAndReader {


    public static void main(String[] args) throws IOException {
        createCustomFilterReader();
    }

    private static void createCustomFilterReader() throws IOException {
        CustomFilterReader customFilterReader = new CustomFilterReader("testOut.txt");

        int data;
        while ((data = customFilterReader.read()) != -1){
            System.out.print((char) data);
        }
        customFilterReader.close();
    }


    private static void createCustomFilterWriter() throws IOException {
        CustomFilterWriter customFilterWriter = new CustomFilterWriter("testOut.txt");
        customFilterWriter.write("You love your country");
        customFilterWriter.close();
    }



    private static void writeAndReadDataSimulatenouslyUsingPipedWriterAndReader() throws IOException {
        PipedReader pipedReader = new PipedReader();
        PipedWriter pipedWriter = new PipedWriter(pipedReader);

        Thread readerThread = new Thread(() -> {
            int data;
            while (true) {
                try {
                    if ((data = pipedReader.read()) == -1)
                        break;

                    System.out.print((char) data);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread writerThread = new Thread(() -> {
            try {
                pipedWriter.write("This is a litle bit difficult theme to learn and understand");
                pipedWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        readerThread.start();
        writerThread.start();
    }




    private static void writeDataWithoutThreadUsingPipedWriter() throws IOException {
        PipedReader pipedReader = new PipedReader();
        PipedWriter pipedWriter = new PipedWriter();
        pipedWriter.connect(pipedReader);

        pipedWriter.write("Hello world what is going on here");
        pipedWriter.close();

        int data;
        while ((data = pipedReader.read()) != -1) {
            System.out.print((char) data);
        }
        pipedReader.close();
    }


    private static void readDataUsingStringReader() throws IOException {
        StringReader stringReader = new StringReader(
                "This is String text"
        );
        int data;

        while ((data = stringReader.read()) != -1) {
            System.out.print((char) data);
        }
    }

    private static void writeDataIntoStringBuffer() throws IOException {
        StringWriter stringWriter = new StringWriter();
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("testOut.txt")
                )
        );

        int aCharacter;

        while ((aCharacter = bufferedReader.read()) != -1) {
            stringWriter.write(aCharacter);
        }

        stringWriter.close();
        bufferedReader.close();
        System.out.println(stringWriter);
    }

    private static void changeLettersBasedOnGivenLettersUsingPushBackReader() throws IOException {
        char[] ary = {'1', '-', '-', '2', '-', '3', '4', '-', '-', '-', '5', '6'};

        PushbackReader pushbackReader = new PushbackReader(
                new CharArrayReader(ary)
        );
        int aByte;
        while ((aByte = pushbackReader.read()) != -1) {

            if (aByte == '-') {

                int theNextByte = pushbackReader.read();

                if (theNextByte == '-') {
                    System.out.print("!)");

                } else {
                    pushbackReader.unread(theNextByte);
                    System.out.print((char) aByte);

                }

            } else {
                System.out.print((char) aByte);

            }
        }
    }

    private static void changeMatchedLettersUsingPushback() throws IOException {
        String srg = "1##2#34###12";
        byte ary[] = srg.getBytes();
        ByteArrayInputStream array = new ByteArrayInputStream(ary);
        PushbackInputStream push = new PushbackInputStream(array);
        int i;
        while ((i = push.read()) != -1) {
            if (i == '#') {
                int j;
                if ((j = push.read()) == '#') {
                    System.out.print("**");
                } else {
                    push.unread(j);
                    System.out.print((char) i);
                }
            } else {
                System.out.print((char) i);
            }
        }
    }

    private static void doublyWriteLettersOfTheTextInTheFileUsingPushBackInputStream() throws IOException {
        PushbackInputStream pushbackInputStream = new PushbackInputStream(
                new FileInputStream("testOut.txt")
        );
        int aByte;
        while ((aByte = pushbackInputStream.read()) != -1) {
            System.out.print((char) aByte);

            pushbackInputStream.unread(aByte);

            aByte = pushbackInputStream.read();
            System.out.print((char) aByte);
        }
    }


    private static void convertByteStreamsIntoCharStreams() {
        try {
            InputStreamReader fileReader = new InputStreamReader(
                    new FileInputStream("testOut.txt"));
            int aByte;
            while ((aByte = fileReader.read()) != -1) {
                System.out.print((char) aByte);
            }
            fileReader.close();
        } catch (IOException ex) {
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
