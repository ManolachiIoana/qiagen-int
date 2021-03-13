package javaQuestion;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {

    public static char[] convertStringToArray(String s){
        return s.toLowerCase().replaceAll(" ", "").toCharArray();
    }

    public static boolean areAnagrams(String a, String b) {
        char[] aToArray = convertStringToArray(a);
        char[] bToArray = convertStringToArray(b);

        if (aToArray.length != bToArray.length)
            return false;
        else {
            Arrays.sort(aToArray);
            Arrays.sort(bToArray);

            if (Arrays.equals(aToArray, bToArray)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first word: ");
        String a = sc.next();
        System.out.println("Enter second word: ");
        String b = sc.next();

        if (areAnagrams(a, b)) {
            System.out.println("Yes, they are anagrams");
        } else {
            System.out.println("No, they are not anagrams");
        }
    }
}

