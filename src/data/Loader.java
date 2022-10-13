package data;

import model.Pantry;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Loader implements Loadable {

    private static Loader instance;

    private Loader() {}

    public static Loader getInstance() {
        if (instance == null) {
            instance = new Loader();
        }
        return instance;
    }

    @Override
    public Pantry load() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("save.bin"))) {
            return (Pantry) ois.readObject();
        }
    }
}
