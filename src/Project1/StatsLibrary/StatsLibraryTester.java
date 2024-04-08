package Project1.StatsLibrary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class StatsLibraryTester {
    public static void main(String[] args) {

        //test list generation

        Random r = new Random();
        ArrayList<Double> testList = new ArrayList<>();

        testList.add(9.8);
        testList.add(9.7);
        testList.add(9.6);
        testList.add(10.1);
        testList.add(9.9);
        testList.add(9.9);
        testList.add(9.8);
        testList.add(9.7);
        testList.add(9.8);
        testList.add(10.2);

        //stats library object used for all method testing

        StatsLibrary myStatsTest = new StatsLibrary();

        //test mean, median, mode, variance, stdDev methods

        int[] coeffs = {12, 12, 8, 8};
        System.out.println(myStatsTest.calcMultinomialCoefficients(40, coeffs));

/*
        System.out.printf("Mean: %.3f ", myStatsTest.findMean(testList));
        System.out.printf("Median: %.3f ", myStatsTest.findMedian(testList));
        System.out.printf("Mode: %.3f ", myStatsTest.findMode(testList));
        System.out.printf("Variance: %.3f ", myStatsTest.calculateVariance(testList));
        System.out.printf("Standard Deviation: %.3f ", myStatsTest.calcStandardDeviation(testList));*/

        /*
        System.out.println();
        testList.clear();
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                testList.add(2.0);
            } else {
                testList.add(r.nextDouble(1, 10));
            }
        }
        System.out.println("List:");
        for (Double e : testList) {
            System.out.printf("%.3f\n", e);
        }

        //test with a defined mode
        System.out.printf("Mean: %.3f ", myStatsTest.findMean(testList));
        System.out.printf("Median: %.3f ", myStatsTest.findMedian(testList));
        System.out.printf("Mode: %.3f \n", myStatsTest.findMode(testList));
        System.out.printf("Variance: %.3f ", myStatsTest.calculateVariance(testList));
        System.out.printf("Standard Deviation: %.3f ", myStatsTest.calcStandardDeviation(testList));

        */

        //test factorial method

        /*

        int fact = 0;
        System.out.println(fact + " Factorial: " + myStatsTest.calculateFactorial(fact));
        fact = 4;
        System.out.println(fact + " Factorial: " + myStatsTest.calculateFactorial(fact));
        fact = 16;
        System.out.println(fact + " Factorial: " + myStatsTest.calculateFactorial(fact));
        fact = 40;
        System.out.println(fact + " Factorial: " + myStatsTest.calculateFactorial(fact));

        */

        //test combinations and permutations

        int totalElements;
        int choiceNumber;

        /*

        totalElements = 5;
        choiceNumber = 2;

        System.out.println("Permutations of a set of " + totalElements + " elements, choose " +
                choiceNumber + ": " + myStatsTest.findPermutations(totalElements, choiceNumber));
        System.out.println("Combinations of a set of " + totalElements + " elements, choose " +
                choiceNumber + ": " + myStatsTest.findCombinations(totalElements, choiceNumber));

        totalElements = 4;
        choiceNumber =

        System.out.println("Permutations of a set of " + totalElements + " elements, choose " +
                choiceNumber + ": " + myStatsTest.findPermutations(totalElements, choiceNumber));
        System.out.println("Combinations of a set of " + totalElements + " elements, choose " +
                choiceNumber + ": " + myStatsTest.findCombinations(totalElements, choiceNumber));

        totalElements = 41;
        choiceNumber = 5;

        */

        ArrayList<Double> testListTwo = new ArrayList<>();
        testList.clear();

        //randomly generate lists with some duplicate values

        int k = r.nextInt(50);
        for(int i = 1; i < k; i++){
            double d = r.nextDouble(20);
            testList.add(d);
            if(k % i != 0){
                testListTwo.add(d);
            }
        }

        Collections.sort(testList);
        Collections.sort(testListTwo);

        //test intersection, union methods

        /*

        System.out.print("List A: ");
        for(Double d : testList){
            System.out.printf("[%.3f] ", d);
        }
        System.out.print("\nList B: ");
        for(Double d : testListTwo){
            System.out.printf("[%.3f] ", d);
        }
        System.out.print("\nIntersection: ");
        for(Double d : myStatsTest.findIntersection(testList, testListTwo)){
            System.out.printf("[%.3f] ", d);
        }

        System.out.print("\nList A: ");
        for(Double d : testList){
            System.out.printf("[%.3f] ", d);
        }
        System.out.print("\nList B: ");
        for(Double d : testListTwo){
            System.out.printf("[%.3f] ", d);
        }
        System.out.print("\nUnion: ");
        for(Double d : myStatsTest.findUnion(testList, testListTwo)){
            System.out.printf("[%.3f] ", d);
        }

       */

        //test binomial distribution

        double p;
        int trials;
        int successes;

        /*

        p = .8;
        successes = 7;
        System.out.printf("\nThere is a %.4f chance that, in %d trials with a %.2f chance of success, " +
                        "we find %d successes.", myStatsTest.binomialDistribution(trials, successes, p),
                trials, p, successes);

        p = .5;
        trials = 5;
        System.out.printf("\nThere is a %.4f chance that, with a %.2f chance of success, we find a success " +
                "at the %dth trial.", myStatsTest.geometricDistribution(trials, p), p, trials);


         */

        //test geometric distribution

        //test hyper geometric

        //test negative binomial

        //test axioms

        //test Thm Total Prob

        //test Conditional

        //test Bayes

        //test Poisson

        //test Chebychev's
    }
}

