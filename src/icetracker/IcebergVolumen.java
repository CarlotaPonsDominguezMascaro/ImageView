package icetracker;

import java.time.LocalDate;

public class IcebergVolumen {
    private final LocalDate date;
    private final Iceberg iceberg;
    private final double volumen;

    public IcebergVolumen(LocalDate date, Iceberg iceberg, double volumen) {
        this.date = date;
        this.iceberg = iceberg;
        this.volumen = volumen;
    }

    public LocalDate getDate() {
        return date;
    }

    public Iceberg getIceberg() {
        return iceberg;
    }

    public double getVolumen() {
        return volumen;
    }

    @Override
    public String toString(){
        return "Volumen: "+volumen;
    }
}
