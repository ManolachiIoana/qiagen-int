package javaQuestion;

import java.util.Scanner;

public class SmallestDistance {

    public static Integer[] readArrayFromKeyboard(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements of the array");
        int numberOfElements = sc.nextInt();
        System.out.println("Enter " + numberOfElements + " elements for your array:");
        Integer array[] = new Integer[numberOfElements];
        for(int i = 0; i < numberOfElements; i ++)
            array[i] = sc.nextInt();
        return array;
    }

    public static int getSmallestDistance(Integer array[]){
        if(array.length < 2)
            return 1;
        else{
            int minDistance = Math.abs(array[1] - array[0]);
            int index = 1;
            for (int i = 2; i < array.length; i ++){
                int localDistance = Math.abs(array[i] - array[i - 1]);
                if(localDistance < minDistance){
                    minDistance = localDistance;
                    index = i - 1;
                }
            }
            return index;
        }
    }

    public static void main(String[] args) {
        Integer array[] = readArrayFromKeyboard();
        System.out.println(getSmallestDistance(array));
    }
}
