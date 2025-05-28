package org.example.Practica4.Ejercicio2;
// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */

public class Ethereum{
    public double usd;
    public double eur;

    @Override
    public String toString() {
        return "Ethereum{" +
                "usd=" + usd +
                ", eur=" + eur +
                '}';
    }
}