package com.github.SkaYXVIII;

import java.util.Arrays;
import java.util.List;

public class GamesFactory {
    public List<Game> addSeveralEqualsGames(){
        Game game1 = new Game("Dark souls",2016,94);
        Game game2 = new Game("Dark souls",2016,94);
        Game game3 = new Game("Dark souls",2016,94);
        Game game4 = new Game("Dark souls",2016,94);
        List<Game> games = Arrays.asList(game1,game2,game3,game4);
        return games;
    }
    public List<Game> addSeveralDifferentGames(){
        Game game1 = new Game("Dark souls",2016,94);
        Game game2 = new Game("Dark souls",2014,89);
        Game game3 = new Game("Counter-Strike",2012,93);
        Game game4 = new Game("League of Legends",2009,76);
        Game game5 = new Game("Counter-Strike",1999,99);
        List<Game> games = Arrays.asList(game1,game2,game3,game4,game5);
        return games;
    }

    public List<Game> addSeveralEqualsGamesSimple(){
        Game game1 = new GameSimple("Dark souls",2016,94);
        Game game2 = new GameSimple("Dark souls",2016,94);
        Game game3 = new GameSimple("Dark souls",2016,94);
        Game game4 = new GameSimple("Dark souls",2016,94);
        List<Game> games = Arrays.asList(game1,game2,game3,game4);
        return games;
    }

    public List<Game> addSeveralDifferentGamesSimple(){
        Game game1 = new GameSimple("Dark souls",2016,94);
        Game game2 = new GameSimple("Dark souls",2014,89);
        Game game3 = new GameSimple("Counter-Strike",2012,93);
        Game game4 = new GameSimple("League of Legends",2009,76);
        Game game5 = new Game("Counter-Strike",1999,99);

        List<Game> games = Arrays.asList(game1,game2,game3,game4,game5);
        return games;
    }
}
