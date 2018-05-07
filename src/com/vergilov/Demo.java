package com.vergilov;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Demo {
    public static void main(String[] args) {
        LinkedList<String> placeToVisit = new LinkedList<>();
        addInOrder(placeToVisit, "Sydney");
        addInOrder(placeToVisit, "Warsaw");
        addInOrder(placeToVisit, "Krakow");
        addInOrder(placeToVisit, "Przemysl");
        addInOrder(placeToVisit, "Olsztyn");
        addInOrder(placeToVisit, "Drawin");
        printList(placeToVisit);

        addInOrder(placeToVisit,"Lodz");
        addInOrder(placeToVisit,"Darwin");
        printList(placeToVisit);

    }

    private static void printList(LinkedList<String> linkedList) {
        Iterator<String> i = linkedList.iterator();
        while (i.hasNext()) {
            System.out.println("Now Visiting: " + i.next());
        }
        System.out.println("++++++++++++++++++++++++++++");
    }

    private static boolean addInOrder(LinkedList<String> linkedList, String newCtiy) {
        ListIterator<String> stringListIterator = linkedList.listIterator();

        while (stringListIterator.hasNext()) {
            int comparison = stringListIterator.next().compareTo(newCtiy);
            if (comparison == 0) {
                //Equal, dont add
                System.out.println(newCtiy + " is already included as a destination");
                return false;
            } else if (comparison > 0) {
                //new city SDhould apopear before this one
                stringListIterator.previous();
                stringListIterator.add(newCtiy);

                return true;
            } else if (comparison < 0) {
                //move to next city
            }
        }
        stringListIterator.add(newCtiy);
        return true;
    }
}
