package org.example;

import java.io.FileWriter;
import java.io.IOException;

public class CustomFilterWriter extends FileWriter {
    public CustomFilterWriter(String fileName) throws IOException {
        super(fileName);
    }

    @Override
    public void write(String str) throws IOException {
        super.write(str.toLowerCase()); // change the text to lower case
    }
}
