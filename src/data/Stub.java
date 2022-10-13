package data;

import model.Pantry;
import model.Pasta;

public class Stub implements Loadable {

    @Override
    public Pantry load() {

        Pantry model = new Pantry();

        Pasta p1 = new Pasta(2.2);
        Pasta p2 = new Pasta(1.2);
        Pasta p3 = new Pasta(1.7);
        Pasta p4 = new Pasta(2.9);
        Pasta p5 = new Pasta(0.35);
        Pasta p6 = new Pasta(2.2142);

        model.addPasta(p1);
        model.addPasta(p2);
        model.addPasta(p3);
        model.addPasta(p4);
        model.addPasta(p5);
        model.addPasta(p6);

        return model;
    }
}
