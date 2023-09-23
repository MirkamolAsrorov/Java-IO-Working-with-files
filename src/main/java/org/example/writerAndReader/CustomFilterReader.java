package org.example.writerAndReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CustomFilterReader extends FileReader {
    public CustomFilterReader(String fileName) throws FileNotFoundException {
        super(fileName);
    }

    @Override
    public int read() throws IOException {
        int data = super.read();
        if (data == ' ') {
            data = '0';
        }
        return data;
    }
}
