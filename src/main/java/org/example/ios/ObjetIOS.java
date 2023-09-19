package org.example.ios;

import lombok.Getter;
import lombok.Setter;

import java.io.*;



public class ObjetIOS {
    static class Student implements Serializable {
    int id;
    String name;

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public Student(int id, String name){
        this.id = id;
        this.name = name;
    }

    }
    public static void main(String[] args) {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream("tetOut.txt"));

            Student deserializedStudent = (Student) objectInputStream.readObject();
            System.out.println(deserializedStudent.getId() + " " + deserializedStudent.name);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    private static void serializeObject() {
        Student serializedStudent =new Student(122, "John");
        try {
            ObjectOutputStream objectOutput = new ObjectOutputStream(
                    new FileOutputStream("testOut.txt"));
            objectOutput.writeObject(serializedStudent);
            objectOutput.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
