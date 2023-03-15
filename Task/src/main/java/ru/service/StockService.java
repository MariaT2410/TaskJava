package ru.service;

import lombok.RequiredArgsConstructor;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import ru.JsonReader;
import ru.model.Ticket;


import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;


@RequiredArgsConstructor
public class StockService {
    private static List<Ticket> list;
    //private final StockStorage stockStorage;


    public static List<Ticket> getTicketsList() throws IOException {
         return JsonReader.getTickets();
    }

    // среднее время полета
    public static double AVGFlightTime(String dapartureCity, String arrivalCity) throws IOException {
        ZoneOffset offset = ZoneOffset.of("-08:00");
    double avgMinute = getTicketsList().stream()
            .filter(o->o.getDapartureCity().equals(dapartureCity)&&o.getArrivalCity().equals(arrivalCity))
            .map(t-> LocalDateTime.parse(t.getDapartureDate()+" "+t.getDapartureTime(), DateTimeFormatter.ofPattern("dd.MM.yy HH:mm:ss"))
                    .until(LocalDateTime.parse(t.getArrivalDate()+" "+t.getArrivalTime(), DateTimeFormatter.ofPattern("dd.MM.yy HH:mm:ss")), ChronoUnit.MINUTES))
            .mapToLong(s -> s)
            .average().orElse(-1);

    return (avgMinute-480);
    }

    //Percentile
    public static double getPercentile(String dapartureCity, String arrivalCity, double percentile) throws IOException {
        List<Long> flightTime = getTicketsList().stream()
                .filter(o -> o.getDapartureCity().equals(dapartureCity) && o.getArrivalCity().equals(arrivalCity))
                .map(t -> LocalDateTime.parse(t.getDapartureDate() + " " + t.getDapartureTime(), DateTimeFormatter.ofPattern("dd.MM.yy HH:mm:ss"))
                        .until(LocalDateTime.parse(t.getArrivalDate() + " " + t.getArrivalTime(), DateTimeFormatter.ofPattern("dd.MM.yy HH:mm:ss")), ChronoUnit.MINUTES)-480)
                .sorted().collect(Collectors.toList());

        DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics();

        for (double v : flightTime) {
            descriptiveStatistics.addValue(v);
        }
        return descriptiveStatistics.getPercentile(percentile);
    }

}
