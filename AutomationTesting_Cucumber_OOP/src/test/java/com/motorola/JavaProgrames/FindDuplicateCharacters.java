/*
* Question 1: Given a list with duplicate values, implement a solution to remove duplicate values from this list.
* */

import java.util.Arrays;

public class FindDuplicateCharacters {

    public static void FindDuplicateCharactersInStringArray(String[] stringArray){
        stringArray = Arrays.stream(stringArray).distinct().toArray(String[]::new);
        System.out.println("Array after removing duplicates: "
                + Arrays.toString(stringArray));

    }

    public static void removeDuplicateValue(Integer[] integerArray ){

        integerArray = Arrays.stream(integerArray).distinct().toArray(Integer[]::new);
        System.out.println("Array after removing duplicates: "
                + Arrays.toString(integerArray));

    }

    public static void main(String[] args) {
        String[] stringArray = {"G", "R", "E", "E","K","E"};
        Integer[] integerArray = {1, 2, 1, 3,3,1};
        FindDuplicateCharactersInStringArray(stringArray);
        removeDuplicateValue(integerArray);

    }
}

