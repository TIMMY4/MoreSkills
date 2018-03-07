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
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Ryan.Wanner
 */
public class MoreSkillBuilding {

    private static int max = 1000;
    private static int min = 0;
    private static int numbGuess(int count, boolean higher ){
        if(higher){
            min= count+1;
        }else{
            max= count -1; 
        }
        return (min+max)/2; 
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random rand = new Random();
        Map<Integer,List<Integer>> map= new HashMap<>();
        int r = rand.nextInt(max)+1;
        System.out.println("Pick a number between 1 and 1,000");
        Scanner input= new Scanner(System.in);
        int guess=0;//input.nextInt();
        int guesses=0;
        int time=0;
        int bin=0;
        int first,last;
        do {
            double start = System.currentTimeMillis();
            if (guess < r) {
                System.out.println("Guess higher than " + guess);
                guess=numbGuess(guess, true);
            } else if (guess > r) {
                System.out.println("Guess lower than " + guess);
                guess= numbGuess(guess,false);
            }
            guesses++;
           // guess = input.nextInt();
            double end = System.currentTimeMillis();
            time += (end - start);
            ArrayList <Integer> newList=new ArrayList();
            newList.add(guess);
            bin = (guess - 1) / (100);
            map.put(bin, newList);
        } while (guess != r);
        System.out.println("Correct");
        System.out.println("Number of guesses " + guesses);
        System.out.println("average time in seconds: " + time / (1000 * guesses));


        int max = 0;
        int binMax = Integer.MIN_VALUE;
        int value;
        for (int i = 0; i < 10; i++) {
            System.out.printf("bin " + i + ": ");
            value = map.getOrDefault(i, guestList);
            if (binMax < value) {
                binMax = value;
                max = i;
            }

            for (int j = 0; j < value; j++) {
                System.out.printf("*");
            }
            System.out.println();

        }
        System.out.printf("the bins that are empty are ");
        for (int i = 0; i < 10; i++) {
            value = map.getOrDefault(i, 0);
            if (value == 0) {
                System.out.printf(i + ",");
            }
        }
        System.out.println();
        System.out.println("The bin with the most guesses is " + max);

    }

}
