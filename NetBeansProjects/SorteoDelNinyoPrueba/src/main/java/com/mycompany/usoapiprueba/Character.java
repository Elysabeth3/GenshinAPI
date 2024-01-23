/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.usoapiprueba;

/**
 *
 * @author ene
 */
public class Character {
    private int id;
    private String name;
    private String rarity;
    private String weapon;
    private String vision;
    private String wiki_url;

    public Character(int id, String name, String rarity, String weapon, String vision, String wiki_url) {
        this.id = id;
        this.name = name;
        this.rarity = rarity;
        this.weapon = weapon;
        this.vision = vision;
        this.wiki_url = wiki_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getVision() {
        return vision;
    }

    public void setVision(String vision) {
        this.vision = vision;
    }

    public String getWiki_url() {
        return wiki_url;
    }

    public void setWiki_url(String wiki_url) {
        this.wiki_url = wiki_url;
    }

    @Override
    public String toString() {
        return "Character{" + "id=" + id + ", name=" + name + ", rarity=" + rarity + ", weapon=" + weapon + ", vision=" + vision + ", wiki_url=" + wiki_url + '}';
    }
    
    
}
