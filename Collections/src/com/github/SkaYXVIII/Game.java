package com.github.SkaYXVIII;

public class Game {
    private String title;
    private int  publicationDate;
    private int rate;

    public Game(String title, int publicationDate, int rate) {
        this.title = title;
        this.publicationDate = publicationDate;
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "{title='" + title + '\'' +
                ", publicationDate=" + publicationDate +
                ", rate=" + rate +
                '}';
    }
}
