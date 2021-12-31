package com.gamace.pojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User implements Comparable<User>{

    private int id;
    private String username;
    private String password;
    private String first_name;
    private String last_name;
    private String email;
    private String phone_number;
    private String role;
    private String language;
    private String game;
    private String contact;
    private String bio;
    private String facebook;
    private String instagram;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getFullName() {
        return first_name + " " + last_name;
    }


    public String getEmail() {
        return email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getLanguage() {
        return language;
    }

    public String getFacebook() {
        return facebook;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }


    public Boolean facebookCheck() {
        return (facebook != null && !facebook.equals(""));
    }

    public Boolean instagramCheck() {
        return (instagram != null && !instagram.equals(""));
    }

    public List<String> getLanguageList() {
        List<String> ret = new ArrayList<String>(Arrays.asList(language.split(",")));
        return ret;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getGame() {
        return game;
    }

    public List<String> getGameList() {
        List<String> ret = new ArrayList<String>(Arrays.asList(game.split(",")));
        return ret;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String toString() {
        return   username + ";"
                + password + ";"
        +  first_name + ";"
        + last_name + ";"
        + email + ";"
        + phone_number + ";"
        + role + ";"
        + facebook;
    }

    public User(String username, String password, String first_name, String last_name, String email, String phone_number, String role, String game, String language, String bio, String facebook, String instagram) {
        if(username == null || username.length() == 0) username = null;
        if(password == null || password.length() == 0) password = null;
        if(first_name == null || first_name.length() == 0) first_name = null;
        if(last_name == null || last_name.length() == 0) last_name = null;
        if(role == null || role.length() == 0) role = null;
        if(bio == null || bio.length() == 0) bio = null;
        if(email == null || email.length() == 0) email = null;
        if(game == null || game.length() == 0) game = null;
        if(language == null || language.length() == 0) language = null;
        if(phone_number == null || phone_number.length() == 0) phone_number = null;
        if(facebook == null || facebook.length() == 0) facebook = "";
        if(instagram == null || instagram.length() == 0) instagram = "";

        this.username = username;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone_number = phone_number;
        this.role = role;
        this.game = game;
        this.language = language;
        this.facebook = facebook;
        this.instagram = instagram;
    }

    @Override
    public int compareTo(User o) {
        return Integer.compare(o.getId(), this.getId());
    }
}
