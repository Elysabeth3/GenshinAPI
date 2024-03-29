/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.usoapigenshin;

/**
 *
 * @author ene
 */
public class Characters {
    private int page;
    private Character[] results;
    private int total_results;
    private int total_pages;

    public Characters(int page, Character[] results, int total_results, int total_pages) {
        this.page = page;
        this.results = results;
        this.total_results = total_results;
        this.total_pages = total_pages;
    }
    
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public Character[] getResults() {
        return results;
    }

    public void setResults(Character[] results) {
        this.results = results;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }
    

    @Override
    public String toString() {
        String cadena = "Personajes: \n";
        for (int i = 0; i < results.length; i++) {
            cadena += results[i].toString() + "\n";
        }
        cadena += "}";
        return cadena;
    }
    
    
}
