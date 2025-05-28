package org.example.Practica4.Ejercicio1;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    static java.util.Scanner in = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        practica1();
    }

    private static void practica1() {

        ArrayList<Videojuego> lista = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            System.out.println("Introduce el nombre del videojuego " + (i+1) + ":");
            String nombre = in.nextLine();

            System.out.println("Introduce la plataforma:");
            String plataforma = in.nextLine();

            System.out.println("Introduce el precio:");
            double precio = in.nextDouble();

            System.out.println("¿Está disponible? (true/false):");
            boolean disponible = in.nextBoolean();
            in.nextLine();

            System.out.println("Introduce los géneros (separados por comas):");
            String generosInput = in.nextLine();

            String[] generosArray = generosInput.split(",");
            lista.add(new Videojuego(nombre, plataforma, precio, disponible, Arrays.asList(generosArray)));
        }

        //Guardar la lista en un archivo JSON
        Gson gson = new Gson();
        String json = gson.toJson(lista);
        System.out.println("Lista de videojuegos en formato JSON:" + json);

        try (FileWriter writer = new FileWriter("src/main/resources/videojuegos.json")) {
            gson.toJson(lista, writer);
            System.out.println("Lista de videojuegos guardada en videojuegos.json");
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }

        try {
            FileReader reader = new FileReader("src/main/resources/videojuegos.json");
            // Leer el archivo JSON y convertirlo a una lista de objetos Videojuego
            Videojuego[] videojuegos = gson.fromJson(reader, Videojuego[].class);
            // Convertir el array a una lista
            lista = new ArrayList<>(Arrays.asList(videojuegos));
            System.out.println("Lista de videojuegos leída desde videojuegos.json. Añadiendo uno más...");
            lista.add(new Videojuego("Outer Wilds", "Steam", 29.99, true, Arrays.asList("Aventura", "Acción")));

            System.out.println("Lista de videojuegos de menos de 30 euros:");
            for (Videojuego v : lista) {
                if (v.getPrecio() < 30) {
                    System.out.println(v);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Volver a guardar la lista actualizada en el archivo JSON
        try (FileWriter writer = new FileWriter("src/main/resources/videojuegos.json")) {
            gson.toJson(lista, writer);
            System.out.println("Lista de videojuegos actualizada y guardada en videojuegos.json");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
