package com.github.SkaYXVIII;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ConsoleApp {

    private final static String COLLECTION_MENU =
            "Wybierz typ kolekcji: \n" +
            " - Set: \n" +
            "   1 - HashSet \n" +
            "   2 - TreeSet \n" +
            "   3 - TreeSet z Comparator \n" +
            " - List: \n" +
            "   4 - ArrayList \n" +
            "   5 - LinkedList \n" +
            " - Map: \n" +
            "   6 - HashMap \n" +
            "   7 - TreeMap \n" +
            "   8 - TreeMap z Comparator \n" +
            " 9 - Wyjście \n"
                  ;

    private final static String OPERATIONS_MENU =
            "Wybierz operację: \n" +
            "1 - Dodaj kilka tych samych obiektów z nadpisananymi metodami hashCode i equals, comparable oraz comparatorem. \n" +
            "2 - Dodaj kilka różnych obiektów z nadpisananymi metodami hashCode i equals, comparable oraz comparatorem. \n" +
            "3 - Dodaj kilka tych samych obiektów z domyślnymi metodami hashCode i equals, comparable. \n" +
            "4 - Dodaj kilka różnych obiektów z domyślnymi metodami hashCode i equals, comparable. \n" +
            "5 - Usuń losowy element. \n" +
            "6 -  Wyświetl kolekcję. \n" +
            "7 - Wróć \n";

    ConsoleDialog consoleDialog = new ConsoleDialog();

    Set<?> currentSet;
    Map<?,Integer> currentMap;
    List<?> currentList;


    public void runApp(){
     
    }

    public void mainMenu(){
        System.out.println(COLLECTION_MENU);
        switch (consoleDialog.requestInt()){
            case 1: break;
            case 2: break;
            case 3: break;
            case 4: break;
            case 5: break;
            case 6: break;
            case 7: break;
            case 8: break;
            case 9: break;

        }


    }

}
