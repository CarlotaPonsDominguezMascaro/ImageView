package icetracker;

import java.time.LocalDate;

public class Iceberg {
    private final int id;
    private final String origin;
    private final LocalDate created;

    public Iceberg(int id, String origin, LocalDate created) {
        this.id = id;
        this.origin = origin;
        this.created = created;
    }

    public int getId() {
        return id;
    }

    public String getOrigin() {
        return origin;
    }

    public LocalDate getCreated() {
        return created;
    }

    @Override
    public String toString(){
        return  " Iceberg con id: " + id + " , se origina en : "+ origin + ", en la fecha: " + created;
    }
}
