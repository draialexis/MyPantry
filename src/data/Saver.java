package data;

import model.Pantry;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Saver implements Savable {

    private static Saver instance;

    private Saver() {}

    public static Saver getInstance() {
        if (instance == null) {
            instance = new Saver();
        }
        return instance;
    }

    @Override
    public void save(Pantry model) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("save.bin"))) {
            oos.writeObject(model);
        }
    }
}
