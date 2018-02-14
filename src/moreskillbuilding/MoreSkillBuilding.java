/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moreskillbuilding;

import java.util.*;

/**
 *
 * @author Ryan.Wanner
 */
public class MoreSkillBuilding {

    private static int max = 1000000;
    private static int min = 0;

    private static int nextGuess(int current, boolean higher) {
        if (higher) {
            min = current + 1;
        } else {
            max = current - 1;
        }
        return (min + max) / 2;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random rand = new Random();
        int r = rand.nextInt(max);
        System.out.println("Pick a number between 1 and 1,000,000");
        //Scanner input= new Scanner(System.in);
        //int guess= input.nextInt();
        int guess = max / 2;
        int guesses = 0;
        do {
            if (guess < r) {
                System.out.println("Guess higher than " + guess);
                guess = nextGuess(guess, true);
                } else if (guess > r) {
                System.out.println("Guess lower than " + guess);
                guess = nextGuess(guess, false);
                
            }
            guesses++;
            // guess=input.nextInt();
        } while (guess != r);
        System.out.println("Correct in " + guesses +" guesses!");
        System.out.println(guess);
        
    }

}
