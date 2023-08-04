package dev.leaning;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    //    Creating static method
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean flag = true;
        ArrayList<String> groceries = new ArrayList<>();

        while (flag) {
            printAction();
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1 -> addItems(groceries);
                case 2 -> removeItems(groceries);
                default -> flag = false;
            }
            groceries.sort(Comparator.naturalOrder());
            System.out.println(groceries);
        }
    }
    /*Add items*/

    private static void addItems(ArrayList<String> groceries) {
        System.out.println("Add item(s) [seperate items by comma]:");
        String[] items = scanner.nextLine().split(",");
//        groceries.addAll(List.of(items));

//        Avoid duplicate
        for (String i : items) {
            String trimmed = i.trim();
            if (groceries.indexOf(trimmed) < 0) {
                groceries.add(trimmed);
            }
        }
    }


    private static void removeItems(ArrayList<String> groceries) {
        System.out.println("Remove item(s) [seperate items by comma]:");
        String[] items = scanner.nextLine().split(",");

//        Avoid duplicate
        for (String i : items) {
            String trimmed = i.trim();
            groceries.remove(trimmed);

        }
    }

    //    create method for displaying menu options
    private static void printAction() {
        String textBlock = """
                Available actions:
                               
                0 - to shutdown
                               
                1 - to add item(s) to list (comma delimited list)
                               
                2 - to remove any items (comma delimited list)
                               
                Enter a number for which action you want to do:""";
        System.out.println(textBlock + " ");
    }
}
