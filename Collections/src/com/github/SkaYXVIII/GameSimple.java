package com.github.SkaYXVIII;

import java.util.Objects;

public class GameSimple extends  Game{
    public GameSimple(String title, int publicationDate, int rate) {
        super(title, publicationDate, rate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameSimple game = (GameSimple) o;
        return getPublicationDate() == game.getPublicationDate()
                && getRate() == game.getRate()
                && Objects.equals(getTitle(), game.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getPublicationDate(), getRate());
    }

}

