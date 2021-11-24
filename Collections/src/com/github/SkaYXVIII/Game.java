package com.github.SkaYXVIII;


public class Game implements Comparable<Game>{
    private String title;
    private int  publicationDate;
    private int rate;

    public Game(String title, int publicationDate, int rate){
        this.title = title;
        this.publicationDate = publicationDate;
        this.rate = rate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(int publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "{title='" + title + '\'' +
                ", publicationDate=" + publicationDate +
                ", rate=" + rate +
                '}';
    }

    @Override
    public int compareTo(Game o) {
        int result = getTitle().compareTo(o.getTitle());
        if (result == 0) result = Integer.compare(getPublicationDate(),o.getPublicationDate());
        if (result == 0) result = Integer.compare(getRate(),o.getRate());
        return result;
    }
}
