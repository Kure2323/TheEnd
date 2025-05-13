package org.example;

import java.io.*;
import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


        FileWriter fichero = new FileWriter("src/main/resources/ejemplo1.txt");
        BufferedReader e = new BufferedReader(new FileWriter());





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