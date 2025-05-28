package org.example.Practica4.Ejercicio1;

import java.util.List;



public class Videojuego {
    private String nombre;
    private String plataforma;
    private double precio;
    private boolean disponible;
    List<String> generos;

    public Videojuego () {}

    public Videojuego(String nombre, String plataforma, double precio, boolean disponible, List<String> generos) {
        this.nombre = nombre;
        this.plataforma = plataforma;
        this.precio = precio;
        this.disponible = disponible;
        this.generos = generos;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Videojuego{" +
                "nombre='" + nombre + '\'' +
                ", plataforma='" + plataforma + '\'' +
                ", precio=" + precio +
                ", disponible=" + disponible +
                ", generos=" + generos +
                '}';
    }

}
