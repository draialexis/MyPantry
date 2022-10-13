package data;

import model.Pantry;

import java.io.IOException;

public interface Loadable {
    public Pantry load() throws IOException, ClassNotFoundException;
}
