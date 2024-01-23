/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.usoapiprueba;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ene
 */
public class UsoAPIPrueba {

    public static void main(String[] args) {

        try {

            String esquema = "https://";
            String servidor = "gsi.fly.dev/";
            String recurso = new String("characters").toLowerCase();

            recurso = URLEncoder.encode(recurso, StandardCharsets.UTF_8);
            String direccion = esquema+servidor+recurso;

            URL url = new URL(direccion);
            HttpURLConnection conexionURL = (HttpURLConnection) url.openConnection();
            conexionURL.setRequestMethod("GET");

            InputStream is = conexionURL.getInputStream();
            byte[] arrStream=is.readAllBytes();
            
            String json = "";
            
            for (byte b : arrStream) {
                json+=(char)b;
                
            }
            //System.out.println(json);
            
            
            Gson gson = new Gson();
            
            Characters personajes = gson.fromJson(json, Characters.class);

            System.out.println(personajes);
        } catch (IOException ex) {
            Logger.getLogger(UsoAPIPrueba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
