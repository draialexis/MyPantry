package data;

import model.Pantry;

import java.io.IOException;

public interface Savable {
    public void save(Pantry model) throws IOException;
}
