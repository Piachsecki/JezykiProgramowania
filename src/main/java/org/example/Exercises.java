package org.example;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Exercises {
    public static void main(String[] args) {
//        1)
//        Zaimplementuj program, który przyjmuje od użytkownika ciąg słów i przechowuje
//        je w zbiorze typu HashSet i TreeSet. Następnie wyświetl różnice między HashSet
//        a TreeSet w kontekście kolejności słów. Porównaj również czas dodawania i usuwania
//        elementów w obu zbiorach.

        ex1();
    }

    private static void ex1() {
        Set<String> myHashSet = new HashSet<>();
        Set<String> myTreeSet = new TreeSet<>();

        LocalTime now = LocalTime.now();
        for (int i = 0; i < 1000; i++) {
            myHashSet.add(String.format("str" + i));
        }
        System.out.println("Hashset: " + myHashSet);
        System.out.println("#################################################" +
                "######################################################################################");
        System.out.println("############################" +
                "###########################################################################################################");
        System.out.println("#############################" +
                "##########################################################################################################");
        System.out.println("############################" +
                "###########################################################################################################");
        System.out.println("############################" +
                "###########################################################################################################");
        LocalTime after = LocalTime.now();
        System.out.println("The time for HashSet in adding elements = " + LocalTime.of(
                after.getHour() - now.getHour(),
                after.getMinute() - now.getMinute(),
                after.getSecond() - now.getSecond(),
                after.getNano() - now.getNano()
                ));



        now = LocalTime.now();
        for (int i = 0; i < 1000; i++) {
            myTreeSet.add(String.format("str" + i));
        }
        after = LocalTime.now();

        System.out.println("TreeSet: " + myTreeSet);
        System.out.println("The time for TreeSet in adding elements = " + LocalTime.of(
                after.getHour() - now.getHour(),
                after.getMinute() - now.getMinute(),
                after.getSecond() - now.getSecond(),
                after.getNano() - now.getNano()
        ));


    }
}