package com.github.SkaYXVIII;

import java.util.*;

public class ConsoleApp{

    private final static String COLLECTION_MENU =
            "Wybierz typ kolekcji: \n" +
            " - Set: \n" +
            "   1 - HashSet \n" +
            "   2 - TreeSet \n" +
            " - List: \n" +
            "   3 - ArrayList \n" +
            "   4 - LinkedList \n" +
            " - Map: \n" +
            "   5 - HashMap \n" +
            "   6 - TreeMap \n" +
            " 7 - Wyjście \n"
                  ;

    private final static String OPERATIONS_MENU =
            "Wybierz operację: \n" +
            "1 - Dodaj kilka tych samych obiektów z nadpisananymi metodami hashCode i equals \n" +
            "2 - Dodaj kilka różnych obiektów z nadpisananymi metodami hashCode i equals \n" +
            "3 - Dodaj kilka tych samych obiektów z domyślnymi metodami hashCode i equals \n" +
            "4 - Dodaj kilka różnych obiektów z domyślnymi metodami hashCode i equals \n" +
            "5 - Usuń losowy element. \n" +
            "6 -  Wyświetl kolekcję. \n" +
            "7 - Wróć \n";

    ConsoleDialog consoleDialog = new ConsoleDialog();
    GamesFactory gamesFactory = new GamesFactory();

    StoreType currentStoreType;
    Set<Game> set;
    Map<Integer,Game> map;
    List<Game> list;



    public void runApp(){
        while (true){
            mainMenu();
        }

    }

    private void mainMenu(){
        System.out.println(COLLECTION_MENU);
        switch (consoleDialog.requestInt()){
            case 1:
                set = new HashSet<>();
                currentStoreType = StoreType.SET;
                break;
            case 2:
                set = new TreeSet<>();
                currentStoreType = StoreType.SET;
                break;
            case 3:
                list = new ArrayList<>();
                currentStoreType = StoreType.LIST;
                break;
            case 4:
                list = new LinkedList<>();
                currentStoreType = StoreType.LIST;
                break;
            case 5:
                map = new HashMap<>();
                currentStoreType = StoreType.MAP;
                break;
            case 6:
                map = new TreeMap<>();
                currentStoreType = StoreType.MAP;
                break;
            case 7: System.exit(0);

            default: mainMenu();
        }
        collectionMenu();
    }

    private void collectionMenu(){
        boolean back = false;
        while (!back){
            System.out.println(OPERATIONS_MENU);
            switch(consoleDialog.requestInt()){
                case 1:
                    addElement(gamesFactory.addSeveralEqualsGamesSimple());
                    break;
                case 2:
                    addElement(gamesFactory.addSeveralDifferentGamesSimple());
                    break;
                case 3:
                    addElement(gamesFactory.addSeveralEqualsGames());
                    break;
                case 4:
                    addElement(gamesFactory.addSeveralDifferentGames());
                    break;
                case 5:
                    deleteRandomElement();
                    break;
                case 6:
                    printData();
                    break;
                case 7:
                    back = true;
                    break;

                default: collectionMenu();
            }
        }

    }

    private void addElement(List<Game> games){
        switch (currentStoreType){
            case MAP:
                for (int i = 0; i < games.size(); i++) {
                    map.put(i+1,games.get(i));
                }
                break;
            case LIST:
                list.addAll(games);
                break;
            case SET:
                set.addAll(games);
                break;
        }
    }
    private void deleteRandomElement(){
        Random random = new Random();
        switch (currentStoreType) {
            case MAP:
                if (map.size() == 0){
                    System.out.println("Kolekcja jest pusta");
                    return;
                }
                int indexToRemove = random.nextInt(map.size());
                for (int key : map.keySet()) {
                    if (key - 1 == indexToRemove) {
                        map.remove(key);
                        return;
                    }
                }

                break;

            case LIST:
                if (list.size() == 0){
                    System.out.println("Kolekcja jest pusta");
                    return;
                }
                list.remove(random.nextInt(list.size()));
                break;

            case SET:
                if (set.size() == 0){
                    System.out.println("Kolekcja jest pusta");
                    return;
                }
                indexToRemove = random.nextInt(set.size());
                int index = 0;
                for (var game : set) {
                    if (index == indexToRemove) {
                        set.remove(game);
                        return;
                    }
                    index++;
                }
                break;
        }
    }
    private void printData(){
        switch (currentStoreType){
            case LIST:
                System.out.println(list.getClass().getName());
                list.forEach(System.out::println);
                System.out.println("\n");
                break;
            case SET:
                System.out.println(set.getClass().getName());
                set.forEach(System.out::println);
                break;
            case MAP:
                System.out.println(map.getClass().getName());
                map.forEach((key,value) -> System.out.println(key + ": " + value));
                break;
        }
    }
    private enum StoreType {
        SET,MAP,LIST
    }
}
