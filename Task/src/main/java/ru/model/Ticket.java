package ru.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.asm.Advice;

import java.util.HashMap;
import java.util.Map;

@JsonPropertyOrder({
        "id",
        "dapartureCity",
        "arrivalCity",
        "dapartureDate",
        "dapartureTime",
        "arrivalDate",
        "arrivalTime",
        "price"

})

public class Ticket {
    @JsonProperty("id")
    private int id;
    @JsonProperty("dapartureCity")
    private String dapartureCity;
    @JsonProperty("arrivalCity")
    private String arrivalCity;
    @JsonProperty("dapartureDate")
    private String dapartureDate;
    @JsonProperty("dapartureTime")
    private String dapartureTime;
    @JsonProperty("arrivalDate")
    private String arrivalDate;
    @JsonProperty("arrivalTime")
    private String arrivalTime;
    @JsonProperty("price")
    private Integer price;


    public Ticket(int id, String dapartureCity, String arrivalCity, String dapartureDate, String dapartureTime, String arrivalDate, String arrivalTime, Integer price) {
        this.id = id;
        this.dapartureCity = dapartureCity;
        this.arrivalCity = arrivalCity;
        this.dapartureDate = dapartureDate;
        this.dapartureTime = dapartureTime;
        this.arrivalDate = arrivalDate;
        this.arrivalTime = arrivalTime;
        this.price = price;
    }

    public Ticket() {
    }

    @JsonProperty("id")
    public int getId() {
        return id;
    }
    @JsonProperty("id")
    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("dapartureCity")
    public String getDapartureCity() {
        return dapartureCity;
    }

    @JsonProperty("dapartureCity")
    public void setDapartureCity(String dapartureCity) {
        this.dapartureCity = dapartureCity;
    }

    @JsonProperty("arrivalCity")
    public String getArrivalCity() {
        return arrivalCity;
    }

    @JsonProperty("arrivalCity")
    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    @JsonProperty("dapartureDate")
    public String getDapartureDate() {
        return dapartureDate;
    }

    @JsonProperty("dapartureDate")
    public void setDapartureDate(String dapartureDate) {
        this.dapartureDate = dapartureDate;
    }

    @JsonProperty("dapartureTime")
    public String getDapartureTime() {
        return dapartureTime;
    }

    @JsonProperty("dapartureTime")
    public void setDapartureTime(String dapartureTime) {
        this.dapartureTime = dapartureTime;
    }

    @JsonProperty("arrivalDate")
    public String getArrivalDate() {
        return arrivalDate;
    }

    @JsonProperty("arrivalDate")
    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    @JsonProperty("arrivalTime")
    public String getArrivalTime() {
        return arrivalTime;
    }

    @JsonProperty("arrivalTime")
    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @JsonProperty("price")
    public Integer getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", dapartureCity='" + dapartureCity + '\'' +
                ", arrivalCity='" + arrivalCity + '\'' +
                ", dapartureDate='" + dapartureDate + '\'' +
                ", dapartureTime='" + dapartureTime + '\'' +
                ", arrivalDate='" + arrivalDate + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", price=" + price +
                '}';
    }
}
