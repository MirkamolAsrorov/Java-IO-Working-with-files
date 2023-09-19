package org.example.ios;

import java.io.*;

public class FilterIOS {
    public static void main(String[] args) throws IOException {
            FilterInputStream filterIn =
                    new BufferedInputStream(new FileInputStream("testOut.txt"));

            int i = 0;
            while ((i = filterIn.read()) != -1){
                System.out.print((char) i);
            }
    }

    private static void write() {
        try {
            FilterOutputStream filterOut = new FilterOutputStream(new FileOutputStream("testOut.txt"));
            String text = "Hello world of Java";
            byte[] bytes = text.getBytes();
            filterOut.write(bytes);
            filterOut.close();

        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
