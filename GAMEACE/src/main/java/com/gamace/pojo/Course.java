package com.gamace.pojo;

import java.util.HashMap;
import java.util.Map;

public class Course {
    private int id;
    private String username;
    private String game;
    private String language;
    private String level;
    private String price;
    private String description;

    public int getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }

    public String getGame() {
        return game;
    }

    public String getLanguage() {
        return language;
    }

    public String getLevel() {
        return level;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public void setLanguague(String languague) {
        this.language = languague;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return String.valueOf(id) + ";"
                + username + ";"
                + game + ";"
                + language + ";"
                +level + ";"
                + price  + ";"
                + description;
    }

    public String getGameName() {
        Map<String, String> mapGameName  = new HashMap<String, String>() {{
            put("lol", "League of Legends");
            put("dota2", "DOTA2");
            put("apex", "Apex Legends");
            put("tft", "Teamfight Tactics");
            put("valorant", "Valorant");
            put("wildrift", "Wild Rift");
            put("csgo", "Counter-Strike: Global Offensive");
        }};
       return mapGameName.get(game);
    }

    public String getLevelName() {
        Map<String, String> mapLevelName  = new HashMap<String, String>() {{
            put("1", "Challenger");
            put("2", "Grandmaster");
        }};
        return mapLevelName.get(level);
    }

    public Course(String username, String game, String language, String level, String price, String description) {
        this.username = username;
        this.game = game;
        this.language = language;
        this.level = level;
        this.price = price;
        this.description = description;
    }
}
