package org.example.Practica4.Ejercicio2;


import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws IOException {

        String apiUrl = "https://api.coingecko.com/api/v3/simple/price?ids=bitcoin,ethereum&vs_currencies=usd,eur";

        URL url = new URL(apiUrl);
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        conexion.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
        StringBuilder json = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null) {
            json.append(line);
        }
        in.close();

        Gson gson = new Gson();
        Root root = gson.fromJson(json.toString(), Root.class);
        System.out.println("Bitcoin: " + root.bitcoin);
        System.out.println("Ethereum: " + root.ethereum);

    }

}
