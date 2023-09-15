package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Set;

public class FilePermission {
    public static void main(String[] args) throws IOException {
        File file = new File("fileForSettingPermission.txt");
        System.out.println(file.createNewFile());
        if (file.exists()) {
            System.out.println("writeable:"+ file.canWrite());
            System.out.println("readable:"+ file.canRead());
            System.out.println("executable"+ file.canExecute());
        }
        file.setWritable(false);
        System.out.println(file.canWrite());

    }

}
