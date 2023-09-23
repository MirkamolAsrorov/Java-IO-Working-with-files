package org.example;

import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) {
        findHiddenFilesFromGivenPath();

    }

    private static void findHiddenFilesFromGivenPath() {
        File file = new File("\\Users\\dJ_Sherzodbey\\Downloads");
        File[] files = file.listFiles();
        for (File hiddenFile : files){
            if (hiddenFile.isHidden()){
                System.out.println("Name: \n" + hiddenFile.getName());
                System.out.println("Path: \n" + hiddenFile.getAbsolutePath());
                System.out.println("Size: \n" + hiddenFile.length());
            }
        }
    }

    private static void getFilesNameFromGivenPath() {
        File file = new File("\\Users\\dJ_Sherzodbey\\OneDrive\\Рабочий стол");
        String[] listOfCurrentFiles = file.list();
        for (String fileName : listOfCurrentFiles) {
            System.out.println(fileName);
        }
    }

    private static void getFilePathBasedOnExist() {
        File file = new File("demoFile.txt");
        if (file.exists()) {
            System.out.println("Exist:\n" + file.getAbsolutePath());
        } else {
            try {
                System.out.println("Already exist: " + file.getCanonicalFile());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void createFileIfItIsNotExist() {
        File file = new File("demoFile.txt");
        try {
            if (file.createNewFile()) {
                System.out.println("New File is created");

            }
            System.out.println("file is already exists");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
