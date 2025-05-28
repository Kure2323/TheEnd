package org.example.Practica4.Ejercicio2;
// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1


public class Bitcoin{
    public int usd;
    public int eur;

    @Override
    public String toString() {
        return "Bitcoin{" +
                "usd=" + usd +
                ", eur=" + eur +
                '}';
    }
}
