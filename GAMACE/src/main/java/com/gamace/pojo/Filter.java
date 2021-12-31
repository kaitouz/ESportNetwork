package com.gamace.pojo;

public class Filter {
    private String game;
    private String language;
    private String username;
    private String rank;
    private String minPrice;
    private String maxPrice;

    public String toString() {
        return game + language + username + rank;
    }

    public Filter(String username, String game, String language, String rank, String minPrice, String maxPrice) {
        if(username != null && username.length() == 0) username = null;
        if(game != null && game.length() == 0) game = null;
        if(language != null && language.length() == 0) language = null;
        if(rank != null && rank.length() == 0) rank = null;
        if(minPrice != null && minPrice.length() == 0) minPrice = null;
        if(maxPrice != null && maxPrice.length() == 0) maxPrice = null;


        this.username = username;
        this.game = game;
        this.language = language;
        this.rank = rank;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    public Integer check(Course course) {
        if(username != null && !course.getUsername().equals(username)) return -1;
        if(game != null && !course.getGame().equals(game)) return -2;
        if(language != null && !course.getLanguage().contains(language)) return -3;
        if(rank != null && !course.getLevel().equals(rank)) return -4;
        int pr = Integer.parseInt(course.getPrice());
        if(minPrice != null) {
            int mi = Integer.parseInt(minPrice);
            if(pr < mi) return -5;
        }
        if(maxPrice != null) {
            int ma = Integer.parseInt(maxPrice);
            if(pr > ma) return -6;
        }
        return 1;
    }
}
