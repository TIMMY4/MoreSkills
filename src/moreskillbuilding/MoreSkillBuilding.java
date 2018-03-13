/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moreskillbuilding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.Optional.empty;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Ryan.Wanner
 */
public class MoreSkillBuilding {

    private static int max = 1000;
    private static int min = 0;

    private static int numbGuess(int count, boolean higher) {
        if (higher) {
            min = count + 1;
        } else {
            max = count - 1;
        }
        return (min + max) / 2;
    }

    public static List<Integer> sort(List<Integer> newList) {
        int first;
        int end = 0;
        if (newList == null) {
            empty();
        } else {
            do {

                for (int i = 0; i < newList.size() - 1; i++) {
                    if (newList.get(i) < newList.get(i + 1)) {
                        first = newList.set(i, newList.get(i + 1));
                        newList.set(i + 1, first);

                    }
                    //System.out.println(randomList.get(i));

                }

            } while (end == newList.size());
        }
        return newList;

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random rand = new Random();
        Map<Integer, List<Integer>> map = new HashMap<>();
        ArrayList<Integer> newList = new ArrayList();
        ArrayList<Integer> list1 = new ArrayList();
        ArrayList<Integer> list2 = new ArrayList();
        ArrayList<Integer> list3 = new ArrayList();
        ArrayList<Integer> list4 = new ArrayList();
        ArrayList<Integer> list5 = new ArrayList();
        ArrayList<Integer> list6 = new ArrayList();
        ArrayList<Integer> list7 = new ArrayList();
        ArrayList<Integer> list8 = new ArrayList();
        ArrayList<Integer> list9 = new ArrayList();
        ArrayList<Integer> list10 = new ArrayList();
        int r = rand.nextInt(max) + 1;
        System.out.println("Pick a number between 1 and 1,000");
        Scanner input = new Scanner(System.in);
        int guess = 0;//input.nextInt();
        int guesses = 1;
        int time = 0;
        int bin = 0;
        do {
            double start = System.currentTimeMillis();
            if (guess < r) {
                System.out.println("Guess higher than " + guess);
                guess = numbGuess(guess, true);
            } else if (guess > r) {
                System.out.println("Guess lower than " + guess);
                guess = numbGuess(guess, false);
            }
            guesses++;
            //guess = input.nextInt();
            double end = System.currentTimeMillis();
            time += (end - start);
            bin = (guess - 1) / (100);
            switch (bin) {
                case 0:
                    list1.add(guess);
                    newList.add(guess);
                    map.put(bin, list1);
                    newList.add(guess);
                    break;
                case 1:

                    list2.add(guess);
                    newList.add(guess);
                    map.put(bin, list2);
                    newList.add(guess);
                    break;
                case 2:

                    list3.add(guess);
                    newList.add(guess);
                    map.put(bin, list3);
                    newList.add(guess);
                    break;
                case 3:

                    list4.add(guess);
                    newList.add(guess);
                    map.put(bin, list4);
                    newList.add(guess);
                    break;
                case 4:

                    list5.add(guess);
                    newList.add(guess);
                    map.put(bin, list5);
                    newList.add(guess);
                    break;
                case 5:

                    list6.add(guess);
                    newList.add(guess);
                    map.put(bin, list6);
                    newList.add(guess);
                    break;
                case 6:

                    list7.add(guess);
                    newList.add(guess);
                    map.put(bin, list7);
                    newList.add(guess);
                    break;
                case 7:

                    list8.add(guess);
                    newList.add(guess);
                    map.put(bin, list8);
                    newList.add(guess);
                    break;
                case 8:

                    list9.add(guess);
                    newList.add(guess);
                    map.put(bin, list9);
                    newList.add(guess);
                    break;
                case 9:
                    list10.add(guess);
                    newList.add(guess);
                    map.put(bin, list10);
                    newList.add(guess);
                    break;
            }

        } while (guess != r);
        switch (bin) {
            case 0:

                list1.add(guess);
                newList.add(guess);
                map.put(bin, list1);
                newList.add(guess);
                break;
            case 1:

                list2.add(guess);
                newList.add(guess);
                map.put(bin, list2);
                newList.add(guess);
                break;
            case 2:

                list3.add(guess);
                newList.add(guess);
                map.put(bin, list3);
                newList.add(guess);
                break;
            case 3:

                list4.add(guess);
                newList.add(guess);
                map.put(bin, list4);
                newList.add(guess);
                break;
            case 4:

                list5.add(guess);
                newList.add(guess);
                map.put(bin, list5);
                break;
            case 5:

                list6.add(guess);
                newList.add(guess);
                map.put(bin, list6);
                newList.add(guess);
                break;
            case 6:

                list7.add(guess);
                newList.add(guess);
                map.put(bin, list7);
                newList.add(guess);
                break;
            case 7:

                list8.add(guess);
                newList.add(guess);
                map.put(bin, list8);
                newList.add(guess);
                break;
            case 8:

                list9.add(guess);
                newList.add(guess);
                map.put(bin, list9);
                newList.add(guess);
                break;
            case 9:
                list10.add(guess);
                newList.add(guess);
                map.put(bin, list10);
                newList.add(guess);
                break;
        }
        System.out.println("Correct");
        System.out.println("Number of guesses " + guesses);
        System.out.println("average time in seconds: " + time / (1000 * guesses));

//makes the histogram
        int max = 0;
        int binMax = Integer.MIN_VALUE;
        int value;
        for (int i = 0; i < 10; i++) {
            System.out.printf("bin " + i + ": ");
            value = map.getOrDefault(i, new ArrayList()).size();
            if (binMax < value) {
                binMax = value;
                max = i;
            }
            if (map.get(i) != null) {
                for (int j = 0; j < map.get(i).size(); j++) {
                    System.out.printf("*");
                }
            }
            System.out.println();

        }
        System.out.printf("the bins that are empty are ");
        for (int i = 0; i < 10; i++) {
            value = map.getOrDefault(i, new ArrayList()).size();
            if (value == 0) {
                System.out.printf(i + ",");
            }
        }
        System.out.println();
        System.out.println("The bin with the most guesses is " + max);
        for (int i = 0; i < 10; i++) {
            sort(map.get(i));
            if (map.get(i) != null) {
                System.out.println(map.get(i));
            }
        }
        int x = 0;
        double avg = 0;
                for(int i=0; i<newList.size(); i++){
                    x+= newList.get(i);
                }
                avg= x/(newList.size());
                System.out.println("The average is: "+avg);
            
        
        //gets average 
        int sum = 0;
        int totalLength = 0;
        for (int i = 0; i < 10; i++) {

            if (map.get(i) == null) {
                continue;
            }

            for (int j = 0; j < map.get(i).size(); j++) {
                sum += map.get(i).get(j);

            }
            totalLength += map.get(i).size();
        }
        avg = ((double) sum) / totalLength;
        System.out.println("The average guess: " + avg);

    }

}
