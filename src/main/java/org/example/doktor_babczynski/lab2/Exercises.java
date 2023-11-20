package org.example.doktor_babczynski.lab2;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class Exercises {
    public static void main(String[] args) {
//        1)
//        Zaimplementuj program, który przyjmuje od użytkownika ciąg słów i przechowuje
//        je w zbiorze typu HashSet i TreeSet. Następnie wyświetl różnice między HashSet
//        a TreeSet w kontekście kolejności słów. Porównaj również czas dodawania i usuwania
//        elementów w obu zbiorach.
        ex1();


//        2)
//        Stwórz program, który generuje losowe liczby i dodaje je do listy typu ArrayList i LinkedList.
//        Następnie przetestuj, jak długo trwa dodawanie, usuwanie i przeszukiwanie elementów w obu listach.

        ex2();

//        4)
//        Zaimplementuj klasę reprezentującą użytkownika z polami takimi jak nazwa użytkownika,
//        adres e-mail i numer ID. Napisz metody equals() i hashCode(), aby porównywały użytkowników na podstawie numeru ID.
//        Stwórz HashSet i dodaj kilku użytkowników o tym samym numerze ID oraz kilku różnych. Przeanalizuj wynik.

        ex4();

//        5)
//        Stwórz klasę reprezentującą zamówienie z polami, takimi jak numer zamówienia, data i kwota.
//        Zaimplementuj interfejs Comparable, aby zamówienia były porównywane na podstawie daty.
//        Stwórz listę zamówień i posortuj ją za pomocą Collections.sort().
//        Następnie wyświetl posortowaną listę.
//        Zmodyfikuj zadanie, aby tym razem użyć własnego komparatora do sortowania zamówień według kwoty.
//        Wyświetl wynik i porównaj go z poprzednim.

        ex5();

    }

    private static void ex5() {
        List<Purchase> data = List.of(
                new Purchase(1, LocalDate.of(2019, 10, 12), new BigDecimal(1243.23)),
                new Purchase(2, LocalDate.of(3000, 10, 12), new BigDecimal(123.43)),
                new Purchase(3, LocalDate.of(1900, 10, 12), new BigDecimal(8563.21)),
                new Purchase(4, LocalDate.of(2016, 10, 12), new BigDecimal(36432.23))
        );

        List<Purchase> purchases = new ArrayList<>(data);

        System.out.println("Before: " + purchases);
        Collections.sort(purchases);
        System.out.println("After: " + purchases);


        System.out.println("Before: " + purchases);
        purchases.sort(new Comparator<Purchase>() {
            @Override
            public int compare(Purchase o1, Purchase o2) {
                return o1.getAmount().subtract(o2.getAmount()).intValue();
            }
        });
        System.out.println("After: " + purchases);


    }

    private static void ex4() {
        Set<User> myHashSet = new HashSet<>();

        List<User> users = List.of(
                new User(1, "Kacper", "kacper@gmail.com"),
                new User(1, "Wojtek", "a231@gmail.com"),
                new User(2, "Maciek", "SSS@gmail.com"),
                new User(2, "AA", "kacper@gmail.com"),
                new User(3, "dsda", "sds123@gmail.com"),
                new User(4, "gasgd", "kacper@gmail.com"),
                new User(4, "aSDF", "sdas3@gmail.com"),
                new User(5, "ASDFAS", "342@gmail.com"),
                new User(6, "FDSFD", "asd34@gmail.com"),
                new User(7, "asd", "5322sdas@gmail.com")
        );
        myHashSet.addAll(users);
        System.out.println(users);

    }

    private static void ex2() {

        List<Integer> myLinkedList = new LinkedList<>();
        List<Integer> myArrayList = new ArrayList<>();


        Random random = new Random();
        LocalTime now = LocalTime.now();
        for (int i = 0; i < 8000; i++) {
            myArrayList.add(random.nextInt(10000 - 2 + 1) + 2);
        }
        LocalTime after = LocalTime.now();

        System.out.println("The time for ArrayList in adding elements = " + LocalTime.of(
                after.getHour() - now.getHour(),
                after.getMinute() - now.getMinute(),
                after.getSecond() - now.getSecond(),
                after.getNano() - now.getNano()
        ));


        now = LocalTime.now();
        for (int i = 0; i < 8000; i++) {
            myLinkedList.add(random.nextInt(10000 - 2 + 1) + 2);
        }
        after = LocalTime.now();


        System.out.println("The time for LinkedList in adding elements = " + LocalTime.of(
                after.getHour() - now.getHour(),
                after.getMinute() - now.getMinute(),
                after.getSecond() - now.getSecond(),
                after.getNano() - now.getNano()
        ));
        System.out.println("Array List: ");

        Integer integer1 = myArrayList.get(1000);
        Integer integer2 = myArrayList.get(2000);
        Integer integer3 = myArrayList.get(3000);
        Integer integer4 = myArrayList.get(4000);
        Integer integer5 = myArrayList.get(5000);
        Integer integer6 = myArrayList.get(6000);


        now = LocalTime.now();
        myArrayList.contains(integer1);
        after = LocalTime.now();
        System.out.println("The time for find element: = " + LocalTime.of(
                after.getHour() - now.getHour(),
                after.getMinute() - now.getMinute(),
                after.getSecond() - now.getSecond(),
                after.getNano() - now.getNano()
        ));

        now = LocalTime.now();
        myArrayList.contains(integer2);
        after = LocalTime.now();
        System.out.println("The time for find element: = " + LocalTime.of(
                after.getHour() - now.getHour(),
                after.getMinute() - now.getMinute(),
                after.getSecond() - now.getSecond(),
                after.getNano() - now.getNano()
        ));

        now = LocalTime.now();
        myArrayList.contains(integer3);
        after = LocalTime.now();
        System.out.println("The time for find element: = " + LocalTime.of(
                after.getHour() - now.getHour(),
                after.getMinute() - now.getMinute(),
                after.getSecond() - now.getSecond(),
                after.getNano() - now.getNano()
        ));

        now = LocalTime.now();
        myArrayList.contains(integer4);
        after = LocalTime.now();
        System.out.println("The time for find element: = " + LocalTime.of(
                after.getHour() - now.getHour(),
                after.getMinute() - now.getMinute(),
                after.getSecond() - now.getSecond(),
                after.getNano() - now.getNano()
        ));

        now = LocalTime.now();
        myArrayList.contains(integer5);
        after = LocalTime.now();
        System.out.println("The time for find element: = " + LocalTime.of(
                after.getHour() - now.getHour(),
                after.getMinute() - now.getMinute(),
                after.getSecond() - now.getSecond(),
                after.getNano() - now.getNano()
        ));

        now = LocalTime.now();
        myArrayList.contains(integer6);
        after = LocalTime.now();
        System.out.println("The time for find element: = " + LocalTime.of(
                after.getHour() - now.getHour(),
                after.getMinute() - now.getMinute(),
                after.getSecond() - now.getSecond(),
                after.getNano() - now.getNano()
        ));


        System.out.println("Linked List: ");
        Integer o = myLinkedList.get(7000);
        now = LocalTime.now();
        myLinkedList.contains(o);
        after = LocalTime.now();
        System.out.println("The time for find element: = " + LocalTime.of(
                after.getHour() - now.getHour(),
                after.getMinute() - now.getMinute(),
                after.getSecond() - now.getSecond(),
                after.getNano() - now.getNano()
        ));

        Integer o5 = myLinkedList.get(2000);
        now = LocalTime.now();
        myLinkedList.contains(o5);
        after = LocalTime.now();
        System.out.println("The time for find element: = " + LocalTime.of(
                after.getHour() - now.getHour(),
                after.getMinute() - now.getMinute(),
                after.getSecond() - now.getSecond(),
                after.getNano() - now.getNano()
        ));

        Integer o4 = myLinkedList.get(6000);
        now = LocalTime.now();
        myLinkedList.contains(o4);
        after = LocalTime.now();
        System.out.println("The time for find element: = " + LocalTime.of(
                after.getHour() - now.getHour(),
                after.getMinute() - now.getMinute(),
                after.getSecond() - now.getSecond(),
                after.getNano() - now.getNano()
        ));

        Integer o3 = myLinkedList.get(1);
        now = LocalTime.now();
        myLinkedList.contains(o3);
        after = LocalTime.now();
        System.out.println("The time for find element: = " + LocalTime.of(
                after.getHour() - now.getHour(),
                after.getMinute() - now.getMinute(),
                after.getSecond() - now.getSecond(),
                after.getNano() - now.getNano()
        ));

        Integer o2 = myLinkedList.get(200);
        now = LocalTime.now();
        myLinkedList.contains(o2);
        after = LocalTime.now();
        System.out.println("The time for find element: = " + LocalTime.of(
                after.getHour() - now.getHour(),
                after.getMinute() - now.getMinute(),
                after.getSecond() - now.getSecond(),
                after.getNano() - now.getNano()
        ));
        Integer o7 = myLinkedList.get(7900);
        now = LocalTime.now();
        myLinkedList.contains(o7);
        after = LocalTime.now();
        System.out.println("The time for find element: = " + LocalTime.of(
                after.getHour() - now.getHour(),
                after.getMinute() - now.getMinute(),
                after.getSecond() - now.getSecond(),
                after.getNano() - now.getNano()
        ));


        now = LocalTime.now();
        for (int i = 0; i < myArrayList.size(); i++) {
            myArrayList.remove(i);
        }
        after = LocalTime.now();
        System.out.println("The time for ArrayList in deleting elements = " + LocalTime.of(
                after.getHour() - now.getHour(),
                after.getMinute() - now.getMinute(),
                after.getSecond() - now.getSecond(),
                after.getNano() - now.getNano()
        ));


        now = LocalTime.now();
        for (int i = 0; i < myLinkedList.size(); i++) {
            myLinkedList.remove(i);
        }
        after = LocalTime.now();
        System.out.println("The time for LinkedList in deleting elements = " + LocalTime.of(
                after.getHour() - now.getHour(),
                after.getMinute() - now.getMinute(),
                after.getSecond() - now.getSecond(),
                after.getNano() - now.getNano()
        ));


    }

    private static void ex1() {
        Set<String> myHashSet = new HashSet<>();
        Set<String> myTreeSet = new TreeSet<>();

        LocalTime now = LocalTime.now();
        for (int i = 0; i < 1000; i++) {
            myHashSet.add(String.format("str" + i));
        }
        LocalTime after = LocalTime.now();
//        System.out.println("Hashset: " + myHashSet);
//        System.out.println("#################################################" +
//                "######################################################################################");
//        System.out.println("############################" +
//                "###########################################################################################################");
//        System.out.println("#############################" +
//                "##########################################################################################################");
//        System.out.println("############################" +
//                "###########################################################################################################");
//        System.out.println("############################" +
//                "###########################################################################################################");
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
//        System.out.println("#################################################" +
//                "######################################################################################");
//        System.out.println("############################" +
//                "###########################################################################################################");
//        System.out.println("#############################" +
//                "##########################################################################################################");
//        System.out.println("############################" +
//                "###########################################################################################################");
//        System.out.println("############################" +
//                "###########################################################################################################");

        now = LocalTime.now();
        myHashSet.removeIf(word -> !Objects.isNull(word));
        after = LocalTime.now();

        System.out.println("The time for HashSet in deleting elements = " + LocalTime.of(
                after.getHour() - now.getHour(),
                after.getMinute() - now.getMinute(),
                after.getSecond() - now.getSecond(),
                after.getNano() - now.getNano()));
        System.out.println("HashSet after removal: " + myHashSet);


//        System.out.println("#################################################" +
//                "######################################################################################");
//        System.out.println("############################" +
//                "###########################################################################################################");
//        System.out.println("#############################" +
//                "##########################################################################################################");
//        System.out.println("############################" +
//                "###########################################################################################################");
//        System.out.println("############################" +
//                "###########################################################################################################");

        now = LocalTime.now();
        myTreeSet.removeIf(word -> !Objects.isNull(word));
        after = LocalTime.now();

        System.out.println("The time for TreeSet in deleting elements = " + LocalTime.of(
                after.getHour() - now.getHour(),
                after.getMinute() - now.getMinute(),
                after.getSecond() - now.getSecond(),
                after.getNano() - now.getNano()));
        System.out.println("Treeset after removal: " + myTreeSet);


    }
}