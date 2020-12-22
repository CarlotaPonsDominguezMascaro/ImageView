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

    private final List<IcebergData> icebergsData = new ArrayList<>();

    public IcebergTrack() {
        Iceberg iceberg1=new Iceberg(1,"Cabo ABC", LocalDate.of(2017, Month.APRIL,1));
        Iceberg iceberg2= new Iceberg(2,"Puerto ABC", LocalDate.of(2018, Month.FEBRUARY,1));

        icebergsData.add(new IcebergData(LocalDate.of(2018, Month.SEPTEMBER, 1),iceberg1,"88oN 24'E", 9e9));
        icebergsData.add(new IcebergData(LocalDate.of(2018, Month.OCTOBER, 1),iceberg1,"80oN 12'E", 8e8));
        icebergsData.add(new IcebergData(LocalDate.of(2018, Month.SEPTEMBER, 1),iceberg2,"77oS 02'W", 7e7));
        icebergsData.add(new IcebergData(LocalDate.of(2018, Month.OCTOBER, 1),iceberg2,"78oS 03'W", 6.5e7));


    }

    private void output(){
        for(IcebergData data : icebergsData){
            System.out.println(data);

        }
    }

}
