package icetracker;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class IcebergTrack {
    public static void main(String[] arg){
        IcebergTrack icebergTrack = new IcebergTrack() ;
        icebergTrack.output();

    }

    private final List<Iceberg> icebergs = new ArrayList<>();
    private final List<IcebergPosition> positions = new ArrayList<>();
    private final List<IcebergVolumen> volumen = new ArrayList<>();

    public IcebergTrack() {
        icebergs.add(new Iceberg(1,"Cabo ABC", LocalDate.of(2017, Month.APRIL,1)));
        icebergs.add(new Iceberg(2,"Puerto ABC", LocalDate.of(2018, Month.FEBRUARY,1)));

        positions.add(new IcebergPosition(LocalDate.of(2018,Month.APRIL,1),icebergs.get(0),"88ºN 24 E"));
        positions.add(new IcebergPosition(LocalDate.of(2018,Month.JULY,1),icebergs.get(0),"88ºN 24 E"));
        positions.add(new IcebergPosition(LocalDate.of(2019,Month.APRIL,1),icebergs.get(1),"88ºN 24 E"));
        positions.add(new IcebergPosition(LocalDate.of(2019,Month.FEBRUARY,1),icebergs.get(1),"88ºN 24 E"));
    }

    private void output(){
        for (Iceberg i : icebergs) {
            System.out.println(i.toString());

            for (IcebergPosition p : positions) {
                if (p.getIceberg().equals(i)){
                    System.out.println(p.toString());
                    for (IcebergVolumen v : volumen){
                        if (v.getIceberg().equals(i)&& v.getDate().equals(p.getDate())){
                            System.out.println(v);
                        }
                    }
                }
            }
        }
    }

}
