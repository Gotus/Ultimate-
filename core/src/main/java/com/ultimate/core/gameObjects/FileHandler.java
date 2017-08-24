package com.ultimate.core.gameObjects;


import java.io.*;

public class FileHandler {

    private FileHandler() {}

    public static void writeObjectToFile(Serializable object, String path) throws IOException {

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
        oos.writeObject(object);
        oos.flush();
        oos.close();
    }

    public static Serializable readObjectFromFile(String path) throws IOException, ClassNotFoundException {

        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream oin = new ObjectInputStream(fis);
        return (Serializable) oin.readObject();
    }
}
