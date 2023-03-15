package view;


import org.eclipse.aether.spi.log.LoggerFactory;
import ru.JsonReader;
import ru.model.Ticket;

import ru.service.StockService;

import java.io.IOException;
import java.util.List;
import java.util.OptionalDouble;
import java.util.logging.Logger;

public class StockView {


    public static void main( String[] args ) throws IOException {

        //среднее время полета
        double f = StockService.AVGFlightTime("VVO", "TLV");
        System.out.println(f);

        //Percentile
        double p = StockService.getPercentile("VVO", "TLV", 90);
        System.out.println(p);
    }

}
