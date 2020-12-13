package day7;

import java.util.List;

public class Bag {

    String description;

    List<Bag> inner;

    Bag(String description, List<Bag> inner) {
        this.description = description;
        this.inner = inner;
    }

}
