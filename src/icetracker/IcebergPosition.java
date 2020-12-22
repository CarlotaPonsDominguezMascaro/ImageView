package icetracker;

import java.time.LocalDate;

public class IcebergPosition {
    private  final LocalDate date;
    private final Iceberg iceberg;
    private final String coordinates;

    public IcebergPosition(LocalDate date, Iceberg iceberg, String coordinates) {
        this.date = date;
        this.iceberg = iceberg;
        this.coordinates = coordinates;
    }

    public LocalDate getDate() {
        return date;
    }

    public Iceberg getIceberg() {
        return iceberg;
    }

    public String getCoordinates() {
        return coordinates;
    }
    @Override
    public  String toString(){
        return "En: "+ date+ ", sus coordenadas son: "+ coordinates;
    }
}
