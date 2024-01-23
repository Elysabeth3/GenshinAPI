package com.mycompany.usoapigenshin;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class PrimaryController implements Initializable {
    
    private String rootURL = "https://gsi.fly.dev";
    private String recurso = "/characters";
    private Characters personajes;
    
    @FXML
    Button Pyro;
    @FXML
    Button Hydro;
    @FXML
    Button Cryo;
    @FXML
    Button Electro;
    @FXML
    Button Anemo;
    @FXML
    Button Geo;
    @FXML
    Button Dendro;
    @FXML
    ChoiceBox<String> armas;
    @FXML
    Label page;
    @FXML
    Button next;
    @FXML
    Button back;
    @FXML
    Button search;
    
    @FXML
    ScrollPane scrollPane;
    
    @FXML
    TextArea contenido;
    
    String elemento;
    
    private String[] weapons = { "Sword", "Bow", "Polearm", "Claymore", "Catalyst"};
    
    @FXML
    private void pulsarPyro() throws IOException {
        elemento = Pyro.getId();
    }
    
    @FXML
    private void pulsarHydro() throws IOException {
        elemento = Hydro.getId();
    }
    @FXML
    private void pulsarCryo() throws IOException {
        elemento = Cryo.getId();
    }
    @FXML
    private void pulsarElectro() throws IOException {
        elemento = Electro.getId();
    }
    @FXML
    private void pulsarGeo() throws IOException {
        elemento = Geo.getId();
    }
    @FXML
    private void pulsarAnemo() throws IOException {
        elemento = Anemo.getId();
    }
    @FXML
    private void pulsarDendro() throws IOException {
        elemento = Dendro.getId();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            armas.getItems().addAll(weapons);
            String direccion = rootURL+recurso;
            
            String json = getJSON(direccion);

            crearVista(json);
            
            if (personajes.getTotal_pages()==1) {
            next.setVisible(false);
            back.setVisible(false);
        }
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getJSON(String direccion) throws IOException, ProtocolException, MalformedURLException {
        URL enlace = new URL(direccion);
        HttpURLConnection conexionURL = (HttpURLConnection) enlace.openConnection();
        conexionURL.setRequestMethod("GET");
        InputStream is = conexionURL.getInputStream();
        byte[] arrStream = is.readAllBytes();
        String json = "";
        for (byte b : arrStream) {
            json += (char) b;
            
        }
        return json;
    }
    
    @FXML
    private void pulsarBuscar() throws IOException {
        String busqueda = null;
        
        if (elemento != null) {
            if (armas.getValue() != null) {
                busqueda = "/search?vision="+elemento+"&weapon=" + armas.getValue();
            } else {
                 busqueda = "/search?vision="+elemento;
            }
        } else if( armas.getValue() != null){
            busqueda = "/search?weapon="+armas.getValue();
        }
        if (busqueda != null) {
            String direccion = rootURL+recurso+busqueda;
            String json = getJSON(direccion);
            crearVista(json);
        } else{
            String direccion = rootURL+recurso;
            
            String json = getJSON(direccion);

            crearVista(json);
        }
        elemento = null;
        armas.setValue(null);
        if (personajes.getTotal_pages()==1) {
            next.setVisible(false);
            back.setVisible(false);
        } else {
            next.setVisible(true);
            back.setVisible(true);
        }
    }
    
    @FXML
    private void pulsarSiguiente() throws IOException {
        if(personajes.getTotal_pages() > 1){
        int paginaSiguiente =(Integer.parseInt(page.getText()) + 1);
        String siguiente = "?page="+paginaSiguiente;
        
        String direccion = rootURL+recurso+siguiente;
            String json = getJSON(direccion);
            crearVista(json);
        }
    }

    public void crearVista(String json) throws JsonSyntaxException {
        Gson gson = new Gson();
        
        personajes = gson.fromJson(json, Characters.class);
        
        page.setText(personajes.getPage()+"");
        contenido.setText(personajes.toString());
    }
    
    @FXML
    private void pulsarAnterior() throws IOException {
        String anterior = null;
        if(personajes.getTotal_pages()>1){
        int paginaAnterior = (Integer.parseInt(page.getText()) - 1);
        if (paginaAnterior>=1) {
            anterior = "?page="+paginaAnterior;
        }
        if (anterior != null) {
           String direccion = rootURL+recurso+anterior;
            String json = getJSON(direccion);
            crearVista(json);
        }
        }
         
         
         
    }
    
}
