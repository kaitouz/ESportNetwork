package com.gamace.pojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CourseAndCoach {
    private int id;
    private String username;
    private String game;
    private String language;
    private String level;
    private String price;
    private String first_name;
    private String last_name;
    private String email;
    private String phone_number;
    private String descritption;

    public int getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }

    public String getGame() {
        return game;
    }

    public String getGameName() {
        HashMap<String, String> h = new HashMap<String, String>() {{
            put("lol", "League of Legends");
            put("csgo", "Counter-Strike: Global Offensive");
            put("apex", "Apex Legends");
            put("dota2", "DOTA2");
            put("tft", "Teamfight Tactics");
            put("wildrift", "Wild Rift");
            put("valorant", "Valorant");
        }};

        return h.get(this.game);
    }

    public List<String> getLanguageList() {
        List<String> ret = new ArrayList<String>(Arrays.asList(language.split(",")));
        return ret;
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

    public String getPriceStr() {
        return "$" + price;
    }

    public String getDescription() {
        return descritption;
    }

    public String getDescriptionShort() {
        if(descritption.length() <= 93)
            return descritption;
        return descritption.substring(0, 91);
    }

    public String getDescriptionExtend() {
        if(descritption.length() <= 93)
            return "";
        return descritption.substring(92);
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


    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getFullName() {
        return (first_name + " " + last_name);
    }



    public CourseAndCoach(String username, String game, String language, String level, String price, String first_name, String last_name, String email, String phone_number, String descritption) {
        this.username = username;
        this.game = game;
        this.language = language;
        this.level = level;
        this.price = price;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone_number = phone_number;
        this.descritption = descritption;
    }

    public CourseAndCoach(User user, Course course) {
        this.id = course.getId();
        this.username = user.getUsername();
        this.game = course.getGame();
        this.language = course.getLanguage();
        this.level = course.getLevel();
        this.price = course.getPrice();
        this.first_name = user.getFirst_name();
        this.last_name = user.getLast_name();
        this.email = user.getEmail();
        this.phone_number = user.getPhone_number();
        this.descritption = course.getDescription();
    }
}
