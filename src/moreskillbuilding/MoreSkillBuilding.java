/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moreskillbuilding;

import java.util.ArrayList;
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
        int r = rand.nextInt(max) + 1;
        System.out.println("Pick a number between 1 and 1,000");
        Scanner input = new Scanner(System.in);
        int guess =0;// input.nextInt();
        int guesses = 1;
        int time = 0;
        int bin = 0;
        List<Integer> newList = map.getOrDefault(guess/100, new ArrayList());
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
          List<Integer> otherList=map.getOrDefault(bin, new ArrayList());
           newList.add(guess);
           otherList.add(guess);
           map.put(bin, otherList);

        } while (guess != r);
        sort(newList);
       
        
        

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
        for (int i = 0; i < newList.size(); i++) {
            x += newList.get(i);
        }
        avg = x / (newList.size());
        System.out.println("The average is: " + avg);

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
