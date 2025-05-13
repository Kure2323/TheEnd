package org.example;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


        ejercicio10();


    }

    private static void ejercicio10() {
        File archivo1 = new File("src/main/resources/archivo.txt");
        File archivo2 = new File("src/main/resources/archivo2.txt");
        File res = new File("src/main/resources/resultado.txt");

        try (
                Scanner a1 = new Scanner(archivo1);
                Scanner a2 = new Scanner(archivo2);
                BufferedWriter writer = new BufferedWriter(new FileWriter(res))
        ) {
            while (a1.hasNext() || a2.hasNext()) {
                if (a1.hasNext()) {
                    writer.write(a1.next() + " ");
                }
                if (a2.hasNext()) {
                    writer.write(a2.next() + " ");
                }
            }
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void ejercicio9() {
        File archivo = new File("src/main/resources/archivo.txt");
        File archivoTemp = new File("src/main/resources/archivoTemp.txt");

        try (
                BufferedReader reader = new BufferedReader(new FileReader(archivo));
                BufferedWriter writer = new BufferedWriter(new FileWriter(archivoTemp))
        ) {
            String frase;

            while ((frase = reader.readLine()) != null) {
                String[] palabras = frase.split(" ");
                for (int i = 0; i < palabras.length; i++) {
                    if (!palabras[i].isEmpty()) {
                        palabras[i] = palabras[i].substring(0, 1).toUpperCase() + palabras[i].substring(1);
                    }
                }
                writer.write(String.join(" ", palabras));
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (archivo.delete()) {
            archivoTemp.renameTo(archivo);
            System.out.println("Archivo modificado correctamente.");
        } else {
            System.out.println("No se ha podido reemplazar el archivo original.");
        }
    }

    private static void ejercicio8() {
        String mensaje = "Blablabla";

        try {
            File file = new File("src/main/resources/archivo.txt");
            FileWriter writer = new FileWriter(file);

            writer.write(mensaje);
            writer.close();

            System.out.println("Archivo creado.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void ejercicio4() throws IOException {
        System.out.println("Introduce la cantidad de archivos:");
        int n = in.nextInt();

        System.out.println("Introduce la ruta:");
        String ruta = in.next();

        File fichero;

        for (int i = 1; i < n+1; i++) {

            fichero = new File(ruta + "nombre" + i + ".txt");
            fichero.createNewFile();

        }
    }

    public static void listarArchivos(String rutaCarpeta, String extension) {

        File carpeta = new File(rutaCarpeta);
        if (carpeta.isDirectory()) {
            File[] archivos = carpeta.listFiles();
            if (archivos != null && archivos.length > 0) {
                for (File f : archivos) {
                    if (f.isFile() && f.getName().endsWith(extension)) {
                        System.out.println(f.getName() + " - " + f.length() + "bytes");
                    }
                }
            }else{
                System.out.println("No se ha encontrado ningún archivo.");
            }
        } else System.err.println("La ruta proporcionada no es una carpeta");
    }
    public static void listarArchivos(String rutaCarpeta) {

        File carpeta = new File(rutaCarpeta);
        if (carpeta.isDirectory()) {
            File[] archivos = carpeta.listFiles();
            if (archivos != null && archivos.length > 0) {
                for (File f : archivos) {
                    if (f.isFile()) {
                        System.out.println(f.getName() + " - " + f.length() + "bytes");
                    }
                }
            }else{
                System.out.println("No se ha encontrado ningún archivo.");
            }
        } else System.err.println("La ruta proporcionada no es una carpeta");
    }
}